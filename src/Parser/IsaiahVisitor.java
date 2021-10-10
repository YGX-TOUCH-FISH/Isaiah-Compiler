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
	 * Visit a parse tree produced by the {@code emptyDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyDeclr(IsaiahParser.EmptyDeclrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclr(IsaiahParser.VarDeclrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclr(IsaiahParser.ClassDeclrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDeclr(IsaiahParser.FuncDeclrContext ctx);
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
	 * Visit a parse tree produced by the {@code variVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariVal(IsaiahParser.VariValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstVal(IsaiahParser.ConstValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewVal(IsaiahParser.NewValContext ctx);
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
	 * Visit a parse tree produced by {@link IsaiahParser#retType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetType(IsaiahParser.RetTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#varDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclare(IsaiahParser.VarDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#classDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclare(IsaiahParser.ClassDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#constructDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructDeclare(IsaiahParser.ConstructDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#funcDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDeclare(IsaiahParser.FuncDeclareContext ctx);
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
	 * Visit a parse tree produced by the {@code blkSuite}
	 * labeled alternative in {@link IsaiahParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlkSuite(IsaiahParser.BlkSuiteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code oneSuite}
	 * labeled alternative in {@link IsaiahParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOneSuite(IsaiahParser.OneSuiteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStmt(IsaiahParser.EmptyStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declrStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclrStmt(IsaiahParser.DeclrStmtContext ctx);
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
	 * Visit a parse tree produced by the {@code loopStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStmt(IsaiahParser.LoopStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jumpStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStmt(IsaiahParser.JumpStmtContext ctx);
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
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(IsaiahParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(IsaiahParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#constValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstValue(IsaiahParser.ConstValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newWrongArray}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewWrongArray(IsaiahParser.NewWrongArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArray(IsaiahParser.NewArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewClass(IsaiahParser.NewClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#lambdaFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaFunc(IsaiahParser.LambdaFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(IsaiahParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link IsaiahParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(IsaiahParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link IsaiahParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(IsaiahParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(IsaiahParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#jump}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump(IsaiahParser.JumpContext ctx);
}