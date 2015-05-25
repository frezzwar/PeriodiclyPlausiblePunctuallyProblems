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
        if(expresion.getClass() == ABooleanExpr.class)
        {
            ABooleanExpr expr = (ABooleanExpr) expresion;
            TypeExpression.add(new TypeExpression(parameters, Type.bool));
        }
        else if(expresion.getClass() == AValueExpr.class)
        {
            AValueExpr expr = (AValueExpr) expresion;
            TypeExpression.add(new TypeExpression(parameters, Typecheck.typeChecker(Typecheck.TypeExpressions(((AValueExpr) expresion).getValue().toString()), FunctionSymbolTable, ((AValueExpr) expresion).getValue().toString())));
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
                if (FunctionSymbolTable.VarPrevDeclared(variables[i].toUpperCase().trim()) && FunctionSymbolTable.GetVariable(variables[i].toUpperCase().trim()) == Type.parameter)
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
                    FunctionSymbolTable.ChangeType(variables[i].toUpperCase().trim(), type);
                }
            }


            for (int i = 0; i < TypeExpr.size(); i++)
            {
                TypeExpression.add(new TypeExpression(parameters, TypeExpr.get(i).getOutput()));
            }
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

        PParams params = node.getParams();
        String[] StringParams = params.toString().split(",");

        if (symbolTable.FuncPrevDeclared(key))
        {
            System.out.println("Function already defined: " + ident);
            System.exit(0);
        }
        FunctionSymbolTable.OpenScope();
        for (int i = 0; i < StringParams.length; i++)
        {
            FunctionSymbolTable.AddVariable(StringParams[i].toUpperCase().trim(), Type.parameter);
            parameters.add(FunctionSymbolTable.GetVariable(StringParams[i].toUpperCase().trim()));
        }
    }

    public void outAFuncDecl(AFuncDecl node)
    {
        String[] StringParams = node.getParams().toString().split(",");
        parameters.clear();
        for (int i = 0; i < StringParams.length; i++)
        {
            parameters.add(FunctionSymbolTable.GetVariable(StringParams[i].toUpperCase().trim()));
        }
        FunctionSymbolTable.CloseScope();
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
        symbolTable.AddFunction(node.getIdentifier().toString().toUpperCase().trim(), TypeExpression);
    }
}
