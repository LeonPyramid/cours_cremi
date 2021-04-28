package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeTIMESAFF extends StreeOpeAff {

	public StreeTIMESAFF(Stree left, Stree right) throws TypeException, StreeException {
		super(left, right, new StreeTIMES(left,right));
	}

}
