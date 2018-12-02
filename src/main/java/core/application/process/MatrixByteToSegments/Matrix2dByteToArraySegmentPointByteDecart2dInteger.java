package core.application.process.MatrixByteToSegments;

import core.application.algorithms.BaseAlgorithm;
import core.application.dataElement.coords.Decart2d;
import core.application.dataElement.matrix.Matrix2d;
import core.application.dataElement.points.Point;
import core.application.dataElement.segments.Segment;
import core.application.exceptions.InputParamException;
import core.application.model.Model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by anonymous on 12.11.2018.
 */
public class Matrix2dByteToArraySegmentPointByteDecart2dInteger extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public Matrix2dByteToArraySegmentPointByteDecart2dInteger(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     *  Matrix2d<Byte> -> ArrayList<Segment<Point<Byte,Decart2d<Integer>>>>
     * @return
     */
    @Override
    public Boolean process() {
        Matrix2d<Byte> in = this.model.matrix2dByteList.get(this.inKey);
        ArrayList<Segment<Point<Byte,Decart2d<Integer>>>> out;
        if(in!=null) {
            out = this.transform(in);
            this.model.arraySegmentPointByteDecart2dIntegerList.put(this.outKey, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     *  Matrix2d<Byte> -> ArrayList<Segment<Point<Byte,Decart2d<Integer>>>>
     * @param in
     * @return
     */
    public static ArrayList<Segment<Point<Byte,Decart2d<Integer>>>> transform(Matrix2d<Byte> in){
        ArrayList<Segment<Point<Byte,Decart2d<Integer>>>> out = new ArrayList<>();
        ArrayList<Segment<Point<Byte,Decart2d<Integer>>>> segments;
        segments = Matrix2dByteToArraySegmentPointByteDecart2dInteger.findSegments(in);
        out.addAll(segments);
        return out;
    }

    /**
     *
     * @param isProcessed
     * @param x
     * @param y
     * @return
     */
    private static Segment<Point<Byte,Decart2d<Integer>>> findSegment(Matrix2d<Byte> in, Matrix2d<Boolean> isProcessed, int x, int y){
        if( in.getValue(x, y) == null ) return null;
        int pi, pj;
        Byte v1, v2, v3, v4, v5, v6, v7, v8, v9;
        Segment<Point<Byte,Decart2d<Integer>>> s = new Segment<Point<Byte,Decart2d<Integer>>>();
        Point<Byte,Decart2d<Integer>> p;
        LinkedList<Point<Byte,Decart2d<Integer>>> points = new LinkedList<Point<Byte,Decart2d<Integer>>>();
        points.add( new Point<Byte,Decart2d<Integer>>( in.getValue(x, y), new Decart2d<Integer>(x, y)) );
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
                points.add( new Point<Byte,Decart2d<Integer>>(v2, new Decart2d<Integer>(pi,pj-1)) );
                isProcessed.setValue(pi, pj-1, true);
            }
            if( v3 != null && isProcessed.getValue(pi+1, pj-1) == false && v1 == v3 ) {
                points.add( new Point<Byte,Decart2d<Integer>>(v3, new Decart2d<Integer>(pi+1,pj-1)) );
                isProcessed.setValue(pi+1, pj-1, true);
            }
            if( v4 != null && isProcessed.getValue(pi+1, pj) == false && v1 == v4 ) {
                points.add( new Point<Byte,Decart2d<Integer>>(v4, new Decart2d<Integer>(pi+1,pj)) );
                isProcessed.setValue(pi+1, pj, true);
            }
            if( v5 != null && isProcessed.getValue(pi+1, pj+1) == false && v1 == v5 ) {
                points.add( new Point<Byte,Decart2d<Integer>>(v5, new Decart2d<Integer>(pi+1,pj+1)) );
                isProcessed.setValue(pi+1, pj+1, true);
            }
            if( v6 != null && isProcessed.getValue(pi, pj+1) == false && v1 == v6 ) {
                points.add( new Point<Byte,Decart2d<Integer>>(v6, new Decart2d<Integer>(pi,pj+1)) );
                isProcessed.setValue(pi, pj+1, true);
            }

            if( v7 != null && isProcessed.getValue(pi-1, pj+1) == false && v1 == v7 ) {
                points.add( new Point<Byte,Decart2d<Integer>>(v7, new Decart2d<Integer>(pi-1,pj+1)) );
                isProcessed.setValue(pi-1, pj+1, true);
            }
            if( v8 != null && isProcessed.getValue(pi-1, pj) == false && v1 == v8 ) {
                points.add( new Point<Byte,Decart2d<Integer>>(v8, new Decart2d<Integer>(pi-1,pj)) );
                isProcessed.setValue(pi-1, pj, true);
            }
            if( v9 != null && isProcessed.getValue(pi-1, pj-1) == false && v1 == v9) {
                points.add( new Point<Byte,Decart2d<Integer>>(v9, new Decart2d<Integer>(pi-1,pj-1)) );
                isProcessed.setValue(pi-1, pj-1, true);
            }
        }
        return s;
    }

    /**
     * find all segments
     * @return
     */
    private static ArrayList<Segment<Point<Byte,Decart2d<Integer>>>> findSegments(Matrix2d<Byte> in) {
        ArrayList<Segment<Point<Byte,Decart2d<Integer>>>> segments = new ArrayList<Segment<Point<Byte,Decart2d<Integer>>>>();
        Matrix2d<Boolean> isProcessed = new Matrix2d<Boolean>(Boolean.class, in.sizeX, in.sizeY, false);
        Segment<Point<Byte,Decart2d<Integer>>> seg;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                if( isProcessed.getValue(i, j) == false ){
                    seg = Matrix2dByteToArraySegmentPointByteDecart2dInteger.findSegment(in, isProcessed, i, j);
                    if(seg!=null) {
                        for (Point<Byte,Decart2d<Integer>> p : seg.points) {
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
