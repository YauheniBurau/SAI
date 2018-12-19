package core.application.VertexValue.coords;

/**
 * Created by anonymous on 04.11.2018.
 */
public class Decart2d<TCoord extends Number> implements ICoords {
    public TCoord x;
    public TCoord y;

    public Decart2d(TCoord x, TCoord y) {
        this.x = x;
        this.y = y;
    }

    public TCoord getX() {
        return x;
    }

    public void setX(TCoord x) {
        this.x = x;
    }

    public TCoord getY() {
        return y;
    }

    public void setY(TCoord y) {
        this.y = y;
    }

}
