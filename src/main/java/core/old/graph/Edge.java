package core.old.graph;

/**
 * Created by anonymous on 07.05.2018.
 */
public class Edge<V,E> {
    public E value;
    public Vertex<V,E> v1;
    public Vertex<V,E> v2;

    public Edge(E value) {
        this.value = value;
        this.v1 = null;
        this.v2 = null;
    }

    public Edge(E value, Vertex<V,E> v1, Vertex<V,E> v2) {
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

    public Vertex<V,E> getV1() {
        return v1;
    }

    public void setV1(Vertex<V,E> v1) {
        this.v1 = v1;
    }

    public Vertex<V,E> getV2() {
        return v2;
    }

    public void setV2(Vertex<V,E> v2) {
        this.v2 = v2;
    }
}
