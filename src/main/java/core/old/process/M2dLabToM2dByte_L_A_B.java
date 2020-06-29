package core.old.process;

import core.old.VertexValue.color.Lab;
import core.old.VertexValue.matrix.Matrix2d;

/**
 * Created by anonymous on 31.10.2018.
 */
public class M2dLabToM2dByte_L_A_B {
    public static final int BY_L = 1;
    public static final int BY_A = 2;
    public static final int BY_B = 3;

    /**
     * Matrix2d<Lab> -> Matrix2d<Byte> By Light from Lab
     * @return
     */
//    @Override
//    public Boolean process() {
//        return Boolean.TRUE;
//    }

    /**
     * transformPoints Matrix2d<Lab> to matrix2d<Byte> where By L from Lab
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transformL(Matrix2d<Lab> in) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Byte value;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedDoubleToSignedByte.transform(in.getValue(i, j).L);
                out.setValue(i, j, value);
            }
        }
        return out;
    }

    /**
     * transformPoints Matrix2d<Lab> to matrix2d<Byte> where By A from Lab
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transformA(Matrix2d<Lab> in) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Byte value;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedDoubleToSignedByte.transform(in.getValue(i, j).a);
                out.setValue(i, j, value);
            }
        }
        return out;
    }

    /**
     * transformPoints Matrix2d<Lab> to matrix2d<Byte> where By B from Lab
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transformB(Matrix2d<Lab> in) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Byte value;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedDoubleToSignedByte.transform(in.getValue(i, j).b);
                out.setValue(i, j, value);
            }
        }
        return out;
    }

}
