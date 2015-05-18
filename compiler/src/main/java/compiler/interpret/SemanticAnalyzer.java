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



}
