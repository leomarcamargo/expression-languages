package br.ufpe.cin.lps.elp.base.expression;

public class MultExp extends BinaryExp {

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
	public MultExp(Expression esq, Expression dir) {
		super(esq, dir, "*");
	}

	/**
	 * Retorna o valor da Expressao de Soma
	 */
	public Value evaluate() {
		Value leftValue = getLeft().evaluate();
		Value rightValue = getRight().evaluate();
		//Ponto de variação
		if (leftValue instanceof DoubleValue)
			return new DoubleValue(((DoubleValue) leftValue).value()
					* ((DoubleValue) rightValue).value());
		else
			return new IntegerValue(((IntegerValue) leftValue).value()
					* ((IntegerValue) rightValue).value());
	}
	
}
