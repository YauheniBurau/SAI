package core.application.VertexValue.curve;

import core.application.VertexValue.coords.ICoords;

/**
 * Created by anonymous on 16.12.2018.
 */
public class Line<T extends ICoords> implements ILine{
    public T p1;
    public T p2;

    public Line(T p1, T p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

}
