package td5;

public class BasicRLECompression implements ICompression{
	private char flag;
	
	
	public BasicRLECompression (char c) {
		this.flag = c;
	}
	public String compress(String data) {
		String res = "";
		char c;
		int i;
		while(data.length()!=0) {
			c = data.charAt(0);
			if(c==flag) {
				throw new Error("character int data is equal to flag");
			}
			i = this.lengthOfSingleLetterPrefix(data);
			if( i > 9) i = 9;
			res = res + c + flag + i;
			data = data.substring(i);
		}
		return res;
	}

	public String uncompress(String data) {
		String res = "";
		while(data.length()>0) {
			char letter = data.charAt(0);
			char flg = data.charAt(1);
			int val = Character.digit(data.charAt(2),10);
			if(!(Character.isAlphabetic(letter)&&flg==flag)) {
				throw new Error("Wrong type of compression");
			}
			for(int i = 0; i < val; i ++) {				
				res = res + letter;
			}
			data = data.substring(3);
		}
		return res;
		
	}
	
	int lengthOfSingleLetterPrefix(String s) {
		char c = s.charAt(0);
		int index = 1;
		int mxLen = s.length();
		while(index<mxLen&&s.charAt(index)==c) {
			index ++;
		}
		return index;
	}

}
