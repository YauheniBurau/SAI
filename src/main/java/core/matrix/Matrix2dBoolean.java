package core.matrix;

import core.element.*;
import core.exceptions.FileException;
//import core.element.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anonymous on 05.10.2017.
 */
public class Matrix2dBoolean{
    private boolean[][] matrix;
    public final int sizeX;
    public final int sizeY;

    public Matrix2dBoolean(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new boolean[ySize][xSize];
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                this.setValue(i, j, false);
            }
        }
    }

    public void setValue(int xPos, int yPos, boolean value) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public boolean getValue(int xPos, int yPos) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            return this.matrix[yPos][xPos];
        }
        return false;
    }

    /**
     * save matrix to image-file
     * @param urlFile
     * @param format
     */
    public Matrix2dBoolean save(String urlFile, String format, int type) {
        BufferedImage image;
        int x, y;
        image = new BufferedImage(this.sizeX, this.sizeY, type);
        y = this.sizeY;
        x = this.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, Color.booleanToInt(this.getValue(i, j)) );
            }
        }
        try {
            ImageIO.write(image, format, new File(urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write matrix2d to image file", e);
        }
        return this;
    }


    /**
     * skeletize binary image by Zhang Suen algorythm
     * @return
     */
    public Matrix2dBoolean skeletonByZhangSuen(){
        int i, j;
        int sX = this.sizeX;
        int sY = this.sizeY;
        ArrayList<Point2d> points = new ArrayList<Point2d>();
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
            points = new ArrayList<Point2d>();
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
                            points.add(new Point2d(i,j));
                        }
                        if (sum >= 2 && sum <= 6 && move01 == 1 && v2 * v4 * v8 == 0 && v2 * v6 * v8 == 0) {
                            points.add(new Point2d(i,j));
                        }
                    }
                }
            }
            if(points.size()>0){isChanged = true;}
            for (Point2d p: points) {
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
        for (int j = 1; j < sizeY-1; j++) {
            for (int i = 1; i < sizeX - 1; i++) {
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

    /**
     * count skeleton of image where removed pixels not broke connectivity
     * @return
     */
    public Matrix2dBoolean skeletize(){
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        boolean isChanged;
        boolean v2, v3, v4, v5, v6, v7, v8, v9;
        int n;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                m2d.setValue(i, j, this.getValue(i, j));
            }
        }
        do {
            isChanged = false;
            for (int j = 1; j < sizeY - 1; j++) {
                for (int i = 1; i < sizeX - 1; i++) {
                    if (m2d.getValue(i, j) == true ){
                        v2 = m2d.getValue(i, j - 1);
                        v3 = m2d.getValue(i + 1, j - 1);
                        v4 = m2d.getValue(i + 1, j);
                        v5 = m2d.getValue(i + 1, j + 1);
                        v6 = m2d.getValue(i, j + 1);
                        v7 = m2d.getValue(i - 1, j + 1);
                        v8 = m2d.getValue(i - 1, j);
                        v9 = m2d.getValue(i - 1, j - 1);
                        // count and check connectivity. If pixel doesn't broke connection we can remove it
                        n = 0;
                        if( (v2 == false && v3 == true) ) n++;
                        if( (v3 == false && v4 == true) ) n++;
                        if( (v4 == false && v5 == true) ) n++;
                        if( (v5 == false && v6 == true) ) n++;
                        if( (v6 == false && v7 == true) ) n++;
                        if( (v7 == false && v8 == true) ) n++;
                        if( (v8 == false && v9 == true) ) n++;
                        if( (v9 == false && v2 == true) ) n++;
                        if ( n==1 ) {
                            m2d.setValue(i, j, false);
                            isChanged = true;
                        }
                    }
                }
            }
        }while(isChanged);
        return m2d;
    }

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
    public Matrix2dBoolean drawLine(Point2d p1, Point2d p2) {
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
        for (int i = 1; i <= n; i++) {
            x += xStep;
            y += yStep;
            this.setValue( (int)Math.round(x), (int)Math.round(y), true);
        }
        return this;
    }

    // TODO:
    /**
     * draw line in binary mask by angle and length
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
    public Matrix2dBoolean drawArc(Point2d rc, double r, int angleStart, int angleEnd){
        double angle;
        Point2d p1, p2;
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

    /**
     * draw arc
     * @param p1 - start point by uncounter clockwise
     * @param p2 - end point by uncounter clockwise
     * @param rc coordinates of point of radius
     * @return
     */
    public Matrix2dBoolean drawArc(Point2d p1, Point2d p2, Point2d rc){
        int angleStart = (int)Line2d.getAngle(rc, p1);
        int angleEnd = (int)Line2d.getAngle(rc, p2);
        double r = Line2d.getLength(rc, p1);
        this.drawArc(rc, r, angleStart, angleEnd);
        return this;
    }


    // TODO:
    /**
     * draw arc
     * @param p1 - start point by uncounter clockwise
     * @param pc - coordinates of point of center of circle
     * @param angle - angle circle sector
     * @return
     */
    public Matrix2dBoolean drawArc(Point2d pc, Point2d p1, int angle){

        return this;
    }



    /**
     * count number for pattern 3x3
     * j = 1; j < sizeY-1;
     * i = 1; i < sizeX-1;
    */
    private int count3x3Pattern(int i, int j){
        int v1, v2, v3, v4, v5, v6, v7, v8, v9, n;
        v1 = (this.getValue(i, j) == true ? 1 : 0);
        v2 = (this.getValue(i, j - 1) == true ? 1 : 0);
        v3 = (this.getValue(i + 1, j - 1) == true ? 1 : 0);
        v4 = (this.getValue(i + 1, j) == true ? 1 : 0);
        v5 = (this.getValue(i + 1, j + 1) == true ? 1 : 0);
        v6 = (this.getValue(i, j + 1) == true ? 1 : 0);
        v7 = (this.getValue(i - 1, j + 1) == true ? 1 : 0);
        v8 = (this.getValue(i - 1, j) == true ? 1 : 0);
        v9 = (this.getValue(i - 1, j - 1) == true ? 1 : 0);
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
            for (int j = 1; j < sizeY - 1; j++) {
                for (int i = 1; i < sizeX - 1; i++) {
                    if (m2d.getValue(i, j) == oldValue ){
                        v2 = (m2d.getValue(i, j - 1) == true ? 1 : 0);
                        v3 = (m2d.getValue(i + 1, j - 1) == true ? 1 : 0);
                        v4 = (m2d.getValue(i + 1, j) == true ? 1 : 0);
                        v5 = (m2d.getValue(i + 1, j + 1) == true ? 1 : 0);
                        v6 = (m2d.getValue(i, j + 1) == true ? 1 : 0);
                        v7 = (m2d.getValue(i - 1, j + 1) == true ? 1 : 0);
                        v8 = (m2d.getValue(i - 1, j) == true ? 1 : 0);
                        v9 = (m2d.getValue(i - 1, j - 1) == true ? 1 : 0);
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

    /**
     * convert Matrix2dBoolean binary mask into Matrix2dGraph
     * @return
     */
    public Matrix2dGraph toGraph() {
        int sizeX = this.sizeX;
        int sizeY = this.sizeY;
        Graph g1, g2, g3, g4, g5, g6, g7, g8, g9;
        Matrix2dGraph m2d = new Matrix2dGraph(sizeX, sizeY);
        for (int j = 1; j < sizeY-1; j++) {
            for (int i = 1; i < sizeX-1; i++) {
                if(this.getValue(i, j)==true) m2d.setValue(i, j, new Graph( new Point2d(i, j)));
            }
        }
        for (int j = 1; j < sizeY-1; j++) {
            for (int i = 1; i < sizeX-1; i++) {
                g1 = m2d.getValue(i, j);
                if(g1 != null ) {
                    g2 = m2d.getValue(i, j - 1);
                    g3 = m2d.getValue(i + 1, j - 1);
                    g4 = m2d.getValue(i + 1, j);
                    g5 = m2d.getValue(i + 1, j + 1);
                    g6 = m2d.getValue(i, j + 1);
                    g7 = m2d.getValue(i - 1, j + 1);
                    g8 = m2d.getValue(i - 1, j);
                    g9 = m2d.getValue(i - 1, j - 1);
                    if (g2 != null) {
                        if (!g1.getPoints().contains(g2)) {
                            g1.getPoints().add(g2);
                            g2.getPoints().add(g1);
                        }
                    }
                    if (g3 != null) {
                        if (!g1.getPoints().contains(g3)) {
                            g1.getPoints().add(g3);
                            g3.getPoints().add(g1);
                        }
                    }
                    if (g4 != null) {
                        if (!g1.getPoints().contains(g4)) {
                            g1.getPoints().add(g4);
                            g4.getPoints().add(g1);
                        }
                    }
                    if (g5 != null) {
                        if (!g1.getPoints().contains(g5)) {
                            g1.getPoints().add(g5);
                            g5.getPoints().add(g1);
                        }
                    }
                    if (g6 != null) {
                        if (!g1.getPoints().contains(g6)) {
                            g1.getPoints().add(g6);
                            g6.getPoints().add(g1);
                        }
                    }
                    if (g7 != null) {
                        if (!g1.getPoints().contains(g7)) {
                            g1.getPoints().add(g7);
                            g7.getPoints().add(g1);
                        }
                    }
                    if (g8 != null) {
                        if (!g1.getPoints().contains(g8)) {
                            g1.getPoints().add(g8);
                            g8.getPoints().add(g1);
                        }
                    }
                    if (g9 != null) {
                        if (!g1.getPoints().contains(g9)) {
                            g1.getPoints().add(g9);
                            g9.getPoints().add(g1);
                        }
                    }
                }
            }
        }
        return m2d;
    }

    @Deprecated
    /**
     * count center of weight
     * @return
     */
    public Point2d countCenterOfSymmetry(){
        int x, y;
        int n = 0;
        int cx = 0;
        int cy = 0;
        y = this.sizeY;
        x = this.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                if( this.getValue(i, j)==true){
                    n +=1;
                    cx += i;
                    cy += j;
                }
            }
        }
        if(n>0) {
            cx /= n;
            cy /= n;
        }
        return new Point2d(cx, cy);
    }

    @Deprecated
    /**
     * remember in calculation used X axis from left to right and y axis from top to bottom
     * count angle of main axis of symmetry
     * @return
     */
    public int countAngleAxisOfSymmetry(Point2d center){
        int x, y;
        int n = 0;
        int cx = center.x;
        int cy = center.y;
        int dx = 0, dy = 0;
        int angle = 0;
        int a;
        y = this.sizeY;
        x = this.sizeX;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                if( this.getValue(i, j)==true){
//                    if((i-cx)==0 ){
//                        n +=1;
//                        angle +=90;
//                    }
//                    else{
//                        n +=1;
//                        // cy-j because of picture non standart y-axis
//                        a = (int) Math.round( Math.atan2((j-cy),(i-cx))*180/Math.PI );
//                        if(a<0){ a+=360; }
//                        if(a> 180){ a-=180;}
//                        angle += a ;
//                    }
//                }
//            }
//        }
//        if(n>0) {
//            angle /= n;
//
//        }

        for(int j = 0; j<y; j++) {
            for (int i = 0; i < x; i++) {
                if (this.getValue(i, j) == true) {
                    dx += (i - cx);
                    dy += (j - cy);
                }
            }
        }
        if(dx==0){
            angle =90;
        }else{
            a = (int) Math.round( Math.atan2(dy,dx)*180/Math.PI );
            if(a<0){ a+=360; }
            if(a> 180){ a-=180;}
            angle = a;
        }

        return angle;
    }


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

    public static float compareRotation(Matrix2dBoolean etalon, Matrix2dBoolean input){
        float diff = 0;


        return diff;
    }

    public static float compareRatio(Matrix2dBoolean etalon, Matrix2dBoolean input){
        float diff = 0;


        return diff;
    }

    // TODO:
    public static double compareLines(double x1, double y1, double x2, double y2) {
        double dist = 0;
        return dist;
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


}