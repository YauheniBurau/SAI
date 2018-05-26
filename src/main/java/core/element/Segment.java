package core.element;

import core.converter.Converter;
import core.exceptions.FileException;
import core.matrix.Matrix2dBoolean;
import core.matrix.Matrix2dInt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 13.05.2018.
 */
public class Segment {
    public static int countId = 0;
    public ArrayList<Point2dByte> points = new ArrayList<Point2dByte>();
    public ArrayList<Line2dByte> lines = new ArrayList<Line2dByte>();

    public ArrayList<Segment> segments = new ArrayList<Segment>();
    public int id; // unique segment number
    public int shiftX = 0;
    public int shiftY = 0;
    public int width = 0;
    public int high = 0;
    public boolean isShifted = false;

    public Segment() {
        this.id = countId;
        Segment.countId+=1;
    }

    private byte countMiddleValue(){
    // Variant 1
    //        int value;
    //        int minValue = 127, maxValue = -128;
    //        for (Point2dByte p: points) {
    //            value = p.getValue();
    //            if( value > maxValue) maxValue = value;
    //            if( value < minValue) minValue = value;
    //        }
    //        value = minValue + (maxValue - minValue)/2;
    // Variant 2
        int value = 0;
        for (Point2dByte p: points) {
            value += p.value;
        }
        value = value/points.size();
    // Correct result to byte value [-128..+127]
        byte result = 0;
        if(value>127){ result = 127;}
        else if(value<-128){ result = -128;}
        else{ result = (byte)(value); }
        return result;
    }

    /**
     * shift is like if minX value = 3 then shiftX = 3
     * shift is like if minY value = 5 then shiftY = 5
     * @return
     */
    public Segment normalizeShiftPoints(){
        // 1. find shift by x and y
        if(points.size()==0) return this;
        int l = Integer.MAX_VALUE;
        int u = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;
        for(Point2dByte p : points){
            if( p.x < l ) l = p.x;
            if( p.y < u ) u = p.y;
            if( p.x > r ) r = p.x;
            if( p.y > d ) d = p.y;
        }
        // 2. shift all point to left up corner
        for(Point2dByte p : points) {
            p.x = p.x - l;
            p.y = p.y - u;
        }
        this.shiftX = l;
        this.shiftY = u;
        this.width = r - l + 1;
        this.high = d - u + 1;
        this.isShifted = true;
        return this;
    }

    /**
     * unshift is like if shiftX value = 3 then p.x += 3
     * unshift is like if shiftY value = 5 then p.y += 5
     * @return
     */
    public Segment normalizeUnshiftPoints(){
        for(Point2dByte p : points) {
            p.x = p.x + this.shiftX;
            p.y = p.y + this.shiftY;
        }
        this.shiftX = 0;
        this.shiftY = 0;
        this.width = 0;
        this.high = 0;
        this.isShifted = false;
        return this;
    }


    /**
     * have to divide by middle value onto two segments and also find all separated segments
     */
    public void countSubSegmentsByMiddleValue(){
        // Find sub segments by middle Value
        Segment segLow = new Segment();
        Segment segHigh = new Segment();
        ArrayList<Point2dByte> pointsLow = segLow.points;
        ArrayList<Point2dByte> pointsHigh = segHigh.points;
        byte middleValue = this.countMiddleValue();
        for (Point2dByte p: this.points) {
            if(p.value <= middleValue){pointsLow.add(p);}
            else{pointsHigh.add(p);}
        }
        this.segments.add(segLow);
        this.segments.add(segHigh);
    }

    /**
     * count All separated segments
     * @return
     */
    public void countSeparatedSubSegments(){
        int sizeMaxX = 0, sizeMaxY = 0;
        for (Point2dByte p: this.points) {
            if (p.x > sizeMaxX) sizeMaxX = p.x;
            if (p.y > sizeMaxY) sizeMaxY = p.y;
        }
        Matrix2dInt tSegmentsIds = new Matrix2dInt(sizeMaxX, sizeMaxY);
        HashMap<Integer, Segment> tSegments = new HashMap<Integer, Segment>();
        Integer currId;
        HashSet<Integer> tIds;
        for (Point2dByte tP: this.points) {
            tIds = new HashSet<Integer>();
            currId = tSegmentsIds.getValue(tP.x-1, tP.y-1);
            if(currId!=null){ tIds.add(currId); }
            currId = tSegmentsIds.getValue(tP.x, tP.y-1);
            if(currId!=null){ tIds.add(currId); }
            currId = tSegmentsIds.getValue(tP.x+1, tP.y-1);
            if(currId!=null){ tIds.add(currId); }
            currId = tSegmentsIds.getValue(tP.x-1, tP.y);
            if(currId!=null){ tIds.add(currId); }
            currId = tSegmentsIds.getValue(tP.x+1, tP.y);
            if(currId!=null){ tIds.add(currId); }
            currId = tSegmentsIds.getValue(tP.x-1, tP.y+1);
            if(currId!=null){ tIds.add(currId); }
            currId = tSegmentsIds.getValue(tP.x, tP.y+1);
            if(currId!=null){ tIds.add(currId); }
            currId = tSegmentsIds.getValue(tP.x+1, tP.y+1);
            if(currId!=null){ tIds.add(currId); }

            if(tIds.size()==0){
                Segment tSeg = new Segment();
                tSeg.points.add(tP);
                tSegments.put(tSeg.id, tSeg);
                tSegmentsIds.setValue(tP.x, tP.y, tSeg.id);
            }else if(tIds.size()==1){
                Segment tSeg = tSegments.get(tIds.iterator().next());
                tSeg.points.add(tP);
                tSegmentsIds.setValue(tP.x, tP.y, tSeg.id);
            }else{
                Segment tSeg = new Segment();
                ArrayList<Point2dByte> tSegPoints = tSeg.points;
                for(Integer tId: tIds){
                    Segment tempSeg = tSegments.get(tId);
                    ArrayList<Point2dByte> tempSegPoints = tempSeg.points;
                    for (Point2dByte tempP: tempSegPoints){
                        tSegmentsIds.setValue(tempP.x, tempP.y, tSeg.id);
                        tSegPoints.add(tempP);
                    }
                    tSegments.remove(tId);
                }
                tSegments.put(tSeg.id, tSeg);
            }
        }
        this.segments.addAll(tSegments.values());
    }


