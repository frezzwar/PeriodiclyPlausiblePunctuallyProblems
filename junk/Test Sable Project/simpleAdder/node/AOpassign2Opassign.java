/* This file was generated by SableCC (http://www.sablecc.org/). */

package simpleAdder.node;

import simpleAdder.analysis.*;

@SuppressWarnings("nls")
public final class AOpassign2Opassign extends POpassign
{
    private POpor _opor_;
    private TIncrement _increment_;
    private POpassign _opassign_;

    public AOpassign2Opassign()
    {
        // Constructor
    }

    public AOpassign2Opassign(
        @SuppressWarnings("hiding") POpor _opor_,
        @SuppressWarnings("hiding") TIncrement _increment_,
        @SuppressWarnings("hiding") POpassign _opassign_)
    {
        // Constructor
        setOpor(_opor_);

        setIncrement(_increment_);

        setOpassign(_opassign_);

    }

    @Override
    public Object clone()
    {
        return new AOpassign2Opassign(
            cloneNode(this._opor_),
            cloneNode(this._increment_),
            cloneNode(this._opassign_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOpassign2Opassign(this);
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

    public TIncrement getIncrement()
    {
        return this._increment_;
    }

    public void setIncrement(TIncrement node)
    {
        if(this._increment_ != null)
        {
            this._increment_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._increment_ = node;
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
            + toString(this._increment_)
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

        if(this._increment_ == child)
        {
            this._increment_ = null;
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

        if(this._increment_ == oldChild)
        {
            setIncrement((TIncrement) newChild);
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