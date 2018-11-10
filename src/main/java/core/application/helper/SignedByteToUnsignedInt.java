package core.application.helper;

/**
 * Created by anonymous on 28.10.2018.
 */
public class SignedByteToUnsignedInt {

    /**
     * transform signed Byte to Unsigned Int
     * @param value
     * @return
     */
    public static int transform(byte value){
        return(value+128);
    }

}
