package core.element;

/**
 * Created by anonymous on 01.05.2017.
 */
public class ARGB{
    public final int a;
    public final int r;
    public final int g;
    public final int b;

    public ARGB(int alpha, int red, int green, int blue) {
        this.a = alpha;
        this.r = red;
        this.g = green;
        this.b = blue;
    }

    /**
     * convert ARGB to HSV
     * @return
     */
    public HSV toHsv(){
        int max, min, a, r, g, b, h, s, v;
        a = this.a;
        r = this.r;
        g = this.g;
        b = this.b;
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

}
