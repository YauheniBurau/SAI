package core.application.graph;

import core.application.data.Decart3d;
import javafx.scene.paint.Color;

import java.util.Vector;

public class VertexLayout implements IVertexLayout {
    private int id;
    private IVertex value;
    private Decart3d position = new Decart3d();
    private Color color = Color.RED;
    private int radius = 2;
    private Vector<IEdgeLayout> edges = new Vector<>();

    public VertexLayout(IVertex value) {
        this.value = value;
    }

    public int getvId() {
        return id;
    }

    public void setvId(int id) {
        this.id = id;
    }

    public IVertex getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
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

    @Override
    public boolean addEdge(IEdge e) {
        return false;
    }

    @Override
    public boolean removeEdge(IEdge e) {
        return false;
    }

    @Override
    public boolean containsEdge(IEdge e) {
        return false;
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
