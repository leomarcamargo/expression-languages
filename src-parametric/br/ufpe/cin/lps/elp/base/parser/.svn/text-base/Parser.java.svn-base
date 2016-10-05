package br.ufpe.cin.lps.elp.base.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.Vector;

import br.ufpe.cin.lps.elp.base.Program;
import br.ufpe.cin.lps.elp.base.expression.AddExp;
import br.ufpe.cin.lps.elp.base.expression.BinaryExp;
import br.ufpe.cin.lps.elp.base.expression.DivisionExp;
import br.ufpe.cin.lps.elp.base.expression.DoubleType;
import br.ufpe.cin.lps.elp.base.expression.Expression;
import br.ufpe.cin.lps.elp.base.expression.IntegerType;
import br.ufpe.cin.lps.elp.base.expression.MultExp;
import br.ufpe.cin.lps.elp.base.expression.SubExp;
import br.ufpe.cin.lps.elp.base.expression.Type;

class Parser<V extends Type<V>> {

	private static String propertiesFile = "testes/pt-br.properties";

	private String parseExpression;

	private Vector<Object> exp = new Vector<Object>();

	private V type;

	public static void main(String args[]) {
		//Variation Point: Selection of app's current type (Integer or Double)
		
		//Variation 1: Double
		new Parser<DoubleType>(new DoubleType()).start(args);
		
		//Variation 2: Integer
		//new Parser<IntegerType>(new IntegerType()).start(args);
	}
	
	public void start(String args[]) {
		Properties langProperties = new Properties();
		InputStream is = null;
		try {
			langProperties.load(new FileInputStream(propertiesFile));
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.println(langProperties.getProperty("saudation"));
		if (args.length == 0) {
			System.out.println(langProperties.getProperty("standardInput"));
			is = System.in;
		} else if (args.length == 1) {
			System.out.println(langProperties.getProperty("fileInput")
					+ args[0]);
			try {
				is = new java.io.FileInputStream(args[0]);
			} catch (java.io.FileNotFoundException e) {
				System.out
						.println(langProperties.getProperty("fileNotFound1")
								+ args[0]
								+ langProperties.getProperty("fileNotFound2"));
				return;
			}
		} else {
			System.out.println(langProperties.getProperty("correctUse"));
			return;
		}
		try {
			Program<V> programa = input(is);
			System.out.println(langProperties.getProperty("validExpression"));
			System.out.print(langProperties.getProperty("result"));
			programa.executar();

		} catch (ParseException e) {
			System.out.println(langProperties.getProperty("invalidExpression"));
		}
	}

	public Parser(V type) {
		this.type = type;
	}

	public Program<V> input(InputStream is) throws ParseException {
		parseExpression = new Scanner(is).nextLine();
		try {
			String expressao = "";
			// Removing all white spaces...
			for (String token : parseExpression.split(" "))
				expressao += token;

			// Put the Values (Expressions) and the operators (Strings) in the
			// Vector
			int i = 0;
			while (i < expressao.length()) {
				char atual = expressao.charAt(i);
				switch (atual) {
				case '+':
					break;
				case '-':
					break;
				case '*':
					break;
				case '/':
					break;
				default:
					// Values
					int end = getNumberLength(expressao, i);
					addValue(expressao.substring(i, end));
					i += end - i;
					continue;
				}
				// Operators
				exp.add(expressao.substring(i, i + 1));
				i += 1;
			}
			/*
			 * Replacing the operators (chars) * and / (and their correspondent
			 * operands) in the vectors for instances of MultExp and DivExp
			 * classes (multiplication and division). This step is necessary to
			 * guarantee the precedence of these operations over addition and
			 * subtraction.
			 */
			/*
			 * Trocando no Vector as multiplicacoes e divisoes por Expressoes
			 * (para fazer valer a precedencia dessas operacoes) Note que nos
			 * dois primeiros casos não precisamos atualizar o valor do index i,
			 * pois estamos diminuindo o vetor.
			 */
			i = 0;
			while (i < exp.size()) {
				Object o = exp.elementAt(i);
				// Variation point - Multiplication
				if (o.toString().equals("*")) {
					createExpression(exp, exp.indexOf(o), new MultExp<V>(null,
							null));
					continue;
				}
				// Variation point - Division
				if (o.toString().equals("/")) {
					createExpression(exp, exp.indexOf(o), new DivisionExp<V>(
							null, null));
					continue;
				}
				i++;
			}
			Expression<V> e = (Expression<V>) exp.elementAt(0);
			// Constructing the tree of Expressions
			for (i = 0; i < exp.size(); i++) {
				if (exp.elementAt(i) instanceof String) {
					String s = (String) exp.elementAt(i);
					if (s.equals("+")) {
						e = new AddExp<V>(e, (Expression<V>) exp
								.elementAt(i + 1));
					} else if (s.equals("-")) {
						e = new SubExp<V>(e, (Expression<V>) exp
								.elementAt(i + 1));
					}
				}
			}
			return new Program<V>(e);
		} catch (Exception e) {
			throw new ParseException(e.getMessage());
		}
	}

	public int getNumberLength(String s, int index) {
		for (int i = index; i < s.length(); i++) {
			if ((s.charAt(i) == '+') || (s.charAt(i) == '-')
					|| (s.charAt(i) == '*') || (s.charAt(i) == '/'))
				return i;
		}
		return s.length();
	}

	public void addValue(String value) {
		exp.add(type.getInstance(value));
	}

	private void createExpression(Vector<Object> v, int index,
			BinaryExp<V> binExpression) {
		Object oAnt = v.get(index - 1);
		Object oProx = v.get(index + 1);
		binExpression.setLeft((Expression<V>) oAnt);
		binExpression.setRight((Expression<V>) oProx);

		v.remove(index - 1);
		v.remove(index - 1);
		v.remove(index - 1);
		v.add(index - 1, binExpression);
	}
}
