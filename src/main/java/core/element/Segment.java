package core.element;

import core.converter.Converter;
import core.converter.ElementConverter;
import core.exceptions.FileException;
import core.matrix.Matrix2dArgb;
import core.matrix.Matrix2dBoolean;
import core.matrix.Matrix2dByte;
import core.matrix.Matrix2dInt;
import core.old.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 13.05.2018.
 */
public class Segment {
    public static int countId = 0;
    public int id; // unique segment number
    public Matrix2dByte mainM2d = null;
    public Segment parentSegment = null;
    public ArrayList<Segment> childSegments = new ArrayList<Segment>();
    public ArrayList<Point2dByte> points = new ArrayList<Point2dByte>();
    public ArrayList<Line2dByte> lines = new ArrayList<Line2dByte>();
    public int shiftX = 0;
    public int shiftY = 0;
    public int width = 0;
    public int high = 0;

    public int borderSize = 0;
    public int shapeSize = 0;
    public int innerSize = 0;

    public byte middleValue = 0;

    public Segment() {
        this.id = countId;
        Segment.countId+=1;
        this.parentSegment = null; // it means that is rootSegment
    }

    public Segment(Segment parentSegment) {
        this.id = countId;
        Segment.countId+=1;
        this.parentSegment = parentSegment;
    }


    public Segment addChildSegment(Segment childSegment){
        childSegment.parentSegment = this;
        this.childSegments.add(childSegment);
        return this;
    }

