/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.analysis;

import java.util.*;
import compiler.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAProgram(AProgram node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVariableDeclDecl(AVariableDeclDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAControlStmtDecl(AControlStmtDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAssignDecl(AAssignDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarGlobalDecls(AVarGlobalDecls node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAObjGlobalDecls(AObjGlobalDecls node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGridGlobalDecls(AGridGlobalDecls node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEventDecl(AEventDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGridDecl(AGridDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAObjectDecl(AObjectDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFuncDecl(AFuncDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVariableDecl(AVariableDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprVariables(AExprVariables node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListVariables(AListVariables node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListVarTail(AListVarTail node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACallParams(ACallParams node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACallParamsTail(ACallParamsTail node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAReturnValue(AReturnValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParams(AParams node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParamsTail(AParamsTail node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAWhileControlStmt(AWhileControlStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARepeatControlStmt(ARepeatControlStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAForeachControlStmt(AForeachControlStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIfStmtControlStmt(AIfStmtControlStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAElseStmtElseStmt(AElseStmtElseStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAElseifStmtElseStmt(AElseifStmtElseStmt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABody(ABody node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAObjBody(AObjBody node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADeclObjDecls(ADeclObjDecls node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAObjDeclsObjDecls(AObjDeclsObjDecls node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAssignExpr(AAssignExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIncrementExpr(AIncrementExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADecrementExpr(ADecrementExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABooleanExpr(ABooleanExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANumericExpr(ANumericExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMinusvalueExpr(AMinusvalueExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValueExpr(AValueExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParamaExpr(AParamaExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParamaBoolExpr(AParamaBoolExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParamaNumericExpr(AParamaNumericExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValueValue(AValueValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValueMemberValue(AValueMemberValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFuncCallValue(AFuncCallValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALiteralValue(ALiteralValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFuncCall(AFuncCall node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADotMember(ADotMember node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMethodCallMember(AMethodCallMember node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMinusOperator(AMinusOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPlusOperator(APlusOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultOperator(AMultOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivOperator(ADivOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEqualBoolOperator(AEqualBoolOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALessEqualBoolOperator(ALessEqualBoolOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterEqualBoolOperator(AGreaterEqualBoolOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegateBoolOperator(ANegateBoolOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndBoolOperator(AAndBoolOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOrBoolOperator(AOrBoolOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALessBoolOperator(ALessBoolOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterBoolOperator(AGreaterBoolOperator node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABooleanLiteral(ABooleanLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntegerLiteral(AIntegerLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADoubleLiteral(ADoubleLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringLiteral(AStringLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATrueBooleanLiteral(ATrueBooleanLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFalseBooleanLiteral(AFalseBooleanLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAssign(TAssign node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTParL(TParL node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTParR(TParR node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCurlyL(TCurlyL node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCurlyR(TCurlyR node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBrackL(TBrackL node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBrackR(TBrackR node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTQuote(TQuote node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSemiC(TSemiC node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDot(TDot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEqual(TEqual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLessEqual(TLessEqual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGreaterEqual(TGreaterEqual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNegate(TNegate node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAnd(TAnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOr(TOr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLess(TLess node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGreater(TGreater node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIncrement(TIncrement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDecrement(TDecrement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTrue(TTrue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFalse(TFalse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNew(TNew node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTo(TTo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRepeat(TRepeat node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTWhile(TWhile node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRandom(TRandom node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIf(TIf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTElse(TElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTForeach(TForeach node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIn(TIn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTReturn(TReturn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMain(TMain node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFigure(TFigure node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGrid(TGrid node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEvent(TEvent node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIdentifier(TIdentifier node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStringLiteral(TStringLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDoubleLiteral(TDoubleLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIntegerLiteral(TIntegerLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMultilineComment(TMultilineComment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOnelineComment(TOnelineComment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
