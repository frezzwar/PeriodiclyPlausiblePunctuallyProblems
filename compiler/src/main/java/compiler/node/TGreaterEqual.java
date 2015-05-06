/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class TGreaterEqual extends Token
{
    public TGreaterEqual()
    {
        super.setText(">=");
    }

    public TGreaterEqual(int line, int pos)
    {
        super.setText(">=");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TGreaterEqual(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTGreaterEqual(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TGreaterEqual text.");
    }
}