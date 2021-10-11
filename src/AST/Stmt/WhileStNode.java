package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Util.position;

import java.util.ArrayList;

public class WhileStNode extends StmtNode{
    public ExprNode condition;
    public StmtNode stmt;
    public WhileStNode(ExprNode _cond, StmtNode _stmt, position pos) {
        super(pos);
        condition = _cond;
        stmt = _stmt;
    }
    @Override
    public void accept(ASTVisitor visitor) { visitor.visit(this);}
}
