package core.application.dataElement.coords;

import core.application.dataElement.IDataElement;

/**
 * Created by anonymous on 03.11.2018.
 */
public class Cartesian3dInt implements ICoords, IDataElement {
    public int x;
    public int y;
    public int z;

    public Cartesian3dInt(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.y = z;
    }

}
