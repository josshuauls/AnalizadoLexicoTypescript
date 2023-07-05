package dlince;

import java.io.IOException;
import java.io.StringReader;

public class Test {

	public static void main(String[] args) {
		String expresion = "if 2+3+a then";
		
		AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(expresion));
		try {
			lexico.yylex();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
