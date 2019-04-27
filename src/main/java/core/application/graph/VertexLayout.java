package core.application.graph;

import core.application.data.Decart3d;
import javafx.scene.paint.Color;

import java.util.Vector;

public class VertexLayout implements IVertexLayout {
    private long id;
    private IVertex value;
    private Decart3d position = new Decart3d();
    private Color color = Color.RED;
    private int radius = 2;
    private Vector<IEdgeLayout> edges = new Vector<>();

    public VertexLayout(IVertex value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public IVertex getValue() {
        return value;
    }

    public void setValue(IVertex value) {
        this.value = value;
    }

    public Decart3d getPosition() {
        return position;
    }

    public void setPosition(Decart3d position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Vector<IEdgeLayout> getEdges() {
        return this.edges;
    }

    public boolean addEdge(IEdgeLayout e) {
        return this.edges.add(e);
    }

    public boolean removeEdge(IEdgeLayout e) {
        return this.edges.remove(e);
    }

    public boolean containsEdge(IEdgeLayout e) {
        return this.edges.contains(e);
    }

}
