package AST.Expr;

import AST.ASTVisitor;
import Util.position;

public class IndexExprNode extends ExprNode{
    public ExprNode array;
    public ExprNode index;
    //TODO: recursion on left
    public IndexExprNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
