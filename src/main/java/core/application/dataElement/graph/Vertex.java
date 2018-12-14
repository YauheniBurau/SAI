package core.application.dataElement.graph;

import java.util.HashSet;

/**
 * Created by anonymous on 17.11.2018.
 */
public class Vertex<TValue> implements IVertex {
    private TValue value = null;
    private Vertex<TValue> parent = null;
    private HashSet<Vertex<TValue>> childs = new HashSet<>();

    public Vertex() {

    }

    public Vertex(TValue value) {
        this.value = value;
    }

    public TValue getValue() {
        return value;
    }

    public void setValue(TValue value) {
        this.value = value;
    }

    public Vertex<TValue> getParent() {
        return parent;
    }

    public void setParent(Vertex<TValue> parent) {
        this.parent = parent;
    }

    public HashSet<Vertex<TValue>> getChilds() {
        return childs;
    }

    public void setChilds(HashSet<Vertex<TValue>> childs) {
        this.childs = childs;
    }

    public boolean add(Vertex<TValue> e) {
        return this.childs.add(e);
    }

    public boolean remove(Vertex<TValue> e) {
        return this.childs.remove(e);
    }

}
