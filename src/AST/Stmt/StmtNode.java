package AST.Stmt;

import AST.ASTNode;
import AST.ASTVisitor;
import Util.Type;
import Util.position;

public abstract class StmtNode extends ASTNode {
    public Type retType;
    public StmtNode(position pos) {
        super(pos);
        retType = new Type("null", 0);
    }
    abstract public void accept(ASTVisitor visitor);
}
