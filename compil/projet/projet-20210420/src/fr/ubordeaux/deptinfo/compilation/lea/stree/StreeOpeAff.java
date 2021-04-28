package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.intermediate.MOVE;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.Stm;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.BINOP.Code;
import fr.ubordeaux.deptinfo.compilation.lea.type.Type;
import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public abstract class StreeOpeAff extends Stree{

	private Stm stm;

	public StreeOpeAff(Stree left, Stree right, StreeOperator StreeOp) throws StreeException, TypeException {
		super(left, right);
		this.stm = new MOVE(left.getExp().copy(), StreeOp.getExp());
	}

	@Override
	public Stm getStm(){
		return stm;
	}

	@Override
	public boolean checkType() throws StreeException {
		Type typeLeft = this.getLeft().getType();
		Type typeRight = this.getRight().getType();
		if ((typeLeft != null) && (typeRight != null))
			return typeLeft.assertEqual(typeRight);
		else
			throw new StreeException("Type error while checking null types !");

	}

    
}
