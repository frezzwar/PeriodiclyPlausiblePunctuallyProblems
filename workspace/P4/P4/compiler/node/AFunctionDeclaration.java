/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AFunctionDeclaration extends PFunctionDeclaration
{
    private TNew _new_;
    private PDecls _decls_;

    public AFunctionDeclaration()
    {
        // Constructor
    }

    public AFunctionDeclaration(
        @SuppressWarnings("hiding") TNew _new_,
        @SuppressWarnings("hiding") PDecls _decls_)
    {
        // Constructor
        setNew(_new_);

        setDecls(_decls_);

    }

    @Override
    public Object clone()
    {
        return new AFunctionDeclaration(
            cloneNode(this._new_),
            cloneNode(this._decls_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFunctionDeclaration(this);
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

    public PDecls getDecls()
    {
        return this._decls_;
    }

    public void setDecls(PDecls node)
    {
        if(this._decls_ != null)
        {
            this._decls_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._decls_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._new_)
            + toString(this._decls_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._new_ == child)
        {
            this._new_ = null;
            return;
        }

        if(this._decls_ == child)
        {
            this._decls_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._new_ == oldChild)
        {
            setNew((TNew) newChild);
            return;
        }

        if(this._decls_ == oldChild)
        {
            setDecls((PDecls) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
