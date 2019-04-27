package core.application.graph;

import java.util.Vector;

/**
 * Main Data Graph structure
 */
public class Graph<V, E>{
    private int vertexCounter = 0;
    private int edgeCounter = 0;
    private int id; // unique long id for Graph
    private String sId; // unique string id for Graph
    private Vector<V> vertexes = new Vector<>();
    private Vector<E> edges = new Vector<>();

    public Graph() {

    }

    public int getVertexCounter() {
        return vertexCounter;
    }

    public void setVertexCounter(int vertexCounter) {
        this.vertexCounter = vertexCounter;
    }

    public int askVertexCounter() {
        this.vertexCounter+=1;
        return this.vertexCounter;
    }

    public int getEdgeCounter() {
        return edgeCounter;
    }

    public void setEdgeCounter(int edgeCounter) {
        this.edgeCounter = edgeCounter;
    }

    public int askEdgeCounter() {
        this.edgeCounter+=1;
        return this.edgeCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void clearVertexes() {
        this.vertexes.clear();
    }

    public boolean containsVertex(V value) {
        return this.vertexes.contains(value);
    }

    public boolean addEdge(E value) {
        return this.edges.add(value);
        // TODO: add also into vertexes links to edges
    }

    public boolean removeEdge(E value) {
        return this.edges.remove(value);
        // TODO: remove links from vertexes
    }

    public void clearEdges() {
        this.edges.clear();
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
