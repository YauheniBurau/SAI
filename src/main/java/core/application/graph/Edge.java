package core.application.graph;

public class Edge<T> implements IEdge<T>{
    private long id;
    private T value;
    private IVertex vertexU;
    private IVertex vertexV;

    public Edge(T value) {
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

    public IVertex getVertexU() {
        return vertexU;
    }

    public void setVertexU(IVertex vertexU) {
        this.vertexU = vertexU;
    }

    public IVertex getVertexV() {
        return vertexV;
    }

    public void setVertexV(IVertex vertexV) {
        this.vertexV = vertexV;
    }

}