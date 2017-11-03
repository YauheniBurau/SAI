package core.element;

/**
 * Created by anonymous on 03.10.2017.
 */
public class Color {
    public static final int ARGB_BLACK = 0x00000000;
    public static final int ARGB_WHITE = 0xffffffff;

    /**
     * convert Boolean color to int Color
     * @param value
     * @return
     */
    public static int booleanToInt(boolean value){
        int i = Color.ARGB_BLACK;
        if(value){ i = Color.ARGB_WHITE; }
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

}
