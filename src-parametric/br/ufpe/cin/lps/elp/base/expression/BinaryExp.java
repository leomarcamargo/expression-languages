package br.ufpe.cin.lps.elp.base.expression;

public abstract class BinaryExp<V extends Type<V>> implements Expression<V> {

	private V type;
	
	private Expression<V> left;

	private Expression<V> right;

	private String operator;

	public V getType() {
		return type;
	}
	
	public BinaryExp(Expression<V> left, Expression<V> right, String operator) {
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

	public Expression<V> getLeft() {
		return left;
	}

	public Expression<V> getRight() {
		return right;
	}

	public String getOperator() {
		return operator;
	}
	
	public void setLeft(Expression<V> left) {
		this.left = left;
	}

	public void setRight(Expression<V> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", left, operator, right);
	}

}
