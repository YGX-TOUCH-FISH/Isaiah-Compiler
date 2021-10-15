package AST.Type;

import AST.ASTVisitor;
import Util.position;

public class IntTypeNode extends TypeNode{
    public IntTypeNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
