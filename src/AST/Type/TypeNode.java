package AST.Type;

import AST.ASTNode;
import Util.Type;
import Util.position;

public abstract class TypeNode extends ASTNode {
    //
    public Type typeOfNode;
    public TypeNode(position pos) {
        super(pos);
    }
}
