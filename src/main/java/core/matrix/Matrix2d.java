package core.matrix;

import core.element.ARGB;
import core.element.BaseMatrixElement;

import java.lang.reflect.Array;

/**
 * Created by anonymous on 27.04.2017.
 */

public class Matrix2d<T extends BaseMatrixElement> {
    private T[][] matrix;
    public final int sizeX;
    public final int sizeY;

    public Matrix2d(Class<T> clazz, int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix =  (T[][]) Array.newInstance(clazz, ySize, xSize);
    }

    public void setValue(int xPos, int yPos, T value){
        this.matrix[yPos][xPos] = value;
    }

    public T getValue(int xPos, int yPos) {
        return this.matrix[yPos][xPos];
    }

    public T[][] get3x3(Class<T> clazz, int x, int y, T empty){
        int sizeX = this.sizeX;
        int sizeY = this.sizeY;
        T[][] pixels = (T[][])Array.newInstance(clazz, 3, 3);
        pixels[0][0] = x >= 1 && y >= 1 ? this.getValue(x - 1, y - 1) : empty;
        pixels[0][1] = x >= 0 && y >= 1 ? this.getValue(x, y - 1) : empty;
        pixels[0][2] = x < sizeX - 1 && y >= 1 ? this.getValue(x + 1, y - 1) : empty;

        pixels[1][0] = x >= 1 && y >= 0 ? this.getValue(x - 1, y) : empty;
        pixels[1][1] = x >= 0 && y >= 0 ? this.getValue(x, y) : empty;
        pixels[1][2] = x < sizeX - 1 && y >= 0 ? this.getValue(x + 1, y) : empty;

        pixels[2][0] = x >= 1 && y < sizeY - 1 ? this.getValue(x - 1, y + 1) : empty;
        pixels[2][1] = x >= 0 && y < sizeY - 1 ? this.getValue(x, y + 1) : empty;
        pixels[2][2] = x < sizeX - 1 && y < sizeY - 1 ? this.getValue(x + 1, y + 1) : empty;
        return pixels;
    }

    public T[][] get2x2(Class<T> clazz, int x, int y, T empty){
        int sizeX = this.sizeX;
        int sizeY = this.sizeY;
        T[][] pixels = (T[][])Array.newInstance(clazz, 2, 2);
        pixels[0][0] = x >= 0 && y >= 0 ? this.getValue(x, y) : empty;
        pixels[0][1] = x < sizeX - 1 && y >=0 ? this.getValue(x+1, y) : empty;
        pixels[1][0] = x >= 0 && y < sizeY - 1 ? this.getValue(x, y + 1) : empty;
        pixels[1][1] = x < sizeX - 1 && y < sizeY - 1 ? this.getValue(x + 1, y + 1) : empty;
        return pixels;
    }

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

}
