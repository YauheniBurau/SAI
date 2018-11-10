package core.application.process;

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
    public TransformResults process() {
        Matrix2d<ARGB> in = this.model.matrix2dArgbList.get(this.inKey);
        Matrix2d<Byte> out = this.model.matrix2dByteList.get(this.outKey);
        TransformResults tr = new TransformResults();
        if(in!=null && out!=null) {
            switch(this.transformType) {
                case BY_A: { tr = this.transform0(in, out);
                    break;
                }
                case BY_R: { tr = this.transform1(in, out);
                    break;
                }
                case BY_G: { tr = this.transform2(in, out);
                    break;
                }
                case BY_B: { tr = this.transform3(in, out);
                    break;
                }
                default: {
                    throw new InputParamException("Wrong in and out params. At least one of them is null");
                }
            }
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return tr;
    }

    /**
     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from A
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform0(Matrix2d<ARGB> in, Matrix2d<Byte> out) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        byte value;
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).a);
                out.setValue(i, j, value);
            }
        }
        return new TransformResults();
    }

    /**
     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from R
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform1(Matrix2d<ARGB> in, Matrix2d<Byte> out) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        byte value;
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).r);
                out.setValue(i, j, value);
            }
        }
        return new TransformResults();
    }

    /**
     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from G
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform2(Matrix2d<ARGB> in, Matrix2d<Byte> out) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        byte value;
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).g);
                out.setValue(i, j, value);
            }
        }
        return new TransformResults();
    }

    /**
     * save matrix2d<ARGB> to Matrix2d<Byte> where values are taken from B
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform3(Matrix2d<ARGB> in, Matrix2d<Byte> out) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        byte value;
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = UnsignedIntToSignedByte.transform(in.getValue(i, j).b);
                out.setValue(i, j, value);
            }
        }
        return new TransformResults();
    }

}
