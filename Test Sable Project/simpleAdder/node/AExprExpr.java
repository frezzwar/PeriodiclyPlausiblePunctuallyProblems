/* This file was generated by SableCC (http://www.sablecc.org/). */

package simpleAdder.node;

import simpleAdder.analysis.*;

@SuppressWarnings("nls")
public final class AExprExpr extends PExpr
{
    private PExpr _expr_;
    private TComma _comma_;
    private POpassign _opassign_;

    public AExprExpr()
    {
        // Constructor
    }

    public AExprExpr(
        @SuppressWarnings("hiding") PExpr _expr_,
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") POpassign _opassign_)
    {
        // Constructor
        setExpr(_expr_);

        setComma(_comma_);

        setOpassign(_opassign_);

    }

    @Override
    public Object clone()
    {
        return new AExprExpr(
            cloneNode(this._expr_),
            cloneNode(this._comma_),
            cloneNode(this._opassign_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExprExpr(this);
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

    public TComma getComma()
    {
        return this._comma_;
    }

    public void setComma(TComma node)
    {
        if(this._comma_ != null)
        {
            this._comma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comma_ = node;
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
            + toString(this._expr_)
            + toString(this._comma_)
            + toString(this._opassign_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expr_ == child)
        {
            this._expr_ = null;
            return;
        }

        if(this._comma_ == child)
        {
            this._comma_ = null;
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
        if(this._expr_ == oldChild)
        {
            setExpr((PExpr) newChild);
            return;
        }

        if(this._comma_ == oldChild)
        {
            setComma((TComma) newChild);
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