/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class ARepeatCount extends PRepeatCount
{
    private TParL _parL_;
    private PValue _value_;
    private TParR _parR_;

    public ARepeatCount()
    {
        // Constructor
    }

    public ARepeatCount(
        @SuppressWarnings("hiding") TParL _parL_,
        @SuppressWarnings("hiding") PValue _value_,
        @SuppressWarnings("hiding") TParR _parR_)
    {
        // Constructor
        setParL(_parL_);

        setValue(_value_);

        setParR(_parR_);

    }

    @Override
    public Object clone()
    {
        return new ARepeatCount(
            cloneNode(this._parL_),
            cloneNode(this._value_),
            cloneNode(this._parR_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARepeatCount(this);
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

    public PValue getValue()
    {
        return this._value_;
    }

    public void setValue(PValue node)
    {
        if(this._value_ != null)
        {
            this._value_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._value_ = node;
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
            + toString(this._value_)
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

        if(this._value_ == child)
        {
            this._value_ = null;
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

        if(this._value_ == oldChild)
        {
            setValue((PValue) newChild);
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