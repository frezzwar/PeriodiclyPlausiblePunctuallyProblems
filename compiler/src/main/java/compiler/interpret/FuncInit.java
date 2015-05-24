package compiler.interpret;

import compiler.analysis.DepthFirstAdapter;
import compiler.node.AFuncDecl;


/**
 * Created by Kenneth on 23-05-2015.
 */
public class FuncInit extends DepthFirstAdapter {
    SymbolTable symTable;
    public FuncInit(SymbolTable symbolTable)
    {
        symTable = symbolTable;
    }
    public void inAFuncDecl(AFuncDecl node)
    {
        node.apply(new FunctionChecker(symTable));
    }
}
