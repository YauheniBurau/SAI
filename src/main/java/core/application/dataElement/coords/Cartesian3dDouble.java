package core.application.dataElement.coords;

import core.application.dataElement.IDataElement;

/**
 * Created by anonymous on 03.11.2018.
 */
public class Cartesian3dDouble implements ICoords, IDataElement {
    public double x;
    public double y;
    public double z;

    public Cartesian3dDouble(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}
