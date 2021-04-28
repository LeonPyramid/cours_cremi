package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeBORAFF extends StreeOpeAff {

	public StreeBORAFF(Stree left, Stree right) throws TypeException, StreeException {
		super(left, right, new StreeOR(left,right));
	}

}
