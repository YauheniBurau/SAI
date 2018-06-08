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
    public ArrayList<Vertex<V>> vertexes = new ArrayList<Vertex<V>>();
    public ArrayList<Edge<E,V>> edges = new ArrayList<Edge<E,V>>();

}
