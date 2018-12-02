package core.application.dataElement.coords;

import core.application.dataElement.IDataElement;

/**
 * Created by anonymous on 04.11.2018.
 */
public class Decart2d<TCoord extends Number> implements ICoords, IDataElement {
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
