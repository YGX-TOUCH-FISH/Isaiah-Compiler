package AST.Value;

import AST.ASTVisitor;
import AST.List.ExprListNode;
import AST.List.ParaListNode;
import Util.position;

public class FuncValNode extends ValueNode{
    public String name;
//    public ParaListNode paraList;
    public ExprListNode exprList;
    public FuncValNode(String _name, ExprListNode _exprList, position pos) {
        super(pos);
        name = _name;
        exprList = _exprList;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
