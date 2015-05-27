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
    void caseAVariableDeclStmt(AVariableDeclStmt node);
    void caseAControlStmtStmt(AControlStmtStmt node);
    void caseAExprStmt(AExprStmt node);
    void caseAVarGlobalDecl(AVarGlobalDecl node);
    void caseAObjGlobalDecl(AObjGlobalDecl node);
    void caseAGridGlobalDecl(AGridGlobalDecl node);
    void caseAEventDecl(AEventDecl node);
    void caseAGridDecl(AGridDecl node);
    void caseAObjectDecl(AObjectDecl node);
    void caseAFuncDecl(AFuncDecl node);
    void caseAVariableDecl(AVariableDecl node);
    void caseAExprVariable(AExprVariable node);
    void caseAListVariable(AListVariable node);
    void caseAListVar(AListVar node);
    void caseAListVarTail(AListVarTail node);
    void caseACallParams(ACallParams node);
    void caseACallParamsTail(ACallParamsTail node);
    void caseAReturnValue(AReturnValue node);
    void caseAParams(AParams node);
    void caseAParamsTail(AParamsTail node);
    void caseAWhileControlStmt(AWhileControlStmt node);
    void caseARepeatControlStmt(ARepeatControlStmt node);
    void caseAForeachControlStmt(AForeachControlStmt node);
    void caseAIfStmtControlStmt(AIfStmtControlStmt node);
    void caseAElseStmtElseStmt(AElseStmtElseStmt node);
    void caseAElseifStmtElseStmt(AElseifStmtElseStmt node);
    void caseACondition(ACondition node);
    void caseARepeatCount(ARepeatCount node);
    void caseABody(ABody node);
    void caseAObjBody(AObjBody node);
    void caseAMethodInObjDecl(AMethodInObjDecl node);
    void caseAMemberInObjDecl(AMemberInObjDecl node);
    void caseAAssignExpr(AAssignExpr node);
    void caseABooleanExpr(ABooleanExpr node);
    void caseANumericExpr(ANumericExpr node);
    void caseAValueExpr(AValueExpr node);
    void caseAParenthesizedExpr(AParenthesizedExpr node);
    void caseAParamaBoolExpr(AParamaBoolExpr node);
    void caseAParamaNumericExpr(AParamaNumericExpr node);
    void caseAVarAssignExpr(AVarAssignExpr node);
    void caseABoolExpr(ABoolExpr node);
    void caseAIdValue(AIdValue node);
    void caseAMethodCallValue(AMethodCallValue node);
    void caseAGridPosValue(AGridPosValue node);
    void caseAFuncCallValue(AFuncCallValue node);
    void caseALiteralValue(ALiteralValue node);
    void caseAGridParams(AGridParams node);
    void caseAFuncCall(AFuncCall node);
    void caseAMember(AMember node);
    void caseAMinusOperator(AMinusOperator node);
    void caseAPlusOperator(APlusOperator node);
    void caseAMultOperator(AMultOperator node);
    void caseADivOperator(ADivOperator node);
    void caseAAssignOperator(AAssignOperator node);
    void caseAEqualBoolOperator(AEqualBoolOperator node);
    void caseANotEqualBoolOperator(ANotEqualBoolOperator node);
    void caseALessEqualBoolOperator(ALessEqualBoolOperator node);
    void caseAGreaterEqualBoolOperator(AGreaterEqualBoolOperator node);
    void caseAAndBoolOperator(AAndBoolOperator node);
    void caseAOrBoolOperator(AOrBoolOperator node);
    void caseALessBoolOperator(ALessBoolOperator node);
    void caseAGreaterBoolOperator(AGreaterBoolOperator node);
    void caseANegationOperator(ANegationOperator node);
    void caseABooleanLiteral(ABooleanLiteral node);
    void caseANumberLiteral(ANumberLiteral node);
    void caseAStringLiteral(AStringLiteral node);
    void caseATrueBooleanLiteral(ATrueBooleanLiteral node);
    void caseAFalseBooleanLiteral(AFalseBooleanLiteral node);

    void caseTPlus(TPlus node);
    void caseTMinus(TMinus node);
    void caseTMult(TMult node);
    void caseTDiv(TDiv node);
    void caseTAssign(TAssign node);
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
    void caseTNotEqual(TNotEqual node);
    void caseTLessEqual(TLessEqual node);
    void caseTGreaterEqual(TGreaterEqual node);
    void caseTNegate(TNegate node);
    void caseTAnd(TAnd node);
    void caseTOr(TOr node);
    void caseTLess(TLess node);
    void caseTGreater(TGreater node);
    void caseTTrue(TTrue node);
    void caseTFalse(TFalse node);
    void caseTNew(TNew node);
    void caseTEvent(TEvent node);
    void caseTTo(TTo node);
    void caseTRepeat(TRepeat node);
    void caseTWhile(TWhile node);
    void caseTIf(TIf node);
    void caseTElse(TElse node);
    void caseTForeach(TForeach node);
    void caseTIn(TIn node);
    void caseTReturn(TReturn node);
    void caseTMain(TMain node);
    void caseTFigure(TFigure node);
    void caseTGrid(TGrid node);
    void caseTIdentifier(TIdentifier node);
    void caseTStringLiteral(TStringLiteral node);
    void caseTNumberLiteral(TNumberLiteral node);
    void caseTMultilineComment(TMultilineComment node);
    void caseTOnelineComment(TOnelineComment node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
