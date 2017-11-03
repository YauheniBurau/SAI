package core.matrix;

/**
 * Created by anonymous on 05.10.2017.
 */
public class Matrix2dInt implements IMatrix2d<Integer> {
    private Integer[][] matrix;
    public final int sizeX;
    public final int sizeY;

    public Matrix2dInt(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new Integer[ySize][xSize];
    }

    public void setValue(int xPos, int yPos, Integer value) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public Integer getValue(int xPos, int yPos) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            return this.matrix[yPos][xPos];
        }
        return null;
    }
}
