package fr.ubordeaux.deptinfo.compilation.lea.intermediate;

public class EXPSTM extends Stm {
	
	private Exp exp;

	public EXPSTM(Exp exp) {
		super();
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "EXPSTM [exp=" + exp + "]";
	}

	@Override
	public void toDot(StringBuffer str) {
		super.toDot(str);
		exp.toDot(str);
		str.append("Stm_" + getId() + " -> Exp_" + exp.getId() + ";\n");
	}

	@Override
	public Stm copy() {
		return new EXPSTM(this.exp.copy());
	}

}
