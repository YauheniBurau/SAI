package core.old.graph;

import java.util.HashMap;

/**
 * Created by anonymous on 07.05.2018.
 */
public class Vertex<E, V> {
    public V value;
    public HashMap<Edge<E,V>, Vertex<E,V>> edges = new HashMap<Edge<E, V>, Vertex<E, V>>();

    public Vertex(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
