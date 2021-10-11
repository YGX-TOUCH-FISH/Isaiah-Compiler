package AST.Type;

import AST.ASTVisitor;
import Util.position;

public class StringTypeNode extends DigitTypeNode{
    public StringTypeNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
