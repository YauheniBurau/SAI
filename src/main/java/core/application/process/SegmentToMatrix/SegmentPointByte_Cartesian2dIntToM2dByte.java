package core.application.process.SegmentToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.dataElement.color.ARGB;
import core.application.dataElement.matrix.Matrix2d;
import core.application.dataElement.points.PointByte_Cartesian2dInt;
import core.application.dataElement.segments.SegmentPointByte_Cartesian2dInt;
import core.application.exceptions.InputParamException;
import core.application.helper.UnsignedIntToSignedByte;
import core.application.model.Model;
import core.application.process.TransformResults;

/**
 * Created by anonymous on 12.11.2018.
 */
public class SegmentPointByte_Cartesian2dIntToM2dByte extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;

    public SegmentPointByte_Cartesian2dIntToM2dByte(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

//    /**
//     * SegmentPointByte_Cartesian2dInt -> Matrix2d<Byte>
//     * @return
//     */
//    @Override
//    public TransformResults process() {
//        SegmentPointByte_Cartesian2dInt in = this.model.matrix2dArgbList.get(this.inKey);
//        Matrix2d<Byte> out = this.model.matrix2dByteList.get(this.outKey);
//        TransformResults tr = new TransformResults();
//        if(in!=null && out!=null) {
//            tr = this.transform0(in, out);
//        }else{
//            throw new InputParamException("Wrong in and out params. At least one of them is null");
//        }
//        return tr;
//    }

    /**
     * SegmentPointByte_Cartesian2dInt -> Matrix2d<Byte>
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform(SegmentPointByte_Cartesian2dInt in, Matrix2d<Byte> out) {
        // 1. find shift by x and y
        if(in.points.size()==0) return null;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int u = Integer.MAX_VALUE;
        int d = Integer.MIN_VALUE;
        for(PointByte_Cartesian2dInt p : in.points){
            if( p.coords.x < l ) l = p.coords.x;
            if( p.coords.x > r ) r = p.coords.x;
            if( p.coords.y < u ) u = p.coords.y;
            if( p.coords.y > d ) d = p.coords.y;
        }
        int width = r - l + 1;
        int high = d - u + 1;
        // 2.create m2dByte
        int x, y;
        y = high;
        x = width;
        out.setSizeXY(x,y, null);
        // 3. add points with shift to Matrix2dByte
        for(PointByte_Cartesian2dInt p : in.points) {
            out.setValue(p.coords.x - l, p.coords.y - u, p.value );
        }
        return new TransformResults();
    }

}
