package core.application.VertexValue.color;

/**
 * Created by anonymous on 01.05.2017.
 */
public class ARGB implements IColor {

    public int a;
    public int r;
    public int g;
    public int b;

    public ARGB(int alpha, int red, int green, int blue) {
        this.a = alpha;
        this.r = red;
        this.g = green;
        this.b = blue;
    }

    public ARGB(int red, int green, int blue) {
        this.a = 0xff;
        this.r = red;
        this.g = green;
        this.b = blue;
    }

    public ARGB(int integerArgb) {
        int alpha, red, green, blue;
        alpha = (integerArgb >>> 24) & 0xff;
        red = (integerArgb >>> 16) & 0xff;
        green = (integerArgb >>> 8) & 0xff;
        blue = (integerArgb >>> 0) & 0xff;
        this.a = alpha;
        this.r = red;
        this.g = green;
        this.b = blue;
    }



//
//    public static ARGB countMiddle(ARGB p00, ARGB p01, ARGB p02,
//                                   ARGB p10, ARGB p11, ARGB p12,
//                                   ARGB p20, ARGB p21, ARGB p22){
//        int a, r, g, b;
//        a = (p00.a + p01.a + p02.a + p10.a + p11.a + p12.a + p20.a + p21.a + p22.a)/9;
//        r = (p00.r + p01.r + p02.r + p10.r + p11.r + p12.r + p20.r + p21.r + p22.r)/9;
//        g = (p00.g + p01.g + p02.g + p10.g + p11.g + p12.g + p20.g + p21.g + p22.g)/9;
//        b = (p00.b + p01.b + p02.b + p10.b + p11.b + p12.b + p20.b + p21.b + p22.b)/9;
//        return new ARGB(a, r, g, b);
//    }


}
