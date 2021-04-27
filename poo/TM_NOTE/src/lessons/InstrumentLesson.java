package lessons;

public class InstrumentLesson extends Lesson{
	
	private String instrument;
	
	public InstrumentLesson(int nannualCost, int nprice, String nprofessor, String ninstrument) {
		super(nannualCost, nprice, nprofessor);
		this.instrument = ninstrument;
		this.setNbRegistrations(1);
	}
	
	public String toString() {
		String origin = this.origin();
		return "Instrument "+ origin + "[instrument="+this.instrument+"]";
	}
	
}