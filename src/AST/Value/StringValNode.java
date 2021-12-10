package AST.Value;

import AST.ASTVisitor;
import Util.position;

public class StringValNode extends ValueNode{
    public String strValue;
    public StringValNode(String _value, position pos) {
        super(pos);
        strValue = _value;
    }
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
