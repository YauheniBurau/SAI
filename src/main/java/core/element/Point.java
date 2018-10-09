package core.element;

/**
 * Created by anonymous on 08.06.2018.
 */
public class Point extends AbstractElement{
    public int x;
    public int y;
    public int z;
    public int value;
    public boolean isProcessed = false;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.z = 0;
        this.value = 0;
//        this.a = 0;
    }

    public Point(int x, int y, int z, int value) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.value = value;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * count a by 3 points
     * @param c
     * @par am a
     * @param b
     * @return
     */
    public static double findAngle(Point c, Point a, Point b ){
        double bx, by, ax, ay;
        double angle;
        bx = c.x - b.x;
        by = c.y - b.y;
        ax = c.x - a.x;
        ay = c.y - a.y;
        angle = Math.acos(
                (bx * ax + by * ay) /
                        ( Math.sqrt( bx*bx + by*by )* Math.sqrt(ax*ax + ay*ay) ) )
                *180/Math.PI;
        return angle;
    }


    public static int getDistance2d(Point p1, Point p2){
        double distE = Math.sqrt(
                Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2) );
        return (int)distE;
    }

}
