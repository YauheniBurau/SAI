package core.element;

/**
 * Created by anonymous on 13.05.2018.
 */
public class Point2dGeneric<E> {
    public E value;
    public int x;
    public int y;

    public Point2dGeneric(int x, int y) {
        value = null;
        this.x = x;
        this.y = y;
    }

    public Point2dGeneric(int x, int y, E e) {
        value = e;
        this.x = x;
        this.y = y;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

}
