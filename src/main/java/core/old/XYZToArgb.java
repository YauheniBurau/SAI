package core.old;

/**
 * Created by anonymous on 29.10.2018.
 */
public class XYZToArgb {
    /**
     * XYZ to sRGB conversion values
     */
    public static double[][] Mi =
            {{ 3.2406, -1.5372, -0.4986},
            {-0.9689,  1.8758,  0.0415},
            { 0.0557, -0.2040,  1.0570}};

    /**
     * Convert XYZ to ARGB.
     * @param in
     * @return RGB in int array.
     */
    public static ARGB transform(XYZ in) {
        if( in == null ){
            //throw new InputParamException("input XYZ must be not null");
        }
        ARGB value;
        double x = in.x / 100.0;
        double y = in.y / 100.0;
        double z = in.z / 100.0;
        // [r g b] = [X Y Z][Mi]
        double r = (x * Mi[0][0]) + (y * Mi[0][1]) + (z * Mi[0][2]);
        double g = (x * Mi[1][0]) + (y * Mi[1][1]) + (z * Mi[1][2]);
        double b = (x * Mi[2][0]) + (y * Mi[2][1]) + (z * Mi[2][2]);
        // assume sRGB
        if (r > 0.0031308) {
            r = ((1.055 * Math.pow(r, 1.0 / 2.4)) - 0.055);
        }
        else {
            r = (r * 12.92);
        }
        if (g > 0.0031308) {
            g = ((1.055 * Math.pow(g, 1.0 / 2.4)) - 0.055);
        }
        else {
            g = (g * 12.92);
        }
        if (b > 0.0031308) {
            b = ((1.055 * Math.pow(b, 1.0 / 2.4)) - 0.055);
        }
        else {
            b = (b * 12.92);
        }
        r = (r < 0) ? 0 : r;
        g = (g < 0) ? 0 : g;
        b = (b < 0) ? 0 : b;
        // convert 0..1 into 0..255
        value = new ARGB(0xff, (int) Math.round(r * 255), (int) Math.round(g * 255), (int) Math.round(b * 255));
        return value;
    }

}
