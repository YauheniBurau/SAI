package core.filter;

import core.element.ARGB;
import core.matrix.Matrix2d;

import static core.transform.Matrix2dTransform.argbConvolute2x;

/**
 * Created by anonymous on 01.05.2017.
 */
public class Matrix2dArgbFilter {

    public static Matrix2d<ARGB> rgbToGrey256(Matrix2d<ARGB> m2dArgb){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        Matrix2d<ARGB> rMatrix2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        int grey;
        ARGB argb;
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                argb = m2dArgb.getValue(i, j);
                grey = (argb.b & argb.g & argb.r & 0xFF);
                rMatrix2d.setValue(i, j, new ARGB(0xff, grey, grey, grey));
            }
        }
        return rMatrix2d;
    }

    public static Matrix2d<ARGB> argbToGrey256(Matrix2d<ARGB> m2dArgb){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        Matrix2d<ARGB> rMatrix2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        int grey;
        ARGB argb;
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                argb = m2dArgb.getValue(i, j);
                grey = (argb.b & argb.g & argb.r & 0xFF);
                rMatrix2d.setValue(i, j, new ARGB(argb.a, grey, grey, grey));
            }
        }
        return rMatrix2d;
    }

    public static Matrix2d<ARGB> argbToColorDiff(Matrix2d<ARGB> m2dArgb){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        ARGB empty = new ARGB(0x00, 0, 0, 0);
        ARGB[][] pixels;
        int a, r, g, b;
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                pixels = m2dArgb.get3x3(ARGB.class, i, j, empty);
                a = pixels[1][1].a ^ (
                        pixels[0][0].a + pixels[0][1].a + pixels[0][2].a +
                        pixels[1][0].a +                  pixels[1][2].a +
                        pixels[2][0].a + pixels[2][1].a + pixels[2][2].a)/8;
                r = pixels[1][1].r ^ (
                        pixels[0][0].r + pixels[0][1].r + pixels[0][2].r +
                        pixels[1][0].r +                  pixels[1][2].r +
                        pixels[2][0].r + pixels[2][1].r + pixels[2][2].r)/8;
                g = pixels[1][1].g ^ (
                        pixels[0][0].g + pixels[0][1].g + pixels[0][2].g +
                        pixels[1][0].g +                  pixels[1][2].g +
                        pixels[2][0].g + pixels[2][1].g + pixels[2][2].g)/8;
                b = pixels[1][1].b ^ (
                        pixels[0][0].b + pixels[0][1].b + pixels[0][2].b +
                        pixels[1][0].b +                  pixels[1][2].b +
                        pixels[2][0].b + pixels[2][1].b + pixels[2][2].b)/8;
                m2d.setValue(i, j, new ARGB(a, r, g, b));
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> argbMinMax(Matrix2d<ARGB> m2dArgb, int aMin, int aMax, int rMin, int rMax, int gMin, int gMax, int bMin, int bMax){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        ARGB empty = new ARGB(0x00, 0, 0, 0);
        ARGB edge = new ARGB(0xff, 255, 255, 255);
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        ARGB p;
        for(int j = 0; j<sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                p = m2dArgb.getValue(i, j);
                if(p.a>=aMin && p.a<=aMax && p.r>=rMin && p.r<=rMax && p.g>=gMin && p.g<=gMax && p.b>=bMin && p.b<=bMax){
                    //m2d.setValue(i, j, p);
                    m2d.setValue(i, j, edge);
                }else{
                    m2d.setValue(i, j, empty);
                }
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> argbByColorFrequency(Matrix2d<ARGB> m2dArgb, int[] frequency, int aMinFrequency, int maxFrequency){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        ARGB empty = new ARGB(0xff, 0, 0, 0);
        ARGB edge = new ARGB(0xff, 255, 255, 255);
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        ARGB p;
        int color;
        for(int j = 0; j<sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                p = m2dArgb.getValue(i, j);
                color = (p.r + p.g + p.b)/3;
                if( frequency[color]>=aMinFrequency && frequency[color]<=maxFrequency){
                    m2d.setValue(i, j, p);
                }else{
                    m2d.setValue(i, j, empty);
                }
            }
        }
        return m2d;
    }

    public static void argbToGrey2ByThreshold(Matrix2d<ARGB> source, Matrix2d<ARGB> output, ARGB threshold,
                                                        int xStart, int yStart, int xFinish, int yFinish){
        int iThreshold = threshold.a + threshold.r + threshold.g + threshold.b;
        ARGB low = new ARGB(0xff, 0, 0, 0);
        ARGB high = new ARGB(0xff, 255, 255, 255);
        ARGB p;
        int pThreshold;
        for(int j = yStart; j<yFinish; j++){
            for(int i = xStart; i<xFinish; i++){
                p = source.getValue(i, j);
                pThreshold = p.a + p.r + p.g + p.b;
                if( pThreshold>=iThreshold){
                    output.setValue(i, j, high);
                }else{
                    output.setValue(i, j, low);
                }
            }
        }
    }

    public static Matrix2d<ARGB> argbToGrey2ByRChannel(Matrix2d<ARGB> m2dArgb, ARGB threshold){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        int iThreshold = threshold.r;
        ARGB low = new ARGB(0xff, 0, 0, 0);
        ARGB high = new ARGB(0xff, 255, 255, 255);
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        ARGB p;
        int pThreshold;
        for(int j = 0; j<sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                p = m2dArgb.getValue(i, j);
                pThreshold = p.r;
                if( pThreshold>=iThreshold){
                    m2d.setValue(i, j, high);
                }else{
                    m2d.setValue(i, j, low);
                }
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> argbToGrey2ByGChannel(Matrix2d<ARGB> m2dArgb, ARGB threshold){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        int iThreshold = threshold.g;
        ARGB low = new ARGB(0xff, 0, 0, 0);
        ARGB high = new ARGB(0xff, 255, 255, 255);
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        ARGB p;
        int pThreshold;
        for(int j = 0; j<sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                p = m2dArgb.getValue(i, j);
                pThreshold = p.g;
                if( pThreshold>=iThreshold){
                    m2d.setValue(i, j, high);
                }else{
                    m2d.setValue(i, j, low);
                }
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> argbToGrey2ByBChannel(Matrix2d<ARGB> m2dArgb, ARGB threshold){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        int iThreshold = threshold.b;
        ARGB low = new ARGB(0xff, 0, 0, 0);
        ARGB high = new ARGB(0xff, 255, 255, 255);
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        ARGB p;
        int pThreshold;
        for(int j = 0; j<sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                p = m2dArgb.getValue(i, j);
                pThreshold = p.b;
                if( pThreshold>=iThreshold){
                    m2d.setValue(i, j, high);
                }else{
                    m2d.setValue(i, j, low);
                }
            }
        }
        return m2d;
    }

    public static Matrix2d<ARGB> argbToGrey2ByAChannel(Matrix2d<ARGB> m2dArgb, ARGB threshold){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        int iThreshold = threshold.a;
        ARGB low = new ARGB(0xff, 0, 0, 0);
        ARGB high = new ARGB(0xff, 255, 255, 255);
        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
        ARGB p;
        int pThreshold;
        for(int j = 0; j<sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                p = m2dArgb.getValue(i, j);
                pThreshold = p.a;
                if( pThreshold>=iThreshold){
                    m2d.setValue(i, j, high);
                }else{
                    m2d.setValue(i, j, low);
                }
            }
        }
        return m2d;
    }

    public static void argbToMaskByThreshold(Matrix2d<ARGB> source, Matrix2d<ARGB> lowMask, Matrix2d<ARGB> highMask, ARGB threshold,
                                              int xStart, int yStart, int xFinish, int yFinish){
        int iThreshold = threshold.a + threshold.r + threshold.g + threshold.b;
        ARGB empty = new ARGB(0xff, 0, 0, 0);
        ARGB mask = new ARGB(0xff, 255, 255, 255);
        ARGB p;
        int pThreshold;
        for(int j = yStart; j<yFinish; j++){
            for(int i = xStart; i<xFinish; i++){
                p = source.getValue(i, j);
                pThreshold = p.a + p.r + p.g + p.b;
                if( pThreshold>=iThreshold){
                    highMask.setValue(i, j, mask);
                    lowMask.setValue(i, j, empty);
                }else{
                    lowMask.setValue(i, j, mask);
                    highMask.setValue(i, j, empty);
                }
            }
        }
    }

    public static void argbToMaskByThreshold(Matrix2d<ARGB> source, Matrix2d<ARGB> lowMask, Matrix2d<ARGB> highMask,
                                                    Matrix2d<ARGB> argbMask, ARGB threshold,
                                                    int xStart, int yStart, int xFinish, int yFinish){
        int iThreshold = threshold.a + threshold.r + threshold.g + threshold.b;
        ARGB empty = new ARGB(0xff, 0, 0, 0);
        ARGB mask = new ARGB(0xff, 255, 255, 255);
        ARGB p, pMask;
        int pThreshold;
        for(int j = yStart; j<yFinish; j++){
            for(int i = xStart; i<xFinish; i++){
                p = source.getValue(i, j);
                pThreshold = p.a + p.r + p.g + p.b;
                pMask = argbMask.getValue(i, j);
                if(pMask.a == mask.a && pMask.r == mask.r && pMask.g == mask.g && pMask.b == mask.b) {
                    if (pThreshold >= iThreshold) {
                        highMask.setValue(i, j, mask);
                        lowMask.setValue(i, j, empty);
                    } else {
                        lowMask.setValue(i, j, mask);
                        highMask.setValue(i, j, empty);
                    }
                }else{
                    highMask.setValue(i, j, empty);
                    lowMask.setValue(i, j, empty);
                }
            }
        }
    }


    public static Matrix2d<ARGB> argbToAlpha(Matrix2d<ARGB> source, ARGB color, int r){
        int i, j, sizeX, sizeY;
        ARGB pixel;
        ARGB black = new ARGB(0x00, 0, 0, 0);
        ARGB white = new ARGB(0xff, 255, 255, 255);
        sizeX = source.sizeX;
        sizeY = source.sizeY;
        Matrix2d<ARGB> mask = new Matrix2d<ARGB>(ARGB.class, sizeX,sizeY);
        // for every pixel of source make
        for (j = 0; j < sizeY; j++) {
            for (i = 0; i < sizeX; i++) {
                pixel = source.getValue(i, j);
                if ( Math.sqrt((color.r-pixel.r)^2+(color.g-pixel.g)^2+(color.b-pixel.b)^2)<r ) {
                    // change color to mask;
                    mask.setValue(i, j, white);
                } else {
                    //change to empty
                    mask.setValue(i, j, black);
                }
            }
        }
        return mask;
    }
}
