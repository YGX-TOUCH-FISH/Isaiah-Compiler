package AST.Expr;

import AST.ASTVisitor;
import AST.Value.ValueNode;
import Util.position;

public class ValueExprNode extends ExprNode{
    public ValueNode valueNode;
    public ValueExprNode(ValueNode _value, position pos) {
        super(pos);
        valueNode = _value;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
