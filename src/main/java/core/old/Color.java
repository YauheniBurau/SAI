package core.old;

import core.element.ARGB;
import core.element.HSV;

/**
 * Created by anonymous on 03.10.2017.
 */
public class Color {
    /**
     * get RGB and convert to brightness
     * @param value
     * @return
     */
    public static int argbToBrightness(ARGB value){
        return (int) (0.2126*value.r+0.7152*value.g+0.0722*value.b);
    }

    /**
     * in system xyz find color distance as distance between 2 point in decart coordinates
     * @param color1
     * @param color2
     * @return
     */
    public static int colorDistance(ARGB color1, ARGB color2){
        return (int) Math.sqrt( Math.pow(color1.r - color2.r,2)
                + Math.pow(color1.g - color2.g,2)
                + Math.pow(color1.b - color2.b,2) );
    }

    public static int colorDistance(HSV color1, HSV color2){
        return color1.v - color2.v;
    }
}
