package core.application.graphView;

import core.application.graph.Graph;
import core.application.graph.IEdge;
import core.application.graph.IVertex;

import java.util.HashMap;
import java.util.Vector;

// TODO: write with GraphModel and GraphView classes
/**
 * base abstract class for all GraphLayout
 * contains static method for generation GraphView with empty coordinates
 */
public abstract class AbstractGraphLayout {
    /**
     * from graphModel generate graphView with empty coordinates
     * @param graph
     * @param divisions
     * @return
     */
    public static Graph<IVertexFX, IEdgeFX> graphModelToGraphView(Graph<IVertex, IEdge> graph, int divisions){
        HashMap<IVertex, VertexFX> map = new HashMap<>();
        Graph<IVertexFX, IEdgeFX> graphView = new Graph<>();
        // create FX vertexesFX and edges
        Vector<IVertex> vertexes = graph.getVertexes();
        VertexFX vFX;
        for (IVertex v: vertexes) {
            vFX = new VertexFX(v, divisions);
            map.put(v, vFX);
            graphView.addVertex(vFX);
        }
        // init EdgesFX into Pane
        Vector<IEdge> edges = graph.getEdges();
        EdgeFX eFX;
        for (IEdge e: edges) {
            eFX = new EdgeFX(e, divisions)
                    .setVertexU(map.get(e.getVertexU()))
                    .setVertexV(map.get(e.getVertexV()));
            graphView.addEdge(eFX);
        }
        return graphView;
    }
}
