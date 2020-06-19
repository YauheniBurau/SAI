package Graph2.GraphFX;

import Graph2.GraphModel.VertexModel;
import Graph2.Interface.IVertex;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

public class VertexFX extends Circle implements IVertex<VertexModel> {
    private ObjectProperty<Point3D> coords3d = new SimpleObjectProperty<>(new Point3D(0,0,0));


    @Override
    public VertexModel get() {
        return null;
    }

    @Override
    public void set(VertexModel value) {

    }
}
