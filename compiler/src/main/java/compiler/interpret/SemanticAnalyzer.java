package compiler.interpret;
import compiler.node.*;
import compiler.analysis.*;
import compiler.interpret.Typecheck;
import org.sablecc.sablecc.node.TId;

import java.util.*;

public class SemanticAnalyzer extends DepthFirstAdapter {

	SymbolTable symbolTable;

	public SemanticAnalyzer(SymbolTable symTable){
		this.symbolTable = symTable;
	}


	public void outAFuncDecl(AFuncDecl node)
	{
		System.out.println("-------------------------------------------------");
		for (int i = 0; i < node.getDecl().size(); i++)
		{
			System.out.println(node.getDecl().get(i).getClass());
		}
		System.out.println("-------------------------------------------------");
	}


	@Override
	public void outAVariableDeclaration(AVariableDeclaration node)
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
	public void inAFuncDecl(AFuncDecl node){
		TIdentifier ident = node.getIdentifier();

		String key = ident.toString().toUpperCase().trim();

		if (symbolTable.VarDeclaredInCurrentScope(key))
		{
			System.out.println("Identifier already defined: " + ident);
			System.exit(0);
		}
		symbolTable.AddVariable(key, Type.function);
		symbolTable.OpenScope();
	}
	/*
	// MUCH SHORTER, BUT CREATES PROBLEMS WITH ADDING PARAMETERS TO THE CORRECT SCOPE
	@Override
	public void inABody(ABody node){
		symbolTable.OpenScope();
	}

	@Override
	public void outABody(ABody node){
		symbolTable.CloseScope();
	}
	*/

	@Override
	public void inAIfstructureControlStatments(AIfstructureControlStatments node){
		symbolTable.OpenScope();
	}

	@Override
	public void outAIfstructureControlStatments(AIfstructureControlStatments node){
		symbolTable.CloseScope();
	}

	@Override
	public void inAElseElsestructure(AElseElsestructure node){
		symbolTable.OpenScope();
	}

	@Override
	public void outAElseElsestructure(AElseElsestructure node){
		symbolTable.CloseScope();
	}

	//TODO Statments -> Statement
	@Override
	public void inAForeachControlStatments(AForeachControlStatments node){
		TIdentifier ident = node.getIdentifier();
		String key = ident.toString().toUpperCase().trim();

		//TODO Foreach type
		symbolTable.OpenScope();
		symbolTable.AddVariable(key, Type.undefined);
	}

	@Override
	public void outAForeachControlStatments(AForeachControlStatments node){
		symbolTable.CloseScope();
	}

	@Override
	public void inARepeatControlStatments(ARepeatControlStatments node){
		symbolTable.OpenScope();
	}

	@Override
	public void outARepeatControlStatments(ARepeatControlStatments node){
		symbolTable.CloseScope();
	}

	@Override
	public void inAWhileControlStatments(AWhileControlStatments node){
		symbolTable.OpenScope();
	}

	@Override
	public void outAWhileControlStatments(AWhileControlStatments node){
		symbolTable.CloseScope();
	}

}
