package core.old.process.MatrixToMatrix;

import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.color.Colors256ARGB;
import core.old.VertexValue.matrix.Matrix2d;
import core.old.VertexValue.matrix.Matrix2dByte;
import core.old.process.PrimitiveToPrimitive.UnsignedIntToSignedByte;

/**
 * Created by anonymous on 14.12.2018.
 */
//public class M2dArgbToM2dByte256Colors {
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
//    public static Matrix2dByte transform(Matrix2d<ARGB> in) {
//        int x, y, i, j;
//        Colors256ARGB colors256 = new Colors256ARGB();
//        y = in.sizeY;
//        x = in.sizeX;
//        Matrix2dByte out = new Matrix2dByte(x, y, null);
//        for(j = 0; j<y; j++){
//            for(i = 0; i<x; i++) {
//                out.setValue(i, j, UnsignedIntToSignedByte.transform(colors256.findClosestColor256Index(in.getValue(i,j))));
//            }
//        }
//        return out;
//    }
//
//}
