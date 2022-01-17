package BackEnd;

import LLVMIR.*;
import LLVMIR.Inst.*;
import LLVMIR.Oprand.ConstInt;
import LLVMIR.Oprand.ConstNull;
import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import RISCV32.AsmBlock;
import RISCV32.AsmFunction;
import RISCV32.AsmModule;
import RISCV32.Inst.*;
import RISCV32.Inst.Inst;
import RISCV32.Oprand.PhyReg;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static RISCV32.Inst.StepWidth.word;

public class AsmBuilder implements Pass {
    AsmModule root = new AsmModule();
    public LinkedHashMap<String, PhyReg> phyRegs = new LinkedHashMap<>();

    public static final ArrayList<String> phyRegName = new ArrayList<>(Arrays.asList(
        "zero", "ra", "sp", "gp", "tp",
        "t0", "t1", "t2", "s0", "s1",
        "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7",
        "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11",
        "t3", "t4", "t5", "t6")
    );
    static public String[] calleeSavePRegNames = {
        "s0", "s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11"
    };
    static public String[] parameterPRegNames = {
        "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7"
    };

    AsmFunction currentFunction = null;
    AsmBlock    currentBlock    = null;
    BasicBlock  irBlock;
    HashMap<Integer, Integer> labelMap = new HashMap<>();
    HashMap<Integer, AsmBlock> blockMap = new HashMap<>();
    LinkedHashMap<Integer, Long> regAddress = new LinkedHashMap<>(); // virtual Reg -> offset of reg for every asmFunction

    long registerReserve = 0;
    long spOffset   = 0;

    public AsmBuilder() {
        for (String regName : phyRegName) phyRegs.put(regName, new PhyReg(regName));
    }

    public AsmModule BuiltRoot() {
        return root;
    }

    @Override public void visit(IRModule node) {
        root.bssSection.addAll(node.staticDataName);
        for (Pair<String, VirtualReg> pair : node.strConstants)
            root.rodataSection.add(new Pair<>(pair.b.name, pair.a));
        for (String name : node.customFunctionName)
            node.customFunctions.get(name).accept(this);
    }

    @Override public void visit(Function node) {
        currentFunction = new AsmFunction(node.name);
        currentBlock = null;
        regAddress = new LinkedHashMap<>();
        irBlock = node.entryBlock;
        while (irBlock != null) {
            if (currentBlock != null) {
                currentBlock.next = new AsmBlock(currentBlock, null, node.name, currentFunction.takeLabel());
                currentBlock = currentBlock.next;
            } else {
                currentBlock = currentFunction.getEntry();
                frameAllocate(node);
            }
            irBlock.accept(this);
            irBlock = irBlock.next;
            blockMap.put(currentBlock.label, currentBlock);
        }
        root.textSection.add(new Pair<>(node.name, currentFunction));
        currentBlock = null;
        currentFunction = null;
    }

    @Override public void visit(BasicBlock node) {
        for (LLVMIR.Inst.Inst inst = node.headInst; inst != null ; inst = inst.next)
            inst.accept(this);
    }

    @Override public void visit(AllocaInst node) {
        spaceAllocate(node.allocReg);
    }

    @Override public void visit(BinaryInst node) {
        PhyReg rs1 = getCalleeSaveReg();
        PhyReg rs2 = getCalleeSaveReg();
        PhyReg rd  = getCalleeSaveReg();
        getPReg(rs1, node.lhs);
        getPReg(rs2, node.rhs);
        RegBinary.RegOperator op = getRegOp(node.operator);
        currentBlock.append(new RegBinary(op, rd, rs1, rs2));
        spaceAllocate(node.resultReg);
        savePReg(rd, node.resultReg);
        rs1.free();
        rs2.free();
        rd.free();
    }

    @Override public void visit(BitCastInst node) {
        PhyReg reg = getCalleeSaveReg();
        getPReg(reg, node.srcReg);
        spaceAllocate(node.destReg);
        savePReg(reg, node.destReg);
        reg.free();
    }

