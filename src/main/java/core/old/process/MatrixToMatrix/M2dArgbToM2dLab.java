package core.old.process.MatrixToMatrix;

import core.old.process.ColorToColor.ArgbToLab;
import core.application.controller.AbstractAlgorithmFX;
import core.old.Model;
import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.color.Lab;
import core.old.VertexValue.matrix.Matrix2d;
import core.application.exceptions.InputParamException;

/**
 * Created by anonymous on 30.10.2018.
 */
public class M2dArgbToM2dLab extends AbstractAlgorithmFX {
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
    public Boolean process() {
        Matrix2d<ARGB> in = this.model.matrix2dArgbList.get(this.inKey);
        Matrix2d<Lab> out;
        if(in!=null) {
            out = this.transform(in, this.whitePoint);
            this.model.matrix2dLabList.put(this.outKey, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     * save matrix2d<ARGB> to Matrix2d<Lab>
     * @param in
     * @param whitePoint from Lab class
     * @return
     */
    public static Matrix2d<Lab> transform(Matrix2d<ARGB> in, double[] whitePoint) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        Lab value;
        Matrix2d<Lab> out = new Matrix2d<Lab>(Lab.class, x, y, null);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = ArgbToLab.transform( in.getValue(i, j), whitePoint );
                out.setValue(i, j, value);
            }
        }
        return out;
    }

}
