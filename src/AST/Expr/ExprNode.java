package AST.Expr;

import AST.ASTNode;
import AST.ASTVisitor;
import Util.position;

public abstract class ExprNode extends ASTNode {
    public ExprNode(position pos) {
        super(pos);
    }
    abstract public void accept(ASTVisitor visitor);
}
