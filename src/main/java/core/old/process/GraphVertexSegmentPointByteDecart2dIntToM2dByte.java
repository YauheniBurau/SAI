package core.old.process;

/**
 * Created by anonymous on 02.12.2018.
 */
public class GraphVertexSegmentPointByteDecart2dIntToM2dByte {

//    /**
//     * GraphVertexSegmentPointByteDecart2dInt -> Matrix2d<Byte>
//     * @return
//     */
//    @Override
//    public Boolean onProcess() {
//        GraphVertexSegmentByteDecart2dInt in =
//                this.model.graphVertexSegmentByteDecart2dIntList.get(this.inKey);
//        Matrix2d<Byte> out;
//        if(in!=null) {
//            out = this.transformPoints(in);
//            this.model.matrix2dByteList.put(this.outKey, out);
//        }else{
//            throw new InputParamException("Wrong in and out params. At least one of them is null");
//        }
//        return Boolean.TRUE;
//    }

//    /**
//     * GraphVertexSegmentPointByteDecart2dInt (points) -> Matrix2d<Byte>
//     * @param in
//     * @return
//     */
//    public static Matrix2d<Byte> transformPoints(GraphVertexSegmentByteDecart2dInt in){
//        Byte segmentValue;
//        VertexSegmentByteDecart2dInt rootVertex = in.getRootVertex();
//        SegmentPointDecart2dInt rootSegment = rootVertex.getValue();
//        rootSegment.countSegmentSize();
//        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, rootSegment.width, rootSegment.high, null);
//        // fill m2dByte with points from segments
//        for(VertexSegmentByteDecart2dInt vertex: in.getVertexes()){
//            segmentValue = vertex.getValue().value;
//            for(PointByteDecart2dInt p: vertex.getValue().points){
//                out.setBufferedImage(p.elements.x, p.elements.y, segmentValue);
//            }
//        }
//        return out;
//    }

//    /**
//     * GraphVertexSegmentPointByteDecart2dInt (points) -> Matrix2d<Byte>
//     * @param in
//     * @return
//     */
//    public static Matrix2d<Byte> transformOuterContours(GraphVertexSegmentByteDecart2dInt in){
//        Byte segmentValue;
//        VertexSegmentByteDecart2dInt rootVertex = in.getRootVertex();
//        SegmentPointDecart2dInt rootSegment = rootVertex.getValue();
//        rootSegment.countSegmentSize();
//        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, rootSegment.width, rootSegment.high, null);
//        // fill m2dByte with points from segments
//        // TODO:
////        for(VertexSegmentByteDecart2dInt vertex: in.getVertexes()){
////            segmentValue = vertex.getValue().value;
////            for(PointByteDecart2dInt p: vertex.getValue().points){
////                out.setBufferedImage(p.elements.x, p.elements.y, segmentValue);
////            }
////        }
//        return out;
//    }

//    /**
//     * GraphVertexSegmentPointByteDecart2dInt (points) -> Matrix2d<Byte>
//     * @param in
//     * @return
//     */
//    public static Matrix2d<Byte> transformInnerContours(GraphVertexSegmentByteDecart2dInt in){
//        Byte segmentValue;
//        VertexSegmentByteDecart2dInt rootVertex = in.getRootVertex();
//        SegmentPointDecart2dInt rootSegment = rootVertex.getValue();
//        rootSegment.countSegmentSize();
//        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, rootSegment.width, rootSegment.high, null);
//        // fill m2dByte with points from segments
//        // TODO:
////        for(VertexSegmentByteDecart2dInt vertex: in.getVertexes()){
////            segmentValue = vertex.getValue().value;
////            for(PointByteDecart2dInt p: vertex.getValue().points){
////                out.setBufferedImage(p.elements.x, p.elements.y, segmentValue);
////            }
////        }
//        return out;
//    }

}
