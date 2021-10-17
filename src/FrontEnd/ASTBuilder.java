package FrontEnd;

import AST.ASTNode;
import AST.Declare.*;
import AST.Expr.*;
import AST.List.BlockNode;
import AST.List.ExprListNode;
import AST.List.ForInitNode;
import AST.List.ParaListNode;
import AST.RootNode;
import AST.Stmt.*;
import AST.Type.*;
import AST.Value.*;
import Parser.IsaiahBaseVisitor;
import Parser.IsaiahParser;
import Util.error.semanticError;
import Util.position;
import Util.scope.GlobalScope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ASTBuilder extends IsaiahBaseVisitor<ASTNode> {
    public GlobalScope globalScope;
    public ASTBuilder(GlobalScope _globalScope) {
        globalScope = _globalScope;
    }
    @Override public ASTNode visitProgram(IsaiahParser.ProgramContext ctx) {
        RootNode root = new RootNode(new position(ctx));
        if (ctx.declare() != null) {
            for (ParserRuleContext declr : ctx.declare()) {
                root.declrs.add((DeclrNode) visit(declr));
            }
        }
        else throw new semanticError("[ERROR]main function not found: ", new position(ctx));
        return root;
    }

    // TODO: 2021/10/11 package Declare
    @Override public ASTNode visitEmptyDeclare(IsaiahParser.EmptyDeclareContext ctx) {
        return new EmptyDeclrNode(new position(ctx));
    }
    @Override public ASTNode visitClassDeclare(IsaiahParser.ClassDeclareContext ctx) {
        String className = ctx.Identifier().toString();
        ClassDeclrNode node = new ClassDeclrNode(className, new position(ctx));
        if (ctx.declare() != null) {
            for (IsaiahParser.DeclareContext declr : ctx.declare())
                node.declrs.add((DeclrNode) visit(declr));
        }
        return node;
    }
    @Override public ASTNode visitFuncDeclare(IsaiahParser.FuncDeclareContext ctx) {
        TypeNode retType = (TypeNode) visit(ctx.retType());
        String funcName = ctx.Identifier().toString();
        ParaListNode paraList = (ParaListNode) visit(ctx.parameterList());
        BlockNode block = (BlockNode) visit(ctx.block());
        return new FuncDeclrNode(retType, funcName, paraList, block, new position(ctx));
    }
    @Override public ASTNode visitConstrDeclare(IsaiahParser.ConstrDeclareContext ctx) {
        String constructName = ctx.Identifier().toString();
        BlockNode block = (BlockNode) visit(ctx.block());
        return new ConstructDeclrNode(constructName, block, new position(ctx));
    }
    @Override public ASTNode visitAssignDeclare(IsaiahParser.AssignDeclareContext ctx) {
        TypeNode type = (TypeNode) visit(ctx.varType());
        String id = ctx.Identifier().toString();
        ExprNode value = (ExprNode) visit(ctx.expression());
        return new AssignDeclrNode(type, id, value, new position(ctx));
    }
    @Override public ASTNode visitListDeclare(IsaiahParser.ListDeclareContext ctx) {
        TypeNode type = (TypeNode) visit(ctx.varType());
        ListDeclrNode node = new ListDeclrNode(type, new position(ctx));
        for (TerminalNode id : ctx.Identifier())
            node.ids.add(id.toString());
        return node;
    }

    // TODO: 2021/10/11 package Type
    @Override public ASTNode visitRetType(IsaiahParser.RetTypeContext ctx) {
        if (ctx.varType() != null) return visit(ctx.varType());
        else if (ctx.Void() != null) return new VoidTypeNode(new position(ctx));
        else throw new semanticError("[ERROR]retType error:", new position(ctx));
    }
    @Override public ASTNode visitVarType(IsaiahParser.VarTypeContext ctx) {
        if (ctx.digitType() != null) return visit(ctx.digitType());
        else if (ctx.arrayType() != null)return visit(ctx.arrayType());
        else throw new semanticError("[ERROR]varType declaration lost: ", new position(ctx));
    }
    @Override public ASTNode visitDigitType(IsaiahParser.DigitTypeContext ctx) {
        position pos = new position(ctx);
        if (ctx.Bool() != null) return new BoolTypeNode(pos);
        else if (ctx.Int() != null) return new IntTypeNode(pos);
        else if (ctx.String() != null) return new StringTypeNode(pos);
        else if (ctx.Identifier() != null) return new ClassTypeNode(ctx.Identifier().toString(), pos);
        else throw new semanticError("[ERROR]visitDigitType error: ", pos);
    }
    @Override public ASTNode visitArrayType(IsaiahParser.ArrayTypeContext ctx) {
        TypeNode type;
        if (ctx.arrayType() != null)type = (TypeNode) visit(ctx.arrayType());
        else type = (TypeNode) visit(ctx.digitType());
        return new ArrayTypeNode(type, new position(ctx));
    }

    // TODO: 2021/10/11 package Expr
    @Override public ASTNode visitValueExpr(IsaiahParser.ValueExprContext ctx) {
        ValueNode value = (ValueNode) visit(ctx.value());
        return new ValueExprNode(value, new position(ctx));
    }
    @Override public ASTNode visitParenExpr(IsaiahParser.ParenExprContext ctx) {
        IsaiahParser.ExpressionContext expr = ctx.expression();
        return visit(ctx.expression());
    }
    @Override public ASTNode visitIndexExpr(IsaiahParser.IndexExprContext ctx) {
        ExprNode arrayName = (ExprNode) visit(ctx.expression(0));
        ExprNode arrayIndex = (ExprNode) visit(ctx.expression(1));
        return new IndexExprNode(arrayName, arrayIndex, new position(ctx));
    }
    @Override public ASTNode visitCallExpr(IsaiahParser.CallExprContext ctx) {
        ExprNode object = (ExprNode) visit(ctx.expression());
        String memberID = ctx.Identifier().toString();
        ExprListNode exprList = null;
        if (ctx.expressionList() != null)
            exprList = (ExprListNode) visit(ctx.expressionList());
        return new CallExprNode(object, memberID, exprList, new position(ctx));
    }
    @Override public ASTNode visitUnaryExpr(IsaiahParser.UnaryExprContext ctx) {
        ExprNode rhs = (ExprNode) visit(ctx.expression());
        UnaryExprNode.UnaryOp op;
        if (ctx.Not() != null) op = UnaryExprNode.UnaryOp.LNOT;
        else if (ctx.Tilde() != null) op = UnaryExprNode.UnaryOp.BNOT;
        else if (ctx.Plus() != null)  op = UnaryExprNode.UnaryOp.POS;
        else if (ctx.Minus() != null) op = UnaryExprNode.UnaryOp.NEG;
        else throw new semanticError("[ERROR]visitUnaryExpr error: " ,new position(ctx));
        return new UnaryExprNode(op,rhs, new position(ctx));
    }
    @Override public ASTNode visitBinaryExpr(IsaiahParser.BinaryExprContext ctx) {
        assert ctx.expression().size() == 2;
        ExprNode lhs = (ExprNode) visit(ctx.expression(0));
        ExprNode rhs = (ExprNode) visit(ctx.expression(1));
        BinaryExprNode.BinaryOp op;
//        if (ctx.Dot() != null) op = BinaryExprNode.BinaryOp.DOT;
        if (ctx.Mul() != null) op = BinaryExprNode.BinaryOp.MUL;
        else if (ctx.Div() != null) op = BinaryExprNode.BinaryOp.DIV;
        else if (ctx.Mod() != null) op = BinaryExprNode.BinaryOp.MOD;
        else if (ctx.Plus() != null)op = BinaryExprNode.BinaryOp.ADD;
        else if (ctx.Minus()!= null)op = BinaryExprNode.BinaryOp.SUB;
        else if (ctx.LeftShift() != null) op = BinaryExprNode.BinaryOp.LSH;
        else if (ctx.RightShift()!= null) op = BinaryExprNode.BinaryOp.RSH;
        else if (ctx.Less() != null)op = BinaryExprNode.BinaryOp.LT;
        else if (ctx.Greater() != null) op = BinaryExprNode.BinaryOp.GT;
        else if (ctx.LessEqual() != null) op = BinaryExprNode.BinaryOp.LEQ;
        else if (ctx.GreaterEqual() != null) op = BinaryExprNode.BinaryOp.GT;
        else if (ctx.Equal() != null) op = BinaryExprNode.BinaryOp.EQ;
        else if (ctx.NotEqual() != null) op = BinaryExprNode.BinaryOp.NEQ;
        else if (ctx.And() != null) op = BinaryExprNode.BinaryOp.AND;
        else if (ctx.Caret() != null) op = BinaryExprNode.BinaryOp.XOR;
        else if (ctx.Or() != null) op = BinaryExprNode.BinaryOp.OR;
        else if (ctx.AndAnd() != null) op = BinaryExprNode.BinaryOp.ANDAND;
        else if (ctx.OrOr() != null) op = BinaryExprNode.BinaryOp.OROR;
        else if (ctx.Assign() != null) op = BinaryExprNode.BinaryOp.ASSIGN;
        else throw new semanticError("[ERROR]visitBinaryExpr error: ", new position(ctx));
        return new BinaryExprNode(lhs, op, rhs, new position(ctx));
    }
    @Override public ASTNode visitSuffixExpr(IsaiahParser.SuffixExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expression());
        SuffixExprNode.SufOp op;
        if (ctx.SelfPlus() != null) op = SuffixExprNode.SufOp.INC;
        else if (ctx.SelfMinus() != null) op = SuffixExprNode.SufOp.DEC;
        else throw new semanticError("[ERROR]visitSuffixExpr error: ", new position(ctx));
        return new SuffixExprNode(lhs, op, new position(ctx));
    }
    @Override public ASTNode visitPrefixExpr(IsaiahParser.PrefixExprContext ctx) {
        ExprNode rhs = (ExprNode) visit(ctx.expression());
        PrefixExprNode.PreOp op;
        if (ctx.SelfPlus() != null) op = PrefixExprNode.PreOp.INC;
        else if (ctx.SelfMinus() != null) op = PrefixExprNode.PreOp.DEC;
        else throw new semanticError("[ERROR]visitPrefixExpr error: ", new position(ctx));
        return new PrefixExprNode(op, rhs, new position(ctx));
    }

    // TODO: 2021/10/11 package List
    @Override public ASTNode visitParameterList(IsaiahParser.ParameterListContext ctx) {
        ParaListNode node = new ParaListNode(new position(ctx));
        if (ctx.varType() != null) {
            for (IsaiahParser.VarTypeContext type : ctx.varType())
                node.para.add((TypeNode) visit(type));
            for (TerminalNode id : ctx.Identifier())
                node.ids.add(id.toString());
        }
        else assert ctx.Identifier() == null;
        return node;
    }
    @Override public ASTNode visitExpressionList(IsaiahParser.ExpressionListContext ctx) {
        ExprListNode node = new ExprListNode(new position(ctx));
        if (ctx.expression() != null) {
            for (IsaiahParser.ExpressionContext expr : ctx.expression())
                node.exprs.add((ExprNode) visit(expr));
        }
        return node;
    }
    @Override public ASTNode visitForInit(IsaiahParser.ForInitContext ctx) {
        ForInitNode node = new ForInitNode(new position(ctx));
        if (ctx.expression() != null) {
            for (IsaiahParser.ExpressionContext expr: ctx.expression())
                node.exprs.add((ExprNode) visit(expr));
        }
        return node;
    }
    @Override public ASTNode visitBlock(IsaiahParser.BlockContext ctx) {
        BlockNode node = new BlockNode(new position(ctx));
        if (ctx.statement() != null) {
            for (IsaiahParser.StatementContext stmt: ctx.statement())
                node.stmts.add((StmtNode) visit(stmt));
        }
        return node;
    }

    // TODO: 2021/10/11 package Stmt
    @Override public ASTNode visitEmptyStmt(IsaiahParser.EmptyStmtContext ctx) {
        return new EmptyStNode(new position(ctx));
    }
    @Override public ASTNode visitAssignStmt(IsaiahParser.AssignStmtContext ctx) {
        TypeNode type = (TypeNode) visit(ctx.varType());
        String name = ctx.Identifier().toString();
        ExprNode value = (ExprNode) visit(ctx.expression());
        return new AssignStNode(type, name, value, new position(ctx));
    }
    @Override public ASTNode visitListStmt(IsaiahParser.ListStmtContext ctx) {
        TypeNode type = (TypeNode) visit(ctx.varType());
        ListStNode node = new ListStNode(type, new position(ctx));
        for (TerminalNode id : ctx.Identifier())
            node.ids.add(id.toString());
        return node;
    }
    @Override public ASTNode visitExprStmt(IsaiahParser.ExprStmtContext ctx) {
        ExprNode expr = (ExprNode) visit(ctx.expression());
        return new ExprStNode(expr, new position(ctx));
    }
    @Override public ASTNode visitCondStmt(IsaiahParser.CondStmtContext ctx) {
        assert ctx.statement().size() < 2;
        ExprNode _cond = (ExprNode) visit(ctx.expression());
        StmtNode _if = (StmtNode) visit(ctx.statement(0));
        StmtNode _else;
        if (ctx.statement().size() == 1) _else = null;
        else _else = (StmtNode) visit(ctx.statement(1));
        return new CondStNode(_cond, _if, _else, new position(ctx));
    }
    @Override public ASTNode visitWhileStmt(IsaiahParser.WhileStmtContext ctx) {
        ExprNode _cond = (ExprNode) visit(ctx.expression());
        StmtNode _stmt = (StmtNode) visit(ctx.statement());
        return new WhileStNode(_cond, _stmt, new position(ctx));
    }
    @Override public ASTNode visitForStmt(IsaiahParser.ForStmtContext ctx) {
        // TODO: 2021/10/11 add ForInitNode
        int exprSize = ctx.expression().size();
        assert exprSize < 3;

        ForInitNode init = (ForInitNode) visit(ctx.forInit());
        ExprNode cond = null, incre = null;
        if (exprSize > 0) cond = (ExprNode) visit(ctx.expression(0));
        if (exprSize > 1) incre = (ExprNode) visit(ctx.expression(1));
        StmtNode stmt = (StmtNode) visit(ctx.statement());
        return new ForStNode(init, cond, incre, stmt, new position(ctx));
    }
    @Override public ASTNode visitRetStmt(IsaiahParser.RetStmtContext ctx) {
        if (ctx.expression() == null) return new RetStNode(null, new position(ctx));
        else return new RetStNode((ExprNode) visit(ctx.expression()), new position(ctx));
    }
    @Override public ASTNode visitBreakStmt(IsaiahParser.BreakStmtContext ctx) {
        return new BreakStNode(new position(ctx));
    }
    @Override public ASTNode visitContinStmt(IsaiahParser.ContinStmtContext ctx) {
        return new ContinStNode(new position(ctx));
    }
    @Override public ASTNode visitBlockStmt(IsaiahParser.BlockStmtContext ctx) {
        BlockNode block = (BlockNode) visit(ctx.block());
        return new BlockStNode(block, new position(ctx));
    }

    // TODO: 2021/10/11 package Value
    @Override public ASTNode visitVariVal(IsaiahParser.VariValContext ctx) {
        return new VariValNode(ctx.Identifier().toString(), new position(ctx));
    }
    @Override public ASTNode visitIntVal(IsaiahParser.IntValContext ctx) {
        String intStrVal = ctx.IntConst().toString();
        int value = Integer.parseInt(intStrVal);
        return new IntValNode(value, new position(ctx));
    }
    @Override public ASTNode visitStringVal(IsaiahParser.StringValContext ctx) {
        return new StringValNode(ctx.StringConst().toString(), new position(ctx));
    }
    @Override public ASTNode visitTrueVal(IsaiahParser.TrueValContext ctx) {
        return new BoolValNode(true, new position(ctx));
    }
    @Override public ASTNode visitFalseVal(IsaiahParser.FalseValContext ctx) {
        return new BoolValNode(false, new position(ctx));
    }
    @Override public ASTNode visitNullVal(IsaiahParser.NullValContext ctx) {
        return new NullValNode(new position(ctx));
    }
    @Override public ASTNode visitNewWrong2(IsaiahParser.NewWrong2Context ctx) {
        throw new semanticError("[ERROR]ArrayNew Wrong[2]: ", new position(ctx));
    }
    @Override public ASTNode visitNewWrong(IsaiahParser.NewWrongContext ctx) {
        throw new semanticError("[ERROR]ArrayNew Wrong[1]: ", new position(ctx));
    }
    @Override public ASTNode visitNewArray(IsaiahParser.NewArrayContext ctx) {
        // TODO: 2021/10/12 should be arrayType or digitType?
        TypeNode arrayType = (TypeNode) visit(ctx.digitType());
        assert (ctx.LeftBracket().size() == ctx.RightBracket().size());
        int dims = ctx.LeftBracket().size();
        NewArrayNode node = new NewArrayNode(arrayType, dims, new position(ctx));
        for (IsaiahParser.ExpressionContext expr: ctx.expression())
            node.sizeofDim.add((ExprNode) visit(expr));
        return node;
    }
    @Override public ASTNode visitNewClass(IsaiahParser.NewClassContext ctx) {
        return new VariValNode(ctx.Identifier().toString(), new position(ctx));
    }
    @Override public ASTNode visitFuncVal(IsaiahParser.FuncValContext ctx) {
        String name = ctx.Identifier().toString();
        ExprListNode exprList = (ExprListNode) visit(ctx.expressionList());
        return new FuncValNode(name, exprList, new position(ctx));
    }
    @Override public ASTNode visitLambdaVal(IsaiahParser.LambdaValContext ctx) {
        ParaListNode paraList = (ParaListNode) visit(ctx.parameterList());
        BlockNode block = (BlockNode) visit(ctx.block());
        ExprListNode exprList = (ExprListNode) visit(ctx.expressionList());
        return new LambdaValNode(paraList, block, exprList, new position(ctx));
    }
    @Override public ASTNode visitThisVal(IsaiahParser.ThisValContext ctx) {
        return new ThisValNode(new position(ctx));
    }
}

