package school;
import lessons.*;


public class MusicSchool{
	private Lesson[] lessons;
	private int ammount;
	public MusicSchool() {
		lessons = new Lesson[10];
		ammount = 0;
	}
	public void addLesson(Lesson l) throws MaxSizeExceededException {
		if (this.ammount == 10) {
			throw new MaxSizeExceededException();
		}
		else {
			this.lessons[this.ammount] = l;
			ammount += 1;
		}
	}
	
	public int getBalance() {
		int res = 0;
		for (int i = 0 ; i < this.ammount ; i ++) {
			res += this.lessons[i].getBalance();
		}
		return res;
	}
	
	public String toString() {
		String res = "MusicSchool\n";
		for (int i = 0 ; i < this.ammount ; i ++) {
			res += this.lessons[i].toString()+"\n";
		}
		return res;
	}
}