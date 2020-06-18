package core.old.process.MatrixToMatrix;

import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.color.Colors256ARGB;
import core.old.VertexValue.matrix.Matrix2d;

/**
 * Created by anonymous on 13.12.2018.
 */
//public class M2dArgbToM2dArgb16Colors {
//
//    /**
//     * Matrix2d<Byte> -> quantize values  in new Matrix2d<Byte>
//     * @return
//     */
//    @Override
//    public Boolean process() {
//        return Boolean.TRUE;
//    }
//
//    /**
//     * Matrix2d<Byte> -> EdgeDiff values  in new Matrix2d<Byte>
//     * @param in
//     * @return
//     */
//    public static Matrix2d<ARGB> transform(Matrix2d<ARGB> in) {
//        int x, y, i, j;
//        ARGB inArgb, outArgb;
//        Colors256ARGB colors256 = new Colors256ARGB();
//        y = in.sizeY;
//        x = in.sizeX;
//        Matrix2d<ARGB> out = new Matrix2d<ARGB>(ARGB.class, x, y, null);
//        for(j = 0; j<y; j++){
//            for(i = 0; i<x; i++) {
//                inArgb = in.getValue(i,j);
//                outArgb = colors256.findClosestColor16(inArgb);
//                out.setValue(i, j, outArgb);
//            }
//        }
//        return out;
//    }
//
//}
