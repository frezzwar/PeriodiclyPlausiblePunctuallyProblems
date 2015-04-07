/* This file was generated by SableCC (http://www.sablecc.org/). */

package simpleAdder.node;

import simpleAdder.analysis.*;

@SuppressWarnings("nls")
public final class AControlstructureDecl extends PDecl
{
    private PControlstructure _controlstructure_;

    public AControlstructureDecl()
    {
        // Constructor
    }

    public AControlstructureDecl(
        @SuppressWarnings("hiding") PControlstructure _controlstructure_)
    {
        // Constructor
        setControlstructure(_controlstructure_);

    }

    @Override
    public Object clone()
    {
        return new AControlstructureDecl(
            cloneNode(this._controlstructure_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAControlstructureDecl(this);
    }

    public PControlstructure getControlstructure()
    {
        return this._controlstructure_;
    }

    public void setControlstructure(PControlstructure node)
    {
        if(this._controlstructure_ != null)
        {
            this._controlstructure_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._controlstructure_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._controlstructure_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._controlstructure_ == child)
        {
            this._controlstructure_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._controlstructure_ == oldChild)
        {
            setControlstructure((PControlstructure) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}