package core.application.dataConverters;

import core.application.data.Decart3d;
import core.application.data.Polar3d;

import static java.lang.Math.sin;
import static java.lang.Math.cos;

/**
 * convert polar3d double coordinates into Decart3d double coordinates
 */
public class Polar3d_Decart3d {
    /**
     * convert static method
     * @param polar3d
     * @return
     */
    public static Decart3d convert(Polar3d polar3d){
        return new Decart3d(
                polar3d.getR()* sin(polar3d.getLatitudeAngle()) * cos(polar3d.getLongitudeAngle()),
                polar3d.getR()* sin(polar3d.getLatitudeAngle()) * sin(polar3d.getLongitudeAngle()),
                polar3d.getR()* cos(polar3d.getLatitudeAngle())
        );
    }
}
