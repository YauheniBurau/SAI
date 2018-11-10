package core.application.dataElement;

import core.old.Point;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by anonymous on 24.03.2018.
 * values of values byte[0..255]
 */
public class Matrix2dByte extends AbstractElement {
    private Byte[][] matrix;

    public final int sizeX;
    public final int sizeY;

    public Matrix2dByte(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new Byte[ySize][xSize];
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                this.setValue( i, j, null );
            }
        }
    }

    public Matrix2dByte(int xSize, int ySize, byte value) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new Byte[ySize][xSize];
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                this.setValue( i, j, value );
            }
        }
    }

    public void setValue(int xPos, int yPos, Byte value) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public Byte getValue(int xPos, int yPos) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            return this.matrix[yPos][xPos];
        }
        return null;
    }



    /**
     *
     * @param isProcessed
     * @param maxDiff
     * @param x
     * @param y
     * @return
     */
    public Segment findSegment(Matrix2dBoolean isProcessed, int maxDiff, int x, int y){
        int pi, pj;
        Byte v2, v3, v4, v5, v6, v7, v8, v9;
        double summ = 0;
        int n = 0;
        Segment s = new Segment();
        s.mainM2d = this;
        Point p;
        LinkedList<Point> points = new LinkedList<Point>();
        points.add( new Point(x, y, 0, this.getValue(x, y)) );
        isProcessed.setValue(x, y, true);
        summ += this.getValue(x, y);
        n += 1;
        while(points.size()>0){
            p = points.poll();
            s.points.add(p);
            pi = p.x;
            pj = p.y;
            v2 = this.getValue(pi, pj-1);
            v3 = this.getValue(pi+1, pj-1);
            v4 = this.getValue(pi+1, pj);
            v5 = this.getValue(pi+1, pj+1);
            v6 = this.getValue(pi, pj+1);
            v7 = this.getValue(pi-1, pj+1);
            v8 = this.getValue(pi-1, pj);
            v9 = this.getValue(pi-1, pj-1);
            if( v2 != null && isProcessed.getValue(pi, pj-1) == false && Math.abs(summ/n - v2) <= maxDiff) {
                points.add( new Point(pi,pj-1, 0, v2) );
                isProcessed.setValue(pi, pj-1, true);
                summ += v2;
                n += 1;
            }
            if( v3 != null && isProcessed.getValue(pi+1, pj-1) == false && Math.abs(summ/n - v3) <= maxDiff) {
                points.add( new Point(pi+1,pj-1, 0, v3) );
                isProcessed.setValue(pi+1, pj-1, true);
                summ += v3;
                n += 1;
            }
            if( v4 != null && isProcessed.getValue(pi+1, pj) == false && Math.abs(summ/n - v4) <= maxDiff) {
                points.add( new Point(pi+1,pj, 0, v4) );
                isProcessed.setValue(pi+1, pj, true);
                summ += v4;
                n += 1;
            }
            if( v5 != null && isProcessed.getValue(pi+1, pj+1) == false && Math.abs(summ/n - v5) <= maxDiff) {
                points.add( new Point(pi+1,pj+1, 0, v5) );
                isProcessed.setValue(pi+1, pj+1, true);
                summ += v5;
                n += 1;
            }
            if( v6 != null && isProcessed.getValue(pi, pj+1) == false && Math.abs(summ/n - v6) <= maxDiff) {
                points.add( new Point(pi,pj+1, 0, v6) );
                isProcessed.setValue(pi, pj+1, true);
                summ += v6;
                n += 1;
            }

            if( v7 != null && isProcessed.getValue(pi-1, pj+1) == false && Math.abs(summ/n - v7) <= maxDiff) {
                points.add( new Point(pi-1,pj+1, 0, v7) );
                isProcessed.setValue(pi-1, pj+1, true);
                summ += v7;
                n += 1;
            }
            if( v8 != null && isProcessed.getValue(pi-1, pj) == false && Math.abs(summ/n - v8) <= maxDiff) {
                points.add( new Point(pi-1,pj, 0, v8) );
                isProcessed.setValue(pi-1, pj, true);
                summ += v8;
                n += 1;
            }
            if( v9 != null && isProcessed.getValue(pi-1, pj-1) == false && Math.abs(summ/n - v9) <= maxDiff) {
                points.add( new Point(pi-1,pj-1, 0, v9) );
                isProcessed.setValue(pi-1, pj-1, true);
                summ += v9;
                n += 1;
            }
        }
        return s;
    }

    /**
     * find all segments
     * @param maxDiff
     * @return
     */
    public ArrayList<Segment> findSegments(int maxDiff) {
        ArrayList<Segment> segments = new ArrayList<Segment>();
        Matrix2dBoolean isProcessed = new Matrix2dBoolean(this.sizeX, this.sizeY);
        Segment seg;
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                if( isProcessed.getValue(i, j) == false ){
                    seg = this.findSegment(isProcessed, maxDiff, i, j);
                    for(Point p: seg.points){
                        isProcessed.setValue(p.x, p.y, true);
                    }
                    segments.add(seg);
                }
            }
        }
        return segments;
    }

    @Deprecated
    /**
     * count center of weight
     * @return
     */
    public Point countCenterOfSymmetry(){
//        int x, y, n = 0, cx = 0, cy = 0;
//        y = this.sizeY;
//        x = this.size;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                if( this.getValue(i, j)==true){
//                    n +=1;
//                    cx += i;
//                    cy += j;
//                }
//            }
//        }
//        if(n>0) {
//            cx /= n;
//            cy /= n;
//        }
//        return new Point2d(cx, cy);
        return null;
    }

}
