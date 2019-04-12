package core.old.process.MatrixToMatrix;

import core.application.controller.AbstractAlgorithmFX;
import core.old.process.PrimitiveToPrimitive.SignedByteToUnsignedInt;
import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.matrix.Matrix2d;

/**
 * Created by anonymous on 08.11.2018.
 */
public class M2dByte3ToM2dArgb extends AbstractAlgorithmFX {

    /**
     * 3 of Matrix2d<Byte> -> Matrix2d<ARGB>
     * @return
     */
    @Override
    public Boolean process() {
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
