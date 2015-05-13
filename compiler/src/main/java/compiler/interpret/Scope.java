package compiler.interpret;

import compiler.node.*;

import java.util.HashMap;


public class Scope {
	private static int counter = 0;
	private int scopeNumber;
	private Scope parent;
	private HashMap<String, Type> variables = new HashMap<>();
	private boolean opened;

	public Scope(){
		this(null);
	}

	public Scope(Scope containing){
		this.parent = containing;
		this.scopeNumber = counter++;
		this.opened = true;
	}

	public void CloseScope(){
		this.opened = false;
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
			return parent.VarPrevDeclared(name);
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

	@Override
	public String toString(){
		String inf = "";
		String status = this.opened == true ? "open" : "closed";
		inf += "Scope " + this.scopeNumber + " - " + status;
		if(parent != null){
			inf += " (parent: " + parent.scopeNumber + ")";
		}
		else{
			inf += " (no parent)";
		}
		return inf;
	}
}

