package core.matrix;

import core.element.ARGB;
import core.exceptions.FileException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 27.04.2017.
 */
public class Matrix2d{
    public static final int EMPTY = 0x00000000;
    public static final int WHITE = 0xffffffff;

    private int[][] matrix;
    public final int sizeX;
    public final int sizeY;

    public Matrix2d(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new int[ySize][xSize];
    }

    /**
     * convert int to ARGB
     * @param value
     * @return
     */
    public static ARGB intToArgb(int value){
        int alpha, red, green, blue;
        alpha = (value >>> 24) & 0xff;
        red = (value >>> 16) & 0xff;
        green = (value >>> 8) & 0xff;
        blue = (value >>> 0) & 0xff;
        return new ARGB(alpha, red, green, blue);
    }

    /**
     * convert ARGB to int
     * @param value
     * @return
     */
    public static int argbToInt(ARGB value){
        int i = 0x00000000;
        i = i | value.a;
        i = i<<8 | value.r;
        i = i<<8 | value.g;
        i = i<<8 | value.b;
        return i;
    }

    /**
     * set int value
     * @param xPos
     * @param yPos
     * @param value
     */
    public void setValue(int xPos, int yPos, int value){
        this.matrix[yPos][xPos] = value;
    }

    /**
     * set ARGB value
     * @param xPos
     * @param yPos
     * @param value
     */
    public void setValue(int xPos, int yPos, ARGB value){
        this.matrix[yPos][xPos] = argbToInt(value);
    }

    /**
     * get value int, after you can convert it to any type(ARGB, HSV...)
     * @param xPos
     * @param yPos
     * @return
     */
    public int getValue(int xPos, int yPos) {
        return this.matrix[yPos][xPos];
    }

