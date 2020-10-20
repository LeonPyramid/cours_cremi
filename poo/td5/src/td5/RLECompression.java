package td5;

public class RLECompression implements ICompression{
	private char flag;
	
	
	public RLECompression (char c) {
		this.flag = c;
	}
	public String compress(String data) {
		String res = "";
		char c;
		int i;
		while(data.length()!=0) {
			c = data.charAt(0);
			i = this.lengthOfSingleLetterPrefix(data);
			if( i > 9) i = 9;
			if(c==flag) {
				res = res + c + i;
			}
			else {				
				res = res + c + flag + i;
			}
			data = data.substring(i);
		}
		return res;
	}

	public String uncompress(String data) {
		String res = "";
		while(data.length()>0) {
			int val;
			char letter = data.charAt(0);
			if(letter == flag) {
				char valc = data.charAt(1);
				if(Character.isDigit(valc)) {
					val = Character.digit(valc, 10);
				}
				else {
					throw new DecodeError("Mauvais caractère après le flag " + flag,res,data);
				}
				for(int i = 0; i < val; i ++) {				
					res = res + letter;
				}
				data = data.substring(2);
				
			}
			else {				
				char flg = data.charAt(1);
				char valc = data.charAt(2);
				if(flg != flag) {
					throw new DecodeError("Pas de flag à l'endroit souhaité après "+letter,res,data);
				}
				if(Character.isDigit(valc)) {
					val = Character.digit(valc, 10);
				}
				else {
					throw new DecodeError("Mauvais caractère après le flag " + flg,res,data);
				}
				for(int i = 0; i < val; i ++) {				
					res = res + letter;
				}
				data = data.substring(3);
			}
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
