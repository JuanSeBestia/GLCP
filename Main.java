
// import de librerias de runtime de ANTLR
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// crear un analizador léxico que se alimenta apartir de la entrada
		// (archivo o consola)
		/*
		 * UNALangLexer lexer; if (args.length>0) lexer = new UNALangLexer(new
		 * ANTLRFileStream(args[0])); else lexer = new UNALangLexer(new
		 * ANTLRInputStream(System.in));
		 */
		List<String> booksForTraining = new ArrayList<String>();
		booksForTraining.add("D:\\Bibliotecas\\workspaceJuanSe\\plagio\\src\\Planetas.py");
		booksForTraining.add("D:\\Bibliotecas\\workspaceJuanSe\\plagio\\src\\Planetas.py");
		GLCP glcp = new GLCP (booksForTraining);
		
	}

}