    /**
     * load matrix2d from image ARGB-file
     * @param urlFile
     * @return
     */
    public static Matrix2d load(String urlFile) {
        BufferedImage image;
        int color, x, y;
        try {
            image = ImageIO.read(new FileImageInputStream(new File(urlFile)));
        } catch (IOException e) {
            throw new FileException("Can't read image file into matrix2d<ARGB>", e);
        }
        y = image.getHeight();
        x = image.getWidth();
        Matrix2d matrix2D = new Matrix2d(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                color = image.getRGB(i,j);
                matrix2D.setValue(i,j, color);
            }
        }
        return matrix2D;
    }

    /**
     * save matrix to image-file
     * @param urlFile
     * @param format
     */
    public Matrix2d save(String urlFile, String format) {
        BufferedImage image;
        int x, y;
        image = new BufferedImage(this.sizeX, this.sizeY, TYPE_INT_ARGB);
        y = this.sizeY;
        x = this.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, this.getValue(i, j));
            }
        }
        try {
            ImageIO.write(image, format, new File(urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write matrix2d to image file", e);
        }
        return this;
    }

    /**
     * get pixels 2x2 from left up corner
     * @param x
     * @param y
     * @return
     */
    public int[][] get2x2(int x, int y){
        int sizeX = this.sizeX;
        int sizeY = this.sizeY;
        int[][] pixels = new int[2][2];
        pixels[0][0] = x >= 0 && y >= 0 ? this.getValue(x, y) : EMPTY;
        pixels[0][1] = x < sizeX - 1 && y >=0 ? this.getValue(x+1, y) : EMPTY;
        pixels[1][0] = x >= 0 && y < sizeY - 1 ? this.getValue(x, y + 1) : EMPTY;
        pixels[1][1] = x < sizeX - 1 && y < sizeY - 1 ? this.getValue(x + 1, y + 1) : EMPTY;
        return pixels;
    }

    /**
     * get matrix of elements 3x3 from center elements
     * @param x
     * @param y
     * @return
     */
    public int[][] get3x3(int x, int y){
        int sizeX = this.sizeX;
        int sizeY = this.sizeY;
        int[][] pixels = new int[3][3];
        pixels[0][0] = x >= 1 && y >= 1 ? this.getValue(x - 1, y - 1) : EMPTY;
        pixels[0][1] = x >= 0 && y >= 1 ? this.getValue(x, y - 1) : EMPTY;
        pixels[0][2] = x < sizeX - 1 && y >= 1 ? this.getValue(x + 1, y - 1) : EMPTY;

        pixels[1][0] = x >= 1 && y >= 0 ? this.getValue(x - 1, y) : EMPTY;
        pixels[1][1] = x >= 0 && y >= 0 ? this.getValue(x, y) : EMPTY;
        pixels[1][2] = x < sizeX - 1 && y >= 0 ? this.getValue(x + 1, y) : EMPTY;

        pixels[2][0] = x >= 1 && y < sizeY - 1 ? this.getValue(x - 1, y + 1) : EMPTY;
        pixels[2][1] = x >= 0 && y < sizeY - 1 ? this.getValue(x, y + 1) : EMPTY;
        pixels[2][2] = x < sizeX - 1 && y < sizeY - 1 ? this.getValue(x + 1, y + 1) : EMPTY;
        return pixels;
    }

    /**
     * Reduce size of matrix2d to n-times on axis x and y by selecting every nx-element
     * @param nx
     * @return
     */
    public Matrix2d reduce(int nx){
        int resizedX = this.sizeX/nx;
        int resizedY = this.sizeY/nx;
        Matrix2d m2d = new Matrix2d(resizedX, resizedY);
        for(int j = 0; j<resizedY; j++){
            for(int i = 0; i<resizedX; i++){
                m2d.setValue(i, j, this.getValue(i*nx, j*nx) );
            }
        }
        return m2d;
    }

//    /**
//     * Reduce size of matrix2d to 1x2-times on axis x and y by count from neighbors
//     * @return
//     */
//    public Matrix2d Convolute1x2(){
//        int[][] pixels;
//        int a, r, g, b;
//        int x = this.sizeX>>1;
//        int y = this.sizeY>>1;
//        Matrix2d m2d = new Matrix2d(x, y);
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                pixels = this.get2x2(i*2, j*2);
//                a = (pixels[0][0].a + pixels[0][1].a + pixels[1][0].a + pixels[1][1].a)/4;
//                r = (pixels[0][0].r + pixels[0][1].r + pixels[1][0].r + pixels[1][1].r)/4;
//                g = (pixels[0][0].g + pixels[0][1].g + pixels[1][0].g + pixels[1][1].g)/4;
//                b = (pixels[0][0].b + pixels[0][1].b + pixels[1][0].b + pixels[1][1].b)/4;
//                m2d.setValue(i, j, new ARGB(a, r, g, b));
//            }
//        }
//        return m2d;
//    }


//    public int getMiddleValue(int xPos, int yPos){
//        int xLeft, yLeft, xRight,yRight, xUp, yUp, xDown, yDown;
//        xLeft = xPos - 1;
//        yLeft = yPos;
//        xRight = xPos + 1;
//        yRight = yPos;
//        xUp = xPos;
//        yUp = yPos -1;
//        xDown = xPos;
//        yDown = yPos + 1;
//        int centerValue, leftValue, rightValue, upValue, downValue;
//        int leftUpValue, rightUpValue,leftDownValue, rightDownValue;
//        double middleValue;
//        centerValue = this.matrix[yPos][xPos];
//        leftValue = xLeft>=0 ? this.matrix[yLeft][xLeft]: 0;
//        rightValue = xRight<this.sizeX ? this.matrix[yRight][xRight]: 0;
//        upValue = yUp>=0 ? this.matrix[yUp][xUp]: 0;
//        downValue = yDown<this.sizeY ? this.matrix[yDown][xDown]: 0;
//
//        leftUpValue = xLeft>=0 &&  yUp>=0 ? this.matrix[yUp][xLeft]: 0;
//        rightUpValue = xRight<this.sizeX && yUp>=0 ? this.matrix[yUp][xRight]: 0;
//        leftDownValue = xLeft>=0 && yDown<this.sizeY ? this.matrix[yDown][xLeft]: 0;
//        rightDownValue = xRight<this.sizeX && yDown<this.sizeY ? this.matrix[yDown][xRight]: 0;
//
//        middleValue = (centerValue |
//                leftValue | rightValue | upValue | downValue |
//                leftUpValue | rightUpValue | leftDownValue | rightDownValue);
//        return (int)middleValue;
//    }
//
//    public boolean isEdgeValue(int xPos, int yPos){
//        int xLeft, yLeft, xRight,yRight, xUp, yUp, xDown, yDown;
//        xLeft = xPos - 1;
//        yLeft = yPos;
//        xRight = xPos + 1;
//        yRight = yPos;
//        xUp = xPos;
//        yUp = yPos -1;
//        xDown = xPos;
//        yDown = yPos + 1;
//        int centerValue, leftValue, rightValue, upValue, downValue;
//        int leftUpValue, rightUpValue,leftDownValue, rightDownValue;
//        double middleValue;
//        centerValue = this.matrix[yPos][xPos];
//        leftValue = xLeft>=0 ? this.matrix[yLeft][xLeft]: 0;
//        rightValue = xRight<this.sizeX ? this.matrix[yRight][xRight]: 0;
//        upValue = yUp>=0 ? this.matrix[yUp][xUp]: 0;
//        downValue = yDown<this.sizeY ? this.matrix[yDown][xDown]: 0;
//
//        leftUpValue = xLeft>=0 &&  yUp>=0 ? this.matrix[yUp][xLeft]: 0;
//        rightUpValue = xRight<this.sizeX && yUp>=0 ? this.matrix[yUp][xRight]: 0;
//        leftDownValue = xLeft>=0 && yDown<this.sizeY ? this.matrix[yDown][xLeft]: 0;
//        rightDownValue = xRight<this.sizeX && yDown<this.sizeY ? this.matrix[yDown][xRight]: 0;
//
//        return (centerValue & leftValue & rightValue & upValue & downValue &
//                leftUpValue & rightUpValue & leftDownValue & rightDownValue)==centerValue;
//    }
//
//    public void analyzeMatrix(){
//        int maxRed = 0;
//        int minRed = 255;
//        int maxGreen = 0;
//        int minGreen = 255;
//        int maxBlue = 0;
//        int minBlue = 255;
//        int pixel;
//        int red, green, blue;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                pixel = this.matrix[j][i];
//                red = (pixel >>> 16) & 0xFF;
//                green = (pixel >>> 8) & 0xFF;
//                blue = (pixel >>> 0) & 0xFF;
//
//                if(red > maxRed) maxRed = red;
//                if(red < minRed) minRed = red;
//                if(green > maxGreen) maxGreen = green;
//                if(green < minGreen) minGreen = green;
//                if(blue > maxBlue) maxBlue = blue;
//                if(blue< minBlue) minBlue = blue;
//            }
//        }
//        this.maxRedValue = maxRed;
//        this.minRedValue = minRed;
//        this.maxGreenValue = maxGreen;
//        this.minGreenValue = minGreen;
//        this.maxBlueValue = maxBlue;
//        this.minBlueValue = minBlue;
//    }


//    public int[] getData(){
//        int[] data = new int[sizeX*sizeY];
//        int n = 0;
//        for(int j=0; j<sizeY; j++){
//            for(int i=0;i<sizeX;i++){
//                n = j*sizeX + i;
//                data[n] = matrix[j][i];
//            }
//        }
//        return data;
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
//    public static ARGB middleColor(Matrix2d<ARGB> m2dArgb, int xStart, int yStart, int xFinish, int yFinish){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        int total = (yFinish-yStart)*(xFinish-xStart);
//        ARGB pixel;
//        int a = 0;
//        int r = 0;
//        int g = 0;
//        int b = 0;
//        for(int j = yStart; j<yFinish; j++){
//            for(int i = xStart; i<xFinish; i++){
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
//    public static ARGB middleColor(Matrix2d<ARGB> m2dArgb, Matrix2d<ARGB> m2dArgbMask, int xStart, int yStart, int xFinish, int yFinish){
//         int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        ARGB empty = new ARGB(0xff, 0, 0, 0);
//        ARGB mask = new ARGB(0xff, 255, 255, 255);
//        int total = 0;
//        ARGB p, pMask;
//        int a = 0;
//        int r = 0;
//        int g = 0;
//        int b = 0;
//        for(int j = yStart; j<yFinish; j++){
//            for(int i = xStart; i<xFinish; i++){
//                p = m2dArgb.getValue(i, j);
//                pMask = m2dArgbMask.getValue(i, j);
//                if(mask.a == pMask.a && mask.r == pMask.r && mask.g == pMask.g && mask.b == pMask.b) {
//                    a += p.a;
//                    r += p.r;
//                    g += p.g;
//                    b += p.b;
//                    total+=1;
//                }
//            }
//        }
//        return new ARGB(a/total, r/total, g/total, b/total);
//    }

//    public static Matrix2d<ARGB> argbPlusArgb(Matrix2d<ARGB> m2dArgb1, Matrix2d<ARGB> m2dArgb2){
//        int sizeX = m2dArgb1.sizeX;
//        int sizeY = m2dArgb1.sizeY;
//        int a, r, g, b;
//        ARGB p1, p2;
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                p1 = m2dArgb1.getValue(i, j);
//                p2 = m2dArgb2.getValue(i, j);
//                m2d.setValue(i, j, new ARGB((p1.a + p2.a)/2, (p1.r + p2.r)/2, (p1.g + p2.g)/2, (p1.b + p2.b)/2));
//            }
//        }
//        return m2d;
//    }
//
//    public static Matrix2d<ARGB> argbPlusArgb(Matrix2d<ARGB> m2dArgb1, Matrix2d<ARGB> m2dArgb2, Matrix2d<ARGB> m2dArgb3){
//        int sizeX = m2dArgb1.sizeX;
//        int sizeY = m2dArgb1.sizeY;
//        int a, r, g, b;
//        ARGB p1, p2, p3;
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                p1 = m2dArgb1.getValue(i, j);
//                p2 = m2dArgb2.getValue(i, j);
//                p3 = m2dArgb3.getValue(i, j);
//                m2d.setValue(i, j, new ARGB((p1.a + p2.a + p3.a)/2, (p1.r + p2.r + p3.r)/2, (p1.g + p2.g + p3.g)/2, (p1.b + p2.b + p3.b)/2));
//            }
//        }
//        return m2d;
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

//    public static Matrix2d<ARGB> rgbToGrey256(Matrix2d<ARGB> m2dArgb){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        Matrix2d<ARGB> rMatrix2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        int grey;
//        ARGB argb;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                argb = m2dArgb.getValue(i, j);
//                grey = (argb.b & argb.g & argb.r & 0xFF);
//                rMatrix2d.setValue(i, j, new ARGB(0xff, grey, grey, grey));
//            }
//        }
//        return rMatrix2d;
//    }
//
//    public static Matrix2d<ARGB> argbToGrey256(Matrix2d<ARGB> m2dArgb){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        Matrix2d<ARGB> rMatrix2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        int grey;
//        ARGB argb;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                argb = m2dArgb.getValue(i, j);
//                grey = (argb.b & argb.g & argb.r & 0xFF);
//                rMatrix2d.setValue(i, j, new ARGB(argb.a, grey, grey, grey));
//            }
//        }
//        return rMatrix2d;
//    }
//
//    public static Matrix2d<ARGB> argbToColorDiff(Matrix2d<ARGB> m2dArgb){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        ARGB empty = new ARGB(0x00, 0, 0, 0);
//        ARGB[][] pixels;
//        int a, r, g, b;
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                pixels = m2dArgb.get3x3(ARGB.class, i, j, empty);
//                a = pixels[1][1].a ^ (
//                        pixels[0][0].a + pixels[0][1].a + pixels[0][2].a +
//                        pixels[1][0].a +                  pixels[1][2].a +
//                        pixels[2][0].a + pixels[2][1].a + pixels[2][2].a)/8;
//                r = pixels[1][1].r ^ (
//                        pixels[0][0].r + pixels[0][1].r + pixels[0][2].r +
//                        pixels[1][0].r +                  pixels[1][2].r +
//                        pixels[2][0].r + pixels[2][1].r + pixels[2][2].r)/8;
//                g = pixels[1][1].g ^ (
//                        pixels[0][0].g + pixels[0][1].g + pixels[0][2].g +
//                        pixels[1][0].g +                  pixels[1][2].g +
//                        pixels[2][0].g + pixels[2][1].g + pixels[2][2].g)/8;
//                b = pixels[1][1].b ^ (
//                        pixels[0][0].b + pixels[0][1].b + pixels[0][2].b +
//                        pixels[1][0].b +                  pixels[1][2].b +
//                        pixels[2][0].b + pixels[2][1].b + pixels[2][2].b)/8;
//                m2d.setValue(i, j, new ARGB(a, r, g, b));
//            }
//        }
//        return m2d;
//    }
//
//    public static Matrix2d<ARGB> argbMinMax(Matrix2d<ARGB> m2dArgb, int aMin, int aMax, int rMin, int rMax, int gMin, int gMax, int bMin, int bMax){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        ARGB empty = new ARGB(0x00, 0, 0, 0);
//        ARGB edge = new ARGB(0xff, 255, 255, 255);
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        ARGB p;
//        for(int j = 0; j<sizeY; j++) {
//            for (int i = 0; i < sizeX; i++) {
//                p = m2dArgb.getValue(i, j);
//                if(p.a>=aMin && p.a<=aMax && p.r>=rMin && p.r<=rMax && p.g>=gMin && p.g<=gMax && p.b>=bMin && p.b<=bMax){
//                    //m2d.setValue(i, j, p);
//                    m2d.setValue(i, j, edge);
//                }else{
//                    m2d.setValue(i, j, empty);
//                }
//            }
//        }
//        return m2d;
//    }
//
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
//    public static Matrix2d<ARGB> argbToGrey2ByRChannel(Matrix2d<ARGB> m2dArgb, ARGB threshold){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        int iThreshold = threshold.r;
//        ARGB low = new ARGB(0xff, 0, 0, 0);
//        ARGB high = new ARGB(0xff, 255, 255, 255);
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        ARGB p;
//        int pThreshold;
//        for(int j = 0; j<sizeY; j++) {
//            for (int i = 0; i < sizeX; i++) {
//                p = m2dArgb.getValue(i, j);
//                pThreshold = p.r;
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
//    public static Matrix2d<ARGB> argbToGrey2ByGChannel(Matrix2d<ARGB> m2dArgb, ARGB threshold){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        int iThreshold = threshold.g;
//        ARGB low = new ARGB(0xff, 0, 0, 0);
//        ARGB high = new ARGB(0xff, 255, 255, 255);
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        ARGB p;
//        int pThreshold;
//        for(int j = 0; j<sizeY; j++) {
//            for (int i = 0; i < sizeX; i++) {
//                p = m2dArgb.getValue(i, j);
//                pThreshold = p.g;
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
//    public static Matrix2d<ARGB> argbToGrey2ByBChannel(Matrix2d<ARGB> m2dArgb, ARGB threshold){
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        int iThreshold = threshold.b;
//        ARGB low = new ARGB(0xff, 0, 0, 0);
//        ARGB high = new ARGB(0xff, 255, 255, 255);
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        ARGB p;
//        int pThreshold;
//        for(int j = 0; j<sizeY; j++) {
//            for (int i = 0; i < sizeX; i++) {
//                p = m2dArgb.getValue(i, j);
//                pThreshold = p.b;
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
//
//
//    public static Matrix2d<ARGB> argbToAlpha(Matrix2d<ARGB> source, ARGB color, int r){
//        int i, j, sizeX, sizeY;
//        ARGB pixel;
//        ARGB black = new ARGB(0x00, 0, 0, 0);
//        ARGB white = new ARGB(0xff, 255, 255, 255);
//        sizeX = source.sizeX;
//        sizeY = source.sizeY;
//        Matrix2d<ARGB> mask = new Matrix2d<ARGB>(ARGB.class, sizeX,sizeY);
//        // for every pixel of source make
//        for (j = 0; j < sizeY; j++) {
//            for (i = 0; i < sizeX; i++) {
//                pixel = source.getValue(i, j);
//                if ( Math.sqrt((color.r-pixel.r)^2+(color.g-pixel.g)^2+(color.b-pixel.b)^2)<r ) {
//                    // change color to mask;
//                    mask.setValue(i, j, white);
//                } else {
//                    //change to empty
//                    mask.setValue(i, j, black);
//                }
//            }
//        }
//        return mask;
//    }

//    public static Matrix2d<ARGB> matrix2dIntToMatrix2dArgb(Matrix2d<Int> matrix2dInt) {
//        int y = matrix2dInt.sizeY;
//        int x = matrix2dInt.sizeX;
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, x, y);
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                m2d.setValue( i, j, ElementConverter.intToArgb(matrix2dInt.getValue(i, j).value) );
//            }
//        }
//        return m2d;
//    }
//
//    public static Matrix2d<Int> matrix2dArgbToMatrix2dInt(Matrix2d<ARGB> matrix2dArgb) {
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

