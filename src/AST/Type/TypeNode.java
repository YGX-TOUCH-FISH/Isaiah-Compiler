package AST.Type;

import AST.ASTNode;
import LLVMIR.Type.BaseType;
import Util.Type;
import Util.position;

public abstract class TypeNode extends ASTNode {
    public Type typeOfNode;
    public BaseType baseType; //supporting IR
    public TypeNode(position pos) {
        super(pos);
    }
    public BaseType getBaseType() {
        return baseType;
    }
}
