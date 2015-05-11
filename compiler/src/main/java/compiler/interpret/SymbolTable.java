package compiler.interpret;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.Stack;

public class SymbolTable {
	//private HashMap<String, Type> types = new HashMap<>(); // OBSOLETE
	private Stack<Scope> scopes = new Stack<>();

	public SymbolTable(){
		scopes.push(new Scope());
	}

	public Scope CurrentScope(){
		if (scopes.isEmpty()){
			return null;
		}
		return scopes.peek();
	}
	
	public void OpenScope(){
		scopes.push(new Scope(CurrentScope()));
	}
	
	public void OpenScope(Scope containing){
		scopes.push(new Scope(containing));
	}

	public void CloseScope(){
		scopes.pop();
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
		else getVariable(scope.Parent(), name);

		return null;
	}

	@Override
	public String toString(){
		String st = "Symboltable:\n";
		if (scopes != null){
			for (Scope s : scopes){
				st += "____________________\n" + s.GetAllVariables().toString();
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
