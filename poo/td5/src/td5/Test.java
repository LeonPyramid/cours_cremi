package td5;

public class Test {

	public static void main(String[] args) {
		//String str = "aaaaggggeeeefeaaaaaa$$$$000aaa$$aaaaaaaaaaaaa";
		
		BasicRLECompression compress = new BasicRLECompression('$');
		//String res = compress.compress(str);
		//System.out.println(res);
		String out = compress.uncompress("a$4g$4e$4f$1e$1a$f6");
		//System.out.println(out);
		//System.out.println(str);
		//System.out.print(out.equals(str));
	}

}
