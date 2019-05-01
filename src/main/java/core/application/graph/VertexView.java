package core.application.graph;

import core.application.data.Decart3d;
import javafx.geometry.Point3D;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

import java.util.Vector;

public class VertexView extends Sphere implements IVertexView {
    private IVertexLayout vertex;
    private Vector<IEdgeView> edges = new Vector<>();

    public VertexView(IVertexLayout vertex, int divisions){
        super(vertex.getRadius(), divisions);
        this.vertex = vertex;
        this.update();
    }

    public IVertexLayout getVertex() {
        return vertex;
    }

    public Point3D getPosition() {
        return new Point3D(this.getTranslateX(), this.getTranslateY(), this.getTranslateZ());
    }

    public Vector<IEdgeView> getEdges() {
        return this.edges;
    }

    public boolean addEdge(IEdgeView e) {
        return this.edges.add(e);
    }

    public boolean removeEdge(IEdgeView e) {
        return this.edges.remove(e);
    }

    public boolean containsEdge(IEdgeView e) {
        return this.edges.contains(e);
    }

    public void update(){
        Decart3d p = this.vertex.getPosition();
        this.setTranslateX(p.x);
        this.setTranslateY(p.y);
        this.setTranslateZ(p.z);
        this.setMaterial(new PhongMaterial(this.vertex.getColor()));
        this.setRadius(this.vertex.getRadius());
    }
}