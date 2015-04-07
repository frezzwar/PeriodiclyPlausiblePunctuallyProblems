/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class TNegate extends Token
{
    public TNegate()
    {
        super.setText("!=");
    }

    public TNegate(int line, int pos)
    {
        super.setText("!=");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TNegate(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNegate(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TNegate text.");
    }
}
