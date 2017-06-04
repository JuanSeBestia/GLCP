
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
		booksForTraining.add("D:\\Bibliotecas\\workspaceJuanSe\\plagio\\src\\basico.py");
		GLCP glcp = new GLCP (booksForTraining);
		

		ANTLRInputStream input = new ANTLRFileStream(args[0]);
		ANTLRInputStream input1 = new ANTLRFileStream(args[1]);
		// Solo prueba
		//ANTLRInputStream input = new ANTLRFileStream("basico.py");
		//ANTLRInputStream input1 = new ANTLRFileStream("basico.py");

		Python3Lexer lexer = new Python3Lexer(input);
		Python3Lexer lexer1 = new Python3Lexer(input1);
		// Identificar al analizador léxico como fuente de tokens para el
		// sintactico
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CommonTokenStream tokens1 = new CommonTokenStream(lexer1);
		// Crear el analizador sintáctico que se alimenta a partir del buffer
		// de
		// tokens
		Python3Parser parser = new Python3Parser(tokens);
		Python3Parser parser1 = new Python3Parser(tokens1);
		ParseTree tree = parser.file_input(); // comienza el análisis en la
		// regla inicial
		ParseTree tree1 = parser1.file_input();
		

		System.out.println("Inicio del porgrama");
		System.out.println("pureba minDistance" + minDistanceOptimizado("Un pajaro grita", "Un pajar rnza"));
		String word1 = tree.toStringTree(parser);
		String word2 = tree1.toStringTree(parser1);
		System.out.println("\n*********************Aqui empieza la funcionalidad Basica**********************\n");

		System.out.println(
				"\n****************************Arbol1*********************************************\n" + word1 + "\n");
		System.out.println(
				"\n****************************Arbol2*********************************************\n" + word2 + "\n");

		double max = 0;
		if (word1.length() < word2.length()) {
			max = word2.length();
			StringBuilder sb = new StringBuilder(word1);
			for (int i = 0; i < (word2.length() - word1.length()); i++) {
				sb.append(" ");
			}
			word1 = sb.toString();

		} else {
			max = word1.length();
			StringBuilder sb = new StringBuilder(word2);
			for (int i = 0; i < (word1.length() - word2.length()); i++) {
				sb.append(" ");
			}
			word2 = sb.toString();
		}
		// Arreglar
		/*
		 * Exception in thread "main" java.lang.OutOfMemoryError: Java heapspace
		 * at Test.minDistance(Test.java:127) at Test.main(Test.java:53)
		 */
		/*
		 * int div = 5000; int ndiv = (int) (max / div); double mindis = 0;
		 * 
		 * for (int i = 1; i < ndiv + 1; i++) { String w1 = word1.substring((i -
		 * 1) * div, i * div); String w2 = word2.substring((i - 1) * div, i *
		 * div); // System.out.println("prueba" + i*div + " " + w1); double aux
		 * = minDistance(w1, w2); System.out.println(
		 * "diferencia obtenida en prueba " + i * div + ": " + aux); mindis =
		 * mindis + aux;
		 * 
		 * } String w1 = word1.substring((ndiv) * div, (int) max); String w2 =
		 * word2.substring((ndiv) * div, (int) max); //
		 * System.out.println("prueba" + (ndiv) *div + " " + w1); double aux =
		 * minDistance(w1, w2); System.out.println(
		 * "diferencia obtenida en prueba " + max + ": " + aux); mindis = mindis
		 * + aux;
		 */
		// System.out.println(ndiv + "-" + ndiv * div + "-" + max);
		double mindis = minDistanceOptimizado(word1, word2); // se muere por falta de
		// memoria ram no puede crear un arreglo tan grande
		System.out.println("Mind Distance:" + mindis);

		ParseTreeWalker walker = new ParseTreeWalker();
		ParseTreeWalker walker1 = new ParseTreeWalker();
		Listener listener = new Listener(parser);
		Listener listener1 = new Listener(parser1);
		walker.walk(listener, tree);
		walker1.walk(listener, tree1);
		System.out.println(listener.probModule.toStringPositive());;
		System.out.println(listener1.probModule.toStringPositive());;
		
		
		// Funcionalidad Basica

		System.out.println("Mind Distance:" + mindis);

		System.out.println("\n**********************************RESULTADOS***********************************\n");
		System.out.println(
				"Los codigos han pasado la prueba lexica y sintactico por lo cual es un codigo permitido del lenguaje");
		// System.out.println("max" + max + " - minds: " + mindis);
		double porcentaje = ((max - mindis) / max) * 100;
		System.out.println("Los codigos tienen un %" + porcentaje
				+ "de acuerdo a su analisis syntactico por la coincidencias de sus arboes AST");
		System.out.println("Acontinuacion se mostraran los llamados de cada regla de la framatica en el codigo");
		String[] nf = listener.nombres_funciones;
		//String[] nf1 = listener1.nombres_funciones;

		int[] nvf = listener.numero_veces_funcion_llamada;
		int[] nvf1 = listener1.numero_veces_funcion_llamada;
		int[] dif = listener1.numero_veces_funcion_llamada;

		System.out.println("******Funcion**********llamados en codigo 1*******llamados en codigo 2******Diferencia");
		double numFuncLlmadas = 0;
		double numFuncLlmadas1 = 0;
		double desv = 0;
		int idesv = 0;
		for (int i = 0; i < 84; i++) {
			dif[i] = (nvf[i] - nvf1[i]) * (nvf[i] - nvf1[i]); // para caluclar
			if (dif[i] != 0)
				idesv++;
			desv += dif[i]; // la desviacion
			numFuncLlmadas += nvf[i]; // estandar
			numFuncLlmadas1 += nvf1[i];

			System.out.println(
					"funcion:" + nf[i] + "\t\t\t" + nvf[i] + "\t\t" + nvf1[i] + "\t\t" + Math.abs(nvf[i] - nvf1[i]));

		}
		double media = numFuncLlmadas / 84;
		double media1 = numFuncLlmadas1 / 84;
		desv = Math.sqrt(desv / (idesv - 1));
		System.out.println("********************************RESUMEN***************************************");
		System.out.println("Los codigos tienen un %" + porcentaje
				+ "de acuerdo a su analisis syntactico por la coincidencias de sus arboes AST");
		System.out.println("El codigo 1 y 2  tiene " + (int) numFuncLlmadas + "------" + (int) numFuncLlmadas1
				+ " derivaciones gramaticales respectivamente");
		System.out.println("El codigo 1 y 2  tiene una media de " + media + "-----" + media1
				+ " derivaciones gramaticales respectivamente");
		System.out.println("La desviacion estandar entre las reglas gramaticas llamadas es de: " + desv);

		/*
		 * ParseTree tree1 = parser1.file_input(); // Create a generic parse
		 * tree walker that can trigger callbacks System.out.println("father1");
		 * System.out.println(tree.toStringTree(parser)); for(int
		 * i=0;i<tree.getChildCount();i++) { System.out.println("son1");
		 * System.out.println(tree.getChild(i).toStringTree(parser)); }
		 * System.out.println("father2");
		 * System.out.println(tree1.toStringTree(parser1)); for(int
		 * i=0;i<tree1.getChildCount();i++) { System.out.println("son2");
		 * System.out.println(tree1.getChild(i).toStringTree(parser1)); }
		 * //System.out.println(tree1.toStringTree(parser1)); for(int
		 * i=0;i<tree.getChildCount();i++) {
		 * 
		 * for(int j=0;j<tree1.getChildCount();j++) { System.out.println(
		 * "comparing "+ i+" "+j);
		 * System.out.println(minDistance(tree.getChild(i).toStringTree(parser),
		 * tree1.getChild(j).toStringTree(parser1))); } }
		 */

	}

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		// System.out.println("Tamaños de arreglos x" + len1 + " y" + len2);
		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		// iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);

				// if last two chars equal
				if (c1 == c2) {
					// update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;

					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
		return dp[len1][len2];
	}

	public static int minDistanceOptimizado(String word1, String word2) {
		/**
		 * Optimizacion Sugerida por Laura Alejandra Chaparro Gutierrez, Gracias
		 * :)
		 */
		int len1 = word1.length();
		int len2 = word2.length();

		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[2][len2 + 1];

		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;

		}
		dp[1] = dp[0];
		// iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			dp[0] = dp[1];
			dp[1] = new int[len2 + 1];
			char c1 = word1.charAt(i);
			dp[1][0] = i;
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);

				// if last two chars equal
				if (c1 == c2) {
					// update dp value for +1 length
					dp[1][j + 1] = dp[0][j];
				} else {
					int replace = dp[0][j] + 1;
					int insert = dp[0][j + 1] + 1;
					int delete = dp[1][j] + 1;

					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[1][j + 1] = min;
				}
			}
			/*
			 * for (int is : dp[0]) { System.out.print(is); }
			 */
		}

		return dp[1][len2];
	}

}
