import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class GLCP {
	private ANTLRInputStream input;
	private Python3Lexer lexer;
	private CommonTokenStream tokens;
	private Python3Parser parser;
	private ParseTreeWalker walker;
	private Listener listener;
	
	public GLCP(List<String> booksForTraining) throws Exception {
		System.out.println("####### Training #####");
		for (String book : booksForTraining) {
			input = new ANTLRFileStream(book);
			lexer = new Python3Lexer(input);
			tokens = new CommonTokenStream(lexer);
			parser = new Python3Parser(tokens);
			ParseTree tree = parser.file_input(); // comienza el análisis en la
			// regla inicial
			String word = tree.toStringTree(parser);
			System.out.println("\n****************************Arbol de " + book
					+ "*********************************************\n" + word
					+ "\n");
			walker = new ParseTreeWalker();
			if (listener == null)
				listener = new Listener(parser);
			walker.walk(listener, tree);
			System.out.println(listener.probModule.toStringPositive());

		}
		System.out.println("####### End Training #####");
		listener.setCalculate();// desactiva que el Listener siga sumando para
								// las probabilidades
	}

	public float getProb(String codeIn) throws Exception {
		listener.setResult(0);
		System.out.println("####### Calculating #####");
		input = new ANTLRFileStream(codeIn);
		lexer = new Python3Lexer(input);
		tokens = new CommonTokenStream(lexer);
		parser = new Python3Parser(tokens);
		ParseTree tree = parser.file_input(); // comienza el análisis en la
		// regla inicial
		String word = tree.toStringTree(parser);
		System.out.println("\n****************************Arbol de " + codeIn
				+ "*********************************************\n" + word
				+ "\n");
		walker = new ParseTreeWalker();
		walker.walk(listener, tree);
		System.out.println(listener.probModule.toStringPositive());

		System.out.println("####### End Calculating #####");
		return  listener.getResult();
	}

}
