package core.element;

//import core.old.ElementImage;

import java.util.*;

/**
 * Created by anonymous on 05.10.2017.
 */
public class Matrix2dBoolean extends AbstractElement{
    private Boolean[][] matrix;
    public final int sizeX;
    public final int sizeY;

    public Matrix2dBoolean(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new Boolean[ySize][xSize];
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, false);
            }
        }
    }

    public void setValue(int xPos, int yPos, Boolean value) {
        if (xPos >= 0 && xPos < this.sizeX && yPos >= 0 && yPos < this.sizeY) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public Boolean getValue(int xPos, int yPos) {
        if (xPos >= 0 && xPos < this.sizeX && yPos >= 0 && yPos < this.sizeY) {
            return this.matrix[yPos][xPos];
        }
        return null;
    }

//    /**
//     * load matrix2d from image ARGB-file
//     * @param urlFile
//     * @return
//     */
//    public static Matrix2dBoolean load(String urlFile) {
//        BufferedImage image;
//        int x, y, intColor;
//        boolean color;
//        try {
//            image = ImageIO.read(new FileImageInputStream(new File(urlFile)));
//        } catch (IOException e) {
//            throw new FileException("Can't read image file into matrix2d<ARGB>", e);
//        }
//        y = image.getHeight();
//        x = image.getWidth();
//        Matrix2dBoolean matrix2D = new Matrix2dBoolean(x, y);
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                intColor = image.getRGB(i,j);
//                color = Transformer.intToBoolean( intColor );
//                matrix2D.setValue(i,j, color);
//            }
//        }
//        return matrix2D;
//    }

//    /**
//     * save matrix to image-file
//     *
//     * @param urlFile
//     * @param format
//     */
//    public Matrix2dBoolean save(String urlFile, String format, int type) {
//        BufferedImage image;
//        int x, y;
//        image = new BufferedImage(this.sizeX, this.sizeY, type);
//        y = this.sizeY;
//        x = this.sizeX;
//        for (int j = 0; j < y; j++) {
//            for (int i = 0; i < x; i++) {
//                image.setRGB(i, j, Transformer.booleanToInt(this.getValue(i, j)));
//            }
//        }
//        try {
//            ImageIO.write(image, format, new File(urlFile));
//        } catch (IOException e) {
//            throw new FileException("Can't write matrix2d to image file", e);
//        }
//        return this;
//    }
//
//    public Matrix2dBoolean skeletize(){
//        Matrix2dBoolean result = new Matrix2dBoolean(this.sizeX, this.sizeY);
//        boolean p00, p01, p02, p10, p11, p12, p20, p21, p22;
//        for(int j = 0; j<this.sizeY; j++){
//            for(int i = 0; i<this.sizeX; i++){
//                p00 = this.getValue(i-1, j-1);
//                p01 = this.getValue(i, j-1);
//                p02 = this.getValue(i+1, j-1);
//                p10 = this.getValue(i-1, j);
//                p11 = this.getValue(i, j);
//                p12 = this.getValue(i+1, j);
//                p20 = this.getValue(i-1, j+1);
//                p21 = this.getValue(i, j+1);
//                p22 = this.getValue(i+1, j+1);
//                if( p11 == true &&
//                        (p00 == false || p01 == false || p02 == false ||
//                                p10 == false         ||         p12 == false ||
//                                p20 == false || p21 == false || p22 == false) ){
//                    result.setValue( i, j, true);
//                }
//            }
//        }
//        return result;
//    }

//    /**
//     * find curve by coordinates of one of the point
//     * @param x
//     * @param y
//     * @return
//     */
//    public Curve findCurve(int x, int y){
//        Curve c = new Curve();
//
//        return c;
//    }

//    public ArrayList<Curve> countBaseCurves(){
//        // ===== COUNT BASE CURVES =====
//        ArrayList<Curve> curves = new ArrayList<Curve>();
//        Matrix2dBoolean isProcessed = new Matrix2dBoolean(this.sizeX, this.sizeY);
//        Point p1, p2;
//        Curve curve;
//        ArrayList<Point> curvePoints;
//        int n;
//        for(int j = 0; j<this.sizeY; j++){
//            for(int i = 0; i<this.sizeX; i++) {
//                if(this.getValue(i, j)==true && isProcessed.getValue(i, j) == false){
//                    // 1. find horizontal base lines
//                    p1 = new Point(i, j, 0, 0, 0);
//                    p2 = new Point(i, j, 0, 0, 0);
//                    curvePoints = new ArrayList<Point>();
//                    curvePoints.add(new Point(i, j, 0, 0, 0));
//                    n = 1;
//                    while(this.getValue(i-n, j)==true ){
//                        p1.x = i-n;
//                        isProcessed.setValue(i-n, j, true);
//                        curvePoints.add(new Point(i-n,j, 0, 0, 0));
//                        n+=1;
//                    }
//                    n = 1;
//                    while(this.getValue(i+n, j)==true ){
//                        p2.x = i+n;
//                        isProcessed.setValue(i+n, j, true);
//                        curvePoints.add(new Point(i+n,j, 0, 0, 0));
//                        n+=1;
//                    }
//                    curve = new Curve(p1, p2, null);
//                    curve.points = curvePoints;
//                    curves.add(curve);
//                    // 2. find vertical base lines
//                    p1 = new Point(i, j, 0, 0, 0);
//                    p2 = new Point(i, j, 0, 0, 0);
//                    curvePoints = new ArrayList<Point>();
//                    curvePoints.add(new Point(i, j, 0, 0, 0));
//                    n = 1;
//                    while(this.getValue(i, j-n)==true ){
//                        p1.y = j-n;
//                        isProcessed.setValue(i, j-n, true);
//                        curvePoints.add(new Point(i, j-n, 0, 0, 0));
//                        n+=1;
//                    }
//                    n = 1;
//                    while(this.getValue(i, j+n)==true ){
//                        p2.y = j+n;
//                        isProcessed.setValue(i, j+n, true);
//                        curvePoints.add(new Point(i, j+n, 0, 0, 0));
//                        n+=1;
//                    }
//                    curve = new Curve(p1, p2, null);
//                    curve.points = curvePoints;
//                    curves.add(curve);
//                    // 3. find diagonal 45o base lines
//                    p1 = new Point(i, j, 0, 0, 0);
//                    p2 = new Point(i, j, 0, 0, 0);
//                    curvePoints = new ArrayList<Point>();
//                    curvePoints.add(new Point(i, j, 0, 0, 0));
//                    n = 1;
//                    while(this.getValue(i-n, j+n)==true ){
//                        p1.x = i-n;
//                        p1.y = j+n;
//                        isProcessed.setValue(i-n, j+n, true);
//                        curvePoints.add(new Point(i-n, j+n, 0, 0, 0));
//                        n+=1;
//                    }
//                    n = 1;
//                    while(this.getValue(i+n, j-n)==true ){
//                        p2.x = i+n;
//                        p2.y = j-n;
//                        isProcessed.setValue(i+n, j-n, true);
//                        curvePoints.add(new Point(i+n, j-n, 0, 0, 0));
//                        n+=1;
//                    }
//                    curve = new Curve(p1, p2, null);
//                    curve.points = curvePoints;
//                    curves.add(curve);
//                    // 4. find diagonal 135o base lines
//                    p1 = new Point(i, j, 0, 0, 0);
//                    p2 = new Point(i, j, 0, 0, 0);
//                    curvePoints = new ArrayList<Point>();
//                    curvePoints.add(new Point(i, j, 0, 0, 0));
//                    n = 1;
//                    while(this.getValue(i-n, j-n)==true ){
//                        p1.x = i-n;
//                        p1.y = j-n;
//                        isProcessed.setValue(i-n, j-n, true);
//                        curvePoints.add(new Point(i-n, j-n, 0, 0, 0));
//                        n+=1;
//                    }
//                    n = 1;
//                    while(this.getValue(i+n, j+n)==true ){
//                        p2.x = i+n;
//                        p2.y = j+n;
//                        isProcessed.setValue(i+n, j+n, true);
//                        curvePoints.add(new Point(i+n, j+n, 0, 0, 0));
//                        n+=1;
//                    }
//                    curve = new Curve(p1, p2, null);
//                    curve.points = curvePoints;
//                    curves.add(curve);
//                    // finish point processing
//                    isProcessed.setValue(i, j, true);
//                }
//            }
//        }
//        // ===== REMOVE OVERWHELMING LINES =====
//        Collections.sort(curves, new CurveByLengthDescComparator());
//        boolean isLine;
//        ArrayList<Curve> curvesResult = new ArrayList<Curve>();
//        isProcessed = new Matrix2dBoolean(this.sizeX, this.sizeY);
//        for (Curve c: curves){
//            isLine = false;
//            for (Point p: c.points) {
//                if(isProcessed.getValue(p.x, p.y)==false){
//                    isLine = true;
//                }
//                isProcessed.setValue(p.x, p.y, true);
//            }
//            if(isLine == true){
//                curvesResult.add(c);
//            }else{
//                break;
//            }
//        }
//        return curvesResult;
//    }

    /**
     * @param x
     * @param y
     * @return
     */
    public Matrix2dBoolean findFilledShape(int x, int y){
        Boolean colorValue = this.getValue(x, y);
        Matrix2dBoolean isProcessed = new Matrix2dBoolean(this.sizeX, this.sizeY);
        int pi, pj;
        Boolean v2, v3, v4, v5, v6, v7, v8, v9;
        Point2dGeneric<Boolean> p;
        LinkedList<Point2dGeneric<Boolean>> points = new LinkedList<Point2dGeneric<Boolean>>();
        points.add( new Point2dGeneric<Boolean>(x, y, this.getValue(x, y)) );
        isProcessed.setValue(x, y, true);
        while(points.size()>0){
            p = points.poll();
            pi = p.x;
            pj = p.y;
            v2 = this.getValue(pi, pj-1);
//            v3 = this.getValue(pi+1, pj-1);
            v4 = this.getValue(pi+1, pj);
//            v5 = this.getValue(pi+1, pj+1);
            v6 = this.getValue(pi, pj+1);
//            v7 = this.getValue(pi-1, pj+1);
            v8 = this.getValue(pi-1, pj);
//            v9 = this.getValue(pi-1, pj-1);
            if( v2 != null && isProcessed.getValue(pi, pj-1) == false && v2 == colorValue) {
                points.add( new Point2dGeneric<Boolean>(pi, pj-1, v2) );
                isProcessed.setValue(pi, pj-1, true);
            }
//            if( v3 != null && isProcessed.getValue(pi+1, pj-1) == false && Math.abs(summ/n - v3) <= maxDiff) {
//                points.add( new Point(pi+1,pj-1, 0, v3) );
//                isProcessed.setValue(pi+1, pj-1, true);
//                summ += v3;
//                n += 1;
//            }
            if( v4 != null && isProcessed.getValue(pi+1, pj) == false && v4 == colorValue) {
                points.add( new Point2dGeneric<Boolean>(pi+1, pj, v4) );
                isProcessed.setValue(pi+1, pj, true);
            }
//            if( v5 != null && isProcessed.getValue(pi+1, pj+1) == false && Math.abs(summ/n - v5) <= maxDiff) {
//                points.add( new Point(pi+1,pj+1, 0, v5) );
//                isProcessed.setValue(pi+1, pj+1, true);
//                summ += v5;
//                n += 1;
//            }
            if( v6 != null && isProcessed.getValue(pi, pj+1) == false && v6 == colorValue) {
                points.add( new Point2dGeneric<Boolean>(pi,pj+1, v6) );
                isProcessed.setValue(pi, pj+1, true);
            }
//            if( v7 != null && isProcessed.getValue(pi-1, pj+1) == false && Math.abs(summ/n - v7) <= maxDiff) {
//                points.add( new Point(pi-1,pj+1, 0, v7) );
//                isProcessed.setValue(pi-1, pj+1, true);
//                summ += v7;
//                n += 1;
//            }
            if( v8 != null && isProcessed.getValue(pi-1, pj) == false && v8 == colorValue) {
                points.add( new Point2dGeneric<Boolean>(pi-1,pj, v8) );
                isProcessed.setValue(pi-1, pj, true);
            }
//            if( v9 != null && isProcessed.getValue(pi-1, pj-1) == false && Math.abs(summ/n - v9) <= maxDiff) {
//                points.add( new Point(pi-1,pj-1, 0, v9) );
//                isProcessed.setValue(pi-1, pj-1, true);
//                summ += v9;
//                n += 1;
//            }
        }
        return isProcessed;
    }


    // ================================ OLD =============================================
//    public Matrix2dBoolean getFilledShape() {
//        int y = this.sizeY;
//        int x = this.sizeX;
//        int pi, pj;
//        Matrix2dBoolean isProcessed = new Matrix2dBoolean(x, y);
//        LinkedList<Point2dByte> points;
//        Point2dByte p;
//        // TODO: optimize cycle
//        for (int j = 0; j < y; j++) {
//            for (int i = 0; i < x; i++) {
//                if( this.getValue(i, j) == false && isProcessed.getValue(i, j) == false &&
//                    (i==0 || i == x-1 || j == 0 || j == y-1) ){
//                    points = new LinkedList<Point2dByte>();
//                    points.add( new Point2dByte(i,j, (byte)0) );
//                    isProcessed.setValue(i, j, true);
//                    while(points.size()>0){
//                        p = points.poll();
//                        pi = p.x;
//                        pj = p.y;
//                        if( this.getValue(pi, pj-1) == false && isProcessed.getValue(pi, pj-1) == false
//                                && (pi>=0 && pi < x && pj >= 0 && pj < y) ) {
//                            points.add( new Point2dByte(pi,pj-1, (byte)0) );
//                            isProcessed.setValue(pi, pj-1, true);
//                        }
//                        if( this.getValue(pi, pj+1) == false && isProcessed.getValue(pi, pj+1) == false
//                                && (pi>=0 && pi < x && pj >= 0 && pj < y) ) {
//                            points.add( new Point2dByte(pi,pj+1, (byte)0) );
//                            isProcessed.setValue(pi, pj+1, true);
//                        }
//                        if( this.getValue(pi-1, pj) == false && isProcessed.getValue(pi-1, pj) == false
//                                && (pi>=0 && pi < x && pj >= 0 && pj < y) ) {
//                            points.add( new Point2dByte(pi-1,pj, (byte)0) );
//                            isProcessed.setValue(pi-1, pj, true);
//                        }
//                        if( this.getValue(pi+1, pj) == false && isProcessed.getValue(pi+1, pj) == false
//                                && (pi>=0 && pi < x && pj >= 0 && pj < y) ) {
//                            points.add( new Point2dByte(pi+1,pj, (byte)0) );
//                            isProcessed.setValue(pi+1, pj, true);
//                        }
//                    }
//                }
//            }
//        }
//        // invert matrix2dBoolean
//        for (int j = 0; j < y; j++) {
//            for (int i = 0; i < x; i++) {
//                if( isProcessed.getValue(i, j) == false){ isProcessed.setValue(i, j, true);}
//                else{ isProcessed.setValue(i, j, false); }
//            }
//        }
//        return isProcessed;
//    }


    public Matrix2dBoolean removeNoise() {
        return this.replacePoints(true, 0, 2, -1, -1)
            .replacePoints(false, 5, 8, -1, -1)
            .replace3x3(263, 262)
            .replace3x3(29, 28)
            .replace3x3(113, 112)
            .replace3x3(449, 448);
    }

    /**
     * skeletize binary image by Zhang Suen algorythm
     * @return
     */
    public Matrix2dBoolean skeletonByZhangSuen(){
        int i, j;
        int sX = this.sizeX;
        int sY = this.sizeY;
        ArrayList<Point> points = new ArrayList<Point>();
        // copy
        Matrix2dBoolean m2d = new Matrix2dBoolean(sX, sY);
        for(j = 0; j<sY;j++ ){
            for(i = 0; i<sX;i++ ){
                m2d.setValue(i, j, this.getValue(i,j));
            }
        }
        // skeleton
        // p9 p2 p3
        // p8 p1 p4
        // p7 p6 p5
        int sum;
        int move01;
        int v1, v2, v3, v4, v5, v6, v7, v8, v9;
        boolean isChanged;
        do{
            isChanged = false;
            points = new ArrayList<Point>();
            // find skeleton
            for (j = 1; j < sY-1; j++) {
                for (i = 1; i < sX-1; i++) {
                    if(m2d.getValue(i, j) == true){
                        // 1-st sub iteration
                        v1 = (m2d.getValue(i, j) == true ? 0 : 1);
                        v2 = (m2d.getValue(i, j - 1) == true ? 0 : 1);
                        v3 = (m2d.getValue(i + 1, j - 1) == true ? 0 : 1);
                        v4 = (m2d.getValue(i + 1, j) == true ? 0 : 1);
                        v5 = (m2d.getValue(i + 1, j + 1) == true ? 0 : 1);
                        v6 = (m2d.getValue(i, j + 1) == true ? 0 : 1);
                        v7 = (m2d.getValue(i - 1, j + 1) == true ? 0 : 1);
                        v8 = (m2d.getValue(i - 1, j) == true ? 0 : 1);
                        v9 = (m2d.getValue(i - 1, j - 1) == true ? 0 : 1);
                        sum = v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9;
                        move01 = 0;
                        if (v2 == 0 && v3 == 1) move01 += 1;
                        if (v3 == 0 && v4 == 1) move01 += 1;
                        if (v4 == 0 && v5 == 1) move01 += 1;
                        if (v5 == 0 && v6 == 1) move01 += 1;
                        if (v6 == 0 && v7 == 1) move01 += 1;
                        if (v7 == 0 && v8 == 1) move01 += 1;
                        if (v8 == 0 && v9 == 1) move01 += 1;
                        if (v9 == 0 && v2 == 1) move01 += 1;

                        if (sum >= 2 && sum <= 6 && move01 == 1 && v2 * v4 * v6 == 0 && v4 * v6 * v8 == 0) {
                            points.add(new Point(i,j, 0, 0));
                        }
                        if (sum >= 2 && sum <= 6 && move01 == 1 && v2 * v4 * v8 == 0 && v2 * v6 * v8 == 0) {
                            points.add(new Point(i,j, 0, 0));
                        }
                    }
                }
            }
            if(points.size()>0){isChanged = true;}
            for (Point p: points) {
                m2d.setValue(p.x, p.y, false);
            }
//        }while(false);
        }while(isChanged);

        return m2d;
    }

    // skeleton
    // p9 p2 p3
    // p8 p1 p4
    // p7 p6 p5
    /**
     *
     * @param inPattern3x3code
     * @param outPattern3x3Code
     * @return
     */
    public Matrix2dBoolean replace3x3(int inPattern3x3code, int outPattern3x3Code){
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                    m2d.setValue(i, j, this.getValue(i, j));
            }
        }
        boolean v1, v2, v3, v4, v5, v6, v7, v8, v9;
        v1 = ((outPattern3x3Code & 1)  == 1) ? true : false;
        v2 = ((outPattern3x3Code & (1<<1)) > 0) ? true : false;
        v3 = ((outPattern3x3Code & (1<<2)) > 0) ? true : false;
        v4 = ((outPattern3x3Code & (1<<3)) > 0) ? true : false;
        v5 = ((outPattern3x3Code & (1<<4)) > 0) ? true : false;
        v6 = ((outPattern3x3Code & (1<<5)) > 0) ? true : false;
        v7 = ((outPattern3x3Code & (1<<6)) > 0) ? true : false;
        v8 = ((outPattern3x3Code & (1<<7)) > 0) ? true : false;
        v9 = ((outPattern3x3Code & (1<<8)) > 0) ? true : false;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                if( m2d.count3x3Pattern(i, j) == inPattern3x3code ){
                    m2d.replace3x3Pattern(i, j, v1, v2, v3, v4, v5, v6, v7, v8, v9);
                }
            }
        }
        return m2d;
    }

    // skeleton
    // p1 p2
    // p4 p3
    /**
     *
     * @param inPattern2x2code
     * @param outPattern2x2Code
     * @return
     */
    public Matrix2dBoolean replace2x2(int inPattern2x2code, int outPattern2x2Code){
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                m2d.setValue(i, j, this.getValue(i, j));
            }
        }
        boolean v1, v2, v3, v4;
        v1 = ((outPattern2x2Code & 1)  == 1) ? true : false;
        v2 = ((outPattern2x2Code & (1<<1)) > 0) ? true : false;
        v3 = ((outPattern2x2Code & (1<<2)) > 0) ? true : false;
        v4 = ((outPattern2x2Code & (1<<3)) > 0) ? true : false;
        for (int j = 1; j < sizeY-1; j++) {
            for (int i = 1; i < sizeX - 1; i++) {
                if( m2d.count2x2Pattern(i, j) == inPattern2x2code ){
                    m2d.replace2x2Pattern(i, j, v1, v2, v3, v4);
                }
            }
        }
        return m2d;
    }

