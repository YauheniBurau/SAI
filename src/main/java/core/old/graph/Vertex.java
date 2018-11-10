package core.old.graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by anonymous on 07.05.2018.
 * V - type of value in Vertex
 * E - Type of value in Edge
 */
public class Vertex<V, E> {
    public V value;
    public ArrayList<Edge<V,E>> edges = new ArrayList<Edge<V,E>>();

    public Vertex(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    // TODO: add check if edge already exists to avoid duplicates for pair of allready connected two vertexes
    // TODO: add method add edge
}
