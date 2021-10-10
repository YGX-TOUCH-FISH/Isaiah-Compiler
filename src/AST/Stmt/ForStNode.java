package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Util.position;

import java.util.ArrayList;

public class ForStNode extends StmtNode{
    //TODO: optimize
    public ArrayList<ExprNode> init = new ArrayList<>();
    public ExprNode condition;
    public ExprNode increment;
    public ForStNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) { visitor.visit(this);}
}
