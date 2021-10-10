package AST.Declare;

import AST.ASTVisitor;
import AST.Stmt.BlockStNode;
import Util.position;

import java.util.ArrayList;

public class ClassDeclrNode extends DeclrNode{
    public String name;
    ArrayList<DeclrNode> declrs = new ArrayList<>();
    public ClassDeclrNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
