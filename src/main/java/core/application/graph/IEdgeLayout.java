package core.application.graph;

import core.application.data.Decart3d;
import javafx.scene.paint.Color;


public interface IEdgeLayout extends IEdge{
    int geteId();
    void seteId(int id);
    IEdge getValue();
    void setValue(IEdge value);
    IVertexLayout getVertexU();
    EdgeLayout setVertexU(IVertexLayout vertexU);
    IVertexLayout getVertexV();
    EdgeLayout setVertexV(IVertexLayout vertexV);
    Color getColor();
    void setColor(Color color);
    Decart3d getPositionU();
    Decart3d getPositionV();
    void update();
}
