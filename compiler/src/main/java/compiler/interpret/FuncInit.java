package compiler.interpret;

import compiler.analysis.DepthFirstAdapter;
import compiler.node.AFuncDecl;
import compiler.node.AObjectDecl;
import compiler.node.TIdentifier;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Kenneth on 23-05-2015.
 */
public class FuncInit extends DepthFirstAdapter {
    SymbolTable symTable;

    public FuncInit(SymbolTable symbolTable) {
        symTable = symbolTable;
    }

    private boolean InObj = false;

    public void inAObjectDecl(AObjectDecl node) {
        InObj = true;
        String key = node.getId1().toString().toUpperCase().trim();

        if (symTable.FigureDeclared(key) || symTable.VarDeclaredInCurrentScope(key)) {
            System.out.println("Variable with name already declared: " + key);
            System.exit(0);
        }
        symTable.AddFigure(key);
        symTable.AddMethod(key, "MOVE", Arrays.asList(new TypeExpression(Arrays.asList(Type.parameter), Type.parameter)));
        //node.apply(new SemanticAnalyzer(symTable));
    }

    public void outAObjectDecl(AObjectDecl node) {
        InObj = false;
    }

    public void inAFuncDecl(AFuncDecl node) {
        if (!InObj) {
            TIdentifier ident = node.getIdentifier();
            String key = ident.toString().toUpperCase().trim();
            if (symTable.FuncPrevDeclared(key)) {
                System.out.println("Function already defined: " + ident);
                System.exit(0);
            }
            List<TypeExpression> typeExpressions = new LinkedList<>();
            node.apply(new FunctionChecker(typeExpressions));
            symTable.AddFunction(node.getIdentifier().toString().toUpperCase().trim(), typeExpressions);
        }
    }
}
