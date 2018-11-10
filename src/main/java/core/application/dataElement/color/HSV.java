package core.application.dataElement.color;

import core.application.dataElement.IDataElement;

/**
 * Created by anonymous on 01.05.2017.
 */
public class HSV implements IColor, IDataElement {
    public int h;
    public int s;
    public int v;

    public HSV(int hue, int saturation, int value) {
        this.h = hue;
        this.s = saturation;
        this.v = value;
    }

    // TODO: remove later
    //    public static HSV toClosestHighValue(HSV p00, HSV p01, HSV p02,
//                                   HSV p10, HSV p11, HSV p12,
//                                   HSV p20, HSV p21, HSV p22, int dist){
//        int v = p11.v;
//        HSV max = p11;
//        if( p00!=null && (v + dist)<p00.v && p00.v > max.v){
//            max = p00;
//        }else if( p01!=null && (v + dist)<p01.v && p01.v > max.v){
//            max = p01;
//        }else if( p02!=null && (v + dist)<p02.v && p02.v > max.v){
//            max = p02;
//        }else if( p10!=null && (v + dist)<p10.v && p10.v > max.v){
//            max = p10;
//        }else if( p12!=null && (v + dist)<p12.v && p12.v > max.v){
//            max = p12;
//        }else if( p20!=null && (v + dist)<p20.v && p20.v > max.v){
//            max = p20;
//        }else if( p21!=null && (v + dist)<p21.v && p21.v > max.v){
//            max = p21;
//        }else if( p22!=null && (v + dist)<p22.v && p22.v > max.v){
//            max = p22;
//        }
//        return new HSV(max.h, max.s, max.v);
//    }


}
