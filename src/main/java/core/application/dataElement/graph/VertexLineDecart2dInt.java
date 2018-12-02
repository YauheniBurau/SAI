package core.application.dataElement.graph;

import core.application.dataElement.coords.Decart2d;

/**
 * Created by anonymous on 17.11.2018.
 */
public class VertexLineDecart2dInt extends AbstractVertex {
    private Decart2d<Integer> p1 = null;
    private Decart2d<Integer> p2 = null;

    public VertexLineDecart2dInt() {

    }

    public VertexLineDecart2dInt(Decart2d<Integer> p1, Decart2d<Integer> p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Decart2d<Integer> getP1() {
        return p1;
    }

    public void setP1(Decart2d<Integer> p1) {
        this.p1 = p1;
    }

    public Decart2d<Integer> getP2() {
        return p2;
    }

    public void setP2(Decart2d<Integer> p2) {
        this.p2 = p2;
    }
}
