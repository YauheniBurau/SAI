package core.application.process.ColorToColor;

import core.application.exceptions.InputParamException;
import core.application.VertexValue.color.ARGB;
import core.application.VertexValue.color.Lab;

/**
 * Created by anonymous on 29.10.2018.
 */
public class LabToArgb {

    /**
     * convert Lab to ARGB with default Lab.whitePoint = D65
     * @param in Lab color
     * @return ARGB value
     */
    public static ARGB transform(Lab in) {
        return XYZToArgb.transform( LabToXYZ.transform(in) ) ;
    }

    /**
     * @param in Lab color
     * @param whitePoint predefined values see in Lab class
     * @return ARGB value
     */
    public static ARGB transform(Lab in, double[] whitePoint) {
        if( in == null ){
            throw new InputParamException("input Lab must be not null");
        }
        return XYZToArgb.transform( LabToXYZ.transform(in, whitePoint) );
    }

}
