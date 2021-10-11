package AST.Value;

import AST.ASTVisitor;
import Util.position;

public class NullValNode extends ValueNode{
    public NullValNode(position pos) {
        super(pos);
    }
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
