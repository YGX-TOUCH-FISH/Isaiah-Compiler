package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.ArrayType;
import LLVMIR.Type.PointerType;

// dereference: load
public class GetElementPtrInst extends Inst{
    VirtualReg resultReg;
    Oprand     indexSrc;
    Oprand     indexOffset;
    public GetElementPtrInst(VirtualReg _result, Oprand _indexSrc, Oprand _indexOffset) {
        resultReg   = _result;
        indexSrc    = _indexSrc;
        indexOffset = _indexOffset;
    }

    @Override
    public String toString() {
        // indexSrc must be pointer type
        PointerType srcPointerType = (PointerType) indexSrc.baseType;
        if (srcPointerType.referType instanceof ArrayType) {
            // 2 parameters: first: 0 offset from array pointer
            return resultReg.toName()+" = getelementptr inbounds "+srcPointerType.referType.toString()+", "+indexSrc.toString()+", i64 0, "+indexOffset.toString();
        }
        else {
            // simply pointer, 1 parameter to support offset
            return resultReg.toName()+" = getelementptr inbounds "+srcPointerType.referType.toString()+", "+indexSrc.toString()+", "+indexOffset.toString();
        }
    }
}
