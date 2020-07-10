package core.old;

/**
 * Created by anonymous on 29.10.2018.
 * class for storing Lab color
 */
public class Lab {
    /**
     * reference white in XYZ coordinates
     */
    public static double[] D50 = {96.4212, 100.0, 82.5188};
    public static double[] D55 = {95.6797, 100.0, 92.1481};
    public static double[] D65 = {95.0429, 100.0, 108.8900};
    public static double[] D75 = {94.9722, 100.0, 122.6394};
    public static double[] whitePoint = D65;

    public double L; // (0.0 .. 100.0)
    public double a;
    public double b;

    public Lab(double l, double a, double b) {
        this.L = l;
        this.a = a;
        this.b = b;
    }

}
