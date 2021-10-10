package AST.Declare;

import AST.ASTVisitor;
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
    public BlockStNode block;
    public FuncDeclrNode(position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {visitor.visit(this);}
}
