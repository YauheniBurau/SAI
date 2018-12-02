package core.application.process.MatrixToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.helper.SignedIntToSignedByte;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.model.Model;

/**
 * Created by anonymous on 10.11.2018.
 */
public class M2dByteToM2dByte_EdgeDiff  extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;

    public M2dByteToM2dByte_EdgeDiff(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     * Matrix2d<Byte> -> quantize values  in new Matrix2d<Byte>
     * @return
     */
    @Override
    public Boolean process() {
        Matrix2d<Byte> in = this.model.matrix2dByteList.get(this.inKey);
        Matrix2d<Byte> out;
        if(in!=null) {
            out = this.transform(in);
            this.model.matrix2dByteList.put(this.outKey, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     * Matrix2d<Byte> -> EdgeDiff values  in new Matrix2d<Byte>
     * @param in
     * @return
     */
    public static Matrix2d<Byte> transform(Matrix2d<Byte> in) {
        int newV, pi, pj, n, k, i, j, x, y;
        Byte v1, v2, v3, v4, v5, v6, v7, v8, v9, v;
        y = in.sizeY;
        x = in.sizeX;
        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null);
        for( j = 0; j<y; j++){
            for( i = 0; i<x; i++) {
                newV = 0;
                n = 0;
                pi = i;
                pj = j;
                v1 = in.getValue(pi, pj);
                v2 = in.getValue(pi, pj-1);
                v3 = in.getValue(pi+1, pj-1);
                v4 = in.getValue(pi+1, pj);
                v5 = in.getValue(pi+1, pj+1);
                v6 = in.getValue(pi, pj+1);
                v7 = in.getValue(pi-1, pj+1);
                v8 = in.getValue(pi-1, pj);
                v9 = in.getValue(pi-1, pj-1);
                if(v1!=null){
                    //if(v1!=null){ newV+=v1; n+=1; } // TODO: check
                    if(v2!=null){ newV+=v2; n+=1; }
                    if(v3!=null){ newV+=v3; n+=1; }
                    if(v4!=null){ newV+=v4; n+=1; }
                    if(v5!=null){ newV+=v5; n+=1; }
                    if(v6!=null){ newV+=v6; n+=1; }
                    if(v7!=null){ newV+=v7; n+=1; }
                    if(v8!=null){ newV+=v8; n+=1; }
                    if(v9!=null){ newV+=v9; n+=1; }
                    newV = (v1 - newV/n)/2;
                    v = SignedIntToSignedByte.transform(newV);
                    out.setValue(pi, pj, v);
                }else{
                    out.setValue(pi, pj, null);
                }
            }
        }
        return out;
    }

}
