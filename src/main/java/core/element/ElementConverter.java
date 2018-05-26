package core.element;

/**
 * Created by anonymous on 24.03.2018.
 */
public class ElementConverter {

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
