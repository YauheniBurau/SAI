package core.application.dataElement.clouds;

import core.application.dataElement.coords.Decart2dInt;
import core.application.dataElement.file.PngFile;
import core.application.dataElement.matrix.Matrix2dBool;
import core.application.dataElement.matrix.Matrix2dByte;
import core.application.process.CloudToMatrix.CloudOfDecart2dIntToM2dByte;
import core.application.process.MatrixToFile.M2dByteToPngFile;

import java.util.ArrayList;

/**
 * Created by anonymous on 09.12.2018.
 */
public class CloudOfDecart2dInt extends Cloud<Decart2dInt>{
    private CloudOfDecart2dIntParams cloudParams = new CloudOfDecart2dIntParams();
    private CloudOfDecart2dInt outerCloud = null;
    private ArrayList<CloudOfDecart2dInt> innerClouds = null;

    /**
     * constructor
     */
    public CloudOfDecart2dInt() {
        super();
    }

    /**
     * constructor
     * @param elements
     */
    public CloudOfDecart2dInt(ArrayList<Decart2dInt> elements) {
        super(elements);
    }

    /**
     * count cloud params as max and min dimensions
     * @return
     */
    private CloudOfDecart2dIntParams countCloudParams(){
        CloudOfDecart2dIntParams params = new CloudOfDecart2dIntParams();
        // 1. find shift by x and y
        params.left = Integer.MAX_VALUE; // left
        params.up = Integer.MAX_VALUE; // up
        params.right = Integer.MIN_VALUE; // right
        params.down = Integer.MIN_VALUE; // down
        for (Decart2dInt p : this.elements) {
            if (p.x < params.left) params.left = p.x;
            if (p.y < params.up) params.up = p.y;
            if (p.x > params.right) params.right = p.x;
            if (p.y > params.down) params.down = p.y;
        }
        params.shiftX = 0;
        params.shiftY = 0;
        params.width = params.right - params.left + 1;
        params.height = params.down - params.up + 1;
        this.cloudParams = params;
        return params;
    }

    /**
     * cloud -> create Matrix2d where coordinates are shfited for the left and up values
     * @param cloud
     * @return
     */
    private static Matrix2dBool cloudToM2dShiftedMask(CloudOfDecart2dInt cloud){
        CloudOfDecart2dIntParams cloudParams = cloud.cloudParams;
        Matrix2dBool m2d = new Matrix2dBool(cloudParams.width, cloudParams.height, false);
        int shiftLeft = cloud.cloudParams.left;
        int shiftUp = cloud.cloudParams.up;
        for(Decart2dInt p: cloud.elements) {
            m2d.setValue(p.x - shiftLeft, p.y - shiftUp,true);
        }
        return m2d;
    }

