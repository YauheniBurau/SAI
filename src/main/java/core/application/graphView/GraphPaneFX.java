package core.application.graphView;

import core.application.graph.Graph;
import core.application.graph.IEdge;
import core.application.graph.IVertex;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 * GraphPaneFX SubScene component for visualization Graph
 */
public class GraphPaneFX extends Group implements IGraphFX{
    private Graph<IVertex, IEdge> graph = new Graph<>();
    private Graph<IVertexFX, IEdgeFX> graphFX = new Graph<>();
    private ArrayList<LightBase> lights = new ArrayList<>();
    private int divisions = 8;

    public Graph<IVertexFX, IEdgeFX> getGraphFX() {
        return graphFX;
    }

    public Graph<IVertex, IEdge> getGraph() {
        return graph;
    }

    public GraphPaneFX setGraph(Graph<IVertex, IEdge> graph) {
        HashMap<IVertex, VertexFX> map = new HashMap<>();
        // clear all
        this.getChildren().clear();
        // set new data
        this.graph = graph;
        graphFX = new Graph<>();
        // restore lights
        this.getChildren().addAll(this.lights);
        // create FX vertexes and edges
        Vector<IVertex> vertexes = graph.getVertexes();
        VertexFX vFX;
        for (IVertex v: vertexes) {
            vFX = new VertexFX(v, this.divisions);
            map.put(v, vFX);
            graphFX.addVertex(vFX);
            this.getChildren().add(vFX);
        }
        // init of EdgesFX into Pane
        Vector<IEdge> edges = graph.getEdges();
        EdgeFX eFX;
        for (IEdge e: edges) {
            eFX = new EdgeFX(e, this.divisions)
                    .setVertexU(map.get(e.getVertexU()))
                    .setVertexV(map.get(e.getVertexV()));
            graphFX.addEdge(eFX);
            this.getChildren().add(eFX);
        }

        return this;
    }

    public GraphPaneFX addLight(LightBase light){
        this.lights.add(light);
        this.getChildren().add(light);
        return this;
    }

    public void removeLight(LightBase light){
        this.lights.remove(light);
        this.getChildren().remove(light);
    }

    public int getDivisions() {
        return divisions;
    }

    /**
     * will cause of redrawing all components like vertexes and edges, so need reinit graph
     * @param divisions
     */
    public GraphPaneFX setDivisions(int divisions) {
        this.divisions = divisions;
        // TODO:
        return this;
    }


}
