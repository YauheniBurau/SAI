package core.application.helper;

import core.application.exceptions.InputParamException;
import core.application.dataElement.color.ARGB;
import core.application.dataElement.color.Lab;

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
            throw new InputParamException("input ARGB must be not null");
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
            throw new InputParamException("input ARGB must be not null");
        }
        return XYZToLab.transform( ArgbToXYZ.transform(in), whitePoint );
    }

}
