package compiler.interpret;




import compiler.analysis.DepthFirstAdapter;
import compiler.node.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Formatter;

public class ClassGenerator extends DepthFirstAdapter
{
	private SymbolTable symbolTable;
	private static int SizeOfCell = 40;

	public ClassGenerator(SymbolTable sym){
		this.symbolTable = sym;
	}

	public void write(String output)
	{
		try{
			PrintWriter out
			   = new PrintWriter(new BufferedWriter(new FileWriter("out.js", true)));
			out.print(output);
			//System.out.print(output);
			out.close();
		}catch(Exception e)
		{
			System.out.println("File write error");
		}
	}
	String code = "";
	
	public void inAVariableDecl(AVariableDecl node)
	{
		code = "var " + node.getIdentifier() + node.getAssign() + node.getVariables() + ";\n";
		write(code);
	}
	
	public void inAAssignExpr(AAssignExpr node)
	{
		code = node.getValue().toString() + node.getAssign() + node.getExpr() + ";\n";
		write(code);

		// TODO -- WHAT'S THIS FOR?
		if(!node.parent().parent().getClass().toString().equals("class compiler.node.ABody"))
		{
			// Do nothing
		}
		
	}
	
	public void inAIfStmtControlStmt(AIfStmtControlStmt node)
	{
		code = node.getIf().toString() + "( ";
		write(code);
	}

	@Override
	public void inAElseStmtElseStmt(AElseStmtElseStmt node){
		code = node.getElse().toString();
		write(code);
	}

	@Override
	public void inABody(ABody node){
		if (node.parent().getClass() == AProgram.class){
			code = "function main()";
			write(code);
		}

		code = node.getCurlyL() + "\n";
		write(code);
	}

	@Override
	public void outABody(ABody node){
		code = node.getCurlyR() + "\n";
		write(code);
	}

	@Override
	public void inAFuncDecl(AFuncDecl node){
		code = "function " + node.getIdentifier() + node.getParL();
		write(code);
	}

	@Override
	public void outAFuncDecl(AFuncDecl node){
		code = "}";
		write(code);
	}

	@Override
	public void inAParams(AParams node){
		code = node.getIdentifier().toString();
		write(code);
	}

	@Override
	public void inAParamsTail(AParamsTail node){
		code = node.getComma().toString() + node.getIdentifier().toString();
		write(code);
	}

	@Override
	public void outAParams(AParams node){
		code = "){\n";
		write(code);
	}

	@Override
	public void inAForeachControlStmt(AForeachControlStmt node){
		code = "for ( " + node.getIdentifier() + "of " + node.getVarname() + ")";
		write(code);
	}

	@Override
	public void inAWhileControlStmt(AWhileControlStmt node){
		code = "while " + node.getParL();
		write(code);
	}

	// TODO FIX NESTED REPEATS, NOT WORKING PROPERLY
	private static String counter = "i";
	@Override
	public void inARepeatControlStmt(ARepeatControlStmt node){
		if (node.parent().getClass() == AControlStmtDecl.class){
			AControlStmtDecl temp = (AControlStmtDecl)node.parent();
			if (temp.getControlStmt().getClass() == ARepeatControlStmt.class){
				counter += "i";
			}

		}
		code = "for (" + counter + " = 1; " + counter +" <= "
				+ node.getValue() + "; "+ counter + "++)";
		write(code);
	}


	@Override
	public void inABooleanExpr(ABooleanExpr node){
		if (node.parent().getClass() != AExprVariables.class){
			code = node.toString();
			write(code);
		}
	}

	@Override
	public void outABooleanExpr(ABooleanExpr node){
		if (node.parent().getClass() != AExprVariables.class){
			code = ")";
			write(code);
		}
	}

	@Override
	public void inAGridDecl(AGridDecl node){
		String ident = node.getIdentifier().toString();
		String width = node.getInt1().toString();
		String height = node.getInt2().toString();
		String temp = "var " + ident + "= new Array(" + width + ");\n" +
				"for (var i = 0; i < " + width + "; i++){\n  " +
				ident + "[i] = new Array(" + height + ");\n}\n";

		code = temp;

		try{
			int w = Integer.parseInt(width.trim()) * SizeOfCell;
			int h = Integer.parseInt(height.trim()) * SizeOfCell;
			code += CreateHtmlCanvas(w, h);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}

		write(code);
	}

	private String CreateHtmlCanvas(int width, int height){
		String str = "// Creates HTML Canvas\n" +
		"var canvas = document.createElement(\"canvas\");\n" +
		"var ctx = canvas.getContext(\"2d\");\n" +
		"canvas.width = " + width +";\n" +
		"canvas.height = " + height + ";\n" +
		"document.body.appendChild(canvas);\n\n";

		return str;
	}

	@Override
	public void inAProgram(AProgram node){
		// Nothing here yet...

	}

	@Override
	public void inADotMember(ADotMember node){
		String ident = node.getIdentifier().toString();
		String key = ident.toUpperCase().trim();
		if (node.parent().getClass() == AVarname.class){
			AVarname temp = (AVarname) node.parent();
			String temp_ident = temp.getIdentifier().toString();
			String temp_key = temp_ident.toUpperCase().trim();
			if (symbolTable.GetVariable(temp_key) == Type.grid){
				if (key.equals("BACKGROUND")){
					if (temp.parent().parent().getClass() == AAssignExpr.class){
						AAssignExpr tempAssignNode = (AAssignExpr) temp.parent().parent();
						String param = tempAssignNode.getExpr().toString();
						code = CreateGridBackground(param);
						write(code);

					}
				}
			}
		}
	}

	private String CreateGridBackground(String src){
		String str = "// Set background image\n" +
				"var bgReady = false;\n" +
				"var bgImage = new Image();\n" +
				"bgImage.onload = function () {\n" +
				"	bgReady = true; \n};\n" +
				"bgImage.src = " + src + ";\n" +
				"if (bgReady) {\n" +
				"ctx.drawImage(bgImage, 0, 0);\n}\n\n";

		return str;
	}

}
