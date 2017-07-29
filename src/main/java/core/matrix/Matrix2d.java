package core.matrix;

import core.element.ARGB;
import core.exceptions.FileException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
    public Matrix2d save(String urlFile, String format, int type) {
        BufferedImage image;
        int x, y;
        image = new BufferedImage(this.sizeX, this.sizeY, type);
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

    /**
     * average pixel from 3x3 around pixels
     * @return
     */
    public Matrix2d average(){
        Matrix2d m2d = new Matrix2d(this.sizeX, this.sizeY);
        int[][] m3x3 = null;
        int averaged = 0;
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++){
                m3x3 = this.get3x3(i, j);
                averaged = m3x3[0][0] | m3x3[0][1] | m3x3[0][2] |
                        m3x3[1][0] | m3x3[1][1] | m3x3[1][2] |
                        m3x3[2][0] | m3x3[2][1] | m3x3[2][2];
                m2d.setValue(i, j, averaged);
            }
        }
        return m2d;
    }

    /**
     * average pixel from 3x3 around pixels
     * @return
     */
    public Matrix2d edge(int r){
        int alpha, red, green, blue;
        Matrix2d m2d = new Matrix2d(this.sizeX, this.sizeY);
        int[][] m3x3 = null;
        int averaged, value;
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++){
                m3x3 = this.get3x3(i, j);
                averaged = m3x3[0][0] | m3x3[0][1] | m3x3[0][2] |
                        m3x3[1][0]         |         m3x3[1][2] |
                        m3x3[2][0] | m3x3[2][1] | m3x3[2][2];
                value = ((m3x3[1][1] >>> 24) & 0xff) - ((averaged >>> 24) & 0xff);
                alpha = Math.abs(value)<=r ? 0 : 255;
                value = ((m3x3[1][1] >>> 16) & 0xff) - ((averaged >>> 16) & 0xff);
                red = Math.abs(value)<=r ? 0 : 255;
                value = ((m3x3[1][1] >>> 8) & 0xff) - ((averaged >>> 8) & 0xff);
                green = Math.abs(value)<=r ? 0 : 255;
                value = ((m3x3[1][1] >>> 0) & 0xff) - ((averaged >>> 0) & 0xff);
                blue = Math.abs(value)<=r ? 0 : 255;
                value = (((((alpha << 8) + red) << 8) + green) << 8) + blue;
                m2d.setValue(i, j, value);
            }
        }
        return m2d;
    }

    public static final int ALPHA = 1;
    public static final int RED = 2;
    public static final int GREEN = 3;
    public static final int BLUE = 4;

    /**
     * average pixel from 3x3 around pixels
     * @return
     */
    public Matrix2d channel(int channel){
        int alpha, red, green, blue;
        Matrix2d m2d = new Matrix2d(this.sizeX, this.sizeY);
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++){
                if(channel == 1) m2d.setValue(i, j, ((this.getValue(i,j) >>> 24) & 0xff) );
                if(channel == 2) m2d.setValue(i, j, ((this.getValue(i,j) >>> 16) & 0xff) );
                if(channel == 3) m2d.setValue(i, j, ((this.getValue(i,j) >>> 8) & 0xff) );
                if(channel == 4) m2d.setValue(i, j, ((this.getValue(i,j) >>> 0) & 0xff) );
            }
        }
        return m2d;
    }

    public static Matrix2d and(Matrix2d m1, Matrix2d m2){
        int sizeX = m1.sizeX;
        int sizeY = m1.sizeY;
        Matrix2d m2d = new Matrix2d(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                m2d.setValue(i, j, m1.getValue(i,j) & m2.getValue(i,j) );
            }
        }
        return m2d;
    }

    public static Matrix2d and(Matrix2d m1, Matrix2d m2, Matrix2d m3){
        int sizeX = m1.sizeX;
        int sizeY = m1.sizeY;
        Matrix2d m2d = new Matrix2d(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                m2d.setValue(i, j, m1.getValue(i,j) & m2.getValue(i,j) & m3.getValue(i,j));
            }
        }
        return m2d;
    }

    // TODO: no protection against x<0, x>max, y<0, y>max
    /**
     * by chain find all near element with the same value
     * @param x
     * @param y
     * @return
     */
    public Matrix2d getShape(int x, int y){
        Queue<Point2d> fifo = new LinkedList<Point2d>();
        Point2d point;
        int up, right, down, left;
        Matrix2d m2d = new Matrix2d(this.sizeX, this.sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++){
                m2d.setValue(i, j, Matrix2d.EMPTY);
            }
        }
        int formValue = m2d.getValue(x, y);
        fifo.add(new Point2d(x,y));
        m2d.setValue(x, y, Matrix2d.WHITE);
        while(!fifo.isEmpty()){
            point = fifo.remove();
            // up
            up = this.getValue(point.x,point.y-1);
            if( up == formValue && m2d.getValue(point.x, point.y-1)==Matrix2d.EMPTY ){
                fifo.add(new Point2d(point.x, point.y-1));
                m2d.setValue(point.x, point.y-1, Matrix2d.WHITE);
            }else{
                m2d.setValue(point.x, point.y-1, Matrix2d.WHITE);
            }
            // right
            right = this.getValue(point.x+1,point.y);
            if( right == formValue && m2d.getValue(point.x+1, point.y)==Matrix2d.EMPTY ){
                fifo.add(new Point2d(point.x+1,point.y));
                m2d.setValue(point.x+1, point.y, Matrix2d.WHITE);
            }else{
                m2d.setValue(point.x+1,point.y, Matrix2d.WHITE);
            }
            // down
            down = this.getValue(point.x,point.y+1);
            if( down == formValue && m2d.getValue(point.x, point.y+1)==Matrix2d.EMPTY ){
                fifo.add(new Point2d(point.x,point.y+1));
                m2d.setValue(point.x, point.y+1, Matrix2d.WHITE);
            }else{
                m2d.setValue(point.x,point.y+1, Matrix2d.WHITE);
            }
            // left
            left = this.getValue(point.x-1,point.y);
            if( left == formValue && m2d.getValue(point.x-1, point.y)==Matrix2d.EMPTY ){
                fifo.add(new Point2d(point.x-1,point.y));
                m2d.setValue(point.x-1, point.y, Matrix2d.WHITE);
            }else{
                m2d.setValue(point.x-1,point.y, Matrix2d.WHITE);
            }
        }
        return m2d;
    }


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
}
