package td6;

public class RLECompression implements ICompression{
	protected char flag;
	
	
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
				res = res + c + 0;
				data = data.substring(1);
			}
			else {
				if(i > 3) {
					res = res + c + flag + i;
				}
				else {
					for (int j = 0; j < i; j ++) {
						res = res + c;
					}
				}
				data = data.substring(i);
			}
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
				if(valc == '0') {
					res = res + letter;
				}
				else {
					throw new RLEException(true,"Mauvais caractère après le flag " + flag,res,data);
				}
				data = data.substring(2);
				
			}
			else {				
				char char2 = data.charAt(1);
				char valc = data.charAt(2);
				if(char2 == flag && Character.isDigit(valc) && Character.digit(valc, 10) > 3) {
					val = Character.digit(valc, 10);
					for(int i = 0; i < val; i ++) {				
						res = res + letter;
					}
					data = data.substring(3);					
				}
				else if((char2 != flag) ||(char2 == flag && valc == '0')) {
					res = res + letter;
					data = data.substring(1);
				}
				else {
					throw new RLEException(true,"Mauvais caractère après le flag " + valc,res,data);
				}
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
