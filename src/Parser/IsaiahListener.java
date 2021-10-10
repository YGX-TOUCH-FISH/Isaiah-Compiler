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
	 * Enter a parse tree produced by the {@code emptyDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterEmptyDeclr(IsaiahParser.EmptyDeclrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitEmptyDeclr(IsaiahParser.EmptyDeclrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclr(IsaiahParser.VarDeclrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclr(IsaiahParser.VarDeclrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclr(IsaiahParser.ClassDeclrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclr(IsaiahParser.ClassDeclrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterFuncDeclr(IsaiahParser.FuncDeclrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcDeclr}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitFuncDeclr(IsaiahParser.FuncDeclrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constrDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterConstrDeclare(IsaiahParser.ConstrDeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constrDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitConstrDeclare(IsaiahParser.ConstrDeclareContext ctx);
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
	 * Enter a parse tree produced by the {@code variVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterVariVal(IsaiahParser.VariValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitVariVal(IsaiahParser.VariValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterConstVal(IsaiahParser.ConstValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitConstVal(IsaiahParser.ConstValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNewVal(IsaiahParser.NewValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNewVal(IsaiahParser.NewValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFuncVal(IsaiahParser.FuncValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFuncVal(IsaiahParser.FuncValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterLambdaVal(IsaiahParser.LambdaValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitLambdaVal(IsaiahParser.LambdaValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterThisVal(IsaiahParser.ThisValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitThisVal(IsaiahParser.ThisValContext ctx);
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
	 * Enter a parse tree produced by the {@code blkSuite}
	 * labeled alternative in {@link IsaiahParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterBlkSuite(IsaiahParser.BlkSuiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blkSuite}
	 * labeled alternative in {@link IsaiahParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitBlkSuite(IsaiahParser.BlkSuiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code oneSuite}
	 * labeled alternative in {@link IsaiahParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterOneSuite(IsaiahParser.OneSuiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code oneSuite}
	 * labeled alternative in {@link IsaiahParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitOneSuite(IsaiahParser.OneSuiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStmt(IsaiahParser.EmptyStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStmt(IsaiahParser.EmptyStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declrStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclrStmt(IsaiahParser.DeclrStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declrStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclrStmt(IsaiahParser.DeclrStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(IsaiahParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(IsaiahParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCondStmt(IsaiahParser.CondStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCondStmt(IsaiahParser.CondStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loopStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStmt(IsaiahParser.LoopStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loopStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStmt(IsaiahParser.LoopStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStmt(IsaiahParser.JumpStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStmt(IsaiahParser.JumpStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(IsaiahParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(IsaiahParser.BlockStmtContext ctx);
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
	 * Enter a parse tree produced by {@link IsaiahParser#constValue}.
	 * @param ctx the parse tree
	 */
	void enterConstValue(IsaiahParser.ConstValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#constValue}.
	 * @param ctx the parse tree
	 */
	void exitConstValue(IsaiahParser.ConstValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newWrongArray}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void enterNewWrongArray(IsaiahParser.NewWrongArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newWrongArray}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void exitNewWrongArray(IsaiahParser.NewWrongArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void enterNewArray(IsaiahParser.NewArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void exitNewArray(IsaiahParser.NewArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void enterNewClass(IsaiahParser.NewClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link IsaiahParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void exitNewClass(IsaiahParser.NewClassContext ctx);
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
	 * Enter a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link IsaiahParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(IsaiahParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link IsaiahParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(IsaiahParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link IsaiahParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(IsaiahParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link IsaiahParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(IsaiahParser.ForLoopContext ctx);
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