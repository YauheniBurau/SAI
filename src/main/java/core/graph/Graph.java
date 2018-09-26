package core.graph;

/**
 * Created by anonymous on 07.05.2018.
 */

import java.util.ArrayList;

/**
 *
 * @param <E> type value for edge
 * @param <V> type value for Vertex
 */
public class Graph<E, V> {
    public ArrayList<Vertex<E,V>> vertexes = new ArrayList<Vertex<E,V>>();
    public ArrayList<Edge<E,V>> edges = new ArrayList<Edge<E,V>>();

    /**
     * add vertex to graph
     * @param value
     * @return
     */
    public Graph<E,V> addVertex(Vertex<E,V> value){
        this.vertexes.add(value);
        return this;
    }

    /**
     * add edge to graph
     * @param value
     * @return
     */
    public Graph<E,V> addEdge(Edge<E,V> value){
        this.edges.add(value);
        return this;
    }

    /**
     * create Vertex but not add to graph
     * @param value
     * @return
     */
    public Vertex<E,V> newVertex(V value){
        Vertex<E,V> v = new Vertex<E,V>(value);
        return v;
    }

    /**
     * create Edge but not add to graph, add crosslinks to edge and vertexes
     * @param value
     * @return
     */
    public Edge<E,V> newEdge(E value, Vertex<E,V> v1, Vertex<E,V> v2){
        Edge<E,V> edge = new Edge<E,V>(value);
        edge.setV1(v1);
        edge.setV2(v2);
        v1.edges.put(edge, v2);
        v2.edges.put(edge, v1);
        return edge;
    }

    // v1 = new Vertex(V value1)
    // v2 = new Vertex(V value2)
    // e = newEdge(E e, v1, v2);
    // this.addVertex(v1)
    // this.addVertex(V2)
    // this.addEdge(e);

}
