package AST.Declare;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import AST.Type.TypeNode;
import Util.position;

import java.util.ArrayList;

public class VarDeclrNode extends DeclrNode{
    public TypeNode type;
    public ArrayList<String> ids = new ArrayList<>();
    public ArrayList<ExprNode> exprs = new ArrayList<>();
    public VarDeclrNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
