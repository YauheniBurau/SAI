package core.application.gui.graphFxComponent.view;

import core.old.Decart3d;
import core.application.gui.graphFxComponent.model.Polar3d;
import javafx.scene.layout.Pane;
import org.apache.commons.lang.RandomStringUtils;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;

public class Graph2dFx extends Pane {
    private Graph<Vertex2dFx, Edge2dFx> graph;

    public Graph2dFx() {
        this.graph = new DefaultDirectedGraph<>(Edge2dFx.class);
    }

    public void addVertex(Vertex2dFx v){
        this.graph.addVertex(v);
        this.getChildren().add(v);
    }

    public void addEdge(Vertex2dFx v1, Vertex2dFx v2, Edge2dFx e){
        this.graph.addEdge(v1, v2, e);
        this.getChildren().add(e);
    }

    public void deleteVertex(Vertex2dFx v){

    }

    public void deleteEdge(Vertex2dFx e){

    }

    public void generate(int vertexesNumber, int edgesNumber){
        int n;
        Vertex2dFx stV, enV;
        Edge2dFx e;
        // VERTEXES
        for (n = 0; n < vertexesNumber; n++) {
            this.addVertex(Vertex2dFxFactory.newVDataChar(RandomStringUtils.random(1, true, false) ));
        }
        // EDGES
        int start, end;
        Object[] vertexes = this.graph.vertexSet().toArray();
        for (n = 0; n < edgesNumber; n++) {
            start = (int)Math.round(Math.random()*(vertexesNumber-1));
            end = (int)Math.round(Math.random()*(vertexesNumber-1));
            if(start!=end) {
                stV = (Vertex2dFx) vertexes[start];
                enV = (Vertex2dFx) vertexes[end];
                e = Edge2dFxFactory.newEPrevNext(stV, enV);
                this.addEdge(stV, enV, e);
            }else{
                // add cycle edge where start and end vertex are the same
            }
        }
    }

    public void orderVertexesInSphere(int sphereRadius){
        double r;
        double latitudeAngle;
        double longitudeAngle;
        Decart3d p3d;
        for(Vertex2dFx v: this.graph.vertexSet()) {
            r = Math.random()*sphereRadius;
            latitudeAngle = Math.random()*2*Math.PI;
            longitudeAngle = Math.random()*2*Math.PI;
            p3d = new Polar3d(r, latitudeAngle, longitudeAngle).toDecart3d();
            v.x().set(p3d.getX());
            v.y().set(p3d.getY());
            v.z().set(p3d.getZ());
        }
    }

}

//    private ListenableGraph listenableGraph;
//    private HashMap<AbstractVertex, AbstractVertexViewFx> vertexMapping = new HashMap<>();
//    private HashMap<AbstractEdge, AbstractEdgeViewFx> edgeMapping = new HashMap<>();

//    public GraphPaneFx(Graph<AbstractVertexViewFx, AbstractEdgeViewFx> graph) {
//        this.graph = graph;
//        // this.listenableGraph = new DefaultListenableGraph(this.graph);
//    }
