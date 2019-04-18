package core.application.data;

public class Polar3d {
    double r;
    double latitudeAngle;
    double longitudeAngle;

    public Polar3d(double r, double latitudeAngle, double longitudeAngle) {
        this.r = r;
        this.latitudeAngle = latitudeAngle;
        this.longitudeAngle = longitudeAngle;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getLatitudeAngle() {
        return latitudeAngle;
    }

    public void setLatitudeAngle(double latitudeAngle) {
        this.latitudeAngle = latitudeAngle;
    }

    public double getLongitudeAngle() {
        return longitudeAngle;
    }

    public void setLongitudeAngle(double longitudeAngle) {
        this.longitudeAngle = longitudeAngle;
    }
}
