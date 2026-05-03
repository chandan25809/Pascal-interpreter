// Generated from /Users/undefinedboy/development/plp_project1/src/delphi/delphi.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link delphiParser}.
 */
public interface delphiListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link delphiParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(delphiParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(delphiParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(delphiParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(delphiParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(delphiParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(delphiParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(delphiParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(delphiParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(delphiParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(delphiParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(delphiParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(delphiParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(delphiParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(delphiParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(delphiParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(delphiParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(delphiParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(delphiParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(delphiParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(delphiParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(delphiParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(delphiParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(delphiParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(delphiParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(delphiParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(delphiParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(delphiParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(delphiParser.PrintStatementContext ctx);
}