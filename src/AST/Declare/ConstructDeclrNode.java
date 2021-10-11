package AST.Declare;

import AST.ASTVisitor;
import AST.List.BlockNode;
import AST.Stmt.BlockStNode;
import Util.position;

public class ConstructDeclrNode extends DeclrNode{
    public String name;
    public BlockNode block;
    public ConstructDeclrNode(String _name, BlockNode _block, position pos) {
        super(pos);
        name = _name;
        block = _block;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
