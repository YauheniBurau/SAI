package core.old;

/**
 * Created by anonymous on 27.04.2017.
 */
public class Matrix2d{

//    /**
//     * rotate matrix for a alpha
//     * @param n - a for rotation matrix
//     * @return
//     */
//    public Matrix2d rotate(int n) {
//        if(n<0 || n>359) {
//            throw new InputParamException("n-parameter value must be between 1..256");
//        }
//        ARGB pARGB;
//        int a, r, g, b, step;
//        step = 256/n;
//        Matrix2d m2d = new Matrix2d(this.sizeX, this.sizeY);
//        for (int j = 1; j < sizeY-1; j++) {
//            for (int i = 1; i < sizeX-1; i++) {
//                pARGB = intToArgb(this.getValue(i, j));
//                a = pARGB.a / step * step + step / 2;
//                r = pARGB.r / step * step + step / 2;
//                g = pARGB.g / step * step + step / 2;
//                b = pARGB.b / step * step + step / 2;
//                if (a > 255 || r > 255 || g > 255 || b > 255){
//                    throw new InputParamException("argb parameter value must be between 1..256");
//                }
//                m2d.setValue(i,j, new ARGB(a, r, g, b) );
//            }
//        }
//        return m2d;
//    }


//    public static int[] argbColors(Matrix2d<ARGB> m2dArgb){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        ARGB pixel;
//        int[] colors = new int[256];
//        int color;
//        for(int n =0; n<256; n++) colors[n] = 0;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                pixel = m2dArgb.getValue(i, j);
//                color = (pixel.r + pixel.g +pixel.b)/3;
//                colors[color]+=1;
//            }
//        }
//        return colors;
//    }
//
//    public static ARGB middleColor(Matrix2d<ARGB> m2dArgb){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        int total = sizeX*sizeY;
//        ARGB pixel;
//        int a = 0;
//        int r = 0;
//        int g = 0;
//        int b = 0;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                pixel = m2dArgb.getValue(i, j);
//                a += pixel.a;
//                r += pixel.r;
//                g += pixel.g;
//                b += pixel.b;
//            }
//        }
//        return new ARGB(a/total, r/total, g/total, b/total);
//    }



//
//    public static Matrix2d<ARGB> argbMask(Matrix2d<ARGB> m2dArgb, ARGB threshold){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        ARGB low = new ARGB(0xff, 0, 0, 0);
//        ARGB high = new ARGB(0xff, 255, 255, 255);
//        ARGB p;
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                p = m2dArgb.getValue(i, j);
//                if(p.a == threshold.a && p.r == threshold.r && p.g == threshold.g && p.b == threshold.b)
//                m2d.setValue(i, j, high);
//                else m2d.setValue(i, j, low);
//            }
//        }
//        return m2d;
//    }



//    public static Matrix2d<ARGB> argbByColorFrequency(Matrix2d<ARGB> m2dArgb, int[] frequency, int aMinFrequency, int maxFrequency){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        ARGB empty = new ARGB(0xff, 0, 0, 0);
//        ARGB edge = new ARGB(0xff, 255, 255, 255);
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        ARGB p;
//        int color;
//        for(int j = 0; j<sizeY; j++) {
//            for (int i = 0; i < sizeX; i++) {
//                p = m2dArgb.getValue(i, j);
//                color = (p.r + p.g + p.b)/3;
//                if( frequency[color]>=aMinFrequency && frequency[color]<=maxFrequency){
//                    m2d.setValue(i, j, p);
//                }else{
//                    m2d.setValue(i, j, empty);
//                }
//            }
//        }
//        return m2d;
//    }
//
//    public static void argbToGrey2ByThreshold(Matrix2d<ARGB> source, Matrix2d<ARGB> output, ARGB threshold,
//                                                        int xStart, int yStart, int xFinish, int yFinish){
//        int iThreshold = threshold.a + threshold.r + threshold.g + threshold.b;
//        ARGB low = new ARGB(0xff, 0, 0, 0);
//        ARGB high = new ARGB(0xff, 255, 255, 255);
//        ARGB p;
//        int pThreshold;
//        for(int j = yStart; j<yFinish; j++){
//            for(int i = xStart; i<xFinish; i++){
//                p = source.getValue(i, j);
//                pThreshold = p.a + p.r + p.g + p.b;
//                if( pThreshold>=iThreshold){
//                    output.setValue(i, j, high);
//                }else{
//                    output.setValue(i, j, low);
//                }
//            }
//        }
//    }
//
//
//    public static Matrix2d<ARGB> argbToGrey2ByAChannel(Matrix2d<ARGB> m2dArgb, ARGB threshold){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        int iThreshold = threshold.a;
//        ARGB low = new ARGB(0xff, 0, 0, 0);
//        ARGB high = new ARGB(0xff, 255, 255, 255);
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        ARGB p;
//        int pThreshold;
//        for(int j = 0; j<sizeY; j++) {
//            for (int i = 0; i < sizeX; i++) {
//                p = m2dArgb.getValue(i, j);
//                pThreshold = p.a;
//                if( pThreshold>=iThreshold){
//                    m2d.setValue(i, j, high);
//                }else{
//                    m2d.setValue(i, j, low);
//                }
//            }
//        }
//        return m2d;
//    }
//
//    public static void argbToMaskByThreshold(Matrix2d<ARGB> source, Matrix2d<ARGB> lowMask, Matrix2d<ARGB> highMask, ARGB threshold,
//                                              int xStart, int yStart, int xFinish, int yFinish){
//        int iThreshold = threshold.a + threshold.r + threshold.g + threshold.b;
//        ARGB empty = new ARGB(0xff, 0, 0, 0);
//        ARGB mask = new ARGB(0xff, 255, 255, 255);
//        ARGB p;
//        int pThreshold;
//        for(int j = yStart; j<yFinish; j++){
//            for(int i = xStart; i<xFinish; i++){
//                p = source.getValue(i, j);
//                pThreshold = p.a + p.r + p.g + p.b;
//                if( pThreshold>=iThreshold){
//                    highMask.setValue(i, j, mask);
//                    lowMask.setValue(i, j, empty);
//                }else{
//                    lowMask.setValue(i, j, mask);
//                    highMask.setValue(i, j, empty);
//                }
//            }
//        }
//    }
//
//    public static void argbToMaskByThreshold(Matrix2d<ARGB> source, Matrix2d<ARGB> lowMask, Matrix2d<ARGB> highMask,
//                                                    Matrix2d<ARGB> argbMask, ARGB threshold,
//                                                    int xStart, int yStart, int xFinish, int yFinish){
//        int iThreshold = threshold.a + threshold.r + threshold.g + threshold.b;
//        ARGB empty = new ARGB(0xff, 0, 0, 0);
//        ARGB mask = new ARGB(0xff, 255, 255, 255);
//        ARGB p, pMask;
//        int pThreshold;
//        for(int j = yStart; j<yFinish; j++){
//            for(int i = xStart; i<xFinish; i++){
//                p = source.getValue(i, j);
//                pThreshold = p.a + p.r + p.g + p.b;
//                pMask = argbMask.getValue(i, j);
//                if(pMask.a == mask.a && pMask.r == mask.r && pMask.g == mask.g && pMask.b == mask.b) {
//                    if (pThreshold >= iThreshold) {
//                        highMask.setValue(i, j, mask);
//                        lowMask.setValue(i, j, empty);
//                    } else {
//                        lowMask.setValue(i, j, mask);
//                        highMask.setValue(i, j, empty);
//                    }
//                }else{
//                    highMask.setValue(i, j, empty);
//                    lowMask.setValue(i, j, empty);
//                }
//            }
//        }
//    }

}
