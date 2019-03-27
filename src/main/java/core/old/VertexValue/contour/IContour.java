package core.old.VertexValue.contour;

import core.old.VertexValue.matrix.Matrix2dBool;

/**
 * Created by anonymous on 09.11.2018.
 */
public interface IContour {
    ContourParams countContourParams();
    Matrix2dBool toM2dBool();
}
