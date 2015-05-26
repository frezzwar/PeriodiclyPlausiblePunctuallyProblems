package compiler.interpret;

import compiler.analysis.DepthFirstAdapter;
import compiler.node.AFuncDecl;
import compiler.node.AObjectDecl;
import compiler.node.TIdentifier;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by Kenneth on 23-05-2015.
 */
public class FuncInit extends DepthFirstAdapter {
    SymbolTable symTable;
    public FuncInit(SymbolTable symbolTable)
    {
        symTable = symbolTable;
    }

    private boolean InObj = false;

    public void inAObjectDecl (AObjectDecl node)
    {
        InObj = true;
    }

    public void outAObjectDecl (AObjectDecl node)
    {
        InObj = false;
    }

    public void inAFuncDecl(AFuncDecl node)
    {
        if (!InObj)
        {
            TIdentifier ident = node.getIdentifier();
            String key = ident.toString().toUpperCase().trim();
            if (symTable.FuncPrevDeclared(key))
            {
                System.out.println("Function already defined: " + ident);
                System.exit(0);
            }
            List<TypeExpression> typeExpressions = new LinkedList<>();
            node.apply(new FunctionChecker(typeExpressions));
            symTable.AddFunction(node.getIdentifier().toString().toUpperCase().trim(), typeExpressions);
        }
    }
}
