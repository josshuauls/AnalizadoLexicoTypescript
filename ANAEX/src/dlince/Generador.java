package dlince;
import java.io.File;
//agregar jFlex
public class Generador {
	public static void main(String [] args) {
		String path = "C://Users/jossh/git/AnalizadorLexType/ANAEX/src/dlince/";//
		String archivo = path + "lenguaje.lex";//nombre del archivo lex
		
		File file = new File(archivo);
		
		jflex.Main.generate(file);
	}
}
