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
    public void caseADecls(ADecls node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVariableDeclarationDecl(AVariableDeclarationDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionDeclarationDecl(AFunctionDeclarationDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAControlStatementsDecl(AControlStatementsDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAssignDecl(AAssignDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVariableDeclaration(AVariableDeclaration node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASingleVariableTypes(ASingleVariableTypes node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListVariableTypes(AListVariableTypes node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVariableTail(AVariableTail node)
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
    public void caseAFunctionDeclaration(AFunctionDeclaration node)
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
    public void caseAWhileControlStatments(AWhileControlStatments node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARepeatControlStatments(ARepeatControlStatments node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAForeachControlStatments(AForeachControlStatments node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIfstructureControlStatments(AIfstructureControlStatments node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAElseElsestructure(AElseElsestructure node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIfelseElsestructure(AIfelseElsestructure node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABody(ABody node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEqualsExpr(AEqualsExpr node)
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
    public void caseAOrExpr(AOrExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOrOpor(AOrOpor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndOpor(AAndOpor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndOpand(AAndOpand node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEquateOpand(AEquateOpand node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEqualOpequate(AEqualOpequate node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegateOpequate(ANegateOpequate node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACompareOpequate(ACompareOpequate node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALessOpcompare(ALessOpcompare node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterOpcompare(AGreaterOpcompare node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALessEqualOpcompare(ALessEqualOpcompare node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterEqualOpcompare(AGreaterEqualOpcompare node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAddOpcompare(AAddOpcompare node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPlusOpadd(APlusOpadd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMinusOpadd(AMinusOpadd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultOpadd(AMultOpadd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultOpmult(AMultOpmult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivOpmult(ADivOpmult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAUnaryOpmult(AUnaryOpmult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMinusvalueOpunary(AMinusvalueOpunary node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAValueOpunary(AValueOpunary node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarnameValue(AVarnameValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALiteralValue(ALiteralValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARndValue(ARndValue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionCall(AFunctionCall node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarname(AVarname node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdlist(AIdlist node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALessEqualCompareToken(ALessEqualCompareToken node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALessCompareToken(ALessCompareToken node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterEqualCompareToken(AGreaterEqualCompareToken node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGreaterCompareToken(AGreaterCompareToken node)
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
    public void caseARnd(ARnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABooleanLiteralLiteral(ABooleanLiteralLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntegerLiteralLiteral(AIntegerLiteralLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADoubleLiteralLiteral(ADoubleLiteralLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringLiteralLiteral(AStringLiteralLiteral node)
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
    public void caseTEquals(TEquals node)
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
