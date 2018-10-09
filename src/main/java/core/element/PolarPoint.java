package core.element;

/**
 * Created by anonymous on 23.09.2018.
 */
public class PolarPoint extends AbstractElement{
    public double a;
    public double r;

    public PolarPoint(double angle, double r) {
        this.a = angle;
        this.r = r;
    }

}
