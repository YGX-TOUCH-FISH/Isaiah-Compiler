package AST.List;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.Stmt.StmtNode;
import Util.position;

import java.util.ArrayList;

public class BlockNode extends ASTNode {
    public ArrayList<StmtNode> stmts = new ArrayList<>();
    public BlockNode (position pos)  {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
