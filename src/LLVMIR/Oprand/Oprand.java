package LLVMIR.Oprand;
// The more complex Mx* is, the larger file number will be.
import LLVMIR.Type.BaseType;

public abstract class Oprand {
    public BaseType type;
    public Oprand(BaseType _type) {
        type = _type;
    }
    public abstract String toString() ;
    public abstract String toName() ;
}
