package core.old.VertexValue.matrix;

import core.old.VertexValue.coords.Decart2dInt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by anonymous on 29.10.2018.
 * states for porcessing and storing temporal data about activity element
 * true = Active, selected, processed
 * false = not active, not selected, not processed
 * null = processed, no element, no need to onProcess, excluded from processing
 */
public class Matrix2d<T> implements IMatrix {
    private Class<T> elementClass;
    protected T[][] values;
    public int sizeX;
    public int sizeY;

    /**
     * create empty class with values = null
     */
    public Matrix2d(Class<T> clazz) {
        this.sizeX = 1;
        this.sizeY = 1;
        elementClass = clazz;
        this.values = (T[][]) Array.newInstance(clazz, this.sizeY, this.sizeX);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
    }

    /**
     * create Matrix2d with all values equal null
     * @param clazz
     * @param xSize
     * @param ySize
     */
    public Matrix2d(Class<T> clazz, int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        elementClass = clazz;
        this.values = (T[][]) Array.newInstance(clazz, ySize, xSize);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
    }

    /**
     * set all elements as single instance of defaultValue
     * @param clazz
     * @param xSize
     * @param ySize
     * @param defaultValue
     */
    public Matrix2d(Class<T> clazz, int xSize, int ySize, T defaultValue) {
        elementClass = clazz;
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.values = (T[][]) Array.newInstance(clazz, ySize, xSize);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, defaultValue);
            }
        }
    }

    /**
     * setBufferedImage into Matrix2d
     * @param xPos
     * @param yPos
     * @param value
     */
    public void setValue(int xPos, int yPos, T value) {
        if (xPos >= 0 && xPos < this.sizeX && yPos >= 0 && yPos < this.sizeY) {
            this.values[yPos][xPos] = value;
        }
    }

    /**
     * getValue from Matrix2d
     * @param xPos
     * @param yPos
     * @return
     */
    public T getValue(int xPos, int yPos) {
        if (xPos >= 0 && xPos < this.sizeX && yPos >= 0 && yPos < this.sizeY) {
            return this.values[yPos][xPos];
        }
        return null;
    }

    /**
     * set new size of Matrix2d, all data will be rewritten with "null" value
     * @param xSize
     * @param ySize
     */
    public void setSizeXY(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.values = (T[][]) Array.newInstance(this.elementClass, ySize, xSize);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
    }

    /**
     * count number of not null elements
     * @return
     */
    public int countValues(T valueToCount){
        int n = 0;
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                T value = this.getValue(i, j);
                if( value.equals(valueToCount) ){
                    n+=1;
                }
            }
        }
        return n;
    }

    /**
     * count number of not null elements
     */
    public void resetValues(T defaultValue){
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, defaultValue);
            }
        }
    }

    /**
     * can find segments only of not null values in matrix2d
     * 8-linked points algoritm
     * null value counts as non exist elements and no need for processing
     * @param x
     * @param y
     * @return
     */
    public ArrayList<Decart2dInt> count8LSegmentPoints(int x, int y){
        if( this.getValue(x, y) == null ) return null;
        Matrix2d<Boolean> isProcessed = new Matrix2d<>(Boolean.class, this.sizeX, this.sizeY, false);
        int pi, pj;
        T v1, v2, v3, v4, v5, v6, v7, v8, v9;
        ArrayList<Decart2dInt> s = new ArrayList<>();
        Decart2dInt p;
        LinkedList<Decart2dInt> points = new LinkedList<>();
        points.add( new Decart2dInt(x, y) );
        isProcessed.setValue(x, y, true);
        while(points.size()>0){
            p = points.poll();
            s.add(p);
            pi = (int)Math.ceil(p.x);
            pj = (int)Math.ceil(p.y);
            v1 = this.getValue(pi, pj);
            v2 = this.getValue(pi, pj-1);
            v3 = this.getValue(pi+1, pj-1);
            v4 = this.getValue(pi+1, pj);
            v5 = this.getValue(pi+1, pj+1);
            v6 = this.getValue(pi, pj+1);
            v7 = this.getValue(pi-1, pj+1);
            v8 = this.getValue(pi-1, pj);
            v9 = this.getValue(pi-1, pj-1);
            if( v2 != null && isProcessed.getValue(pi, pj-1) == false && v1 == v2 ) {
                points.add( new Decart2dInt(pi,pj-1) );
                isProcessed.setValue(pi, pj-1, true);
            }
            if( v3 != null && isProcessed.getValue(pi+1, pj-1) == false && v1 == v3 ) {
                points.add( new Decart2dInt(pi+1,pj-1) );
                isProcessed.setValue(pi+1, pj-1, true);
            }
            if( v4 != null && isProcessed.getValue(pi+1, pj) == false && v1 == v4 ) {
                points.add( new Decart2dInt(pi+1,pj) );
                isProcessed.setValue(pi+1, pj, true);
            }
            if( v5 != null && isProcessed.getValue(pi+1, pj+1) == false && v1 == v5 ) {
                points.add( new Decart2dInt(pi+1,pj+1) );
                isProcessed.setValue(pi+1, pj+1, true);
            }
            if( v6 != null && isProcessed.getValue(pi, pj+1) == false && v1 == v6 ) {
                points.add( new Decart2dInt(pi,pj+1) );
                isProcessed.setValue(pi, pj+1, true);
            }

            if( v7 != null && isProcessed.getValue(pi-1, pj+1) == false && v1 == v7 ) {
                points.add( new Decart2dInt(pi-1,pj+1) );
                isProcessed.setValue(pi-1, pj+1, true);
            }
            if( v8 != null && isProcessed.getValue(pi-1, pj) == false && v1 == v8 ) {
                points.add( new Decart2dInt(pi-1,pj) );
                isProcessed.setValue(pi-1, pj, true);
            }
            if( v9 != null && isProcessed.getValue(pi-1, pj-1) == false && v1 == v9) {
                points.add( new Decart2dInt(pi-1,pj-1) );
                isProcessed.setValue(pi-1, pj-1, true);
            }
        }
        return s;
    }

    /**
     * can find segments only of not null values in matrix2d
     * 4-linked points algoritm
     * null value counts as non exist elements and no need for processing
     * @param x
     * @param y
     * @return
     */
    public ArrayList<Decart2dInt> count4LSegmentPoints(int x, int y){
        if( this.getValue(x, y) == null ) return null;
        Matrix2d<Boolean> isProcessed = new Matrix2d<>(Boolean.class, this.sizeX, this.sizeY, false);
        int pi, pj;
        T v1, v2, v4, v6, v8;
        ArrayList<Decart2dInt> s = new ArrayList<>();
        Decart2dInt p;
        LinkedList<Decart2dInt> points = new LinkedList<>();
        points.add( new Decart2dInt(x, y) );
        isProcessed.setValue(x, y, true);
        while(points.size()>0){
            p = points.poll();
            s.add(p);
            pi = (int)Math.ceil(p.x);
            pj = (int)Math.ceil(p.y);
            v1 = this.getValue(pi, pj);
            v2 = this.getValue(pi, pj-1);
            v4 = this.getValue(pi+1, pj);
            v6 = this.getValue(pi, pj+1);
            v8 = this.getValue(pi-1, pj);
            if( v2 != null && isProcessed.getValue(pi, pj-1) == false && v1 == v2 ) {
                points.add( new Decart2dInt(pi,pj-1) );
                isProcessed.setValue(pi, pj-1, true);
            }
            if( v4 != null && isProcessed.getValue(pi+1, pj) == false && v1 == v4 ) {
                points.add( new Decart2dInt(pi+1,pj) );
                isProcessed.setValue(pi+1, pj, true);
            }
            if( v6 != null && isProcessed.getValue(pi, pj+1) == false && v1 == v6 ) {
                points.add( new Decart2dInt(pi,pj+1) );
                isProcessed.setValue(pi, pj+1, true);
            }
            if( v8 != null && isProcessed.getValue(pi-1, pj) == false && v1 == v8 ) {
                points.add( new Decart2dInt(pi-1,pj) );
                isProcessed.setValue(pi-1, pj, true);
            }
        }
        return s;
    }

