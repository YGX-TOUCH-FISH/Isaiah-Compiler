package AST.Expr;

import AST.ASTVisitor;
import AST.Value.ValueNode;
import Util.position;

public class ValueExprNode extends ExprNode{
    public ValueNode value;
    public ValueExprNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
