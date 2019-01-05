package core.application.VertexValue.cloud;

import core.application.VertexValue.coords.Decart2d;
import core.application.VertexValue.file.PngFile;
import core.application.VertexValue.matrix.Matrix2dBool;
import core.application.VertexValue.matrix.Matrix2dByte;
import core.application.graph.IVertexValue;
import core.application.graph.Vertex;
import core.application.process.CloudToMatrix.CloudOfDecart2dToM2dBool;
import core.application.process.CloudToMatrix.CloudOfDecart2dToM2dByte;
import core.application.process.MatrixToFile.M2dBooleanToPngFile;
import core.application.process.MatrixToFile.M2dByteToPngFile;
import core.application.process.PrimitiveToPrimitive.LongToHexString;

import java.util.ArrayList;

/**
 * Created by anonymous on 09.12.2018.
 */
public class CloudOfDecart2d extends Cloud<Decart2d> implements IVertexValue{
    private CloudParams params = new CloudParams();
    private CloudOfDecart2d outerCloud = null;
    private ArrayList<CloudOfDecart2d> innerClouds = null;

    /**
     * constructor
     */
    public CloudOfDecart2d() {
        super();
    }

    /**
     * constructor
     * @param elements
     */
    public CloudOfDecart2d(ArrayList<Decart2d> elements) {
        super(elements);
    }

    /**
     * count cloud params as max and min dimensions
     * @return
     */
    public CloudParams countCloudParams(){
        CloudParams params = new CloudParams();
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

    public double countWidth(){
        return this.params.eX - this.params.sX + 1;
    }

    public double countHeight(){
        return this.params.eY - this.params.sY + 1;
    }

    /**
     * cloud -> create Matrix2d where coordinates are shfited for the left and up values
     * @param cloud
     * @return
     */
    public static Matrix2dBool cloudToM2dShiftedMask(CloudOfDecart2d cloud){
        CloudParams cloudParams = cloud.params;
        int sizeX = (int)Math.ceil(cloudParams.eX - cloudParams.sX + 1);
        int sizeY = (int)Math.ceil(cloudParams.eY - cloudParams.sY + 1);
        Matrix2dBool m2d = new Matrix2dBool(sizeX, sizeY, false);
        int shiftLeft = (int)cloud.params.sX;
        int shiftUp = (int)cloud.params.sY;
        for(Decart2d p: cloud.elements) {
            m2d.setValue((int)p.x - shiftLeft, (int)p.y - shiftUp,true);
        }
        return m2d;
    }


    /**
     * Matrix2d where coordinates are shfited for the left and up values -> Cloud where coordinates are unshifted
     * @param m2dShiftedMask
     * @return
     */
    private static CloudOfDecart2d M2dShiftedMaskToCloud(Matrix2dBool m2dShiftedMask, int shiftX, int shiftY){
        CloudOfDecart2d outCloud = new CloudOfDecart2d();
        int sizeX = m2dShiftedMask.sizeX;
        int sizeY = m2dShiftedMask.sizeY;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                if(m2dShiftedMask.getValue(i, j)==true) {
                    outCloud.elements.add(new Decart2d(i+shiftX, j+shiftY));
                }
            }
        }
        return outCloud;
    }

