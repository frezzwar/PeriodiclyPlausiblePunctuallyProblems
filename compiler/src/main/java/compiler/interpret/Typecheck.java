package compiler.interpret;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import compiler.node.*;


public class Typecheck{
	
	public static List<TypeExpression> TypeExpressions(String check)
	{
		List<TypeExpression> retType = new LinkedList<TypeExpression>();
				String[] variables = check.split(" ");
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
					else if(variables[0].equals("true") || variables[0].equals("false"))
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

					case "==":retType.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.bool));
							  retType.add(new TypeExpression(Arrays.asList(Type.bool, Type.bool),Type.number));
							  retType.add(new TypeExpression(Arrays.asList(Type.string, Type.string),Type.number));
							  break;

					case "!=":retType.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.bool));
							  retType.add(new TypeExpression(Arrays.asList(Type.bool, Type.bool),Type.number));
							  retType.add(new TypeExpression(Arrays.asList(Type.string, Type.string),Type.number));
							  break;

					case "<": retType.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.bool));
							  retType.add(new TypeExpression(Arrays.asList(Type.string, Type.string),Type.number));
							  break;

					case ">": retType.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.bool));
							  retType.add(new TypeExpression(Arrays.asList(Type.string, Type.string),Type.number));
							  break;

					case "<=":retType.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.bool));
							  retType.add(new TypeExpression(Arrays.asList(Type.string, Type.string),Type.number));
							  break;

					case ">=":retType.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.bool));
							  retType.add(new TypeExpression(Arrays.asList(Type.string, Type.string),Type.number));
							  break;

					case "&&":retType.add(new TypeExpression(Arrays.asList(Type.bool, Type.bool),Type.bool));
							  break;

					case "||":retType.add(new TypeExpression(Arrays.asList(Type.bool, Type.bool),Type.bool));
							  break;

					}
					//System.out.println(retType);
			  		return retType;
				}
				else
				{
					for(int i = 0; i < variables.length; i++)
					{
						List<TypeExpression> TempExpression = new LinkedList<TypeExpression>();
						int priority = 0;
						switch (variables[i])
						{
							case "+": TempExpression.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.number));
									  TempExpression.add(new TypeExpression(Arrays.asList(Type.string, Type.string),Type.string));
								  	  TempExpression.add(new TypeExpression(Arrays.asList(Type.string, Type.number),Type.string));
									  TempExpression.add(new TypeExpression(Arrays.asList(Type.number, Type.string),Type.string));
									  TempExpression.add(new TypeExpression(Arrays.asList(Type.string, Type.bool),Type.string));
									  TempExpression.add(new TypeExpression(Arrays.asList(Type.bool,   Type.string),Type.string));
								      priority = 0;
								      break;

							case "-": TempExpression.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.number));
									  priority = 0;
									  break;

							case "*": TempExpression.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.number));
									  priority = 1;
									  break;

							case "/": TempExpression.add(new TypeExpression(Arrays.asList(Type.number, Type.number),Type.number));
									  priority = 1;
									  break;

							default:  break;
						}
						MultivariableList(retType, TempExpression, priority);
					}
				}
		return retType;
	}
	
	private static boolean isNumeric(String str)
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

	private static void MultivariableList(List<TypeExpression> ToList, List<TypeExpression> InputList, int priority)
	{
		List<TypeExpression> TempList = new LinkedList<>();
		List<Integer> RemoveList = new LinkedList<>();
		TempList.addAll(ToList);
		if(ToList.size() == 0 && InputList.size() != 0)
		{
			for(int i = 0; i < InputList.size(); i++)
			{
				TempList.add(InputList.get(i));
			}
		}
		else if(InputList.size() != 1 && InputList.size() != 0)
		{
			for(int i = 0; i < ToList.size(); i++)
			{
				for(int j = 0; j < InputList.size()-1; j++)
				{
					TypeExpression temp = ToList.get(i).Copy();
					TempList.add(i * InputList.size() + j, temp);
				}
			}
			for (int i = 0; i < TempList.size(); i++)
			{
				if (priority == 0)
				{
					if (TempList.get(i).getOutput() == InputList.get(i % InputList.size()).getInput().get(0))
					{
						TempList.get(i).Output(InputList.get(i % InputList.size()).getOutput());
						Type Temp = InputList.get(i % InputList.size()).getInput().get(1);
						TempList.get(i).Input(Temp);
					}
					else
					{
						RemoveList.add(i);
					}
				}
				else if (priority == 1)
				{
					if (TempList.get(i).getInput().get(TempList.size()-1) == InputList.get(i % InputList.size()).getOutput())
					{
						TempList.get(i).Output(InputList.get(i % InputList.size()).getOutput());
						TempList.get(i).getInput().remove(1);
						TempList.get(i).Input(InputList.get(i % InputList.size()).getInput().get(0));
						TempList.get(i).Input(InputList.get(i % InputList.size()).getInput().get(1));
					}
					else
					{
						RemoveList.add(i);
					}
				}
			}
		}
		else if (InputList.size() != 0)
		{
			for (int i = 0; i < TempList.size(); i++)
			{
				if (priority == 0)
				{
					if (TempList.get(i).getOutput() == InputList.get(i % InputList.size()).getInput().get(0))
					{
						TempList.get(i).Output(InputList.get(i % InputList.size()).getOutput());
						Type Temp = InputList.get(i % InputList.size()).getInput().get(1);
						TempList.get(i).getInput().add(Temp);
					}
					else
					{
						RemoveList.add(i);
					}
				}
				else if(priority == 1)
				{
					if (TempList.get(i).getInput().get(TempList.get(i).getInput().size()-1) == InputList.get(i % InputList.size()).getOutput())
					{
						TempList.get(i).Output(InputList.get(i % InputList.size()).getOutput());
						TempList.get(i).getInput().remove(1);
						TempList.get(i).Input(InputList.get(i % InputList.size()).getInput().get(0));
						TempList.get(i).Input(InputList.get(i % InputList.size()).getInput().get(1));
					}
					else
					{
						RemoveList.add(i);
					}
				}
			}
		}
		for (int i = RemoveList.size()-1; i >= 0; i--)
		{
			int Remove = RemoveList.get(i);
			TempList.remove(Remove);
		}
		ToList.clear();
		ToList.addAll(TempList);
		System.out.println(ToList);
	}
	
	public static Type typeChecker(List<TypeExpression> InputList, SymbolTable table, String Variables)
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
					return table.GetVariable(Variables.toUpperCase().trim());
				}
			}
			else
			{
				String[] variables = Variables.split(" ");
				//lave tjek om inputet er tilladt
				int expression = 0;
				for(int i = 0; i < variables.length; i += 2)
				{
					String key = variables[i].toUpperCase().trim();
					//System.out.println(key);
					if(variables[i].equals("grid") && Expression.getInput().get(expression) == Type.grid)
					{
						typesafe = true;
					}
					else if(isNumeric(variables[i]) && Expression.getInput().get(expression) == Type.number)
					{
						typesafe = true;
					}
					else if((variables[i].startsWith("\"") && variables[i].endsWith("\"")) && Expression.getInput().get(expression) == Type.string)
					{
						typesafe = true;
					}
					else if(table.GetVariable(key) != null)
					{
						if(table.GetVariable(key).equals(Expression.getInput().get(expression)))
						{
							typesafe = true;
						}
						else
						{
							typesafe = false;
							break;
						}
					}
					else if (variables[i].equals("+") || variables[i].equals("-") || variables[i].equals("*") || variables[i].equals("/") || variables[i].equals("==") || variables[i].equals("<=") || variables[i].equals(">=") || variables[i].equals("!=") || variables[i].equals("&&") || variables[i].equals("||") || variables[i].equals("<") || variables[i].equals(">") || variables[i].equals("(") || variables[i].equals(")"))
					{
						expression--;
					}
					else if (Expression.getInput().get(expression) == Type.parameter)
					{
						typesafe = true;
					}
					else
					{
						typesafe = false;
						break;
					}
					expression++;
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
			//System.out.println(TypeList);
			TypeList.removeAll(Collections.singleton(null));
			if(TypeList.size() == 1)
			{
				return TypeList.get(0);
			}
			else
			{
				Type type = null;
				for (int i = 0; i < TypeList.size(); i++)
				{
					if(TypeList.get(i) != null && type == null)
					{
						type = TypeList.get(i);
					}
					else if(TypeList.get(i) != null && type != type)
					{
						System.out.println("Type Error in " + Variables);
						System.exit(0);
					}
				}
				return type;
			}
		}
		return null;
	}

	public static List<TypeExpression> FunctionChecker()
	{
		return null;
	}
}
