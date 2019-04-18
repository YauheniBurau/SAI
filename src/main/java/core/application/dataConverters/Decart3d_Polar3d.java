package core.application.dataConverters;

import core.application.data.Decart3d;
import core.application.data.Polar3d;

/**
 * convert decart3d double coordinates into polar3d double coordinates
 */
public class Decart3d_Polar3d {
    /**
     * convert static method
     * @param decart3d
     * @return
     */
    public static Polar3d convert(Decart3d decart3d){
        double r = 0;
        double latitude = 0;
        double longitude = 0;
        // R
        r = Math.sqrt( decart3d.x * decart3d.x + decart3d.y * decart3d.y + decart3d.z * decart3d.z);
        // Latitude
        if(decart3d.z==0.0){ latitude = 0;}
        else{ latitude = Math.acos(decart3d.z/r); }
        // Longitude
//        if(decart3d.x==0.0 && decart3d.y>0) longitude = Math.PI/2;
//        if(decart3d.x==0.0 && decart3d.y<0) longitude = Math.PI*3/4;
//        if(decart3d.x==0.0 && decart3d.y==0) longitude = 0;
        if(decart3d.x!=0.0 && decart3d.y!=0.0){ longitude = Math.atan2(decart3d.y, decart3d.x); }
        return new Polar3d(r, latitude, longitude);
    }
}
