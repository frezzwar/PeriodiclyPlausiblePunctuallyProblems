/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AGreaterOpcompare extends POpcompare
{
    private POpcompare _opcompare_;
    private TGreater _greater_;
    private PValue _value_;

    public AGreaterOpcompare()
    {
        // Constructor
    }

    public AGreaterOpcompare(
        @SuppressWarnings("hiding") POpcompare _opcompare_,
        @SuppressWarnings("hiding") TGreater _greater_,
        @SuppressWarnings("hiding") PValue _value_)
    {
        // Constructor
        setOpcompare(_opcompare_);

        setGreater(_greater_);

        setValue(_value_);

    }

    @Override
    public Object clone()
    {
        return new AGreaterOpcompare(
            cloneNode(this._opcompare_),
            cloneNode(this._greater_),
            cloneNode(this._value_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGreaterOpcompare(this);
    }

    public POpcompare getOpcompare()
    {
        return this._opcompare_;
    }

    public void setOpcompare(POpcompare node)
    {
        if(this._opcompare_ != null)
        {
            this._opcompare_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._opcompare_ = node;
    }

    public TGreater getGreater()
    {
        return this._greater_;
    }

    public void setGreater(TGreater node)
    {
        if(this._greater_ != null)
        {
            this._greater_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._greater_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._opcompare_)
            + toString(this._greater_)
            + toString(this._value_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._opcompare_ == child)
        {
            this._opcompare_ = null;
            return;
        }

        if(this._greater_ == child)
        {
            this._greater_ = null;
            return;
        }

        if(this._value_ == child)
        {
            this._value_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._opcompare_ == oldChild)
        {
            setOpcompare((POpcompare) newChild);
            return;
        }

        if(this._greater_ == oldChild)
        {
            setGreater((TGreater) newChild);
            return;
        }

        if(this._value_ == oldChild)
        {
            setValue((PValue) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
