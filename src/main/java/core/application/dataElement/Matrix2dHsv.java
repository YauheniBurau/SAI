package core.application.dataElement;

import core.application.dataElement.color.HSV;
import core.application.dataElement.points.Point2d;
import core.old.Point;

import java.util.ArrayList;

/**
 * Created by anonymous on 06.10.2017.
 */
public class Matrix2dHsv extends AbstractElement {
    private HSV[][] matrix;
    public final int sizeX;
    public final int sizeY;

    public Matrix2dHsv(int xSize, int ySize, HSV defaultValue) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new HSV[ySize][xSize];
        for(int j = 0; j<=this.sizeY-1; j++){
            for(int i = 0; i<=this.sizeX-1; i++){
                this.setValue(i, j, defaultValue);
            }
        }
    }

    public Matrix2dHsv(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new HSV[ySize][xSize];
        for(int j = 0; j<=this.sizeY-1; j++){
            for(int i = 0; i<=this.sizeX-1; i++){
                this.setValue(i, j, null);
            }
        }
    }

    public Matrix2dHsv(Matrix2dHsv m2d) {
        HSV hsv;
        this.sizeX = m2d.sizeX;
        this.sizeY = m2d.sizeY;
        this.matrix = new HSV[this.sizeY][this.sizeX];
        for(int j = 0; j<=this.sizeY-1; j++){
            for(int i = 0; i<=this.sizeX-1; i++){
                hsv = m2d.getValue(i,j);
                this.setValue(i, j, new HSV(hsv.h, hsv.s, hsv.v) );
            }
        }
    }

    public void setValue(int xPos, int yPos, HSV value) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public HSV getValue(int xPos, int yPos) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            return this.matrix[yPos][xPos];
        }
        return null;
    }


    public ArrayList<Point2d<HSV, Integer>> getShapePoints(ArrayList<Point> points){
        ArrayList<Point2d<HSV, Integer>> pointsHSV = new ArrayList<Point2d<HSV, Integer>>();
        HSV hsv;
        for (Point p: points) {
            hsv = this.getValue(p.x, p.y);
            pointsHSV.add( new Point2d<HSV, Integer>(p.x, p.y, new HSV(hsv.h, hsv.s, hsv.v)) );
        }
        return pointsHSV;
    }

    /**
     * edge by color hue
     * @return
     */
    public Matrix2dBoolean edgeByColorHue(int r){
        HSV p00, p01, p02, p10, p11, p12, p20, p21, p22;
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for(int j = 1; j<this.sizeY-1; j++){
            for(int i = 1; i<this.sizeX-1; i++){
                p00 = this.getValue(i-1, j-1);
                p01 = this.getValue(i, j-1);
                p02 = this.getValue(i+1, j-1);

                p10 = this.getValue(i-1, j);
                p11 = this.getValue(i, j);
                p12 = this.getValue(i+1, j);

                p20 = this.getValue(i-1, j+1);
                p21 = this.getValue(i, j+1);
                p22 = this.getValue(i+1, j+1);

                if( Math.abs(p11.h - p00.h) >=r ){
                    m2d.setValue( i-1, j-1,true);
                }
                if( Math.abs(p11.h - p01.h)>=r ){
                    m2d.setValue( i, j-1,true);
                }
                if( Math.abs(p11.h - p02.h)>=r ){
                    m2d.setValue( i+1, j-1,true);
                }

                if( Math.abs(p11.h - p10.h)>=r ){
                    m2d.setValue( i-1, j, true);
                }
                if( Math.abs(p11.h - p12.h)>=r ){
                    m2d.setValue( i+1, j, true);
                }

                if( Math.abs(p11.h - p20.h)>=r ){
                    m2d.setValue( i-1, j+1, true);
                }
                if( Math.abs(p11.h - p21.h)>=r ){
                    m2d.setValue( i, j+1, true);
                }
                if( Math.abs(p11.h - p22.h)>=r ){
                    m2d.setValue( i+1, j+1, true);
                }
            }
        }
        return m2d;
    }

    /**
     * edge by color Saturation
     * @return
     */
    public Matrix2dBoolean edgeByColorSaturation(int r){
        HSV p00, p01, p02, p10, p11, p12, p20, p21, p22;
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for(int j = 1; j<this.sizeY-1; j++){
            for(int i = 1; i<this.sizeX-1; i++){
                p00 = this.getValue(i-1, j-1);
                p01 = this.getValue(i, j-1);
                p02 = this.getValue(i+1, j-1);

                p10 = this.getValue(i-1, j);
                p11 = this.getValue(i, j);
                p12 = this.getValue(i+1, j);

                p20 = this.getValue(i-1, j+1);
                p21 = this.getValue(i, j+1);
                p22 = this.getValue(i+1, j+1);

                if( Math.abs(p11.s - p00.s) >=r ){
                    m2d.setValue( i-1, j-1,true);
                }
                if( Math.abs(p11.s - p01.s)>=r ){
                    m2d.setValue( i, j-1,true);
                }
                if( Math.abs(p11.s - p02.s)>=r ){
                    m2d.setValue( i+1, j-1,true);
                }

                if( Math.abs(p11.s - p10.s)>=r ){
                    m2d.setValue( i-1, j, true);
                }
                if( Math.abs(p11.s - p12.s)>=r ){
                    m2d.setValue( i+1, j, true);
                }

                if( Math.abs(p11.s - p20.s)>=r ){
                    m2d.setValue( i-1, j+1, true);
                }
                if( Math.abs(p11.s - p21.s)>=r ){
                    m2d.setValue( i, j+1, true);
                }
                if( Math.abs(p11.s - p22.s)>=r ){
                    m2d.setValue( i+1, j+1, true);
                }
            }
        }
        return m2d;
    }

    /**
     *
     * @return
     */
    public Matrix2dBoolean edgeByColorValue(int r){
        HSV p00, p01, p02, p10, p11, p12, p20, p21, p22;
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for(int j = 1; j<this.sizeY-1; j++){
            for(int i = 1; i<this.sizeX-1; i++){
                p00 = this.getValue(i-1, j-1);
                p01 = this.getValue(i, j-1);
                p02 = this.getValue(i+1, j-1);

                p10 = this.getValue(i-1, j);
                p11 = this.getValue(i, j);
                p12 = this.getValue(i+1, j);

                p20 = this.getValue(i-1, j+1);
                p21 = this.getValue(i, j+1);
                p22 = this.getValue(i+1, j+1);

                if( Math.abs(p11.v - p00.v) >=r ){
                    m2d.setValue( i-1, j-1,true);
                }
                if( Math.abs(p11.v - p01.v)>=r ){
                    m2d.setValue( i, j-1,true);
                }
                if( Math.abs(p11.v - p02.v)>=r ){
                    m2d.setValue( i+1, j-1,true);
                }

                if( Math.abs(p11.v - p10.v)>=r ){
                    m2d.setValue( i-1, j, true);
                }
                if( Math.abs(p11.v - p12.v)>=r ){
                    m2d.setValue( i+1, j, true);
                }

                if( Math.abs(p11.v - p20.v)>=r ){
                    m2d.setValue( i-1, j+1, true);
                }
                if( Math.abs(p11.v - p21.v)>=r ){
                    m2d.setValue( i, j+1, true);
                }
                if( Math.abs(p11.v - p22.v)>=r ){
                    m2d.setValue( i+1, j+1, true);
                }
            }
        }
        return m2d;
    }

    /**
     *
     * @return
     */
    public Matrix2dHsv middleValueByThreshold(int threshold){
        HSV p00, p01, p02, p10, p11, p12, p20, p21, p22, v;
        Matrix2dHsv m2d = new Matrix2dHsv(this.sizeX, this.sizeY);
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                v = this.getValue(i,j);
                m2d.setValue(i,j, new HSV(v.h, v.s, v.v) );
            }
        }
        int max;
        for(int j = 1; j<this.sizeY-1; j++){
            for(int i = 1; i<this.sizeX-1; i++){
                p00 = m2d.getValue(i-1, j-1);
                p01 = m2d.getValue(i, j-1);
                p02 = m2d.getValue(i+1, j-1);

                p10 = m2d.getValue(i-1, j);
                p11 = m2d.getValue(i, j);
                p12 = m2d.getValue(i+1, j);

                p20 = m2d.getValue(i-1, j+1);
                p21 = m2d.getValue(i, j+1);
                p22 = m2d.getValue(i+1, j+1);

                max = Math.max(p00.v, p01.v);
                max = Math.max(max, p02.v);
                max = Math.max(max, p10.v);
                max = Math.max(max, p12.v);
                max = Math.max(max, p20.v);
                max = Math.max(max, p21.v);
                max = Math.max(max, p22.v);

                if( (max - p11.v)>=0 && (max - p11.v)<=threshold ){
                    p11.v = (max + p11.v)/2;
                }
            }
        }
        return m2d;
    }

    public int[] countGistogramByValue(){
        int v;
        int gist[] = new int[256];
        for(int l = 0; l<256; l++){
            gist[l] = 0;
        }
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                v = this.getValue(i,j).v;
                if(v>255) System.out.println("v=" + v);
                gist[v]+=1;
            }
        }
        return gist;
    }

    public Matrix2dBoolean binarizeByValue(int minValue, int maxValue){
        int v;
        Matrix2dBoolean m2dBool = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                v = this.getValue(i,j).v;
                if(v>=minValue && v<=maxValue){
                    m2dBool.setValue(i, j, true);
                }else{
                    m2dBool.setValue(i, j, false);
                }
            }
        }
        return m2dBool;
    }

    public Matrix2dHsv reduceColors(int dist){
        int i, j, l, nStart, nEnd, start, end;
        HSV hsv;
        Matrix2dHsv m2dHsv = new Matrix2dHsv(this);
        int[] gist = countGistogramByValue();
        start = 0;
        end = 0;
        nStart = gist[start];
        nEnd = gist[end];
        dist = 0;
        for(l = 0; l<256; l++){
            if(gist[l]==0) continue;
            if(gist[l]>nEnd && (end-start)<=dist){
                // find interval of colors
                end = l;
                nEnd = gist[end];
            }else{
                //cnange all colors in interval to max interval
                for(j = 0; j<this.sizeY; j++){
                    for(i = 0; i<this.sizeX; i++) {
                        hsv = this.getValue(i,j);
                        if(hsv.v>=start && hsv.v<=end){
                            m2dHsv.setValue(i, j, new HSV(hsv.h, hsv.s, end) );
                        }
                    }
                }
                // start count new interval
                start = l;
                end = start;
                nStart = gist[start];
                nEnd = gist[end];
            }
        }
        //cnange last all colors in interval to max interval
        if((end-start)<=dist){
            for (j = 0; j < this.sizeY; j++) {
                for (i = 0; i < this.sizeX; i++) {
                    hsv = this.getValue(i, j);
                    if (hsv.v >= start && hsv.v <= end) {
                        m2dHsv.setValue(i, j, new HSV(hsv.h, hsv.s, end));
                    }
                }
            }
        }
        return m2dHsv;
    }

