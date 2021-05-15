package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.intermediate.CALL;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.EXPSTM;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.Exp;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.Stm;
import fr.ubordeaux.deptinfo.compilation.lea.type.Tag;
import fr.ubordeaux.deptinfo.compilation.lea.type.Type;
import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeCALL extends Stree {

	private Exp exp;
	private Stm stm;

	public StreeCALL(Stree left, Stree right) throws StreeException, TypeException {
		super(left, right);
		this.exp = new CALL(left.getExp(), right.getExpList());
		this.stm = new EXPSTM(exp);
	}

	@Override
	public Exp getExp() {
		return exp;
	}

	@Override
	public Stm getStm() {
		return stm;
	}

	@Override
	public boolean checkType() throws StreeException {
		if (getLeft().getType() == null)
			return true;
		Type lType = this.getLeft().getType().getLeft();
		Stree rArg = this.getRight();
		if (lType == null || rArg == null)
			return lType == rArg;
		while (lType != null && rArg != null) {
			Type tmpType = lType;
			if(tmpType.getTag()==Tag.PRODUCT)
				tmpType = lType.getRight();

			if (!tmpType.getLeft().assertEqual(rArg.getLeft().getType())) {
				return false;
			}

			if(lType.getTag() == Tag.PRODUCT)
				lType = lType.getLeft();
			else
				lType = null;
			rArg = rArg.getRight();
		}
		return (lType == null && rArg == null);

	}

	@Override
	public Type getType() throws StreeException {
		return this.getLeft().getType().getRight();
	}

}
