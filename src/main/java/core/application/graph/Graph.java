package core.application.graph;

import java.util.Vector;

/**
 * Created by anonymous on 02.12.2018.
 */
public final class Graph<V, E>{
    private long id; // unique long id for Graph
    private String sId; // unique string id for Graph
    private Vector<V> vertexes = new Vector<>();
    private Vector<E> edges = new Vector<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public boolean addVertex(V value) {
        return this.vertexes.add(value);
    }

    public boolean removeVertex(V value) {
        return this.vertexes.remove(value);
        // TODO: remove all edges
    }

    public boolean containsVertex(V value) {
        return this.vertexes.contains(value);
    }


    public boolean addEdge(E value) {
        return this.edges.add(value);
        // TODO: add alslo into vertexes links to edges
    }

    public boolean removeEdge(E value) {
        return this.edges.remove(value);
        // TODO: remove links from vertexes
    }

    public boolean containsEdge(E value) {
        return this.edges.contains(value);
    }

    public Vector<V> getVertexes() {
        return vertexes;
    }

    public Vector<E> getEdges() {
        return edges;
    }



}
