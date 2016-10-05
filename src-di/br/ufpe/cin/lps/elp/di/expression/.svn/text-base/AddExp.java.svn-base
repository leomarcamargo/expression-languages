package br.ufpe.cin.lps.elp.di.expression;

import br.ufpe.cin.lps.elp.di.expression.BinaryExp;
import br.ufpe.cin.lps.elp.di.expression.DoubleValue;
import br.ufpe.cin.lps.elp.di.expression.Expression;
import br.ufpe.cin.lps.elp.di.expression.IntegerValue;
import br.ufpe.cin.lps.elp.di.expression.Value;

public class AddExp extends BinaryExp {

	public AddExp(Expression esq, Expression dir) {
		super(esq, dir, "+");
	}

	public Value evaluate() {
		Value leftValue = getLeft().evaluate();
		Value rightValue = getRight().evaluate();
		//Ponto de variação
		if (leftValue instanceof DoubleValue)
			return new DoubleValue(((DoubleValue) leftValue).value()
					+ ((DoubleValue) rightValue).value());
		else
			return new IntegerValue(((IntegerValue) leftValue).value()
					+ ((IntegerValue) rightValue).value());
	}
	
}
