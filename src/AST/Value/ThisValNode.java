package AST.Value;

import AST.ASTVisitor;
import Util.position;

public class ThisValNode extends ValueNode{
    public ThisValNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
