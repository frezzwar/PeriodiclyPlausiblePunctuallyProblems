/* This file was generated by SableCC (http://www.sablecc.org/). */

package compiler.node;

import compiler.analysis.*;

@SuppressWarnings("nls")
public final class AIfStmtControlStmt extends PControlStmt
{
    private TIf _if_;
    private PCondition _condition_;
    private PBody _body_;
    private PElseStmt _elseStmt_;

    public AIfStmtControlStmt()
    {
        // Constructor
    }

    public AIfStmtControlStmt(
        @SuppressWarnings("hiding") TIf _if_,
        @SuppressWarnings("hiding") PCondition _condition_,
        @SuppressWarnings("hiding") PBody _body_,
        @SuppressWarnings("hiding") PElseStmt _elseStmt_)
    {
        // Constructor
        setIf(_if_);

        setCondition(_condition_);

        setBody(_body_);

        setElseStmt(_elseStmt_);

    }

    @Override
    public Object clone()
    {
        return new AIfStmtControlStmt(
            cloneNode(this._if_),
            cloneNode(this._condition_),
            cloneNode(this._body_),
            cloneNode(this._elseStmt_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIfStmtControlStmt(this);
    }

    public TIf getIf()
    {
        return this._if_;
    }

    public void setIf(TIf node)
    {
        if(this._if_ != null)
        {
            this._if_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._if_ = node;
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

    public PElseStmt getElseStmt()
    {
        return this._elseStmt_;
    }

    public void setElseStmt(PElseStmt node)
    {
        if(this._elseStmt_ != null)
        {
            this._elseStmt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._elseStmt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._if_)
            + toString(this._condition_)
            + toString(this._body_)
            + toString(this._elseStmt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._if_ == child)
        {
            this._if_ = null;
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

        if(this._elseStmt_ == child)
        {
            this._elseStmt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._if_ == oldChild)
        {
            setIf((TIf) newChild);
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

        if(this._elseStmt_ == oldChild)
        {
            setElseStmt((PElseStmt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
