/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AFuncCallValue extends PValue
{
    private PFuncCall _funcCall_;

    public AFuncCallValue()
    {
        // Constructor
    }

    public AFuncCallValue(
        @SuppressWarnings("hiding") PFuncCall _funcCall_)
    {
        // Constructor
        setFuncCall(_funcCall_);

    }

    @Override
    public Object clone()
    {
        return new AFuncCallValue(
            cloneNode(this._funcCall_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFuncCallValue(this);
    }

    public PFuncCall getFuncCall()
    {
        return this._funcCall_;
    }

    public void setFuncCall(PFuncCall node)
    {
        if(this._funcCall_ != null)
        {
            this._funcCall_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._funcCall_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._funcCall_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._funcCall_ == child)
        {
            this._funcCall_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._funcCall_ == oldChild)
        {
            setFuncCall((PFuncCall) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}