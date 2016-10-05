package br.ufpe.cin.lps.elp.base.expression;

public class IntegerType implements Type<IntegerType>, Expression<IntegerType> {
	
	private int value;
	
	public IntegerType() { }
	
	public IntegerType(int value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public IntegerType add(IntegerType it) {
		this.value += it.getValue();
		return this;
	}
	
	public IntegerType minus(IntegerType it) {
		this.value -= it.getValue();
		return this;
	}
	
	public IntegerType times(IntegerType it) {
		this.value *= it.getValue();
		return this;
	}
	
	public IntegerType div(IntegerType it) {
		this.value /= it.getValue();
		return this;
	}
	
	public String getString() {
		return String.valueOf(value);
	}

	public IntegerType evaluate() {
		// TODO Auto-generated method stub
		return this;
	}

	public IntegerType getInstance(String s) {
		return new IntegerType(Integer.parseInt(s));
	}
}
