package core.converter;

import core.element.ARGB;
import core.element.HSV;

/**
 * Created by anonymous on 24.03.2018.
 */
public class ElementConverter {

    /**
     * convert Int ARGB to Boolean
     * @param value
     * @return
     */
    public static boolean intToBoolean(int value){
        return value <-1 ? false : true;
    }

    /**
     * convert Boolean color to int Color
     * @param value
     * @return
     */
    public static int booleanToInt(boolean value){
        int i =  0x00000000;
        if(value){ i = 0xffffffff; }
        return i;
    }

    /**
     * convert ARGB to int
     * @param value
     * @return
     */
    public static int argbToInt(ARGB value){
        int i = 0x00000000;
        i = i | value.a;
        i = i<<8 | value.r;
        i = i<<8 | value.g;
        i = i<<8 | value.b;
        return i;
    }

    /**
     * convert HSV to int
     * @param value
     * @return
     */
    public static int hsvToInt(HSV value){
        int i = 0x00000000;
        i = i | 0xff;
        i = i<<8 | value.h;
        i = i<<8 | value.s;
        i = i<<8 | value.v;
        return i;
    }

    /**
     * convert int ARGB into HSV
     * @param value
     * @return
     */
    public static HSV intToHsv(int value){
        return ElementConverter.argbToHsv( intToArgb(value) );
    }

    /**
     * convert int to ARGB
     * @param value
     * @return
     */
    public static ARGB intToArgb(int value){
        int alpha, red, green, blue;
        alpha = (value >>> 24) & 0xff;
        red = (value >>> 16) & 0xff;
        green = (value >>> 8) & 0xff;
        blue = (value >>> 0) & 0xff;
        return new ARGB(alpha, red, green, blue);
    }

    // TODO: correct this, I am not sure it's right transformation
    /**
     * convert ARGB to HSV
     * @return
     */
    public static HSV argbToHsv(ARGB in){
        int max, min, a, r, g, b, h, s, v;
        a = in.a;
        r = in.r;
        g = in.g;
        b = in.b;
        max = Math.max( Math.max(r, g), b );
        min = Math.min( Math.min(r, g), b );
        // Hue count
        if(min == max){ h = 0;}
        else if(max == r && g>=b){h = 60*(g-b)/(max-min)+0; }
        else if(max == r && g<b){h = 60*(g-b)/(max-min)+360; }
        else if(max == g){h = 60*(b-r)/(max-min)+120; }
        else if(max == b){h = 60*(r-g)/(max-min)+240; }
        else h = 0;
        // Saturation count
        if(max == 0 ){s = 0;}
        else{ s = (1-min/max)*255;}
        // Value count
        v = max;
        return new HSV(h, s, v);
    }

    // TODO: correct this
    /**
     * convert HSV to ARGB
     * @return
     */
    public static ARGB hsvToArgb(HSV in){
//        int max, min, h, s, v;
//        double r = 0, g = 0, b = 0;
//        h = in.h;
//        s = in.s;
//        v = in.v;
//        double i = Math.floor(h * 6);
//        double f = h * 6 - i;
//        double p = v * (1 - s);
//        double q = v * (1 - f * s);
//        double t = v * (1 - (1 - f) * s);
//
//        switch( (int)(i % 6)){
//            case 0: r = v; g = t; b = p; break;
//            case 1: r = q; g = v; b = p; break;
//            case 2: r = p; g = v; b = t; break;
//            case 3: r = p; g = q; b = v; break;
//            case 4: r = t; g = p; b = v; break;
//            case 5: r = v; g = p; b = q; break;
//        }
//        return new ARGB(255, (int)(r * 255), (int)(g * 255), (int)(b * 255) );
        return new ARGB(255, in.v, in.v, in.v );
    }


}
