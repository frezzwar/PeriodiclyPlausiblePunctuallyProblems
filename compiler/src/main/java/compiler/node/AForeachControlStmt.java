/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AForeachControlStmt extends PControlStmt
{
    private TRepeat _repeat_;
    private TForeach _foreach_;
    private TParL _parL_;
    private TIdentifier _identifier_;
    private TIn _in_;
    private TIdentifier _list_;
    private TParR _parR_;
    private PBody _body_;

    public AForeachControlStmt()
    {
        // Constructor
    }

    public AForeachControlStmt(
        @SuppressWarnings("hiding") TRepeat _repeat_,
        @SuppressWarnings("hiding") TForeach _foreach_,
        @SuppressWarnings("hiding") TParL _parL_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") TIn _in_,
        @SuppressWarnings("hiding") TIdentifier _list_,
        @SuppressWarnings("hiding") TParR _parR_,
        @SuppressWarnings("hiding") PBody _body_)
    {
        // Constructor
        setRepeat(_repeat_);

        setForeach(_foreach_);

        setParL(_parL_);

        setIdentifier(_identifier_);

        setIn(_in_);

        setList(_list_);

        setParR(_parR_);

        setBody(_body_);

    }

    @Override
    public Object clone()
    {
        return new AForeachControlStmt(
            cloneNode(this._repeat_),
            cloneNode(this._foreach_),
            cloneNode(this._parL_),
            cloneNode(this._identifier_),
            cloneNode(this._in_),
            cloneNode(this._list_),
            cloneNode(this._parR_),
            cloneNode(this._body_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAForeachControlStmt(this);
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

    public TForeach getForeach()
    {
        return this._foreach_;
    }

    public void setForeach(TForeach node)
    {
        if(this._foreach_ != null)
        {
            this._foreach_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._foreach_ = node;
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

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    public TIn getIn()
    {
        return this._in_;
    }

    public void setIn(TIn node)
    {
        if(this._in_ != null)
        {
            this._in_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._in_ = node;
    }

    public TIdentifier getList()
    {
        return this._list_;
    }

    public void setList(TIdentifier node)
    {
        if(this._list_ != null)
        {
            this._list_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._list_ = node;
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
            + toString(this._foreach_)
            + toString(this._parL_)
            + toString(this._identifier_)
            + toString(this._in_)
            + toString(this._list_)
            + toString(this._parR_)
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

        if(this._foreach_ == child)
        {
            this._foreach_ = null;
            return;
        }

        if(this._parL_ == child)
        {
            this._parL_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._in_ == child)
        {
            this._in_ = null;
            return;
        }

        if(this._list_ == child)
        {
            this._list_ = null;
            return;
        }

        if(this._parR_ == child)
        {
            this._parR_ = null;
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

        if(this._foreach_ == oldChild)
        {
            setForeach((TForeach) newChild);
            return;
        }

        if(this._parL_ == oldChild)
        {
            setParL((TParL) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._in_ == oldChild)
        {
            setIn((TIn) newChild);
            return;
        }

        if(this._list_ == oldChild)
        {
            setList((TIdentifier) newChild);
            return;
        }

        if(this._parR_ == oldChild)
        {
            setParR((TParR) newChild);
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
