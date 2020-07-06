package core.old.process;

import core.old.VertexValue.color.Lab;
import core.old.VertexValue.color.XYZ;
import javafx.scene.paint.Color;

/**
 * Created by anonymous on 29.10.2018.
 */
public class LabToXYZ {
    Color fx;
    /**
     * default convert, where whitePoint = D65
     * Convert LAB to XYZ.
     * @param in Lab Color
     * @return XYZ values
     */
    public static XYZ transform(Lab in) {
        return LabToXYZ.transform(in, Lab.whitePoint);
    }

    /**
     * Convert LAB to XYZ.
     * @param in Lab Color
     * @param whitePoint
     * @return XYZ values
     */
    public static XYZ transform(Lab in, double[] whitePoint) {
        double y = (in.L + 16.0) / 116.0;
        double y3 = Math.pow(y, 3.0);
        double x = (in.a / 500.0) + y;
        double x3 = Math.pow(x, 3.0);
        double z = y - (in.b / 200.0);
        double z3 = Math.pow(z, 3.0);

        if (y3 > 0.008856) {
            y = y3;
        }
        else {
            y = (y - (16.0 / 116.0)) / 7.787;
        }
        if (x3 > 0.008856) {
            x = x3;
        }
        else {
            x = (x - (16.0 / 116.0)) / 7.787;
        }
        if (z3 > 0.008856) {
            z = z3;
        }
        else {
            z = (z - (16.0 / 116.0)) / 7.787;
        }
        XYZ result = new XYZ(x * whitePoint[0], y * whitePoint[1], z * whitePoint[2] );
        return result;
    }

}
