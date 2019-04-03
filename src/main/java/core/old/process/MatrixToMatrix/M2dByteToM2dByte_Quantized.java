package core.old.process.MatrixToMatrix;

import core.application.controller.AbstractAlgorithmFX;
import core.old.VertexValue.matrix.Matrix2dByte;
import core.old.process.PrimitiveToPrimitive.UnsignedIntToSignedByte;
import core.old.VertexValue.matrix.Matrix2d;

/**
 * Created by anonymous on 08.11.2018.
 */
public class M2dByteToM2dByte_Quantized extends AbstractAlgorithmFX {

    /**
     * Matrix2d<Byte> -> quantize values  in new Matrix2d<Byte>
     * @return
     */
    @Override
    public Boolean process() {
        return Boolean.TRUE;
    }

    /**
     * Matrix2d<Byte> -> quantize values  in new Matrix2d<Byte>
     * @param in
     * @return
     */
    public static Matrix2dByte transform(Matrix2d<Byte> in, int quantizeValue) {
        int n, k, i, j, x, y, currQuantizedValue;
        int[] values = new int[256];
        for(k = 0;k<256; k++){
            values[k] = 0;
        }
        byte value;
        y = in.sizeY;
        x = in.sizeX;
        Matrix2dByte out = new Matrix2dByte(x, y, null);
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
        return out;
    }

}