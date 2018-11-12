package core.application.process.MatrixByteToSegments;

import core.application.algorithms.BaseAlgorithm;
import core.application.dataElement.coords.Cartesian2dInt;
import core.application.dataElement.matrix.Matrix2d;
import core.application.dataElement.points.PointByte_Cartesian2dInt;
import core.application.dataElement.segments.ArrayListOfSegmentPointByte_Cartesian2dInt;
import core.application.dataElement.segments.SegmentPointByte_Cartesian2dInt;
import core.application.exceptions.InputParamException;
import core.application.model.Model;
import core.application.process.TransformResults;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by anonymous on 12.11.2018.
 */
public class Matrix2dByteToArrayListOfSegmentByte_Cartesian2dInt extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public Matrix2dByteToArrayListOfSegmentByte_Cartesian2dInt(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

//    /**
//     *  Matrix2dByte -> ArrayListOfSegmentPointByte_Cartesian2dInt
//     * @return
//     */
//    @Override
//    public TransformResults process() {
//        Matrix2d<Byte> in = this.model.matrix2dByteList.get(this.inKey);
//        ArrayListOfSegmentPointByte_Cartesian2dInt out = this.model.arrayListOfSegmentByte_Cartesian2dIntList.get(this.outKey);
//        TransformResults tr = new TransformResults();
//        if(in!=null && out!=null) {
//            tr = this.transform(in, out);
//        }else{
//            throw new InputParamException("Wrong in and out params. At least one of them is null");
//        }
//        return tr;
//    }

    /**
     *  Matrix2dByte -> ArrayListOfSegmentPointByte_Cartesian2dInt
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform(Matrix2d<Byte> in, ArrayListOfSegmentPointByte_Cartesian2dInt out) {
        TransformResults tr = new TransformResults();
        out.segments.clear();
        ArrayList<SegmentPointByte_Cartesian2dInt> segments;
        segments = Matrix2dByteToArrayListOfSegmentByte_Cartesian2dInt.findSegments(in);
        out.segments.addAll(segments);
        return tr;
    }


    /**
     *
     * @param isProcessed
     * @param x
     * @param y
     * @return
     */
    public static SegmentPointByte_Cartesian2dInt findSegment(Matrix2d<Byte> in, Matrix2d<Boolean> isProcessed, int x, int y){
        if( in.getValue(x, y) == null ) return null;
        int pi, pj;
        Byte v1, v2, v3, v4, v5, v6, v7, v8, v9;
        SegmentPointByte_Cartesian2dInt s = new SegmentPointByte_Cartesian2dInt();
        PointByte_Cartesian2dInt p;
        LinkedList<PointByte_Cartesian2dInt> points = new LinkedList<PointByte_Cartesian2dInt>();
        points.add( new PointByte_Cartesian2dInt( in.getValue(x, y), new Cartesian2dInt(x, y)) );
        isProcessed.setValue(x, y, true);
        while(points.size()>0){
            p = points.poll();
            s.points.add(p);
            pi = p.coords.x;
            pj = p.coords.y;
            v1 = in.getValue(pi, pj);
            v2 = in.getValue(pi, pj-1);
            v3 = in.getValue(pi+1, pj-1);
            v4 = in.getValue(pi+1, pj);
            v5 = in.getValue(pi+1, pj+1);
            v6 = in.getValue(pi, pj+1);
            v7 = in.getValue(pi-1, pj+1);
            v8 = in.getValue(pi-1, pj);
            v9 = in.getValue(pi-1, pj-1);
            if( v2 != null && isProcessed.getValue(pi, pj-1) == false && v1 == v2 ) {
                points.add( new PointByte_Cartesian2dInt(v2, pi,pj-1) );
                isProcessed.setValue(pi, pj-1, true);
            }
            if( v3 != null && isProcessed.getValue(pi+1, pj-1) == false && v1 == v3 ) {
                points.add( new PointByte_Cartesian2dInt(v3, pi+1,pj-1) );
                isProcessed.setValue(pi+1, pj-1, true);
            }
            if( v4 != null && isProcessed.getValue(pi+1, pj) == false && v1 == v4 ) {
                points.add( new PointByte_Cartesian2dInt(v4, pi+1,pj) );
                isProcessed.setValue(pi+1, pj, true);
            }
            if( v5 != null && isProcessed.getValue(pi+1, pj+1) == false && v1 == v5 ) {
                points.add( new PointByte_Cartesian2dInt(v5, pi+1,pj+1) );
                isProcessed.setValue(pi+1, pj+1, true);
            }
            if( v6 != null && isProcessed.getValue(pi, pj+1) == false && v1 == v6 ) {
                points.add( new PointByte_Cartesian2dInt(v6, pi,pj+1) );
                isProcessed.setValue(pi, pj+1, true);
            }

            if( v7 != null && isProcessed.getValue(pi-1, pj+1) == false && v1 == v7 ) {
                points.add( new PointByte_Cartesian2dInt(v7, pi-1,pj+1) );
                isProcessed.setValue(pi-1, pj+1, true);
            }
            if( v8 != null && isProcessed.getValue(pi-1, pj) == false && v1 == v8 ) {
                points.add( new PointByte_Cartesian2dInt(v8, pi-1,pj) );
                isProcessed.setValue(pi-1, pj, true);
            }
            if( v9 != null && isProcessed.getValue(pi-1, pj-1) == false && v1 == v9) {
                points.add( new PointByte_Cartesian2dInt(v9, pi-1,pj-1) );
                isProcessed.setValue(pi-1, pj-1, true);
            }
        }
        return s;
    }

    /**
     * find all segments
     * @return
     */
    public static ArrayList<SegmentPointByte_Cartesian2dInt> findSegments(Matrix2d<Byte> in) {
        ArrayList<SegmentPointByte_Cartesian2dInt> segments = new ArrayList<SegmentPointByte_Cartesian2dInt>();
        Matrix2d<Boolean> isProcessed = new Matrix2d<Boolean>(Boolean.class, in.sizeX, in.sizeY, false);
        SegmentPointByte_Cartesian2dInt seg;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                if( isProcessed.getValue(i, j) == false ){
                    seg = Matrix2dByteToArrayListOfSegmentByte_Cartesian2dInt.findSegment(in, isProcessed, i, j);
                    if(seg!=null) {
                        for (PointByte_Cartesian2dInt p : seg.points) {
                            isProcessed.setValue(p.coords.x, p.coords.y, true);
                        }
                        segments.add(seg);
                    }else{
                        isProcessed.setValue(i, j, true);
                    }
                }
            }
        }
        return segments;
    }


}
