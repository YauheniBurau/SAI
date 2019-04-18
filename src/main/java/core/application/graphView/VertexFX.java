package core.application.graphView;

import core.application.graph.IVertex;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

public class VertexFX extends Sphere implements IVertexFX{
    private IVertex vertex;

    public VertexFX(IVertex vertex, int divisions){
        super(2, divisions);
        this.setMaterial(new PhongMaterial(Color.RED));
        this.vertex = vertex;
    }

    public IVertex getVertex() {
        return vertex;
    }

    public Point3D getPosition() {
        return new Point3D(this.getTranslateX(), this.getTranslateY(), this.getTranslateZ());
    }

    public void setPosition(Point3D position) {
        this.setTranslateX(position.getX());
        this.setTranslateY(position.getY());
        this.setTranslateZ(position.getZ());
    }
}
