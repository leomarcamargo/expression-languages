package br.ufpe.cin.lps.elp.base.expression;

public class SubExp<V extends Type<V>> extends BinaryExp<V> {

	public SubExp(Expression<V> esq, Expression<V> dir) {
		super(esq, dir, "-");
	}

	public V evaluate() {
		return getLeft().evaluate().minus(getRight().evaluate());
	}

}
