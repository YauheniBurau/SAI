package core.application.VertexValue.segments;


import core.application.VertexValue.color.ARGB;
import core.application.VertexValue.contour.ContourParams;
import core.application.VertexValue.contour.IContour;
import core.application.VertexValue.file.PngFile;
import core.application.VertexValue.matrix.Matrix2d;
import core.application.VertexValue.matrix.Matrix2dBool;
import core.application.VertexValue.texture.ITexture;
import core.application.graph.IVertexValue;
import core.application.graph.Vertex;
import core.application.process.MatrixToFile.M2dArgbToPngFile;
import core.application.process.PrimitiveToPrimitive.LongToHexString;

import java.util.ArrayList;

/**
 * Created by anonymous on 09.11.2018.
 */
public class Segment2d implements ISegment, IVertexValue {
    public ITexture texture = null;
    public IContour outerContour = null;
    public ArrayList<IContour> innerContours = new ArrayList<>();

    public Segment2d() {

    }

    public Segment2d(ITexture texture, IContour outerContour, ArrayList<IContour> innerContours) {
        this.texture = texture;
        this.outerContour = outerContour;
        this.innerContours = innerContours;
    }


    @Override
    public Boolean toHumanFile(Vertex vertex, String path) {
        ContourParams params = outerContour.countContourParams();
        int sizeX = (int)Math.ceil(params.eX - params.sX);
        int sizeY = (int)Math.ceil(params.eY - params.sY);
        Matrix2d<ARGB> m2dArgb = new Matrix2d<ARGB>(ARGB.class, sizeX, sizeY, new ARGB(0x00000000) );
        Matrix2dBool m2dMask = new Matrix2dBool(sizeX, sizeY, false);
        Matrix2dBool m2dMaskOuter;
        Matrix2dBool m2dMaskInner;
        // TODO:
        M2dArgbToPngFile.transform(m2dArgb, new PngFile(path + LongToHexString.transform( vertex.getuId() ) + ".png"));
        return true;
    }

    @Override
    public Boolean toDataFile(Vertex vertex, String path) {
        return null;
    }

}
