package core.application.process.CloudToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.dataElement.clouds.CloudOfDecart2dInt;
import core.application.dataElement.coords.Decart2dInt;
import core.application.dataElement.matrix.Matrix2dByte;
import core.application.model.Model;

/**
 * Created by anonymous on 10.12.2018.
 */
public class CloudOfDecart2dIntToM2dByte  extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public CloudOfDecart2dIntToM2dByte(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     *  Matrix2d<Byte> -> CloudOfDecart2dInt rootCoud and all subclouds as innerClouds
     * @param in
     * @return
     */
    public static Matrix2dByte transform(CloudOfDecart2dInt cloud, Matrix2dByte in) {
        // First stage Create RootCloud. RootCloud contains all points of "in" matrix
        int i, j;
        Matrix2dByte m2d = new Matrix2dByte(in.sizeX, in.sizeY, null);
        Byte value;
        for(Decart2dInt p: cloud.elements){
            value = in.getValue(p.x, p.y);
            m2d.setValue(p.x, p.y, value);
        }
        return m2d;
    }

}
