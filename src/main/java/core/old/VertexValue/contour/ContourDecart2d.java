package core.old.VertexValue.contour;

import core.old.VertexValue.coords.Decart2d;
import core.old.VertexValue.file.PngFile;
import core.old.VertexValue.matrix.Matrix2dBool;
import core.old.process.MatrixToFile.M2dBooleanToPngFile;
import core.old.process.PrimitiveToPrimitive.LongToHexString;

/**
 * Created by anonymous on 20.12.2018.
 */
public class ContourDecart2d extends AbstractContour<Decart2d>{
    public ContourParams params = null;
    public Decart2d center = null;

    /**
     * Conture -> Conture Center as Decart2d
     * @return
     */
    public Decart2d countContourCenter(){
        int n = 0;
        double cx = 0;
        double cy = 0;
        for(Decart2d p: this.elements) {
            n +=1;
            cx += p.x;
            cy += p.y;
        }
        if(n>0) {
            cx /= n;
            cy /= n;
        }
        this.center = new Decart2d(cx, cy);
        return this.center;
    }

    /**
     * count size and dimension of contour edges
     * @return
     */
    @Override
    public ContourParams countContourParams(){
        ContourParams params = new ContourParams();
        // 1. find shift by x and y
        params.sX = Integer.MAX_VALUE;
        params.sY = Integer.MAX_VALUE;
        params.sZ = 0;
        params.eX = Integer.MIN_VALUE;
        params.eY = Integer.MIN_VALUE;
        params.eZ = 0;
        for (Decart2d p : this.elements) {
            if (p.x < params.sX) params.sX = p.x;
            if (p.y < params.sY) params.sY = p.y;
            if (p.x > params.eX) params.eX = p.x;
            if (p.y > params.eY) params.eY = p.y;
        }
        this.params = params;
        return this.params;
    }

    /**
     * implementaion from IContour
     * @return
     */
    @Override
    public Matrix2dBool toM2dBool() {
        ContourParams params = this.countContourParams();
        int sizeX = (int)Math.ceil(params.eX - params.sX + 1);
        int sizeY = (int)Math.ceil(params.eY - params.sY + 1);
        Matrix2dBool m2dMask = new Matrix2dBool(sizeX, sizeY, false);
        // TODO:
        return null;
    }

}
