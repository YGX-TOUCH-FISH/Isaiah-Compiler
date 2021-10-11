package AST.Declare;

import AST.ASTVisitor;
import AST.Stmt.BlockStNode;
import Util.position;

import java.util.ArrayList;

public class ClassDeclrNode extends DeclrNode{
    public String name;
    public ArrayList<DeclrNode> declrs = new ArrayList<>();
    public ClassDeclrNode(String _name, position pos) {
        super(pos);
        name = _name;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
