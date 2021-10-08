// Generated from E:/SJTU/3CompilerWorkplace/src/Parser\Isaiah.g4 by ANTLR 4.9.1
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsaiahParser}.
 */
public interface IsaiahListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(IsaiahParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(IsaiahParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(IsaiahParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(IsaiahParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#digitType}.
	 * @param ctx the parse tree
	 */
	void enterDigitType(IsaiahParser.DigitTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#digitType}.
	 * @param ctx the parse tree
	 */
	void exitDigitType(IsaiahParser.DigitTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(IsaiahParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(IsaiahParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(IsaiahParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(IsaiahParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#varObj}.
	 * @param ctx the parse tree
	 */
	void enterVarObj(IsaiahParser.VarObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#varObj}.
	 * @param ctx the parse tree
	 */
	void exitVarObj(IsaiahParser.VarObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#retType}.
	 * @param ctx the parse tree
	 */
	void enterRetType(IsaiahParser.RetTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#retType}.
	 * @param ctx the parse tree
	 */
	void exitRetType(IsaiahParser.RetTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#varDeclare}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclare(IsaiahParser.VarDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#varDeclare}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclare(IsaiahParser.VarDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#initialPart}.
	 * @param ctx the parse tree
	 */
	void enterInitialPart(IsaiahParser.InitialPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#initialPart}.
	 * @param ctx the parse tree
	 */
	void exitInitialPart(IsaiahParser.InitialPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#classDeclare}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclare(IsaiahParser.ClassDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#classDeclare}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclare(IsaiahParser.ClassDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#classIdentity}.
	 * @param ctx the parse tree
	 */
	void enterClassIdentity(IsaiahParser.ClassIdentityContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#classIdentity}.
	 * @param ctx the parse tree
	 */
	void exitClassIdentity(IsaiahParser.ClassIdentityContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#constructDeclare}.
	 * @param ctx the parse tree
	 */
	void enterConstructDeclare(IsaiahParser.ConstructDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#constructDeclare}.
	 * @param ctx the parse tree
	 */
	void exitConstructDeclare(IsaiahParser.ConstructDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#funcDeclare}.
	 * @param ctx the parse tree
	 */
	void enterFuncDeclare(IsaiahParser.FuncDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#funcDeclare}.
	 * @param ctx the parse tree
	 */
	void exitFuncDeclare(IsaiahParser.FuncDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(IsaiahParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(IsaiahParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(IsaiahParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(IsaiahParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(IsaiahParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(IsaiahParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(IsaiahParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(IsaiahParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(IsaiahParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(IsaiahParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexExpr(IsaiahParser.IndexExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexExpr(IsaiahParser.IndexExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpr(IsaiahParser.ValueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpr(IsaiahParser.ValueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(IsaiahParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(IsaiahParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(IsaiahParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(IsaiahParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(IsaiahParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(IsaiahParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(IsaiahParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(IsaiahParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(IsaiahParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(IsaiahParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#constVal}.
	 * @param ctx the parse tree
	 */
	void enterConstVal(IsaiahParser.ConstValContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#constVal}.
	 * @param ctx the parse tree
	 */
	void exitConstVal(IsaiahParser.ConstValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code test3}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void enterTest3(IsaiahParser.Test3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code test3}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void exitTest3(IsaiahParser.Test3Context ctx);
	/**
	 * Enter a parse tree produced by the {@code test4}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void enterTest4(IsaiahParser.Test4Context ctx);
	/**
	 * Exit a parse tree produced by the {@code test4}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void exitTest4(IsaiahParser.Test4Context ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#lambdaFunc}.
	 * @param ctx the parse tree
	 */
	void enterLambdaFunc(IsaiahParser.LambdaFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#lambdaFunc}.
	 * @param ctx the parse tree
	 */
	void exitLambdaFunc(IsaiahParser.LambdaFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(IsaiahParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(IsaiahParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(IsaiahParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(IsaiahParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(IsaiahParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(IsaiahParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsaiahParser#jump}.
	 * @param ctx the parse tree
	 */
	void enterJump(IsaiahParser.JumpContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#jump}.
	 * @param ctx the parse tree
	 */
	void exitJump(IsaiahParser.JumpContext ctx);
}