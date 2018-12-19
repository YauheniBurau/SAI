package core.application.process.MatrixToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.VertexValue.color.ARGB;
import core.application.VertexValue.color.Colors256ARGB;
import core.application.VertexValue.matrix.Matrix2d;
import core.application.VertexValue.matrix.Matrix2dByte;
import core.application.process.PrimitiveToPrimitive.UnsignedIntToSignedByte;
import core.application.model.Model;

/**
 * Created by anonymous on 14.12.2018.
 */
public class M2dArgbToM2dByte256Colors  extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;

    public M2dArgbToM2dByte256Colors(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     * Matrix2d<Byte> -> quantize values  in new Matrix2d<Byte>
     * @return
     */
    @Override
    public Boolean process() {
    // TODO:
//        Matrix2d<ARGB> in = this.model.matrix2dArgbList.get(this.inKey);
//        Matrix2d<Byte> out;
//        if(in!=null) {
//            out = this.transform(in);
//            this.model.matrix2dArgbList.put(this.outKey, out);
//        }else{
//            throw new InputParamException("Wrong in and out params. At least one of them is null");
//        }
        return Boolean.TRUE;
    }

    /**
     * Matrix2d<Byte> -> EdgeDiff values  in new Matrix2d<Byte>
     * @param in
     * @return
     */
    public static Matrix2dByte transform(Matrix2d<ARGB> in) {
        int x, y, i, j;
        Colors256ARGB colors256 = new Colors256ARGB();
        y = in.sizeY;
        x = in.sizeX;
        Matrix2dByte out = new Matrix2dByte(x, y, null);
        for(j = 0; j<y; j++){
            for(i = 0; i<x; i++) {
                out.setValue(i, j, UnsignedIntToSignedByte.transform(colors256.findClosestColor256Index(in.getValue(i,j))));
            }
        }
        return out;
    }


}
