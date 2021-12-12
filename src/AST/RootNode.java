package AST;

import AST.Declare.DeclrNode;
import Util.position;
import java.util.ArrayList;

public class RootNode extends ASTNode{
    public ArrayList<DeclrNode> declrs = new ArrayList<DeclrNode>();
    public RootNode(position pos) {
        super(pos);
    }
    @Override public void accept(ASTVisitor visitor) { visitor.visit(this); }
}
