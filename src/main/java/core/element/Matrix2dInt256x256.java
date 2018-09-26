package core.element;

/**
 * Created by anonymous on 21.09.2018.
 */
public class Matrix2dInt256x256 {
    private Integer[][] matrix;
    public final int sizeX = 256;
    public final int sizeY = 256;

    public Matrix2dInt256x256() {
        this.matrix = new Integer[this.sizeX][this.sizeY];
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
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
