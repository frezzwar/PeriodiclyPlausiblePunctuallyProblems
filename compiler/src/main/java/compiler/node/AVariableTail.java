/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AVariableTail extends PVariableTail
{
    private TComma _comma_;
    private TNew _new_;
    private TIdentifier _identifier_;
    private TAssign _assign_;
    private PVariables _variables_;

    public AVariableTail()
    {
        // Constructor
    }

    public AVariableTail(
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") TNew _new_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") TAssign _assign_,
        @SuppressWarnings("hiding") PVariables _variables_)
    {
        // Constructor
        setComma(_comma_);

        setNew(_new_);

        setIdentifier(_identifier_);

        setAssign(_assign_);

        setVariables(_variables_);

    }

    @Override
    public Object clone()
    {
        return new AVariableTail(
            cloneNode(this._comma_),
            cloneNode(this._new_),
            cloneNode(this._identifier_),
            cloneNode(this._assign_),
            cloneNode(this._variables_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVariableTail(this);
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

    public TNew getNew()
    {
        return this._new_;
    }

    public void setNew(TNew node)
    {
        if(this._new_ != null)
        {
            this._new_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._new_ = node;
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

    public TAssign getAssign()
    {
        return this._assign_;
    }

    public void setAssign(TAssign node)
    {
        if(this._assign_ != null)
        {
            this._assign_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._assign_ = node;
    }

    public PVariables getVariables()
    {
        return this._variables_;
    }

    public void setVariables(PVariables node)
    {
        if(this._variables_ != null)
        {
            this._variables_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._variables_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._comma_)
            + toString(this._new_)
            + toString(this._identifier_)
            + toString(this._assign_)
            + toString(this._variables_);
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

        if(this._new_ == child)
        {
            this._new_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._assign_ == child)
        {
            this._assign_ = null;
            return;
        }

        if(this._variables_ == child)
        {
            this._variables_ = null;
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

        if(this._new_ == oldChild)
        {
            setNew((TNew) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._assign_ == oldChild)
        {
            setAssign((TAssign) newChild);
            return;
        }

        if(this._variables_ == oldChild)
        {
            setVariables((PVariables) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}