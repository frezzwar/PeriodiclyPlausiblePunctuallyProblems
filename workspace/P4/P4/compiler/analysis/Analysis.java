/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.analysis;

import compiler.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProgram(AProgram node);
    void caseADecls(ADecls node);
    void caseAVariableDeclarationDecl(AVariableDeclarationDecl node);
    void caseAFunctionDeclarationDecl(AFunctionDeclarationDecl node);
    void caseAControlStatementsDecl(AControlStatementsDecl node);
    void caseAAssignDecl(AAssignDecl node);
    void caseAVariableDeclaration(AVariableDeclaration node);
    void caseASingleVariableTypes(ASingleVariableTypes node);
    void caseAListVariableTypes(AListVariableTypes node);
    void caseAVariableTail(AVariableTail node);
    void caseAListVarTail(AListVarTail node);
    void caseACallParams(ACallParams node);
    void caseACallParamsTail(ACallParamsTail node);
    void caseAFunctionDeclaration(AFunctionDeclaration node);
    void caseAReturnValue(AReturnValue node);
    void caseAParams(AParams node);
    void caseAParamsTail(AParamsTail node);
    void caseAWhileControlStatments(AWhileControlStatments node);
    void caseARepeatControlStatments(ARepeatControlStatments node);
    void caseAForeachControlStatments(AForeachControlStatments node);
    void caseAIfstructureControlStatments(AIfstructureControlStatments node);
    void caseAElseElsestructure(AElseElsestructure node);
    void caseAIfelseElsestructure(AIfelseElsestructure node);
    void caseABody(ABody node);
    void caseAEqualsExpr(AEqualsExpr node);
    void caseAIncrementExpr(AIncrementExpr node);
    void caseADecrementExpr(ADecrementExpr node);
    void caseAOrExpr(AOrExpr node);
    void caseAOrOpor(AOrOpor node);
    void caseAAndOpor(AAndOpor node);
    void caseAAndOpand(AAndOpand node);
    void caseAEquateOpand(AEquateOpand node);
    void caseAEqualOpequate(AEqualOpequate node);
    void caseANegateOpequate(ANegateOpequate node);
    void caseACompareOpequate(ACompareOpequate node);
    void caseALessOpcompare(ALessOpcompare node);
    void caseAGreaterOpcompare(AGreaterOpcompare node);
    void caseALessEqualOpcompare(ALessEqualOpcompare node);
    void caseAGreaterEqualOpcompare(AGreaterEqualOpcompare node);
    void caseAAddOpcompare(AAddOpcompare node);
    void caseAPlusOpadd(APlusOpadd node);
    void caseAMinusOpadd(AMinusOpadd node);
    void caseAMultOpadd(AMultOpadd node);
    void caseAMultOpmult(AMultOpmult node);
    void caseADivOpmult(ADivOpmult node);
    void caseAUnaryOpmult(AUnaryOpmult node);
    void caseAMinusvalueOpunary(AMinusvalueOpunary node);
    void caseAValueOpunary(AValueOpunary node);
    void caseAVarnameValue(AVarnameValue node);
    void caseALiteralValue(ALiteralValue node);
    void caseARndValue(ARndValue node);
    void caseAFunctionCall(AFunctionCall node);
    void caseAVarname(AVarname node);
    void caseAIdlist(AIdlist node);
    void caseALessEqualCompareToken(ALessEqualCompareToken node);
    void caseALessCompareToken(ALessCompareToken node);
    void caseAGreaterEqualCompareToken(AGreaterEqualCompareToken node);
    void caseAGreaterCompareToken(AGreaterCompareToken node);
    void caseAMinusOperator(AMinusOperator node);
    void caseAPlusOperator(APlusOperator node);
    void caseAMultOperator(AMultOperator node);
    void caseADivOperator(ADivOperator node);
    void caseAEqualBoolOperator(AEqualBoolOperator node);
    void caseALessEqualBoolOperator(ALessEqualBoolOperator node);
    void caseAGreaterEqualBoolOperator(AGreaterEqualBoolOperator node);
    void caseANegateBoolOperator(ANegateBoolOperator node);
    void caseAAndBoolOperator(AAndBoolOperator node);
    void caseAOrBoolOperator(AOrBoolOperator node);
    void caseALessBoolOperator(ALessBoolOperator node);
    void caseAGreaterBoolOperator(AGreaterBoolOperator node);
    void caseARnd(ARnd node);
    void caseABooleanLiteralLiteral(ABooleanLiteralLiteral node);
    void caseAIntegerLiteralLiteral(AIntegerLiteralLiteral node);
    void caseADoubleLiteralLiteral(ADoubleLiteralLiteral node);
    void caseAStringLiteralLiteral(AStringLiteralLiteral node);
    void caseATrueBooleanLiteral(ATrueBooleanLiteral node);
    void caseAFalseBooleanLiteral(AFalseBooleanLiteral node);

    void caseTPlus(TPlus node);
    void caseTMinus(TMinus node);
    void caseTMult(TMult node);
    void caseTDiv(TDiv node);
    void caseTEquals(TEquals node);
    void caseTParL(TParL node);
    void caseTParR(TParR node);
    void caseTCurlyL(TCurlyL node);
    void caseTCurlyR(TCurlyR node);
    void caseTBrackL(TBrackL node);
    void caseTBrackR(TBrackR node);
    void caseTQuote(TQuote node);
    void caseTComma(TComma node);
    void caseTSemiC(TSemiC node);
    void caseTBlank(TBlank node);
    void caseTDot(TDot node);
    void caseTEqual(TEqual node);
    void caseTLessEqual(TLessEqual node);
    void caseTGreaterEqual(TGreaterEqual node);
    void caseTNegate(TNegate node);
    void caseTAnd(TAnd node);
    void caseTOr(TOr node);
    void caseTLess(TLess node);
    void caseTGreater(TGreater node);
    void caseTIncrement(TIncrement node);
    void caseTDecrement(TDecrement node);
    void caseTTrue(TTrue node);
    void caseTFalse(TFalse node);
    void caseTNew(TNew node);
    void caseTTo(TTo node);
    void caseTRepeat(TRepeat node);
    void caseTWhile(TWhile node);
    void caseTRandom(TRandom node);
    void caseTIf(TIf node);
    void caseTElse(TElse node);
    void caseTForeach(TForeach node);
    void caseTIn(TIn node);
    void caseTReturn(TReturn node);
    void caseTIdentifier(TIdentifier node);
    void caseTStringLiteral(TStringLiteral node);
    void caseTDoubleLiteral(TDoubleLiteral node);
    void caseTIntegerLiteral(TIntegerLiteral node);
    void caseTMultilineComment(TMultilineComment node);
    void caseTOnelineComment(TOnelineComment node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
