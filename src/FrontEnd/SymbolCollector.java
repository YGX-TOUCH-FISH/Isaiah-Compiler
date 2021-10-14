package FrontEnd;

import AST.ASTVisitor;
import AST.Declare.*;
import AST.Expr.*;
import AST.List.BlockNode;
import AST.List.ExprListNode;
import AST.List.ForInitNode;
import AST.List.ParaListNode;
import AST.RootNode;
import AST.Stmt.*;
import AST.Type.*;
import AST.Value.*;
import Util.FunctionDef;
import Util.Type;
import Util.error.semanticError;
import Util.scope.GlobalScope;
import Util.scope.Scope;

import java.util.ArrayList;

public class SymbolCollector implements ASTVisitor{
    public GlobalScope globalScope;
    public SymbolCollector(GlobalScope _globalScope) {
        globalScope = _globalScope;
    }

    @Override
    public void visit(RootNode node) {
        globalScope.addClassType("bool", node.pos);
        globalScope.addClassType("int", node.pos);
        globalScope.addClassType("string", node.pos);
        for (DeclrNode declare : node.declrs) {
            if (declare instanceof ClassDeclrNode) visit((ClassDeclrNode) declare);
            else if (declare instanceof FuncDeclrNode) visit((FuncDeclrNode) declare);
        }

        FunctionDef mainDef = new FunctionDef(new Type("int", 0), "main", null);
        if (!globalScope.containsFunc(mainDef))
            throw new semanticError("[ERROR]main function not found: ", node.pos);
    }

    @Override public void visit(ClassDeclrNode node) {
        globalScope.addClassType(node.name, node.pos);
    }

    @Override public void visit(FuncDeclrNode node) {
        TypeNode retNode = node.retType;
        Type retType;
        ArrayList<Type> paraType = new ArrayList<>();
        ArrayList<TypeNode> paraList = node.paraList.types;
        if (retNode instanceof ArrayTypeNode) {
            ArrayTypeNode array = (ArrayTypeNode) retNode;
            if (array.baseType instanceof BoolTypeNode)
                retType = new Type("bool", array.dims);
            else if (array.baseType instanceof StringTypeNode)
                retType = new Type("String", array.dims);
            else if (array.baseType instanceof IntTypeNode)
                retType = new Type("int", array.dims);
            else if (array.baseType instanceof VoidTypeNode)
                retType = new Type("void", array.dims);
            else if (array.baseType instanceof ClassTypeNode)
                retType = new Type(((ClassTypeNode) array.baseType).name, array.dims);
            else throw new semanticError("[ERROR]function definition of retType failed[1]: ", node.pos);
        }
        else {
            if (retNode instanceof BoolTypeNode)
                retType = new Type("bool", 0);
            else if (retNode instanceof StringTypeNode)
                retType = new Type("String", 0);
            else if (retNode instanceof IntTypeNode)
                retType = new Type("int", 0);
            else if (retNode instanceof VoidTypeNode)
                retType = new Type("void", 0);
            else if (retNode instanceof ClassTypeNode)
                retType = new Type(((ClassTypeNode) retNode).name, 0);
            else throw new semanticError("[ERROR]function definition of retType failed[2]: ", node.pos);
        }

        for (TypeNode varType : paraList) {
            if (varType instanceof ArrayTypeNode) {
                TypeNode varBaseType = ((ArrayTypeNode) varType).baseType;
                int dimension = ((ArrayTypeNode) varType).dims;

                if (varBaseType instanceof BoolTypeNode)
                    paraType.add(new Type("bool", dimension));
                else if (varBaseType instanceof StringTypeNode)
                    paraType.add(new Type("string", dimension));
                else if (varBaseType instanceof IntTypeNode)
                    paraType.add(new Type("int", dimension));
                else if (varBaseType instanceof ClassTypeNode)
                    paraType.add(new Type(((ClassTypeNode) varBaseType).name, dimension));
                else throw new semanticError("[ERROR]function definition of parameter failed[1]: ", node.pos);
            }
            else {
                if (varType instanceof BoolTypeNode)
                    paraType.add(new Type("bool", 0));
                else if (varType instanceof StringTypeNode)
                    paraType.add(new Type("string", 0));
                else if (varType instanceof IntTypeNode)
                    paraType.add(new Type("int", 0));
                else if (varType instanceof ClassTypeNode)
                    paraType.add(new Type(((ClassTypeNode) varType).name, 0));
                else throw new semanticError("[ERROR]function definition of parameter failed[2]: ", node.pos);
            }
        }
        FunctionDef funcDef = new FunctionDef(retType, node.name, paraType);
        globalScope.addFuncDef(funcDef, node.pos);
    }
    @Override public void visit(ConstructDeclrNode node) {}
    @Override public void visit(EmptyDeclrNode node) {}
    @Override public void visit(AssignDeclrNode node) {}
    @Override public void visit(ListDeclrNode node) {}
    @Override public void visit(VoidTypeNode node) {}
    @Override public void visit(BoolTypeNode node) {}
    @Override public void visit(IntTypeNode node) {}
    @Override public void visit(StringTypeNode node) {}
    @Override public void visit(ClassTypeNode node) {}
    @Override public void visit(DigitTypeNode node) {}
    @Override public void visit(ArrayTypeNode node) {}
    @Override public void visit(EmptyStNode node) {}
    @Override public void visit(AssignStNode node) {}
    @Override public void visit(ListStNode node) {}
    @Override public void visit(ExprStNode node) {}
    @Override public void visit(CondStNode node) {}
    @Override public void visit(ForStNode node) {}
    @Override public void visit(WhileStNode node) {}
    @Override public void visit(BreakStNode node) {}
    @Override public void visit(RetStNode node) {}
    @Override public void visit(ContinStNode node) {}
    @Override public void visit(BlockStNode node) {}
    @Override public void visit(ValueExprNode node) {}
    @Override public void visit(IndexExprNode node) {}
    @Override public void visit(UnaryExprNode node) {}
    @Override public void visit(BinaryExprNode node) {}
    @Override public void visit(PrefixExprNode node) {}
    @Override public void visit(SuffixExprNode node) {}
    @Override public void visit(ClassValNode node) {}
    @Override public void visit(IntValNode node) {}
    @Override public void visit(StringValNode node) {}
    @Override public void visit(BoolValNode node) {}
    @Override public void visit(NullValNode node) {}
    @Override public void visit(NewArrayNode node) {}
    @Override public void visit(FuncValNode node) {}
    @Override public void visit(LambdaValNode node) {}
    @Override public void visit(ThisValNode node) {}
    @Override public void visit(ParaListNode node) {}
    @Override public void visit(ExprListNode node) {}
    @Override public void visit(ForInitNode node) {}
    @Override public void visit(BlockNode node) {}
}
