package core.application.graph;

import core.application.data.Decart3d;
import javafx.scene.paint.Color;

import java.util.Vector;

public interface IVertexLayout extends IVertex{
    int getvId();
    void setvId(int id);
    IVertex getValue();
    void setValue(IVertex value);
    Decart3d getPosition();
    void setPosition(Decart3d position);
    Color getColor();
    void setColor(Color color);
    int getRadius();
    void setRadius(int radius);
    Vector<IEdgeLayout> getEdges();
    boolean addEdge(IEdgeLayout e);
    boolean removeEdge(IEdgeLayout e);
    boolean containsEdge(IEdgeLayout e);
}
