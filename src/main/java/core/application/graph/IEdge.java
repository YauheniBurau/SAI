package core.application.graph;

public interface IEdge<T> {
    int geteId();
    void seteId(int id);
    int getuId();
    Edge setuId(int uId);
    int getvId();
    Edge setvId(int vId);
    T getValue();
    Edge setValue(T value);
    IVertex getVertexU();
    Edge setVertexU(IVertex vertexU) ;
    IVertex getVertexV();
    Edge setVertexV(IVertex vertexV);
}
