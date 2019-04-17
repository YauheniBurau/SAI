package core.application.graph;

public interface IEdge<T> {
    long getId();
    void setId(long id);
    T getValue();
    void setValue(T value);
    IVertex getVertexU();
    void setVertexU(IVertex vertexU) ;
    IVertex getVertexV();
    void setVertexV(IVertex vertexV);
}
