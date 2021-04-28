package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeDIVAFF extends StreeOpeAff {

	public StreeDIVAFF(Stree left, Stree right) throws TypeException, StreeException {
		super(left, right, new StreeDIV(left,right));
	}

}