    // TODO: find out how remove this in parameter
    public Segment reduceNoise(Matrix2dByte baseM2d){
        this.countShiftAndSize();
        int x, y;
        byte value;
        y = this.high;
        x = this.width;
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.width, this.high);
        for (Point2dByte p: this.points ) {
            m2d.setValue(p.x-this.shiftX, p.y-this.shiftY, true);
        }
        Matrix2dBoolean m2d1 = m2d./*getFilledShape().*/removeNoise();
        this.points = new ArrayList<Point2dByte>();
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++) {
                if(m2d1.getValue(i, j) == true) {
                    value = baseM2d.getValue(i + this.shiftX, j + this.shiftY);
                    this.points.add(new Point2dByte(i + this.shiftX, j + this.shiftY, value));
                }
            }
        }
        return this;
    }

    private Segment countMiddleValue(){
        int value = 0;
        int n = 0;
        for (Point2dByte p: points) {
            if(p.value !=-128) {
                value += p.value;
                n+=1;
            }
        }
        if(n == 0) value = 0;
        else value = value/n;
        // Correct result to byte value [-128..+127]
        byte result;
        if(value>127){ result = 127;}
        else if(value<-128){ result = -128;}
        else{ result = (byte)(value); }
        this.middleValue = result;
        return this;
    }

    /**
     * shift is like if minX value = 3 then shiftX = 3
     * shift is like if minY value = 5 then shiftY = 5
     * @return
     */
    public Segment countShiftAndSize(){
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
        this.shiftX = l;
        this.shiftY = u;
        this.width = r - l + 1;
        this.high = d - u + 1;
        return this;
    }

    public Segment shiftPoints() {
        this.countShiftAndSize();
        for (Point2dByte p: this.points) {
            p.x = p.x-this.shiftX;
            p.y = p.y-this.shiftY;
        }
        this.shiftX = 0;
        this.shiftY = 0;
        return this;
    }

    /**
     * have to divide by middle value onto two segments
     * @param segment
     * @return
     */
    public static ArrayList<Segment> segmentateByMiddleValue(Segment segment) {
        ArrayList<Segment> result = new ArrayList<Segment>();
        // Find sub segments by middle Value
        Segment segLow = new Segment();
        Segment segHigh = new Segment();
        ArrayList<Point2dByte> pointsLow = segLow.points;
        ArrayList<Point2dByte> pointsHigh = segHigh.points;
        for (Point2dByte p: segment.points) {
            if(p.value <= segment.middleValue){pointsLow.add(p);}
            else{pointsHigh.add(p);}
        }
        segLow.mainM2d = segment.mainM2d;
        segHigh.mainM2d = segment.mainM2d;
        result.add(segLow);
        result.add(segHigh);
        return result;
    }

    /**
     * count All separated segments
     * @param segment
     * @return
     */
    public static ArrayList<Segment> segmentateBySeparatedArea(Segment segment){
        ArrayList<Segment> result = new ArrayList<Segment>();
        int sizeMaxX = 0, sizeMaxY = 0;
        for (Point2dByte p: segment.points) {
            if (p.x > sizeMaxX) sizeMaxX = p.x;
            if (p.y > sizeMaxY) sizeMaxY = p.y;
        }
        Matrix2dInt tSegmentsIds = new Matrix2dInt(sizeMaxX, sizeMaxY);
        HashMap<Integer, Segment> tSegments = new HashMap<Integer, Segment>();
        Integer currId;
        HashSet<Integer> tIds;
        for (Point2dByte tP: segment.points) {
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
        for(Segment s: tSegments.values()){
            s.mainM2d = segment.mainM2d;
        }
        result.addAll(tSegments.values());
        return result;
    }

    /**
     * segmentate base segment to all separated segments and create tree segments
     * @param minDiff
     * @return
     */
    public Segment segmentate(int minDiff){
        this.countShiftAndSize().countMiddleValue();
        Matrix2dByte m2d = this.mainM2d; //new Matrix2dByte(this.width, this.high, (byte)-128);
//        for (Point2dByte p: this.points) {
//            m2d.setValue(p.x-this.shiftX, p.y-this.shiftY, p.value);
//        }
        ArrayList<Segment> segments = Segment.segmentateByMiddleValue(this);
        Segment lowSeg = segments.get(0);
        Segment highSeg = segments.get(1);
        ArrayList<Segment> lowSegments = Segment.segmentateBySeparatedArea(lowSeg);
        ArrayList<Segment> highSegments = Segment.segmentateBySeparatedArea(highSeg);
        for (Segment seg: lowSegments) {
            seg.reduceNoise(m2d).countMiddleValue();
            this.addChildSegment(seg);
        }
        for (Segment seg: highSegments) {
            seg.reduceNoise(m2d).countMiddleValue();
            this.addChildSegment(seg);
        }
//        for (Segment s: this.childSegments) {
//            if( s.points.size()>minDiff/*Math.abs(s.middleValue - this.middleValue)>minDiff*/ ){
//                s.segmentate(minDiff);
//            }
//        }
        return this;
    }



    /**
     * save as data-file
     * @param urlFile
     * @return
     */
    public Segment save(String urlFile) {
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream(urlFile));
        } catch (FileNotFoundException e) {
            throw new FileException("Can't find file", e);
        }
        for (Point2dByte p: this.points) {
            try {
                out.writeInt(p.x);
                out.writeInt(p.y);
                out.writeByte(p.value);
            } catch (IOException e) {
                throw new FileException("Can't write to file", e);
            }
        }
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new FileException("Can't flush and close file", e);
        }
        return this;
    }

    /**
     * load as data-file
     * @param urlFile
     * @return
     */
    public static Segment load(String urlFile) {
        Segment segment = new Segment();
        int x, y;
        byte value;
        DataInputStream in;
        try {
            in = new DataInputStream(new FileInputStream(urlFile));
        } catch (FileNotFoundException e) {
            throw new FileException("Can't find file", e);
        }
        try {
            while (in.available() > 0) {
                x = in.readInt();
                y = in.readInt();
                value = in.readByte();
                segment.points.add(new Point2dByte(x, y, value));
            }
            in.close();
        }
        catch (IOException e) {
            throw new FileException("Can't read and close file", e);
        }
        return segment;
    }

    public Segment saveAs2dArgbImage(Matrix2dArgb mainM2d, String urlFile, String format){
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
        ARGB v;
        for(Point2dByte p : points) {
            v = mainM2d.getValue(p.x, p.y);
            image.setRGB(  p.x - l, p.y - u, ElementConverter.argbToInt(v) );
        }
        // 4. Save
        try {
            ImageIO.write(image, format, new File(urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write segment to image file", e);
        }
        return this;
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
            if(p.value ==-128) image.setRGB(  p.x - l, p.y - u, 0x00000000 );
            else image.setRGB(  p.x - l, p.y - u, 0xffffffff );
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
    public static ArrayList<Segment> removeSegmentsByMinNumberOfPoints(int min, ArrayList<Segment> segments){
        ArrayList<Segment> toRemove = new ArrayList<Segment>();
        for (Segment seg: segments) {
            if(seg.points.size() <= min){ toRemove.add(seg);}
        }
        for (Segment seg: toRemove) {
            segments.remove(seg);
        }
        return segments;
    }



    /**
     * if number point in subsegment less then "min" - remove this subsegment
     * @param min
     */
    public void removeSegmentsByMinNumberOfPoints(int min){
        ArrayList<Segment> toRemove = new ArrayList<Segment>();
        for (Segment seg: this.childSegments) {
            if(seg.points.size()<min){ toRemove.add(seg);}
        }
        for (Segment seg: toRemove) {
            this.childSegments.remove(seg);
        }
    }

//    /**
//     * // p9 p2 p3
//     * // p8 p1 p4
//     * // p7 p6 p5
//     * before use that method, list of points must be normalized
//     */
//    public Matrix2dBoolean countLines(){
//        // binarize
//        int x, y;
//        y = this.high;
//        x = this.width;
//        int sum;
//        int v1, v2, v3, v4, v5, v6, v7, v8, v9;
//        Matrix2dBoolean m2d = new Matrix2dBoolean(this.width, this.high);
//        for (Point2dByte p: this.points ) {
//            m2d.setValue(p.x, p.y, true);
//        }
//        Matrix2dBoolean m2d1 = new Matrix2dBoolean(this.width, this.high);
//        Matrix2dBoolean m2d2 = new Matrix2dBoolean(this.width, this.high);
//        // left only edges
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                if(m2d.getValue(i, j) == true){
//                    v2 = (m2d.getValue(i, j - 1) == true ? 1 : 0);
//                    v3 = (m2d.getValue(i + 1, j - 1) == true ? 1 : 0);
//                    v4 = (m2d.getValue(i + 1, j) == true ? 1 : 0);
//                    v5 = (m2d.getValue(i + 1, j + 1) == true ? 1 : 0);
//                    v6 = (m2d.getValue(i, j + 1) == true ? 1 : 0);
//                    v7 = (m2d.getValue(i - 1, j + 1) == true ? 1 : 0);
//                    v8 = (m2d.getValue(i - 1, j) == true ? 1 : 0);
//                    v9 = (m2d.getValue(i - 1, j - 1) == true ? 1 : 0);
//                    sum = v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9;
//                    if (sum <=7) {
//                        m2d1.setValue(i,j, true);
//                    }
//                }
//            }
//        }
//        // fill empty closed places
//        return m2d1.getFilledShape();

//        // second step
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++) {
//                m2d2.setValue(i, j, m2d1.getValue(i, j) );
//            }
//        }
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++) {
//                v1 = (m2d1.getValue(i, j) == true ? 1 : 0);
//                v2 = (m2d1.getValue(i, j - 1) == true ? 1 : 0);
//                v3 = (m2d1.getValue(i + 1, j - 1) == true ? 1 : 0);
//                v4 = (m2d1.getValue(i + 1, j) == true ? 1 : 0);
//                sum = v1 + v2 + v3 + v4;
//                if(sum == 4){
//                    v1 = (m2d1.getValue(i-1, j) == true ? 1 : 0);
//                    v2 = (m2d1.getValue(i-1, j - 1) == true ? 1 : 0);
//                    v3 = (m2d1.getValue(i, j - 1) == true ? 1 : 0);
//                    v4 = (m2d1.getValue(i, j + 2) == true ? 1 : 0);
//                    v5 = (m2d1.getValue(i + 2, j) == true ? 1 : 0);
//                    if(v1 == 0 && v2 == 0 && v3 == 0 && v4 == 0 && v5 == 0){ m2d2.setValue(i,j, false); }
//
//                    v1 = (m2d1.getValue(i+1, j-1) == true ? 1 : 0);
//                    v2 = (m2d1.getValue(i+2, j - 1) == true ? 1 : 0);
//                    v3 = (m2d1.getValue(i+2, j) == true ? 1 : 0);
//                    v4 = (m2d1.getValue(i-1, j) == true ? 1 : 0);
//                    v5 = (m2d1.getValue(i + 1, j+2) == true ? 1 : 0);
//                    if(v1 == 0 && v2 == 0 && v3 == 0 && v4 == 0 && v5 == 0){ m2d2.setValue(i,j, false); }
//
//                    v1 = (m2d1.getValue(i+2, j+1) == true ? 1 : 0);
//                    v2 = (m2d1.getValue(i+2, j+2) == true ? 1 : 0);
//                    v3 = (m2d1.getValue(i+1, j+2) == true ? 1 : 0);
//                    v4 = (m2d1.getValue(i+1, j-1) == true ? 1 : 0);
//                    v5 = (m2d1.getValue(i-1, j+1) == true ? 1 : 0);
//                    if(v1 == 0 && v2 == 0 && v3 == 0 && v4 == 0 && v5 == 0){ m2d2.setValue(i,j, false); }
//
//                    v1 = (m2d1.getValue(i-1, j+1) == true ? 1 : 0);
//                    v2 = (m2d1.getValue(i-1, j+2) == true ? 1 : 0);
//                    v3 = (m2d1.getValue(i, j+2) == true ? 1 : 0);
//                    v4 = (m2d1.getValue(i, j-1) == true ? 1 : 0);
//                    v5 = (m2d1.getValue(i+2, j+1) == true ? 1 : 0);
//                    if(v1 == 0 && v2 == 0 && v3 == 0 && v4 == 0 && v5 == 0){ m2d2.setValue(i,j, false); }
//                }
//            }
//        }
//        return m2d2;
//    }

    // countDiffMinMaxValue
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

    // TODO: remove
    //    /**
//     * unshift is like if shiftX value = 3 then p.x += 3
//     * unshift is like if shiftY value = 5 then p.y += 5
//     * @return
//     */
//    private Segment unshiftPoints(){
//        for(Point2dByte p : points) {
//            p.x = p.x + this.shiftX;
//            p.y = p.y + this.shiftY;
//        }
//        this.shiftX = 0;
//        this.shiftY = 0;
//        this.width = 0;
//        this.high = 0;
//        this.isShifted = false;
//        return this;
//    }

}
