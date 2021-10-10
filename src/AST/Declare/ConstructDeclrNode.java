package AST.Declare;

import AST.ASTVisitor;
import AST.Stmt.BlockStNode;
import Util.position;

public class ConstructDeclrNode extends DeclrNode{
    public String name;
    public BlockStNode block;
    public ConstructDeclrNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
