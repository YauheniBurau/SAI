package core.application.graphView;

import core.application.graph.IVertex;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class VertexFX extends Sphere implements IVertexFX{
    private IVertex vertex;
    private Point3D position;

    public VertexFX(IVertex vertex, int divisions){
        super(1, divisions);
        this.setMaterial(new PhongMaterial(Color.RED));
        this.vertex = vertex;
    }

    public IVertex getVertex() {
        return vertex;
    }

    public Point3D getPosition() {
        return position;
    }

    public void setPosition(Point3D position) {
        this.position = position;
    }

}
