package AST.Value;

import AST.ASTVisitor;
import Util.position;

public class ConstValNode extends ValueNode{
    public int intVal;
    public String strVal;
    public boolean boolVal;
    public boolean nullVal;
    //true: null; false: non-null

    public ConstValNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}

}
