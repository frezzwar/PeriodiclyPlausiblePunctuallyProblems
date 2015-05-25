package compiler.interpret;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SymbolTable {
	private HashMap<String, List<TypeExpression>> functions = new HashMap<>();
	private Stack<Scope> scopes = new Stack<>();
	private Scope currentScope = null;

	public SymbolTable(){
		this.OpenScope();
	}

	public void ChangeType(String key, Type type)
	{
		changeType(currentScope, key, type);
	}

	private void changeType(Scope scope, String key, Type type)
	{
		if (scope.GetVariable(key) != null){
			scope.ChangeVariable(key, type);
		}
		else if (scope.Parent() != null){
			changeType(scope.Parent(), key, type);
		}
	}

	public void AddFunction(String name, List<TypeExpression> inf){
		List<TypeExpression> temp = new LinkedList<>();
		for (int i = 0; i < inf.size(); i++)
		{
			temp.add(inf.get(i).Copy());
		}
		functions.put(name, temp);
	}

	public List<TypeExpression> GetFunction(String key)
	{
		if (functions.containsKey(key))
		{
			return functions.get(key);
		}
		else
		{
			return null;
		}
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
