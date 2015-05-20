/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.parser;

import compiler.node.*;
import compiler.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTPlus(@SuppressWarnings("unused") TPlus node)
    {
        this.index = 0;
    }

    @Override
    public void caseTMinus(@SuppressWarnings("unused") TMinus node)
    {
        this.index = 1;
    }

    @Override
    public void caseTMult(@SuppressWarnings("unused") TMult node)
    {
        this.index = 2;
    }

    @Override
    public void caseTDiv(@SuppressWarnings("unused") TDiv node)
    {
        this.index = 3;
    }

    @Override
    public void caseTAssign(@SuppressWarnings("unused") TAssign node)
    {
        this.index = 4;
    }

    @Override
    public void caseTParL(@SuppressWarnings("unused") TParL node)
    {
        this.index = 5;
    }

    @Override
    public void caseTParR(@SuppressWarnings("unused") TParR node)
    {
        this.index = 6;
    }

    @Override
    public void caseTCurlyL(@SuppressWarnings("unused") TCurlyL node)
    {
        this.index = 7;
    }

    @Override
    public void caseTCurlyR(@SuppressWarnings("unused") TCurlyR node)
    {
        this.index = 8;
    }

    @Override
    public void caseTBrackL(@SuppressWarnings("unused") TBrackL node)
    {
        this.index = 9;
    }

    @Override
    public void caseTBrackR(@SuppressWarnings("unused") TBrackR node)
    {
        this.index = 10;
    }

    @Override
    public void caseTQuote(@SuppressWarnings("unused") TQuote node)
    {
        this.index = 11;
    }

    @Override
    public void caseTComma(@SuppressWarnings("unused") TComma node)
    {
        this.index = 12;
    }

    @Override
    public void caseTSemiC(@SuppressWarnings("unused") TSemiC node)
    {
        this.index = 13;
    }

    @Override
    public void caseTDot(@SuppressWarnings("unused") TDot node)
    {
        this.index = 14;
    }

    @Override
    public void caseTEqual(@SuppressWarnings("unused") TEqual node)
    {
        this.index = 15;
    }

    @Override
    public void caseTLessEqual(@SuppressWarnings("unused") TLessEqual node)
    {
        this.index = 16;
    }

    @Override
    public void caseTGreaterEqual(@SuppressWarnings("unused") TGreaterEqual node)
    {
        this.index = 17;
    }

    @Override
    public void caseTNegate(@SuppressWarnings("unused") TNegate node)
    {
        this.index = 18;
    }

    @Override
    public void caseTAnd(@SuppressWarnings("unused") TAnd node)
    {
        this.index = 19;
    }

    @Override
    public void caseTOr(@SuppressWarnings("unused") TOr node)
    {
        this.index = 20;
    }

    @Override
    public void caseTLess(@SuppressWarnings("unused") TLess node)
    {
        this.index = 21;
    }

    @Override
    public void caseTGreater(@SuppressWarnings("unused") TGreater node)
    {
        this.index = 22;
    }

    @Override
    public void caseTIncrement(@SuppressWarnings("unused") TIncrement node)
    {
        this.index = 23;
    }

    @Override
    public void caseTDecrement(@SuppressWarnings("unused") TDecrement node)
    {
        this.index = 24;
    }

    @Override
    public void caseTTrue(@SuppressWarnings("unused") TTrue node)
    {
        this.index = 25;
    }

    @Override
    public void caseTFalse(@SuppressWarnings("unused") TFalse node)
    {
        this.index = 26;
    }

    @Override
    public void caseTNew(@SuppressWarnings("unused") TNew node)
    {
        this.index = 27;
    }

    @Override
    public void caseTTo(@SuppressWarnings("unused") TTo node)
    {
        this.index = 28;
    }

    @Override
    public void caseTRepeat(@SuppressWarnings("unused") TRepeat node)
    {
        this.index = 29;
    }

    @Override
    public void caseTWhile(@SuppressWarnings("unused") TWhile node)
    {
        this.index = 30;
    }

    @Override
    public void caseTRandom(@SuppressWarnings("unused") TRandom node)
    {
        this.index = 31;
    }

    @Override
    public void caseTIf(@SuppressWarnings("unused") TIf node)
    {
        this.index = 32;
    }

    @Override
    public void caseTElse(@SuppressWarnings("unused") TElse node)
    {
        this.index = 33;
    }

    @Override
    public void caseTForeach(@SuppressWarnings("unused") TForeach node)
    {
        this.index = 34;
    }

    @Override
    public void caseTIn(@SuppressWarnings("unused") TIn node)
    {
        this.index = 35;
    }

    @Override
    public void caseTReturn(@SuppressWarnings("unused") TReturn node)
    {
        this.index = 36;
    }

    @Override
    public void caseTMain(@SuppressWarnings("unused") TMain node)
    {
        this.index = 37;
    }

    @Override
    public void caseTFigure(@SuppressWarnings("unused") TFigure node)
    {
        this.index = 38;
    }

    @Override
    public void caseTGrid(@SuppressWarnings("unused") TGrid node)
    {
        this.index = 39;
    }

    @Override
    public void caseTEvent(@SuppressWarnings("unused") TEvent node)
    {
        this.index = 40;
    }

    @Override
    public void caseTIdentifier(@SuppressWarnings("unused") TIdentifier node)
    {
        this.index = 41;
    }

    @Override
    public void caseTStringLiteral(@SuppressWarnings("unused") TStringLiteral node)
    {
        this.index = 42;
    }

    @Override
    public void caseTDoubleLiteral(@SuppressWarnings("unused") TDoubleLiteral node)
    {
        this.index = 43;
    }

    @Override
    public void caseTIntegerLiteral(@SuppressWarnings("unused") TIntegerLiteral node)
    {
        this.index = 44;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 45;
    }
}
