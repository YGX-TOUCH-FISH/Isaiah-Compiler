package AST.Value;

import AST.ASTVisitor;
import AST.List.BlockNode;
import AST.List.ExprListNode;
import AST.List.ParaListNode;
import AST.Stmt.BlockStNode;
import Util.position;

public class LambdaValNode extends ValueNode{
    public ParaListNode paraList;
    public BlockNode block;
    public ExprListNode exprList;
    public LambdaValNode(ParaListNode _paraList, BlockNode _block, ExprListNode _exprList, position pos) {
        super(pos);
        paraList = _paraList;
        block = _block;
        exprList = _exprList;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
