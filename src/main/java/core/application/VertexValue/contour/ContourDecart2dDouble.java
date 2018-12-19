package core.application.VertexValue.contour;

import core.application.VertexValue.coords.Decart2dDouble;
import core.application.VertexValue.file.PngFile;
import core.application.VertexValue.matrix.Matrix2dBool;
import core.application.graph.IVertexValue;
import core.application.graph.Vertex;
import core.application.process.ContourToMatrix.ContourDecart2dDoubleToM2dBool;
import core.application.process.MatrixToFile.M2dBooleanToPngFile;
import core.application.process.PrimitiveToPrimitive.LongToHexString;

/**
 * Created by anonymous on 14.12.2018.
 */
public class ContourDecart2dDouble extends Contour<Decart2dDouble> implements IVertexValue {
    private Contour2dParams contourParams = new Contour2dParams();

    /**
     * count cloud params as max and min dimensions
     * @return
     */
    private Contour2dParams countContourParams(){
        Contour2dParams params = new Contour2dParams();
        // 1. find shift by x and y
        params.left = Integer.MAX_VALUE; // left
        params.up = Integer.MAX_VALUE; // up
        params.right = Integer.MIN_VALUE; // right
        params.down = Integer.MIN_VALUE; // down
        for (Decart2dDouble p : this.elements) {
            if (p.x < params.left) params.left = p.x;
            if (p.y < params.up) params.up = p.y;
            if (p.x > params.right) params.right = p.x;
            if (p.y > params.down) params.down = p.y;
        }
        params.shiftX = 0;
        params.shiftY = 0;
        params.width = params.right - params.left + 1;
        params.height = params.down - params.up + 1;
        this.contourParams = params;
        return params;
    }


    @Override
    public Boolean toHumanFile(Vertex vertex, String path) {
        this.countContourParams();
        Matrix2dBool m2d = ContourDecart2dDoubleToM2dBool.transform(
                this, (int)this.contourParams.width, (int)this.contourParams.height);
        M2dBooleanToPngFile.transform(m2d, new PngFile(path + LongToHexString.transform( vertex.getuId() ) + ".png"));
        return true;
    }

    @Override
    public Boolean toDataFile(Vertex vertex, String path) {
        return null;
    }
}
