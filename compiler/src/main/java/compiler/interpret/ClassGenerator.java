package compiler.interpret;

import compiler.analysis.DepthFirstAdapter;
import compiler.node.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ClassGenerator extends DepthFirstAdapter
{
	private static int cellSize;
	private boolean dontPrint = false;
	private boolean inObject;
	private boolean inEvent;
	private HashMap<String, String[]> figures;
	private String indent;
	private String eventParam;
	private String ObjectName;

	public ClassGenerator() {
		this(50);
	}

	public ClassGenerator(int gridCellSize){
		cellSize = gridCellSize;
		inObject = false;
		inEvent = false;
		figures = new HashMap<>();
		indent = "";
		ObjectName = "";
	}

	private void MoveFunctions()
	{
		String temp = "var move = function (figur, key) \n{\n " +
				"if(key == \"up\")\n{\n figur.y =figur.y - " + cellSize + "; \n}\n" +
				"if(key == \"down\")\n{\n figur.y =figur.y + " + cellSize + "; \n}\n" +
				"if(key == \"left\")\n{\n figur.x = figur.x - " + cellSize + "; \n}\n" +
				"if(key == \"right\")\n{\n figur.x = figur.x + " + cellSize + "; \n}\n" +
				"\n}\n";
		write(temp);
	}

	private void write(String output)
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
	String functionName = "";

	private String createHtmlCanvas(int width, int height){
		return "// Creates HTML Canvas\n" +
				"var cellSize = " + cellSize + ";\n" +
				"var height = " + height + ";\n" +
				"var width = " + width + ";\n" +
				"var canvas = document.createElement(\"canvas\");\n" +
				"var ctx = canvas.getContext(\"2d\");\n" +
				"canvas.width = cellSize * width;\n" +
				"canvas.height = cellSize * height;\n" +
				"document.body.appendChild(canvas);\n\n";
	}

	private String createBackground(){
		String defaultPath = "\"images/bg.png\"";
		return "var bgImage = new Image();\nbgImage.onload = function() {};\n" +
				"bgImage.src = " + defaultPath + ";\n\n";

	}

	private void increaseIndentation(){
		indent += "    ";
	}
	private void decreaseIndentation(){
		indent = indent.substring(4);
	}

	private int translateKey(String key){
		switch (key) {
			case "up": return 38;
			case "down": return 40;
			case "right": return 37;
			case "left": return 39;
			case "enter": return 13;
			case "space": return 32;
			case "a": return 65;
			default: System.out.println("Key not recognised: " + key);
				System.exit(0);
				return 0;
		}
	}

	private String createRenderer(HashMap<String, String[]> figList){
		String temp = "var render = function(){\n";
		temp += "ctx.drawImage(bgImage, 0, 0, canvas.width, canvas.height);\n";
		for (String item : figList.keySet()){
			temp += "ctx.drawImage(" + item + "Image, " + item + ".x, " + item + ".y, " +
					cellSize + ", " + cellSize + ");\n";
		}
		temp += "}\n\n";
		return temp;
	}

	private String createEventListeners(){
		return "var OneKeyPress = true;\n\nvar keysDown = [];\n\n" +
				"addEventListener(\"keydown\", function (e){\nkeysDown[e.keyCode] = true;\n})\n" +
				"addEventListener(\"keyup\", function (e){\ndelete keysDown[e.keyCode];\n" +
				"OneKeyPress = true;\n})\n";
	}

	private String loadImage(String name, String src){
		figures.put(name, new String[2]);
		String tempName = name + "Image";
		String path = "" + src + "";
		return "var " + tempName + " = new Image();\n" +
				tempName + ".src = \"images/" + path + ".png\"\n\n";
	}

	private void addFigureCoords(String name, String x, String y){
		figures.replace(name, new String[]{x, y});
	}

	private String placeFigures(HashMap<String, String[]> figList){
		String temp = "var start = function(){\n";

		for (Map.Entry<String, String[]> entry : figList.entrySet()){
			String name = entry.getKey();
			String[] coords = entry.getValue();
			String x = coords[0];
			String y = coords[1];
			temp += name + ".x = " + x + " * " + cellSize + ";\n" +
					name + ".y = " + y + " * " + cellSize + ";\n";
		}
		temp += "}\n\n";
		return temp;
	}

	@Override
	public void inAProgram(AProgram node){
	}

	@Override
	public void outAProgram(AProgram node){
		code = placeFigures(figures) +
				createRenderer(figures) +
				"var main = function(){\nupdate()\nrender()\nrequestAnimationFrame(main);\n}\n" +
				"var w = window;\nrequestAnimationFrame = w.requestAnimationFrame ||\n" +
				"w.webkitRequestAnimationFrame ||\nw.msRequestAnimationFrame ||\n" +
				"w.mozRequestAnimationFrame;\n\n" +
				"start();\nmain();\n";
		if (!dontPrint){
			MoveFunctions();
			write(code);
		}

	}

	@Override
	public void outAExprStmt(AExprStmt node){
		code = ";\n";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAEventDecl(AEventDecl node){
		dontPrint = false;
		code = createEventListeners();
		code += "var update = function ()";
		if (!dontPrint){
			write(code);
		}
		inEvent = true;
		eventParam = node.getIdentifier().toString().toLowerCase().trim();

	}

	@Override
	public void outAEventDecl(AEventDecl node){
		inEvent = false;
		write("\n}}\n");
		eventParam = "";
	}

	public void outABoolExpr(ABoolExpr node)
	{
		if (inEvent && dontPrint)
		{
			dontPrint = false;
		}
	}
	@Override
	public void inABoolExpr(ABoolExpr node){
		if (inEvent && !dontPrint)
		{
			String[] temp = node.toString().split(" ");
			code = "";
			for (int i = 0; i < temp.length; i++)
			{
				if (temp[i].equals(eventParam))
				{
					if (temp[i + 1].equals("==") || temp[i + 1].equals("!="))
					{
						int keyCode=translateKey(temp[i + 2].toLowerCase().trim());
						code += keyCode + " in keysDown && OneKeyPress == true";
						i += 2;
					}
					else if (temp[i - 1].equals( "==") || temp[i - 1].equals("!="))
					{
						int keyCode=translateKey(temp[i-2].toLowerCase().trim());
						code += keyCode + " in keysDown && OneKeyPress == true";
						i += 2;
					}
				}
				else
				{
					code += temp[i];
				}
			}
			write(code);
			dontPrint = true;
		}
	}

	@Override
	public void inAGridDecl(AGridDecl node){
		int width = Integer.parseInt(node.getInt1().toString().trim());
		int height = Integer.parseInt(node.getInt2().toString().trim());
		code = createHtmlCanvas(width, height);
		code += createBackground();
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAObjectDecl(AObjectDecl node){
		code = loadImage(node.getId1().toString().trim(), node.getId2().toString().trim());
		code += "/*Object*/\nfunction " + node.getId1().toString().trim() + "()";
		functionName = node.getId1().toString().trim();
		if (!dontPrint){
			write(code);
		}
		inObject = true;
		ObjectName = node.getId1().toString().trim();
	}

	@Override
	public void outAObjectDecl(AObjectDecl node){
		inObject = false;
		ObjectName = "";
		if(!dontPrint) {
			write("var " + functionName + " = new " + functionName + "();\n\n");
		}
	}

	@Override
	public void inAFuncDecl(AFuncDecl node){
		if (!inObject){
			code = "function " + node.getIdentifier().toString().trim() ;
			dontPrint = false;
		}
		code += (node.getParams() == null ? "()" : "");
		if (!dontPrint){
			write(code);
		}
	}


	public void inAMethodInObjDecl (AMethodInObjDecl node)
	{
		dontPrint = true;
	}


	public void outAFuncDecl(AFuncDecl node)
	{
		if (inObject)
		{
			if (node.parent().getClass() == AMethodInObjDecl.class)
			{
				write("}\n");
				code = "var " + ObjectName + "_" + node.getIdentifier() + " = function(" + node.getParams().toString() + ")\n";
				write(code);
				node.getBody().apply(new ClassGenerator());
				dontPrint = true;
			}
		}

	}

	@Override
	public void inAVariableDecl(AVariableDecl node){
		if (inObject){
			code = "this." + node.getIdentifier().toString().trim() + " = ";
		}
		else {
			code = "/*Variable*/\nvar " + node.getIdentifier().toString().trim();
		}
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void outAVariableDecl(AVariableDecl node){
		if (node.parent().getClass() != AMemberInObjDecl.class){
			code = ";\n";
		}
		else{
			code =";\n";
		}
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAListVariable(AListVariable node){
		code = "[";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void outAListVariable(AListVariable node){
		code = "]";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAListVarTail(AListVarTail node){
		code = ", ";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inACallParams(ACallParams node){
		code = "(";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void outACallParams(ACallParams node){
		code = ")";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAReturnValue(AReturnValue node){
		code = "return ";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void outAReturnValue(AReturnValue node){
		code = ";";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAParams(AParams node){
		code = "(" + node.getIdentifier().toString().trim();
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void outAParams(AParams node){
		code = ")";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAParamsTail(AParamsTail node){
		code = ", " + node.getIdentifier().toString().trim();
			write(code);
	}

	@Override
	public void inAWhileControlStmt(AWhileControlStmt node){
		code = "while ";
		if (!dontPrint){
			write(code);
		}
	}

	private static int counter = 0;
	@Override
	public void inARepeatControlStmt(ARepeatControlStmt node){
		String id = "i" + counter;
		code = "for (" + id + " = 1; id <= ";

		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAIfStmtControlStmt(AIfStmtControlStmt node){
		code = "if ";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAElseStmtElseStmt(AElseStmtElseStmt node){
		code = "else";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAElseifStmtElseStmt(AElseifStmtElseStmt node){
		code = "else if ";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inACondition(ACondition node){
		code = "(";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void outACondition(ACondition node){
		code = ")";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void outARepeatCount(ARepeatCount node){
		String id = "i" + counter;
		code = "; " + id + "++)";
		if (!dontPrint){
			write(code);
		}
		counter++;
	}

	@Override
	public void inABody(ABody node){
		code = "\n//BodyBegins\n{\n";

		if (!dontPrint){
			write(code);
		}
		increaseIndentation();
	}

	@Override
	public void outABody(ABody node){
		code = "\n}\n//BodyEnds\n";
		if (node.parent().getClass() == AEventDecl.class)
		{
			code = "OneKeyPress = false;";
		}
		if (!dontPrint){
			write(code);
		}

		decreaseIndentation();
	}

	@Override
	public void inAObjBody(AObjBody node){
		code = "{\n";
		if (!dontPrint){
			write(code);
		}
		increaseIndentation();
	}

	@Override
	public void outAObjBody(AObjBody node){
		code = "}\n";
		if (!dontPrint){
			write(code);
		}
		dontPrint = false;
		decreaseIndentation();
	}

	@Override
	public void inAParenthesizedExpr(AParenthesizedExpr node){
		code = "(";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void outAParenthesizedExpr(AParenthesizedExpr node){
		code = ")";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAVarAssignExpr(AVarAssignExpr node){
		code = node.getIdentifier().toString().trim();
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAIdValue(AIdValue node){
		code = node.getIdentifier().toString().trim();
		if (!dontPrint) {
			write(code);
		}
	}

	public void outAMethodCallValue(AMethodCallValue node)
	{
		dontPrint = false;
	}

	@Override
	public void inAMethodCallValue(AMethodCallValue node){
		if(node.getFuncCall().getClass() == AFuncCall.class)
		{
			AFuncCall funcCall = (AFuncCall) node.getFuncCall();
			if(funcCall.getIdentifier().toString().trim().equals("move"))
			{
				code = "move(" + node.getIdentifier().toString() + ", \"" + funcCall.getCallParams().toString().trim() + "\")";
			}
			write(code);
			dontPrint = true;
		}
		else {
			code = node.getIdentifier().toString().trim() + ".";
		}

		if (!dontPrint) {
			write(code);
		}
	}

	@Override
	public void inAGridPosValue(AGridPosValue node) {
		if (node.getIdentifier().toString().toLowerCase().trim().equals("addobj")) {
			AFuncCall tempFunc = (AFuncCall) node.getFuncCall();
			ACallParams tempParams = (ACallParams) tempFunc.getCallParams();
			ACallParamsTail tempTail = (ACallParamsTail) tempParams.getCallParamsTail().getFirst();
			AGridParams tempGrPar = (AGridParams) node.getGridParams();
			String name = tempGrPar.getIdentifier().toString().trim();
			String x = tempParams.getExpr().toString().toLowerCase().trim();
			String y = tempTail.getExpr().toString().toLowerCase().trim();
			addFigureCoords(name, x, y);
		}
	}

	public void outAObjGlobalDecl(AObjGlobalDecl node)
	{
		dontPrint = false;
	}

	@Override
	public void inAFuncCall(AFuncCall node) {
		code = node.getIdentifier().toString().trim();
		if (node.parent().getClass() == AGridPosValue.class) {
			dontPrint = true;
		}
		if (!dontPrint) {
			write(code);
		}
	}



	@Override
	public void inAMember(AMember node){
		code = "." + node.getIdentifier().toString().trim();
		if (!dontPrint) {
			write(code);
		}
	}

	@Override
	public void inAMinusOperator(AMinusOperator node){
		code = "-";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAPlusOperator(APlusOperator node){
		code = "+";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAMultOperator(AMultOperator node){
		code = "*";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inADivOperator(ADivOperator node){
		code = "/";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAAssignOperator(AAssignOperator node){
		if (node.parent().parent().getClass() != AMemberInObjDecl.class) {
			code = " = ";
		}
		else{
			code = "";
		}
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAEqualBoolOperator(AEqualBoolOperator node){
		code = "==";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inANotEqualBoolOperator(ANotEqualBoolOperator node){
		code = "!=";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inALessEqualBoolOperator(ALessEqualBoolOperator node){
		code = "<=";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAGreaterEqualBoolOperator(AGreaterEqualBoolOperator node){
		code = ">=";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAAndBoolOperator(AAndBoolOperator node){
		code = "&&";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAOrBoolOperator(AOrBoolOperator node){
		code = "||";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inALessBoolOperator(ALessBoolOperator node){
		code = "<";

		if (!dontPrint){
			write(code);
		};
	}

	@Override
	public void inAGreaterBoolOperator(AGreaterBoolOperator node){
		code = ">";
		if (!dontPrint){
		write(code);
		}
	}

	@Override
	public void inANegationOperator(ANegationOperator node){
		code = "!";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inANumberLiteral(ANumberLiteral node){
		if(node.parent().parent().getClass() != AGridDecl.class){
			code = node.getNumberLiteral().toString().trim();
		}
		else{
			code = "";
		}
//		code += node.parent().getClass().toString() + " ";
//		code += node.parent().parent().getClass().toString() + " ";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAStringLiteral(AStringLiteral node){
		code = node.getStringLiteral().toString().trim();
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inATrueBooleanLiteral(ATrueBooleanLiteral node){
		code = "true";
		if (!dontPrint){
			write(code);
		}
	}

	@Override
	public void inAFalseBooleanLiteral(AFalseBooleanLiteral node){
		code = "false";
		if (!dontPrint){
			write(code);
		}
	}
/*
	@Override
	public void caseTIdentifier(TIdentifier node){
		code =">>>" + node. + "<<<";
		//code = node.toString().toLowerCase().trim();
		write(code);
	}
*/

}
