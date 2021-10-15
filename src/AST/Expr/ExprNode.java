package AST.Expr;

import AST.ASTNode;
import AST.ASTVisitor;
import Util.Type;
import Util.position;

public abstract class ExprNode extends ASTNode {
    public ExprNode(position pos) {
        super(pos);
    }
    public enum Catagory{
        LVALUE, RVALUE,
    }
    public Catagory catagory;
    public Type type;
    abstract public void accept(ASTVisitor visitor);
}
