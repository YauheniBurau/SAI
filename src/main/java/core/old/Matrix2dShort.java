package core.old;

import core.element.IMatrix2d;

/**
 * Created by anonymous on 06.10.2017.
 */
public class Matrix2dShort implements IMatrix2d<Short> {
    private Short[][] matrix;
    public final int sizeX;
    public final int sizeY;

    public Matrix2dShort(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new Short[ySize][xSize];
    }

    public void setValue(int xPos, int yPos, Short value) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public Short getValue(int xPos, int yPos) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            return this.matrix[yPos][xPos];
        }
        return null;
    }

}
