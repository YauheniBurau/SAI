package core.application.process.MatrixToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.VertexValue.color.ARGB;
import core.application.VertexValue.color.Colors256ARGB;
import core.application.VertexValue.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.model.Model;

/**
 * Created by anonymous on 13.12.2018.
 */
public class M2dArgbToM2dArgb16Colors  extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;

    public M2dArgbToM2dArgb16Colors(Model model, String inKey, String outKey) {
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
        Matrix2d<ARGB> in = this.model.matrix2dArgbList.get(this.inKey);
        Matrix2d<ARGB> out;
        if(in!=null) {
            out = this.transform(in);
            this.model.matrix2dArgbList.put(this.outKey, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     * Matrix2d<Byte> -> EdgeDiff values  in new Matrix2d<Byte>
     * @param in
     * @return
     */
    public static Matrix2d<ARGB> transform(Matrix2d<ARGB> in) {
        int x, y, i, j;
        ARGB inArgb, outArgb;
        Colors256ARGB colors256 = new Colors256ARGB();
        y = in.sizeY;
        x = in.sizeX;
        Matrix2d<ARGB> out = new Matrix2d<ARGB>(ARGB.class, x, y, null);
        for(j = 0; j<y; j++){
            for(i = 0; i<x; i++) {
                inArgb = in.getValue(i,j);
                outArgb = colors256.findClosestColor16(inArgb);
                out.setValue(i, j, outArgb);
            }
        }
        return out;
    }

}
