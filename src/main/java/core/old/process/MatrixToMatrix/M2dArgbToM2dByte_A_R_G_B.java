package core.old.process.MatrixToMatrix;

import core.old.process.PrimitiveToPrimitive.UnsignedIntToSignedByte;
import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.matrix.Matrix2d;

/**
 * Created by anonymous on 08.11.2018.
 */
//public class M2dArgbToM2dByte_A_R_G_B {
//    public static final int BY_A = 0;
//    public static final int BY_R = 1;
//    public static final int BY_G = 2;
//    public static final int BY_B = 3;
//
//    /**
//     * Matrix2d<Argb> -> Matrix2d<Lab>
//     * @return
//     */
//    @Override
//    public Boolean process() {
//        return Boolean.TRUE;
//    }
//
//    /**
//     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from A
//     * @param in
//     * @return
//     */
//    public static Matrix2d<Byte> transform0(Matrix2d<ARGB> in) {
//        int x, y;
//        y = in.sizeY;
//        x = in.sizeX;
//        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null );
//        byte value;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).a);
//                out.setValue(i, j, value);
//            }
//        }
//        return out;
//    }
//
//    /**
//     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from R
//     * @param in
//     * @return
//     */
//    public static Matrix2d<Byte> transform1(Matrix2d<ARGB> in) {
//        int x, y;
//        y = in.sizeY;
//        x = in.sizeX;
//        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null );
//        byte value;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).r);
//                out.setValue(i, j, value);
//            }
//        }
//        return out;
//    }
//
//    /**
//     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from G
//     * @param in
//     * @return
//     */
//    public static Matrix2d<Byte> transform2(Matrix2d<ARGB> in) {
//        int x, y;
//        y = in.sizeY;
//        x = in.sizeX;
//        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null );
//        byte value;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).g);
//                out.setValue(i, j, value);
//            }
//        }
//        return out;
//    }
//
//    /**
//     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from B
//     * @param in
//     * @return
//     */
//    public static Matrix2d<Byte> transform3(Matrix2d<ARGB> in) {
//        int x, y;
//        y = in.sizeY;
//        x = in.sizeX;
//        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null );
//        byte value;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).b);
//                out.setValue(i, j, value);
//            }
//        }
//        return out;
//    }
//
//}
