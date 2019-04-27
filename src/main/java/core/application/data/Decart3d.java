package core.application.data;

/**
 * Created by anonymous on 03.11.2018.
 */
public class Decart3d{
    public double x;
    public double y;
    public double z;

    public Decart3d() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public Decart3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
