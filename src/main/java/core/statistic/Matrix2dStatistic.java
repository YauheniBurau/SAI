package core.statistic;

import core.element.ARGB;
import core.matrix.Matrix2d;

/**
 * Created by anonymous on 06.05.2017.
 */
public class Matrix2dStatistic {

    public static int[] argbColors(Matrix2d<ARGB> m2dArgb){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        ARGB pixel;
        int[] colors = new int[256];
        int color;
        for(int n =0; n<256; n++) colors[n] = 0;
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                pixel = m2dArgb.getValue(i, j);
                color = (pixel.r + pixel.g +pixel.b)/3;
                colors[color]+=1;
            }
        }
        return colors;
    }

    public static ARGB middleColor(Matrix2d<ARGB> m2dArgb){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        int total = sizeX*sizeY;
        ARGB pixel;
        int a = 0;
        int r = 0;
        int g = 0;
        int b = 0;
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                pixel = m2dArgb.getValue(i, j);
                a += pixel.a;
                r += pixel.r;
                g += pixel.g;
                b += pixel.b;
            }
        }
        return new ARGB(a/total, r/total, g/total, b/total);
    }

    public static ARGB middleColor(Matrix2d<ARGB> m2dArgb, int xStart, int yStart, int xFinish, int yFinish){
        int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        int total = (yFinish-yStart)*(xFinish-xStart);
        ARGB pixel;
        int a = 0;
        int r = 0;
        int g = 0;
        int b = 0;
        for(int j = yStart; j<yFinish; j++){
            for(int i = xStart; i<xFinish; i++){
                pixel = m2dArgb.getValue(i, j);
                a += pixel.a;
                r += pixel.r;
                g += pixel.g;
                b += pixel.b;
            }
        }
        return new ARGB(a/total, r/total, g/total, b/total);
    }

    public static ARGB middleColor(Matrix2d<ARGB> m2dArgb, Matrix2d<ARGB> m2dArgbMask, int xStart, int yStart, int xFinish, int yFinish){
         int sizeX = m2dArgb.sizeX;
        int sizeY = m2dArgb.sizeY;
        ARGB empty = new ARGB(0xff, 0, 0, 0);
        ARGB mask = new ARGB(0xff, 255, 255, 255);
        int total = 0;
        ARGB p, pMask;
        int a = 0;
        int r = 0;
        int g = 0;
        int b = 0;
        for(int j = yStart; j<yFinish; j++){
            for(int i = xStart; i<xFinish; i++){
                p = m2dArgb.getValue(i, j);
                pMask = m2dArgbMask.getValue(i, j);
                if(mask.a == pMask.a && mask.r == pMask.r && mask.g == pMask.g && mask.b == pMask.b) {
                    a += p.a;
                    r += p.r;
                    g += p.g;
                    b += p.b;
                    total+=1;
                }
            }
        }
        return new ARGB(a/total, r/total, g/total, b/total);
    }

}
