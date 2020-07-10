package core.old;

/**
 * Created by anonymous on 29.10.2018.
 */
public class XYZToLab {
    /**
     * XYZ to Lab with default whitePoint = D65
     * @param in
     * @return
     */
    public static Lab transform(XYZ in) {
        return XYZToLab.transform(in, Lab.whitePoint);
    }

    /**
     * Convert XYZ to LAB.
     * @param in XYZ
     * @return Lab value
     */
    public static Lab transform(XYZ in, double[] whitePoint) {

        double x = in.x / whitePoint[0];
        double y = in.y / whitePoint[1];
        double z = in.z / whitePoint[2];

        if (x > 0.008856) {
            x = Math.pow(x, 1.0 / 3.0);
        }
        else {
            x = (7.787 * x) + (16.0 / 116.0);
        }
        if (y > 0.008856) {
            y = Math.pow(y, 1.0 / 3.0);
        }
        else {
            y = (7.787 * y) + (16.0 / 116.0);
        }
        if (z > 0.008856) {
            z = Math.pow(z, 1.0 / 3.0);
        }
        else {
            z = (7.787 * z) + (16.0 / 116.0);
        }

        double[] result = new double[3];
        result[0] = (116.0 * y) - 16.0;
        result[1] = 500.0 * (x - y);
        result[2] = 200.0 * (y - z);
        return new Lab(result[0], result[1], result[2]);
    }

}
