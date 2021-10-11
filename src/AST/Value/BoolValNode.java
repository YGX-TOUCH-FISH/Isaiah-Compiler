package AST.Value;

import AST.ASTVisitor;
import Util.position;

public class BoolValNode extends ValueNode{
    boolean value;
    public BoolValNode(boolean _value, position pos) {
        super(pos);
        value = _value;
    }
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
