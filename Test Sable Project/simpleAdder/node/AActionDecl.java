/* This file was generated by SableCC (http://www.sablecc.org/). */

package simpleAdder.node;

import simpleAdder.analysis.*;

@SuppressWarnings("nls")
public final class AActionDecl extends PDecl
{
    private PAction _action_;

    public AActionDecl()
    {
        // Constructor
    }

    public AActionDecl(
        @SuppressWarnings("hiding") PAction _action_)
    {
        // Constructor
        setAction(_action_);

    }

    @Override
    public Object clone()
    {
        return new AActionDecl(
            cloneNode(this._action_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAActionDecl(this);
    }

    public PAction getAction()
    {
        return this._action_;
    }

    public void setAction(PAction node)
    {
        if(this._action_ != null)
        {
            this._action_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._action_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._action_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._action_ == child)
        {
            this._action_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._action_ == oldChild)
        {
            setAction((PAction) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
