package AST.Declare;

import AST.ASTVisitor;
import Util.position;

public class EmptyDeclrNode extends DeclrNode{
    public EmptyDeclrNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
