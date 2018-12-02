package core.old;

import core.application.dataElement.AbstractElement;
import core.application.dataElement.color.HSV;

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
