package lessons;

public abstract class Lesson {
		private int annualCost;
		private int price;
		private String professor;
		private int nbRegistrations;
		private int nbRegistrationsMax;
		
		
		public int getNbRegistrations() {
			return nbRegistrations;
		}

		protected void setNbRegistrations(int nbRegistrations) {
			this.nbRegistrations = nbRegistrations;
		}

		protected int getNbRegistrationsMax() {
			return nbRegistrationsMax;
		}
		
		protected void setNbRegistrationsMax(int nbRegistrationsMax) {
			this.nbRegistrationsMax = nbRegistrationsMax;
		}

		public Lesson (int nannualCost ,int nprice, String nprofessor) {
			this.annualCost = nannualCost;
			this.price = nprice;
			this.professor = nprofessor;
			this.setNbRegistrationsMax(1);
			this.setNbRegistrations(0);
		}
		
		public int getBalance() {
			return (this.price*this.nbRegistrations) - this.annualCost;
		}
		
		public  int addRegistration(int ammount) {
			int rest = this.nbRegistrationsMax - this.nbRegistrations;
			if(rest < ammount ) {
				this.nbRegistrations = this.nbRegistrationsMax;
				return rest;
			}
			else {
				this.nbRegistrations += ammount;
				return ammount;
			}
		}
		
		public int addRegistration() {
			if (this.nbRegistrations < this.nbRegistrationsMax) {
				this.nbRegistrations += 1;
				return 1;
			}
			else {
				return 0;
			}
		}
		public String toString() {
			return this.origin();
		}
		public String origin() {
			return "Lesson [annualCost="+this.annualCost+", price="+this.price+
					", professor="+this.professor+", registrations="+this.nbRegistrations+"]";
		}

}