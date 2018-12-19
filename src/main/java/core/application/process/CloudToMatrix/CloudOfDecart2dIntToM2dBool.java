package core.application.process.CloudToMatrix;

import core.application.VertexValue.cloud.CloudOfDecart2dInt;
import core.application.VertexValue.matrix.Matrix2dBool;
import core.application.algorithms.BaseAlgorithm;
import core.application.model.Model;

/**
 * Created by anonymous on 19.12.2018.
 */
public class CloudOfDecart2dIntToM2dBool extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public CloudOfDecart2dIntToM2dBool(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     *  CloudOfDecart2dInt -> M2dBool
     * @param cloud
     * @return
     */
    public static Matrix2dBool transform(CloudOfDecart2dInt cloud) {
        Matrix2dBool m2d = CloudOfDecart2dInt.cloudToM2dShiftedMask(cloud);
        return m2d;
    }

}