    @Override public void visit(BrInst node) {
        Branch.condOperator op = irBlock.next == node.iftrue ? Branch.condOperator.beqz : Branch.condOperator.bnez;
        int target = irBlock.next == node.iftrue ? node.iffalse.label : node.iftrue.label;
        PhyReg rs1 = getCalleeSaveReg();
        getPReg(rs1, node.cond);
        currentBlock.append(new Branch(op, rs1, null, labelMap.get(target)));
        rs1.free();
    }

    @Override public void visit(CallInst node) {
        Oprand parameter;
        PhyReg reg;
        long spilledOffset;
        for (int i = 0 ; i < node.inputArgs.size() ; i++) {
            parameter = node.inputArgs.get(i);
            if (i < 8) {
                reg = phyRegs.get(parameterPRegNames[i]);
                getPReg(reg, parameter);
            }
            else {
                spilledOffset = (node.inputArgs.size()-i-1)* 4L;    // cast to long
                reg = getCalleeSaveReg();
                getPReg(reg, parameter);
                currentBlock.append(new Store(word, reg, sp(), spilledOffset));   // no possibility of 12-bit spill
                reg.free();
            }
        }
        currentBlock.append(new Call(node.func.name));
        if (node.allocReg != null) {
            spaceAllocate(node.allocReg);
            savePReg(phyRegs.get("a0"), node.allocReg);
        }
    }

    @Override public void visit(GetElementPtrInst node) {
        // size == 2: offset[0] is 0`
        if (!(node.indexSrc instanceof VirtualReg)) throw new RuntimeException("constant called gep instruction.");
        PhyReg result   = getCalleeSaveReg();
        PhyReg baseAddr = getCalleeSaveReg();
        PhyReg reg1 = getCalleeSaveReg();
        PhyReg reg2 = getCalleeSaveReg();
        PhyReg reg3 = getCalleeSaveReg();
        Oprand offset = node.indexOffsets.get(node.indexOffsets.size()-1);
        getPReg(baseAddr, node.indexSrc);
        if (offset instanceof ConstInt) {
            long value = ((ConstInt)offset).getIntValue();
            currentBlock.append(new LoadImm(reg1, 4*value));
            currentBlock.append(new RegBinary(RegBinary.RegOperator.add, reg2, baseAddr, reg1));
            currentBlock.append(new Load(word, result, reg2 , 0L));
        } else {
            getPReg(reg1, offset);
            currentBlock.append(new ImmBinary(ImmBinary.immOperator.slli, reg2, reg1,2L));
            currentBlock.append(new RegBinary(RegBinary.RegOperator.add,  reg3, baseAddr, reg2));
            currentBlock.append(new Load(word, result, reg3, 0L));
        }
        spaceAllocate(node.resultReg);
        savePReg(result, node.resultReg);
        result.free(); baseAddr.free(); reg1.free(); reg2.free(); reg3.free();
    }

    @Override public void visit(IcmpInst node) {
        PhyReg reg1   = getCalleeSaveReg();
        PhyReg reg2   = getCalleeSaveReg();
        PhyReg reg3   = getCalleeSaveReg();
        PhyReg reg4   = getCalleeSaveReg();
        PhyReg result = getCalleeSaveReg();
        getPReg(reg1, node.lhs);
        getPReg(reg2, node.rhs);
        currentBlock.append(new RegBinary(RegBinary.RegOperator.sub, reg3, reg1, reg2));
        if (node.cmpType == IcmpInst.CompareType.eq) {
            currentBlock.append(new Unary(Unary.UnaryOperator.seqz, result, reg3));
        } else if (node.cmpType == IcmpInst.CompareType.ne) {
            currentBlock.append(new Unary(Unary.UnaryOperator.snez, result, reg3));
        } else if (node.cmpType == IcmpInst.CompareType.sgt) {
            currentBlock.append(new Unary(Unary.UnaryOperator.sgtz, result, reg3));
        } else if (node.cmpType == IcmpInst.CompareType.slt) {
            currentBlock.append(new Unary(Unary.UnaryOperator.sltz, result, reg3));
        } else if (node.cmpType == IcmpInst.CompareType.sge) {
            currentBlock.append(new Unary(Unary.UnaryOperator.sltz, reg4, reg3));
            currentBlock.append(new Unary(Unary.UnaryOperator.snez, result, reg4));
        } else {
            currentBlock.append(new Unary(Unary.UnaryOperator.sgtz, reg4, reg3));
            currentBlock.append(new Unary(Unary.UnaryOperator.snez, result, reg4));
        }
        spaceAllocate(node.resultReg);
        savePReg(result, node.resultReg);
        reg1.free();
        reg2.free();
        reg3.free();
        reg4.free();
        result.free();
    }

