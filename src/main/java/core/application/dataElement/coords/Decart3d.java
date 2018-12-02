package core.application.dataElement.coords;

import core.application.dataElement.IDataElement;

/**
 * Created by anonymous on 03.11.2018.
 */
public class Decart3d<TCoord extends Number> implements ICoords, IDataElement {
    public TCoord x;
    public TCoord y;
    public TCoord z;

    public Decart3d(TCoord x, TCoord y, TCoord z) {
        this.x = x;
        this.y = y;
        this.y = z;
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

    public TCoord getZ() {
        return z;
    }

    public void setZ(TCoord z) {
        this.z = z;
    }
}
