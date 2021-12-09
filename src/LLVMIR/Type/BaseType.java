package LLVMIR.Type;

import LLVMIR.Oprand.Oprand;

public abstract class BaseType {
    abstract public String toString() ;
    abstract public Oprand getZeroInit();
}
