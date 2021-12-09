package AST.Declare;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import AST.Type.TypeNode;
import Util.position;

public class AssignDeclrNode extends DeclrNode{
    public TypeNode typeNode;
    public String   id;
    public ExprNode valueNode;
    public AssignDeclrNode(TypeNode _type, String _id, ExprNode _value, position pos) {
        super(pos);
        typeNode = _type;
        id = _id;
        valueNode = _value;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
