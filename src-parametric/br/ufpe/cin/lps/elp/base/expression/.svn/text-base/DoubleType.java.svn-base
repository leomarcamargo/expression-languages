package br.ufpe.cin.lps.elp.base.expression;

public class DoubleType implements Type<DoubleType>, Expression<DoubleType> {

	private double value;
	
	public DoubleType() {};
	
	public DoubleType(double value) {
		this.value = value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}
	
	public DoubleType add(DoubleType dt) {
		this.value += dt.getValue();
		return this;
	}
	
	public DoubleType minus(DoubleType dt) {
		this.value -= dt.getValue();
		return this;
	}
	
	public DoubleType times(DoubleType dt) {
		this.value *= dt.getValue();
		return this;
	}
	
	public DoubleType div(DoubleType dt) {
		this.value /= dt.getValue();
		return this;
	}

	public String getString() {
		return String.valueOf(value);
	}

	public DoubleType evaluate() {
		return this;
	}

	public DoubleType getInstance(String s) {
		return new DoubleType(Double.parseDouble(s));
	}
}
