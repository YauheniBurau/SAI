package core.old;

import core.application.VertexValue.color.ARGB;
import core.application.VertexValue.matrix.Matrix2d;
import javafx.scene.chart.XYChart;

// TODO: remove later
/**
 * Created by anonymous on 24.03.2018.
 */
public class Transformer {

    /**
     * count distance between ARGB values
     * @param in1
     * @param in2
     * @return
     */
    public static int countColorDistance(ARGB in1, ARGB in2) {
        int dist = 512;
        if (in1 != null && in2 != null) {
            dist = (int) Math.sqrt((in1.r - in2.r) * (in1.r - in2.r) + (in1.g - in2.g) * (in1.g - in2.g) + (in1.b - in2.b) * (in1.b - in2.b));
        }
        return dist;
    }



    // ================================ TYPES CONVERSION ===============================================

// TODO: important
//    /**
//     * ElementImage -> "ArrayList<Conture>"
//     * @param in
//     * @param out
//     * @return
//     */
//    public static ArrayList<Conture> transformPoints(Matrix2dGraph in, ArrayList<Conture> out){
//        ArrayList<Conture> contures = new ArrayList<Conture>();
//        Matrix2dBoolean isProcessed = new Matrix2dBoolean(in.sizeX, in.sizeY);
//        Conture c;
//        Graph g;
//        int x, y;
//        ArrayList<Graph> links;
//        for(int j = 0; j<in.sizeY; j++){
//            for(int i = 0; i<in.sizeX; i++){
//                if(in.getValue(i, j)!=null && isProcessed.getValue(i,j)==false){
//                    c = new Conture();
//                    // 1-st direction
//                    g = in.getValue(i, j);
//                    x = g.getPoint().x;
//                    y = g.getPoint().y;
//                    do{
//                        c.points.addLast(new Point(x, y) );
//                        isProcessed.setValue(x, y, true);
//                        links = g.getPoints();
//                        g = null;
//                        for (Graph link: links) {
//                            x = link.getPoint().x;
//                            y = link.getPoint().y;
//                            if( isProcessed.getValue(x,y)==false){
//                                g = link;
//                                break;
//                            }
//                        }
//                    }while(g!=null);
//                    // 2-nd direction
//                    c.points.removeFirst();
//                    g = in.getValue(i, j);
//                    x = g.getPoint().x;
//                    y = g.getPoint().y;
//                    do{
//                        c.points.addFirst(new Point(x, y) );
//                        isProcessed.setValue(x, y,true);
//                        links = g.getPoints();
//                        g = null;
//                        for (Graph link: links) {
//                            x = link.getPoint().x;
//                            y = link.getPoint().y;
//                            if( isProcessed.getValue(x,y)==false){
//                                g = link;
//                                break;
//                            }
//                        }
//                    }while(g!=null);
//                    contures.add(c);
//                }
//            }
//        }
//
//        return contures;
//    }



//    /**
//     * NormalizedPolarPoint -> polarPoint where a value ={0..360}; r value = {0..255}
//     * @param in
//     * @param out
//     * @return
//     */
//    public static PolarPoint transform(NormalizedPolarPoint in, PolarPoint out){
//        double a = 360.0 / 255.0 * (in.a + 128);
//        double r = (in.r +128);
//        return new PolarPoint(a, r);
//    }

//    /**
//     * PolarPoint where a value ={0..360}; r value = {0..255} -> Point2d where x and y ={-128..+127}
//     * @param in
//     * @param out
//     * @return
//     */
//    public static Point2d transformPoints(PolarPoint in, Point2d out){
//        int x = (int) Math.floor( (in.r * Math.cos(in.a * Math.PI / 180))/2 );
//        int y = (int) Math.floor( (in.r * Math.sin(in.a * Math.PI / 180))/2 );
//        return new Point2d(x, y);
//    }

//    /**
//     * NormalizedPolarPoint -> PolarPoint -> Point2d
//     * @param in
//     * @param out
//     * @return
//     */
//    public static Point2d transformPoints(NormalizedPolarPoint in, Point2d out){
//        PolarPoint pp = null;
//        pp = Transformer.transformPoints(in, pp);
//        Point2d p2d = null;
//        p2d = Transformer.transformPoints(pp, p2d);
//        return p2d;
//    }

//    /**
//     * NormalizedPolarConture -> transformPoints to Matrix2dBoolean as picture
//     * @param in
//     * @param out
//     * @return
//     */
//    public static Matrix2dBoolean transformPoints(NormalizedPolarConture in, Matrix2dBoolean out) {
//        Matrix2dBoolean m2d = new Matrix2dBoolean(256, 256);
//        // draw contureLine in Matrix
//        NormalizedPolarPoint nppFirst, nppLast, npp1, npp2;
//        nppFirst = in.points.get(0);
//        nppLast = in.points.get(0);
//        npp1 = nppFirst;
//        Point2d p1 = null, p2 = null;
//        for (NormalizedPolarPoint npp: in.points){
//            npp2 = npp;
//            p1 = Transformer.transformPoints(npp1, p1);
//            p2 = Transformer.transformPoints(npp2, p2);
////            m2d.drawLine(p1.x+128, p1.y+128, p2.x+128, p2.y+128);
//            npp1 = npp2;
//            nppLast = npp2;
//        }
//        p1 = Transformer.transformPoints(nppFirst, p1);
//        p2 = Transformer.transformPoints(nppLast, p2);
////        m2d.drawLine(p1.x+128, p1.y+128, p2.x+128, p2.y+128);
//        return m2d;
//    }

