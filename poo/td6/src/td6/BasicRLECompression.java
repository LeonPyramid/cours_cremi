package td6;

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
				throw new Error("Erreur de compression : Flag présent dans la chaîne de caractère.\n" + 
						"	encodé à ce stade : " + res + 
						"\n	non traité	  : " + data);
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
			int val;
			char letter = data.charAt(0);
			char flg = data.charAt(1);
			char valc = data.charAt(2);
			if(letter == flag) {
				throw new DecodeError("Mauvais caractère à décoder " + letter, res, data);
			}
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

class DecodeError extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DecodeError(String s ,String done ,String todo) 
	{
		super("Erreur de décompression : " + s + "\n décodé à ce stade : " + done + 
						"\n	non décodé        : " + todo); 
	}
	
}

