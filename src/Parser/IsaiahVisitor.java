// Generated from E:/SJTU/3CompilerWorkplace/src/Parser\Isaiah.g4 by ANTLR 4.9.1
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IsaiahParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IsaiahVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(IsaiahParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyDeclare(IsaiahParser.EmptyDeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignDeclare(IsaiahParser.AssignDeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListDeclare(IsaiahParser.ListDeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclare(IsaiahParser.ClassDeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDeclare(IsaiahParser.FuncDeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constrDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstrDeclare(IsaiahParser.ConstrDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#digitType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigitType(IsaiahParser.DigitTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(IsaiahParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(IsaiahParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#retType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetType(IsaiahParser.RetTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariVal(IsaiahParser.VariValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntVal(IsaiahParser.IntValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringVal(IsaiahParser.StringValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueVal(IsaiahParser.TrueValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseVal(IsaiahParser.FalseValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullVal(IsaiahParser.NullValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newWrong2}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewWrong2(IsaiahParser.NewWrong2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code newWrong}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewWrong(IsaiahParser.NewWrongContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArray(IsaiahParser.NewArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewClass(IsaiahParser.NewClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncVal(IsaiahParser.FuncValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaVal(IsaiahParser.LambdaValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisVal(IsaiahParser.ThisValContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(IsaiahParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(IsaiahParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(IsaiahParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStmt(IsaiahParser.EmptyStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(IsaiahParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListStmt(IsaiahParser.ListStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(IsaiahParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondStmt(IsaiahParser.CondStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(IsaiahParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(IsaiahParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code retStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetStmt(IsaiahParser.RetStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(IsaiahParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinStmt(IsaiahParser.ContinStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(IsaiahParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpr(IsaiahParser.IndexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(IsaiahParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueExpr(IsaiahParser.ValueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(IsaiahParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixExpr(IsaiahParser.SuffixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(IsaiahParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(IsaiahParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(IsaiahParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(IsaiahParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#forCond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCond(IsaiahParser.ForCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#forIncre}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForIncre(IsaiahParser.ForIncreContext ctx);
}