    //    /**
//     * NormalizedPolarConture -> NormalizedPolarConture, where all cell under conture line are fullfilled
//     * @param in
//     * @param out
//     * @return
//     */
//    public static Matrix2dBoolean transformPoints(NormalizedPolarConture in, Matrix2dBoolean out) {
//        Matrix2dBoolean m2d = new Matrix2dBoolean(256, 256);
//        // draw contureLine in Matrix
//        NormalizedPolarPoint npp1, npp2;
//        npp1 = in.points.get(0);
//        for (NormalizedPolarPoint npp: in.points){
//            npp2 = npp;
//            if(Math.abs(npp1.a - npp2.a)>128){
//                // TODO: Make  it cicle from last coords to firstPoint of LinkedList
//            }
//            else{
//                m2d.drawLine(npp1.a+128, npp1.r+128, npp2.a+128, npp2.r+128);
//            }
//            npp1 = npp2;
//        }
//        // fulfill cells under conture line
//        boolean fill, prevValue, currValue;
//        for(int i=0; i<256; i++){
//            fill = false;
//            prevValue = m2d.getValue(i,255);
//            currValue = m2d.getValue(i,255);
//            for(int j=255; j>=0; j--) {
//                currValue = m2d.getValue(i,j);
//                if(prevValue == true && currValue == false) {
//                    fill = !fill;
//                }
//                if(currValue == false && fill == true){
//                    m2d.setValue(i, j, fill);
//                }
//                prevValue = currValue;
//            }
//        }
//        return m2d;
//    }


    // ====================================== JAVAFX ============================================
//    /**
//     * NormalizedPolarConture -> javafx.scene.chart.XYChart.Series
//     * @param in
//     * @param out
//     * @param seriesName
//     * @return
//     */
//    public static XYChart.Series transform(NormalizedPolarConture in, XYChart.Series out, String seriesName) {
//        XYChart.Series series = new XYChart.Series();
//        series.setName(seriesName);
//        //populating the series with data
//        for(NormalizedPolarPoint pp: in.points) {
//            series.getData().add(new XYChart.Data(pp.a, pp.r));
//        }
//        return series;
//    }

