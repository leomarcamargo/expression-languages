package br.ufpe.cin.lps.elp.base;

import br.ufpe.cin.lps.elp.base.expression.Expression;
import br.ufpe.cin.lps.elp.base.expression.Type;

public class Program<V extends Type<V>> {

	private Expression<V> exp;

	public V executar() {
		V result = exp.evaluate();
		System.out.println(result.getString());
		return result;		
 	}

	public Program(Expression<V> exp){
		this.exp = exp;
	}

	public Expression<V> getExpressao() {
		return exp;
	}
}
