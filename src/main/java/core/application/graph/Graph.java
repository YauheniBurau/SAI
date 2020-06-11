package core.application.graph;

import java.util.Collection;
import java.util.TreeMap;

/**
 * Main Data Graph structure
 */
public class Graph<V extends IVertex, E extends IEdge>{
    private int vertexCounter = 0;
    private int edgeCounter = 0;
    private int id; // unique long id for Graph
    private String sId; // unique string id for Graph
    private TreeMap<Integer, V> vertexes = new TreeMap<>();
    private TreeMap<Integer, E> edges = new TreeMap<>();

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

    public V addVertex(int key, V value) {
        return this.vertexes.put(key, value);
    }

    public V removeVertex(int key) {
        IVertex vertex = this.getVertex(key);
        Collection<IEdge> edges = vertex.getEdges();
        for (IEdge edge: edges) {
            this.removeEdge(edge.geteId());
        }
        return this.vertexes.remove(key);
    }

    public void clearVertexes() {
        this.vertexes.clear();
    }

    public boolean containsValueVertex(V value) {
        return this.vertexes.containsValue(value);
    }

    public boolean containsKeyVertex(int key) {
        return this.vertexes.containsKey(key);
    }

    public E addEdge(int key, E value) {
        value.getVertexU().addEdge(value);
        value.getVertexV().addEdge(value);
        return this.edges.put(key, value);
    }

    public E removeEdge(int key) {
        IEdge edge = this.edges.get(key);
        edge.getVertexU().removeEdge(edge);
        edge.getVertexV().removeEdge(edge);
        return this.edges.remove(key);
    }

    public void clearEdges() {
        this.edges.clear();
    }

    public boolean containsValueEdge(E value) {
        return this.edges.containsValue(value);
    }

    public boolean containsKeyEdge(int key) {
        return this.edges.containsKey(key);
    }

    public Collection<V> getVertexes() {
        return vertexes.values();
    }

    public V getVertex(int key) {
        return vertexes.get(key);
    }

    public Collection<E> getEdges() {
        return edges.values();
    }

    public E getEdge(int key) {
        return edges.get(key);
    }

}