//    /**
//     * count skeleton of image where removed pixels not broke connectivity
//     * @return
//     */
//    public Matrix2dBoolean skeletize(){
//        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
//        boolean isChanged;
//        boolean v2, v3, v4, v5, v6, v7, v8, v9;
//        int n;
//        for (int j = 0; j < sizeY; j++) {
//            for (int i = 0; i < sizeX; i++) {
//                m2d.setValue(i, j, this.getValue(i, j));
//            }
//        }
//        do {
//            isChanged = false;
//            for (int j = 1; j < sizeY - 1; j++) {
//                for (int i = 1; i < sizeX - 1; i++) {
//                    if (m2d.getValue(i, j) == true ){
//                        v2 = m2d.getValue(i, j - 1);
//                        v3 = m2d.getValue(i + 1, j - 1);
//                        v4 = m2d.getValue(i + 1, j);
//                        v5 = m2d.getValue(i + 1, j + 1);
//                        v6 = m2d.getValue(i, j + 1);
//                        v7 = m2d.getValue(i - 1, j + 1);
//                        v8 = m2d.getValue(i - 1, j);
//                        v9 = m2d.getValue(i - 1, j - 1);
//                        // count and check connectivity. If pixel doesn't broke connection we can remove it
//                        n = 0;
//                        if( (v2 == false && v3 == true) ) n++;
//                        if( (v3 == false && v4 == true) ) n++;
//                        if( (v4 == false && v5 == true) ) n++;
//                        if( (v5 == false && v6 == true) ) n++;
//                        if( (v6 == false && v7 == true) ) n++;
//                        if( (v7 == false && v8 == true) ) n++;
//                        if( (v8 == false && v9 == true) ) n++;
//                        if( (v9 == false && v2 == true) ) n++;
//                        if ( n==1 ) {
//                            m2d.setValue(i, j, false);
//                            isChanged = true;
//                        }
//                    }
//                }
//            }
//        }while(isChanged);
//        return m2d;
//    }

    /**
     * count edge in binary mask
     * @return
     */
    public Matrix2dBoolean edge() {
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        int v1, v2, v3, v4, v5, v6, v7, v8, v9;
        int n;
        for (int j = 1; j < sizeY-1; j++) {
            for (int i = 1; i < sizeX-1; i++) {
                v1 = (this.getValue(i, j) == true ? 1 : 0);
                v2 = (this.getValue(i, j - 1) == true ? 1 : 0);
                v3 = (this.getValue(i + 1, j - 1) == true ? 1 : 0);
                v4 = (this.getValue(i + 1, j) == true ? 1 : 0);
                v5 = (this.getValue(i + 1, j + 1) == true ? 1 : 0);
                v6 = (this.getValue(i, j + 1) == true ? 1 : 0);
                v7 = (this.getValue(i - 1, j + 1) == true ? 1 : 0);
                v8 = (this.getValue(i - 1, j) == true ? 1 : 0);
                v9 = (this.getValue(i - 1, j - 1) == true ? 1 : 0);
                n = v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9;
                if(v1==1 && n<8){
                    m2d.setValue(i,j, true);
                }else{
                    m2d.setValue(i,j, false);
                }
            }
        }
        return m2d;
    }

    /**
     * remove ** ->  *
     *        *     *
     * @return
     */
    public Matrix2dBoolean remove90points(){
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                m2d.setValue(i, j, this.getValue(i, j));
            }
        }
        m2d = this.replace2x2(11,10)
                .replace2x2(7,5)
                .replace2x2(14,10)
                .replace2x2(13,5);
        return m2d;
    }

    /**
     * draw line by two points
     * @param p1
     * @param p2
     * @return
     */
    public Matrix2dBoolean drawLine(Point p1, Point p2) {
        return this.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    /**
     * draw line in binary mask
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public Matrix2dBoolean drawLine(int x1, int y1, int x2, int y2){
        double x = x1, y = y1;
        float n = Math.abs(x2-x1)>Math.abs(y2-y1) ? Math.abs(x2-x1) : Math.abs(y2-y1);
        double xStep = (x2-x1)/n;
        double yStep = (y2-y1)/n;
        this.setValue(x1, y1, true);
        this.setValue(x2, y2, true);
        for (int i = 1; i < n; i++) {
            this.setValue( (int)Math.floor(x + xStep*i), (int)Math.floor(y + yStep*i), true);
        }
        return this;
    }

    // TODO:
    /**
     * draw line in binary mask by a and length
     * @param x1
     * @param y1
     * @param angle
     * @param length
     * @return
     */
    public Matrix2dBoolean drawLine1(int x1, int y1, int angle, int length){
        double x = x1, y = y1;
//        float n = Math.abs(x2-x1)>Math.abs(y2-y1) ? Math.abs(x2-x1) : Math.abs(y2-y1);
//        double xStep = (x2-x1)/n;
//        double yStep = (y2-y1)/n;
//        this.setValue(x1, y1, true);
//        this.setValue(x2, y2, true);
//        for (int i = 1; i <= n; i++) {
//            x += xStep;
//            y += yStep;
//            this.setValue( (int)Math.round(x), (int)Math.round(y), true);
//        }
        return this;
    }

    /**
     * draw arc by
     * @param rc
     * @param r
     * @param angleStart
     * @param angleEnd
     * @return
     */
    public Matrix2dBoolean drawArc(Point rc, double r, int angleStart, int angleEnd){
        double angle;
        Point p1, p2;
        int x1, y1, x2, y2;
        angle = angleStart;
        while(angle!=angleEnd) {
            x1 = (int) (rc.x + r * Math.cos(angle * Math.PI / 180));
            y1 = (int) (rc.y + r * Math.sin(angle * Math.PI / 180));
            angle += 1;
            x2 = (int) (rc.x + r * Math.cos(angle * Math.PI / 180));
            y2 = (int) (rc.y + r * Math.sin(angle * Math.PI / 180));
            this.drawLine(x1, y1, x2, y2);
            if(angle == 360){angle = 0;}
        }
        return this;
    }

//    /**
//     * draw arc
//     * @param p1 - start point by uncounter clockwise
//     * @param p2 - end point by uncounter clockwise
//     * @param rc coordinates of point of radius
//     * @return
//     */
//    public Matrix2dBoolean drawArc(Point p1, Point p2, Point rc){
//        int angleStart = (int)Line2d.getAngle(rc, p1);
//        int angleEnd = (int)Line2d.getAngle(rc, p2);
//        double r = Line2d.getLength(rc, p1);
//        this.drawArc(rc, r, angleStart, angleEnd);
//        return this;
//    }

    /**
     * count number for pattern 3x3
     * j = 1; j < sizeY-1;
     * i = 1; i < sizeX-1;
    */
    private int count3x3Pattern(int i, int j){
        int v1, v2, v3, v4, v5, v6, v7, v8, v9, n;
        v1 = this.getValue(i, j) !=null && this.getValue(i, j) == true ? 1 : 0;
        v2 = this.getValue(i, j-1) !=null && this.getValue(i, j - 1) == true ? 1 : 0;
        v3 = this.getValue(i+1, j-1) !=null && this.getValue(i + 1, j - 1) == true ? 1 : 0;
        v4 = this.getValue(i+1, j) !=null && this.getValue(i + 1, j) == true ? 1 : 0;
        v5 = this.getValue(i+1, j+1) !=null && this.getValue(i + 1, j + 1) == true ? 1 : 0;
        v6 = this.getValue(i, j+1) !=null && this.getValue(i, j + 1) == true ? 1 : 0;
        v7 = this.getValue(i-1, j+1) !=null && this.getValue(i - 1, j + 1) == true ? 1 : 0;
        v8 = this.getValue(i-1, j) !=null && this.getValue(i - 1, j) == true ? 1 : 0;
        v9 = this.getValue(i-1, j-1) !=null && this.getValue(i - 1, j - 1) == true ? 1 : 0;
        n = ((((((((((((((((v9<<1)+v8)<<1)+v7)<<1)+v6)<<1)+v5)<<1)+v4)<<1)+v3)<<1)+v2)<<1)+v1);
        return n;
    }

    /**
     * count number for pattern 2x2
     * j = 0; j < sizeY-1;
     * i = 0; i < sizeX-1;
     */
    private int count2x2Pattern(int i, int j){
        int v1, v2, v3, v4, n;
        v1 = (this.getValue(i, j) == true ? 1 : 0);
        v2 = (this.getValue(i + 1, j) == true ? 1 : 0);
        v3 = (this.getValue(i + 1, j + 1) == true ? 1 : 0);
        v4 = (this.getValue(i, j + 1) == true ? 1 : 0);
        n = ((((((v4<<1)+v3)<<1)+v2)<<1)+v1);
        return n;
    }

    /**
     * reduce Noise and gap points by neighbors points values
     * @param oldValue
     * @param minWhite
     * @param maxWhite
     * @param minBlack
     * @param maxBlack
     * @return
     */
    public Matrix2dBoolean replacePoints(boolean oldValue, int minWhite, int maxWhite, int minBlack, int maxBlack) {
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        boolean isChanged;
        int v2, v3, v4, v5, v6, v7, v8, v9;
        int n;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                m2d.setValue(i, j, this.getValue(i, j));
            }
        }

        do {
            isChanged = false;
            for (int j = 0; j < sizeY; j++) {
                for (int i = 0; i < sizeX; i++) {
                    if (m2d.getValue(i, j) == oldValue ){
                        v2 = m2d.getValue(i, j - 1) != null && m2d.getValue(i, j - 1) == true ? 1 : 0;
                        v3 = m2d.getValue(i+1, j - 1) != null && m2d.getValue(i + 1, j - 1) == true ? 1 : 0;
                        v4 = m2d.getValue(i+1, j) != null && m2d.getValue(i + 1, j) == true ? 1 : 0;
                        v5 = m2d.getValue(i+1, j + 1) != null && m2d.getValue(i + 1, j + 1) == true ? 1 : 0;
                        v6 = m2d.getValue(i, j + 1) != null && m2d.getValue(i, j + 1) == true ? 1 : 0;
                        v7 = m2d.getValue(i-1, j + 1) != null && m2d.getValue(i - 1, j + 1) == true ? 1 : 0;
                        v8 = m2d.getValue(i-1, j) != null && m2d.getValue(i - 1, j) == true ? 1 : 0;
                        v9 = m2d.getValue(i-1, j - 1) != null && m2d.getValue(i - 1, j - 1) == true ? 1 : 0;
                        n = v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9;
                        if ( (n >= minWhite && n<=maxWhite) || ((8-n)>= minBlack && (8-n)<=maxBlack) ) {
                            m2d.setValue(i, j, !oldValue);
                            isChanged = true;
                        }
                    }
                }
            }
        }while(isChanged);

        return m2d;
    }

    /**
     *
     * @param i
     * @param j
     * @param v1
     * @param v2
     * @param v3
     * @param v4
     * @param v5
     * @param v6
     * @param v7
     * @param v8
     * @param v9
     */
    private void replace3x3Pattern(int i, int j, boolean v1, boolean v2, boolean v3,
                                   boolean v4, boolean v5, boolean v6,
                                   boolean v7, boolean v8, boolean v9 ){
        this.setValue(i, j, v1);
        this.setValue(i, j - 1, v2);
        this.setValue(i + 1, j - 1, v3);
        this.setValue(i + 1, j, v4);
        this.setValue(i + 1, j + 1, v5);
        this.setValue(i, j + 1, v6);
        this.setValue(i - 1, j + 1, v7);
        this.setValue(i - 1, j, v8);
        this.setValue(i - 1, j - 1, v9);
    }

    /**
     *
     * @param i
     * @param j
     * @param v1
     * @param v2
     * @param v3
     * @param v4
     */
    private void replace2x2Pattern(int i, int j, boolean v1, boolean v2, boolean v3, boolean v4){
        this.setValue(i, j, v1);
        this.setValue(i+1, j, v2);
        this.setValue(i + 1, j + 1, v3);
        this.setValue(i, j + 1, v4);
    }



