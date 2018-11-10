package core.application.process;

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
    public TransformResults process() {
        Matrix2d<Byte> inR = this.model.matrix2dByteList.get(this.inKeyR);
        Matrix2d<Byte> inG = this.model.matrix2dByteList.get(this.inKeyG);
        Matrix2d<Byte> inB = this.model.matrix2dByteList.get(this.inKeyB);
        Matrix2d<ARGB> out = this.model.matrix2dArgbList.get(this.outKey);
        TransformResults tr = new TransformResults();
        if(inR!=null && inG!=null && inB!=null && out!=null) {
            tr = this.transform(inR, inG, inB,out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return tr;
    }

    /**
     * transform 3 matrixes matrix2d<Byte> to Matrix2d<ARGB>
     * @param inR
     * @param inG
     * @param inB
     * @param out
     * @return
     */
    public static TransformResults transform(Matrix2d<Byte> inR, Matrix2d<Byte> inG, Matrix2d<Byte> inB, Matrix2d<ARGB> out) {
        int x, y;
        y = inR.sizeY;
        x = inR.sizeX;
        ARGB value;
        int r, g, b;
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                r = SignedByteToUnsignedInt.transform(inR.getValue(i, j));
                g = SignedByteToUnsignedInt.transform(inG.getValue(i, j));
                b = SignedByteToUnsignedInt.transform(inB.getValue(i, j));
                value = new ARGB(0xff, r, g, b);
                out.setValue(i, j, value);
            }
        }
        return new TransformResults();
    }

}