    /**
     * Matrix2d where coordinates are shfited for the left and up values -> Cloud where coordinates are unshifted
     * @param m2dShiftedMask
     * @return
     */
    private static CloudOfDecart2dInt M2dShiftedMaskToCloud(Matrix2dBool m2dShiftedMask, int shiftX, int shiftY){
        CloudOfDecart2dInt outCloud = new CloudOfDecart2dInt();
        int sizeX = m2dShiftedMask.sizeX;
        int sizeY = m2dShiftedMask.sizeY;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                if(m2dShiftedMask.getValue(i, j)==true) {
                    outCloud.elements.add(new Decart2dInt(i+shiftX, j+shiftY));
                }
            }
        }
        return outCloud;
    }

    /**
     *
     * @param m2dShiftedMask original mask with empty outer elements and inner elements
     * @return Matrix2dBool as if OuterCloud
     */
    private static Matrix2dBool countM2dOuterMask(Matrix2dBool m2dShiftedMask) {
        // find m2d with all separated inner segments
        int sizeX = m2dShiftedMask.sizeX;
        int sizeY = m2dShiftedMask.sizeY;
        int i, j;
        Matrix2dBool m2dOuterMask = new Matrix2dBool(m2dShiftedMask.sizeX, m2dShiftedMask.sizeY, null);
        Boolean value;
        for (j = 0; j < sizeY; j++) {
            for (i = 0; i < sizeX; i++) {
                value = m2dShiftedMask.getValue(i, j);
                m2dOuterMask.setValue(i, j, value);
            }
        }
        // ===== remove outer points =====
        Boolean segmentValue;
        ArrayList<Decart2dInt> segmentPoints;
       // up horizontal line
        j = 0;
        for (i = 0; i < sizeX; i++) {
            value = m2dOuterMask.getValue(i,j);
            if( value!=null && value==false){
                segmentPoints = m2dOuterMask.count4LSegment(i, j);
                for (Decart2dInt p: segmentPoints) {
                    // remove from matrix m2dInnerClouds as processed -> null
                    m2dOuterMask.setValue(p.x, p.y, null);
                }
            }
        }
        // down horizontal line
        j = sizeY-1;
        for (i = 0; i < sizeX; i++) {
            value = m2dOuterMask.getValue(i,j);
            if( value!=null && value==false){
                segmentPoints = m2dOuterMask.count4LSegment(i, j);
                for (Decart2dInt p: segmentPoints) {
                    // remove from matrix m2dInnerClouds as processed -> null
                    m2dOuterMask.setValue(p.x, p.y, null);
                }
            }
        }
        // left vertical line
        i = 0;
        for (j = 0; j < sizeY; j++) {
            value = m2dOuterMask.getValue(i,j);
            if( value!=null && value==false){
                segmentPoints = m2dOuterMask.count4LSegment(i, j);
                for (Decart2dInt p: segmentPoints) {
                    // remove from matrix m2dInnerClouds as processed -> null
                    m2dOuterMask.setValue(p.x, p.y, null);
                }
            }
        }
        // right vertical line
        i = sizeX-1;
        for (j = 0; j < sizeY; j++) {
            value = m2dOuterMask.getValue(i,j);
            if( value!=null && value==false){
                segmentPoints = m2dOuterMask.count4LSegment(i, j);
                for (Decart2dInt p: segmentPoints) {
                    // remove from matrix m2dInnerClouds as processed -> null
                    m2dOuterMask.setValue(p.x, p.y, null);
                }
            }
        }
        // convert all false inner points to true points
        for (j = 0; j < sizeY; j++) {
            for (i = 0; i < sizeX; i++) {
                value = m2dOuterMask.getValue(i, j);
                if(m2dOuterMask.getValue(i, j)==null) {
                    m2dOuterMask.setValue(i, j, false);
                }else if(value==false) {
                    m2dOuterMask.setValue(i, j, true);
                }
            }
        }
        return m2dOuterMask;
    }

    /**
     *
     * @return
     */
    public CloudOfDecart2dInt countOuterCloud() {
        this.countCloudParams();
        int shiftX = this.cloudParams.left;
        int shiftY = this.cloudParams.up;
        Matrix2dBool m2dShiftedMask = CloudOfDecart2dInt.cloudToM2dShiftedMask(this);
        Matrix2dBool m2dOuterMask = CloudOfDecart2dInt.countM2dOuterMask(m2dShiftedMask);
        this.outerCloud = CloudOfDecart2dInt.M2dShiftedMaskToCloud(m2dOuterMask, shiftX, shiftY);
        return this.outerCloud;
    }

    /**
     *
     * @return ArrayList CloudOfDecart2dInt.
     * @return
     */
    public ArrayList<CloudOfDecart2dInt> countInnerClouds() {
        // find m2d with all separated inner segments
        // prepare m2dInnerMask where only true - innerSegments and null - no point value
        this.countCloudParams();
        int shiftX = this.cloudParams.left;
        int shiftY = this.cloudParams.up;
        Matrix2dBool m2dOriginMask = CloudOfDecart2dInt.cloudToM2dShiftedMask(this);
        Matrix2dBool m2dOuterMask = CloudOfDecart2dInt.countM2dOuterMask(m2dOriginMask);
        Matrix2dBool m2dInnerMask = new Matrix2dBool(m2dOriginMask.sizeX, m2dOriginMask.sizeY, null);
        int sizeX = m2dOriginMask.sizeX;
        int sizeY = m2dOriginMask.sizeY;
        int i, j;
        for (j = 0; j < sizeY; j++) {
            for (i = 0; i < sizeX; i++) {
                if(m2dOriginMask.getValue(i, j)==false && m2dOuterMask.getValue(i, j)==true){
                    m2dInnerMask.setValue(i,j, true);
                }
            }
        }
        // convert m2d of separated segments of true values -> ArrayList<CloudOfDecart2dInt>
        this.innerClouds = new ArrayList<>();
        CloudOfDecart2dInt innerCloud;
        ArrayList<Decart2dInt> segmentPoints;
        for(j = 0; j<m2dInnerMask.sizeY; j++){
            for(i = 0; i<m2dInnerMask.sizeX; i++) {
                if(m2dInnerMask.getValue(i,j)!=null){
                    segmentPoints = m2dInnerMask.count4LSegment(i, j);
                    for (Decart2dInt p: segmentPoints) {
                        // remove from matrix m2dInnerClouds as processed
                        m2dInnerMask.setValue(p.x, p.y, null);
                        // make points unshifted
                        p.setX(p.x + shiftX);
                        p.setY(p.y + shiftY);
                    }
                    innerCloud = new CloudOfDecart2dInt(segmentPoints);
                    this.innerClouds.add(innerCloud);
                }
            }
        }
        return this.innerClouds;
    }

    /**
     * getter
     * @return
     */
    public CloudOfDecart2dIntParams getCloudParams() {
        return cloudParams;
    }

    /**
     * getter
     * @return
     */
    public CloudOfDecart2dInt getOuterCloud() {
        return outerCloud;
    }

    /**
     * setter
     * @param outerCloud
     */
    public void setOuterCloud(CloudOfDecart2dInt outerCloud) {
        this.outerCloud = outerCloud;
    }

    /**
     * getter
     * @return
     */
    public ArrayList<CloudOfDecart2dInt> getInnerClouds() {
        return innerClouds;
    }

    /**
     * setter
     * @return
     */
    public void setInnerClouds(ArrayList<CloudOfDecart2dInt> clouds) {
        this.innerClouds = clouds;
    }

    /**
     * setter
     * @return
     */
    public boolean addInnerCloud(CloudOfDecart2dInt cloud) {
        return this.innerClouds.add(cloud);
    }

    /**
     * select all points from matrix by cloud and save nto file
     * @param uri
     * @param cloud
     * @param m2d
     */
    public static void saveCloud(String uri, CloudOfDecart2dInt cloud, Matrix2dByte m2d){
        Matrix2dByte out = CloudOfDecart2dIntToM2dByte.transform(cloud, m2d);
        M2dByteToPngFile.transform(out, new PngFile(uri) );
    }

}
