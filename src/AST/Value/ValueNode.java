package AST.Value;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.Expr.ExprNode;
import Util.Type;
import Util.position;

public abstract class ValueNode extends ASTNode {
    public Type type = null;
    public ExprNode.Catagory catagory;
    public ValueNode(position pos) {
        super(pos);
    }
    abstract public void accept(ASTVisitor visitor);
}
