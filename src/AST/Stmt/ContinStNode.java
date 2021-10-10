package AST.Stmt;

import AST.ASTVisitor;
import Util.position;

public class ContinStNode extends StmtNode{
    public ContinStNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
