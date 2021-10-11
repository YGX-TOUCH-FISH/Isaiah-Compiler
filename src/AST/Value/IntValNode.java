package AST.Value;

import AST.ASTVisitor;
import Util.position;

public class IntValNode extends ValueNode{
    public int value;

    public IntValNode(int _value, position pos) {
        super(pos);
        value = _value;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}

}
