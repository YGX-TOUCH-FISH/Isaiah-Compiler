package AST.Value;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import AST.Type.TypeNode;
import Util.position;

import java.util.ArrayList;

public class NewArrayNode extends ValueNode{
    public TypeNode baseType;
    public ArrayList<ExprNode> sizeofDim = new ArrayList<>();
    public int dims;
    public NewArrayNode(TypeNode _baseType, int _dims, position pos) {
        super(pos);
        baseType = _baseType;
        dims = _dims;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
