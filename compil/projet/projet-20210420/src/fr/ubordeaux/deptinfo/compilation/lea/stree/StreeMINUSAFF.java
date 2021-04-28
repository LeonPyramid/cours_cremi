package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeMINUSAFF extends StreeOpeAff {

	public StreeMINUSAFF(Stree left, Stree right) throws TypeException, StreeException {
		super(left, right, new StreeMINUS(left,right));
	}

}