//    public static Matrix2d<ARGB> matrix2dArgbToColors256(Matrix2d<ARGB> matrix2dArgb){
//        int sizeX = matrix2dArgb.sizeX;
//        int sizeY = matrix2dArgb.sizeY;
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        int grey;
//        ARGB argb;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                argb = matrix2dArgb.getValue(i, j);
//                grey = (argb.b >>>  0) & 0xFF | (argb.g >>>  8) & 0xFF | (argb.r >>>  16) & 0xFF;
//                m2d.setValue(i, j, new ARGB( argb.a, grey, grey, grey) );
//            }
//        }
//        return m2d;
//    }

//    public static Matrix2d<ARGB> matrix2dArgbToColors8(Matrix2d<ARGB> matrix2dArgb){
//        int sizeX = matrix2dArgb.sizeX;
//        int sizeY = matrix2dArgb.sizeY;
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        int color;
//        ARGB argb;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                argb = matrix2dArgb.getValue(i, j);
//                color = (argb.b >>>  0) & 0xFF | (argb.g >>>  8) & 0xFF | (argb.r >>>  16) & 0xFF;
//                color=color>>5;
//                color=color<<5;
//                m2d.setValue(i, j, new ARGB(argb.a, color, color, color));
//            }
//        }
//        return m2d;
//    }

