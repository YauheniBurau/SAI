package core.application.process;

import core.application.algorithms.BaseAlgorithm;
import core.application.helper.UnsignedIntToSignedByte;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.model.Model;

/**
 * Created by anonymous on 08.11.2018.
 */
public class M2dByteToM2dByte_Quantized extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;
    private int quantizeValue; // [2..256]

    public M2dByteToM2dByte_Quantized(Model model, String inKey, String outKey, int quantizeValue) {
        if(quantizeValue<2 || quantizeValue>256){
            throw new InputParamException("Wrong quantizeValue param. it must be in [2..256]");
        }
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.quantizeValue = quantizeValue;
    }

    /**
     * Matrix2d<Byte> -> quantize values  in new Matrix2d<Byte>
     * @return
     */
    @Override
    public TransformResults process() {
        Matrix2d<Byte> in = this.model.matrix2dByteList.get(this.inKey);
        Matrix2d<Byte> out = this.model.matrix2dByteList.get(this.outKey);
        TransformResults tr = new TransformResults();
        if(in!=null && out!=null) {
            tr = this.transform(in, out, this.quantizeValue);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return tr;
    }

    /**
     * Matrix2d<Byte> -> quantize values  in new Matrix2d<Byte>
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform(Matrix2d<Byte> in, Matrix2d<Byte> out, int quantizeValue) {
        int n, k, i, j, x, y, currQuantizedValue;
        int[] values = new int[256];
        for(k = 0;k<256; k++){
            values[k] = 0;
        }
        byte value;
        y = in.sizeY;
        x = in.sizeX;
        out.setSizeXY(x, y);
        for( j = 0; j<y; j++){
            for( i = 0; i<x; i++) {
                value = in.getValue(i, j);
                values[value+128]+=1;
                out.setValue(i, j, value);
            }
        }
        // Count current quantized value
        currQuantizedValue = 0;
        for(k = 0;k<256; k++){
            if(values[k] > 0) currQuantizedValue+=1;
        }
        // quantize;
        int minValueIndex, maxValueIndex, closeValueIndex;
        byte oldValue, newValue;
        while(currQuantizedValue>quantizeValue){
            // find min and max value index of byte values occurrence
            maxValueIndex = 0;
            for(k = 0;k<256; k++){
                if(values[k] > values[maxValueIndex]) maxValueIndex = k;
            }
            minValueIndex = maxValueIndex;
            for(k = 0;k<256; k++){
                if(values[k]>0 &&  values[k]<values[minValueIndex]) minValueIndex = k;
            }
            // find closest value occurrence that more than minValueIndex
            closeValueIndex = minValueIndex;
            n = 0;
            while(values[minValueIndex]>=values[closeValueIndex]){
                n+=1;
                if( (closeValueIndex+n)<256 && values[minValueIndex]<=values[closeValueIndex+n] ){
                    closeValueIndex = minValueIndex+n;
                    break;
                }
                if( (closeValueIndex-n)>=0 && values[minValueIndex]<=values[closeValueIndex-n] ){
                    closeValueIndex = minValueIndex-n;
                    break;
                }
                if( (closeValueIndex+n)>255 && (closeValueIndex-n)<0 ){
                    break;
                }
            }
            // replace all minValue to closest higher value
            values[closeValueIndex] = values[closeValueIndex] + values[minValueIndex];
            values[minValueIndex] = 0;
            oldValue = UnsignedIntToSignedByte.transform(minValueIndex);
            newValue = UnsignedIntToSignedByte.transform(closeValueIndex);
            for( j = 0; j<y; j++){
                for( i = 0; i<x; i++) {
                    value = out.getValue(i, j);
                    if(value == oldValue) out.setValue(i, j, newValue);
                }
            }
            currQuantizedValue-=1;
        }
        return new TransformResults();
    }


}
