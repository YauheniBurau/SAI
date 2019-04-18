package core.application.graph;

/**
 * generate graph vertexes and edges for testing or demonstration functionality
 */
public class GraphGenerator {

    public static Graph<IVertex, IEdge> generate(int vertexesNumber, int edgesNumber){
        Graph<IVertex, IEdge> g = new Graph<>();
        int n;
        IVertex v;
        IEdge e;
        // VERTEXES
        for (n = 0; n < vertexesNumber; n++) {
            v = new Vertex<Integer>(n);
            g.addVertex(v);
        }
        // EDGES
        int start, end;
        for (n = 0; n < edgesNumber; n++) {
            start = (int)Math.round(Math.random()*(vertexesNumber-1));
            end = (int)Math.round(Math.random()*(vertexesNumber-1));
            e = new Edge<Integer>(n);
            e.setVertexU( g.getVertexes().get(start) );
            e.setVertexV( g.getVertexes().get(end) );
            g.addEdge(e);
        }
        return g;
    }
}
