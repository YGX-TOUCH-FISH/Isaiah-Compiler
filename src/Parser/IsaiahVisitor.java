// Generated from E:/SJTU/3CompilerWorkplace/src\Isaiah.g4 by ANTLR 4.9.1
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
	 * Visit a parse tree produced by {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare(IsaiahParser.DeclareContext ctx);
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
	 * Visit a parse tree produced by {@link IsaiahParser#varObj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarObj(IsaiahParser.VarObjContext ctx);
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
	 * Visit a parse tree produced by {@link IsaiahParser#initialPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialPart(IsaiahParser.InitialPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#classDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclare(IsaiahParser.ClassDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#classIdentity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassIdentity(IsaiahParser.ClassIdentityContext ctx);
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
	 * Visit a parse tree produced by {@link IsaiahParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(IsaiahParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(IsaiahParser.StatementContext ctx);
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
	 * Visit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(IsaiahParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(IsaiahParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(IsaiahParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link IsaiahParser#constVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstVal(IsaiahParser.ConstValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code test1}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest1(IsaiahParser.Test1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code test2}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest2(IsaiahParser.Test2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code test3}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest3(IsaiahParser.Test3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code test4}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest4(IsaiahParser.Test4Context ctx);
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
	 * Visit a parse tree produced by {@link IsaiahParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(IsaiahParser.LoopContext ctx);
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