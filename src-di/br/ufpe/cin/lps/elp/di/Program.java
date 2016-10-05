package br.ufpe.cin.lps.elp.di;

import br.ufpe.cin.lps.elp.di.expression.Expression;
import br.ufpe.cin.lps.elp.di.expression.Value;

public class Program {

	private Expression exp;

	public Value executar() {
		Value result = exp.evaluate();
		System.out.println(result);
		return result;		
 	}

	public Program(Expression exp){
		this.exp = exp;
	}

	public Expression getExpressao() {
		return exp;
	}
}
