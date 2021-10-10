package AST.Value;

import AST.ASTVisitor;
import AST.List.ExprListNode;
import AST.List.ParaListNode;
import AST.Stmt.BlockStNode;
import Util.position;

public class LambdaValNode extends ValueNode{
    public ParaListNode paraList;
    public BlockStNode block;
    public ExprListNode exprList;
    public LambdaValNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
