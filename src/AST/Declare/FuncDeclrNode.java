package AST.Declare;

import AST.ASTVisitor;
import AST.List.BlockNode;
import AST.List.ParaListNode;
import AST.Stmt.BlockStNode;
import AST.Stmt.StmtNode;
import AST.Type.TypeNode;
import Util.position;

import java.util.ArrayList;

public class FuncDeclrNode extends DeclrNode{
    public TypeNode retType;
    public String name;
    public ParaListNode paraList;
    public BlockNode block;
    public FuncDeclrNode(TypeNode _type, String _name, ParaListNode _paraList, BlockNode _block, position pos) {
        super(pos);
        retType = _type;
        name = _name;
        paraList = _paraList;
        block = _block;
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
