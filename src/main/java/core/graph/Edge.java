package core.graph;

/**
 * Created by anonymous on 07.05.2018.
 */
public class Edge<E, V> {
    public E value;
    public Vertex<V> v1;
    public Vertex<V> v2;

    public Edge(E value, Vertex<V> v1, Vertex<V> v2) {
        this.value = value;
        this.v1 = v1;
        this.v2 = v2;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Vertex<V> getV1() {
        return v1;
    }

    public void setV1(Vertex<V> v1) {
        this.v1 = v1;
    }

    public Vertex<V> getV2() {
        return v2;
    }

    public void setV2(Vertex<V> v2) {
        this.v2 = v2;
    }
}
