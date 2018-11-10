package core.application.process;

import core.application.helper.ArgbToLab;
import core.application.algorithms.BaseAlgorithm;
import core.application.model.Model;
import core.application.dataElement.color.ARGB;
import core.application.dataElement.color.Lab;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.InputParamException;

/**
 * Created by anonymous on 30.10.2018.
 */
public class M2dArgbToM2dLab extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;
    public double[] whitePoint; // From Lab class constants

    public M2dArgbToM2dLab(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.whitePoint = Lab.whitePoint;
    }

    /**
     * Matrix2d<Argb> -> Matrix2d<Lab>
     * @return
     */
    @Override
    public TransformResults process() {
        Matrix2d<ARGB> in = this.model.matrix2dArgbList.get(this.inKey);
        Matrix2d<Lab> out = this.model.matrix2dLabList.get(this.outKey);
        TransformResults tr = new TransformResults();
        if(in!=null && out!=null) {
            tr = this.transform(in, out, this.whitePoint);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return tr;
    }

    /**
     * save matrix2d<ARGB> to Matrix2d<Lab>
     * @param in
     * @param out
     * @param whitePoint from Lab class
     * @return
     */
    public static TransformResults transform(Matrix2d<ARGB> in, Matrix2d<Lab> out, double[] whitePoint) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Lab value;
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = ArgbToLab.transform( in.getValue(i, j), whitePoint );
                out.setValue(i, j, value);
            }
        }
        return new TransformResults();
    }

}
