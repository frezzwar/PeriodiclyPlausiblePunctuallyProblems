/* This file was generated by SableCC (http://www.sablecc.org/). */

package simpleAdder.node;

import simpleAdder.analysis.*;

@SuppressWarnings("nls")
public final class ADeclsDecls extends PDecls
{
    private PDecl _decl_;
    private PDecls _decls_;

    public ADeclsDecls()
    {
        // Constructor
    }

    public ADeclsDecls(
        @SuppressWarnings("hiding") PDecl _decl_,
        @SuppressWarnings("hiding") PDecls _decls_)
    {
        // Constructor
        setDecl(_decl_);

        setDecls(_decls_);

    }

    @Override
    public Object clone()
    {
        return new ADeclsDecls(
            cloneNode(this._decl_),
            cloneNode(this._decls_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADeclsDecls(this);
    }

    public PDecl getDecl()
    {
        return this._decl_;
    }

    public void setDecl(PDecl node)
    {
        if(this._decl_ != null)
        {
            this._decl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._decl_ = node;
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
            + toString(this._decl_)
            + toString(this._decls_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._decl_ == child)
        {
            this._decl_ = null;
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
        if(this._decl_ == oldChild)
        {
            setDecl((PDecl) newChild);
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
