package compiler.interpret;
import compiler.node.*;
import compiler.analysis.*;
import compiler.interpret.Typecheck;
import org.sablecc.sablecc.node.TId;

import java.util.*;

public class SemanticAnalyzer extends DepthFirstAdapter {

	private SymbolTable symbolTable;

	public SemanticAnalyzer(SymbolTable symTable){
		this.symbolTable = symTable;
	}


	@Override
	public void outAVariableDecl(AVariableDecl node)
	{
		TIdentifier ident = node.getIdentifier();
		Type type = null;
		String key = ident.toString().toUpperCase().trim();
		if (node.getVariables().getClass() != AListVariables.class)
		{
			List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getVariables().toString());
			type = Typecheck.typeChecker(TypeExpression, symbolTable, node.getVariables().toString());
		}
		else
		{
			AListVariables listVariables = (AListVariables) node.getVariables();
			String[] temp = listVariables.getValue().toString().split(",");
			for (int i = 0; i < temp.length; i++)
			{
				if (type == null)
				{
					List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(temp[0].toString().trim());
					type = Typecheck.typeChecker(TypeExpression, symbolTable, temp[0].toString().trim());
				}
				else
				{
					List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(temp[i].toString().trim());
					if(type != Typecheck.typeChecker(TypeExpression, symbolTable, temp[i].toString().trim()))
					{
						System.out.println("Type Error" + node.getIdentifier());
					}
				}
			}
		}

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

	public void outAAssignExpr(AAssignExpr node)
	{
		PValue ident = node.getValue();
		if (ident.getClass() != AValueMemberValue.class)
		{
			String key = ident.toString().toUpperCase().trim();
			List<TypeExpression> TypeExpression = Typecheck.TypeExpressions(node.getExpr().toString());
			Type type = Typecheck.typeChecker(TypeExpression, symbolTable, node.getExpr().toString());

			if (symbolTable.VarPrevDeclared(key))
			{
				if (symbolTable.GetVariable(key) != type)
				{
					System.out.println(ident + "is of type " + symbolTable.GetVariable(key) + ", but you are trying to assign it a " + type);
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

	@Override
	public void outAParams(AParams node)
	{
		TIdentifier ident = node.getIdentifier();
		String key = ident.toString().toUpperCase().trim();
		
		if(symbolTable.VarDeclaredInCurrentScope(key))
		{
			System.out.println("Identifier already defined: " + ident);
			System.exit(0);
		}
		symbolTable.AddVariable(key, Type.parameter);
	}

	@Override
	public void outAParamsTail(AParamsTail node){
		TIdentifier ident = node.getIdentifier();
		String key = ident.toString().toUpperCase().trim();

		if (symbolTable.VarDeclaredInCurrentScope(key)){
			System.out.println("Identifier already defined: " + ident);
			System.exit(0);
		}
		symbolTable.AddVariable(key, Type.parameter);
	}

	@Override
	public void outAProgram(AProgram node)
	{
		//Temp: Printer symboltable for at se om det virker
		System.out.println(symbolTable.toString());
	}

	@Override
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
		String listKey = node.getList().toString().toUpperCase().trim();

		symbolTable.OpenScope();
		symbolTable.AddVariable(key, symbolTable.GetVariable(listKey));
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
}
