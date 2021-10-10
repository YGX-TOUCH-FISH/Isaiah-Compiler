package AST.Type;

import AST.ASTVisitor;
import Util.Type;
import Util.position;

public class BoolTypeNode extends TypeNode{
    public BoolTypeNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
