package core.old.process.PrimitiveToPrimitive;

/**
 * Created by anonymous on 10.11.2018.
 */
public class SignedIntToSignedByte {

    /**
     * transform signed int -> signed Byte
     * @param value
     * @return
     */
    public static byte transform(int value){
        if(value<-128 || value>127){
            //throw new InputParamException("input int must be in [-128..+127]");
        }
        return (byte)(value);
    }

}
