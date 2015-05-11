package compiler.interpret;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import compiler.node.*;

public class Typecheck{
	
	public static List<TypeExpression> TypeExpressions(PVariables check, LinkedList<PVariableTail> VariableTail)
	{
		List<TypeExpression> retType = new ArrayList<TypeExpression>();
			if(VariableTail.size() == 0)
			{
				String[] variables = check.toString().split(" ");
				if(variables[0].equals("grid"))
				{
					retType.add(new TypeExpression(null, Type.grid));
					return retType;
				}
				else if(variables.length == 1)
				{
					if(isNumeric(variables[0]))
					{
						retType.add(new TypeExpression(null, Type.number));
						return retType;
					}
					else if(variables[0] == "true" || variables[0] == "false")
					{
						retType.add(new TypeExpression(null, Type.bool));
						return retType;
					}
					else if(variables[0].startsWith("\"" ) && variables[0].endsWith("\""))
					{
						retType.add(new TypeExpression(null, Type.string));
						return retType;
					}
					else
					{
						retType.add(new TypeExpression(null, Type.variable));
						return retType;
					}
				}
				else if (variables.length == 3)
				{
					switch (variables[1])
					{
					case "+": retType.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.number));
							  retType.add(new TypeExpression(Arrays.asList(Type.string, Type.string),Type.string));
							  retType.add(new TypeExpression(Arrays.asList(Type.string, Type.number),Type.string));
							  retType.add(new TypeExpression(Arrays.asList(Type.number, Type.string),Type.string));
							  retType.add(new TypeExpression(Arrays.asList(Type.string, Type.bool),Type.string));
							  retType.add(new TypeExpression(Arrays.asList(Type.bool,   Type.string),Type.string));
							  break;
					
					case "-": retType.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.number));
					  		  break; 
						
					case "*": retType.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.number));
							  break;
					
					case "/": retType.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.number));
							  break;
					}
					//System.out.println(retType);
			  		return retType;
				}
				else
				{
					//flere operator
				}
			}
			else
			{
				//variabletail ????
			}
		return retType;
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public static Type typeChecker(List<TypeExpression> InputList, SymbolTable table, PVariables Variables)
	{
		Boolean typesafe = false;
		//System.out.println("TypeCheck : " + InputList + " : " + Variables);
		if(InputList.size() == 1)
		{
			TypeExpression Expression = InputList.get(0);
			if (Expression.getInput().size() == 0)
			{
				if(Expression.getOutput() != Type.variable)
				{
					return Expression.getOutput();
				}
				else
				{
					//retunerer typen af variablen
					return table.GetVariable(Variables.toString().toUpperCase().trim());
				}
			}
			else
			{
				String[] variables = Variables.toString().split(" ");
				//lave tjek om inputet er tilladt
				for(int i = 0; i < variables.length; i += 2)
				{
					String key = variables[i].toUpperCase().trim();
					//System.out.println(key);
					if(variables[i].equals("grid") && Expression.getInput().get(i/2) == Type.grid)
					{
						typesafe = true;
					}
					else if(isNumeric(variables[i]) && Expression.getInput().get(i/2) == Type.number)
					{
						typesafe = true;
					}
					else if((variables[i].startsWith("\"") && variables[i].endsWith("\"")) && Expression.getInput().get(i/2) == Type.string)
					{
						typesafe = true;
					}
					else if(table.GetVariable(key) != null)
					{
						if(table.GetVariable(key).equals(Expression.getInput().get(i/2)))
						{
							typesafe = true;
						}
						else
						{
							typesafe = false;
							break;
						}
					}
					else
					{
						typesafe = false;
						break;
					}
				}
				if(typesafe)
				{
					return Expression.getOutput();
				}	
			}
			return null;
			
		}
		else if(InputList.size() > 1)
		{
			List<Type> TypeList = new ArrayList<Type>();
			//System.out.println(InputList);
			for(int i = 0; i < InputList.size(); i++)
			{
				List<TypeExpression> Expression = new ArrayList<TypeExpression>();
				Expression.add(InputList.get(i));
				TypeList.add(typeChecker(Expression, table, Variables));
			}
			System.out.println(TypeList);
			TypeList.removeAll(Collections.singleton(null));
			if(TypeList.size() == 1)
			{
				return TypeList.get(0);
			}
			else
			{
				System.out.println("Type Error in " + Variables);
				System.exit(0);
			}
		}
		return null;
	}
}
