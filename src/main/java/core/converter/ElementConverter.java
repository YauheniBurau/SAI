package core.converter;

import core.element.ARGB;
import core.element.Int;

/**
 * Created by anonymous on 01.05.2017.
 */
public class ElementConverter {

    public static ARGB intToArgb(int value){
        int alpha, red, green, blue;
        alpha = (value >>> 24) & 0xff;
        red = (value >>> 16) & 0xff;
        green = (value >>> 8) & 0xff;
        blue = (value >>> 0) & 0xff;
        return new ARGB(alpha, red, green, blue);
    }

    public static Int argbToInt(ARGB value){
        int i = 0x00000000;
        i = i | value.a;
        i = i<<8 | value.r;
        i = i<<8 | value.g;
        i = i<<8 | value.b;
        return new Int(i);
    }

}
