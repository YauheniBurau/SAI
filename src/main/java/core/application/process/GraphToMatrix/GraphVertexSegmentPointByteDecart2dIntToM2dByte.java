package core.application.process.GraphToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.dataElement.graph.GraphVertexSegmentPointByteDecart2dInt;
import core.application.dataElement.matrix.Matrix2d;
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

    /**
     * GraphVertexSegmentPointByteDecart2dInt -> Matrix2d<Byte>
     * @return
     */
    @Override
    public Boolean process() {
        GraphVertexSegmentPointByteDecart2dInt in =
                this.model.graphVertexSegmentPointByteDecart2dIntList.get(this.inKey);
        Matrix2d<Byte> out;
        if(in!=null) {
            out = this.transform(in);
            this.model.matrix2dByteList.put(this.outKey, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     * GraphVertexSegmentPointByteDecart2dInt -> Matrix2d<Byte>
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transform(GraphVertexSegmentPointByteDecart2dInt in){
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class);
        //todo
//        ArrayList<Segment<Point<Byte,Decart2d<Integer>>>> segments;
//        segments = Matrix2dByteToArraySegmentPointByteDecart2dInteger.findSegments(in);
//        out.addAll(segments);
        return out;
    }


}
