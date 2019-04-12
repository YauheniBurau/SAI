package core.old.process.ColorToColor;

import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.color.Lab;

/**
 * Created by anonymous on 29.10.2018.
 */
public class ArgbToLab {
    /**
     * @param in ARGB
     * @return Lab value
     */
    public static Lab transform(ARGB in) {
        if( in == null ){
            //throw new InputParamException("input ARGB must be not null");
        }
        return XYZToLab.transform( ArgbToXYZ.transform(in), Lab.whitePoint );
    }

    /**
     * @param in ARGB
     * @param whitePoint from predefined in Lab class
     * @return Lab value
     */
    public static Lab transform(ARGB in, double[] whitePoint) {
        if( in == null ){
            //throw new InputParamException("input ARGB must be not null");
        }
        return XYZToLab.transform( ArgbToXYZ.transform(in), whitePoint );
    }

}
