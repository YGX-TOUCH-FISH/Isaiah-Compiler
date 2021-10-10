package AST.Stmt;

import AST.ASTVisitor;
import AST.Declare.VarDeclrNode;
import Util.position;

public class VarDeclrStNode extends StmtNode{
    public VarDeclrNode declr;
    public VarDeclrStNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
