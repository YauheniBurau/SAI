package core.old.process.PrimitiveToPrimitive;

import core.application.exceptions.InputParamException;

/**
 * Created by anonymous on 28.10.2018.
 */
public class UnsignedIntToSignedByte {
    /**
     * transform unsigned Int [0..255] to signed Byte [-128, +127]
     * int must be in dipazon [0..255]
     * @param value
     * @return
     */
    public static byte transform(int value){
        if(value>255 || value<0){
            throw new InputParamException("input int must be in [0..255]");
        }
        return (byte)(value-128);
    }

}
