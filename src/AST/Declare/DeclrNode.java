package AST.Declare;

import AST.ASTNode;
import AST.ASTVisitor;
import Util.position;

public abstract class DeclrNode extends ASTNode {
    public DeclrNode(position pos) {
        super(pos);
    }
}
