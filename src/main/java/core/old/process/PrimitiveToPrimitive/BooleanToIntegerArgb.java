package core.old.process.PrimitiveToPrimitive;

/**
 * Created by anonymous on 28.10.2018.
 */
public class BooleanToIntegerArgb {

    /**
     * Boolean -> ARGB
     * @param in
     * @return black color for boolean false, white color for boolean true
     */
    public static int transform(Boolean in){
        if(in == null){
            //throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        int v;
        if(in == false) v = 0xff000000;
        else v = 0xffffffff;
        return v;
    }

}
