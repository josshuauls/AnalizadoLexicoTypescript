package dlince;
import java.io.File;
//agregar jFlex
public class Generador {
	public static void main(String [] args) {
		String path = "C://Users/jossh/eclipse-workspace/ANAEX/src/dlince/";//ruta del .lex
		String archivo = path + "lenguaje.lex";//nombre del archivo lex
		
		File file = new File(archivo);
		
		jflex.Main.generate(file);
	}
}
