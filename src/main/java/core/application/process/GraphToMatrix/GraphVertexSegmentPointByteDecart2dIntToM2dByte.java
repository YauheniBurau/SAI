package core.application.process.GraphToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.dataElement.graph.GraphVertexSegmentByteDecart2dInt;
import core.application.dataElement.graph.VertexSegmentByteDecart2dInt;
import core.application.dataElement.matrix.Matrix2d;
import core.application.dataElement.points.PointByteDecart2dInt;
import core.application.dataElement.segments.SegmentPointDecart2dInt;
import core.application.exceptions.InputParamException;
import core.application.model.Model;

/**
 * Created by anonymous on 02.12.2018.
 */
public class GraphVertexSegmentPointByteDecart2dIntToM2dByte extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public GraphVertexSegmentPointByteDecart2dIntToM2dByte(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

//    /**
//     * GraphVertexSegmentPointByteDecart2dInt -> Matrix2d<Byte>
//     * @return
//     */
//    @Override
//    public Boolean process() {
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
//                out.setValue(p.coords.x, p.coords.y, segmentValue);
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
////                out.setValue(p.coords.x, p.coords.y, segmentValue);
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
////                out.setValue(p.coords.x, p.coords.y, segmentValue);
////            }
////        }
//        return out;
//    }

}
