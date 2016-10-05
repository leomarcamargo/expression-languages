package br.ufpe.cin.lps.elp.base.aspects;

import br.ufpe.cin.lps.elp.base.Program;
import br.ufpe.cin.lps.elp.base.expression.*;

public privileged aspect PrintAspect {
	
	
	public void Expression.print(){}
	
	
	public void Value.print(){
		System.out.print(value);
		
	}
	
	public void BinaryExp.print(){
		left.print();
		System.out.print(" "+operator+" ");
		right.print();
		
	}
	
	pointcut programExecution(Program p) : call(public Value Program.executar(..)) && target(p);
	
	before(Program p) : programExecution(p) {
		p.exp.print();
		System.out.print(" = ");
	}
	

}
