package core.old;


import core.application.dataElement.AbstractElement;

import java.util.ArrayList;

// TODO: remove later
/**
 * Created by anonymous on 13.05.2018.
 */
public class Segment extends AbstractElement {




//    protected Curve mergeCurves(Curve c1, Curve c2){
//
//        double c1Angle = c1.getAngle();
//        double c2Angle = c2.getAngle();
//
//
//        int minX, maxX, minY, maxY;
//        if( this.comparePoints(c1.p1, c2.p1)<=1 && curve.findAngle(c1.p2, )){
//            c = new Curve(new Point(c1.p2.x, c1.p2.y, 0,0,0),
//                    new Point(c2.p2.x, c2.p2.y, 0,0,0), null);
//        }else if(this.comparePoints(c1.p2, c2.p2)<=1){
//            c = new Curve(new Point(c1.p1.x, c1.p1.y, 0,0,0),
//                    new Point(c2.p1.x, c2.p1.y, 0,0,0), null);
//        }else if(this.comparePoints(c1.p1, c2.p2)<=1){
//            c = new Curve(new Point(c1.p2.x, c1.p2.y, 0,0,0),
//                    new Point(c2.p1.x, c2.p1.y, 0,0,0), null);
//        }else if(this.comparePoints(c1.p2, c2.p1)<=1){
//            c = new Curve(new Point(c1.p1.x, c1.p1.y, 0,0,0),
//                    new Point(c2.p2.x, c2.p2.y, 0,0,0), null);
//        }
//        return c;
//    }

//    /**
//     * have to divide by middle value onto two segments
//     * @param segment
//     * @return
//     */
//    public static ArrayList<Segment> segmentateByMiddleValue(Segment segment) {
//        ArrayList<Segment> result = new ArrayList<Segment>();
//        // Find sub segments by middle Value
//        Segment segLow = new Segment();
//        Segment segHigh = new Segment();
//        ArrayList<Point2dByte> pointsLow = segLow.points;
//        ArrayList<Point2dByte> pointsHigh = segHigh.points;
//        for (Point2dByte p: segment.points) {
//            if(p.value <= segment.middleValue){pointsLow.add(p);}
//            else{pointsHigh.add(p);}
//        }
//        segLow.mainM2d = segment.mainM2d;
//        segHigh.mainM2d = segment.mainM2d;
//        result.add(segLow);
//        result.add(segHigh);
//        return result;
//    }

//    /**
//     * count All separated segments
//     * @param segment
//     * @return
//     */
//    public static ArrayList<Segment> segmentateBySeparatedArea(Segment segment){
//        ArrayList<Segment> result = new ArrayList<Segment>();
//        int sizeMaxX = 0, sizeMaxY = 0;
//        for (Point2dByte p: segment.points) {
//            if (p.x > sizeMaxX) sizeMaxX = p.x;
//            if (p.y > sizeMaxY) sizeMaxY = p.y;
//        }
//        Matrix2dInt tSegmentsIds = new Matrix2dInt(sizeMaxX, sizeMaxY);
//        HashMap<Integer, Segment> tSegments = new HashMap<Integer, Segment>();
//        Integer currId;
//        HashSet<Integer> tIds;
//        for (Point2dByte tP: segment.points) {
//            tIds = new HashSet<Integer>();
//            currId = tSegmentsIds.getValue(tP.x-1, tP.y-1);
//            if(currId!=null){ tIds.add(currId); }
//            currId = tSegmentsIds.getValue(tP.x, tP.y-1);
//            if(currId!=null){ tIds.add(currId); }
//            currId = tSegmentsIds.getValue(tP.x+1, tP.y-1);
//            if(currId!=null){ tIds.add(currId); }
//            currId = tSegmentsIds.getValue(tP.x-1, tP.y);
//            if(currId!=null){ tIds.add(currId); }
//            currId = tSegmentsIds.getValue(tP.x+1, tP.y);
//            if(currId!=null){ tIds.add(currId); }
//            currId = tSegmentsIds.getValue(tP.x-1, tP.y+1);
//            if(currId!=null){ tIds.add(currId); }
//            currId = tSegmentsIds.getValue(tP.x, tP.y+1);
//            if(currId!=null){ tIds.add(currId); }
//            currId = tSegmentsIds.getValue(tP.x+1, tP.y+1);
//            if(currId!=null){ tIds.add(currId); }
//
//            if(tIds.size()==0){
//                Segment tSeg = new Segment();
//                tSeg.points.add(tP);
//                tSegments.put(tSeg.id, tSeg);
//                tSegmentsIds.setValue(tP.x, tP.y, tSeg.id);
//            }else if(tIds.size()==1){
//                Segment tSeg = tSegments.get(tIds.iterator().next());
//                tSeg.points.add(tP);
//                tSegmentsIds.setValue(tP.x, tP.y, tSeg.id);
//            }else{
//                Segment tSeg = new Segment();
//                ArrayList<Point2dByte> tSegPoints = tSeg.points;
//                for(Integer tId: tIds){
//                    Segment tempSeg = tSegments.get(tId);
//                    ArrayList<Point2dByte> tempSegPoints = tempSeg.points;
//                    for (Point2dByte tempP: tempSegPoints){
//                        tSegmentsIds.setValue(tempP.x, tempP.y, tSeg.id);
//                        tSegPoints.add(tempP);
//                    }
//                    tSegments.remove(tId);
//                }
//                tSegments.put(tSeg.id, tSeg);
//            }
//        }
//        for(Segment s: tSegments.values()){
//            s.mainM2d = segment.mainM2d;
//        }
//        result.addAll(tSegments.values());
//        return result;
//    }

//    /**
//     * segmentate base segment to all separated segments and create tree segments
//     * @param minDiff
//     * @return
//     */
//    public Segment segmentate(int minDiff){
//        this.countShiftAndSize().countMiddleValue();
//        Matrix2dByte m2d = this.mainM2d; //new Matrix2dByte(this.width, this.high, (byte)-128);
////        for (Point2dByte p: this.points) {
////            m2d.setValue(p.x-this.shiftX, p.y-this.shiftY, p.value);
////        }
//        ArrayList<Segment> segments = Segment.segmentateByMiddleValue(this);
//        Segment lowSeg = segments.get(0);
//        Segment highSeg = segments.get(1);
//        ArrayList<Segment> lowSegments = Segment.segmentateBySeparatedArea(lowSeg);
//        ArrayList<Segment> highSegments = Segment.segmentateBySeparatedArea(highSeg);
//        for (Segment seg: lowSegments) {
//            seg.reduceNoise(m2d).countMiddleValue();
//            this.addChildSegment(seg);
//        }
//        for (Segment seg: highSegments) {
//            seg.reduceNoise(m2d).countMiddleValue();
//            this.addChildSegment(seg);
//        }
////        for (Segment s: this.childSegments) {
////            if( s.points.size()>minDiff/*Math.abs(s.middleValue - this.middleValue)>minDiff*/ ){
////                s.segmentate(minDiff);
////            }
////        }
//        return this;
//    }


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


}
