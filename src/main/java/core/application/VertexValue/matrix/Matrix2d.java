package core.application.VertexValue.matrix;

import core.application.VertexValue.coords.Decart2dInt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by anonymous on 29.10.2018.
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
     * setValue into Matrix2d
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
     * set new size of Matrix2d, all data will be rewritten with defaultValue
     * @param xSize
     * @param ySize
     * @param defaultValue
     */
    public void setSizeXY(int xSize, int ySize, T defaultValue) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.values = (T[][]) Array.newInstance(this.elementClass, ySize, xSize);
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, defaultValue);
            }
        }
    }

    /**
     * set new size of Matrix2d, all data will be rewritten with "null" value
     * @param xSize
     * @param ySize
     */
    public void setSizeXY(int xSize, int ySize) {
        this.setSizeXY(xSize, ySize, null);
    }

    /**
     * count number of not null elements
     * @return
     */
    public int countNotNullElements(){
        int n = 0;
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                T value = this.getValue(i, j);
                if( value!=null ){
                    n+=1;
                }
            }
        }
        return n;
    }

    /**
     * can find segments only of not null values in matrix2d
     * 8-linked points algoritm
     * null value counts as non exist elements and no need for processing
     * @param x
     * @param y
     * @return
     */
    public ArrayList<Decart2dInt> count8LSegment(int x, int y){
        if( this.getValue(x, y) == null ) return null;
        Matrix2d<Boolean> isProcessed = new Matrix2d<Boolean>(Boolean.class, this.sizeX, this.sizeY, false);
        int pi, pj;
        T v1, v2, v3, v4, v5, v6, v7, v8, v9;
        ArrayList<Decart2dInt> s = new ArrayList<Decart2dInt>();
        Decart2dInt p;
        LinkedList<Decart2dInt> points = new LinkedList<Decart2dInt>();
        points.add( new Decart2dInt(x, y) );
        isProcessed.setValue(x, y, true);
        while(points.size()>0){
            p = points.poll();
            s.add(p);
            pi = p.x;
            pj = p.y;
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
    public ArrayList<Decart2dInt> count4LSegment(int x, int y){
        if( this.getValue(x, y) == null ) return null;
        Matrix2d<Boolean> isProcessed = new Matrix2d<Boolean>(Boolean.class, this.sizeX, this.sizeY, false);
        int pi, pj;
        T v1, v2, v4, v6, v8;
        ArrayList<Decart2dInt> s = new ArrayList<Decart2dInt>();
        Decart2dInt p;
        LinkedList<Decart2dInt> points = new LinkedList<Decart2dInt>();
        points.add( new Decart2dInt(x, y) );
        isProcessed.setValue(x, y, true);
        while(points.size()>0){
            p = points.poll();
            s.add(p);
            pi = p.x;
            pj = p.y;
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

    /**
     * can find Contour only if it contains not null elements -s contour and null values - empty values
     * null - no contour, not null - element of contour
     * 4-linked points algoritm
     * null value counts as non exist elements and no need for processing
     * @param x
     * @param y
     * @return
     */
    public LinkedList<Decart2dInt> count4LContour(int x, int y){
        if( this.getValue(x, y) == null ) return null;
        int pi, pj;
        T v1, v2, v4, v6, v8;
        Matrix2d<Boolean> isProcessed = new Matrix2d<Boolean>(Boolean.class, this.sizeX, this.sizeY, false);
        LinkedList<Decart2dInt> points = new LinkedList<Decart2dInt>();
        isProcessed.setValue(x, y, true);
        Decart2dInt start, curr, next;
        start = new Decart2dInt(x, y);
        curr = start;
        next = new Decart2dInt(-1, -1);
        while( next!=null && !(next.x==start.x && next.y==start.y) ){
            pi = curr.x;
            pj = curr.y;
            v1 = this.getValue(pi, pj);
            v2 = this.getValue(pi, pj-1);
            v4 = this.getValue(pi+1, pj);
            v6 = this.getValue(pi, pj+1);
            v8 = this.getValue(pi-1, pj);
            if( v2 != null && isProcessed.getValue(pi, pj-1) == false) {
                isProcessed.setValue(pi, pj-1, true);
                next = new Decart2dInt(pi, pj-1);
                points.add( next );
                break;
            }
            if( v4 != null && isProcessed.getValue(pi+1, pj) == false) {
                isProcessed.setValue(pi+1,pj, true);
                next = new Decart2dInt(pi+1,pj);
                points.add( next );
                break;
            }
            if( v6 != null && isProcessed.getValue(pi, pj+1) == false) {
                isProcessed.setValue(pi,pj+1, true);
                next = new Decart2dInt(pi,pj+1);
                points.add( next );
                break;
            }
            if( v8 != null && isProcessed.getValue(pi-1, pj) == false) {
                isProcessed.setValue(pi-1,pj, true);
                next = new Decart2dInt(pi-1,pj);
                points.add( next );
                break;
            }
            next = null;
        }
        return points;
    }



}