//    /**
//     *
//     * @param m2dShiftedMask original mask with empty outer elements and inner elements
//     * @return Matrix2dBool as if OuterCloud
//     */
//    private static Matrix2dBool countM2dOuterMask(Matrix2dBool m2dShiftedMask) {
//        // find m2d with all separated inner segments
//        int sizeX = m2dShiftedMask.sizeX;
//        int sizeY = m2dShiftedMask.sizeY;
//        int i, j;
//        Matrix2dBool m2dOuterMask = new Matrix2dBool(m2dShiftedMask.sizeX, m2dShiftedMask.sizeY, null);
//        Boolean value;
//        for (j = 0; j < sizeY; j++) {
//            for (i = 0; i < sizeX; i++) {
//                value = m2dShiftedMask.getValue(i, j);
//                m2dOuterMask.setValue(i, j, value);
//            }
//        }
//        // ===== remove outer points =====
//        Boolean segmentValue;
//        ArrayList<Decart2d> segmentPoints;
//       // up horizontal line
//        j = 0;
//        for (i = 0; i < sizeX; i++) {
//            value = m2dOuterMask.getValue(i,j);
//            if( value!=null && value==false){
//                segmentPoints = m2dOuterMask.count4LSegmentPoints(i, j);
//                for (Decart2d p: segmentPoints) {
//                    // remove from matrix m2dInnerClouds as processed -> null
//                    m2dOuterMask.setValue((int)p.x, (int)p.y, null);
//                }
//            }
//        }
//        // down horizontal line
//        j = sizeY-1;
//        for (i = 0; i < sizeX; i++) {
//            value = m2dOuterMask.getValue(i,j);
//            if( value!=null && value==false){
//                segmentPoints = m2dOuterMask.count4LSegmentPoints(i, j);
//                for (Decart2d p: segmentPoints) {
//                    // remove from matrix m2dInnerClouds as processed -> null
//                    m2dOuterMask.setValue((int)p.x, (int)p.y, null);
//                }
//            }
//        }
//        // left vertical line
//        i = 0;
//        for (j = 0; j < sizeY; j++) {
//            value = m2dOuterMask.getValue(i,j);
//            if( value!=null && value==false){
//                segmentPoints = m2dOuterMask.count4LSegmentPoints(i, j);
//                for (Decart2d p: segmentPoints) {
//                    // remove from matrix m2dInnerClouds as processed -> null
//                    m2dOuterMask.setValue((int)p.x, (int)p.y, null);
//                }
//            }
//        }
//        // right vertical line
//        i = sizeX-1;
//        for (j = 0; j < sizeY; j++) {
//            value = m2dOuterMask.getValue(i,j);
//            if( value!=null && value==false){
//                segmentPoints = m2dOuterMask.count4LSegmentPoints(i, j);
//                for (Decart2d p: segmentPoints) {
//                    // remove from matrix m2dInnerClouds as processed -> null
//                    m2dOuterMask.setValue((int)p.x, (int)p.y, null);
//                }
//            }
//        }
//        // convert all false inner points to true points
//        for (j = 0; j < sizeY; j++) {
//            for (i = 0; i < sizeX; i++) {
//                value = m2dOuterMask.getValue(i, j);
//                if(m2dOuterMask.getValue(i, j)==null) {
//                    m2dOuterMask.setValue(i, j, false);
//                }else if(value==false) {
//                    m2dOuterMask.setValue(i, j, true);
//                }
//            }
//        }
//        return m2dOuterMask;
//    }

//    /**
//     *
//     * @return
//     */
//    public CloudOfDecart2d countOuterCloud() {
//        this.countCloudParams();
//        int shiftX = (int)this.params.sX;
//        int shiftY = (int)this.params.sY;
//        Matrix2dBool m2dShiftedMask = CloudOfDecart2d.cloudToM2dShiftedMask(this);
//        Matrix2dBool m2dOuterMask = CloudOfDecart2d.countM2dOuterMask(m2dShiftedMask);
//        this.outerCloud = CloudOfDecart2d.M2dShiftedMaskToCloud(m2dOuterMask, shiftX, shiftY);
//        return this.outerCloud;
//    }

