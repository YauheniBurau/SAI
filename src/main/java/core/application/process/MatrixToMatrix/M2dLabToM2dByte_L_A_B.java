package core.application.process.MatrixToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.helper.UnsignedDoubleToSignedByte;
import core.application.dataElement.color.Lab;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.model.Model;

/**
 * Created by anonymous on 31.10.2018.
 */
public class M2dLabToM2dByte_L_A_B extends BaseAlgorithm {
    public static final int BY_L = 1;
    public static final int BY_A = 2;
    public static final int BY_B = 3;

    private Model model;
    private String inKey;
    private String outKey;
    private int transformType;

    public M2dLabToM2dByte_L_A_B(Model model, String inKey, String outKey, int transformType) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.transformType = transformType;
    }

    /**
     * Matrix2d<Lab> -> Matrix2d<Byte> By Light from Lab
     * @return
     */
    @Override
    public Boolean process() {
        Matrix2d<Lab> in = this.model.matrix2dLabList.get(this.inKey);
        Matrix2d<Byte> out;
        if(in!=null) {
            switch(this.transformType) {
                case BY_L: { out = this.transformL(in);
                    break;
                }
                case BY_A: { out = this.transformA(in);
                    break;
                }
                case BY_B: { out = this.transformB(in);
                    break;
                }
                default: {
                    throw new InputParamException("Wrong transformType param value transformPoints not exists");
                }
            }
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        this.model.matrix2dByteList.put(this.outKey, out);
        return Boolean.TRUE;
    }

    /**
     * transformPoints Matrix2d<Lab> to matrix2d<Byte> where By L from Lab
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transformL(Matrix2d<Lab> in) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Byte value;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedDoubleToSignedByte.transform(in.getValue(i, j).L);
                out.setValue(i, j, value);
            }
        }
        return out;
    }

    /**
     * transformPoints Matrix2d<Lab> to matrix2d<Byte> where By A from Lab
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transformA(Matrix2d<Lab> in) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Byte value;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedDoubleToSignedByte.transform(in.getValue(i, j).a);
                out.setValue(i, j, value);
            }
        }
        return out;
    }

    /**
     * transformPoints Matrix2d<Lab> to matrix2d<Byte> where By B from Lab
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transformB(Matrix2d<Lab> in) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Byte value;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedDoubleToSignedByte.transform(in.getValue(i, j).b);
                out.setValue(i, j, value);
            }
        }
        return out;
    }

}