//    public static Matrix2d<ARGB> matrix2dArgbToColors4(Matrix2d<ARGB> matrix2dArgb){
//        int sizeX = matrix2dArgb.sizeX;
//        int sizeY = matrix2dArgb.sizeY;
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        int color;
//        ARGB argb;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                argb = matrix2dArgb.getValue(i, j);
//                color = (argb.b >>>  0) & 0xFF | (argb.g >>>  8) & 0xFF | (argb.r >>>  16) & 0xFF;
//                color/=64;
//                color*=64;
//                m2d.setValue(i, j, new ARGB(argb.a, color, color, color));
//            }
//        }
//        return m2d;
//    }

//    public static Matrix2d<ARGB> matrix2dArgbToColors2(Matrix2d<ARGB> matrix2dArgb){
//        int sizeX = matrix2dArgb.sizeX;
//        int sizeY = matrix2dArgb.sizeY;
//        Matrix2d<ARGB> m2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        int color;
//        ARGB argb;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                argb = matrix2dArgb.getValue(i, j);
//                color = (argb.b >>>  0) & 0xFF | (argb.g >>>  8) & 0xFF | (argb.r >>>  16) & 0xFF;
//                color/=128;
//                color*=128;
//                m2d.setValue(i, j, new ARGB(argb.a, color, color, color));
//            }
//        }
//        return m2d;
//    }

//    public static Matrix2d<ARGB> matrix2dArgbToColorsNxNxN(Matrix2d<ARGB> matrix2d, int N){
//        int sizeX = matrix2d.sizeX;
//        int sizeY = matrix2d.sizeY;
//        Matrix2d<ARGB> rMatrix2d = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY);
//        ARGB argb;
//        int red, green, blue;
//        int K = 256/N;
//        for(int j = 0; j<sizeY; j++){
//            for(int i = 0; i<sizeX; i++){
//                argb = matrix2d.getValue(i, j);
//                red = argb.r / K * K;
//                green = argb.g/K *K;
//                blue = argb.b/K*K;
//                rMatrix2d.setValue(i, j, new ARGB(argb.a, red, green, blue));
//            }
//        }
//        return rMatrix2d;
//    }

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
