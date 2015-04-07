/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class ARnd extends PRnd
{
    private TRandom _random_;
    private TParL _parL_;
    private PValue _left_;
    private TTo _to_;
    private PValue _right_;
    private TParR _parR_;

    public ARnd()
    {
        // Constructor
    }

    public ARnd(
        @SuppressWarnings("hiding") TRandom _random_,
        @SuppressWarnings("hiding") TParL _parL_,
        @SuppressWarnings("hiding") PValue _left_,
        @SuppressWarnings("hiding") TTo _to_,
        @SuppressWarnings("hiding") PValue _right_,
        @SuppressWarnings("hiding") TParR _parR_)
    {
        // Constructor
        setRandom(_random_);

        setParL(_parL_);

        setLeft(_left_);

        setTo(_to_);

        setRight(_right_);

        setParR(_parR_);

    }

    @Override
    public Object clone()
    {
        return new ARnd(
            cloneNode(this._random_),
            cloneNode(this._parL_),
            cloneNode(this._left_),
            cloneNode(this._to_),
            cloneNode(this._right_),
            cloneNode(this._parR_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARnd(this);
    }

    public TRandom getRandom()
    {
        return this._random_;
    }

    public void setRandom(TRandom node)
    {
        if(this._random_ != null)
        {
            this._random_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._random_ = node;
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

    public PValue getLeft()
    {
        return this._left_;
    }

    public void setLeft(PValue node)
    {
        if(this._left_ != null)
        {
            this._left_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._left_ = node;
    }

    public TTo getTo()
    {
        return this._to_;
    }

    public void setTo(TTo node)
    {
        if(this._to_ != null)
        {
            this._to_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._to_ = node;
    }

    public PValue getRight()
    {
        return this._right_;
    }

    public void setRight(PValue node)
    {
        if(this._right_ != null)
        {
            this._right_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._right_ = node;
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
            + toString(this._random_)
            + toString(this._parL_)
            + toString(this._left_)
            + toString(this._to_)
            + toString(this._right_)
            + toString(this._parR_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._random_ == child)
        {
            this._random_ = null;
            return;
        }

        if(this._parL_ == child)
        {
            this._parL_ = null;
            return;
        }

        if(this._left_ == child)
        {
            this._left_ = null;
            return;
        }

        if(this._to_ == child)
        {
            this._to_ = null;
            return;
        }

        if(this._right_ == child)
        {
            this._right_ = null;
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
        if(this._random_ == oldChild)
        {
            setRandom((TRandom) newChild);
            return;
        }

        if(this._parL_ == oldChild)
        {
            setParL((TParL) newChild);
            return;
        }

        if(this._left_ == oldChild)
        {
            setLeft((PValue) newChild);
            return;
        }

        if(this._to_ == oldChild)
        {
            setTo((TTo) newChild);
            return;
        }

        if(this._right_ == oldChild)
        {
            setRight((PValue) newChild);
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