package core.application.dataElement.graph;

import core.application.dataElement.coords.Decart2d;

/**
 * Created by anonymous on 18.11.2018.
 */
public class VertexDecart2dInt extends AbstractVertex{
    private Decart2d<Integer> p = null;

    public VertexDecart2dInt() {

    }

    public VertexDecart2dInt(Decart2d<Integer> p) {
        this.p = p;
    }

    public Decart2d<Integer> getP() {
        return p;
    }

    public void setP(Decart2d<Integer> p) {
        this.p = p;
    }

}
