package br.ufpe.cin.lps.elp.di.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.Vector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import br.ufpe.cin.lps.elp.di.Program;
import br.ufpe.cin.lps.elp.di.expression.AddExp;
import br.ufpe.cin.lps.elp.di.expression.BinaryExp;
import br.ufpe.cin.lps.elp.di.expression.DivisionExp;
import br.ufpe.cin.lps.elp.di.expression.DoubleValue;
import br.ufpe.cin.lps.elp.di.expression.Expression;
import br.ufpe.cin.lps.elp.di.expression.MultExp;
import br.ufpe.cin.lps.elp.di.expression.SubExp;
import br.ufpe.cin.lps.elp.di.language2.MessagesBean2;

class Parser2 {

	private static String propertiesFile;

	private String parseExpression;

	private Vector<Object> exp = new Vector<Object>();

	public static void main(String args[]) {
		Parser2 parser2 = null;
		
		ApplicationContext context = new FileSystemXmlApplicationContext("language2.xml");
		MessagesBean2 languageBean2 = (MessagesBean2) context.getBean("MessagesBean2");
		propertiesFile = languageBean2.getPropertiesFile();
		
		Properties langProperties = new Properties();
		try {
			langProperties.load(new FileInputStream(propertiesFile));
		} catch (IOException ioe) {
		}
		
		System.out.println(langProperties.getProperty("saudation"));

		if (args.length == 0) {
			System.out.println(langProperties.getProperty("standardInput"));
			parser2 = new Parser2(System.in);
		} else if (args.length == 1) {
			System.out.println(langProperties.getProperty("fileInput")
					+ args[0]);
			try {
				parser2 = new Parser2(new java.io.FileInputStream(args[0]));
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
			Program programa = parser2.input();
			System.out.println(langProperties.getProperty("validExpression"));
			System.out.print(langProperties.getProperty("result"));
			programa.executar();

		} catch (ParseException e) {
			System.out.println(langProperties.getProperty("invalidExpression"));
		}
	}

	public Parser2(InputStream is) {
		Scanner s = new Scanner(is);
		parseExpression = s.nextLine();
	}

	public Program input() throws ParseException {
		try {
			String expressao = "";
			// Removing all white spaces...
			for (String token : parseExpression.split(" "))
				expressao += token;

			// Put the Values (Expressions) and the operators (Strings) in the Vector
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
			 * classes (multiplication and division). This step is necessary
			 * to guarantee the precedence of these operations over addition and
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
				//Variation point - Multiplication
				if (o.toString().equals("*")) {
					createExpression(exp, exp.indexOf(o), new MultExp(null,
							null));
					continue;
				}
				//Variation point - Division
				if (o.toString().equals("/")) {
					createExpression(exp, exp.indexOf(o),
							new DivisionExp(null, null));
					continue;
				}
				i++;
			}
			Expression e = (Expression) exp.elementAt(0);
			//Constructing the tree of Expressions
			for (i = 0; i < exp.size(); i++) {
				if (exp.elementAt(i) instanceof String) {
					String s = (String) exp.elementAt(i);
					if (s.equals("+"))
						e = new AddExp(e, (Expression) exp.elementAt(i + 1));
					else if (s.equals("-"))
						e = new SubExp(e, (Expression) exp.elementAt(i + 1));
				}
			}
			return new Program(e);
		} catch (Exception e) {
			throw new ParseException(e.getMessage());
		}
	}

	public int getNumberLength(String s, int index) {
		int end = -1;
		for (int i = index; i < s.length(); i++) {
			if ((s.charAt(i) == '+') || (s.charAt(i) == '-')
					|| (s.charAt(i) == '*') || (s.charAt(i) == '/'))
				return i;
		}
		return s.length();
	}

	// Variation points - Integer / Double values
	public void addValue(String value) {
		// exp.add(new ValorInteiro(Integer.parseInt(value)));
		exp.add(new DoubleValue(Double.parseDouble(value)));
	}

	private void createExpression(Vector<Object> v, int index,
			BinaryExp binExpression) {
		Object oAnt = v.get(index - 1);
		Object oProx = v.get(index + 1);
		binExpression.setLeft((Expression) oAnt);
		binExpression.setRight((Expression) oProx);
		
		v.remove(index - 1);
		v.remove(index - 1);
		v.remove(index - 1);
		v.add(index - 1, binExpression);
	}

	class ParseException extends Exception {
		
		private static final long serialVersionUID = 1L;

		public ParseException(String message) {
			super(message);
		}
	}
}