//    /**
//     * can find segments only of not null values in matrix2d
//     * 4-linked points algoritm
//     * null value counts as non exist elements and no need for processing
//     * @param x
//     * @param y
//     * @return
//     */
//    public Matrix2dBool count4LinkSegmentMask(int x, int y){
//        if( this.getValue(x, y) == null ) return null;
//        Matrix2dBool m2dMask = new Matrix2dBool(this.sizeX, this.sizeY, false);
//        int pi, pj;
//        T v1, v2, v4, v6, v8;
//        //ArrayList<Decart2dInt> s = new ArrayList<Decart2dInt>();
//        Decart2d p;
//        LinkedList<Decart2d> points = new LinkedList<Decart2d>();
//        points.add( new Decart2d(x, y) );
//        m2dMask.setBufferedImage(x, y, true);
//        while(points.size()>0){
//            p = points.poll();
//            //s.add(p);
//            pi = (int)Math.ceil(p.x);
//            pj = (int)Math.ceil(p.y);
//            v1 = this.getValue(pi, pj);
//            v2 = this.getValue(pi, pj-1);
//            v4 = this.getValue(pi+1, pj);
//            v6 = this.getValue(pi, pj+1);
//            v8 = this.getValue(pi-1, pj);
//            if( v2 != null && m2dMask.getValue(pi, pj-1) == false && v1 == v2 ) {
//                points.add( new Decart2d(pi,pj-1) );
//                m2dMask.setBufferedImage(pi, pj-1, true);
//            }
//            if( v4 != null && m2dMask.getValue(pi+1, pj) == false && v1 == v4 ) {
//                points.add( new Decart2d(pi+1,pj) );
//                m2dMask.setBufferedImage(pi+1, pj, true);
//            }
//            if( v6 != null && m2dMask.getValue(pi, pj+1) == false && v1 == v6 ) {
//                points.add( new Decart2d(pi,pj+1) );
//                m2dMask.setBufferedImage(pi, pj+1, true);
//            }
//            if( v8 != null && m2dMask.getValue(pi-1, pj) == false && v1 == v8 ) {
//                points.add( new Decart2d(pi-1,pj) );
//                m2dMask.setBufferedImage(pi-1, pj, true);
//            }
//        }
//        return m2dMask;
//    }

