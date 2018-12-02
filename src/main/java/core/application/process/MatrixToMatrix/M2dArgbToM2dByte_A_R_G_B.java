package core.application.process.MatrixToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.helper.UnsignedIntToSignedByte;
import core.application.dataElement.color.ARGB;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.model.Model;

/**
 * Created by anonymous on 08.11.2018.
 */
public class M2dArgbToM2dByte_A_R_G_B extends BaseAlgorithm {
    public static final int BY_A = 0;
    public static final int BY_R = 1;
    public static final int BY_G = 2;
    public static final int BY_B = 3;

    private Model model;
    private String inKey;
    private String outKey;
    private int transformType;

    public M2dArgbToM2dByte_A_R_G_B(Model model, String inKey, String outKey, int transformType) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.transformType = transformType;
    }

    /**
     * Matrix2d<Argb> -> Matrix2d<Lab>
     * @return
     */
    @Override
    public Boolean process() {
        Matrix2d<ARGB> in = this.model.matrix2dArgbList.get(this.inKey);
        Matrix2d<Byte> out;
        if(in!=null) {
            switch(this.transformType) {
                case BY_A: { out = this.transform0(in);
                    break;
                }
                case BY_R: { out = this.transform1(in);
                    break;
                }
                case BY_G: { out = this.transform2(in);
                    break;
                }
                case BY_B: { out = this.transform3(in);
                    break;
                }
                default: {
                    throw new InputParamException("Wrong in and out params. At least one of them is null");
                }
            }
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        this.model.matrix2dByteList.put(this.outKey, out);
        return Boolean.TRUE;
    }

    /**
     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from A
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transform0(Matrix2d<ARGB> in) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null );
        byte value;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).a);
                out.setValue(i, j, value);
            }
        }
        return out;
    }

    /**
     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from R
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transform1(Matrix2d<ARGB> in) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null );
        byte value;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).r);
                out.setValue(i, j, value);
            }
        }
        return out;
    }

    /**
     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from G
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transform2(Matrix2d<ARGB> in) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null );
        byte value;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).g);
                out.setValue(i, j, value);
            }
        }
        return out;
    }

    /**
     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from B
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transform3(Matrix2d<ARGB> in) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null );
        byte value;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).b);
                out.setValue(i, j, value);
            }
        }
        return out;
    }

}
