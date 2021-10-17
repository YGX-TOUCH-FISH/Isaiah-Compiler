package AST.Expr;

import AST.ASTVisitor;
import AST.List.ExprListNode;
import Util.position;

public class CallExprNode extends ExprNode{
    public ExprNode object;
    public String memberID;
    public ExprListNode exprList;
    public CallExprNode(ExprNode _object, String _memberID, ExprListNode _exprList, position _pos) {
        super(_pos);
        object = _object;
        memberID = _memberID;
        exprList = _exprList;
    }
    public void accept(ASTVisitor visitor) {visitor.visit(this);}

}
