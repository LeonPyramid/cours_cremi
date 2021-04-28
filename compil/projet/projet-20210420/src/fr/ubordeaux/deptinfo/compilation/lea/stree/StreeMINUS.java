package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.intermediate.BINOP;
import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeMINUS extends StreeOperator {

	public StreeMINUS(Stree left, Stree right) throws StreeException, TypeException {
		super(left, right, BINOP.Code.MINUS);
	}

	public StreeMINUS(Stree left) throws StreeException, TypeException {
		super(left,BINOP.Code.MINUS);
	}
}
