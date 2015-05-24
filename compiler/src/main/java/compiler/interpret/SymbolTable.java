package compiler.interpret;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class SymbolTable {
	private HashMap<String, List<TypeExpression>> functions = new HashMap<>();
	private Stack<Scope> scopes = new Stack<>();
	private Scope currentScope = null;

	public SymbolTable(){
		this.OpenScope();
	}

	public void AddFunction(String name, List<TypeExpression> inf){
		functions.put(name, inf);
	}


	public boolean FuncPrevDeclared(String name){
		return functions.containsKey(name);
	}

	public Scope CurrentScope(){
		return currentScope;
	}
	
	public void OpenScope(){
		scopes.push(new Scope(CurrentScope()));
		this.currentScope = scopes.peek();
	}
	
	public void OpenScope(Scope containing){
		scopes.push(new Scope(containing));
	}

	public void CloseScope(){
		//TODO		Keeping old scopes for overview, update later
		currentScope.CloseScope();
		currentScope = currentScope.Parent();
		//scopes.pop();
	}

	public void AddVariable(String name, Type type){
		CurrentScope().AddVariable(name, type);
	}

	public boolean VarDeclaredInCurrentScope(String name){
		return CurrentScope().VarDeclaredInScope(name);
	}

	public boolean VarPrevDeclared(String name){
		return CurrentScope().VarPrevDeclared(name);
	}

	public Type GetVariable(String name){
		return getVariable(CurrentScope(), name);
	}

	private Type getVariable(Scope scope, String name){
		if (scope.GetVariable(name) != null){
			return scope.GetVariable(name);
		}
		else if (scope.Parent() != null){
			return getVariable(scope.Parent(), name);
		}

		return null;
	}

	@Override
	public String toString(){
		String st = "\nSymboltable:\n";

		st += "Functions: " + functions.toString() + "\n";

		if (!scopes.empty()){
			for (Scope s : scopes){
				st += s.toString() + "\n" + s.GetAllVariables().toString() + "\n";
			}
		}
		return st;
	}

	/* OBSOLETE
	public void AddGlobalVar(String name, Type type){
		globalVariables.put(name, type);
	}
	*/
}
