package core.application.helper;

import core.application.dataElement.contours.ContourDecart2dInt;
import core.application.dataElement.contours.ContourPolar2dByte;
import core.application.dataElement.contours.ContourPolar2dDouble;
import core.application.dataElement.coords.Decart2dInt;
import core.application.dataElement.coords.Polar2dByte;
import core.application.dataElement.coords.Polar2dDouble;
import core.application.math.Geometry;

/**
 * Created by anonymous on 04.12.2018.
 */
public class ContourDecart2dIntToContourPolar2dByte {

    /**
     * works only for 2d contours
     /**
     * PolarConture (absolute values) -> NormalizedPolarConture( values in range [-128 +127] )
     * works only for 2d contours
     * @param in
     * @return
     */
    public static ContourPolar2dByte transform(ContourDecart2dInt in) {
        // ContourDecart2dInt -> ContourPolar2dDouble
        Decart2dInt contourCenter = in.countContourCenter();
        ContourPolar2dDouble contourDouble = new ContourPolar2dDouble();
        ContourPolar2dByte contourByte = new ContourPolar2dByte();
        double dist, maxDistance, d, angle;
        byte a, r;
        // count max distance and find distance from center to points
        for(Decart2dInt p: in.coords) {
            angle = Geometry.countPolarAngle( contourCenter, p);
            d = Math.sqrt((contourCenter.x - p.x)*(contourCenter.x - p.x) + (contourCenter.y - p.y)*(contourCenter.y - p.y));
            contourDouble.coords.add( new Polar2dDouble(angle, d) );
        }
        // ContourPolar2dDouble -> ContourPolar2dByte
        maxDistance = 0;
        for(Polar2dDouble p: contourDouble.coords) {
            if (p.r > maxDistance) {
                maxDistance = p.r;
            }
        }
        for(Polar2dDouble p: contourDouble.coords) {
            dist = (p.r/maxDistance)*255;
            r = UnsignedDoubleToSignedByte.transform(dist);
            angle = p.a /360 * 255;
            a = UnsignedDoubleToSignedByte.transform(angle);
            contourByte.coords.add( new Polar2dByte(a, r) );
        }

        return contourByte;
    }

}