    @Override public void visit(JumpInst node) {
        currentBlock.append(new Jump(labelMap.get(node.dest.label)));
    }

    @Override public void visit(LoadInst node) {
        PhyReg result = getCalleeSaveReg();
        PhyReg addr = getCalleeSaveReg();
        getPReg(addr, node.address);
        currentBlock.append(new Load(word, result, addr, 0L));
        spaceAllocate(node.resultReg);
        savePReg(result, node.resultReg);
        result.free();
        addr.free();
    }

    @Override public void visit(PhiInst node) {
        Integer rootLabel  = labelMap.get(node.paths.get(0).b);
        Integer alterLabel = labelMap.get(node.paths.get(1).b);
        ConstInt rootValue = (ConstInt) node.paths.get(0).a;
        VirtualReg alterValue = (VirtualReg) node.paths.get(1).a;
        AsmBlock rootBlock  = blockMap.get(rootLabel);
        AsmBlock alterBlock = blockMap.get(alterLabel);
        if (!(rootBlock.tailInst instanceof Branch)) throw new RuntimeException("root-block: branch lost.");
        if (!(alterBlock.tailInst instanceof Jump))  throw new RuntimeException("alter-block: jump lost.");
        ((PhyReg)rootBlock.tailInst.rs1).occupy();
        PhyReg result = getCalleeSaveReg();
        PhyReg offset = getCalleeSaveReg();
        PhyReg addr   = getCalleeSaveReg();
        LoadImm rootInsert = new LoadImm(result, rootValue.getIntValue());
        insertInst(rootInsert, rootBlock.tailInst);

        Inst alterInsert0 = new LoadImm(offset, regAddress.get(alterValue.label));
        Inst alterInsert1 = new RegBinary(RegBinary.RegOperator.add, addr, sp(), offset);
        Inst alterInsert2 = new Load(word, result, addr, 0L);
        insertInst(alterInsert0, alterBlock.tailInst);
        insertInst(alterInsert1, alterBlock.tailInst);
        insertInst(alterInsert2, alterBlock.tailInst);
        spaceAllocate(node.resultReg);
        savePReg(result, node.resultReg);
        ((PhyReg)rootBlock.tailInst.rs1).free();
        result.free();
        offset.free();
        addr.free();
    }

    @Override public void visit(RetInst node) {
        PhyReg a0 = phyRegs.get("a0");
        if (node.retValue != null) getPReg(a0, node.retValue);
        regRelease();
        currentBlock.append(new ImmBinary(ImmBinary.immOperator.addi, sp(), sp(), spOffset));
        currentBlock.append(new Return());
    }

    @Override public void visit(StoreInst node) {
        PhyReg value  = getCalleeSaveReg();
        PhyReg target = getCalleeSaveReg();
        getPReg(value, node.storeValue);
        getPReg(target, node.storeTarget);
        currentBlock.append(new Store(word, value, target, 0L));
        value.free();
        target.free();

    }

    private PhyReg ra() { return phyRegs.get("ra"); }
    private PhyReg sp() { return phyRegs.get("sp"); }
    private PhyReg zero() { return phyRegs.get("zero"); }

