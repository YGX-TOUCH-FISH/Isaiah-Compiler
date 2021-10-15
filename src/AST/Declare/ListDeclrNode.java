package AST.Declare;

import AST.ASTVisitor;
import AST.Type.TypeNode;
import Util.position;

import java.util.ArrayList;

public class ListDeclrNode extends DeclrNode{
    public TypeNode type;
    public ArrayList<String> ids = new ArrayList<>();
    public ListDeclrNode(TypeNode _type, position pos) {
        super(pos);
        type = _type;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}