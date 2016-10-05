package br.ufpe.cin.lps.elp.base.aspects;

import br.ufpe.cin.lps.elp.base.expression.*;

public aspect MulDoubleTypeAspect extends DoubleTypeAspect{
	
	pointcut expType(Expression e) :  if(e instanceof MultExp) && target(e);

	DoubleValue around(Expression e) : callEval(e){
		MultExp ae = (MultExp)e;
		return new DoubleValue(
				((DoubleValue)ae.getLeft().evaluate()).value() *
				( (DoubleValue)ae.getRight().evaluate()).value() );
	}



	
}
