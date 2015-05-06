/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class ADivOperator extends POperator
{
    private TDiv _div_;

    public ADivOperator()
    {
        // Constructor
    }

    public ADivOperator(
        @SuppressWarnings("hiding") TDiv _div_)
    {
        // Constructor
        setDiv(_div_);

    }

    @Override
    public Object clone()
    {
        return new ADivOperator(
            cloneNode(this._div_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADivOperator(this);
    }

    public TDiv getDiv()
    {
        return this._div_;
    }

    public void setDiv(TDiv node)
    {
        if(this._div_ != null)
        {
            this._div_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._div_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._div_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._div_ == child)
        {
            this._div_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._div_ == oldChild)
        {
            setDiv((TDiv) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}