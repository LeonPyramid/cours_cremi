package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeANDAFF extends StreeOpeAff {

	public StreeANDAFF(Stree left, Stree right) throws TypeException, StreeException {
		super(left, right, new StreeAND(left,right));
	}

}
