package core.graph;

/**
 * Created by anonymous on 07.05.2018.
 */
public class Vertex<V> {
    public V value;

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
