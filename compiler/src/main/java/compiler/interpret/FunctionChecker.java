package compiler.interpret;

import com.sun.org.apache.bcel.internal.generic.NEW;
import compiler.analysis.DepthFirstAdapter;
import compiler.node.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kenneth on 16-05-2015.
 */
public class FunctionChecker extends DepthFirstAdapter
{
    private List<TypeExpression> TypeExpression = new LinkedList<>();
    private List<Type> parameters = new LinkedList<>();
    private SymbolTable symbolTable;

    public FunctionChecker(SymbolTable symTable)
    {
        this.symbolTable = symTable;
    }

    public void outAVariableDecl(AVariableDecl node)
    {
        TIdentifier ident = node.getIdentifier();

        String key = ident.toString().toUpperCase().trim();

        List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getVariables());
        Type type = Typecheck.typeChecker(TypeExpression, symbolTable, node.getVariables());

        if(symbolTable.VarDeclaredInCurrentScope(key))
        {
            System.out.println("Identifier already defined: " + ident);
            System.exit(0);
        }
        else
        {
            symbolTable.AddVariable(key, type);
        }
    }

    public void outAVarname(AVarname node)
    {
        TIdentifier ident = node.getIdentifier();

        String key = ident.toString().toUpperCase().trim();
        if(!key.equals("GRID"))
        {
            if(!symbolTable.VarPrevDeclared(key))
            {
                System.out.println("Identifier not defined: " + ident);
                System.exit(0);
            }
        }
    }

    public void inAIfStmtControlStmt(AIfStmtControlStmt node){

        symbolTable.OpenScope();
    }

    @Override
    public void outAIfStmtControlStmt(AIfStmtControlStmt node){
        symbolTable.CloseScope();
    }

    @Override
    public void inAElseStmtElseStmt(AElseStmtElseStmt node){
        symbolTable.OpenScope();
    }

    @Override
    public void outAElseStmtElseStmt(AElseStmtElseStmt node){
        symbolTable.CloseScope();
    }

    @Override
    public void inAForeachControlStmt(AForeachControlStmt node){
        TIdentifier ident = node.getIdentifier();
        String key = ident.toString().toUpperCase().trim();

        //TODO Foreach type
        symbolTable.OpenScope();
        symbolTable.AddVariable(key, Type.undefined);
    }

    @Override
    public void outAForeachControlStmt(AForeachControlStmt node){
        symbolTable.CloseScope();
    }

    @Override
    public void inARepeatControlStmt(ARepeatControlStmt node){
        symbolTable.OpenScope();
    }

    @Override
    public void outARepeatControlStmt(ARepeatControlStmt node){
        symbolTable.CloseScope();
    }

    @Override
    public void inAWhileControlStmt(AWhileControlStmt node){
        symbolTable.OpenScope();
    }

    @Override
    public void outAWhileControlStmt(AWhileControlStmt node){
        symbolTable.CloseScope();
    }

    @Override
    public void inAFuncCall(AFuncCall node){
        TIdentifier ident = node.getIdentifier();
        String key = ident.toString().toUpperCase().trim();
        if (!symbolTable.FuncPrevDeclared(key)){
            System.out.println("Function not declared: " + ident.toString());
            System.exit(0);
        }
    }

    @Override
    public void inAGridDecl(AGridDecl node){
        String ident = node.getIdentifier().toString();
        String key = ident.toUpperCase().trim();
        if (symbolTable.CurrentScope().VarDeclaredInScope(key)){
            System.out.println("Identifier already declared: " + ident);
            System.exit(0);
        }
        symbolTable.AddVariable(key, Type.grid);
    }

    public void inAReturnValue(AReturnValue node)
    {
        PExpr expresion = node.getExpr();
        TypeExpression ReturnExpression;

        if(expresion.getClass() == AValueExpr.class)
        {
            AValueExpr expr = (AValueExpr) expresion;
            TypeExpression.add(new TypeExpression(parameters, symbolTable.GetVariable(expr.toString().toUpperCase().trim())));
        }
        else if(expresion.getClass() == ABooleanExpr.class)
        {
            ABooleanExpr expr = (ABooleanExpr) expresion;
            TypeExpression.add(new TypeExpression(parameters, Type.bool));
        }
        else if(expresion.getClass() == ANumericExpr.class)
        {
            ANumericExpr expr = (ANumericExpr) expresion;
            //Typecheck.TypeExpressions(expr.getValue().)
        }
        else if(expresion.getClass() == AMinusvalueExpr.class)
        {
            AMinusvalueExpr expr = (AMinusvalueExpr) expresion;
            //TypeExpression.add(new TypeExpression(parameters, symbolTable.GetVariable(expr.getExpr())))
        }
        System.out.println(TypeExpression);

    }

    @Override
    public void inAFuncDecl(AFuncDecl node){
        TIdentifier ident = node.getIdentifier();

        String key = ident.toString().toUpperCase().trim();

        if (symbolTable.VarDeclaredInCurrentScope(key))
        {
            System.out.println("Identifier already defined: " + ident);
            System.exit(0);
        }
        for (int i = 0; i < node.getParams().toString().split(",").length; i++)
        {
            parameters.add(Type.parameter);
        }
        symbolTable.AddFunction(key, new TypeExpression(null, Type.function));
        symbolTable.OpenScope();
    }

    public void outAFuncDecl(AFuncDecl node)
    {
        symbolTable.CloseScope();
    }
}
