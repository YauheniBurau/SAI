package core.application.dataElement.graph;

import core.application.dataElement.AbstractElement;

import java.util.HashSet;

/**
 * Created by anonymous on 17.11.2018.
 */
public abstract class AbstractVertex<TValue extends AbstractElement> implements IVertex {
    private TValue value = null;
    private AbstractVertex<TValue> parent = null;
    private HashSet<AbstractVertex<TValue>> childs = new HashSet<>();

    public TValue getValue() {
        return value;
    }

    public void setValue(TValue value) {
        this.value = value;
    }

    public AbstractVertex<TValue> getParent() {
        return parent;
    }

    public void setParent(AbstractVertex<TValue> parent) {
        this.parent = parent;
    }

    public HashSet<AbstractVertex<TValue>> getChilds() {
        return childs;
    }

    public void setChilds(HashSet<AbstractVertex<TValue>> childs) {
        this.childs = childs;
    }

    public boolean add(AbstractVertex<TValue> e) {
        return this.childs.add(e);
    }

    public boolean remove(AbstractVertex<TValue> e) {
        return this.childs.remove(e);
    }

}
