package core.application.process.ContourToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.VertexValue.contour.ContourDecart2dDouble;
import core.application.VertexValue.coords.Decart2dDouble;
import core.application.VertexValue.matrix.Matrix2dBool;
import core.application.model.Model;

/**
 * Created by anonymous on 16.12.2018.
 */
public class ContourDecart2dDoubleToM2dBool extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public ContourDecart2dDoubleToM2dBool(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     *  ContourDecart2dDouble -> Matrix2dBool
     * @param in Contour of Decart2dDoublePoints
     * @return
     */
    public static Matrix2dBool transform(ContourDecart2dDouble in, int sizeX, int sizeY) {
        Matrix2dBool m2d = new Matrix2dBool(sizeX, sizeY, false);
        int x, y;
        for(Decart2dDouble p: in.elements){
            x = (int)Math.round(p.x);
            y = (int)Math.round(p.y);
            m2d.setValue(x, y, true);
        }
        return m2d;
    }

}