//    /**
//     *
//     * @return ArrayList CloudOfDecart2dInt.
//     * @return
//     */
//    public ArrayList<CloudOfDecart2d> countInnerClouds() {
//        // find m2d with all separated inner segments
//        // prepare m2dInnerMask where only true - innerSegments and null - no point value
//        this.countCloudParams();
//        int shiftX = (int)this.params.sX;
//        int shiftY = (int)this.params.sY;
//        Matrix2dBool m2dOriginMask = CloudOfDecart2d.cloudToM2dShiftedMask(this);
//        Matrix2dBool m2dOuterMask = CloudOfDecart2d.countM2dOuterMask(m2dOriginMask);
//        Matrix2dBool m2dInnerMask = new Matrix2dBool(m2dOriginMask.sizeX, m2dOriginMask.sizeY, null);
//        int sizeX = m2dOriginMask.sizeX;
//        int sizeY = m2dOriginMask.sizeY;
//        int i, j;
//        for (j = 0; j < sizeY; j++) {
//            for (i = 0; i < sizeX; i++) {
//                if(m2dOriginMask.getValue(i, j)==false && m2dOuterMask.getValue(i, j)==true){
//                    m2dInnerMask.setValue(i,j, true);
//                }
//            }
//        }
//        // convert m2d of separated segments of true values -> ArrayList<CloudOfDecart2dInt>
//        this.innerClouds = new ArrayList<>();
//        CloudOfDecart2d innerCloud;
//        ArrayList<Decart2d> segmentPoints;
//        for(j = 0; j<m2dInnerMask.sizeY; j++){
//            for(i = 0; i<m2dInnerMask.sizeX; i++) {
//                if(m2dInnerMask.getValue(i,j)!=null){
//                    segmentPoints = m2dInnerMask.count4LSegmentPoints(i, j);
//                    for (Decart2d p: segmentPoints) {
//                        // remove from matrix m2dInnerClouds as processed
//                        m2dInnerMask.setValue((int)p.x, (int)p.y, null);
//                        // make points unshifted
//                        p.x = (p.x + shiftX);
//                        p.y = (p.y + shiftY);
//                    }
//                    innerCloud = new CloudOfDecart2d(segmentPoints);
//                    this.innerClouds.add(innerCloud);
//                }
//            }
//        }
//        return this.innerClouds;
//    }

    /**
     * getter
     * @return
     */
    public CloudParams getParams() {
        return params;
    }

    /**
     * getter
     * @return
     */
    public CloudOfDecart2d getOuterCloud() {
        return outerCloud;
    }

    /**
     * setter
     * @param outerCloud
     */
    public void setOuterCloud(CloudOfDecart2d outerCloud) {
        this.outerCloud = outerCloud;
    }

    /**
     * getter
     * @return
     */
    public ArrayList<CloudOfDecart2d> getInnerClouds() {
        return innerClouds;
    }

    /**
     * setter
     * @return
     */
    public void setInnerClouds(ArrayList<CloudOfDecart2d> clouds) {
        this.innerClouds = clouds;
    }

    /**
     * setter
     * @return
     */
    public boolean addInnerCloud(CloudOfDecart2d cloud) {
        return this.innerClouds.add(cloud);
    }

    /**
     * select all points from matrix by cloud and save nto file
     * @param uri
     * @param cloud
     * @param m2d
     */
    public static void saveCloud(String uri, CloudOfDecart2d cloud, Matrix2dByte m2d){
        Matrix2dByte out = CloudOfDecart2dToM2dByte.transform(cloud, m2d);
        M2dByteToPngFile.transform(out, new PngFile(uri) );
    }

    @Override
    public Boolean toHumanFile(Vertex vertex, String path) {
        this.countCloudParams();
        Matrix2dBool m2d = CloudOfDecart2dToM2dBool.transform(this);
        M2dBooleanToPngFile.transform(m2d, new PngFile(path + LongToHexString.transform( vertex.getuId() ) + ".png"));
        return true;
    }

    @Override
    public Boolean toDataFile(Vertex vertex, String path) {
        // TODO:
        return null;
    }

//    public Graph outerCloudToContourAsGraphDecart2d(){
//        this.countCloudParams();
//        Graph graph = null;
//        CloudOfDecart2d outerCloud = this.countOuterCloud();
//        Matrix2d<Decart2dInt2Links> m2d2Links = new Matrix2d<Decart2dInt2Links>(
//                Decart2dInt2Links.class, (int)outerCloud.countWidth(), (int)outerCloud.countHeight() );
//        Matrix2dBool m2dOuterMask = CloudOfDecart2d.cloudToM2dShiftedMask(outerCloud);
//        int sizeX = m2dOuterMask.sizeX;
//        int sizeY = m2dOuterMask.sizeY;
//        for (int j = 0; j < sizeY; j++) {
//            for (int i = 0; i < sizeX; i++) {
//                // TODO: create and connect all m2d2Links
//            }
//        }
//        // find first not null Decart2dInt2Links elements, it will be root of graph
//        graph = new Graph();
//        for (int j = 0; j < sizeY; j++) {
//            for (int i = 0; i < sizeX; i++) {
//                if(m2d2Links.getValue(i, j)!=null){
//                    graph.setRootVertex(new Vertex);
//                }
//            }
//        }
//
//        return graph;
//    }



}
