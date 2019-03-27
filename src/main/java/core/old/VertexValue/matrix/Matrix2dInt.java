package core.old.VertexValue.matrix;

/**
 * Created by anonymous on 08.12.2018.
 */
public class Matrix2dInt extends Matrix2d<Integer> {


    public Matrix2dInt() {
        super(Integer.class);
    }

    public Matrix2dInt(int xSize, int ySize) {
        super(Integer.class, xSize, ySize);
    }

    public Matrix2dInt(int xSize, int ySize, Integer defaultValue) {
        super(Integer.class, xSize, ySize, defaultValue);
    }

}
