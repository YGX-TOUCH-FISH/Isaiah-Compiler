package LLVMIR.Oprand;
// The more complex Mx* is, the larger file number will be.
import LLVMIR.Type.BaseType;

public abstract class Oprand {
    public BaseType baseType;
    public Oprand(BaseType _baseType) {
        baseType = _baseType;
    }
    public abstract String toString() ;
    public abstract String toName() ;
}
