package graph;

import com.orientechnologies.orient.core.record.OEdge;

public abstract class AbstractEdge implements IEdge{
    protected OEdge value = null;
    protected ICluster prev = null;
    protected ICluster next = null;

    @Override
    public ICluster getPrev() {
        return prev;
    }

    @Override
    public void setPrev(ICluster prev) {
        this.prev = prev;
    }

    @Override
    public ICluster getNext() {
        return next;
    }

    @Override
    public void setNext(ICluster next) {
        this.next = next;
    }

    @Override
    public OEdge getValue() {
        return value;
    }

    @Override
    public void setValue(OEdge value) {
        this.value = value;
    }
}
