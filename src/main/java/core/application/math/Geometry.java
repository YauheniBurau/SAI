package core.application.math;

import core.application.VertexValue.coords.Decart2dInt;

/**
 * Created by anonymous on 05.12.2018.
 */
public class Geometry {

    /**
     * find a of line by elements and center elements
     * a starts from -180 to 180
     *          0
     *          |
     *  -90 ----|---- 90
     *          |
     *     -180 | 180
     * @param center
     * @param point
     * @return a in grades
     */
    public static double countPolarAngle(Decart2dInt center, Decart2dInt point){
        double angle;
        angle = Math.atan2( point.x - center.x, point.y - center.y );
        angle = angle *180/Math.PI;
        angle = angle + 270;
        if(angle >=360) angle -=360;
        if(angle>0) angle = Math.abs(angle-360);
        return angle;
    }


}
