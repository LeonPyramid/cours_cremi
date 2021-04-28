package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeRSHIFTAFF extends StreeOpeAff {

	public StreeRSHIFTAFF(Stree left, Stree right) throws TypeException, StreeException {
		super(left, right, new StreeRSHIFT(left,right));
	}

}
