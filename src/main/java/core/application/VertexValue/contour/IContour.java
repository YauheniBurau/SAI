package core.application.VertexValue.contour;

import core.application.VertexValue.matrix.Matrix2dBool;

/**
 * Created by anonymous on 09.11.2018.
 */
public interface IContour {
    ContourParams countContourParams();
    Matrix2dBool toM2dBool();
}
