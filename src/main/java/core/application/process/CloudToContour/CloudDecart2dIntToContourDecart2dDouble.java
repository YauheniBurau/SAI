package core.application.process.CloudToContour;

import core.application.algorithms.BaseAlgorithm;
import core.application.VertexValue.cloud.CloudOfDecart2dInt;
import core.application.VertexValue.contour.ContourDecart2dDouble;
import core.application.VertexValue.coords.Decart2dDouble;
import core.application.VertexValue.coords.Decart2dInt;
import core.application.VertexValue.matrix.Matrix2d;
import core.application.VertexValue.matrix.Matrix2dBool;
import core.application.model.Model;

import java.util.LinkedList;

/**
 * Created by anonymous on 14.12.2018.
 */
public class CloudDecart2dIntToContourDecart2dDouble extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public CloudDecart2dIntToContourDecart2dDouble(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     * @param cloud
     * @return
     */
    public static ContourDecart2dDouble transform(CloudOfDecart2dInt cloud) {
        CloudOfDecart2dInt outerCloud = cloud.countOuterCloud();
        Matrix2dBool m2dBool = CloudOfDecart2dInt.cloudToM2dShiftedMask(outerCloud);
        int shiftX = outerCloud.getCloudParams().left;
        int shiftY = outerCloud.getCloudParams().up;
        int sizeX = m2dBool.sizeX;
        int sizeY = m2dBool.sizeY;
        Matrix2d<Decart2dDouble> m2dDecart2dDouble =
                new Matrix2d<Decart2dDouble>(Decart2dDouble.class, sizeX*2+1, sizeY*2+1, null);
        Matrix2dBool isProcessed =
                new Matrix2dBool(sizeX*2+1, sizeY*2+1, null);
        Boolean v1, v2, v4, v6, v8;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                v1 = m2dBool.getValue(i, j);
                if(v1 == true) {
                    v2 = m2dBool.getValue(i, j - 1);
                    v4 = m2dBool.getValue(i + 1, j);
                    v6 = m2dBool.getValue(i, j + 1);
                    v8 = m2dBool.getValue(i - 1, j);
                    if(v2==null || v2==false){ // up
                        m2dDecart2dDouble.setValue(i*2, j*2, new Decart2dDouble(i*2-0.5, j*2-0.5) );
                        m2dDecart2dDouble.setValue(i*2+1, j*2, new Decart2dDouble(i*2, j*2-0.5) );
                        m2dDecart2dDouble.setValue(i*2+2, j*2, new Decart2dDouble(i*2+0.5, j*2-0.5) );
                    }
                    if(v4==null || v4==false){ // right
                        m2dDecart2dDouble.setValue(i*2+2, j*2, new Decart2dDouble(i*2+0.5, j*2-0.5) );
                        m2dDecart2dDouble.setValue(i*2+2, j*2+1, new Decart2dDouble(i*2+0.5, j*2) );
                        m2dDecart2dDouble.setValue(i*2+2, j*2+2, new Decart2dDouble(i*2+0.5, j*2+0.5) );
                    }
                    if(v6==null || v6==false){ // down
                        m2dDecart2dDouble.setValue(i*2, j*2+2, new Decart2dDouble(i*2-0.5, j*2+0.5) );
                        m2dDecart2dDouble.setValue(i*2+1, j*2+2, new Decart2dDouble(i*2, j*2+0.5) );
                        m2dDecart2dDouble.setValue(i*2+2, j*2+2, new Decart2dDouble(i*2+0.5, j*2+0.5) );
                    }
                    if(v8==null || v8==false){ // left
                        m2dDecart2dDouble.setValue(i*2, j*2, new Decart2dDouble(i*2-0.5, j*2-0.5) );
                        m2dDecart2dDouble.setValue(i*2, j*2+1, new Decart2dDouble(i*2-0.5, j*2) );
                        m2dDecart2dDouble.setValue(i*2, j*2+2, new Decart2dDouble(i*2-0.5, j*2+0.5) );
                    }
                }
            }
        }
        // count contour
        sizeX = m2dBool.sizeX*2+1;
        sizeY = m2dBool.sizeY*2+1;
        // normalize contour decart coord -> make them unshifted.
        Decart2dDouble v;
        double x, y;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                v = m2dDecart2dDouble.getValue(i, j);
                if(v!=null){
                    m2dDecart2dDouble.setValue(i, j, new Decart2dDouble(v.x +shiftX, v.y +shiftY));
                }
            }
        }
        // find point of contour and count Contour circled or non circled
        v = null;
        Decart2dInt start = null;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                v = m2dDecart2dDouble.getValue(i, j);
                if(v!=null){
                    start = new Decart2dInt(i, j);
                    break;
                }
            }
            if(v!=null){
                break;
            }
        }
        ContourDecart2dDouble contour = new ContourDecart2dDouble();
        Decart2dDouble pD;
        LinkedList<Decart2dInt> contourCoords = null;
        if(start!=null){
            contourCoords = m2dDecart2dDouble.count4LContour(start.x, start.y);
        }
        if(contourCoords!=null){
            for(Decart2dInt pI: contourCoords){
                pD = m2dDecart2dDouble.getValue(pI.x, pI.y);
                contour.elements.add(pD);
            }
        }
        return contour;
    }

}
