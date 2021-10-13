package AST.Type;

import AST.ASTVisitor;
import Util.position;

public class BoolTypeNode extends DigitTypeNode {
    public BoolTypeNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
