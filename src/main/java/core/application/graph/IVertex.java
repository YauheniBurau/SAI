package core.application.graph;

import java.util.Vector;

/**
 * Created by anonymous on 03.11.2018.
 */
public interface IVertex<T> {
    int getvId();
    void setvId(int id);
    T getValue();
    void setValue(T value);
    Vector<IEdge> getEdges();
    boolean addEdge(IEdge e);
    boolean removeEdge(IEdge e);
    boolean containsEdge(IEdge e);

}
