package td5;

public class Test {

	public static void main(String[] args) {
		String str = "aaaaggggeeeefeaaaaaaaaaaaaaaaaaaaaaa";
		
		BasicRLECompression compress = new BasicRLECompression('$');
		String res = compress.compress(str);
		System.out.println(res);
		String out = compress.uncompress(res);
		System.out.println(out);
		System.out.println(str);
		System.out.print(out.equals(str));
	}

}
