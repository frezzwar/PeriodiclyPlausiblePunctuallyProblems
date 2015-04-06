/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import java.util.*;
import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AVarname extends PVarname
{
    private TIdentifier _identifier_;
    private final LinkedList<PIdlist> _idlist_ = new LinkedList<PIdlist>();

    public AVarname()
    {
        // Constructor
    }

    public AVarname(
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<?> _idlist_)
    {
        // Constructor
        setIdentifier(_identifier_);

        setIdlist(_idlist_);

    }

    @Override
    public Object clone()
    {
        return new AVarname(
            cloneNode(this._identifier_),
            cloneList(this._idlist_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVarname(this);
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

    public LinkedList<PIdlist> getIdlist()
    {
        return this._idlist_;
    }

    public void setIdlist(List<?> list)
    {
        for(PIdlist e : this._idlist_)
        {
            e.parent(null);
        }
        this._idlist_.clear();

        for(Object obj_e : list)
        {
            PIdlist e = (PIdlist) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._idlist_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifier_)
            + toString(this._idlist_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._idlist_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        for(ListIterator<PIdlist> i = this._idlist_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PIdlist) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