//    /**
//     * check if point is Contour point
//     * @param x
//     * @param y
//     * @return
//     */
//    public Boolean isContourPoint(int x, int y){
//        Boolean isContourPoint = false;
//        if( this.getValue(x, y) != null ) {
//            isContourPoint = true;
//            int pi, pj;
//            T v1, v2, v3, v4, v5, v6, v7, v8, v9;
//            Decart2d curr = new Decart2d(x, y);
//            pi = (int) Math.ceil(curr.x);
//            pj = (int) Math.ceil(curr.y);
//            v1 = this.getValue(pi, pj);
//            v2 = this.getValue(pi, pj - 1);
//            v3 = this.getValue(pi + 1, pj - 1);
//            v4 = this.getValue(pi + 1, pj);
//            v5 = this.getValue(pi + 1, pj + 1);
//            v6 = this.getValue(pi, pj + 1);
//            v7 = this.getValue(pi - 1, pj + 1);
//            v8 = this.getValue(pi - 1, pj);
//            v9 = this.getValue(pi - 1, pj - 1);
//            if (v1.equals(v2) && v1.equals(v3) && v1.equals(v4)
//                    && v1.equals(v5) && v1.equals(v6) && v1.equals(v7)
//                    && v1.equals(v8) && v1.equals(v9)) {
//                isContourPoint = false;
//            }
//        }
//        return isContourPoint;
//    }

