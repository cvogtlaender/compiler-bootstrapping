// Generated from ./xmin.g4 by ANTLR 4.13.2
package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link xminParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface xminVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link xminParser#prog}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(xminParser.ProgContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#structDecl}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDecl(xminParser.StructDeclContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#structField}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructField(xminParser.StructFieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#function}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(xminParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#paramList}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(xminParser.ParamListContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#param}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(xminParser.ParamContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#expression}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(xminParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#letExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExpr(xminParser.LetExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#ifExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpr(xminParser.IfExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#blockExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockExpr(xminParser.BlockExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#logicalOrExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpr(xminParser.LogicalOrExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#logicalAndExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpr(xminParser.LogicalAndExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#equalityExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(xminParser.EqualityExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#relationalExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(xminParser.RelationalExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#additiveExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(xminParser.AdditiveExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#multiplicativeExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(xminParser.MultiplicativeExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#unaryExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(xminParser.UnaryExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#postfixExpr}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpr(xminParser.PostfixExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#postfixPart}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixPart(xminParser.PostfixPartContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#primary}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(xminParser.PrimaryContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#argList}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(xminParser.ArgListContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#literal}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(xminParser.LiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link xminParser#type}.
	 * 
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(xminParser.TypeContext ctx);
}