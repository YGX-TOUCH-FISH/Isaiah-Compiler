package AST.Expr;

import AST.ASTNode;
import AST.ASTVisitor;
import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import LLVMIR.Type.PointerType;
import Util.Type;
import Util.position;

public abstract class ExprNode extends ASTNode {
    public ExprNode(position pos) {
        super(pos);
    }
    public enum Catagory{
        LVALUE, RVALUE,
    }
    public Catagory catagory;
    public Type type;

    public VirtualReg address;  // only for lvalue
    public Oprand value;        // only for rvalue
    abstract public void accept(ASTVisitor visitor);
//    public BaseType getBaseType() {
//        return oprand.baseType;
//    }
    public boolean isLvalue() {
        return catagory == Catagory.LVALUE;
    }
    public BaseType getValueType() {    // get expr's value baseType
        if (catagory == Catagory.LVALUE) {
            return ((PointerType) address.baseType).referType;
        }
        else {
            return value.baseType;
        }
    }

}
