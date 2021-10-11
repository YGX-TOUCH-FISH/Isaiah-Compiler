package AST.Stmt;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import AST.List.ForInitNode;
import Util.position;

import java.util.ArrayList;

public class ForStNode extends StmtNode{
    //TODO: optimize
//    public ArrayList<ExprNode> init = new ArrayList<>();
    public ForInitNode init;
    public ExprNode condition;
    public ExprNode increment;
    public StmtNode stmt;
    public ForStNode(ForInitNode _init, ExprNode _cond, ExprNode _incre, StmtNode _stmt, position pos) {
        super(pos);
        init = _init;
        condition = _cond;
        increment = _incre;
        stmt = _stmt;
    }
    @Override
    public void accept(ASTVisitor visitor) { visitor.visit(this);}
}
