package core.application.process.Matrix2dToGraph;

import core.application.algorithms.BaseAlgorithm;
import core.application.dataElement.graph.GraphVertexSegmentPointByteDecart2dInt;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.model.Model;

/**
 * Created by anonymous on 02.12.2018.
 */
public class M2dByteToGraphVertexSegmentPointByteDecart2dInt extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public M2dByteToGraphVertexSegmentPointByteDecart2dInt(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     *  Matrix2d<Byte> -> GraphVertexSegmentPointByteDecart2dInt
     * @return
     */
    @Override
    public Boolean process() {
        Matrix2d<Byte> in = this.model.matrix2dByteList.get(this.inKey);
        GraphVertexSegmentPointByteDecart2dInt out;
        if(in!=null) {
            out = this.transform(in);
            this.model.graphVertexSegmentPointByteDecart2dIntList.put(this.outKey, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     *  Matrix2d<Byte> -> GraphVertexSegmentPointByteDecart2dInt
     * @param in
     * @return
     */
    public static GraphVertexSegmentPointByteDecart2dInt transform(Matrix2d<Byte> in){
        GraphVertexSegmentPointByteDecart2dInt out = new GraphVertexSegmentPointByteDecart2dInt();
        Matrix2d<Integer> m2dSegmentids = new Matrix2d<Integer>(Integer.class, in.sizeX, in.sizeY, null);
        Matrix2d<Boolean> m2dProcessed = new Matrix2d<Boolean>(Boolean.class, in.sizeX, in.sizeY, false);
        int segId = 0;
        //todo
        //        ArrayList<Segment<Point<Byte,Decart2d<Integer>>>> segments;
//        segments = Matrix2dByteToArraySegmentPointByteDecart2dInteger.findSegments(in);
//        out.addAll(segments);
        return out;
    }

}
