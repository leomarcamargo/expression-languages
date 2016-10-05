package br.ufpe.cin.lps.elp.base.mixins;

import br.ufpe.cin.lps.elp.base.expression.*;

public cclass PrintIntegerValue extends IntegerValue implements PrintExpression{
	
	public void print(){ 
		System.out.print(value());
	}
	

}
 
