package AST.Stmt;

import AST.ASTVisitor;
import Util.position;

import java.util.ArrayList;

public class BlockStNode extends StmtNode{
    public ArrayList<StmtNode> stmts = new ArrayList<>();
    public BlockStNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
