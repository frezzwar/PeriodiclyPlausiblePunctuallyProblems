package compiler.interpret;

import compiler.analysis.DepthFirstAdapter;
import compiler.node.AFuncDecl;
import compiler.node.TIdentifier;

/**
 * Created by Lasse on 15-05-2015.
 */
public class FunctionAnalyzer extends DepthFirstAdapter{
    private SymbolTable symTable;

    public FunctionAnalyzer(SymbolTable symtable){
        this.symTable = symtable;
    }

    @Override
    public void inAFuncDecl(AFuncDecl node){
        TIdentifier ident = node.getIdentifier();
        String key = ident.toString().toUpperCase().trim();
        FunctionInfo info = Typecheck.CheckFunctionTypes(node);

        if (symTable.FuncPrevDeclared(key)){
            System.out.println("Function previously declared: " + ident.toString());
            System.exit(0);
        }

        symTable.AddFunction(key, info);
    }
}
