package core.application.graph;

import javafx.geometry.Point3D;
import java.util.Vector;

public interface IVertexView {
    /**
     * get VertexLayout - basis for current VertexView JavaFX component
     * @return
     */
    IVertexLayout getVertex();

    /**
     * get Position in 3d of vertex in cartesian coordinates
     * @return
     */
    Point3D getPosition();

    /**
     * get list of all edges conneccted into vertex
     * @return
     */
    Vector<IEdgeView> getEdges();

    /**
     * add edge connection into vertex
     * @param e
     * @return
     */
    boolean addEdge(IEdgeView e);

    /**
     * Remove edge connection from Vertex
     * @param e
     * @return
     */
    boolean removeEdge(IEdgeView e);

    /**
     * check if Vertex contains edge
     * @param e
     * @return
     */
    boolean containsEdge(IEdgeView e);
    /**
     * update from GraphLayout into GraphView of javaFX components
     */
    void update();
}
