package core.application.dataElement.points;

import core.application.dataElement.IDataElement;

// TODO: possible remove in future
/**
 * Created by anonymous on 13.05.2018.
 *
 * TValue - type of stored value
 * T - type of coordinates values x,y
 *
 */
public class Point2d<TValue, T> implements IPoint, IDataElement {
    public TValue value;
    public T x;
    public T y;

    public Point2d(T x, T y) {
        value = null;
        this.x = x;
        this.y = y;
    }

    public Point2d(T x, T y, TValue TValue) {
        this.value = TValue;
        this.x = x;
        this.y = y;
    }

    public TValue getValue() {
        return value;
    }

    public void setValue(TValue value) {
        this.value = value;
    }

}
