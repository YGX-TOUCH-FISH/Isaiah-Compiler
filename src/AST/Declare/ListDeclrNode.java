package AST.Declare;

import AST.ASTVisitor;
import AST.Type.TypeNode;
import Util.position;

import java.util.ArrayList;

public class ListDeclrNode extends DeclrNode{
    public TypeNode typeNode;
    public ArrayList<String> ids = new ArrayList<>();
    public ListDeclrNode(TypeNode _type, position pos) {
        super(pos);
        typeNode = _type;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}