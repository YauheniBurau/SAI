package core.application.process.PrimitiveToPrimitive;

import core.application.exceptions.InputParamException;

/**
 * Created by anonymous on 17.12.2018.
 */
public class LongToHexString {
    /**
     * @param in Long Value
     * @return Hex String
     */
    public static String transform(Long in) {
        if( in == null ){
            throw new InputParamException("input Long must be not null");
        }
        return Long.toHexString(in);
    }
}
