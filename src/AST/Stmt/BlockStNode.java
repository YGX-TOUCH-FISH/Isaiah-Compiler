package AST.Stmt;

import AST.ASTVisitor;
import AST.List.BlockNode;
import Util.position;

import java.util.ArrayList;

public class BlockStNode extends StmtNode{
    public BlockNode block;
    public BlockStNode(BlockNode _block, position pos) {
        super(pos);
        block = _block;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