//    @Deprecated
//    /**
//     * remember in calculation used X axis from left to right and y axis from top to bottom
//     * count a of main axis of symmetry
//     * @return
//     */
//    public int countAngleAxisOfSymmetry(Point center){
//        int x, y;
//        int n = 0;
//        int cx = center.x;
//        int cy = center.y;
//        int dx = 0, dy = 0;
//        int a = 0;
//        int a;
//        y = this.sizeY;
//        x = this.sizeX;
//
//        for(int j = 0; j<y; j++) {
//            for (int i = 0; i < x; i++) {
//                if (this.getValue(i, j) == true) {
//                    dx += (i - cx);
//                    dy += (j - cy);
//                }
//            }
//        }
//        if(dx==0){
//            a =90;
//        }else{
//            a = (int) Math.round( Math.atan2(dy,dx)*180/Math.PI );
//            if(a<0){ a+=360; }
//            if(a> 180){ a-=180;}
//            a = a;
//        }
//
//        return a;
//    }


    /**
     * count number of not null elements
     * @return
     */
    public int countPoints(){
        int n = 0;
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                if(this.getValue(i, j)==true ){n++;}
            }
        }
        return n;
    }

    /**
     * binary get matrix = m1 & m2 by values
     * @param m1
     * @return
     */
    public Matrix2dBoolean and(Matrix2dBoolean m1){
        int sizeX = m1.sizeX;
        int sizeY = m1.sizeY;
        Matrix2dBoolean m2d = new Matrix2dBoolean(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                m2d.setValue(i, j, this.getValue(i,j) & m1.getValue(i,j)  );
            }
        }
        return m2d;
    }

    /**
     * binary get matrix = m1 | m2 by values
     * @param m1
     * @return
     */
    public Matrix2dBoolean or(Matrix2dBoolean m1){
        int sizeX = m1.sizeX;
        int sizeY = m1.sizeY;
        Matrix2dBoolean m2d = new Matrix2dBoolean(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                m2d.setValue(i, j, this.getValue(i,j) | m1.getValue(i,j)  );
            }
        }
        return m2d;
    }


    public static double comparePoints(double x1, double y1, double x2, double y2) {
        double dist = Math.sqrt(
                Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) );
        return dist;
    }

    public static double comparePoints(Matrix2dBoolean base, Matrix2dBoolean in){
        double diff = 0;
        int n = 0;
        double minDist, dist;
        double baseXStep = 1/base.sizeX;
        double baseYStep = 1/base.sizeY;
        double inXStep = 1/in.sizeX;
        double inYStep = 1/in.sizeY;

        double baseSizeX = base.sizeX;
        double baseSizeY = base.sizeY;
        double inSizeX = in.sizeX;
        double inSizeY = in.sizeY;

        for(int j = 0; j<baseSizeY; j++){
            for(int i = 0; i<baseSizeX; i++){
                if(base.getValue(i,j) == true ){
                    n++;
                    minDist = 1;
                    for(int k = 0; k<inSizeY; k++){
                        for(int l = 0; l<inSizeX; l++) {
                            if(in.getValue(l,k) == true ) {
                                dist = Matrix2dBoolean.comparePoints((double)i/base.sizeX, (double)j/base.sizeY,
                                        (double)l/in.sizeX, (double)k/in.sizeY );
                                if(dist<minDist){
                                    minDist = dist;
                                }
                            }
                        }
                    }
                    diff+=minDist;
                }
            }
        }
        diff /= n;
        return diff;
    }


    private static final int _0_45 = 1;
    private static final int _46_90 = 2;
    private static final int _91_135 = 3;
    private static final int _136_179 = 4;

    private static final int FIND_LEFT_POINT = 10;
    private static final int FIND_RIGHT_POINT = 11;

    private static final int P0 = 0;
    private static final int P1 = 1;
    private static final int P2 = 2;
    private static final int P3 = 3;
    private static final int P4 = 4;
    private static final int P5 = 5;
    private static final int P6 = 6;
    private static final int P7 = 7;
    private static final int P8 = 8;

    /**
     * p8 p1 p2
     * p7 p0 p3
     * p6 p5 p4
     * @param pStart - is p0
     * @param pAroundIndex are p1, p2, p3, p4, p5, p6, p7, p8
     * @return
     */
    private Point findPointExist(Point pStart, int pAroundIndex){
        Point p = null;
//        switch(pAroundIndex) {
//            case P1:
//                if (this.getValue(p.x, p.y - 1) == true) {
//                    p = new Point(p.x, p.y - 1);
//                }
//                break;
//            case P2:
//                if (this.getValue(p.x+1, p.y - 1) == true) {
//                    p = new Point(p.x+1, p.y - 1);
//                }
//                break;
//            case P3:
//                if (this.getValue(p.x+1, p.y) == true) {
//                    p = new Point(p.x+1, p.y);
//                }
//                break;
//            case P4:
//                if (this.getValue(p.x+1, p.y+1) == true) {
//                    p = new Point(p.x+1, p.y+1);
//                }
//                break;
//            case P5:
//                if (this.getValue(p.x, p.y+1) == true) {
//                    p = new Point(p.x, p.y+1);
//                }
//                break;
//            case P6:
//                if (this.getValue(p.x-1, p.y+1) == true) {
//                    p = new Point(p.x-1, p.y+1);
//                }
//                break;
//            case P7:
//                if (this.getValue(p.x-1, p.y) == true) {
//                    p = new Point(p.x-1, p.y);
//                }
//                break;
//            case P8:
//                if (this.getValue(p.x-1, p.y-1) == true) {
//                    p = new Point(p.x-1, p.y-1);
//                }
//                break;
//            default: p = null;
//        }
        return p;
    }

    /**
     * Find Point for prolonging line
     * @param p point around to find linePoint
     * @param directionLine from _0 to _136_179 constants
     * @param directionLine FIND_LEFT_POINT or FIND_RIGHT_POINT
     * @return Point
     */
    private Point findMorthPoint(Point p, int directionLine, int findPoint){
        Point pNext = null;
//        if(findPoint == FIND_LEFT_POINT){
//            switch(directionLine){
//                case _0: if(this.getValue(p.x-1, p.y)==true){
//                    pNext = new Point(p.x-1, p.y);
//                }
//                break;
//
//                case _1_44: break;
//
//                case _45: if(this.getValue(p.x-1, p.y+1)==true){
//                    pNext = new Point(p.x-1, p.y+1);
//                }
//                break;
//                case _46_89: break;
//                case _90: if(this.getValue(p.x, p.y-1)==true){
//                    pNext = new Point(p.x, p.y-1);
//                }
//                break;
//                case _91_134: break;
//                case _135: if(this.getValue(p.x-1, p.y-1)==true){
//                    pNext = new Point(p.x-1, p.y-1);
//                }
//                break;
//                case _136_179: break;
//            }
//        }
//        if(findPoint == FIND_RIGHT_POINT){
//            switch(directionLine){
//                case _0: break;
//                case _1_44: break;
//                case _45: break;
//                case _46_89: break;
//                case _90: break;
//                case _91_134: break;
//                case _135: break;
//                case _136_179: break;
//            }
//        }
//
        return pNext;
    }

    private MorthLine findMorthLine(Point pStart, int directionLine){
        MorthLine mLine = new MorthLine();
        Point p1, p2;
        p1 = pStart;
        p2 = pStart;
        boolean isNextPointAvailable = false;
//        do{
//
//        }while();


        return mLine;
    }


    /**
     * find all morthological lines on 2d boolean matrix
     * @return
     */
    public ArrayList<MorthLine> findMorthLines(){
        ArrayList<MorthLine> lines = new ArrayList<MorthLine>();
        Matrix2dBoolean isProcessed = new Matrix2dBoolean(this.sizeX, this.sizeY);

//        Point p1, p2;
//        Curve curve;
//        ArrayList<Point> curvePoints;
//        int n;
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                if(this.getValue(i, j)==true && isProcessed.getValue(i, j) == false) {
//
//                    while(){
//
//
//                    }
                }
            }
        }

        return lines;
    }


}