package core.application.process;

import core.application.algorithms.BaseAlgorithm;
import core.application.helper.LabToArgb;
import core.application.model.Model;
import core.application.dataElement.color.ARGB;
import core.application.dataElement.color.Lab;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.InputParamException;

/**
 * Created by anonymous on 30.10.2018.
 */
public class M2dLabToM2dArgb extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;
    public double[] whitePoint; // From Lab class constants
    TransformParams transformParams;

    public M2dLabToM2dArgb(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.whitePoint = Lab.whitePoint;
        this.transformParams = new TransformParams();
    }

    public M2dLabToM2dArgb(Model model, String inKey, String outKey, TransformParams transformParams) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.whitePoint = Lab.whitePoint;
        this.transformParams = transformParams;
    }

    /**
     * Matrix2d<Argb> -> Matrix2d<Lab>
     * @return
     */
    @Override
    public TransformResults process() {
        Matrix2d<Lab> in = this.model.matrix2dLabList.get(this.inKey);
        Matrix2d<ARGB> out = this.model.matrix2dArgbList.get(this.outKey);
        TransformResults tr = new TransformResults();
        if(in!=null && out!=null) {
            tr = this.transform(in, out, this.whitePoint, this.transformParams);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return tr;
    }

    /**
     * transform Matrix2d<Lab> to matrix2d<ARGB>
     * @param in
     * @param out
     * @param whitePoint from Lab class
     * @param params
     * @return
     */
    public static TransformResults transform(Matrix2d<Lab> in, Matrix2d<ARGB> out, double[] whitePoint, TransformParams params) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        ARGB value;
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = LabToArgb.transform( in.getValue(i, j), whitePoint );
                out.setValue(i, j, value);
            }
        }
        return new TransformResults();
    }

}
