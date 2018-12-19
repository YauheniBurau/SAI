package core.old;

/**
 * Created by anonymous on 14.06.2018.
 */
public class Curve {
    public static final int CURVE_UNDEFINED = 0;
    public static final int CURVE_LINE = 1;
    public static final int CURVE_ARC = 2;

//    public static int countId = 0;
//    public int id; // unique segment number
//    public int curveType = Curve.CURVE_UNDEFINED;
//    // draw arc by counter clockwise from p1 to p2
//    public Point p1 = null; // begin, end of line
//    public Point pC = null; // center radius coords for arc, null - if line
//    public Point p2 = null; // end, begin of line
//
//    public ArrayList<Point> points = new ArrayList<Point>();
//    public boolean isProcessed = false;
//    public ArrayList<Curve> curves = new ArrayList<Curve>(); //for building net

//    public Curve() {
//        this.curveType = Curve.CURVE_UNDEFINED;
//        this.id = Curve.countId;
//        Curve.countId+=1;
//    }

//    // constructor for CURVE_LINE
//    public Curve(Point p1, Point p2) {
//        this.curveType = Curve.CURVE_LINE;
//        this.p1 = p1;
//        this.p2 = p2;
//        this.id = Curve.countId;
//        Curve.countId+=1;
//    }

//    // constructor for CURVE_ARC
//    // if p1 coords equals p2 coord it meens the full circle
//    public Curve(Point p1, Point p2, Point pC) {
//        this.curveType = Curve.CURVE_ARC;
//        this.p1 = p1;
//        this.p2 = p2;
//        this.pC = pC;
//        this.id = Curve.countId;
//        Curve.countId+=1;
//    }

//    /**
//     * find Coefficient K of direct line by two points
//     * @return
//     */
//    public static double findDirectLineCoeffK(Point p1, Point p2){
//        return (p1.y - p2.y) / (p1.x - p2.x);
//    }

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
//     * find distance from p0 to line passing through p1 and p2
//     * @param p0
//     * @param p1
//     * @param p2
//     * @return
//     */
//    public static double findDistanceFromP0ToLineP1P2(Point p0, Point p1, Point p2){
//        double d = ( (p2.y - p1.y)*p0.x - (p2.x - p1.x)*p0.y +p2.x * p1.y - p2.y* p1.x )/
//                Math.sqrt((p2.x - p1.x)*(p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y));
//        return d;
//    }

//    /**
//     * count standart midlle quadriple deviation relativly line2d
//     * @param points
//     * @param p1
//     * @param p2
//     * @return
//     */
//    public static Curve findCurveLine2d(Point p1, Point p2, ArrayList<Point> points,
//                                        double maxPercentPointDeviation, double minPercentCurvePoints){
//        Curve curve = new Curve(p1, p2);
//        double d, l, result;
//        double sum = 0;
//        int n = 0;
//        l = Curve.findPointsDistance(p1, p2);
//        for (Point p: points) {
//            d = Curve.findDistanceFromP0ToLineP1P2(p, p1, p2);
//            if( d/l < maxPercentPointDeviation){
//                n+=1;
//                curve.points.add(p);
//            }
//        }
//        if( (n/l>=minPercentCurvePoints) ){
//            for (Point pp: curve.points) {
//                pp.isProcessed = true;
//            }
//        }else{
//            curve = null;
//        }
//        return curve;
//    }

//    /**
//     * count standart midlle quadriple deviation relativly line2d
//     * @param points
//     * @param p1
//     * @param p2
//     * @return
//     */
//    public static double findLine2dStandartDeviation(ArrayList<Point> points, Point p1, Point p2){
//        double d, l, result;
//        double sum = 0;
//        l = Curve.findPointsDistance(p1, p2);
//        for (Point p: points) {
//            d = Curve.findDistanceFromP0ToLineP1P2(p, p1, p2);
//            sum += d/l;
//        }
//        result = Math.abs(sum/points.size());
//        return result;
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
//        for (Point p: points) {
//            d = Curve.findPointsDistance(c, p);
//            sum += Math.abs((d-r)/r);
//        }
//        d = Math.abs(sum/points.size());
//        return d;
//    }

//    /**
//     * count standart midlle quadriple deviation relativly arc2d
//     * (x – a)2 + (y – b)2 = R2, где a и b – координаты центра A окружности ω (A; R)
//     * @param points
//     * @param c
//     * @param p1
//     * @param p2
//     * @return
//     */
//    public static double findArc2dStandartDeviation(ArrayList<Point> points, Point c, Point p1, Point p2){
//        double d, d1, d2, r, ap, a1, a2;
//        double sum = 0;
//        a1 = Curve.findLine2dAngleGrade(c, p1);
//        a2 = Curve.findLine2dAngleGrade(c, p2);
//        r = Curve.findPointsDistance(c, p1);
//        for (Point p: points) {
//            ap = Curve.findLine2dAngleGrade(c, p2);
//            if( ((ap>=a1 && ap<360) || (ap>=a1 && ap>=0)) && ( (ap<=a2 && ap<360) || (ap<=a2 && ap>=0) ) ) {
//                d = Curve.findPointsDistance(c, p);
//                sum += Math.abs((d-r)/r);
//            }else{
//                d1 = Curve.findPointsDistance(p, p1);
//                d2 = Curve.findPointsDistance(p, p2);
//                if(d1<d2){ sum += Math.abs(d1/r); }
//                else{ sum += Math.abs(d2/r); }
//            }
//        }
//        d = Math.abs(sum/points.size());
//        return d;
//    }

//    /**
//     * count standart midlle quadriple deviation relativly arc2d
//     * (x – a)2 + (y – b)2 = R2, где a и b – координаты центра A окружности ω (A; R)
//     * @param points
//     * @param c
//     * @param r
//     * @param gradeStart
//     * @param gradeEnd
//     * @return
//     */
//    public static double findArc2dStandartDeviation(ArrayList<Point> points, Point c, double r, double gradeStart, double gradeEnd){
//        Point pStart, pEnd;
//        pStart = Curve.f_gradeCircle(c, r, gradeStart);
//        pEnd = Curve.f_gradeCircle(c, r, gradeEnd);
//        double d = Curve.findArc2dStandartDeviation(points, c, pStart, pEnd);
//        return d;
//    }


//    /**
//     * find a of line by elements and center elements
//     * @param pc
//     * @param p
//     * @return a in radians
//     */
//    public static double findLine2dAngleRad(Point pc, Point p){
//        double angle;
//        angle = Math.atan2(p.x - pc.x, p.y - pc.y);
//        return angle;
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
//     * function circle y = f(rad); where rad is a in radians
//     * @return
//     */
//    public static Point f_radCircle(Point c, double r, double rad){
//        double x, y;
//        x = r * Math.cos(rad);
//        y = r * Math.sin(rad);
//        return new Point((int)(x + c.x), (int)(y + c.y));
//    }

//    /**
//     * function circle y = f(grade); where rad is a in grades
//     * @return
//     */
//    public static Point f_gradeCircle(Point c, double r, double grade){
//        double x, y, rad;
//        rad = grade * Math.PI / 180;
//        x = r * Math.cos(rad);
//        y = r * Math.sin(rad);
//        return new Point((int)(x + c.x), (int)(y + c.y));
//    }

//    @Deprecated
//    /**
//     * remember in calculation used X axis from left to right and y axis from top to bottom
//     * count a of main axis of symmetry
//     * @return
//     */
//    public int countAngleAxisOfSymmetry(Point center, ArrayList<Point> points){
//        int x, y;
//        int n = 0;
//        int cx = center.x;
//        int cy = center.y;
//        int cz = center.z;
//        int dx = 0, dy = 0, dz = 0;
//        int angle = 0;
//        int a;
//        for(Point p: points) {
//            dx += (p.x - cx);
//            dy += (p.y - cy);
//            dz += (p.z - cz);
//        }
//        if(dx==0){
//            angle =90;
//        }else{
//            a = (int) Math.round( Math.atan2(dy,dx)*180/Math.PI );
//            if(a<0){ a+=360; }
//            if(a> 180){ a-=180;}
//            angle = a;
//        }
//
//        return angle;
//    }

//    /**
//     * count curve length by points(its more accurate, strict and siutable for arcs, and curve, not only lines)
//     * @return
//     */
//    public Integer getLength(){
//        return points.size();
//    }

//    /**
//     * count length between p1 and p2 of curve
//     * @return
//     */
//    public Integer getStraightLength(){
//        return Point.getDistance2d(this.p1, this.p2);
//    }

//    /**
//     * count radius of segment
//     * @param h high of segment
//     * @param c length of hord
//     * @return
//     */
//    private static double findSegmentR(double h, double c){
//        return h/2 + (c*c)/(8*h);
//    }
//
//    public static Point findRCenterBy3Points(Point p1, Point p2, Point p3){
//        Point result = null;
//        double A = p2.x - p1.x;
//        double B = p2.y - p1.y;
//        double C = p3.x - p1.x;
//        double D = p3.y - p1.y;
//        double E = A * (p1.x + p2.x) + B * (p1.y + p2.y);
//        double F = C * (p1.x + p3.x) + D * (p1.y + p3.y);
//        double G = 2 * (A * (p3.y - p2.y) - B * (p3.x - p2.x));
//        if(G != 0) {
//            int x = (int) Math.round((D * E - B * F)/G);
//            int y = (int) Math.round((A * F - C * E)/G);
//            result = new Point(x, y);
//        }
//        return result;
//    }

//    public Curve(Point p1, Point p2, Point pC) {
//        this.p1 = p1;
//        this.pC = pC;
//        this.p2 = p2;
//        this.id = Curve.countId;
//        Curve.countId+=1;
//    }
//
//
//    /**
//     * get a between line and x-axis
//     * @return
//     */
//    public double getAngle(){
//        Point c, a, b;
//        double a;
//        if(this.p1.y <= this.p2.y){
//            c = this.p1;
//            a = this.p2;
//        }else{
//            c = this.p2;
//            a = this.p1;
//        }
//        b = new Point(a.x, c.y, 0,0,0);
//        a = Point.findAngle(c, a, b);
//        return a;
//    }

}
