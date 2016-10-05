package br.ufpe.cin.lps.elp.base.aspects;

import br.ufpe.cin.lps.elp.base.expression.*;

public aspect DivDoubleTypeAspect extends DoubleTypeAspect{
	
	pointcut expType(Expression e) :  if(e instanceof DivisionExp) && target(e);	
	 
	DoubleValue around(Expression e) : callEval(e){
		DivisionExp ae = (DivisionExp)e;
		return new DoubleValue(
				((DoubleValue)ae.getLeft().evaluate()).value() /
				( (DoubleValue)ae.getRight().evaluate()).value() );
	}

}