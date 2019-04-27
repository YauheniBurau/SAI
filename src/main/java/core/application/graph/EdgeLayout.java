package core.application.graph;

import core.application.data.Decart3d;
import javafx.scene.paint.Color;

public class EdgeLayout implements IEdgeLayout{
    private long id;
    private IEdge value;
    private IVertexLayout vertexU;
    private IVertexLayout vertexV;
    private Color color = Color.BLUE;
    private Decart3d positionU;
    private Decart3d positionV;

    public EdgeLayout(IEdge value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public IEdge getValue() {
        return value;
    }

    public void setValue(IEdge value) {
        this.value = value;
    }

    public IVertexLayout getVertexU() {
        return vertexU;
    }

    public EdgeLayout setVertexU(IVertexLayout vertexU) {
        this.vertexU = vertexU;
        return this;
    }

    public IVertexLayout getVertexV() {
        return vertexV;
    }

    public EdgeLayout setVertexV(IVertexLayout vertexV) {
        this.vertexV = vertexV;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Decart3d getPositionU() {
        return positionU;
    }

    public Decart3d getPositionV() {
        return positionV;
    }

    /**
     * read data from graph model Layout and update FX component
     */
    public void update(){
        this.positionU = vertexU.getPosition();
        this.positionV = vertexV.getPosition();
    }

}
