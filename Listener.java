/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/

/** Convert short array inits like {1,2,3} to "\u0001\u0002\u0003" */
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

public class Listener extends Python3BaseListener {

	ArrayList<ParseTree> lista = new ArrayList<ParseTree>();
	ArrayList<Integer> loop = new ArrayList<Integer>();
	int index = 0;
	Python3Parser parser;
	static String[] nombres_funciones = new String[90];
	int[] numero_veces_funcion_llamada = new int[90];
	public ProbModule probModule = new ProbModule(200);

	Listener(Python3Parser parser1) {
		parser = parser1;
	}

	/*
	 * @Override public void enterSimple_stmt(Python3Parser.Simple_stmtContext
	 * ctx) { ParseTree tree = ctx; System.out.println("FUNCIONA");
	 * System.out.println(tree.getText());
	 * System.out.println(tree.toStringTree(parser));
	 * System.out.println("FUNCIONA"); lista.add(tree); index++;
	 * 
	 * // fun=ctx.dato().getText()+" "+ctx.IDENT().getText()+" " //
	 * +ctx.LPAREN().getText()+ctx.opargs().getText()+ctx.RPAREN().getText() //
	 * ; test.crearFuncion(d, fun, 0); o++; d++;
	 * 
	 * }
	 * 
	 * @Override public void enterWhile_stmt(Python3Parser.While_stmtContext
	 * ctx) { loop.add(index); index++; // // fun=ctx.dato().getText()+" "
	 * +ctx.IDENT().getText()+" "
	 * //+ctx.LPAREN().getText()+ctx.opargs().getText()+ctx.RPAREN().getText()
	 * // ; test.crearFuncion(d, fun, 0); o++; d++;
	 * 
	 * }
	 * 
	 * public void exitWhile_stmt(Python3Parser.While_stmtContext ctx) {
	 * ctx.removeLastChild(); System.out.println("FUNCIONA");
	 * System.out.println(ctx.getText());
	 * System.out.println(ctx.toStringTree(parser));
	 * System.out.println("FUNCIONASS"); if (loop.size() > 1) {
	 * loop.set(loop.size() - 1, loop.get(loop.size() - 1) - loop.size() + 1); }
	 * int a = loop.remove(loop.size() - 1); System.out.println(a); lista.add(a,
	 * ctx); }
	 * 
	 * public void exitFile_input(Python3Parser.File_inputContext ctx) { for
	 * (ParseTree t : lista) { System.out.println("son");
	 * System.out.println(t.toStringTree(parser)); } }
	 * 
	 * @Override public void enterFor_stmt(Python3Parser.For_stmtContext ctx) {
	 * loop.add(index); index++; }
	 * 
	 * public void exitFor_stmt(Python3Parser.For_stmtContext ctx) {
	 * ctx.removeLastChild(); System.out.println("FUNCIONA");
	 * System.out.println(ctx.getText());
	 * System.out.println(ctx.toStringTree(parser));
	 * System.out.println("FUNCIONASS"); if (loop.size() > 1) {
	 * loop.set(loop.size() - 1, loop.get(loop.size() - 1) - loop.size() + 1); }
	 * int a = loop.remove(loop.size() - 1); System.out.println(a); lista.add(a,
	 * ctx); }
	 * 
	 * public void enterIf_stmt(Python3Parser.If_stmtContext ctx) { if
	 * (ctx.getChildCount() <= 4) { loop.add(index); index++; } else {
	 * loop.add(index); } }
	 * 
	 * public void exitIf_stmt(Python3Parser.If_stmtContext ctx) { if
	 * (ctx.getChildCount() == 4) { ctx.removeLastChild();
	 * System.out.println("FUNCIONA"); System.out.println(ctx.getText());
	 * System.out.println(ctx.toStringTree(parser));
	 * System.out.println("FUNCIONASS"); if (loop.size() > 1) {
	 * loop.set(loop.size() - 1, loop.get(loop.size() - 1) - loop.size() + 1); }
	 * int a = loop.remove(loop.size() - 1); System.out.println(a); lista.add(a,
	 * ctx); } }
	 */
	/**
	 * Enter no implement method
	 * 
	 */

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterAnd_expr(Python3Parser.And_exprContext ctx) {
		probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[0] = "enterAnd_expr";
		numero_veces_funcion_llamada[0] = numero_veces_funcion_llamada[0] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterAnd_test(Python3Parser.And_testContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[1] = "enterAnd_test";
		numero_veces_funcion_llamada[1] = numero_veces_funcion_llamada[1] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterArglist(Python3Parser.ArglistContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[2] = "enterArglist";
		numero_veces_funcion_llamada[2] = numero_veces_funcion_llamada[2] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterArgument(Python3Parser.ArgumentContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[3] = "enterArgument";
		numero_veces_funcion_llamada[3] = numero_veces_funcion_llamada[3] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterArith_expr(Python3Parser.Arith_exprContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[4] = "enterArith_expr";
		numero_veces_funcion_llamada[4] = numero_veces_funcion_llamada[4] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterAssert_stmt(Python3Parser.Assert_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[5] = "enterAssert_stmt";
		numero_veces_funcion_llamada[5] = numero_veces_funcion_llamada[5] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterAtom(Python3Parser.AtomContext ctx) {
		probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[6] = "enterAtom";
		numero_veces_funcion_llamada[6] = numero_veces_funcion_llamada[6] + 1;
		
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterAugassign(Python3Parser.AugassignContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[7] = "enterAugassign";
		numero_veces_funcion_llamada[7] = numero_veces_funcion_llamada[7] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterBreak_stmt(Python3Parser.Break_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[8] = "enterBreak_stmt";
		numero_veces_funcion_llamada[8] = numero_veces_funcion_llamada[8] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterClassdef(Python3Parser.ClassdefContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[9] = "enterClassdef";
		numero_veces_funcion_llamada[9] = numero_veces_funcion_llamada[9] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterComp_for(Python3Parser.Comp_forContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[10] = "enterComp_for";
		numero_veces_funcion_llamada[10] = numero_veces_funcion_llamada[10] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterComp_if(Python3Parser.Comp_ifContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[11] = "enterComp_if";
		numero_veces_funcion_llamada[11] = numero_veces_funcion_llamada[11] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterComp_iter(Python3Parser.Comp_iterContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[12] = "enterComp_iter";
		numero_veces_funcion_llamada[12] = numero_veces_funcion_llamada[12] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterComp_op(Python3Parser.Comp_opContext ctx) {

		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[13] = "enterComp_op";
		numero_veces_funcion_llamada[13] = numero_veces_funcion_llamada[13] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterComparison(Python3Parser.ComparisonContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[14] = "enterComparison";
		numero_veces_funcion_llamada[14] = numero_veces_funcion_llamada[14] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterCompound_stmt(Python3Parser.Compound_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[15] = "enterCompound_stmt";
		numero_veces_funcion_llamada[15] = numero_veces_funcion_llamada[15] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterContinue_stmt(Python3Parser.Continue_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[16] = "enterContinue_stmt";
		numero_veces_funcion_llamada[16] = numero_veces_funcion_llamada[16] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterDecorated(Python3Parser.DecoratedContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[17] = "enterDecorated";
		numero_veces_funcion_llamada[17] = numero_veces_funcion_llamada[17] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterDecorator(Python3Parser.DecoratorContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[18] = "enterDecorator";
		numero_veces_funcion_llamada[18] = numero_veces_funcion_llamada[18] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterDecorators(Python3Parser.DecoratorsContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[19] = "enterDecorators";
		numero_veces_funcion_llamada[19] = numero_veces_funcion_llamada[19] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterDel_stmt(Python3Parser.Del_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[20] = "enterDel_stmt";
		numero_veces_funcion_llamada[20] = numero_veces_funcion_llamada[20] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterDictorsetmaker(Python3Parser.DictorsetmakerContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[21] = "enterDictorsetmaker";
		numero_veces_funcion_llamada[21] = numero_veces_funcion_llamada[21] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterDotted_as_name(Python3Parser.Dotted_as_nameContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[22] = "enterDotted_as_name";
		numero_veces_funcion_llamada[22] = numero_veces_funcion_llamada[22] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterDotted_as_names(Python3Parser.Dotted_as_namesContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[23] = "enterDotted_as_names";
		numero_veces_funcion_llamada[23] = numero_veces_funcion_llamada[23] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterDotted_name(Python3Parser.Dotted_nameContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[24] = "enterDotted_name";
		numero_veces_funcion_llamada[24] = numero_veces_funcion_llamada[24] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterEval_input(Python3Parser.Eval_inputContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[25] = "enterEval_input";
		numero_veces_funcion_llamada[25] = numero_veces_funcion_llamada[25] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[26] = "enterEveryRule";
		numero_veces_funcion_llamada[26] = numero_veces_funcion_llamada[26] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterExcept_clause(Python3Parser.Except_clauseContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[27] = "enterExcept_clause";
		numero_veces_funcion_llamada[27] = numero_veces_funcion_llamada[27] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterExpr(Python3Parser.ExprContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[28] = "enterExpr";
		numero_veces_funcion_llamada[28] = numero_veces_funcion_llamada[28] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterExpr_stmt(Python3Parser.Expr_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[29] = "enterExpr_stmt";
		numero_veces_funcion_llamada[29] = numero_veces_funcion_llamada[29] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterExprlist(Python3Parser.ExprlistContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[30] = "enterExprlist";
		numero_veces_funcion_llamada[30] = numero_veces_funcion_llamada[30] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterFactor(Python3Parser.FactorContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[31] = "enterFactor";
		numero_veces_funcion_llamada[31] = numero_veces_funcion_llamada[31] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterFile_input(Python3Parser.File_inputContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[32] = "enterFile_input";
		numero_veces_funcion_llamada[32] = numero_veces_funcion_llamada[32] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterFlow_stmt(Python3Parser.Flow_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[33] = "enterFlow_stmt";
		numero_veces_funcion_llamada[33] = numero_veces_funcion_llamada[33] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterFor_stmt(Python3Parser.For_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[34] = "enterFor_stmt";
		numero_veces_funcion_llamada[34] = numero_veces_funcion_llamada[34] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterFuncdef(Python3Parser.FuncdefContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[35] = "enterFuncdef";
		numero_veces_funcion_llamada[35] = numero_veces_funcion_llamada[35] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterGlobal_stmt(Python3Parser.Global_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[36] = "enterGlobal_stmt";
		numero_veces_funcion_llamada[36] = numero_veces_funcion_llamada[36] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterIf_stmt(Python3Parser.If_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[37] = "enterIf_stmt";
		numero_veces_funcion_llamada[37] = numero_veces_funcion_llamada[37] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterImport_as_name(Python3Parser.Import_as_nameContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[38] = "enterImport_as_name";
		numero_veces_funcion_llamada[38] = numero_veces_funcion_llamada[38] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterImport_as_names(Python3Parser.Import_as_namesContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[39] = "enterImport_as_names";
		numero_veces_funcion_llamada[39] = numero_veces_funcion_llamada[39] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterImport_from(Python3Parser.Import_fromContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[40] = "enterImport_from";
		numero_veces_funcion_llamada[40] = numero_veces_funcion_llamada[40] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterImport_name(Python3Parser.Import_nameContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[41] = "enterImport_name";
		numero_veces_funcion_llamada[41] = numero_veces_funcion_llamada[41] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterImport_stmt(Python3Parser.Import_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[42] = "enterImport_stmt";
		numero_veces_funcion_llamada[42] = numero_veces_funcion_llamada[42] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterInteger(Python3Parser.IntegerContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[43] = "enterInteger";
		numero_veces_funcion_llamada[43] = numero_veces_funcion_llamada[43] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterLambdef(Python3Parser.LambdefContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[44] = "enterLambdef";
		numero_veces_funcion_llamada[44] = numero_veces_funcion_llamada[44] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterLambdef_nocond(Python3Parser.Lambdef_nocondContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[45] = "enterLambdef_nocond";
		numero_veces_funcion_llamada[45] = numero_veces_funcion_llamada[45] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterNonlocal_stmt(Python3Parser.Nonlocal_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[46] = "enterNonlocal_stmt";
		numero_veces_funcion_llamada[46] = numero_veces_funcion_llamada[46] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterNot_test(Python3Parser.Not_testContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[47] = "enterNot_test";
		numero_veces_funcion_llamada[47] = numero_veces_funcion_llamada[47] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterNumber(Python3Parser.NumberContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[48] = "enterNumber";
		numero_veces_funcion_llamada[48] = numero_veces_funcion_llamada[48] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterOr_test(Python3Parser.Or_testContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[49] = "enterOr_test";
		numero_veces_funcion_llamada[49] = numero_veces_funcion_llamada[49] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterParameters(Python3Parser.ParametersContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[50] = "enterParameters";
		numero_veces_funcion_llamada[50] = numero_veces_funcion_llamada[50] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterPass_stmt(Python3Parser.Pass_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[51] = "enterPass_stmt";
		numero_veces_funcion_llamada[51] = numero_veces_funcion_llamada[51] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterPower(Python3Parser.PowerContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[52] = "enterPower";
		numero_veces_funcion_llamada[52] = numero_veces_funcion_llamada[52] + 1;
		/*
		System.out.println("#######POWER#####");
		System.out.println("ctx.getChildCount()" + ctx.getChildCount());
		System.out.println("ctx.getRuleIndex()" + ctx.getRuleIndex());
		System.out.println("ctx.getText()" + ctx.getText());
		System.out.println("ctx.getChild(0)" + ctx.getChild(0));
		System.out.println("ctx.getParent()" + ctx.getParent());
		System.out.println("ctx.getPayload()" + ctx.getPayload());
		System.out.println("ctx.getRuleContext()" + ctx.getRuleContext());
		System.out.println("ctx.getSourceInterval()" + ctx.getSourceInterval());
		System.out.println("ctx.getStart()" + ctx.getStart());
		System.out.println("ctx.getStop()" + ctx.getStop());
		System.out.println("" + ctx.getTokens(1));
		// System.out.println(""+ctx.get);
		 * 
		 */

	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterRaise_stmt(Python3Parser.Raise_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[53] = "enterRaise_stmt";
		numero_veces_funcion_llamada[53] = numero_veces_funcion_llamada[53] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterReturn_stmt(Python3Parser.Return_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[54] = "enterReturn_stmt";
		numero_veces_funcion_llamada[54] = numero_veces_funcion_llamada[54] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterShift_expr(Python3Parser.Shift_exprContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[55] = "enterShift_expr";
		numero_veces_funcion_llamada[55] = numero_veces_funcion_llamada[55] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterSimple_stmt(Python3Parser.Simple_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[56] = "enterSimple_stmt";
		numero_veces_funcion_llamada[56] = numero_veces_funcion_llamada[56] + 1;
		/*
		System.out.println("#######Simple_STMT#####");
		System.out.println("ctx.getChildCount()" + ctx.getChildCount());
		System.out.println("ctx.getRuleIndex()" + ctx.getRuleIndex());
		System.out.println("ctx.getText()" + ctx.getText());
		System.out.println("ctx.getChild(0)" + ctx.getChild(0));
		System.out.println("ctx.getParent()" + ctx.getParent());
		System.out.println("ctx.getPayload()" + ctx.getPayload());
		System.out.println("ctx.getRuleContext()" + ctx.getRuleContext());
		System.out.println("ctx.getSourceInterval()" + ctx.getSourceInterval());
		System.out.println("ctx.getStart()" + ctx.getStart());
		System.out.println("ctx.getStop()" + ctx.getStop());
		System.out.println("" + ctx.getTokens(1));
		*/
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterSingle_input(Python3Parser.Single_inputContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[57] = "enterSingle_input";
		numero_veces_funcion_llamada[57] = numero_veces_funcion_llamada[57] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterSliceop(Python3Parser.SliceopContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[58] = "enterSliceop";
		numero_veces_funcion_llamada[58] = numero_veces_funcion_llamada[58] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterSmall_stmt(Python3Parser.Small_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[59] = "enterSmall_stmt";
		numero_veces_funcion_llamada[59] = numero_veces_funcion_llamada[59] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterStar_expr(Python3Parser.Star_exprContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[60] = "enterStar_expr";
		numero_veces_funcion_llamada[60] = numero_veces_funcion_llamada[60] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterStmt(Python3Parser.StmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[61] = "enterStmt";
		numero_veces_funcion_llamada[61] = numero_veces_funcion_llamada[61] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterString(Python3Parser.StringContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[62] = "enterString";
		numero_veces_funcion_llamada[62] = numero_veces_funcion_llamada[62] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterSubscript(Python3Parser.SubscriptContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[63] = "enterSubscript";
		numero_veces_funcion_llamada[63] = numero_veces_funcion_llamada[63] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterSubscriptlist(Python3Parser.SubscriptlistContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[64] = "enterSubscriptlist";
		numero_veces_funcion_llamada[64] = numero_veces_funcion_llamada[64] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterSuite(Python3Parser.SuiteContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[65] = "enterSuite";
		numero_veces_funcion_llamada[65] = numero_veces_funcion_llamada[65] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterTerm(Python3Parser.TermContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[66] = "enterTerm";
		numero_veces_funcion_llamada[66] = numero_veces_funcion_llamada[66] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterTest(Python3Parser.TestContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[67] = "enterTest";
		numero_veces_funcion_llamada[67] = numero_veces_funcion_llamada[67] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterTest_nocond(Python3Parser.Test_nocondContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[68] = "enterTest_nocond";
		numero_veces_funcion_llamada[68] = numero_veces_funcion_llamada[68] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterTestlist(Python3Parser.TestlistContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[69] = "enterTestlist";
		numero_veces_funcion_llamada[69] = numero_veces_funcion_llamada[69] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterTestlist_comp(Python3Parser.Testlist_compContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[70] = "enterTestlist_comp";
		numero_veces_funcion_llamada[70] = numero_veces_funcion_llamada[70] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterTestlist_star_expr(
			Python3Parser.Testlist_star_exprContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[71] = "enterTestlist_star_expr";
		numero_veces_funcion_llamada[71] = numero_veces_funcion_llamada[71] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterTfpdef(Python3Parser.TfpdefContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[72] = "enterTfpdef";
		numero_veces_funcion_llamada[72] = numero_veces_funcion_llamada[72] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterTrailer(Python3Parser.TrailerContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[73] = "enterTrailer";
		numero_veces_funcion_llamada[73] = numero_veces_funcion_llamada[73] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterTry_stmt(Python3Parser.Try_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[74] = "enterTry_stmt";
		numero_veces_funcion_llamada[74] = numero_veces_funcion_llamada[74] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterTypedargslist(Python3Parser.TypedargslistContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[75] = "enterTypedargslist";
		numero_veces_funcion_llamada[75] = numero_veces_funcion_llamada[75] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterVarargslist(Python3Parser.VarargslistContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[76] = "enterVarargslist";
		numero_veces_funcion_llamada[76] = numero_veces_funcion_llamada[76] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterVfpdef(Python3Parser.VfpdefContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[77] = "enterVfpdef";
		numero_veces_funcion_llamada[77] = numero_veces_funcion_llamada[77] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterWhile_stmt(Python3Parser.While_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[78] = "enterWhile_stmt";
		numero_veces_funcion_llamada[78] = numero_veces_funcion_llamada[78] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterWith_item(Python3Parser.With_itemContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[79] = "enterWith_item";
		numero_veces_funcion_llamada[79] = numero_veces_funcion_llamada[79] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterWith_stmt(Python3Parser.With_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[80] = "enterWith_stmt";
		numero_veces_funcion_llamada[80] = numero_veces_funcion_llamada[80] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterXor_expr(Python3Parser.Xor_exprContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[81] = "enterXor_expr";
		numero_veces_funcion_llamada[81] = numero_veces_funcion_llamada[81] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterYield_arg(Python3Parser.Yield_argContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[82] = "enterYield_arg";
		numero_veces_funcion_llamada[82] = numero_veces_funcion_llamada[82] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterYield_expr(Python3Parser.Yield_exprContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[83] = "enterYield_expr";
		numero_veces_funcion_llamada[83] = numero_veces_funcion_llamada[83] + 1;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation does nothing.
	 * </p>
	 */
	@Override
	public void enterYield_stmt(Python3Parser.Yield_stmtContext ctx) {
		float prob = probModule.addDerivation(ctx.getRuleIndex(),
				ctx.invokingState);
		nombres_funciones[84] = "enterYield_stmt";
		numero_veces_funcion_llamada[84] = numero_veces_funcion_llamada[84] + 1;
	}

	static {

	}
}

class ParserRuleContextClone extends ParserRuleContext {
	List<ParseTree> children;
	RecognitionException exception;
	Token start;
	Token stop;

	ParserRuleContextClone(ParserRuleContext another) {
		this.children = another.children;
		this.exception = another.exception;
		this.start = another.start;
		this.stop = another.stop;
	}

}
