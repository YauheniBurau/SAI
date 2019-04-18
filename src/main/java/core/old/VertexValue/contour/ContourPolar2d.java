package core.old.VertexValue.contour;

import core.old.VertexValue.coords.Polar2dByte;
import core.old.VertexValue.matrix.Matrix2dBool;

/**
 * Created by anonymous on 20.12.2018.
 * already normalized and quantized values to byte
 */
public class ContourPolar2d extends AbstractContour<Polar2dByte>{


    /**
     * 0..255 is full circle rotation
     * @param angle
     * @return
     */
    public ContourPolar2d centralRotate(int angle){
        for(Polar2dByte p: this.elements){
            p.centralRotate(angle);
        }
        return this;
    }

    @Override
    public ContourParams countContourParams() {
        return null;
    }

    @Override
    public Matrix2dBool toM2dBool() {
        return null;
    }

}
