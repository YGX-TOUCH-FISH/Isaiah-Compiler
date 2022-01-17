package LLVMIR.Inst;

import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Pass;
import LLVMIR.Type.ArrayType;
import LLVMIR.Type.PointerType;

import java.util.ArrayList;

// dereference: load
public class GetElementPtrInst extends Inst{
    public VirtualReg resultReg;
    public Oprand     indexSrc;
    public ArrayList<Oprand> indexOffsets = new ArrayList<>();
    public GetElementPtrInst(VirtualReg _result, Oprand _indexSrc, ArrayList<Oprand> _indexOffsets) {
        resultReg   = _result;
        indexSrc    = _indexSrc;
        indexOffsets = _indexOffsets;
    }
    public GetElementPtrInst(VirtualReg _result, Oprand _indexSrc, Oprand indexOffset) {
        resultReg   = _result;
        indexSrc    = _indexSrc;
        indexOffsets.add(indexOffset);
    }
    @Override
    public String toString() {
        // indexSrc must be pointer type
        PointerType srcPointerType = (PointerType) indexSrc.baseType;
        StringBuilder ret = new StringBuilder(resultReg.toName()+" = getelementptr inbounds "+srcPointerType.referType.toString()+", "+indexSrc.toString()+", ");
        for (int i = 0 ; i < indexOffsets.size() ; i++) {
            ret.append(indexOffsets.get(i).toString());
            if (i != indexOffsets.size()-1) ret.append(", ");
        }
        return ret.toString();
    }
    @Override public void accept(Pass visitor) {visitor.visit(this);}
}
