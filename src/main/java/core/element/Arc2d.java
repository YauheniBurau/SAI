package core.element;

/**
 * Created by anonymous on 22.12.2017.
 */
public class Arc2d {
    public Point2d p1; // from p1 to p2 by counter clockwise
    public Point2d p2;
    public Point2d pc;

    public Arc2d(Point2d p1, Point2d p2, Point2d pc) {
        this.p1 = p1;
        this.p2 = p2;
        this.pc = pc;
    }

    public Point2d getP1() {
        return p1;
    }

    public void setP1(Point2d p1) {
        this.p1 = p1;
    }

    public Point2d getP2() {
        return p2;
    }

    public void setP2(Point2d p2) {
        this.p2 = p2;
    }

    public Point2d getPc() {
        return pc;
    }

    public void setPc(Point2d pc) {
        this.pc = pc;
    }

    /**
     * find center coordinates of arc of circle by 3 points on arc
     * @param p1
     * @param p2
     * @param p3
     * @return
     */
    public static Point2d findRCenter(Point2d p1, Point2d p2, Point2d p3) {
        int a, b, c, d, e, f, g;
        int x, y;
        Point2d pc;
        a = p2.x - p1.x;
        b = p2.y - p1.y;
        c = p3.x - p1.x;
        d = p3.y - p1.y;
        e = a * (p1.x + p2.x) + b * (p1.y + p2.y);
        f = c * (p1.x + p3.x) + d * (p1.y + p3.y);
        g = 2 * ( a *(p3.y - p2.y)  - b * (p3.x - p2.x) );
        if(g == 0) {
            pc = null;
        }else {
            x = (d*e - b*f)/g;
            y = (a*f - c*e)/g;
            pc = new Point2d(x, y);
        }
        return pc;
    }


}
