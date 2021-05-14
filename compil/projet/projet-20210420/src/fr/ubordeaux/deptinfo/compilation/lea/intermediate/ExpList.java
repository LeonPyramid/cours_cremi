package fr.ubordeaux.deptinfo.compilation.lea.intermediate;

public class ExpList {
	private Exp head;
	private ExpList tail;
	private EXPLIST expl;

	public ExpList(Exp head, ExpList tail) {
		super();
		this.head = head;
		this.tail = tail;
		expl = new EXPLIST(this);
		
	}

	public ExpList(Exp head) {
		this(head, null);
	}

	@Override
	public String toString(){
		ExpList tmp = this;
		String ret = "ExpList[" + tmp.head;
		if(tail != null){
			tmp = tmp.tail;
			while(tmp.tail!= null){
				ret +=", " +  tmp.head;
				tmp = tmp.tail;;
			}
		}
		return ret + "]";
	}




	public int getId() {
		return this.expl.getId();
	}

	private void interToDot(StringBuffer str){
		
	}

	public void toDot(StringBuffer str){
		expl.toDot(str);
		ExpList tmp = this;
		tmp.head.toDot(str);
		str.append("Stm_" + getId() + " -> Exp_" + head.getId() + ";\n");
		if(tmp.tail != null){
			tmp = tmp.tail;
			tmp.head.toDot(str);
			str.append("Stm_" + this.getId() + " -> Exp_" + tmp.head.getId() + ";\n");
		}
	}

	public String getDotLabel(){
		return this.toString();
	}

	public ExpList copy(){
		ExpList next = null;
		if(this.tail!=null){
			next = tail.copy();
		}
		return new ExpList(this.head,next);
	}
}
