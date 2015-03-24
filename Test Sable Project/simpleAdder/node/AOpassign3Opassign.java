/* This file was generated by SableCC (http://www.sablecc.org/). */

package simpleAdder.node;

import simpleAdder.analysis.*;

@SuppressWarnings("nls")
public final class AOpassign3Opassign extends POpassign
{
    private POpor _opor_;
    private TDecrement _decrement_;
    private POpassign _opassign_;

    public AOpassign3Opassign()
    {
        // Constructor
    }

    public AOpassign3Opassign(
        @SuppressWarnings("hiding") POpor _opor_,
        @SuppressWarnings("hiding") TDecrement _decrement_,
        @SuppressWarnings("hiding") POpassign _opassign_)
    {
        // Constructor
        setOpor(_opor_);

        setDecrement(_decrement_);

        setOpassign(_opassign_);

    }

    @Override
    public Object clone()
    {
        return new AOpassign3Opassign(
            cloneNode(this._opor_),
            cloneNode(this._decrement_),
            cloneNode(this._opassign_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOpassign3Opassign(this);
    }

    public POpor getOpor()
    {
        return this._opor_;
    }

    public void setOpor(POpor node)
    {
        if(this._opor_ != null)
        {
            this._opor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._opor_ = node;
    }

    public TDecrement getDecrement()
    {
        return this._decrement_;
    }

    public void setDecrement(TDecrement node)
    {
        if(this._decrement_ != null)
        {
            this._decrement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._decrement_ = node;
    }

    public POpassign getOpassign()
    {
        return this._opassign_;
    }

    public void setOpassign(POpassign node)
    {
        if(this._opassign_ != null)
        {
            this._opassign_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._opassign_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._opor_)
            + toString(this._decrement_)
            + toString(this._opassign_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._opor_ == child)
        {
            this._opor_ = null;
            return;
        }

        if(this._decrement_ == child)
        {
            this._decrement_ = null;
            return;
        }

        if(this._opassign_ == child)
        {
            this._opassign_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._opor_ == oldChild)
        {
            setOpor((POpor) newChild);
            return;
        }

        if(this._decrement_ == oldChild)
        {
            setDecrement((TDecrement) newChild);
            return;
        }

        if(this._opassign_ == oldChild)
        {
            setOpassign((POpassign) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
