package core.application.dataElement.graph;

import core.application.dataElement.coords.Polar2d;

/**
 * Created by anonymous on 18.11.2018.
 */
public class VertexPolar2dByte extends Vertex {
    private Polar2d<Byte> p = null;

    public VertexPolar2dByte() {

    }

    public VertexPolar2dByte(Polar2d<Byte> p) {
        this.p = p;
    }

    public Polar2d<Byte> getP() {
        return p;
    }

    public void setP(Polar2d<Byte> p) {
        this.p = p;
    }

}
