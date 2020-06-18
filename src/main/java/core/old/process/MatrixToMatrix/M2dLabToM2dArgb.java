package core.old.process.MatrixToMatrix;

import core.old.process.ColorToColor.LabToArgb;
import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.color.Lab;
import core.old.VertexValue.matrix.Matrix2d;

/**
 * Created by anonymous on 30.10.2018.
 */
public class M2dLabToM2dArgb {

    /**
     * Matrix2d<Argb> -> Matrix2d<Lab>
     * @return
     */
//    @Override
//    public Boolean process() {
//        return Boolean.TRUE;
//    }

    /**
     * transformPoints Matrix2d<Lab> to matrix2d<ARGB>
     * @param in
     * @param whitePoint from Lab class
     * @return
     */
    public static Matrix2d<ARGB> transform(Matrix2d<Lab> in, double[] whitePoint) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        ARGB value;
        Matrix2d<ARGB> out = new Matrix2d<ARGB>(ARGB.class, x, y, null);
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = LabToArgb.transform( in.getValue(i, j), whitePoint );
                out.setValue(i, j, value);
            }
        }
        return out;
    }

}