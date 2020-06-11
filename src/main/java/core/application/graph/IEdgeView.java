    package core.application.graph;

public interface IEdgeView extends IEdge{

    IEdgeLayout getEdge();

    EdgeView setVertexU(IVertexView vertexU);

    EdgeView setVertexV(IVertexView vertexV);

    /**
     * read data from model and VertexView positions and update view and position of EdgeFX
     */
    EdgeView update();




}
