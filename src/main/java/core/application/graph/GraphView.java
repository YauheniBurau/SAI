package core.application.graph;

import java.util.Collection;
import java.util.HashMap;

public class GraphView extends Graph<IVertexView, IEdgeView> {
    private GraphLayout graphLayout;
    private int divisions = 8;

    public GraphView(GraphLayout graphLayout, int divisions) {
        this.setDivisions(divisions);
        this.setGraphLayout(graphLayout);
    }

    public GraphLayout getGraphLayout() {
        return graphLayout;
    }

    public void setGraphLayout(GraphLayout graphLayout) {
        this.clearVertexes();
        this.clearEdges();
        this.graphLayout = graphLayout;
        HashMap<IVertexLayout, VertexView> map = new HashMap<>();
        // create VertexView-s
        Collection<IVertexLayout> vertexes = graphLayout.getVertexes();
        VertexView vV;
        for(IVertexLayout vL: vertexes){
            vV = new VertexView(vL, this.divisions);
            map.put(vL, vV);
            this.addVertex(vL.getvId(), vV);
        }
        // create EdgeFX-s
        Collection<IEdgeLayout> edges = graphLayout.getEdges();
        EdgeView eV;
        for (IEdgeLayout eL: edges) {
            eV = new EdgeView( this.divisions, eL, map.get(eL.getVertexU()), map.get(eL.getVertexV()) );
            this.addEdge(eL.geteId(), eV);
        }
    }

    public int getDivisions() {
        return divisions;
    }

    public void setDivisions(int divisions) {
        this.divisions = divisions;
        // TODO: update all view component because division is changed
    }

    // TODO: maybe use later. check if not then remove
//    /**
//     * recount all GraphLayout data accordingly graphLayout and layout
//     */
//    public void update(){
//        this.setGraphLayout(this.graphLayout);
//    }

}
