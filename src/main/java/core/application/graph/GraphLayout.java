package core.application.graph;

import core.application.GraphLayouter.GL_Default;

import java.util.HashMap;
import java.util.Vector;

public class GraphLayout extends Graph<IVertexLayout, IEdgeLayout> {
    private GraphModel graphModel;
    private AbstractGraphLayouter layout = new GL_Default();

    public GraphLayout() {
        this.setGraphModel(new GraphModel());
        this.setLayouter(new GL_Default());
    }

    public GraphLayout(GraphModel graphModel, AbstractGraphLayouter layout) {
        this.setGraphModel(graphModel);
        this.setLayouter(layout);
    }

    public GraphModel getGraphModel() {
        return graphModel;
    }

    public void setGraphModel(GraphModel graphModel) {
        this.clearVertexes();
        this.clearEdges();
        this.graphModel = graphModel;
        HashMap<IVertex, VertexLayout> map = new HashMap<>();
        // create VertexLayout-s edgelayout-s
        Vector<IVertex> vertexes = graphModel.getVertexes();
        VertexLayout vL;
        for(IVertex vM: vertexes){
            vL = new VertexLayout(vM);
            map.put(vM, vL);
            this.addVertex(vL);
        }
        // init EdgesFX into Pane
        Vector<IEdge> edges = graphModel.getEdges();
        EdgeLayout eL;
        for (IEdge eM: edges) {
            eL = new EdgeLayout(eM)
                    .setVertexU(map.get(eM.getVertexU()))
                    .setVertexV(map.get(eM.getVertexV()));
            this.addEdge(eL);
        }
    }

    public AbstractGraphLayouter getLayouter() {
        return layout;
    }

    public void setLayouter(AbstractGraphLayouter layout) {
        this.layout = layout;
        this.layout.process(this);
    }

    /**
     * recount all GraphLayout data accordingly graphModel and layout
     */
    public void update(){
        this.setGraphModel(this.graphModel);
        this.setLayouter(layout);
    }

}
