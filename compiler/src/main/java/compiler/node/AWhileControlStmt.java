/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AWhileControlStmt extends PControlStmt
{
    private TRepeat _repeat_;
    private TWhile _while_;
    private PCondition _condition_;
    private PBody _body_;

    public AWhileControlStmt()
    {
        // Constructor
    }

    public AWhileControlStmt(
        @SuppressWarnings("hiding") TRepeat _repeat_,
        @SuppressWarnings("hiding") TWhile _while_,
        @SuppressWarnings("hiding") PCondition _condition_,
        @SuppressWarnings("hiding") PBody _body_)
    {
        // Constructor
        setRepeat(_repeat_);

        setWhile(_while_);

        setCondition(_condition_);

        setBody(_body_);

    }

    @Override
    public Object clone()
    {
        return new AWhileControlStmt(
            cloneNode(this._repeat_),
            cloneNode(this._while_),
            cloneNode(this._condition_),
            cloneNode(this._body_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAWhileControlStmt(this);
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

    public TWhile getWhile()
    {
        return this._while_;
    }

    public void setWhile(TWhile node)
    {
        if(this._while_ != null)
        {
            this._while_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._while_ = node;
    }

    public PCondition getCondition()
    {
        return this._condition_;
    }

    public void setCondition(PCondition node)
    {
        if(this._condition_ != null)
        {
            this._condition_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._condition_ = node;
    }

    public PBody getBody()
    {
        return this._body_;
    }

    public void setBody(PBody node)
    {
        if(this._body_ != null)
        {
            this._body_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._body_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._repeat_)
            + toString(this._while_)
            + toString(this._condition_)
            + toString(this._body_);
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

        if(this._while_ == child)
        {
            this._while_ = null;
            return;
        }

        if(this._condition_ == child)
        {
            this._condition_ = null;
            return;
        }

        if(this._body_ == child)
        {
            this._body_ = null;
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

        if(this._while_ == oldChild)
        {
            setWhile((TWhile) newChild);
            return;
        }

        if(this._condition_ == oldChild)
        {
            setCondition((PCondition) newChild);
            return;
        }

        if(this._body_ == oldChild)
        {
            setBody((PBody) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
