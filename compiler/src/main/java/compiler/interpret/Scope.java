package compiler.interpret;

import compiler.node.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Scope {
	private Scope parent;
	private HashMap<String, Type> variables = new HashMap<>();

	public Scope(){
		this.parent = null;
	}

	public Scope(Scope containing){
		this.parent = containing;
	}
	
	public void AddVariable(String str, Type type){
		variables.put(str, type);
	}

	public void AddVariables(HashMap<String, Type> varCollection){
		variables.putAll(varCollection);
	}

	public boolean VarDeclaredInScope(String name){
		return variables.containsKey(name);
	}

	public boolean VarPrevDeclared(String name){
		if (this.VarDeclaredInScope(name)){
			return true;
		}
		else if (parent != null){
			parent.VarPrevDeclared(name);
		}
		return false;
	}

	public Type GetVariable(String name){
		return variables.get(name);
	}

	public HashMap<String, Type> GetAllVariables(){
		return variables;
	}

	public Scope Parent(){
		return parent;
	}

}
