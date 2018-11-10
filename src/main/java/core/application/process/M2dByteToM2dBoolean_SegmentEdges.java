package core.application.process;

import core.application.algorithms.BaseAlgorithm;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.model.Model;

/**
 * Created by anonymous on 31.10.2018.
 */
public class M2dByteToM2dBoolean_SegmentEdges extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;
    TransformParams transformParams;

    public M2dByteToM2dBoolean_SegmentEdges(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.transformParams = new TransformParams();
    }

    public M2dByteToM2dBoolean_SegmentEdges(Model model, String inKey, String outKey, TransformParams transformParams) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.transformParams = transformParams;
    }

    /**
     * Matrix2d<Byte> -> Matrix2d<Boolean> as Conture edges
     * @return
     */
    @Override
    public TransformResults process() {
        Matrix2d<Byte> in = this.model.matrix2dByteList.get(this.inKey);
        Matrix2d<Boolean> out = this.model.matrix2dBoolList.get(this.outKey);
        TransformResults tr = new TransformResults();
        if(in!=null && out!=null) {
            tr = this.transform(in, out, this.transformParams);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return tr;
    }

    /**
     * transform Matrix2d<Byte> -> Matrix2d<Boolean> as segment edges
     * @param in
     * @param out
     * @param params
     * @return
     */
    public static TransformResults transform(Matrix2d<Byte> in, Matrix2d<Boolean> out, TransformParams params) {
        Byte p00, p01, p02, p10, p11, p12, p20, p21, p22;
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        out.setSizeXY(x, y, false);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                p00 = in.getValue(i-1, j-1); if(p00 ==null) p00 = 0;
                p01 = in.getValue(i, j-1); if(p01 ==null) p01 = 0;
                p02 = in.getValue(i+1, j-1);  if(p02 ==null) p02 = 0;
                p10 = in.getValue(i-1, j);  if(p10 ==null) p10 = 0;
                p11 = in.getValue(i, j);  if(p11 ==null) p11 = 0;
                p12 = in.getValue(i+1, j);  if(p12 ==null) p12 = 0;
                p20 = in.getValue(i-1, j+1);  if(p20 ==null) p20 = 0;
                p21 = in.getValue(i, j+1);  if(p21 ==null) p21 = 0;
                p22 = in.getValue(i+1, j+1);  if(p22 ==null) p22 = 0;
                if( p11>p00 ){ out.setValue( i-1, j-1, true); }
                if( p11>p01 ){ out.setValue( i, j-1, true); }
                if( p11>p02 ){ out.setValue( i+1, j-1, true); }
                if( p11>p10 ){ out.setValue( i-1, j, true); }
                if( p11>p12 ){ out.setValue( i+1, j, true); }
                if( p11>p20 ){ out.setValue( i-1, j+1, true); }
                if( p11>p21 ){ out.setValue( i, j+1, true);}
                if( p11>p22 ){ out.setValue( i+1, j+1,true);}
            }
        }
        return new TransformResults();
    }


}
