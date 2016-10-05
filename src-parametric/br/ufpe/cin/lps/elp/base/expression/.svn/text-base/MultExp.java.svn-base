package br.ufpe.cin.lps.elp.base.expression;

public class MultExp<V extends Type<V>> extends BinaryExp<V> {

	/**
	 * Controi uma Expressao de Soma com as sub-expressoes especificadas.
	 * Assume-se que estas sub-expressoes resultam em <code>ValorInteiro</code>
	 * quando avaliadas.
	 * 
	 * @param esq
	 *            Expressao da esquerda
	 * @param dir
	 *            Expressao da direita
	 */
	public MultExp(Expression<V> esq, Expression<V> dir) {
		super(esq, dir, "*");
	}

	public V evaluate() {
		return getLeft().evaluate().times(getRight().evaluate());
	}
	
}
