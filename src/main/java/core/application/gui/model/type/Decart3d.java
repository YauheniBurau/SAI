package core.application.gui.model.type;

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

    /**
     * convert to Polar3d
     * @return
     */
    public Polar3d toPolar3d(){
        double r = 0;
        double latitude = 0;
        double longitude = 0;
        // R
        r = Math.sqrt( this.x * this.x + this.y * this.y + this.z * this.z);
        // Latitude
        if(this.z==0.0){ latitude = 0;}
        else{ latitude = Math.acos(this.z/r); }
        // Longitude
//        if(decart3d.x==0.0 && decart3d.y>0) longitude = Math.PI/2;
//        if(decart3d.x==0.0 && decart3d.y<0) longitude = Math.PI*3/4;
//        if(decart3d.x==0.0 && decart3d.y==0) longitude = 0;
        if(this.x!=0.0 && this.y!=0.0){ longitude = Math.atan2(this.y, this.x); }
        return new Polar3d(r, latitude, longitude);
    }


}
