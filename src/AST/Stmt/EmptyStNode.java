package AST.Stmt;

import AST.ASTVisitor;
import Util.position;

public class EmptyStNode extends StmtNode{
    public EmptyStNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
