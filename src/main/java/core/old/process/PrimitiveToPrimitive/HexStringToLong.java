package core.old.process.PrimitiveToPrimitive;

import core.application.exceptions.InputParamException;

/**
 * Created by anonymous on 17.12.2018.
 */
public class HexStringToLong {
    /**
     * @param in Hex String in format 0x[0..1,a-f]+
     * @return Long Value
     */
    public static Long transform(String in) {
        if( in == null ){
            throw new InputParamException("input HexString must be not null");
        }
        return Long.decode(in);
    }
}
