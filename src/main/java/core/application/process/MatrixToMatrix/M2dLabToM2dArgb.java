package core.application.process.MatrixToMatrix;

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

    public M2dLabToM2dArgb(Model model, String inKey, String outKey) {
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
    public Boolean process() {
        Matrix2d<Lab> in = this.model.matrix2dLabList.get(this.inKey);
        Matrix2d<ARGB> out;
        if(in!=null) {
            out = this.transform(in, this.whitePoint);
            this.model.matrix2dArgbList.put(this.outKey, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     * transform Matrix2d<Lab> to matrix2d<ARGB>
     * @param in
     * @param whitePoint from Lab class
     * @return
     */
    public static Matrix2d<ARGB> transform(Matrix2d<Lab> in, double[] whitePoint) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        ARGB value;
        Matrix2d<ARGB> out = new Matrix2d<ARGB>(ARGB.class, x, y, null);
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = LabToArgb.transform( in.getValue(i, j), whitePoint );
                out.setValue(i, j, value);
            }
        }
        return out;
    }

}