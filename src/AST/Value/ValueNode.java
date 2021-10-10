package AST.Value;

import AST.ASTNode;
import AST.ASTVisitor;
import Util.position;

public abstract class ValueNode extends ASTNode {
    public ValueNode(position pos) {
        super(pos);
    }
    abstract public void accept(ASTVisitor visitor);
}
