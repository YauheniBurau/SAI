package core.application.VertexValue.coords;

/**
 * Created by anonymous on 09.11.2018.
 */
public class Polar2d<T extends Number> implements ICoords {
    public T a;
    public T r;

    public Polar2d(T a, T r) {
        this.a = a;
        this.r = r;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getR() {
        return r;
    }

    public void setR(T r) {
        this.r = r;
    }

}
