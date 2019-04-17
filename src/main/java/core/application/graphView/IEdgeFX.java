package core.application.graphView;

import core.application.graph.IEdge;

public interface IEdgeFX {

    IEdge getEdge();

    void setVertexU(VertexFX vertexU);

    void setVertexV(VertexFX vertexV);

    /**
     * read data from model and VertexFX positions and update view and position of EdgeFX
     */
    void update();

}