    private void frameAllocate(Function node) {
        int blockNumber = 0;
        BasicBlock BB = node.entryBlock;
        while (BB != null) {
            labelMap.put(BB.label, blockNumber);
            blockNumber++;
            BB = BB.next;
        }
        // block-tagged

        int pReg    = 13;
        int inPara  = node.args.size();
        int outPara = 0;
        int vReg    = node.getLabel()-blockNumber;
        long number = pReg + vReg + inPara + outPara;
        spOffset = number%4 == 0 ? 4*number : 16*(number/4 + 1);
        // get frame size

        currentBlock.append(new ImmBinary(ImmBinary.immOperator.addi, sp(), sp(), -spOffset));
        currentBlock.append(new Store(word, ra(), sp(), spOffset-4));
        int i = 2;
        for (String calleeSaveName : calleeSavePRegNames) {
            currentBlock.append(new Store(word, phyRegs.get(calleeSaveName), sp(), spOffset - 4L*i));
            i++;
        }
        registerReserve = 13;
        // ra & s0-s11

        for (i = 0 ; i < node.args.size() ; i++) {
            VirtualReg arg = node.args.get(i);
            PhyReg p;
            spaceAllocate(arg);
            if (i < 8) {
                p = phyRegs.get(parameterPRegNames[i]);
                savePReg(p, arg);
            }
            else {
                p = getCalleeSaveReg();
                currentBlock.append(new Load(word, p, sp(), spOffset + 4L*(i-8)));
                savePReg(p, arg);
                p.free();
            }
        }
        // parameter
    }

    private void regRelease() {
        long i = 2;
        for (String calleeSaveName : calleeSavePRegNames) {
            currentBlock.append(new Load(word, phyRegs.get(calleeSaveName), sp(), spOffset-4*i));
            i++;
        }
        currentBlock.append(new Load(word, ra(), sp(), spOffset-4));
    }

    private PhyReg getCalleeSaveReg() {
        for (String calleeSaveName : calleeSavePRegNames) {
            PhyReg s = phyRegs.get(calleeSaveName);
            if (!s.isBusy()) {
                s.occupy();
                return s;
            }
        }
        throw new RuntimeException("s-Registers all occupied.");
    }
    private void spaceAllocate (VirtualReg reg) {
        registerReserve++;
        regAddress.put(reg.label, spOffset - registerReserve *4);
    }

    private void getPReg(PhyReg p, Oprand o) {
        if (o instanceof VirtualReg) getPReg(p, (VirtualReg) o);
        else if (o instanceof ConstNull) getPReg(p);
        else getPReg(p, (ConstInt) o);
    }
    private void getPReg(PhyReg p, VirtualReg v) {
        if (v.name != null) currentBlock.append(new LoadAddr(p, v.name));
        else {
            PhyReg offset = getCalleeSaveReg();
            PhyReg addr = getCalleeSaveReg();
            currentBlock.append(new LoadImm(offset, regAddress.get(v.label)));
            currentBlock.append(new RegBinary(RegBinary.RegOperator.add, addr, sp(), offset));
            currentBlock.append(new Load(word, p, addr, 0L));
            offset.free();
            addr.free();
        }
    }
    private void getPReg(PhyReg p, ConstInt i) {
        currentBlock.append(new LoadImm(p, i.getIntValue()));
    }
    private void getPReg(PhyReg p) {
        currentBlock.append(new Move(p, zero()));
    }
    private void savePReg(PhyReg p, VirtualReg v) {
        PhyReg offset = getCalleeSaveReg();
        PhyReg addr = getCalleeSaveReg();
        currentBlock.append(new LoadImm(offset, regAddress.get(v.label)));
        currentBlock.append(new RegBinary(RegBinary.RegOperator.add, addr, sp(), offset));
        currentBlock.append(new Store(word, p, addr, 0L));
        offset.free();
        addr.free();
    }

    private void insertInst(Inst insert, Inst inst) {
        if (inst.prev != null ) inst.prev.next = insert;
        inst.prev = insert.prev;
        insert.next = inst;
        inst.prev = insert;
    }

    private RegBinary.RegOperator getRegOp(BinaryInst.BiArOp op) {
        switch (op) {
            case add: return RegBinary.RegOperator.add;
            case sub: return RegBinary.RegOperator.sub;
            case mul: return RegBinary.RegOperator.mul;
            case sdiv:return RegBinary.RegOperator.div;
            case srem:return RegBinary.RegOperator.rem;
            case shl: return RegBinary.RegOperator.sll;
            case ashr:return RegBinary.RegOperator.sra;
            case and: return RegBinary.RegOperator.and;
            case or:  return RegBinary.RegOperator.or;
            case xor: return RegBinary.RegOperator.xor;
        }
        throw new RuntimeException("unknown error");
    }
}
