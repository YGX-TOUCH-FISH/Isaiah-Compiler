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
	 * Enter a parse tree produced by the {@code emptyDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterEmptyDeclare(IsaiahParser.EmptyDeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitEmptyDeclare(IsaiahParser.EmptyDeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterAssignDeclare(IsaiahParser.AssignDeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitAssignDeclare(IsaiahParser.AssignDeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterListDeclare(IsaiahParser.ListDeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitListDeclare(IsaiahParser.ListDeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclare(IsaiahParser.ClassDeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclare(IsaiahParser.ClassDeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterFuncDeclare(IsaiahParser.FuncDeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcDeclare}
	 * labeled alternative in {@link IsaiahParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitFuncDeclare(IsaiahParser.FuncDeclareContext ctx);
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
	 * Enter a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIntVal(IsaiahParser.IntValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIntVal(IsaiahParser.IntValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterStringVal(IsaiahParser.StringValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitStringVal(IsaiahParser.StringValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterTrueVal(IsaiahParser.TrueValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitTrueVal(IsaiahParser.TrueValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFalseVal(IsaiahParser.FalseValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFalseVal(IsaiahParser.FalseValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNullVal(IsaiahParser.NullValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullVal}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNullVal(IsaiahParser.NullValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newWrong2}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNewWrong2(IsaiahParser.NewWrong2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code newWrong2}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNewWrong2(IsaiahParser.NewWrong2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code newWrong}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNewWrong(IsaiahParser.NewWrongContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newWrong}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNewWrong(IsaiahParser.NewWrongContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNewArray(IsaiahParser.NewArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArray}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNewArray(IsaiahParser.NewArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNewClass(IsaiahParser.NewClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link IsaiahParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNewClass(IsaiahParser.NewClassContext ctx);
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
	 * Enter a parse tree produced by the {@code assignStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(IsaiahParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(IsaiahParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterListStmt(IsaiahParser.ListStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitListStmt(IsaiahParser.ListStmtContext ctx);
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
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(IsaiahParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(IsaiahParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(IsaiahParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(IsaiahParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code retStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterRetStmt(IsaiahParser.RetStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code retStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitRetStmt(IsaiahParser.RetStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(IsaiahParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(IsaiahParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinStmt(IsaiahParser.ContinStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continStmt}
	 * labeled alternative in {@link IsaiahParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinStmt(IsaiahParser.ContinStmtContext ctx);
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
	 * Enter a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(IsaiahParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(IsaiahParser.PrefixExprContext ctx);
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
	 * Enter a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuffixExpr(IsaiahParser.SuffixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link IsaiahParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuffixExpr(IsaiahParser.SuffixExprContext ctx);
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
	 * Enter a parse tree produced by {@link IsaiahParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(IsaiahParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsaiahParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(IsaiahParser.ForInitContext ctx);
}