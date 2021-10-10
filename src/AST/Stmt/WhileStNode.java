package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Util.position;

import java.util.ArrayList;

public class WhileStNode extends StmtNode{
    public ExprNode condition;
    public ArrayList<StmtNode> stmts = new ArrayList<>();
    public WhileStNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) { visitor.visit(this);}
}
