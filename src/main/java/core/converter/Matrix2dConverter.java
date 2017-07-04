package core.converter;

import core.element.ARGB;
import core.element.Grey256;
import core.element.Int;
import core.matrix.Matrix2d;

/**
 * Created by anonymous on 27.04.2017.
 */
public class Matrix2dConverter {

    public static Matrix2d<ARGB> matrix2dIntToMatrix2dArgb(Matrix2d<Int> matrix2dInt) {
        int y = matrix2dInt.sizeY;
        int x = matrix2dInt.sizeX;
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                m2d.setValue( i, j, ElementConverter.intToArgb(matrix2dInt.getValue(i, j).value) );
            }
        }
        return m2d;
    }

    public static Matrix2d<Int> matrix2dArgbToMatrix2dInt(Matrix2d<ARGB> matrix2dArgb) {
        int y = matrix2dArgb.sizeY;
        int x = matrix2dArgb.sizeX;
        Matrix2d<Int> m2d = new Matrix2d<Int>(Int.class, x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                m2d.setValue( i, j, ElementConverter.argbToInt(matrix2dArgb.getValue(i, j)) );
            }
        }
        return m2d;
    }

//    public static Matrix2d<Int> matrix2dArgbToMatrixDiff(Matrix2d<ARGB> matrix2dArgb) {
//        int y = matrix2dArgb.sizeY;
//        int x = matrix2dArgb.sizeX;
//        Matrix2d<Int> m2d = new Matrix2d<Int>(Int.class, x, y);
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                m2d.setValue( i, j, ElementConverter.argbToInt(matrix2dArgb.getValue(i, j)) );
//            }
//        }
//        return m2d;
//    }
//

//    public static IMatrix matrix2dTransform(IMatrix matrix2d){
//        int sizeX = matrix2d.getSizeX();
//        int sizeY = matrix2d.getSizeY();
//        IMatrix rMatrix2d = new MatrixInt(sizeX, sizeY);
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                rMatrix2d.setValue(i, j, matrix2d.getMiddleValue(i, j) );
//            }
//        }
//        return rMatrix2d;
//    }
//
//    public static IMatrix matrix2dXor(IMatrix matrix2d_1, IMatrix matrix2d_2){
//        int sizeX = matrix2d_1.getSizeX();
//        int sizeY = matrix2d_1.getSizeY();
//        IMatrix rMatrix2d = new MatrixInt(sizeX, sizeY);
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                rMatrix2d.setValue(i, j, matrix2d_1.getMiddleValue(i, j) ^ matrix2d_2.getMiddleValue(i, j) );
//            }
//        }
//        return rMatrix2d;
//    }
//

    public static Matrix2d<ARGB> matrix2dArgbToColors256(Matrix2d<ARGB> matrix2dArgb){
        int sizeX = matrix2dArgb.sizeX;
        int sizeY = matrix2dArgb.sizeY;
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        int grey;
        ARGB argb;
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                argb = matrix2dArgb.getValue(i, j);
                grey = (argb.b >>>  0) & 0xFF | (argb.g >>>  8) & 0xFF | (argb.r >>>  16) & 0xFF;
                m2d.setValue(i, j, new ARGB( argb.a, grey, grey, grey) );
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> matrix2dArgbToColors8(Matrix2d<ARGB> matrix2dArgb){
        int sizeX = matrix2dArgb.sizeX;
        int sizeY = matrix2dArgb.sizeY;
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        int color;
        ARGB argb;
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                argb = matrix2dArgb.getValue(i, j);
                color = (argb.b >>>  0) & 0xFF | (argb.g >>>  8) & 0xFF | (argb.r >>>  16) & 0xFF;
                color=color>>5;
                color=color<<5;
                m2d.setValue(i, j, new ARGB(argb.a, color, color, color));
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> matrix2dArgbToColors4(Matrix2d<ARGB> matrix2dArgb){
        int sizeX = matrix2dArgb.sizeX;
        int sizeY = matrix2dArgb.sizeY;
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        int color;
        ARGB argb;
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                argb = matrix2dArgb.getValue(i, j);
                color = (argb.b >>>  0) & 0xFF | (argb.g >>>  8) & 0xFF | (argb.r >>>  16) & 0xFF;
                color/=64;
                color*=64;
                m2d.setValue(i, j, new ARGB(argb.a, color, color, color));
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> matrix2dArgbToColors2(Matrix2d<ARGB> matrix2dArgb){
        int sizeX = matrix2dArgb.sizeX;
        int sizeY = matrix2dArgb.sizeY;
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        int color;
        ARGB argb;
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                argb = matrix2dArgb.getValue(i, j);
                color = (argb.b >>>  0) & 0xFF | (argb.g >>>  8) & 0xFF | (argb.r >>>  16) & 0xFF;
                color/=128;
                color*=128;
                m2d.setValue(i, j, new ARGB(argb.a, color, color, color));
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> matrix2dArgbToColorsNxNxN(Matrix2d<ARGB> matrix2d, int N){
        int sizeX = matrix2d.sizeX;
        int sizeY = matrix2d.sizeY;
        Matrix2d<ARGB> rMatrix2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        ARGB argb;
        int red, green, blue;
        int K = 256/N;
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                argb = matrix2d.getValue(i, j);
                red = argb.r / K * K;
                green = argb.g/K *K;
                blue = argb.b/K*K;
                rMatrix2d.setValue(i, j, new ARGB(argb.a, red, green, blue));
            }
        }
        return rMatrix2d;
    }

//
//    public static IMatrix matrix2dColor8x8x8(IMatrix matrix2d){
//        int sizeX = matrix2d.getSizeX();
//        int sizeY = matrix2d.getSizeY();
//        IMatrix rMatrix2d = new MatrixInt(sizeX, sizeY);
//        int grey;
//        int pixel;
//        int red, green, blue;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                grey = matrix2d.getValue(i, j);
//                red = (grey >>> 16) & 0xFF; red = red / 32 *32;
//                green = (grey >>> 8) & 0xFF; green = green/32 *32;
//                blue = (grey >>> 0) & 0xFF; blue = blue/32*32;
//                pixel = red;
//                pixel = (pixel<<8) + green;
//                pixel = (pixel<<8) + blue;
//                rMatrix2d.setValue(i, j, pixel);
//            }
//        }
//        return rMatrix2d;
//    }
//

//
//    public static IMatrix matrix2dDetectEdges(IMatrix matrix2d){
//        int sizeX = matrix2d.getSizeX();
//        int sizeY = matrix2d.getSizeY();
//        IMatrix rMatrix2d = new MatrixInt(sizeX, sizeY);
//        int whiteColor = 0x00ffffff;
//        int blackColor = 0x00000000;
//        int pixel;
//        boolean isEdgeValue;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                isEdgeValue = matrix2d.isEdgeValue(i, j);
//                if(isEdgeValue) pixel = whiteColor;
//                else pixel = blackColor;
//                rMatrix2d.setValue(i, j, pixel);
//            }
//        }
//        return rMatrix2d;
//    }

}
