package core.application.dataElement.points;

import core.application.dataElement.IDataElement;
import core.application.dataElement.coords.ICoords;

/**
 * Created by anonymous on 09.11.2018.
 */
public class Point<TValue, TCoords> implements IPoint, IDataElement {
    public TValue value;
    public TCoords coords;

    public Point(TValue value, TCoords coords) {
        this.value = value;
        this.coords = coords;
    }

    public Point() {
        this.value = null;
        this.coords = null;
    }

    public TValue getValue() {
        return value;
    }

    public void setValue(TValue value) {
        this.value = value;
    }

    public TCoords getCoords() {
        return coords;
    }

    public void setCoords(TCoords coords) {
        this.coords = coords;
    }

}
