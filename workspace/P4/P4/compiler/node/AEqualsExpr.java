/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AEqualsExpr extends PExpr
{
    private POpor _opor_;
    private TEquals _equals_;
    private PExpr _expr_;

    public AEqualsExpr()
    {
        // Constructor
    }

    public AEqualsExpr(
        @SuppressWarnings("hiding") POpor _opor_,
        @SuppressWarnings("hiding") TEquals _equals_,
        @SuppressWarnings("hiding") PExpr _expr_)
    {
        // Constructor
        setOpor(_opor_);

        setEquals(_equals_);

        setExpr(_expr_);

    }

    @Override
    public Object clone()
    {
        return new AEqualsExpr(
            cloneNode(this._opor_),
            cloneNode(this._equals_),
            cloneNode(this._expr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEqualsExpr(this);
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

    public TEquals getEquals()
    {
        return this._equals_;
    }

    public void setEquals(TEquals node)
    {
        if(this._equals_ != null)
        {
            this._equals_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._equals_ = node;
    }

    public PExpr getExpr()
    {
        return this._expr_;
    }

    public void setExpr(PExpr node)
    {
        if(this._expr_ != null)
        {
            this._expr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._opor_)
            + toString(this._equals_)
            + toString(this._expr_);
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

        if(this._equals_ == child)
        {
            this._equals_ = null;
            return;
        }

        if(this._expr_ == child)
        {
            this._expr_ = null;
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

        if(this._equals_ == oldChild)
        {
            setEquals((TEquals) newChild);
            return;
        }

        if(this._expr_ == oldChild)
        {
            setExpr((PExpr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