    public Segment saveAs2dArgbImage(String urlFile, String format){
        // 1. find shift by x and y
        if(points.size()==0) return this;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int u = Integer.MAX_VALUE;
        int d = Integer.MIN_VALUE;
        for(Point2dByte p : points){
            if( p.x < l ) l = p.x;
            if( p.x > r ) r = p.x;
            if( p.y < u ) u = p.y;
            if( p.y > d ) d = p.y;
        }
        int width = r - l + 1;
        int high = d - u + 1;
        // 2.create image
        BufferedImage image;
        int x, y;
        image = new BufferedImage(width, high, TYPE_INT_ARGB);
        y = high;
        x = width;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, 0x00000000 );
            }
        }
        // 3. add points with shift to Image
        for(Point2dByte p : points) {
            image.setRGB(  p.x - l, p.y - u, Converter.byteToArgbInt(p.value) );
        }
        // 4. Save
        try {
            ImageIO.write(image, format, new File(urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write segment to image file", e);
        }
        return this;
    }

    public Segment saveAs2dBooleanImage(String urlFile, String format){
        // 1. find shift by x and y
        if(points.size()==0) return this;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int u = Integer.MAX_VALUE;
        int d = Integer.MIN_VALUE;
        for(Point2dByte p : points){
            if( p.x < l ) l = p.x;
            if( p.x > r ) r = p.x;
            if( p.y < u ) u = p.y;
            if( p.y > d ) d = p.y;
        }
        int width = r - l + 1;
        int high = d - u + 1;
        // 2.create image
        BufferedImage image;
        int x, y;
        image = new BufferedImage(width, high, TYPE_INT_ARGB);
        y = high;
        x = width;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, 0x00000000 );
            }
        }
        // 3. add points with shift to Image
        for(Point2dByte p : points) {
            image.setRGB(  p.x - l, p.y - u, 0xffffffff );
        }
        // 4. Save
        try {
            ImageIO.write(image, format, new File(urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write segment to image file", e);
        }
        return this;
    }

    /**
     * if number point in subsegment less then "min" - remove this subsegment
     * @param min
     */
    public void removeSegmentsByMinNumberOfPoints(int min){
        ArrayList<Segment> toRemove = new ArrayList<Segment>();
        for (Segment seg: this.segments) {
            if(seg.points.size()<min){ toRemove.add(seg);}
        }
        for (Segment seg: toRemove) {
            this.segments.remove(seg);
        }
    }

    /**
     * // p9 p2 p3
     * // p8 p1 p4
     * // p7 p6 p5
     * before use that method, list of points must be normalized
     */
    public Matrix2dBoolean countLines(){
        // binarize
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.width, this.high);
        Matrix2dBoolean m2dResult = new Matrix2dBoolean(this.width, this.high);
        for (Point2dByte p: this.points ) {
            m2d.setValue(p.x, p.y, true);
        }
        // left only edges
        int x, y;
        y = this.high;
        x = this.width;
        int sum;
        int v2, v3, v4, v5, v6, v7, v8, v9;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                if(m2d.getValue(i, j) == true){
                    v2 = (m2d.getValue(i, j - 1) == true ? 1 : 0);
                    v3 = (m2d.getValue(i + 1, j - 1) == true ? 1 : 0);
                    v4 = (m2d.getValue(i + 1, j) == true ? 1 : 0);
                    v5 = (m2d.getValue(i + 1, j + 1) == true ? 1 : 0);
                    v6 = (m2d.getValue(i, j + 1) == true ? 1 : 0);
                    v7 = (m2d.getValue(i - 1, j + 1) == true ? 1 : 0);
                    v8 = (m2d.getValue(i - 1, j) == true ? 1 : 0);
                    v9 = (m2d.getValue(i - 1, j - 1) == true ? 1 : 0);
                    sum = v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9;
                    if (sum <=7) {
                        m2dResult.setValue(i,j, true);
                    }
                }
            }
        }
        return m2dResult;
    }


}
