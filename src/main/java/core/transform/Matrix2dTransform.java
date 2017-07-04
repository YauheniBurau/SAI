package core.transform;

import core.element.ARGB;
import core.matrix.Matrix2d;

/**
 * Created by anonymous on 03.05.2017.
 */
public class Matrix2dTransform {

    public static Matrix2d<ARGB> reduce(Matrix2d<ARGB> m2dArgb, int nx){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        int resizedX = sizeX/nx;
        int resizedY = sizeY/nx;
        Matrix2d<ARGB> m2d = new Matrix2d( ARGB.class, resizedX, resizedY);
        for(int j = 0; j<resizedY; j++){
            for(int i = 0; i<resizedX; i++){
                m2d.setValue(i, j, m2dArgb.getValue(i*nx, j*nx) );
                // rMatrix2d.setValue(i, j, matrix2d.getMiddleValue(i*2, j*2) );
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> argbConvolute2x(Matrix2d<ARGB> m2dArgb){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        ARGB empty = new ARGB(0x00, 0, 0, 0);
        ARGB[][] pixels;
        int a, r, g, b;
        int x = sizeX>>1;
        int y = sizeY>>1;
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                pixels = m2dArgb.get2x2(ARGB.class, i*2, j*2, empty);
                a = (pixels[0][0].a + pixels[0][1].a + pixels[1][0].a + pixels[1][1].a)/4;
                r = (pixels[0][0].r + pixels[0][1].r + pixels[1][0].r + pixels[1][1].r)/4;
                g = (pixels[0][0].g + pixels[0][1].g + pixels[1][0].g + pixels[1][1].g)/4;
                b = (pixels[0][0].b + pixels[0][1].b + pixels[1][0].b + pixels[1][1].b)/4;
                m2d.setValue(i, j, new ARGB(a, r, g, b));
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> argbPlusArgb(Matrix2d<ARGB> m2dArgb1, Matrix2d<ARGB> m2dArgb2){
        int sizeX = m2dArgb1.sizeX;
        int sizeY = m2dArgb1.sizeY;
        int a, r, g, b;
        ARGB p1, p2;
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                p1 = m2dArgb1.getValue(i, j);
                p2 = m2dArgb2.getValue(i, j);
                m2d.setValue(i, j, new ARGB((p1.a + p2.a)/2, (p1.r + p2.r)/2, (p1.g + p2.g)/2, (p1.b + p2.b)/2));
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> argbPlusArgb(Matrix2d<ARGB> m2dArgb1, Matrix2d<ARGB> m2dArgb2, Matrix2d<ARGB> m2dArgb3){
        int sizeX = m2dArgb1.sizeX;
        int sizeY = m2dArgb1.sizeY;
        int a, r, g, b;
        ARGB p1, p2, p3;
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                p1 = m2dArgb1.getValue(i, j);
                p2 = m2dArgb2.getValue(i, j);
                p3 = m2dArgb3.getValue(i, j);
                m2d.setValue(i, j, new ARGB((p1.a + p2.a + p3.a)/2, (p1.r + p2.r + p3.r)/2, (p1.g + p2.g + p3.g)/2, (p1.b + p2.b + p3.b)/2));
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> argbMask(Matrix2d<ARGB> m2dArgb, ARGB threshold){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        ARGB low = new ARGB(0xff, 0, 0, 0);
        ARGB high = new ARGB(0xff, 255, 255, 255);
        ARGB p;
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                p = m2dArgb.getValue(i, j);
                if(p.a == threshold.a && p.r == threshold.r && p.g == threshold.g && p.b == threshold.b)
                m2d.setValue(i, j, high);
                else m2d.setValue(i, j, low);
            }
        }
        return m2d;
    }


}
