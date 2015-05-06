/* This file was generated by SableCC (http://www.sablecc.org/). */

package simpleAdder.node;

import simpleAdder.analysis.*;

@SuppressWarnings("nls")
public final class ARepeatstructureControlstructure extends PControlstructure
{
    private TRepeat _repeat_;
    private PRepeatstructure _repeatstructure_;

    public ARepeatstructureControlstructure()
    {
        // Constructor
    }

    public ARepeatstructureControlstructure(
        @SuppressWarnings("hiding") TRepeat _repeat_,
        @SuppressWarnings("hiding") PRepeatstructure _repeatstructure_)
    {
        // Constructor
        setRepeat(_repeat_);

        setRepeatstructure(_repeatstructure_);

    }

    @Override
    public Object clone()
    {
        return new ARepeatstructureControlstructure(
            cloneNode(this._repeat_),
            cloneNode(this._repeatstructure_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARepeatstructureControlstructure(this);
    }

    public TRepeat getRepeat()
    {
        return this._repeat_;
    }

    public void setRepeat(TRepeat node)
    {
        if(this._repeat_ != null)
        {
            this._repeat_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._repeat_ = node;
    }

    public PRepeatstructure getRepeatstructure()
    {
        return this._repeatstructure_;
    }

    public void setRepeatstructure(PRepeatstructure node)
    {
        if(this._repeatstructure_ != null)
        {
            this._repeatstructure_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._repeatstructure_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._repeat_)
            + toString(this._repeatstructure_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._repeat_ == child)
        {
            this._repeat_ = null;
            return;
        }

        if(this._repeatstructure_ == child)
        {
            this._repeatstructure_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._repeat_ == oldChild)
        {
            setRepeat((TRepeat) newChild);
            return;
        }

        if(this._repeatstructure_ == oldChild)
        {
            setRepeatstructure((PRepeatstructure) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}