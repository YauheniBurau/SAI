package core.application.graph;

import java.util.Vector;

/**
 * Created by anonymous on 03.11.2018.
 */
public interface IVertex<T> {
    long getId();
    void setId(long id);
    T getValue();
    void setValue(T value);
    Vector<IEdge> getEdges();
    boolean addEdge(IEdge e);
    boolean removeEdge(IEdge e);
    boolean containsEdge(IEdge e);

}
