package core.old.process.MatrixToGraph;

import core.application.controller.AbstractAlgorithmFX;

// TODO: remove later
/**
 * Created by anonymous on 02.12.2018.
 */
public class M2dByteToGraphVertexSegmentByteDecart2dInt extends AbstractAlgorithmFX {
    @Override
    public Boolean process() {
        return null;
    }

//    /**
//     * find all points that connected with point(x,y) and have the same value
//     * @param in
//     * @param x
//     * @param y
//     * @return
//     */
//    private static ArrayList<PointByteDecart2dInt> findPointsOfSegment(Matrix2d<Byte> in, int x, int y){
//        if( in.getValue(x, y) == null ) return null;
//        Matrix2d<Boolean> isProcessed = new Matrix2d<Boolean>(Boolean.class, in.sizeX, in.sizeY, false);
//        int pi, pj;
//        Byte v1, v2, v3, v4, v5, v6, v7, v8, v9;
//        ArrayList<PointByteDecart2dInt> s = new ArrayList<PointByteDecart2dInt>();
//        PointByteDecart2dInt p;
//        LinkedList<PointByteDecart2dInt> points = new LinkedList<PointByteDecart2dInt>();
//        points.add( new PointByteDecart2dInt( in.getValue(x, y), new Decart2dInt(x, y)) );
//        isProcessed.setBufferedImage(x, y, true);
//        while(points.size()>0){
//            p = points.poll();
//            s.add(p);
//            pi = p.coords.x;
//            pj = p.coords.y;
//            v1 = in.getValue(pi, pj);
//            v2 = in.getValue(pi, pj-1);
//            v3 = in.getValue(pi+1, pj-1);
//            v4 = in.getValue(pi+1, pj);
//            v5 = in.getValue(pi+1, pj+1);
//            v6 = in.getValue(pi, pj+1);
//            v7 = in.getValue(pi-1, pj+1);
//            v8 = in.getValue(pi-1, pj);
//            v9 = in.getValue(pi-1, pj-1);
//            if( v2 != null && isProcessed.getValue(pi, pj-1) == false && v1 == v2 ) {
//                points.add( new PointByteDecart2dInt(v2, new Decart2dInt(pi,pj-1)) );
//                isProcessed.setBufferedImage(pi, pj-1, true);
//            }
//            if( v3 != null && isProcessed.getValue(pi+1, pj-1) == false && v1 == v3 ) {
//                points.add( new PointByteDecart2dInt(v3, new Decart2dInt(pi+1,pj-1)) );
//                isProcessed.setBufferedImage(pi+1, pj-1, true);
//            }
//            if( v4 != null && isProcessed.getValue(pi+1, pj) == false && v1 == v4 ) {
//                points.add( new PointByteDecart2dInt(v4, new Decart2dInt(pi+1,pj)) );
//                isProcessed.setBufferedImage(pi+1, pj, true);
//            }
//            if( v5 != null && isProcessed.getValue(pi+1, pj+1) == false && v1 == v5 ) {
//                points.add( new PointByteDecart2dInt(v5, new Decart2dInt(pi+1,pj+1)) );
//                isProcessed.setBufferedImage(pi+1, pj+1, true);
//            }
//            if( v6 != null && isProcessed.getValue(pi, pj+1) == false && v1 == v6 ) {
//                points.add( new PointByteDecart2dInt(v6, new Decart2dInt(pi,pj+1)) );
//                isProcessed.setBufferedImage(pi, pj+1, true);
//            }
//
//            if( v7 != null && isProcessed.getValue(pi-1, pj+1) == false && v1 == v7 ) {
//                points.add( new PointByteDecart2dInt(v7, new Decart2dInt(pi-1,pj+1)) );
//                isProcessed.setBufferedImage(pi-1, pj+1, true);
//            }
//            if( v8 != null && isProcessed.getValue(pi-1, pj) == false && v1 == v8 ) {
//                points.add( new PointByteDecart2dInt(v8, new Decart2dInt(pi-1,pj)) );
//                isProcessed.setBufferedImage(pi-1, pj, true);
//            }
//            if( v9 != null && isProcessed.getValue(pi-1, pj-1) == false && v1 == v9) {
//                points.add( new PointByteDecart2dInt(v9, new Decart2dInt(pi-1,pj-1)) );
//                isProcessed.setBufferedImage(pi-1, pj-1, true);
//            }
//        }
//        return s;
//    }
//
//    /**
//     * transformPoints Matrix2d<Byte> -> Matrix2d<Boolean> as segment edges
//     * @param in
//     * @return
//     */
//    public static Matrix2d<Boolean> m2dByteToM2dBooleanContours(Matrix2d<Byte> in) {
//        Byte p00, p01, p02, p10, p11, p12, p20, p21, p22;
//        int x, y;
//        y = in.sizeY;
//        x = in.sizeX;
//        Matrix2d<Boolean> out = new Matrix2d<Boolean>(Boolean.class, x, y, null);
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                p00 = in.getValue(i-1, j-1); if(p00 ==null) p00 = 0;
//                p01 = in.getValue(i, j-1); if(p01 ==null) p01 = 0;
//                p02 = in.getValue(i+1, j-1);  if(p02 ==null) p02 = 0;
//                p10 = in.getValue(i-1, j);  if(p10 ==null) p10 = 0;
//                p11 = in.getValue(i, j);  if(p11 ==null) p11 = 0;
//                p12 = in.getValue(i+1, j);  if(p12 ==null) p12 = 0;
//                p20 = in.getValue(i-1, j+1);  if(p20 ==null) p20 = 0;
//                p21 = in.getValue(i, j+1);  if(p21 ==null) p21 = 0;
//                p22 = in.getValue(i+1, j+1);  if(p22 ==null) p22 = 0;
//                if( p11>p00 ){ out.setBufferedImage( i-1, j-1, true); }
//                if( p11>p01 ){ out.setBufferedImage( i, j-1, true); }
//                if( p11>p02 ){ out.setBufferedImage( i+1, j-1, true); }
//                if( p11>p10 ){ out.setBufferedImage( i-1, j, true); }
//                if( p11>p12 ){ out.setBufferedImage( i+1, j, true); }
//                if( p11>p20 ){ out.setBufferedImage( i-1, j+1, true); }
//                if( p11>p21 ){ out.setBufferedImage( i, j+1, true);}
//                if( p11>p22 ){ out.setBufferedImage( i+1, j+1,true);}
//            }
//        }
//        return out;
//    }
//
//    /**
//     * conveerts edges boolean matrix to matrixof graph where you can see connections between points
//     * @param in
//     * @return
//     */
//    private static Matrix2d<LinkedDecart2dInt> m2dBooleanContoursToM2dLinkedDecart2dInt(Matrix2d<Boolean> in) {
//        int i, j, x, y;
//        y = in.sizeY;
//        x = in.sizeX;
//        Matrix2d<LinkedDecart2dInt> m2dLinked =
//                new Matrix2d<LinkedDecart2dInt>(LinkedDecart2dInt.class, x, y, null);
//        // create vertexes
//        for(j = 0; j<y; j++){
//            for(i = 0; i<x; i++) {
//                if(in.getValue(i,j)!=null ) {
//                    m2dLinked.setBufferedImage(i, j, new LinkedDecart2dInt(new Decart2dInt(i,j)) );
//                }
//            }
//        }
//        // set all connections between vertexes in Matrix2d<LinkedDecart2dInt>
//        LinkedDecart2dInt p1, p2, p3, p4, p5, p6, p7, p8, p9;
//        int pi, pj;
//        for(j = 0; j<y; j++){
//            for(i = 0; i<x; i++) {
//                p1 = m2dLinked.getValue(i,j);
//                if(p1!=null){
//                    // for 8 connections
//                    pi = p1.getPoint().x;
//                    pj = p1.getPoint().y;
//                    p2 = m2dLinked.getValue(pi, pj-1);
//                    p3 = m2dLinked.getValue(pi+1, pj-1);
//                    p4 = m2dLinked.getValue(pi+1, pj);
//                    p5 = m2dLinked.getValue(pi+1, pj+1);
//                    p6 = m2dLinked.getValue(pi, pj+1);
//                    p7 = m2dLinked.getValue(pi-1, pj+1);
//                    p8 = m2dLinked.getValue(pi-1, pj);
//                    p9 = m2dLinked.getValue(pi-1, pj-1);
//
//                    if( p2!=null ){ p1.getPoints().add(p2); }
//                    if( p3!=null ){ p1.getPoints().add(p3); }
//                    if( p4!=null ){ p1.getPoints().add(p4); }
//                    if( p5!=null ){ p1.getPoints().add(p5); }
//                    if( p6!=null ){ p1.getPoints().add(p6); }
//                    if( p7!=null ){ p1.getPoints().add(p7); }
//                    if( p8!=null ){ p1.getPoints().add(p8); }
//                    if( p9!=null ){ p1.getPoints().add(p9); }
//                }
//            }
//        }
//        return m2dLinked;
//    }
//
//    /**
//     * in data will be changed and returned as result
//     * @param in
//     * @return
//     */
//    public static Matrix2d<LinkedDecart2dInt> M2dLinkedDecart2dIntToReducedLinkedDecart2dInt(Matrix2d<LinkedDecart2dInt> in){
//        // TODO:
//
//        return in;
//    }
//
//    public static ContourDecart2dInt m2dReducedLinkedDecart2dIntToOuterContourDecart2dInt( Matrix2d<LinkedDecart2dInt> in){
//        ContourDecart2dInt outerContour = null;
//        // TODO:
//
//        return outerContour;
//    }
//
//    public static ArrayList<ContourDecart2dInt> m2dReducedLinkedDecart2dIntToInnerContoursDecart2dInt( Matrix2d<LinkedDecart2dInt> in){
//        ArrayList<ContourDecart2dInt> innerContours = null;
//        // TODO:
//
//        return innerContours;
//    }


//    /**
//     *
//     * @return
//     */
//    private static SegmentPointDecart2dInt arrayPointByteDecart2dIntToSegmentByteDecart2dInt(ArrayList<PointByteDecart2dInt> in) {
//        // 1. find shift by x and y
//        if(in.size()==0) return null;
//        int l = Integer.MAX_VALUE;
//        int u = Integer.MAX_VALUE;
//        int r = Integer.MIN_VALUE;
//        int d = Integer.MIN_VALUE;
//        for(PointByteDecart2dInt p : in){
//            if( p.elements.x < l ) l = p.elements.x;
//            if( p.elements.y < u ) u = p.elements.y;
//            if( p.elements.x > r ) r = p.elements.x;
//            if( p.elements.y > d ) d = p.elements.y;
//        }
//        int shiftX = l;
//        int shiftY = u;
//        int width = r - l + 1;
//        int high = d - u + 1;
//        Matrix2d<Byte> m2dShifted = new Matrix2d<>(Byte.class, width, high, null);
//        for(PointByteDecart2dInt p : in) {
//            m2dShifted.setBufferedImage(p.elements.x-shiftX, p.elements.y - shiftY, p.value);
//        }
//        // count matrix2d<Boolean> as Segment mask of points
//        Matrix2d<Boolean> m2dSegmentContours = m2dByteToM2dBooleanContours(m2dShifted);
//        Matrix2d<LinkedDecart2dInt> m2dLinkedDecart2dInt = m2dBooleanContoursToM2dLinkedDecart2dInt(m2dSegmentContours);
//        Matrix2d<LinkedDecart2dInt> m2dReducedLinkedDecart2dInt = M2dLinkedDecart2dIntToReducedLinkedDecart2dInt(m2dLinkedDecart2dInt);
//        // find outerContour
//        ContourDecart2dInt outerContour = m2dReducedLinkedDecart2dIntToOuterContourDecart2dInt(m2dReducedLinkedDecart2dInt);
//        // find innerContours
//        ArrayList<ContourDecart2dInt> innerContours = m2dReducedLinkedDecart2dIntToInnerContoursDecart2dInt(m2dReducedLinkedDecart2dInt);
//        // count Value
//        Byte value = in.get(0).value.byteValue();
//
//        // TODO: normalize value with shiftX and shiftY
//
//        // gather all in SegmentByteDecart2dInt
//        SegmentPointDecart2dInt out = new SegmentPointDecart2dInt();
//        out.value = value;
//        out.outerContour = outerContour;
//        out.innerContours = innerContours;
//        out.points = in;
//        return out;
//    }

//    public static Matrix2d<SegmentPointDecart2dInt> m2dByteToM2dIntSegmentIds(Matrix2d<Byte> in){
//        Matrix2d<SegmentPointDecart2dInt> m2dSegments =
//                new Matrix2d<>(SegmentPointDecart2dInt.class, in.sizeX, in.sizeY, null);
//        Byte segmentValue;
//        ArrayList<PointByteDecart2dInt> segmentPoints;
//        SegmentPointDecart2dInt segment;
////        VertexSegmentByteDecart2dInt vertex;
//        int i, j;
//        for(j = 0; j<in.sizeY; j++){
//            for(i = 0; i<in.sizeX; i++) {
//                if(m2dSegments.getValue(i,j)==null){
//                    segmentPoints = findPointsOfSegment(in, i, j);
//                    segment = new SegmentPointDecart2dInt();
//                    segment.points = segmentPoints;
//                    segment.countSegmentSize();
//                    for (PointByteDecart2dInt p: segmentPoints) {
//                        m2dSegments.setBufferedImage(p.elements.x, p.elements.y, segment);
//                    }
//                }
//            }
//        }
//        return m2dSegments;
//    }

//    /**
//     *  Matrix2d<Byte> -> GraphVertexSegmentPointByteDecart2dInt
//     * @param in
//     * @return
//     */
//    public static GraphVertexSegmentByteDecart2dInt transform(Matrix2d<Byte> in) {
//        GraphVertexSegmentByteDecart2dInt out = new GraphVertexSegmentByteDecart2dInt();
//        // create rootVertex
//        SegmentPointDecart2dInt rootSegment = new SegmentPointDecart2dInt();
//        rootSegment.points.add(new PointByteDecart2dInt((byte)255, new Decart2dInt(0,0)));
//        rootSegment.points.add(new PointByteDecart2dInt((byte)255, new Decart2dInt(in.sizeX,in.sizeY)));
//        out.setRootVertex(new VertexSegmentByteDecart2dInt(rootSegment));
//        // create all vertexes of segments from m2dByte
//        Matrix2d<VertexSegmentByteDecart2dInt> m2dVertexes =
//                new Matrix2d<>(VertexSegmentByteDecart2dInt.class, in.sizeX, in.sizeY, null);
//        Byte segmentValue;
//        ArrayList<PointByteDecart2dInt> segmentPoints;
//        ArrayList<Decart2dInt> decartPoints;
//        SegmentPointDecart2dInt segment;
//        VertexSegmentByteDecart2dInt vertex;
//        int i, j;
//        for(j = 0; j<in.sizeY; j++){
//            for(i = 0; i<in.sizeX; i++) {
//                if(m2dVertexes.getValue(i,j)==null){
//                    segmentValue = in.getValue(i,j);
//                    decartPoints = in.count8LSegment(i, j);
//                    segment = new SegmentPointDecart2dInt(segmentValue, segmentPoints);
//                    vertex = new VertexSegmentByteDecart2dInt(segment);
//                    for (PointByteDecart2dInt p: segmentPoints) {
//                        m2dVertexes.setBufferedImage(p.elements.x, p.elements.y, vertex);
//                    }
//                    out.add(vertex);
//                }
//            }
//        }
//        // organize vertexes of segments into tree hierarchy
//        // create rootVertex
//        // add all vertexSegments into first Segment
//        // TODO:
//        return out;
//    }


//    /**
//     *  Matrix2d<Byte> -> GraphVertexSegmentPointByteDecart2dInt
//     * @return
//     */
//    @Override
//    public Boolean onProcess() {
//        Matrix2d<Byte> in = this.model.matrix2dByteList.get(this.inKey);
//        GraphVertexSegmentByteDecart2dInt out;
//        if(in!=null) {
//            out = this.transform(in);
//            this.model.graphVertexSegmentByteDecart2dIntList.put(this.outKey, out);
//        }else{
//            throw new InputParamException("Wrong in and out params. At least one of them is null");
//        }
//        return Boolean.TRUE;
//    }

}
