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
    private SymbolTable FunctionSymbolTable = new SymbolTable();

    public FunctionChecker(SymbolTable symTable)
    {
        this.symbolTable = symTable;
    }

    public void outAVariableDecl(AVariableDecl node)
    {
        TIdentifier ident = node.getIdentifier();

        String key = ident.toString().toUpperCase().trim();

        List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getVariables().toString());
        Type type = Typecheck.typeChecker(TypeExpression, FunctionSymbolTable, node.getVariables().toString());

        if(FunctionSymbolTable.VarDeclaredInCurrentScope(key))
        {
            System.out.println("Identifier already defined: " + ident);
            System.exit(0);
        }
        else
        {
            FunctionSymbolTable.AddVariable(key, type);
        }
    }

    public void inAIfStmtControlStmt(AIfStmtControlStmt node){

        FunctionSymbolTable.OpenScope();
    }

    @Override
    public void outAIfStmtControlStmt(AIfStmtControlStmt node){
        FunctionSymbolTable.CloseScope();
    }

    @Override
    public void inAElseStmtElseStmt(AElseStmtElseStmt node){
        FunctionSymbolTable.OpenScope();
    }

    @Override
    public void outAElseStmtElseStmt(AElseStmtElseStmt node){
        FunctionSymbolTable.CloseScope();
    }

    @Override
    public void inAForeachControlStmt(AForeachControlStmt node){
        TIdentifier ident = node.getIdentifier();
        String key = ident.toString().toUpperCase().trim();
        String listKey = node.getList().toString().toUpperCase().trim();

        FunctionSymbolTable.OpenScope();
        FunctionSymbolTable.AddVariable(key, FunctionSymbolTable.GetVariable(listKey));
    }

    @Override
    public void outAForeachControlStmt(AForeachControlStmt node){
        FunctionSymbolTable.CloseScope();
    }

    @Override
    public void inARepeatControlStmt(ARepeatControlStmt node){
        FunctionSymbolTable.OpenScope();
    }

    @Override
    public void outARepeatControlStmt(ARepeatControlStmt node){
        FunctionSymbolTable.CloseScope();
    }

    @Override
    public void inAWhileControlStmt(AWhileControlStmt node){
        FunctionSymbolTable.OpenScope();
    }

    @Override
    public void outAWhileControlStmt(AWhileControlStmt node){
        FunctionSymbolTable.CloseScope();
    }

    @Override
    public void inAFuncCall(AFuncCall node){
        TIdentifier ident = node.getIdentifier();
        String key = ident.toString().toUpperCase().trim();
        if (!FunctionSymbolTable.FuncPrevDeclared(key)){
            System.out.println("Function not declared: " + ident.toString());
            System.exit(0);
        }
    }

    @Override
    public void inAGridDecl(AGridDecl node){
        String ident = node.getIdentifier().toString();
        String key = ident.toUpperCase().trim();
        if (FunctionSymbolTable.CurrentScope().VarDeclaredInScope(key)){
            System.out.println("Identifier already declared: " + ident);
            System.exit(0);
        }
        FunctionSymbolTable.AddVariable(key, Type.grid);
    }

    public void outAAssignExpr(AAssignExpr node)
    {
        PValue ident = node.getValue();
        if (ident.getClass() != AValueMemberValue.class)
        {
            String key = ident.toString().toUpperCase().trim();
            List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getExpr().toString());
            Type type = Typecheck.typeChecker(TypeExpression, FunctionSymbolTable, node.getExpr().toString());

            if (FunctionSymbolTable.VarPrevDeclared(key))
            {
                if (FunctionSymbolTable.GetVariable(key) != type)
                {
                    System.out.println(ident + "is of type " + FunctionSymbolTable.GetVariable(key) + ", but you are trying to assign it a " + type);
                    System.exit(0);
                }
            }
        }
        else
        {
            AValueMemberValue member = (AValueMemberValue)ident;
            String key = member.getIdentifier().toString();
            //TODO figur typecheck

        }
    }


    public void inAReturnValue(AReturnValue node)
    {
        PExpr expresion = node.getExpr();

        if(expresion.getClass() == AValueExpr.class)
        {
            AValueExpr expr = (AValueExpr) expresion;
            TypeExpression.add(new TypeExpression(parameters, FunctionSymbolTable.GetVariable(expr.toString().toUpperCase().trim())));
        }
        else if(expresion.getClass() == ABooleanExpr.class)
        {
            ABooleanExpr expr = (ABooleanExpr) expresion;
            TypeExpression.add(new TypeExpression(parameters, Type.bool));
        }
        else if(expresion.getClass() == ANumericExpr.class)
        {
            ANumericExpr expr = (ANumericExpr) expresion;
            List<TypeExpression> TypeExpr = Typecheck.TypeExpressions(expr.toString());
            TypeExpression.addAll(TypeExpr);
        }
        else if(expresion.getClass() == AMinusvalueExpr.class)
        {
            AMinusvalueExpr expr = (AMinusvalueExpr) expresion;
            TypeExpression.add(new TypeExpression(parameters, FunctionSymbolTable.GetVariable(expr.getExpr().toString().toUpperCase().trim())));
        }


    }

    @Override
    public void inAFuncDecl(AFuncDecl node){
        TIdentifier ident = node.getIdentifier();

        String key = ident.toString().toUpperCase().trim();
        if (symbolTable.FuncPrevDeclared(key))
        {
            System.out.println("Function already defined: " + ident);
            System.exit(0);
        }
        for (int i = 0; i < node.getParams().toString().split(",").length; i++)
        {
            parameters.add(Type.parameter);
        }
        FunctionSymbolTable.OpenScope();
    }

    public void outAFuncDecl(AFuncDecl node)
    {
        FunctionSymbolTable.CloseScope();
        symbolTable.AddFunction(node.getIdentifier().toString().toUpperCase(), TypeExpression);
    }
}
