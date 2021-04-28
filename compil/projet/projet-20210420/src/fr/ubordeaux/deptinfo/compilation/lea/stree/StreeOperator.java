package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.intermediate.BINOP;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.Exp;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.BINOP.Code;
import fr.ubordeaux.deptinfo.compilation.lea.type.Type;
import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public abstract class StreeOperator extends Stree {
    private BINOP exp;
	private Type type;

	public StreeOperator(Stree left, Stree right, Code biCode) throws StreeException, TypeException {
		super(left, right);
		this.exp = new BINOP(biCode, left.getExp(), right.getExp());
	}

    public StreeOperator(Stree left, Code biCode) throws StreeException, TypeException {
        this(left,null,biCode);
    }
	@Override
	public Exp getExp(){
		return exp;
	}
	
	@Override
	public Type getType() throws StreeException {
		return type;
	}

	@Override
	public boolean checkType() throws StreeException {
		Type typeLeft = getLeft().getType();
		Type typeRight = getRight().getType();
		type = typeLeft;
		if ((typeLeft != null) && (typeRight != null))
			return typeLeft.assertEqual(typeRight);
		else
			throw new StreeException("Type error while checking null types !");
	}
}