//    /**
//     * check if point is Contour point
//     * @param x
//     * @param y
//     * @return
//     */
//    public Boolean isCertainContourPoint(int x, int y, T value){
//        Boolean isContourPoint = false;
//        if( this.getValue(x, y) != null && this.getValue(x, y).equals(value)) {
//            isContourPoint = true;
//            int pi, pj;
//            T v1, v2, v3, v4, v5, v6, v7, v8, v9;
//            Decart2d curr = new Decart2d(x, y);
//            pi = (int) Math.ceil(curr.x);
//            pj = (int) Math.ceil(curr.y);
//            v1 = this.getValue(pi, pj);
//            v2 = this.getValue(pi, pj - 1);
//            v3 = this.getValue(pi + 1, pj - 1);
//            v4 = this.getValue(pi + 1, pj);
//            v5 = this.getValue(pi + 1, pj + 1);
//            v6 = this.getValue(pi, pj + 1);
//            v7 = this.getValue(pi - 1, pj + 1);
//            v8 = this.getValue(pi - 1, pj);
//            v9 = this.getValue(pi - 1, pj - 1);
//            if (v1.equals(v2) && v1.equals(v3) && v1.equals(v4)
//                    && v1.equals(v5) && v1.equals(v6) && v1.equals(v7)
//                    && v1.equals(v8) && v1.equals(v9)) {
//                isContourPoint = false;
//            }
//        }
//        return isContourPoint;
//    }


//    /**
//     * p1 p2
//     * p4 p3
//     * @param p
//     * @param bitPattern
//     * @return
//     */
//    public boolean isPattern2x2(Decart2dInt p, BitSet bitPattern){
//        boolean b1 = bitPattern.get(0);
//        boolean b2 = bitPattern.get(1);
//        boolean b3 = bitPattern.get(2);
//        boolean b4 = bitPattern.get(3);
//
//
//    }

//    /**
//     * p1 p2
//     * p4 p3
//     * converts points of segment into m2d where points connected as contours of segment
//     * @param points
//     * @return
//     */
//    public Matrix2d<Decart2dInt8Links> arrayPointsToMatrix2dPoints8Links(ArrayList<Decart2dInt> points){
//        Matrix2d<Decart2dInt8Links> m2d8Links = new Matrix2d<Decart2dInt8Links>();
//        T p1, p2, p3, p4;
//        for(Decart2dInt p: points){
//            if(pattern)
//            p1 = this.getValue(p.x, p.y);
//            p2 = this.getValue(p.x+1, p.y);
//            p3 = this.getValue(p.x+1, p.y+1);
//            p4 = this.getValue(p.x, p.y+1);
//
//            // TODO:
//        }
//
//        return m2d8Links;
//    }

//    public Segment2d m2d8LinksToSegment2d(Matrix2d<Decart2dInt8Links> in){
//        ITexture texture = null;
//        IContour outerContour = null;
//        ArrayList<IContour> innerContours = new ArrayList<>();
//        Segment2d segment2d = null;
//        for (int j = 0; j < in.sizeY; j++) {
//            for (int i = 0; i < in.sizeX; i++) {
//                if( this.getValue(i, j)!=null){
//
//                }
//            }
//        }
//
//        return new Segment2d(texture, outerContour, innerContours);
//    }

