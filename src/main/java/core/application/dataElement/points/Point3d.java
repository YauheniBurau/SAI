package core.application.dataElement.points;

import core.application.dataElement.IDataElement;

// TODO: possible remove in future
/**
 * Created by anonymous on 06.10.2017.
 *
 * E - type of stored value
 * T - type of coordinates values x, y, z
 *
 */
public class Point3d<E, T> implements IPoint, IDataElement {
    public E value;
    public T x;
    public T y;
    public T z;

    public Point3d(T x, T y, T z) {
        this.value = null;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3d(T x, T y, T z, E e) {
        this.value = e;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

}
