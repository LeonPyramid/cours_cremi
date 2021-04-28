package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.intermediate.BINOP;
import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeRSHIFT extends StreeOperator {

	public StreeRSHIFT(Stree left, Stree right) throws StreeException, TypeException {
		super(left, right, BINOP.Code.RSHIFT);
	}
}
