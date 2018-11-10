package core.application.process;

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
    public TransformResults process() {
        Matrix2d<Lab> in = this.model.matrix2dLabList.get(this.inKey);
        Matrix2d<Byte> out = this.model.matrix2dByteList.get(this.outKey);
        TransformResults tr = new TransformResults();
        if(in!=null && out!=null) {
            switch(this.transformType) {
                case BY_L: { tr = this.transform1(in, out);
                    break;
                }
                case BY_A: { tr = this.transform2(in, out);
                    break;
                }
                case BY_B: { tr = this.transform3(in, out);
                    break;
                }
                default: {
                    throw new InputParamException("Wrong transformType param value transform not exists");
                }
            }
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return tr;
    }

    /**
     * transform Matrix2d<Lab> to matrix2d<Byte> where By L from Lab
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform1(Matrix2d<Lab> in, Matrix2d<Byte> out) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Byte value;
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedDoubleToSignedByte.transform(in.getValue(i, j).L);
                out.setValue(i, j, value);
            }
        }
        return new TransformResults();
    }

    /**
     * transform Matrix2d<Lab> to matrix2d<Byte> where By A from Lab
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform2(Matrix2d<Lab> in, Matrix2d<Byte> out) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Byte value;
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedDoubleToSignedByte.transform(in.getValue(i, j).a);
                out.setValue(i, j, value);
            }
        }
        return new TransformResults();
    }

    /**
     * transform Matrix2d<Lab> to matrix2d<Byte> where By B from Lab
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform3(Matrix2d<Lab> in, Matrix2d<Byte> out) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Byte value;
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedDoubleToSignedByte.transform(in.getValue(i, j).b);
                out.setValue(i, j, value);
            }
        }
        return new TransformResults();
    }

}
