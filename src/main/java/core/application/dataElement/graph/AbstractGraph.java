package core.application.dataElement.graph;

import java.util.HashSet;

/**
 * Created by anonymous on 02.12.2018.
 */
public class AbstractGraph<T extends IVertex> implements IGraph {
    private HashSet<T> vertexes = new HashSet<>();
    private T rootVertex = null;

    public HashSet<T> getVertexes() {
        return vertexes;
    }

    public void setVertexes(HashSet<T> vertexes) {
        this.vertexes = vertexes;
    }

    public T getRootVertex() {
        return rootVertex;
    }

    public void setRootVertex(T rootVertex) {
        this.rootVertex = rootVertex;
    }

    public boolean add(T E) {
        return this.vertexes.add(E);
    }

    public boolean remove(T E) {
        return this.vertexes.remove(E);
    }

    public boolean contains(T e) {
        return this.vertexes.contains(e);
    }

}
