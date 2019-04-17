package core.application.graph;

import java.util.Vector;

public class Vertex<T> implements IVertex<T>{
    private long id;
    private T value;
    private Vector<IEdge> edges = new Vector<>();

    public Vertex(T value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Vector<IEdge> getEdges() {
        return this.edges;
    }

    public boolean addEdge(IEdge e) {
        return this.edges.add(e);
    }

    public boolean removeEdge(IEdge e) {
        return this.edges.remove(e);
    }

    public boolean containsEdge(IEdge e) {
        return this.edges.contains(e);
    }

}
