package core.element;

import core.element.ARGB;

/**
 * Created by anonymous on 20.09.2018.
 */
public class Matrix2dArgbSensor {
    public ARGB[][] matrix;
    public int sizeX;
    public int sizeY;

    public Matrix2dArgbSensor() {
        this.sizeX = 0;
        this.sizeY = 0;
        this.matrix = new ARGB[this.sizeX][this.sizeY];
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
    }


    public Matrix2dArgbSensor(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new ARGB[ySize][xSize];
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
    }

    public void setValue(int xPos, int yPos, ARGB value) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public ARGB getValue(int xPos, int yPos) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            return this.matrix[yPos][xPos];
        }
        return null;
    }

}
