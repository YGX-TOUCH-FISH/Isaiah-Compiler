package AST.Stmt;

import AST.ASTVisitor;
import AST.Type.TypeNode;
import Util.position;

import java.util.ArrayList;

public class ListStNode extends StmtNode{
    public TypeNode type;
    public ArrayList<String> ids = new ArrayList<>();
    public ListStNode(TypeNode _type, position pos) {
        super(pos);
        type = _type;
    }
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
