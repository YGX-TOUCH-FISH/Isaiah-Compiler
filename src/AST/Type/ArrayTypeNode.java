package AST.Type;

import AST.ASTVisitor;
import Util.position;

public class ArrayTypeNode extends TypeNode{
    //TODO  1 dimension
    //      2 baseType
    //
    public TypeNode baseType;
    public int dims;
    public ArrayTypeNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
