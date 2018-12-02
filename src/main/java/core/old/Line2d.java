package core.old;

import core.application.dataElement.AbstractElement;

/**
 * Created by anonymous on 22.10.2017.
 */
public class Line2d extends AbstractElement {
    public Point p1;
    public Point p2;
    public double k; // coeff of y=k*x+b
    public double b; // coeff of y=k*x+b

    public Line2d(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.k = Geometry.findDirectLineCoeffK(p1, p2);
        this.b = Geometry.findDirectLineCoeffB(p2, k);
    }

    /**
     * get a between line vector (p0,p1) and x-axis
     * @return
     */
    public static double getAngle(Point p0, Point p1){
        double angle = 0;
        if( (p1.x - p0.x == 0) && (p1.y - p0.y > 0) ){ // 90 degree
            angle = 90;
        }else
        if( (p1.x - p0.x == 0) && (p1.y - p0.y < 0) ){ // 270 degree
            angle = 270;
        }else
        if( (p1.x - p0.x > 0) && (p1.y - p0.y == 0) ){ // 0 degree
            angle =  0;
        }else
        if( (p1.x - p0.x < 0) && (p1.y - p0.y == 0) ){ // 180 degree
            angle = 180;
        }else
        if( (p1.x - p0.x > 0) && (p1.y - p0.y > 0) ){ // first quarter
            angle = Math.atan2((p1.y - p0.y), (p1.x - p0.x))*180/Math.PI;
        }else
        if( (p1.x - p0.x < 0) && (p1.y - p0.y > 0) ){ // second quarter
            angle = Math.atan2((p1.y - p0.y), (p1.x - p0.x))*180/Math.PI;
        }else
        if( (p1.x - p0.x < 0) && (p1.y - p0.y < 0) ){ // third quarter
            angle = Math.atan2((p1.y - p0.y), (p1.x - p0.x))*180/Math.PI + 360;
        }else
        if( (p1.x - p0.x > 0) && (p1.y - p0.y < 0) ){ // fourth quarter
            angle = Math.atan2((p1.y - p0.y), (p1.x - p0.x))*180/Math.PI + 360;
        }
        return angle;
    }

    /**
     * get center of line
     * @return
     */
    public Point getCenter(){
        int x, y;
        if(p1.x>=p2.x){ x = p2.x + (p1.x - p2.x)/2; }
        else{ x = p1.x + (p2.x - p1.x)/2; }
        if(p1.y>=p2.y){
            y = p2.y + (p1.y - p2.y)/2;
        }else{
            y = p1.y + (p2.y - p1.y)/2;
        }
        return new Point(x,y, 0,0);
    }

    /**
     * get length of line
     * @return
     */
    public double getLength(){
        return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
    }


    /**
     * get a between line and x-axis
     * @return
     */
    public double getAngle(){
        Point c, a, b;
        double angle;
        if(this.p1.y <= this.p2.y){
            c = this.p1;
            a = this.p2;
        }else{
            c = this.p2;
            a = this.p1;
        }
        b = new Point(a.x, c.y, 0,0);
        angle = Point.findAngle(c, a, b);
        // count angleDiff
        return angle;
    }

    /**
     * diff in percent a line2 from line1 [0..180] like [0.00 .. 1.00]
     * @param angle
     * @param base
     * @return
     */
    public static double angleDiff(double angle, double base){
        return (angle - base)/base;
    }

    /**
     * diff in percent line2 from line1. If l2 length < axis length then value [0.00 .. 1.00]
     * @param line base line
     * @param base
     * @return
     */
    public static double lengthDiff(Line2d line, Line2d base){
        double length1, length2;
        double diff;
        length1 = Math.sqrt((line.p1.x - line.p2.x)*(line.p1.x - line.p2.x) + (line.p1.y - line.p2.y)*(line.p1.y - line.p2.y));
        length2 = Math.sqrt((base.p1.x - base.p2.x)*(base.p1.x - base.p2.x) + (base.p1.y - base.p2.y)*(base.p1.y - base.p2.y));
        diff = (length1-length2)/length2;
        return diff;
    }

    /**
     * diff distance from line center1 and line center2
     * @param line
     * @param base
     * @return
     */
    public static double distanceDiff(Line2d line, Line2d base){
        Point p1, p2;
        double length1, length2;
        p1 = line.getCenter();
        p2 = base.getCenter();
        Line2d l = new Line2d(p1, p2);
        length1 = l.getLength();
        length2 = base.getLength();
        return (length1-length2)/length2;
    }


}
