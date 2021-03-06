/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AListVariable extends PVariable
{
    private TBrackL _brackL_;
    private PListVar _listVar_;
    private TBrackR _brackR_;

    public AListVariable()
    {
        // Constructor
    }

    public AListVariable(
        @SuppressWarnings("hiding") TBrackL _brackL_,
        @SuppressWarnings("hiding") PListVar _listVar_,
        @SuppressWarnings("hiding") TBrackR _brackR_)
    {
        // Constructor
        setBrackL(_brackL_);

        setListVar(_listVar_);

        setBrackR(_brackR_);

    }

    @Override
    public Object clone()
    {
        return new AListVariable(
            cloneNode(this._brackL_),
            cloneNode(this._listVar_),
            cloneNode(this._brackR_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListVariable(this);
    }

    public TBrackL getBrackL()
    {
        return this._brackL_;
    }

    public void setBrackL(TBrackL node)
    {
        if(this._brackL_ != null)
        {
            this._brackL_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._brackL_ = node;
    }

    public PListVar getListVar()
    {
        return this._listVar_;
    }

    public void setListVar(PListVar node)
    {
        if(this._listVar_ != null)
        {
            this._listVar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listVar_ = node;
    }

    public TBrackR getBrackR()
    {
        return this._brackR_;
    }

    public void setBrackR(TBrackR node)
    {
        if(this._brackR_ != null)
        {
            this._brackR_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._brackR_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._brackL_)
            + toString(this._listVar_)
            + toString(this._brackR_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._brackL_ == child)
        {
            this._brackL_ = null;
            return;
        }

        if(this._listVar_ == child)
        {
            this._listVar_ = null;
            return;
        }

        if(this._brackR_ == child)
        {
            this._brackR_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._brackL_ == oldChild)
        {
            setBrackL((TBrackL) newChild);
            return;
        }

        if(this._listVar_ == oldChild)
        {
            setListVar((PListVar) newChild);
            return;
        }

        if(this._brackR_ == oldChild)
        {
            setBrackR((TBrackR) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
