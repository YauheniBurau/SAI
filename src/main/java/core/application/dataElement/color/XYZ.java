package core.application.dataElement.color;

import core.application.dataElement.IDataElement;

/**
 * XYZ Color class
 * Created by anonymous on 29.10.2018.
 */
public class XYZ implements IColor, IDataElement {
    public double x;
    public double y;
    public double z;

    public XYZ(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}