//    /**
//     * can find Contour only if it contains not null elements -s contour and null values - empty values
//     * null - no contour, not null - element of contour
//     * 4-linked points algoritm
//     * null value counts as non exist elements and no need for processing
//     * @param x
//     * @param y
//     * @return
//     */
//    public LinkedList<Decart2d> count4LContour(int x, int y){
//        LinkedList<Decart2d> contour = null;
//        if( this.isContourPoint(x, y) != null ){
//        int pi, pj;
//        byte direction = 2;
//        T v1, v2, v3, v4, v5, v6, v7, v8, v9;
//        Decart2d start, curr, next;
//        start = new Decart2d(x, y);
//        curr = start;
//        next = new Decart2d(-1, -1);
//        direction
//        while( next!=null && !(next.x==start.x && next.y==start.y) ){
//            pi = (int)Math.ceil(curr.x);
//            pj = (int)Math.ceil(curr.y);
//            v1 = this.getValue(pi, pj);
//            v2 = this.getValue(pi, pj-1);
//            v3 = this.getValue(pi+1, pj-1);
//            v4 = this.getValue(pi+1, pj);
//            v5 = this.getValue(pi+1, pj+1);
//            v6 = this.getValue(pi, pj+1);
//            v7 = this.getValue(pi-1, pj+1);
//            v8 = this.getValue(pi-1, pj);
//            v9 = this.getValue(pi-1, pj-1);
//
//
//
//            if( v2 != null && isProcessed.getValue(pi, pj-1) == false) {
//                isProcessed.setBufferedImage(pi, pj-1, true);
//                next = new Decart2d(pi, pj-1);
//                points.add( next );
//                break;
//            }
//            if( v4 != null && isProcessed.getValue(pi+1, pj) == false) {
//                isProcessed.setBufferedImage(pi+1,pj, true);
//                next = new Decart2d(pi+1,pj);
//                points.add( next );
//                break;
//            }
//            if( v6 != null && isProcessed.getValue(pi, pj+1) == false) {
//                isProcessed.setBufferedImage(pi,pj+1, true);
//                next = new Decart2d(pi,pj+1);
//                points.add( next );
//                break;
//            }
//            if( v8 != null && isProcessed.getValue(pi-1, pj) == false) {
//                isProcessed.setBufferedImage(pi-1,pj, true);
//                next = new Decart2d(pi-1,pj);
//                points.add( next );
//                break;
//            }
//            next = null;
//        }
//        return null; //contour;
//    }

//    /**
//     * can find Contour only if it contains not null elements -s contour and null values - empty values
//     * null - no contour, not null - element of contour
//     * 4-linked points algoritm
//     * null value counts as non exist elements and no need for processing
//     * @param x
//     * @param y
//     * @return
//     */
//    public ArrayList<ContourDecart2d> countAllContours(int x, int y){
//        if( this.getValue(x, y) == null ) return null;
//        ArrayList<Decart2d> segmentPoints = this.count4LSegmentPoints(x, y);
//        for (Decart2d p: segmentPoints){
//
//        }
//
//        int pi, pj;
//        T v1, v2, v4, v6, v8;
//        Matrix2d<Boolean> isProcessed = new Matrix2d<Boolean>(Boolean.class, this.sizeX, this.sizeY, false);
//        LinkedList<Decart2d> points = new LinkedList<Decart2d>();
//        isProcessed.setBufferedImage(x, y, true);
//        Decart2d start, curr, next;
//        start = new Decart2d(x, y);
//        curr = start;
//        next = new Decart2d(-1, -1);
//        while( next!=null && !(next.x==start.x && next.y==start.y) ){
//            pi = (int)Math.ceil(curr.x);
//            pj = (int)Math.ceil(curr.y);
//            v1 = this.getValue(pi, pj);
//            v2 = this.getValue(pi, pj-1);
//            v4 = this.getValue(pi+1, pj);
//            v6 = this.getValue(pi, pj+1);
//            v8 = this.getValue(pi-1, pj);
//            if( v2 != null && isProcessed.getValue(pi, pj-1) == false) {
//                isProcessed.setBufferedImage(pi, pj-1, true);
//                next = new Decart2d(pi, pj-1);
//                points.add( next );
//                break;
//            }
//            if( v4 != null && isProcessed.getValue(pi+1, pj) == false) {
//                isProcessed.setBufferedImage(pi+1,pj, true);
//                next = new Decart2d(pi+1,pj);
//                points.add( next );
//                break;
//            }
//            if( v6 != null && isProcessed.getValue(pi, pj+1) == false) {
//                isProcessed.setBufferedImage(pi,pj+1, true);
//                next = new Decart2d(pi,pj+1);
//                points.add( next );
//                break;
//            }
//            if( v8 != null && isProcessed.getValue(pi-1, pj) == false) {
//                isProcessed.setBufferedImage(pi-1,pj, true);
//                next = new Decart2d(pi-1,pj);
//                points.add( next );
//                break;
//            }
//            next = null;
//        }
//        return points;
//    }
//


}