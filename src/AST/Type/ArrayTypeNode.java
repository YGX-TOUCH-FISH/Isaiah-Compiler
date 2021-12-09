package AST.Type;

import AST.ASTVisitor;
import Util.position;

public class ArrayTypeNode extends TypeNode{
    //TODO  1 dimension
    //      2 baseType
    //
    public TypeNode elementType;
    public int dims;
    public ArrayTypeNode(TypeNode _elementType, position pos) {
        super(pos);
        if (_elementType instanceof ArrayTypeNode){
            elementType = ((ArrayTypeNode) _elementType).elementType;
            dims = ((ArrayTypeNode) _elementType).dims + 1;
        }
        else {
            elementType = _elementType;
            dims = 1;
        }
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
