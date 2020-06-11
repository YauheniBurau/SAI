package core.application.graph;

import core.application.data.Decart3d;
import javafx.scene.paint.Color;

public class EdgeLayout implements IEdgeLayout{
    private int id;
    private IEdge value;
    private IVertexLayout vertexU;
    private IVertexLayout vertexV;
    private Color color = Color.BLUE;
    private Decart3d positionU;
    private Decart3d positionV;

    public EdgeLayout(IEdge value) {
        this.value = value;
    }

    public int geteId() {
        return id;
    }

    public void seteId(int id) {
        this.id = id;
    }

    @Override
    public int getuId() {
        return 0;
    }

    @Override
    public Edge setuId(int uId) {
        return null;
    }

    @Override
    public int getvId() {
        return 0;
    }

    @Override
    public Edge setvId(int vId) {
        return null;
    }

    public IEdge getValue() {
        return value;
    }

    @Override
    public Edge setValue(Object value) {
        return null;
    }

    public void setValue(IEdge value) {
        this.value = value;
    }

    public IVertexLayout getVertexU() {
        return vertexU;
    }

    @Override
    public Edge setVertexU(IVertex vertexU) {
        return null;
    }

    public EdgeLayout setVertexU(IVertexLayout vertexU) {
        this.vertexU = vertexU;
        return this;
    }

    public IVertexLayout getVertexV() {
        return vertexV;
    }

    @Override
    public Edge setVertexV(IVertex vertexV) {
        return null;
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
