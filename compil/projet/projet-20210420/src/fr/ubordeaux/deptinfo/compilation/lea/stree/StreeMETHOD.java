package fr.ubordeaux.deptinfo.compilation.lea.stree;

import fr.ubordeaux.deptinfo.compilation.lea.intermediate.Exp;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.NAME;
import fr.ubordeaux.deptinfo.compilation.lea.intermediate.temp.Label;
import fr.ubordeaux.deptinfo.compilation.lea.type.Type;
import fr.ubordeaux.deptinfo.compilation.lea.type.TypeException;

public class StreeMETHOD extends Stree {

	private String name;
	private NAME exp;
	private Type type;

	public StreeMETHOD(String name) throws TypeException, StreeException {
		this(name,null);

	}

	public StreeMETHOD(String name, Type type) throws TypeException, StreeException {
		super();
		this.name = name;
		this.type = type;
		Label lbl = new Label(name);
		this.exp = new NAME(lbl);
	}
	
	@Override
	public Exp getExp(){
		return exp;
	}

	@Override
	public boolean checkType() throws StreeException {
		return true;
	}

	@Override
	public Type getType() throws StreeException {
		return this.type;
	}

}
