package core.application.dataElement.graph;

import core.old.graph.Edge;

import java.util.ArrayList;

/**
 * Created by anonymous on 07.05.2018.
 * T - type of value in Vertex
 * E - Type of value in Edge
 */
public class Vertex<T> {
    public T value;
    public ArrayList<IVertex> connections = new ArrayList<IVertex>();

    public Vertex(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
