package br.ufpe.cin.lps.elp.base.expression;

public class DivisionExp<V extends Type<V>> extends BinaryExp<V> {

	public DivisionExp(Expression<V> esq, Expression<V> dir) {
		super(esq, dir, "/");
	}

	public V evaluate() {
		return getLeft().evaluate().div(getRight().evaluate());
	}

}
