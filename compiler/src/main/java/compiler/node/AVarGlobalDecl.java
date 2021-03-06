/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AVarGlobalDecl extends PGlobalDecl
{
    private PVariableDecl _variableDecl_;

    public AVarGlobalDecl()
    {
        // Constructor
    }

    public AVarGlobalDecl(
        @SuppressWarnings("hiding") PVariableDecl _variableDecl_)
    {
        // Constructor
        setVariableDecl(_variableDecl_);

    }

    @Override
    public Object clone()
    {
        return new AVarGlobalDecl(
            cloneNode(this._variableDecl_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVarGlobalDecl(this);
    }

    public PVariableDecl getVariableDecl()
    {
        return this._variableDecl_;
    }

    public void setVariableDecl(PVariableDecl node)
    {
        if(this._variableDecl_ != null)
        {
            this._variableDecl_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._variableDecl_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._variableDecl_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._variableDecl_ == child)
        {
            this._variableDecl_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._variableDecl_ == oldChild)
        {
            setVariableDecl((PVariableDecl) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
