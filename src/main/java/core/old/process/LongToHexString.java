package core.old.process;

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
            //throw new InputParamException("input Long must be not null");
        }
        return Long.toHexString(in);
    }
}
