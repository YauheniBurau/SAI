package core.old.process;


/**
 * Created by anonymous on 28.10.2018.
 */
public class UnsignedDoubleToSignedByte {
    /**
     * transform Double to Byte
     * double must be in dipazon [0.0 .. 255.0]
     * @param value
     * @return
     */
    public static byte transform(double value){
        if(value>255 || value<0){
            //throw new InputParamException("input int must be in [0..255]");
        }
        return (byte)(value-128);
    }

}
