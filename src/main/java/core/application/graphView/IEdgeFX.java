package core.application.graphView;

import core.application.graph.IEdge;

public interface IEdgeFX {

    IEdge getEdge();

    EdgeFX setVertexU(IVertexFX vertexU);

    EdgeFX setVertexV(IVertexFX vertexV);

    /**
     * read data from model and VertexFX positions and update view and position of EdgeFX
     */
    EdgeFX update();

}
