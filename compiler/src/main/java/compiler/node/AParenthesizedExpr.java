/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AParenthesizedExpr extends PExpr
{
    private TParL _parL_;
    private PExpr _expr_;
    private TParR _parR_;

    public AParenthesizedExpr()
    {
        // Constructor
    }

    public AParenthesizedExpr(
        @SuppressWarnings("hiding") TParL _parL_,
        @SuppressWarnings("hiding") PExpr _expr_,
        @SuppressWarnings("hiding") TParR _parR_)
    {
        // Constructor
        setParL(_parL_);

        setExpr(_expr_);

        setParR(_parR_);

    }

    @Override
    public Object clone()
    {
        return new AParenthesizedExpr(
            cloneNode(this._parL_),
            cloneNode(this._expr_),
            cloneNode(this._parR_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParenthesizedExpr(this);
    }

    public TParL getParL()
    {
        return this._parL_;
    }

    public void setParL(TParL node)
    {
        if(this._parL_ != null)
        {
            this._parL_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parL_ = node;
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

    public TParR getParR()
    {
        return this._parR_;
    }

    public void setParR(TParR node)
    {
        if(this._parR_ != null)
        {
            this._parR_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parR_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._parL_)
            + toString(this._expr_)
            + toString(this._parR_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._parL_ == child)
        {
            this._parL_ = null;
            return;
        }

        if(this._expr_ == child)
        {
            this._expr_ = null;
            return;
        }

        if(this._parR_ == child)
        {
            this._parR_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._parL_ == oldChild)
        {
            setParL((TParL) newChild);
            return;
        }

        if(this._expr_ == oldChild)
        {
            setExpr((PExpr) newChild);
            return;
        }

        if(this._parR_ == oldChild)
        {
            setParR((TParR) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
