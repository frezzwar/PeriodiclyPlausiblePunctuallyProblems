/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import java.util.*;
import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AObjBody extends PObjBody
{
    private TCurlyL _curlyL_;
    private final LinkedList<PInObjDecl> _inObjDecl_ = new LinkedList<PInObjDecl>();
    private TCurlyR _curlyR_;

    public AObjBody()
    {
        // Constructor
    }

    public AObjBody(
        @SuppressWarnings("hiding") TCurlyL _curlyL_,
        @SuppressWarnings("hiding") List<?> _inObjDecl_,
        @SuppressWarnings("hiding") TCurlyR _curlyR_)
    {
        // Constructor
        setCurlyL(_curlyL_);

        setInObjDecl(_inObjDecl_);

        setCurlyR(_curlyR_);

    }

    @Override
    public Object clone()
    {
        return new AObjBody(
            cloneNode(this._curlyL_),
            cloneList(this._inObjDecl_),
            cloneNode(this._curlyR_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAObjBody(this);
    }

    public TCurlyL getCurlyL()
    {
        return this._curlyL_;
    }

    public void setCurlyL(TCurlyL node)
    {
        if(this._curlyL_ != null)
        {
            this._curlyL_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._curlyL_ = node;
    }

    public LinkedList<PInObjDecl> getInObjDecl()
    {
        return this._inObjDecl_;
    }

    public void setInObjDecl(List<?> list)
    {
        for(PInObjDecl e : this._inObjDecl_)
        {
            e.parent(null);
        }
        this._inObjDecl_.clear();

        for(Object obj_e : list)
        {
            PInObjDecl e = (PInObjDecl) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._inObjDecl_.add(e);
        }
    }

    public TCurlyR getCurlyR()
    {
        return this._curlyR_;
    }

    public void setCurlyR(TCurlyR node)
    {
        if(this._curlyR_ != null)
        {
            this._curlyR_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._curlyR_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._curlyL_)
            + toString(this._inObjDecl_)
            + toString(this._curlyR_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._curlyL_ == child)
        {
            this._curlyL_ = null;
            return;
        }

        if(this._inObjDecl_.remove(child))
        {
            return;
        }

        if(this._curlyR_ == child)
        {
            this._curlyR_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._curlyL_ == oldChild)
        {
            setCurlyL((TCurlyL) newChild);
            return;
        }

        for(ListIterator<PInObjDecl> i = this._inObjDecl_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PInObjDecl) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._curlyR_ == oldChild)
        {
            setCurlyR((TCurlyR) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
