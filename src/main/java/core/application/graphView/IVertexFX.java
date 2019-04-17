package core.application.graphView;

import core.application.graph.IVertex;
import javafx.geometry.Point3D;

public interface IVertexFX {
    IVertex getVertex();
    Point3D getPosition();
    void setPosition(Point3D position);

}
