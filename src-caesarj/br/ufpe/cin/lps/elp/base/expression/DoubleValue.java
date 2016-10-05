package br.ufpe.cin.lps.elp.base.expression;


public cclass DoubleValue implements Value{

	private double value;

	public DoubleValue(double value) {
		this.value = value;
	}

	public double value() {
		return value;
	}

	public Value evaluate() {
		return this;
	}
	
	public String toString() {
		return String.valueOf(value);
	}

}
