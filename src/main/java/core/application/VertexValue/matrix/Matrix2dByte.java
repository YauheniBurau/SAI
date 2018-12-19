package core.application.VertexValue.matrix;

/**
 * Created by anonymous on 09.12.2018.
 */
public class Matrix2dByte extends Matrix2d<Byte> {

    public Matrix2dByte(){
        super(Byte.class);
    }

    public Matrix2dByte(int xSize, int ySize){
        super(Byte.class, xSize, ySize);
    }

    public Matrix2dByte(int xSize, int ySize, Byte defaultValue){
        super(Byte.class, xSize, ySize, defaultValue);
    }

}