    // ===================================== COMPARE ============================================
//    /**
//     * Compare two NormalizedPolarConture -> and return double from 0..1 where 1.0 - %100 is equal contour
//     * @param in1
//     * @param in2
//     * @param out
//     * @return
//     */
//    public static Double transform(NormalizedPolarConture in1, NormalizedPolarConture in2, Double out) {
//        int n;
//        double dMin, d;
//        double sum = 0;
//        if(out == null) out = new Double(0.0);
//        for (NormalizedPolarPoint npp1: in1.points) {
//            dMin = 255;
//            for (NormalizedPolarPoint npp2: in2.points) {
//                //d = Math.sqrt((npp1.a - npp2.a)*(npp1.a - npp2.a) + (npp1.r - npp2.r)*(npp1.r - npp2.r));
//                d = (Math.abs(npp1.a - npp2.a) + Math.abs(npp1.r - npp2.r))/2;
//                if(d<dMin){
//                    dMin = d;
//                }
//            }
//            sum += dMin;
//        }
//        n = in1.points.size();
//        return sum/n;
//    }

//    /**
//     * Compare two Matrix2dBoolean -> and return ComparisonResult
//     * @param in1
//     * @param in2
//     * @return
//     */
//    public static void transform(Matrix2dBoolean in1, Matrix2dBoolean in2){
//        double nNotEqual = 0.0, nEqual = 0.0, nMax = in1.sizeX * in1.sizeY;
//        boolean v1, v2;
//        for (int j = 0; j < in1.sizeY; j++) {
//            for (int i = 0; i < in1.sizeX; i++) {
//                v1 = in1.getValue(i, j);
//                v2 = in2.getValue(i, j);
//                if(v1 == true && v2 == true) {
//                    nEqual += 1;
//                }
//                if(v1!=v2){
//                        nNotEqual+=1;
//                }
//            }
//        }
//        //ComparisonResult cr = new ComparisonResult();
//        //cr.form = nEqual/(nEqual + nNotEqual);
//        //return null;
//    }


//   /**
//     * transformPoints ARGB to HSV
//     * @return
//     */
//    public static HSV argbToHsv(ARGB in){
//        int delta, max, min, r, g, b, h, s, v;
//        r = in.r;
//        g = in.g;
//        b = in.b;
//        h = 0;
//        s = 0;
//        v = 0;
//        max = r > g?r:g;
//        max = max > b?max:b;
//        min = r < g?r:g;
//        min = min < b?min:b;
//        if(max == 0){
//                s = 0;
//                h = 360;
//        }else{
//            delta = max - min;
//            s = delta / max;
//            if(r == max) {
//                h = (g - b) / delta;
//            } else if(g == max) {
//                h = 2 + (b - r) / delta;
//            } else if(b == max) {
//                h = 4 + (r - g) / delta;
//            }
//
//            h *= 60;
//            if(h < 0) {
//                h += 360;
//            }
//        }
//        return new HSV(h, s, max);

//    double max, min, a, r, g, b, h, s, v;
//    a = in.a;
//    r = in.r;
//    g = in.g;
//    b = in.b;
//    max = Math.max( Math.max(r, g), b );
//    min = Math.min( Math.min(r, g), b );
//    // Hue count
//        if(min == max){ h = 0;}
//        else if(max == r && g>=b){h = 60*(g-b)/(max-min)+0; }
//        else if(max == r && g<b){h = 60*(g-b)/(max-min)+360; }
//        else if(max == g){h = 60*(b-r)/(max-min)+120; }
//        else if(max == b){h = 60*(r-g)/(max-min)+240; }
//        else h = 0;
//    // Saturation count
//        if(max == 0 ){s = 0;}
//        else{ s = (1-min/max)*255;}
//    // Value count
//    v = max;
//        return new HSV((int)h, (int)s, (int)v);
//
//    }

//    /**
//     * transformPoints HSV to ARGB
//     * @return
//     */
//    public static ARGB hsvToArgb(HSV in){
//        double delta, max, min, r, g, b, h, s, v;
//        h = in.h;
//        s = in.s;
//        v = in.v;
//        r = 0.0d;
//        g = 0.0d;
//        b = 0.0d;
//        if(s == 0.0d) {
////            if(!Double.isNaN(h)) {
////                String msg = "org.j3d.util.interpolator.ColorUtils.invalidHMsg";
////                throw new IllegalArgumentException(msg);
////            }
//            r = v;
//            g = v;
//            b = v;
//        } else {
//            if(h == 360.0d) {
//                h = 0.0d;
//            }
//
//            h /= 60;
//            int i = (int)Math.floor(h);
//            double f = h - i;
//            double p = v * (255 - s);
//            double q = v * (255 - s * f);
//            double t = v * (255 - s * (255 - f));
//            switch(i) {
//                case 0:
//                    r = v; g = t; b = p;
//                    break;
//                case 1:
//                    r = q; g = v; b = p;
//                    break;
//                case 2:
//                    r = p; g = v; b = t;
//                    break;
//                case 3:
//                    r = p; g = q; b = v;
//                    break;
//                case 4:
//                    r = t; g = p; b = v;
//                    break;
//                case 5:
//                    r = v; g = p; b = q;
//            }
//        }
//        return new ARGB(255, (int)r*255, (int)g*255, (int)b*255);
//    }


    // ==================== HSV to ARGB ======================
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



}