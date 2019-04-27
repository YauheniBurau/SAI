package core.application.graph;

/**
 * generate graph vertexes and edges for testing or demonstration functionality
 */
public class GraphGenerator {

    public static GraphModel generate(int vertexesNumber, int edgesNumber){
        GraphModel g = new GraphModel();
        g.setId(0);
        g.setsId("TestGraph");
        int n;
        IVertex v;
        IEdge e;
        // VERTEXES
        for (n = 0; n < vertexesNumber; n++) {
            v = new Vertex<Integer>(n);
            v.setId( g.askVertexCounter() );
            g.addVertex(v);
        }
        // EDGES
        int start, end;
        for (n = 0; n < edgesNumber; n++) {
            start = (int)Math.round(Math.random()*(vertexesNumber-1));
            end = (int)Math.round(Math.random()*(vertexesNumber-1));
            e = new Edge<Integer>(n);
            e.setId( g.askEdgeCounter() );
            e.setVertexU( g.getVertexes().get(start) );
            e.setVertexV( g.getVertexes().get(end) );
            g.addEdge(e);
        }
        return g;
    }
}
