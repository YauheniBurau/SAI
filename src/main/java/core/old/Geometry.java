package core.old;

import core.application.dataElement.coords.Decart2dInt;

import java.util.ArrayList;

// TODO: Remove later
/**
 * Created by anonymous on 27.07.2018.
 */
public class Geometry {

//    /**
//     * find center coordinates of arc of circle by 3 points on arc
//     * @param p1
//     * @param p2 middle coords
//     * @param p3
//     * @return
//     */
//    public static Point findCircleRadius(Point p1, Point p2, Point p3) {
//        int a, b, c, d, e, f, g;
//        int x, y;
//        Point pc;
//        a = p2.x - p1.x;
//        b = p2.y - p1.y;
//        c = p3.x - p1.x;
//        d = p3.y - p1.y;
//        e = a * (p1.x + p2.x) + b * (p1.y + p2.y);
//        f = c * (p1.x + p3.x) + d * (p1.y + p3.y);
//        g = 2 * ( a *(p3.y - p2.y)  - b * (p3.x - p2.x) );
//        if(g == 0) {
//            pc = null;
//        }else {
//            x = (d*e - b*f)/g;
//            y = (a*f - c*e)/g;
//            pc = new Point(x, y);
//        }
//        return pc;
//    }

//    /**
//     * find distance between two points
//     * @return
//     */
//    public static double findPointsDistance(Point p1, Point p2){
//        return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
//    }

//    /**
//     * find Coefficient K of direct line by two points
//     * @return
//     */
//    public static double findDirectLineCoeffK(Point p1, Point p2){
//        return (p1.y - p2.y) / (double)(p1.x - p2.x);
//    }
//
//    /**
//     * find Coefficient B of direct line by two points
//     * @param p
//     * @param k allready counted coefficient
//     * @return
//     */
//    public static double findDirectLineCoeffB(Point p, double k){
//        return p.y - k*p.x;
//    }


//    /**
//     * count standart midlle quadriple deviation relativly line2d
//     * @param points
//     * @param k
//     * @param b
//     * @return
//     */
//    public static double findLine2dStandartDeviation(ArrayList<Point> points, double k, double b){
//        double d;
//        double sum = 0;
//        double yi;
//        for (Point p: points) {
//            yi = k*p.x + b;
//            sum += ((yi - p.y)/yi) * ((yi - p.y)/yi);
//        }
//        d = Math.sqrt(sum/points.size());
//        return d;
//    }

//    /**
//     * count standart midlle quadriple deviation relativly circle2d
//     * (x – a)2 + (y – b)2 = R2, где a и b – координаты центра A окружности ω (A; R)
//     * @param points
//     * @param c
//     * @param r
//     * @return
//     */
//    public static double findCircle2dStandartDeviation(ArrayList<Point> points, Point c, double r){
//        double d;
//        double sum = 0;
//        double yi;
//        for (Point p: points) {
//            yi = Math.sqrt( r*r - (p.x - c.x)*(p.x - c.x) ) + c.y;
//            sum += ((yi - p.y)/yi) * ((yi - p.y)/yi);
//        }
//        d = Math.sqrt(sum/points.size());
//        return d;
//    }

//    /**
//     * function circle y = f(x);
//     * @return
//     */
//    public static double f_xCircle(Point c, double r, double x){
//        double yi = Math.sqrt( r*r - (x - c.x)*(x - c.x) ) + c.y;
//        return yi;
//    }


//    /**
//     * count a by 3 points
//     * @param c
//     * @par am a
//     * @param b
//     * @return
//     */
//    public static double findAngle(Point c, Point a, Point b ){
//        double bx, by, ax, ay;
//        double angle;
//        bx = c.x - b.x;
//        by = c.y - b.y;
//        ax = c.x - a.x;
//        ay = c.y - a.y;
//        angle = Math.acos(
//                (bx * ax + by * ay) /
//                        ( Math.sqrt( bx*bx + by*by )* Math.sqrt(ax*ax + ay*ay) ) )
//                *180/Math.PI;
//        return angle;
//    }

//    public static int getDistance2d(Point p1, Point p2){
//        double distE = Math.sqrt(
//                Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2) );
//        return (int)distE;
//    }


}
