package lessons;

public class TheoryLesson extends Lesson{

	
	public TheoryLesson(int nannualCost, int nprice, String nprofessor, int nnbRegistrationsMax) {
		super(nannualCost, nprice, nprofessor);
		this.setNbRegistrationsMax(nnbRegistrationsMax);
		this.setNbRegistrations(0);
	}
	
	public String toString() {
		String origin = this.origin();
		return "Theory "+ origin;
	}
		
}