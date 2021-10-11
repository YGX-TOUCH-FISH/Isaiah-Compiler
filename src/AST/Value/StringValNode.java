package AST.Value;

import AST.ASTVisitor;
import Util.position;

public class StringValNode extends ValueNode{
    public String value;
    public StringValNode(String _value, position pos) {
        super(pos);
        value = _value;
    }
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
