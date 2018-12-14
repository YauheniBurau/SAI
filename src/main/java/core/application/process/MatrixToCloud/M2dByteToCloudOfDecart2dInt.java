package core.application.process.MatrixToCloud;

import core.application.algorithms.BaseAlgorithm;
import core.application.dataElement.clouds.CloudOfDecart2dInt;
import core.application.dataElement.coords.Decart2dInt;
import core.application.dataElement.matrix.Matrix2dBool;
import core.application.dataElement.matrix.Matrix2dByte;
import core.application.model.Model;

import java.util.ArrayList;

/**
 * Created by anonymous on 10.12.2018.
 */
public class M2dByteToCloudOfDecart2dInt extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public M2dByteToCloudOfDecart2dInt(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     * remark: only fulfilled clouds without gaps must come into function as "clouds" param
     *  Matrix2d<Byte> and Cloud -> ArrayList<CloudOfDecart2dInt>
     * @param in
     * @return
     */
    private static ArrayList<CloudOfDecart2dInt> transform(Matrix2dByte in, ArrayList<CloudOfDecart2dInt> clouds) {
        Matrix2dBool isProcessed = new Matrix2dBool(in.sizeX, in.sizeY, true);
        for(CloudOfDecart2dInt cl : clouds){
            cl.countOuterCloud();
            for(Decart2dInt p: cl.getOuterCloud().elements){
                isProcessed.setValue(p.x, p.y, false);
            }
        }
        //saveM2dBool(isProcessed);
        CloudOfDecart2dInt subCloud, outerCloud;
        ArrayList<CloudOfDecart2dInt> innerClouds;
        ArrayList<CloudOfDecart2dInt> newInnerClouds = new ArrayList<>();
        for(CloudOfDecart2dInt cloud: clouds){
            cloud.countOuterCloud();
            cloud.setInnerClouds(new ArrayList<>());
            for (Decart2dInt p : cloud.getOuterCloud().elements) {
                if (isProcessed.getValue(p.x, p.y) == false) {
                    subCloud = new CloudOfDecart2dInt( in.count4LSegment(p.x, p.y) );
                    outerCloud = subCloud.countOuterCloud();
                    innerClouds = subCloud.countInnerClouds();
                    // add new found subCloud to innerClouds of Cloud
                    cloud.addInnerCloud(subCloud);
                    // set all isProcessed from outerCloud
                    for(Decart2dInt p1 : outerCloud.elements) {
                        isProcessed.setValue(p1.x, p1.y, true);
                    }
                    //saveM2dBool(isProcessed);
                    // add all innerClouds to the list for next iteration processing
                    if(innerClouds.size()>0) {
                        newInnerClouds.addAll(innerClouds);
                    }
                }
            }

        }
        return newInnerClouds;
    }


    public static int cloud_uid = 0;
    /**
     *  Matrix2d<Byte> -> CloudOfDecart2dInt rootCoud and all subclouds as innerClouds
     * @param in
     * @return
     */
    public static CloudOfDecart2dInt transform(Matrix2dByte in) {
        ArrayList<CloudOfDecart2dInt> inClouds;
        ArrayList<CloudOfDecart2dInt> outClouds;
        int i, j;
        // First stage Create RootCloud. RootCloud contains all points of "in" matrix
        // Matrix2dBool isProcessed = new Matrix2dBool(in.sizeX, in.sizeY, false);
        CloudOfDecart2dInt rootCloud = new CloudOfDecart2dInt();
        for (j = 0; j < in.sizeY; j++) {
            for (i = 0; i < in.sizeX; i++) {
                if (in.getValue(i, j) != null) {
                    rootCloud.elements.add(new Decart2dInt(i, j));
                }
            }
        }
        // Second stage. Iteratively execute method for finding all subClouds, until number of returned subClouds > 0
        inClouds = new ArrayList<>();
        inClouds.add(rootCloud);
        while(inClouds.size()>0){
            outClouds = M2dByteToCloudOfDecart2dInt.transform(in, inClouds);
            inClouds = outClouds;
            for (CloudOfDecart2dInt cl: inClouds) {
                CloudOfDecart2dInt.saveCloud("E:\\temp\\out\\" + cloud_uid + "byte.png", cl, in);
                cloud_uid+=1;
            }

        }
        return rootCloud;
    }

}
