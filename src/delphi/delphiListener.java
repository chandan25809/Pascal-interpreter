// Generated from delphi.g4 by ANTLR 4.13.2
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
	 * Enter a parse tree produced by {@link delphiParser#destructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterDestructorDeclaration(delphiParser.DestructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#destructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitDestructorDeclaration(delphiParser.DestructorDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link delphiParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(delphiParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(delphiParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(delphiParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(delphiParser.BlockContext ctx);
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
	 * Enter a parse tree produced by {@link delphiParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(delphiParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(delphiParser.VariableDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link delphiParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(delphiParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(delphiParser.ReturnStatementContext ctx);
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
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(delphiParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(delphiParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(delphiParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(delphiParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(delphiParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(delphiParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(delphiParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(delphiParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCreateExpr(delphiParser.CreateExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCreateExpr(delphiParser.CreateExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMethodExpr(delphiParser.MethodExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodExpr}
	 * labeled alternative in {@link delphiParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMethodExpr(delphiParser.MethodExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link delphiParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(delphiParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link delphiParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(delphiParser.TypeNameContext ctx);
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