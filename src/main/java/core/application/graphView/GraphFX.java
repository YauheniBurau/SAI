package core.application.graphView;

import core.application.graph.Graph;
import core.application.graph.IEdge;
import core.application.graph.IVertex;
import javafx.scene.layout.Pane;

import java.util.Vector;

public class GraphFX extends Pane implements IGraphFX{
    private Graph<IVertex, IEdge> graph = new Graph<>();
    private Graph<IVertexFX, IEdgeFX> graphFX = new Graph<>();
    private int divisions = 8;

    public Graph<IVertexFX, IEdgeFX> getGraphFX() {
        return graphFX;
    }

    public Graph<IVertex, IEdge> getGraph() {
        return graph;
    }

    public int getDivisions() {
        return divisions;
    }

    public void setDivisions(int divisions) {
        this.divisions = divisions;
    }

    public void setGraph(Graph<IVertex, IEdge> graph) {
        this.graph = graph;
        Vector<IVertex> vertexes = graph.getVertexes();
        IVertexFX vFX;
        for (IVertex v: vertexes) {
            vFX = new VertexFX(v, this.divisions);
            graphFX.addVertex(vFX);
        }
//            vertex.setTranslateX(-graphRadius + Math.random()*2*graphRadius);
//            vertex.setTranslateY(-graphRadius + Math.random()*2*graphRadius);
//            vertex.setTranslateZ(-graphRadius + Math.random()*2*graphRadius);
//            pane3dFX.getChildren().add(vertex);
//        }

        // create all visible vertexFX and edgeFX from model
//        EDGES
//        long edges;
//        Cylinder line3d;
//        Sphere sV, eV;
//        Point3D pS, pE;
//        int ii;
//        for (int i = 0 ; i<VertexesNumber; i++) {
//            edges = Math.round(Math.random()*5000);
//            for (int j = 0;j<edges;j++){
//                ii = (int)Math.round(Math.random()*(VertexesNumber-1));
//                sV = vertexes[i];
//                eV = vertexes[ii];
//                pS = new Point3D(sV.getTranslateX(), sV.getTranslateY(), sV.getTranslateZ());
//                pE = new Point3D(eV.getTranslateX(), eV.getTranslateY(), eV.getTranslateZ());
//                if(pS.distance(pE)<100 ) {
//                    line3d = createConnection(pS, pE);
//                    pane3dFX.getChildren().add(line3d);
//                }
//            }
//        }



    }
}
