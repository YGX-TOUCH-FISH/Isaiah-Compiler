package AST.Value;

import AST.ASTVisitor;
import Util.position;

public class IntValNode extends ValueNode{
    public long intValue;

    public IntValNode(long _value, position pos) {
        super(pos);
        intValue = _value;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}

}
