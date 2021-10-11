package AST.Type;

import AST.ASTVisitor;
import Util.position;

public class ClassTypeNode extends DigitTypeNode{
    String name;
    public ClassTypeNode(String _name, position pos) {
        super(pos);
        name = _name;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
