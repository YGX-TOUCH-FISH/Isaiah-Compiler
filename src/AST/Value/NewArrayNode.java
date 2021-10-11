package AST.Value;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import AST.Type.TypeNode;
import Util.position;

import java.util.ArrayList;

public class NewArrayNode extends ValueNode{
    public TypeNode valType;
    public ArrayList<ExprNode> sizeofDim = new ArrayList<>();
    public int dims;
    public NewArrayNode(TypeNode _valType, int _dims, position pos) {
        super(pos);
        valType = _valType;
        dims = _dims;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
