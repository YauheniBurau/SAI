package core.application.process.MatrixToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.helper.SignedByteToUnsignedInt;
import core.application.dataElement.color.ARGB;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.model.Model;

/**
 * Created by anonymous on 08.11.2018.
 */
public class M2dByte3ToM2dArgb extends BaseAlgorithm {

    private Model model;
    private String inKeyR;
    private String inKeyG;
    private String inKeyB;
    private String outKey;

    public M2dByte3ToM2dArgb(Model model, String inKeyR, String inKeyG, String inKeyB, String outKey) {
        this.model = model;
        this.inKeyR = inKeyR;
        this.inKeyG = inKeyG;
        this.inKeyB = inKeyB;
        this.outKey = outKey;
    }

    /**
     * 3 of Matrix2d<Byte> -> Matrix2d<ARGB>
     * @return
     */
    @Override
    public Boolean process() {
        Matrix2d<Byte> inR = this.model.matrix2dByteList.get(this.inKeyR);
        Matrix2d<Byte> inG = this.model.matrix2dByteList.get(this.inKeyG);
        Matrix2d<Byte> inB = this.model.matrix2dByteList.get(this.inKeyB);
        Matrix2d<ARGB> out;
        if(inR!=null && inG!=null && inB!=null) {
            out = this.transform(inR, inG, inB);
            this.model.matrix2dArgbList.put(this.outKey, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     * transformPoints 3 matrixes matrix2d<Byte> to Matrix2d<ARGB>
     * @param inR
     * @param inG
     * @param inB
     * @return
     */
    public static Matrix2d<ARGB> transform(Matrix2d<Byte> inR, Matrix2d<Byte> inG, Matrix2d<Byte> inB) {
        int x, y;
        y = inR.sizeY;
        x = inR.sizeX;
        ARGB value;
        int r, g, b;
        Matrix2d<ARGB> out = new Matrix2d<ARGB>(ARGB.class, x, y, null);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                r = SignedByteToUnsignedInt.transform(inR.getValue(i, j));
                g = SignedByteToUnsignedInt.transform(inG.getValue(i, j));
                b = SignedByteToUnsignedInt.transform(inB.getValue(i, j));
                value = new ARGB(0xff, r, g, b);
                out.setValue(i, j, value);
            }
        }
        return out;
    }

}
