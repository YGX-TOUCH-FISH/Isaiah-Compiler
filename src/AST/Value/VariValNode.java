package AST.Value;

import AST.ASTVisitor;
import Util.position;

public class VariValNode extends ValueNode{
    public String name;
    //be null?
    public VariValNode(String _name, position pos) {
        super(pos);
        name = _name;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
