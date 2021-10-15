package AST.Type;

import AST.ASTVisitor;
import Util.error.semanticError;
import Util.position;

public class ArrayTypeNode extends TypeNode{
    //TODO  1 dimension
    //      2 baseType
    //
    public TypeNode baseType;
    public int dims;
    public ArrayTypeNode(TypeNode _baseType, position pos) {
        super(pos);
        if (_baseType instanceof ArrayTypeNode){
            baseType = ((ArrayTypeNode) _baseType).baseType;
            dims = ((ArrayTypeNode) _baseType).dims + 1;
        }
        else {
            baseType = _baseType;
            dims = 1;
        }
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
