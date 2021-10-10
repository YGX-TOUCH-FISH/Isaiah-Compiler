package AST.Value;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import AST.Type.TypeNode;
import Util.position;

import java.util.ArrayList;

public class NewValNode extends ValueNode{
    public TypeNode valType;
    public ArrayList<ExprNode> sizeofDim = new ArrayList<>();

    public NewValNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
