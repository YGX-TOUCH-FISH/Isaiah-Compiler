package AST.Value;

import AST.ASTVisitor;
import Util.position;

public class VariValNode extends ValueNode{
    public String name;
    public VariValNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
