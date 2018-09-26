package core.element;

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

    public Matrix2dBoolean binarizeByValue(int minValue, int maxValue){
        int v;
        Matrix2dBoolean m2dBool = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                v = this.getValue(i,j);
                if(v>=minValue && v<=maxValue){
                    m2dBool.setValue(i, j, true);
                }else{
                    m2dBool.setValue(i, j, false);
                }
            }
        }
        return m2dBool;
    }

}
