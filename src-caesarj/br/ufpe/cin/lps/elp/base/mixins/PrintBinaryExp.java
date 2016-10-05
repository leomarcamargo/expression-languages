package br.ufpe.cin.lps.elp.base.mixins;

import br.ufpe.cin.lps.elp.base.expression.BinaryExp;

public abstract cclass PrintBinaryExp extends BinaryExp  implements PrintExpression{

	public void print() {
		PrintExpression lPe = (PrintExpression)getLeft();
		lPe.print();
		System.out.print(" "+getOperator()+" ");
		PrintExpression rPe = (PrintExpression)getRight();
		rPe.print(); 
		
	}


}
