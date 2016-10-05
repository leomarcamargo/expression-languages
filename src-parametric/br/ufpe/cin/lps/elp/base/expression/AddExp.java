package br.ufpe.cin.lps.elp.base.expression;

//Mecanismo de instanciação no parser
public class AddExp<V extends Type<V>> extends BinaryExp<V> {

	public AddExp(Expression<V> esq, Expression<V> dir) {
		super(esq, dir, "+");
	}

	public V evaluate() {
		V left, right;
		left = getLeft().evaluate();
		right = getRight().evaluate();
		
		return right.add(left);//getLeft().evaluate().add(getRight().evaluate());
	}
}
