package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import AST.Type.TypeNode;
import Util.position;

public class AssignStNode extends StmtNode{
    public TypeNode type;
    public String name;
    public ExprNode value;
    public AssignStNode(TypeNode _type, String _name, ExprNode _value, position pos) {
        super(pos);
        type = _type;
        name = _name;
        value = _value;
    }
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
