package core.element;

/**
 * Created by anonymous on 29.07.2017.
 */
public class Point2d {
    public int x;
    public int y;

    public Point2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * count angle by 3 points
     * @param c
     * @par am a
     * @param b
     * @return
     */
    public static double findAngle(Point2d c, Point2d a, Point2d b ){
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

}
