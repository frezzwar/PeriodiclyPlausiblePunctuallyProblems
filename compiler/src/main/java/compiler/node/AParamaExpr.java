/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AParamaExpr extends PExpr
{
    private TParL _parL_;
    private PExpr _paramBody_;
    private TParR _parR_;
    private PExpr _expr_;

    public AParamaExpr()
    {
        // Constructor
    }

    public AParamaExpr(
        @SuppressWarnings("hiding") TParL _parL_,
        @SuppressWarnings("hiding") PExpr _paramBody_,
        @SuppressWarnings("hiding") TParR _parR_,
        @SuppressWarnings("hiding") PExpr _expr_)
    {
        // Constructor
        setParL(_parL_);

        setParamBody(_paramBody_);

        setParR(_parR_);

        setExpr(_expr_);

    }

    @Override
    public Object clone()
    {
        return new AParamaExpr(
            cloneNode(this._parL_),
            cloneNode(this._paramBody_),
            cloneNode(this._parR_),
            cloneNode(this._expr_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParamaExpr(this);
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

    public PExpr getParamBody()
    {
        return this._paramBody_;
    }

    public void setParamBody(PExpr node)
    {
        if(this._paramBody_ != null)
        {
            this._paramBody_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._paramBody_ = node;
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
            + toString(this._parL_)
            + toString(this._paramBody_)
            + toString(this._parR_)
            + toString(this._expr_);
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

        if(this._paramBody_ == child)
        {
            this._paramBody_ = null;
            return;
        }

        if(this._parR_ == child)
        {
            this._parR_ = null;
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
        if(this._parL_ == oldChild)
        {
            setParL((TParL) newChild);
            return;
        }

        if(this._paramBody_ == oldChild)
        {
            setParamBody((PExpr) newChild);
            return;
        }

        if(this._parR_ == oldChild)
        {
            setParR((TParR) newChild);
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
