package core.application.process.CloudToMatrix;

import core.application.VertexValue.coords.Decart2d;
import core.application.algorithms.BaseAlgorithm;
import core.application.VertexValue.cloud.CloudOfDecart2d;
import core.application.VertexValue.matrix.Matrix2dByte;
import core.application.model.Model;

/**
 * Created by anonymous on 10.12.2018.
 */
public class CloudOfDecart2dToM2dByte extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public CloudOfDecart2dToM2dByte(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     *  Matrix2d<Byte> -> CloudOfDecart2dInt rootCoud and all subclouds as innerClouds
     * @param in
     * @return
     */
    public static Matrix2dByte transform(CloudOfDecart2d cloud, Matrix2dByte in) {
        // First stage Create RootCloud. RootCloud contains all points of "in" matrix
        int i, j;
        Matrix2dByte m2d = new Matrix2dByte(in.sizeX, in.sizeY, null);
        Byte value;
        for(Decart2d p: cloud.elements){
            value = in.getValue((int)p.x, (int)p.y);
            m2d.setValue((int)p.x, (int)p.y, value);
        }
        return m2d;
    }

    @Override
    public Boolean process() {
        return null;
    }
}
