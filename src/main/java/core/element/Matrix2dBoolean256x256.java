package core.element;

/**
 * Created by anonymous on 27.09.2018.
 */
public class Matrix2dBoolean256x256 {
    private boolean[][] matrix;
    public final int sizeX = 256;
    public final int sizeY = 256;

    public Matrix2dBoolean256x256() {
        this.matrix = new boolean[this.sizeY][this.sizeX];
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                this.setValue(i, j, false);
            }
        }
    }

    public void setValue(int xPos, int yPos, boolean value) {
        if (xPos >= 0 && xPos < this.sizeX && yPos >= 0 && yPos < this.sizeY) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public boolean getValue(int xPos, int yPos) {
        if (xPos >= 0 && xPos < this.sizeX && yPos >= 0 && yPos < this.sizeY) {
            return this.matrix[yPos][xPos];
        }
        return false;
    }

    /**
     * count number of not null elements
     * @return
     */
    public int countPoints(){
        int n = 0;
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                if(this.getValue(i, j)==true ){n++;}
            }
        }
        return n;
    }


}
