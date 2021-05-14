package fr.ubordeaux.deptinfo.compilation.lea.intermediate;

public class EXPLIST extends Stm {
	
	private ExpList exp;

	public EXPLIST(ExpList exp) {
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
	}

	@Override
	public Stm copy() {
		return new EXPLIST(this.exp.copy());
	}

}
