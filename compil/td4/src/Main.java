import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		Parser.Lexer Lexer = new ParserLexer(input);
		Parser parser = new Parser(Lexer);
		if (!parser.parse()) {
			System.exit(1);
		}
		System.out.println("OK");
	}

}
