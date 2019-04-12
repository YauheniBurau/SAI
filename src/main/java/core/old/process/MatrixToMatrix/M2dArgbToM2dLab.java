package core.old.process.MatrixToMatrix;

import core.old.process.ColorToColor.ArgbToLab;
import core.application.controller.AbstractAlgorithmFX;
import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.color.Lab;
import core.old.VertexValue.matrix.Matrix2d;

/**
 * Created by anonymous on 30.10.2018.
 */
public class M2dArgbToM2dLab extends AbstractAlgorithmFX {

    /**
     * Matrix2d<Argb> -> Matrix2d<Lab>
     * @return
     */
    @Override
    public Boolean process() {
        return Boolean.TRUE;
    }

    /**
     * save matrix2d<ARGB> to Matrix2d<Lab>
     * @param in
     * @param whitePoint from Lab class
     * @return
     */
    public static Matrix2d<Lab> transform(Matrix2d<ARGB> in, double[] whitePoint) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Lab value;
        Matrix2d<Lab> out = new Matrix2d<Lab>(Lab.class, x, y, null);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = ArgbToLab.transform( in.getValue(i, j), whitePoint );
                out.setValue(i, j, value);
            }
        }
        return out;
    }

}
