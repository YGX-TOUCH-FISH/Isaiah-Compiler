package AST.Value;

import AST.ASTVisitor;
import AST.List.ParaListNode;
import Util.position;

public class FuncValNode extends ValueNode{
    public String name;
    public ParaListNode paraList;
    public FuncValNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
