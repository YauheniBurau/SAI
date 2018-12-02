package core.application.dataElement.graph;

import core.application.dataElement.coords.Polar2d;

/**
 * Created by anonymous on 18.11.2018.
 */
public class VertexPolar2dDouble extends AbstractVertex{
    private Polar2d<Double> p = null;

    public VertexPolar2dDouble() {

    }

    public VertexPolar2dDouble(Polar2d<Double> p) {
        this.p = p;
    }

    public Polar2d<Double> getP() {
        return p;
    }

    public void setP(Polar2d<Double> p) {
        this.p = p;
    }

}
