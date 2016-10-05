package br.ufpe.cin.lps.elp.base.expression;

//Mecanismo de instanciação no parser
public cclass AddExp extends BinaryExp {
	
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
