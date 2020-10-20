package td5;

public class Test {

	public static void main(String[] args) {
		String str = "aaaaggggeeeefeaaaaaaaaaaaaaaaaaaaaaa";
		
		BasicRLECompression compress = new BasicRLECompression('$');
		String res = compress.compress(str);
		System.out.println(res);
		String out = compress.uncompress("a$22$2");
		System.out.println(out);
		System.out.println(str);
		System.out.print(out.equals(str));
	}

}
