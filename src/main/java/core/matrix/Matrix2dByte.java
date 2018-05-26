package core.matrix;

import core.element.Point2d;

/**
 * Created by anonymous on 24.03.2018.
 */

/**
 * matrix of values byte[0.255]
 */
public class Matrix2dByte implements IMatrix2d<Byte> {
    private Byte[][] matrix;

    public final int sizeX;
    public final int sizeY;

    public Matrix2dByte(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new Byte[ySize][xSize];
    }

    public void setValue(int xPos, int yPos, Byte value) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public Byte getValue(int xPos, int yPos) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            return this.matrix[yPos][xPos];
        }
        return null;
    }



    @Deprecated
    /**
     * count center of weight
     * @return
     */
    public Point2d countCenterOfSymmetry(){
//        int x, y, n = 0, cx = 0, cy = 0;
//        y = this.sizeY;
//        x = this.sizeX;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                if( this.getValue(i, j)==true){
//                    n +=1;
//                    cx += i;
//                    cy += j;
//                }
//            }
//        }
//        if(n>0) {
//            cx /= n;
//            cy /= n;
//        }
//        return new Point2d(cx, cy);
        return null;
    }

}
