package core.old.process.ContourToMatrix;

import core.old.VertexValue.contour.ContourDecart2d;
import core.old.VertexValue.coords.Decart2d;
import core.application.controller.AbstractAlgorithmFX;
import core.old.VertexValue.matrix.Matrix2dBool;

/**
 * Created by anonymous on 16.12.2018.
 */
public class ContourDecart2dToM2dBool extends AbstractAlgorithmFX {

    /**
     *  ContourDecart2d -> Matrix2dBool
     * @param in Contour of Decart2d
     * @return
     */
    public static Matrix2dBool transform(ContourDecart2d in, int sizeX, int sizeY) {
        Matrix2dBool m2d = new Matrix2dBool(sizeX, sizeY, false);
        int x, y;
        for(Decart2d p: in.elements){
            x = (int)Math.round(p.x);
            y = (int)Math.round(p.y);
            m2d.setValue(x, y, true);
        }
        return m2d;
    }

    @Override
    public Boolean process() {
        return null;
    }
}
