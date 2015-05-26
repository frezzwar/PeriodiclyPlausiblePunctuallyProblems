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
    private SymbolTable SymbolTable = new SymbolTable();

    public FunctionChecker(SymbolTable symTable, List<TypeExpression> typeExpressions)
    {
        this.TypeExpression = typeExpressions;
    }

    public void outAVariableDecl(AVariableDecl node)
    {
        TIdentifier ident = node.getIdentifier();

        String key = ident.toString().toUpperCase().trim();

        List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getVariable().toString());
        Type type = Typecheck.typeChecker(TypeExpression, SymbolTable, node.getVariable().toString());

        if(SymbolTable.VarDeclaredInCurrentScope(key))
        {
            System.out.println("Identifier already defined: " + ident);
            System.exit(0);
        }
        else
        {
            SymbolTable.AddVariable(key, type);
        }
    }

    public void inAIfStmtControlStmt(AIfStmtControlStmt node){

        SymbolTable.OpenScope();
    }

    @Override
    public void outAIfStmtControlStmt(AIfStmtControlStmt node){
        SymbolTable.CloseScope();
    }

    @Override
    public void inAElseStmtElseStmt(AElseStmtElseStmt node){
        SymbolTable.OpenScope();
    }

    @Override
    public void outAElseStmtElseStmt(AElseStmtElseStmt node){
        SymbolTable.CloseScope();
    }

    @Override
    public void inAForeachControlStmt(AForeachControlStmt node){
        TIdentifier ident = node.getIdentifier();
        String key = ident.toString().toUpperCase().trim();
        String listKey = node.getList().toString().toUpperCase().trim();

        SymbolTable.OpenScope();
        SymbolTable.AddVariable(key, SymbolTable.GetVariable(listKey));
    }

    @Override
    public void outAForeachControlStmt(AForeachControlStmt node){
        SymbolTable.CloseScope();
    }

    @Override
    public void inARepeatControlStmt(ARepeatControlStmt node){
        SymbolTable.OpenScope();
    }

    @Override
    public void outARepeatControlStmt(ARepeatControlStmt node){
        SymbolTable.CloseScope();
    }

    @Override
    public void inAWhileControlStmt(AWhileControlStmt node){
        SymbolTable.OpenScope();
    }

    @Override
    public void outAWhileControlStmt(AWhileControlStmt node){
        SymbolTable.CloseScope();
    }

    @Override
    public void inAFuncCall(AFuncCall node){
        TIdentifier ident = node.getIdentifier();
        String key = ident.toString().toUpperCase().trim();

        if (!SymbolTable.FuncPrevDeclared(key)){
            System.out.println("Function not declared: " + ident.toString());
            System.exit(0);
        }
    }

    @Override
    public void inAGridDecl(AGridDecl node){
        String ident = node.getIdentifier().toString();
        String key = ident.toUpperCase().trim();
        if (SymbolTable.CurrentScope().VarDeclaredInScope(key)){
            System.out.println("Identifier already declared: " + ident);
            System.exit(0);
        }
        SymbolTable.AddVariable(key, Type.grid);
    }

    public void inAReturnValue(AReturnValue node)
    {
        PExpr expresion = node.getExpr();
        if(expresion.getClass() == ABooleanExpr.class)
        {
            ABooleanExpr expr = (ABooleanExpr) expresion;
            TypeExpression.add(new TypeExpression(parameters, Type.bool));
        }
        else if(expresion.getClass() == AValueExpr.class)
        {
            AValueExpr expr = (AValueExpr) expresion;
            TypeExpression.add(new TypeExpression(parameters, Typecheck.typeChecker(Typecheck.TypeExpressions(((AValueExpr) expresion).getValue().toString()), SymbolTable, ((AValueExpr) expresion).getValue().toString())));
        }
        else if(expresion.getClass() == ANumericExpr.class)
        {
            ANumericExpr expr = (ANumericExpr) expresion;
            List<TypeExpression> TypeExpr = Typecheck.TypeExpressions(expr.toString());

            String[] variables = expr.toString().split(" ");
            int ParameterNumber = 0;

            for (int i = 0; i < variables.length; i++)
            {
                Type type = null;
                if (SymbolTable.VarPrevDeclared(variables[i].toUpperCase().trim()) && SymbolTable.GetVariable(variables[i].toUpperCase().trim()) == Type.parameter)
                {
                    for (int j = 0; j < TypeExpr.size(); j++)
                    {

                        if (null != type)
                        {
                            if (type != TypeExpr.get(j).getInput().get(ParameterNumber))
                            {
                                type = null;
                            }
                        }
                        else
                        {
                            type = TypeExpr.get(j).getInput().get(ParameterNumber);
                        }
                    }
                }
                if (!variables[i].equals("+") && !variables[i].equals("-") && !variables[i].equals("*") && !variables[i].equals("/") && !variables[i].equals("(") && !variables[i].equals(")"))
                {
                    ParameterNumber++;
                }
                if (null != type)
                {
                    SymbolTable.ChangeType(variables[i].toUpperCase().trim(), type);
                }
            }


            for (int i = 0; i < TypeExpr.size(); i++)
            {
                TypeExpression.add(new TypeExpression(parameters, TypeExpr.get(i).getOutput()));
            }
        }
        /*
        else if(expresion.getClass() == AMinusvalueExpr.class)
        {
            AMinusvalueExpr expr = (AMinusvalueExpr) expresion;
            TypeExpression.add(new TypeExpression(parameters, FunctionSymbolTable.GetVariable(expr.getExpr().toString().toUpperCase().trim())));
        }*/


    }

    @Override
    public void inAFuncDecl(AFuncDecl node){
        PParams params = node.getParams();
        String[] StringParams = params.toString().split(",");

        SymbolTable.OpenScope();
        for (int i = 0; i < StringParams.length; i++)
        {
            SymbolTable.AddVariable(StringParams[i].toUpperCase().trim(), Type.parameter);
            parameters.add(SymbolTable.GetVariable(StringParams[i].toUpperCase().trim()));
        }
    }

    public void outAFuncDecl(AFuncDecl node)
    {
        String[] StringParams = node.getParams().toString().split(",");
        parameters.clear();
        for (int i = 0; i < StringParams.length; i++)
        {
            parameters.add(SymbolTable.GetVariable(StringParams[i].toUpperCase().trim()));
        }
        SymbolTable.CloseScope();
        Type type = null;

        for (int i = 0; i < TypeExpression.size(); i++)
        {
            if (null != type)
            {
                if (TypeExpression.get(i).getOutput() != type && TypeExpression.get(i).getOutput() != Type.parameter)
                {
                    System.out.println("Function " + node.getIdentifier() + "got more then 1 return type");
                    System.exit(0);
                }
                else if(null != type && TypeExpression.get(i).getOutput() == Type.parameter)
                {
                    TypeExpression.get(i).Output(type);
                }
            }
            else if(TypeExpression.get(i).getOutput() != Type.parameter)
            {
                type = TypeExpression.get(i).getOutput();
            }
        }
        List<TypeExpression> tempTypeExpression = new LinkedList<>();
        for (int i = 0; i < TypeExpression.size(); i++)
        {
            tempTypeExpression.add(new TypeExpression(parameters, TypeExpression.get(i).getOutput()));
        }
        TypeExpression.clear();
        TypeExpression.addAll(tempTypeExpression);
    }
}
