package br.ufpe.cin.lps.elp.base.expression;

public class DivisionExp extends BinaryExp {

	public DivisionExp(Expression esq, Expression dir) {
		super(esq, dir, "/");
	}

	public Value evaluate() {
		Value leftValue = getLeft().evaluate();
		Value rightValue = getRight().evaluate();
		// Ponto de variação
		if (leftValue instanceof DoubleValue)
			return new DoubleValue(((DoubleValue) leftValue).value()
					/ ((DoubleValue) rightValue).value());
		else
			return new IntegerValue(((IntegerValue) leftValue).value()
					/ ((IntegerValue) rightValue).value());
	}

}
