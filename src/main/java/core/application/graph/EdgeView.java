package core.application.graph;

import javafx.geometry.Point3D;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class EdgeView extends Cylinder implements IEdgeView {
    private IEdgeLayout edge;
    private IVertexView vertexU;
    private IVertexView vertexV;

    public EdgeView( int divisions, IEdgeLayout edge, IVertexView vertexU, IVertexView vertexV) {
        super(1,1, divisions);
        this.edge = edge;
        this.vertexU = vertexU;
        this.vertexV = vertexV;
        this.update();
    }

    public IEdgeLayout getEdge() {
        return edge;
    }

    public EdgeView setVertexU(IVertexView vertexU) {
        this.vertexU = vertexU;
        return this;
    }

    public EdgeView setVertexV(IVertexView vertexV) {
        this.vertexV = vertexV;
        return this;
    }

    /**
     * read data from graphLayout and update GraphView
     */
    public EdgeView update(){
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
        this.setMaterial(new PhongMaterial(edge.getColor()));
        this.getTransforms().removeAll();
        this.getTransforms().addAll(moveToMidpoint, rotateAroundCenter);
        return this;
    }

}