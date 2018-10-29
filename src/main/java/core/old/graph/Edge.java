package core.old.graph;

/**
 * Created by anonymous on 07.05.2018.
 */
public class Edge<E, V> {
    public E value;
    public Vertex<E,V> v1;
    public Vertex<E,V> v2;

    public Edge(E value) {
        this.value = value;
        this.v1 = null;
        this.v2 = null;
    }

    public Edge(E value, Vertex<E,V> v1, Vertex<E,V> v2) {
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

    public Vertex<E,V> getV1() {
        return v1;
    }

    public void setV1(Vertex<E,V> v1) {
        this.v1 = v1;
    }

    public Vertex<E,V> getV2() {
        return v2;
    }

    public void setV2(Vertex<E,V> v2) {
        this.v2 = v2;
    }
}
