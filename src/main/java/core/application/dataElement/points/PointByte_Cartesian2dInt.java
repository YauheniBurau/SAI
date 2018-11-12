package core.application.dataElement.points;

import core.application.dataElement.coords.Cartesian2dInt;

/**
 * Created by anonymous on 12.11.2018.
 */
public class PointByte_Cartesian2dInt extends Point<Byte, Cartesian2dInt> {

    public PointByte_Cartesian2dInt(Byte aValue, Cartesian2dInt aCoords) {
        super(aValue, aCoords);
    }

    public PointByte_Cartesian2dInt(Byte aValue, int x, int y) {
        super();
        Cartesian2dInt aCoords = new Cartesian2dInt(x, y);
        this.setCoords(aCoords);
        this.setValue(aValue);
    }


}