//    /**
//     * count edge by RGB color distance
//     * @return
//     */
//    public Matrix2dHsv removeCloseValues(int dist){
//        HSV p00, p01, p02, p10, p11, p12, p20, p21, p22;
//        Matrix2dHsv m2d = new Matrix2dHsv(this.size, this.sizeY);
//
//        for(int j = 0; j<this.sizeY; j++){
//            for(int i = 0; i<this.size; i++){
//                p00 = this.getValue(i-1, j-1);
//                p01 = this.getValue(i, j-1);
//                p02 = this.getValue(i+1, j-1);
//
//                p10 = this.getValue(i-1, j);
//                p11 = this.getValue(i, j);
//                p12 = this.getValue(i+1, j);
//
//                p20 = this.getValue(i-1, j+1);
//                p21 = this.getValue(i, j+1);
//                p22 = this.getValue(i+1, j+1);
//
//                m2d.setValue( i, j, HSV.toClosestHighValue(p00, p01, p02, p10, p11, p12, p20, p21, p22, dist) );
//            }
//        }
//        return m2d;
//    }


//    /**
//     * Kraskal segmentation
//     * @param threshold
//     * @return
//     */
//    public Matrix2dHsv kraskalSegmentation(int threshold){
//        int i, j;
//        HSV p11, p12, p21, p22;
//        // 1. FIND ALL EDGES BETWEEN PIXELS
//        ArrayList<Edge> edges = new ArrayList<Edge>();
//        Edge e;
//        for(j = 0; j<this.sizeY; j++){
//            for(i = 0; i<this.size; i++){
//                p11 = this.getValue(i, j);
//                p12 = this.getValue(i+1, j);
//                p21 = this.getValue(i, j+1);
//                p22 = this.getValue(i+1, j+1);
//                if( p12!=null){ e = new Edge(new Point2dGeneric(i,j), new Point2dGeneric(i+1,j), Math.abs(p11.v - p12.v) );
//                    edges.add(e);
//                }
//                if( p21!=null){ e = new Edge(new Point2dGeneric(i,j), new Point2dGeneric(i,j+1), Math.abs(p11.v - p21.v) );
//                    edges.add(e);
//                }
//                if( p22!=null){ e = new Edge(new Point2dGeneric(i,j), new Point2dGeneric(i+1,j+1), Math.abs(p11.v - p22.v) );
//                    edges.add(e);
//                }
//            }
//        }
//        // 2. SORT EDGES
//        edges.sort(new CComparator<Edge>() { public int compare(Edge o1, Edge o2) { return o1.compareTo(o2); } });
//        // 3. CREATE SEGMENTS FOR EVERY POINT
//        Matrix2dInt m2dSegmIds = new Matrix2dInt(this.size, this.sizeY); // segmentId in values of points
//        HashMap<Integer, Segment> segments = new HashMap<Integer, Segment>(); // segment number, segment;
//        // 4. FIND ALL KRASKAL SEGMENTS
//        int segCount = 0;
//        int v, min, max;
//        Segment segm1, segm2;
//        ArrayList<Point2dGeneric> points1, points2;
//        for (Edge edge: edges) {
//            if( m2dSegmIds.getValue(edge.p1.x, edge.p1.y)==null ) {
//                v = this.getValue(edge.p1.x, edge.p1.y).v;
//                segm1 = new Segment(v, v, segCount);
//                segm1.points.add(new Point2dGeneric(edge.p1.x, edge.p1.y));
//                segments.put(segCount, segm1);
//                m2dSegmIds.setValue(edge.p1.x, edge.p1.y, segCount);
//                segCount += 1;
//            }else{
//                segm1 = segments.get( m2dSegmIds.getValue(edge.p1.x, edge.p1.y) );
//            }
//            if( m2dSegmIds.getValue(edge.p2.x, edge.p2.y)==null ) {
//                v = this.getValue(edge.p2.x, edge.p2.y).v;
//                segm2 = new Segment(v, v, segCount);
//                segm2.points.add(new Point2dGeneric(edge.p2.x, edge.p2.y));
//                segments.put(segCount, segm2);
//                m2dSegmIds.setValue(edge.p2.x, edge.p2.y, segCount);
//                segCount += 1;
//            }else{
//                segm2 = segments.get( m2dSegmIds.getValue(edge.p2.x, edge.p2.y) );
//            }
//            min = Math.min(segm1.minValue, segm2.minValue);
//            max = Math.max(segm1.maxValue, segm2.maxValue);
//            if( (segm1.id != segm2.id) && ((max-min)<=threshold) ){
//                points1 = segm1.points;
//                points2 = segm2.points;
//                for(Point2dGeneric p : points2){
//                    points1.add(p);
//                    m2dSegmIds.setValue(p.x, p.y, segm1.id);
//                    segm1.minValue = min;
//                    segm1.maxValue = max;
//                    segments.remove(segm2.id);
//                }
//            }
//        }
//
//        Matrix2dHsv m2dHsv = new Matrix2dHsv(this.size, this.sizeY);
//        for(Segment s : segments.values()){
//            for(Point2dGeneric p : s.points) {
//                m2dHsv.setValue(p.x, p.y, new HSV(255, 255, s.id % 255));
//            }
//        }
//        return m2dHsv;
//    }

}
