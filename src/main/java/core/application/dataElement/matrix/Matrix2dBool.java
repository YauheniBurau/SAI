package core.application.dataElement.matrix;

/**
 * Created by anonymous on 09.12.2018.
 */
public class Matrix2dBool extends Matrix2d<Boolean> {

    public Matrix2dBool(Class<Boolean> clazz) {
        super(Boolean.class);
    }

    public Matrix2dBool(int xSize, int ySize) {
        super(Boolean.class, xSize, ySize);
    }

    public Matrix2dBool(int xSize, int ySize, Boolean defaultValue) {
        super(Boolean.class, xSize, ySize, defaultValue);
    }

}
