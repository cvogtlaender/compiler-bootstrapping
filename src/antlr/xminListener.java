// Generated from ./xmin.g4 by ANTLR 4.13.2
package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link xminParser}.
 */
public interface xminListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link xminParser#prog}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterProg(xminParser.ProgContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#prog}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitProg(xminParser.ProgContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#structDecl}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterStructDecl(xminParser.StructDeclContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#structDecl}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitStructDecl(xminParser.StructDeclContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#structField}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterStructField(xminParser.StructFieldContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#structField}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitStructField(xminParser.StructFieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#function}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterFunction(xminParser.FunctionContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#function}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitFunction(xminParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#paramList}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterParamList(xminParser.ParamListContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#paramList}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitParamList(xminParser.ParamListContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#param}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterParam(xminParser.ParamContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#param}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitParam(xminParser.ParamContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#expression}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterExpression(xminParser.ExpressionContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#expression}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitExpression(xminParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#letExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterLetExpr(xminParser.LetExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#letExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitLetExpr(xminParser.LetExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#ifExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterIfExpr(xminParser.IfExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#ifExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitIfExpr(xminParser.IfExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#blockExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterBlockExpr(xminParser.BlockExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#blockExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitBlockExpr(xminParser.BlockExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#logicalOrExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpr(xminParser.LogicalOrExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#logicalOrExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpr(xminParser.LogicalOrExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#logicalAndExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpr(xminParser.LogicalAndExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#logicalAndExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpr(xminParser.LogicalAndExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#equalityExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(xminParser.EqualityExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#equalityExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(xminParser.EqualityExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#relationalExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(xminParser.RelationalExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#relationalExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(xminParser.RelationalExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#additiveExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(xminParser.AdditiveExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#additiveExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(xminParser.AdditiveExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#multiplicativeExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(xminParser.MultiplicativeExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#multiplicativeExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(xminParser.MultiplicativeExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#unaryExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(xminParser.UnaryExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#unaryExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(xminParser.UnaryExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#postfixExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(xminParser.PostfixExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#postfixExpr}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(xminParser.PostfixExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#postfixPart}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterPostfixPart(xminParser.PostfixPartContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#postfixPart}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitPostfixPart(xminParser.PostfixPartContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#primary}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterPrimary(xminParser.PrimaryContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#primary}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitPrimary(xminParser.PrimaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#argList}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterArgList(xminParser.ArgListContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#argList}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitArgList(xminParser.ArgListContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#literal}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterLiteral(xminParser.LiteralContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#literal}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitLiteral(xminParser.LiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link xminParser#type}.
	 * 
	 * @param ctx the parse tree
	 */
	void enterType(xminParser.TypeContext ctx);

	/**
	 * Exit a parse tree produced by {@link xminParser#type}.
	 * 
	 * @param ctx the parse tree
	 */
	void exitType(xminParser.TypeContext ctx);
}