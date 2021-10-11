package AST.Declare;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import AST.Type.TypeNode;
import Util.position;

import java.util.ArrayList;

public class AssignDeclrNode extends DeclrNode{
    public TypeNode type;
    public String id;
    public ExprNode value;
    public AssignDeclrNode(TypeNode _type, String _id, ExprNode _value, position pos) {
        super(pos);
        type = _type;
        id = _id;
        value = _value;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
