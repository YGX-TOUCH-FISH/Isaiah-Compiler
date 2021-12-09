package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import AST.Type.TypeNode;
import Util.position;

public class AssignStNode extends StmtNode{
    public TypeNode typeNode;
    public String name;
    public ExprNode valueNode;
    public AssignStNode(TypeNode _typeNode, String _name, ExprNode _valueNode, position pos) {
        super(pos);
        typeNode = _typeNode;
        name = _name;
        valueNode = _valueNode;
    }
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
