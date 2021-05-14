package fr.ubordeaux.deptinfo.compilation.lea.intermediate;

public class CALL extends Exp {

	private Exp function;
	private ExpList args;

	public CALL(Exp function, ExpList args) {
		super();
		this.function = function;
		this.args = args;
	}

	@Override
	public String getDotLabel() {
		return this.toString();
	}

	public String toString(){
		return "CALL";
	}

	@Override
	public void toDot(StringBuffer str) {
		super.toDot(str);
		function.toDot(str);
		args.toDot(str);
		str.append("Exp_" + getId() + " -> Exp_" + function.getId() + ";\n");
		str.append("Exp_" + getId() + " -> Stm_" + args.getId() + ";\n");
	}

	@Override
	public Exp copy() {
		return new CALL(this.function.copy(),this.args.copy());
	}

}
