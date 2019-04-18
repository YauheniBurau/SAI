package core.application.graphView;

import core.application.graph.IEdge;
import javafx.geometry.Point3D;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class EdgeFX extends Cylinder implements IEdgeFX {
    private IEdge edge;
    private IVertexFX vertexU;
    private IVertexFX vertexV;

    public EdgeFX(IEdge edge, int divisions) {
        super(1,1, divisions);
        this.setMaterial(new PhongMaterial(Color.BLUE));
        this.edge = edge;
    }

    public IEdge getEdge() {
        return edge;
    }

    public EdgeFX setVertexU(IVertexFX vertexU) {
        this.vertexU = vertexU;
        return this;
    }

    public EdgeFX setVertexV(IVertexFX vertexV) {
        this.vertexV = vertexV;
        return this;
    }

    /**
     * read data from model and VertexFX positions and update view and position of EdgeFX
     */
    public EdgeFX update(){
        Point3D origin = vertexU.getPosition();
        Point3D target = vertexV.getPosition();
        Point3D yAxis = new Point3D(0, 1, 0);
        Point3D diff = target.subtract(origin);
        double height = diff.magnitude();
        Point3D mid = target.midpoint(origin);
        Translate moveToMidpoint = new Translate(mid.getX(), mid.getY(), mid.getZ());
        Point3D axisOfRotation = diff.crossProduct(yAxis);
        double angle = Math.acos(diff.normalize().dotProduct(yAxis));
        Rotate rotateAroundCenter = new Rotate(-Math.toDegrees(angle), axisOfRotation);
        this.setHeight(height);
        this.setMaterial(new PhongMaterial(Color.BLUE));
        this.getTransforms().removeAll();
        this.getTransforms().addAll(moveToMidpoint, rotateAroundCenter);
        return this;
    }

}
