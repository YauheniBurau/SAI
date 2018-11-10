package core.old.graph;

/**
 * Created by anonymous on 07.05.2018.
 */

import java.util.ArrayList;

/**
 *
 * @param <E> type value for edge
 * @param <V> type value for Vertex
 */
public class Graph<V, E> {
    public ArrayList<Vertex<V,E>> vertexes = new ArrayList<Vertex<V,E>>();
    public ArrayList<Edge<V,E>> edges = new ArrayList<Edge<V,E>>();

    /**
     * add vertex to graph
     * @param value
     * @return
     */
    public Graph<V,E> addVertex(Vertex<V,E> value){
        this.vertexes.add(value);
        return this;
    }

    /**
     * add edge to graph
     * @param value
     * @return
     */
    public Graph<V,E> addEdge(Edge<V,E> value){
        this.edges.add(value);
        return this;
    }

    /**
     * create Vertex but not add to graph
     * @param value
     * @return
     */
    public Vertex<V,E> newVertex(V value){
        Vertex<V,E> v = new Vertex<V,E>(value);
        return v;
    }

    /**
     * create Edge but not add to graph, add crosslinks to edge and vertexes
     * @param value
     * @return
     */
    public Edge<V,E> newEdge(E value, Vertex<V,E> v1, Vertex<V,E> v2){
        Edge<V,E> edge = new Edge<V,E>(value);
        edge.setV1(v1);
        edge.setV2(v2);
        // TODO: add check if edge already exists to avoid duplicates for pair of allready connected two vertexes
        v1.edges.add(edge);
        v2.edges.add(edge);
        return edge;
    }

    // v1 = new Vertex(V value1)
    // v2 = new Vertex(V value2)
    // e = newEdge(E e, v1, v2);
    // this.addVertex(v1)
    // this.addVertex(V2)
    // this.addEdge(e);

}
