package AST.Type;

import AST.ASTVisitor;
import Util.position;

public class DigitTypeNode extends TypeNode{
    public DigitTypeNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
