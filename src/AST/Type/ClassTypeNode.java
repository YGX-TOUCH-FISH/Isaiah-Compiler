package AST.Type;

import AST.ASTVisitor;
import Util.position;

public class ClassTypeNode extends TypeNode{
    String name;
    public ClassTypeNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
