package core.old.process;

import core.old.VertexValue.color.ARGB;

/**
 * Created by anonymous on 28.10.2018.
 */
public class IntegerArgbToArgb {

    /**
     * transform Integer Argb -> ARGB
     * @param in Integer in format 0x[AA][rr][gg][bb]
     * @return
     */
    public static ARGB transform(Integer in){
        int alpha, red, green, blue;
        alpha = (in >>> 24) & 0xff;
        red = (in >>> 16) & 0xff;
        green = (in >>> 8) & 0xff;
        blue = (in >>> 0) & 0xff;
        return new ARGB(alpha, red, green, blue);
    }

}
