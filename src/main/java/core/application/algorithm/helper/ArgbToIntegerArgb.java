package core.application.algorithm.helper;

import core.application.dataElement.color.ARGB;

/**
 * Created by anonymous on 28.10.2018.
 */
public class ArgbToIntegerArgb {

    /**
     * ARGB -> Integer argb
     * @param in
     * @return
     */
    public static int transform(ARGB in){
        int i = 0x00000000;
        i = i | in.a;
        i = i<<8 | in.r;
        i = i<<8 | in.g;
        i = i<<8 | in.b;
        return i;
    }

}
