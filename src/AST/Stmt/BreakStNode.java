package AST.Stmt;

import AST.ASTVisitor;
import Util.position;

public class BreakStNode extends StmtNode{
    public BreakStNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
