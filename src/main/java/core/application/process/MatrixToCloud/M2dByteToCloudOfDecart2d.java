package core.application.process.MatrixToCloud;

import core.application.VertexValue.coords.Decart2d;
import core.application.algorithms.BaseAlgorithm;
import core.application.VertexValue.cloud.CloudOfDecart2d;
import core.application.VertexValue.matrix.Matrix2dBool;
import core.application.VertexValue.matrix.Matrix2dByte;
import core.application.model.Model;

import java.util.ArrayList;

/**
 * Created by anonymous on 10.12.2018.
 */
public class M2dByteToCloudOfDecart2d extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public M2dByteToCloudOfDecart2d(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

//    /**
//     * remark: only fulfilled cloud without gaps must come into function as "cloud" param
//     *  Matrix2d<Byte> and Cloud -> ArrayList<CloudOfDecart2dInt>
//     * @param in
//     * @return
//     */
//    private static ArrayList<CloudOfDecart2d> transform(Matrix2dByte in, ArrayList<CloudOfDecart2d> clouds) {
//        Matrix2dBool isProcessed = new Matrix2dBool(in.sizeX, in.sizeY, true);
//        for(CloudOfDecart2d cl : clouds){
//            cl.countOuterCloud();
//            for(Decart2d p: cl.getOuterCloud().elements){
//                isProcessed.setValue((int)p.x, (int)p.y, false);
//            }
//        }
//        //saveM2dBool(isProcessed);
//        CloudOfDecart2d subCloud, outerCloud;
//        ArrayList<CloudOfDecart2d> innerClouds;
//        ArrayList<CloudOfDecart2d> newInnerClouds = new ArrayList<>();
//        for(CloudOfDecart2d cloud: clouds){
//            cloud.countOuterCloud();
//            cloud.setInnerClouds(new ArrayList<>());
//            for (Decart2d p : cloud.getOuterCloud().elements) {
//                if (isProcessed.getValue((int)p.x, (int)p.y) == false) {
//                    subCloud = new CloudOfDecart2d( in.count4LSegmentPoints((int)p.x, (int)p.y) );
//                    outerCloud = subCloud.countOuterCloud();
//                    innerClouds = subCloud.countInnerClouds();
//                    // add new found subCloud to innerClouds of Cloud
//                    cloud.addInnerCloud(subCloud);
//                    // set all isProcessed from outerCloud
//                    for(Decart2d p1 : outerCloud.elements) {
//                        isProcessed.setValue((int)p1.x, (int)p1.y, true);
//                    }
//                    //saveM2dBool(isProcessed);
//                    // add all innerClouds to the list for next iteration processing
//                    if(innerClouds.size()>0) {
//                        newInnerClouds.addAll(innerClouds);
//                    }
//                }
//            }
//
//        }
//        return newInnerClouds;
//    }


//    public static int cloud_uid = 0;
//    /**
//     *  Matrix2d<Byte> -> CloudOfDecart2dInt rootCoud and all subclouds as innerClouds
//     * @param in
//     * @return
//     */
//    public static CloudOfDecart2d transform(Matrix2dByte in) {
//        ArrayList<CloudOfDecart2d> inClouds;
//        ArrayList<CloudOfDecart2d> outClouds;
//        int i, j;
//        // First stage Create RootCloud. RootCloud contains all points of "in" matrix
//        // Matrix2dBool isProcessed = new Matrix2dBool(in.sizeX, in.sizeY, false);
//        CloudOfDecart2d rootCloud = new CloudOfDecart2d();
//        for (j = 0; j < in.sizeY; j++) {
//            for (i = 0; i < in.sizeX; i++) {
//                if (in.getValue(i, j) != null) {
//                    rootCloud.elements.add(new Decart2d(i, j));
//                }
//            }
//        }
//        // Second stage. Iteratively execute method for finding all subClouds, until number of returned subClouds > 0
//        inClouds = new ArrayList<>();
//        inClouds.add(rootCloud);
//        while(inClouds.size()>0){
//            outClouds = M2dByteToCloudOfDecart2d.transform(in, inClouds);
//            inClouds = outClouds;
////            for (CloudOfDecart2dInt cl: inClouds) {
////                CloudOfDecart2dInt.saveCloud("E:\\temp\\out\\" + cloud_uid + "byte.png", cl, in);
////                cloud_uid+=1;
////            }
//        }
//        return rootCloud;
//    }

}
