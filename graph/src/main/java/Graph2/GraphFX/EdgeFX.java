package Graph2.GraphFX;

import Graph2.GraphModel.EdgeModel;
import Graph2.Interface.IEdge;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point3D;

public class EdgeFX implements IEdge<EdgeModel> {
    private ObjectProperty<Point3D> start3d = new SimpleObjectProperty<>(new Point3D(0,0,0));
    private ObjectProperty<Point3D> end3d = new SimpleObjectProperty<>(new Point3D(0,0,0));


    @Override
    public EdgeModel get() {
        return null;
    }

    @Override
    public void set(EdgeModel value) {

    }

}
