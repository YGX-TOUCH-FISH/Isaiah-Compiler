package AST.Value;

import AST.ASTVisitor;
import Util.position;

public class BoolValNode extends ValueNode{
    public boolean boolValue;
    public BoolValNode(boolean _value, position pos) {
        super(pos);
        boolValue = _value;
    }
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
