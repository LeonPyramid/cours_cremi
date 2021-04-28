package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.intermediate.BINOP;
import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeLSHIFT extends StreeOperator {

	public StreeLSHIFT(Stree left, Stree right) throws StreeException, TypeException {
		super(left, right, BINOP.Code.LSHIFT);
	}
}
