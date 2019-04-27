package core.application.graph;

public interface IEdgeView {

    IEdgeLayout getEdge();

    EdgeView setVertexU(IVertexView vertexU);

    EdgeView setVertexV(IVertexView vertexV);

    /**
     * read data from model and VertexView positions and update view and position of EdgeView
     */
    EdgeView update();

}
