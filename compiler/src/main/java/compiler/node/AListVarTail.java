/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AListVarTail extends PListVarTail
{
    private TComma _comma_;
    private PValue _value_;

    public AListVarTail()
    {
        // Constructor
    }

    public AListVarTail(
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") PValue _value_)
    {
        // Constructor
        setComma(_comma_);

        setValue(_value_);

    }

    @Override
    public Object clone()
    {
        return new AListVarTail(
            cloneNode(this._comma_),
            cloneNode(this._value_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListVarTail(this);
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
            + toString(this._comma_)
            + toString(this._value_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._comma_ == child)
        {
            this._comma_ = null;
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
        if(this._comma_ == oldChild)
        {
            setComma((TComma) newChild);
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
