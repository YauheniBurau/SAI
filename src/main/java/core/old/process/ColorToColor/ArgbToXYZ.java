package core.old.process.ColorToColor;

import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.color.XYZ;

/**
 * Created by anonymous on 29.10.2018.
 */
public class ArgbToXYZ {
    /**
     * sRGB to XYZ conversion values
     */
    public static double[][] M =
            {{0.4124, 0.3576,  0.1805},
            {0.2126, 0.7152,  0.0722},
            {0.0193, 0.1192,  0.9505}};

    /**
     * Convert RGB to XYZ
     * @param in
     * @return XYZ
     */
    public static XYZ transform(ARGB in) {
        if( in == null ){
            //throw new InputParamException("input ARGB must be not null");
        }
        // convert 0..255 into 0..1
        double r = in.r / 255.0;
        double g = in.g / 255.0;
        double b = in.b / 255.0;

        // assume sRGB
        if (r <= 0.04045) {
            r = r / 12.92;
        }
        else {
            r = Math.pow(((r + 0.055) / 1.055), 2.4);
        }
        if (g <= 0.04045) {
            g = g / 12.92;
        }
        else {
            g = Math.pow(((g + 0.055) / 1.055), 2.4);
        }
        if (b <= 0.04045) {
            b = b / 12.92;
        }
        else {
            b = Math.pow(((b + 0.055) / 1.055), 2.4);
        }
        r *= 100.0;
        g *= 100.0;
        b *= 100.0;
        // [X Y Z] = [r g b][M]
        double X = (r * M[0][0]) + (g * M[0][1]) + (b * M[0][2]);
        double Y = (r * M[1][0]) + (g * M[1][1]) + (b * M[1][2]);
        double Z = (r * M[2][0]) + (g * M[2][1]) + (b * M[2][2]);

        return new XYZ(X, Y, Z);
    }

}
