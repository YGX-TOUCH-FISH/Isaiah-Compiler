package BackEnd;

import LLVMIR.*;
import LLVMIR.Inst.*;
import LLVMIR.Inst.Inst;
import LLVMIR.Oprand.ConstInt;
import LLVMIR.Oprand.ConstNull;
import LLVMIR.Oprand.Oprand;
import LLVMIR.Oprand.VirtualReg;
import LLVMIR.Type.BaseType;
import RISCV32.AsmBlock;
import RISCV32.AsmFunction;
import RISCV32.AsmModule;
import RISCV32.Inst.*;
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
        currentBlock  = currentFunction.getEntry();
        regAddress = new LinkedHashMap<>();
        frameAllocate(node);
        irBlock = node.entryBlock;
        while (irBlock != null) {
            irBlock.accept(this);
            irBlock = irBlock.next;
            blockMap.put(currentBlock.label, currentBlock);
            currentBlock.next = new AsmBlock(currentBlock, null, currentFunction.takeLabel());
            currentBlock = currentBlock.next;
        }
        root.textSection.add(new Pair<>(node.name, currentFunction));
        currentBlock = null;
        currentFunction = null;
    }

    @Override public void visit(BasicBlock node) {
        for (Inst inst = node.headInst ; inst != null ; inst = inst.next)
            inst.accept(this);
    }

    @Override public void visit(AllocaInst node) {
        spaceAllocate(node.allocReg);
    }

    @Override public void visit(BinaryInst node) {
        PhyReg rs1 = getCalleeSaveReg();
        PhyReg rs2 = getCalleeSaveReg();
        PhyReg rd  = getCalleeSaveReg();
        spaceAllocate(node.resultReg);
        if (node.lhs instanceof VirtualReg) {
            currentBlock.append(new Load(word, rs1, sp(), getRegFrameAddress((VirtualReg) node.lhs) ));
        } else currentBlock.append(new LoadImm(rs1, ((ConstInt) node.lhs).getIntValue()));

        if (node.rhs instanceof VirtualReg) {
            currentBlock.append(new Load(word, rs2, sp(), getRegFrameAddress((VirtualReg) node.rhs) ));
        } else currentBlock.append(new LoadImm(rs2, ((ConstInt) node.rhs).getIntValue()));

        RegBinary.RegOperator op = getRegOp(node.operator);
        currentBlock.append(new RegBinary(op, rd, rs1, rs2));
        currentBlock.append(new Store(word, rd, sp(), getRegFrameAddress(node.resultReg)));
        rs1.free();
        rs2.free();
        rd.free();
    }

    @Override public void visit(BitCastInst node) {
        PhyReg reg  = getCalleeSaveReg();
        spaceAllocate(node.destReg);
        currentBlock.append(new Load(word, reg, sp(), getRegFrameAddress(node.srcReg)));
        currentBlock.append(new Store(word, reg, sp(), getRegFrameAddress(node.destReg)));
        reg.free();
    }

    @Override public void visit(BrInst node) {
        Branch.condOperator op = irBlock.next == node.iftrue ? Branch.condOperator.beqz : Branch.condOperator.bnez;
        int target = irBlock.next == node.iftrue ? node.iffalse.label : node.iftrue.label;
        // next is true: [equal to zero](false) for jump
        PhyReg rs1 = getCalleeSaveReg();
        currentBlock.append(new Load(word, rs1, sp(), getRegFrameAddress((VirtualReg) node.cond)));
        currentBlock.append(new Branch(op, rs1, null, labelMap.get(target)));
        rs1.free();
    }

    @Override public void visit(CallInst node) {
        Oprand parameter;
        PhyReg a, s;
        long spilledOffset;
        for (int i = 0 ; i < node.inputArgs.size() ; i++) {
            parameter = node.inputArgs.get(i);
            if (i < 8) {
                a = phyRegs.get(parameterPRegNames[i]);
                if (parameter instanceof VirtualReg) {
                    currentBlock.append(new Load(word, a, sp(), getRegFrameAddress((VirtualReg) parameter)));
                } else currentBlock.append(new LoadImm(a, ((ConstInt) parameter).getIntValue()));
            }
            else {
                spilledOffset = (node.inputArgs.size()-i-1)* 4L;    // cast to long
                s = getCalleeSaveReg();
                if (parameter instanceof VirtualReg) {
                    currentBlock.append(new Load(word, s, sp(), getRegFrameAddress((VirtualReg) parameter)));
                } else currentBlock.append(new LoadImm(s, ((ConstInt) parameter).getIntValue()));

                currentBlock.append(new Store(word, s, sp(), spilledOffset));

                s.free();
            }
        }
        currentBlock.append(new Call(node.func.name));
        if (node.allocReg != null) {
            spaceAllocate(node.allocReg);
            currentBlock.append(new Store(word, phyRegs.get("a0"), sp(), getRegFrameAddress(node.allocReg)));
        }
    }

    @Override public void visit(GetElementPtrInst node) {
        // size == 2: offset[0] is 0
        if (!(node.indexSrc instanceof VirtualReg)) throw new RuntimeException("constant called gep instruction.");
        spaceAllocate(node.resultReg);
        PhyReg result    = getCalleeSaveReg();
        PhyReg baseAddr = getCalleeSaveReg();
        PhyReg reg1 = getCalleeSaveReg();
        PhyReg reg2 = getCalleeSaveReg();
        PhyReg reg3 = getCalleeSaveReg();
        PhyReg reg4 = getCalleeSaveReg();
        Oprand offset = node.indexOffsets.get(node.indexOffsets.size()-1);
        currentBlock.append(new Load(word, baseAddr, sp(), getRegFrameAddress((VirtualReg) node.indexSrc)));
        if (offset instanceof ConstInt) {
            long value = ((ConstInt)offset).getIntValue();
            currentBlock.append(new ImmBinary(ImmBinary.immOperator.addi, reg1, baseAddr, 4*value));
            currentBlock.append(new Load(word, result, reg1 , 0L));
        } else {
            currentBlock.append(new Load(word, reg1, sp(), getRegFrameAddress((VirtualReg) offset)));
            currentBlock.append(new ImmBinary(ImmBinary.immOperator.slli, reg2, reg1,2L));
            currentBlock.append(new RegBinary(RegBinary.RegOperator.add,  reg3, baseAddr, reg2));
            currentBlock.append(new Load(word, reg4, reg3, 0L));
        }
        currentBlock.append(new Store(word, result, sp(), getRegFrameAddress(node.resultReg)));
        result.free(); baseAddr.free(); reg1.free(); reg2.free(); reg3.free(); reg4.free();
    }

    @Override public void visit(IcmpInst node) {
        PhyReg reg1   = getCalleeSaveReg();
        PhyReg reg2   = getCalleeSaveReg();
        PhyReg reg3   = getCalleeSaveReg();
        PhyReg reg4   = getCalleeSaveReg();
        PhyReg result = getCalleeSaveReg();
        if (node.lhs instanceof VirtualReg) {
            currentBlock.append(new Load(word, reg1, sp(), getRegFrameAddress((VirtualReg) node.lhs)));
        } else currentBlock.append(new LoadImm(reg1, ((ConstInt) node.lhs).getIntValue()));
        if (node.rhs instanceof VirtualReg) {
            currentBlock.append(new Load(word, reg2, sp(), getRegFrameAddress((VirtualReg) node.rhs)));
        } else currentBlock.append(new LoadImm(reg2, ((ConstInt) node.rhs).getIntValue()));

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
        currentBlock.append(new Store(word, result, sp(), getRegFrameAddress(node.resultReg)));
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
        spaceAllocate(node.resultReg);
        PhyReg result = getCalleeSaveReg();
        PhyReg addr = getCalleeSaveReg();
        if (node.address.name != null) {
            currentBlock.append(new LoadAddr(addr, node.address.name));
        } else {
            currentBlock.append(new Load(word, addr, sp(), getRegFrameAddress(node.address)));
        }
        currentBlock.append(new Load(word, result, addr, 0L));
        currentBlock.append(new Store(word, result, sp(), getRegFrameAddress(node.resultReg)));
        result.free();
        addr.free();
    }

    @Override public void visit(PhiInst node) {
        Integer rootLabel  = labelMap.get(node.paths.get(0).b);
        Integer alterLabel = labelMap.get(node.paths.get(1).b);
        ConstInt rootValue = (ConstInt) node.paths.get(0).a;
        VirtualReg alterValue = (VirtualReg) node.paths.get(1).a;
        AsmBlock root = blockMap.get(rootLabel);
        AsmBlock alter = blockMap.get(alterLabel);
        if (!(root.tailInst instanceof Branch)) throw new RuntimeException("branch lost.");
        if (!(alter.tailInst instanceof Jump))  throw new RuntimeException("jump lost.");
        PhyReg result = getCalleeSaveReg();
        PhyReg value = getCalleeSaveReg();
        spaceAllocate(node.resultReg);
        ((PhyReg)root.tailInst.rs1).occupy();
        LoadImm rootInsert = new LoadImm(result, rootValue.getIntValue());
        root.tailInst.prev.next = rootInsert;
        rootInsert.prev = root.tailInst.prev;
        rootInsert.next = root.tailInst;
        root.tailInst.prev = rootInsert;
        Load alterInsert1 = new Load(word, value, sp(), getRegFrameAddress(alterValue));
        Move alterInsert2 = new Move(result, value);
        alter.tailInst.prev.next = alterInsert1;
        alterInsert1.prev = alter.tailInst.prev;
        alterInsert1.next = alterInsert2;
        alterInsert2.prev = alterInsert1;
        alterInsert2.next = alter.tailInst;
        alter.tailInst.prev = alterInsert2;
        currentBlock.append(new Store(word, result, sp(), getRegFrameAddress(node.resultReg)));
        ((PhyReg)root.tailInst.rs1).free();
    }

    @Override public void visit(RetInst node) {
        PhyReg a0 = phyRegs.get("a0");
        if (node.retValue != null) {
            if (node.retValue instanceof ConstNull) {
                currentBlock.append(new Move(a0, zero()));
            } else if (node.retValue instanceof ConstInt) {
                currentBlock.append(new LoadImm(a0, ((ConstInt) node.retValue).getIntValue()));
            } else {
                currentBlock.append(new Load(word, a0, sp(), getRegFrameAddress((VirtualReg) node.retValue)));
            }
        }
        regRelease();
        currentBlock.append(new ImmBinary(ImmBinary.immOperator.addi, sp(), sp(), spOffset));
        currentBlock.append(new Return());
    }

    @Override public void visit(StoreInst node) {
        PhyReg value  = getCalleeSaveReg();
        PhyReg target = getCalleeSaveReg();
        if (node.storeValue instanceof ConstInt) {
            currentBlock.append(new LoadImm(value, ((ConstInt)node.storeValue).getIntValue()));
        } else if (node.storeValue instanceof ConstNull) {
            currentBlock.append(new Move(value, zero()));
        } else {
            currentBlock.append(new Load(word, value, sp(), getRegFrameAddress((VirtualReg) node.storeValue)));
        }

        if (node.storeTarget.name != null) {
            currentBlock.append(new LoadAddr(target, node.storeTarget.name));
        } else {
            currentBlock.append(new Load(word, target, sp(), getRegFrameAddress(node.storeTarget)));
        }
        currentBlock.append(new Store(word, value, target, 0L));
        value.free();
        target.free();

    }

    private PhyReg ra() { return phyRegs.get("ra"); }
    private PhyReg sp() { return phyRegs.get("sp"); }
    private PhyReg zero() { return phyRegs.get("zero"); }

    private void frameAllocate(Function node) {
        int blockNumber = 0;
        irBlock = node.entryBlock;
        while (irBlock != null) {
            labelMap.put(irBlock.label, blockNumber);
            blockNumber++;
            irBlock = irBlock.next;
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
                currentBlock.append(new Store(word, p, sp(), getRegFrameAddress(arg)));
            }
            else {
                p = getCalleeSaveReg();
                currentBlock.append(new Load(word, p, sp(), spOffset + 4L*(i-8)));
                currentBlock.append(new Store(word, p, sp(), getRegFrameAddress(arg)));
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
    private long getRegFrameAddress(VirtualReg reg) {
        return regAddress.get(reg.label);
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
