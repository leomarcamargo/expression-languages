package br.ufpe.cin.lps.elp.base.mixins;

import br.ufpe.cin.lps.elp.base.expression.AddExp;
import br.ufpe.cin.lps.elp.base.expression.Value;
import br.ufpe.cin.lps.elp.base.expression.DoubleValue;

public cclass DoubleAddExp extends AddExp{
	
	public Value evaluate() {

		return new DoubleValue(((DoubleValue) getLeft().evaluate()).value()
				+ ((DoubleValue) getRight().evaluate()).value());
	}

}
