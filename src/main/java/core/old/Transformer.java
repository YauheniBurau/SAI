package core.old;

import core.application.helper.UnsignedDoubleToSignedByte;
import core.application.dataElement.color.ARGB;
import core.application.dataElement.file.PngFile;
import core.application.dataElement.matrix.Matrix2d;
//import core.application.dataElement.points.Point2d;
import core.application.exceptions.FileException;
import javafx.scene.chart.XYChart;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 24.03.2018.
 */
public class Transformer {

    /**
     *
     * @param in
     * @param out
     * @param maxColorDiff
     * @param maxPercentImgDiff
     * @return
     */
    public static Matrix2dBoolean transform2(Matrix2d<ARGB> in, Matrix2d<ARGB> out, double maxColorDiff, double maxPercentImgDiff) {
        // 1-st stage
        int n = in.sizeX * in.sizeY;
        ARGB v, vMin, vMax;
        double a = 0, r = 0, g = 0, b = 0;
        int aMax = 0, rMax = 0, gMax = 0, bMax = 0;
        int aMin = 255, rMin = 255, gMin = 255, bMin = 255;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                v = in.getValue(i, j);
                if(v.a>aMax) aMax = v.a;
                if(v.r>rMax) rMax = v.r;
                if(v.g>gMax) gMax = v.g;
                if(v.b>bMax) bMax = v.b;
                a+=v.a;
                r+=v.r;
                g+=v.g;
                b+=v.b;
                if(v.a<aMin) aMin = v.a;
                if(v.r<rMin) rMin = v.r;
                if(v.g<gMin) gMin = v.g;
                if(v.b<bMin) bMin = v.b;
            }
        }
        v = new ARGB( (int)(a/n), (int)(r/n), (int)(g/b), (int)(b/n));
        vMax = new ARGB( aMax, rMax, gMax, bMax);
        vMin = new ARGB( aMin, rMin, gMin, bMin);
        System.out.println("v(" + v.a + ", " + v.r + ", " + v.g + ", " + v.b + ")");
        System.out.println("vMax(" + vMax.a + ", " + vMax.r + ", " + vMax.g + ", " + vMax.b + ")");
        System.out.println("vMin(" + vMin.a + ", " + vMin.r + ", " + vMin.g + ", " + vMin.b + ")");
        // 2-nd stage
        out.setSizeXY(in.sizeX, in.sizeY);
        int i, j, pi, pj;
        ARGB v1, v2, v3, v4, v5, v6, v7, v8, v9, newV;
        int minDist, dist;
        for(j = 0; j<in.sizeY; j++){
            for(i = 0; i<in.sizeX; i++){
                pi = i;
                pj = j;
                v1 = in.getValue(pi, pj);
                v2 = in.getValue(pi, pj-1);
                v3 = in.getValue(pi+1, pj-1);
                v4 = in.getValue(pi+1, pj);
                v5 = in.getValue(pi+1, pj+1);
                v6 = in.getValue(pi, pj+1);
                v7 = in.getValue(pi-1, pj+1);
                v8 = in.getValue(pi-1, pj);
                v9 = in.getValue(pi-1, pj-1);
                minDist = 512;
                newV = v1;
                dist = countColorDistance(v1, v2);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v2;
                }
                dist = countColorDistance(v1, v3);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v3;
                }
                dist = countColorDistance(v1, v4);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v4;
                }
                dist = countColorDistance(v1, v5);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v5;
                }
                dist = countColorDistance(v1, v6);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v6;
                }
                dist = countColorDistance(v1, v7);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v7;
                }
                dist = countColorDistance(v1, v8);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v8;
                }
                dist = countColorDistance(v1, v9);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v9;
                }
                in.setValue( i, j, new ARGB(newV.a, newV.r, newV.g, newV.b) );
            }
        }
        for(j = 0; j<in.sizeY; j++){
            for(i = 0; i<in.sizeX; i++) {
                v = in.getValue(i,j);
                out.setValue(i, j, new ARGB(v.a, v.r, v.g, v.b) );
            }
        }
        return null;
    }



    /**
     *
     * @param in
     * @param out
     * @param maxColorDiff
     * @param maxPercentImgDiff
     * @return
     */
    public static Matrix2dBoolean transform(Matrix2d<ARGB> in, Matrix2d<ARGB> out, double maxColorDiff, double maxPercentImgDiff) {
        // 1-st stage
        int n = in.sizeX * in.sizeY;
        ARGB v, vMin, vMax;
        double a = 0, r = 0, g = 0, b = 0;
        int aMax = 0, rMax = 0, gMax = 0, bMax = 0;
        int aMin = 255, rMin = 255, gMin = 255, bMin = 255;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                v = in.getValue(i, j);
                if(v.a>aMax) aMax = v.a;
                if(v.r>rMax) rMax = v.r;
                if(v.g>gMax) gMax = v.g;
                if(v.b>bMax) bMax = v.b;
                a+=v.a;
                r+=v.r;
                g+=v.g;
                b+=v.b;
                if(v.a<aMin) aMin = v.a;
                if(v.r<rMin) rMin = v.r;
                if(v.g<gMin) gMin = v.g;
                if(v.b<bMin) bMin = v.b;
            }
        }
        v = new ARGB( (int)(a/n), (int)(r/n), (int)(g/b), (int)(b/n));
        vMax = new ARGB( aMax, rMax, gMax, bMax);
        vMin = new ARGB( aMin, rMin, gMin, bMin);
        System.out.println("v(" + v.a + ", " + v.r + ", " + v.g + ", " + v.b + ")");
        System.out.println("vMax(" + vMax.a + ", " + vMax.r + ", " + vMax.g + ", " + vMax.b + ")");
        System.out.println("vMin(" + vMin.a + ", " + vMin.r + ", " + vMin.g + ", " + vMin.b + ")");
        // 2-nd stage
        out.setSizeXY(in.sizeX, in.sizeY);
        int i, j, pi, pj;
        ARGB v1, v2, v3, v4, v5, v6, v7, v8, v9, newV;
        int minDist, dist;
        for(j = 0; j<in.sizeY; j++){
            for(i = 0; i<in.sizeX; i++){
                pi = i;
                pj = j;
                v1 = in.getValue(pi, pj);
                v2 = in.getValue(pi, pj-1);
                v3 = in.getValue(pi+1, pj-1);
                v4 = in.getValue(pi+1, pj);
                v5 = in.getValue(pi+1, pj+1);
                v6 = in.getValue(pi, pj+1);
                v7 = in.getValue(pi-1, pj+1);
                v8 = in.getValue(pi-1, pj);
                v9 = in.getValue(pi-1, pj-1);
                minDist = 512;
                newV = v1;
                dist = countColorDistance(v1, v2);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v2;
                }
                dist = countColorDistance(v1, v3);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v3;
                }
                dist = countColorDistance(v1, v4);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v4;
                }
                dist = countColorDistance(v1, v5);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v5;
                }
                dist = countColorDistance(v1, v6);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v6;
                }
                dist = countColorDistance(v1, v7);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v7;
                }
                dist = countColorDistance(v1, v8);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v8;
                }
                dist = countColorDistance(v1, v9);
                if(dist>0 && dist<maxColorDiff && dist<minDist){
                    minDist = dist;
                    newV = v9;
                }
                out.setValue( i, j, new ARGB(newV.a, newV.r, newV.g, newV.b) );
            }
        }
        return null;
    }


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

    /**
     * count all different rgb colors
     * @param in
     * @return
     */
    public static int countMatrix2dArgbColorsNumber(Matrix2d<ARGB> in){
        int n = 0;
        int[][][] colors = new int[256][256][256];
        int ir, ig, ib;
        for(ir = 0; ir<256; ir++){
            for(ig = 0; ig<256; ig++){
                for(ib = 0; ib<256; ib++){
                    colors[ir][ig][ib] = 0;
                }
            }
        }
        ARGB v;
        int sizeX = in.sizeX;
        int sizeY = in.sizeY;
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++) {
                v = in.getValue(i, j);
                colors[v.r][v.g][v.b] +=1;
            }
        }
        for(ir = 0; ir<256; ir++){
            for(ig = 0; ig<256; ig++){
                for(ib = 0; ib<256; ib++){
                    if( colors[ir][ig][ib] != 0 ){
                        n+=1;
                    }
                }
            }
        }
        return n;
    }


    // ================================ TYPES CONVERSION ===============================================



//    /**
//     * find all coords images in Matrix2dByte
//     * @param maxDiff
//     * @return
//     */
//    public static ArrayList<ElementImage> transformPoints(Matrix2dByte in, ArrayList<ElementImage> out, int maxDiff) {
//        ArrayList<ElementImage> images = new ArrayList<ElementImage>();
//        Matrix2dBoolean isProcessed = new Matrix2dBoolean(in.sizeX, in.sizeY);
//        ElementImage img = null;
//        for(int j = 0; j<in.sizeY; j++){
//            for(int i = 0; i<in.sizeX; i++) {
//                if( isProcessed.getValue(i, j) == false ){
//                    img = Transformer.transformPoints(in, img, isProcessed, maxDiff, i, j);
//                    for(Point p: img.points){
//                        isProcessed.setValue(p.x, p.y, true);
//                    }
//                    images.add(img);
//                }
//            }
//        }
//        return images;
//    }


//    /**
//     * ElementImage -> ImageCenter
//     * @param in
//     * @param out
//     * @return
//     */
//    public static ImageCenter transformPoints(ElementImage in, ImageCenter out){
//        int n = 0;
//        double cx = 0;
//        double cy = 0;
//        double cz = 0;
//        for(Point p: in.points) {
//            n +=1;
//            cx += p.x;
//            cy += p.y;
//            cz += p.z;
//        }
//        if(n>0) {
//            cx /= n;
//            cy /= n;
//            cz /= n;
//        }
//        return new ImageCenter(cx, cy, cz);
//    }




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
    /**
     * NormalizedPolarConture -> javafx.scene.chart.XYChart.Series
     * @param in
     * @param out
     * @param seriesName
     * @return
     */
    public static XYChart.Series transform(NormalizedPolarConture in, XYChart.Series out, String seriesName) {
        XYChart.Series series = new XYChart.Series();
        series.setName(seriesName);
        //populating the series with data
        for(NormalizedPolarPoint pp: in.points) {
            series.getData().add(new XYChart.Data(pp.a, pp.r));
        }
        return series;
    }

    // ===================================== COMPARE ============================================
    /**
     * Compare two NormalizedPolarConture -> and return double from 0..1 where 1.0 - %100 is equal contours
     * @param in1
     * @param in2
     * @param out
     * @return
     */
    public static Double transform(NormalizedPolarConture in1, NormalizedPolarConture in2, Double out) {
        int n;
        double dMin, d;
        double sum = 0;
        if(out == null) out = new Double(0.0);
        for (NormalizedPolarPoint npp1: in1.points) {
            dMin = 255;
            for (NormalizedPolarPoint npp2: in2.points) {
                //d = Math.sqrt((npp1.a - npp2.a)*(npp1.a - npp2.a) + (npp1.r - npp2.r)*(npp1.r - npp2.r));
                d = (Math.abs(npp1.a - npp2.a) + Math.abs(npp1.r - npp2.r))/2;
                if(d<dMin){
                    dMin = d;
                }
            }
            sum += dMin;
        }
        n = in1.points.size();
        return sum/n;
    }

    /**
     * Compare two Matrix2dBoolean -> and return ComparisonResult
     * @param in1
     * @param in2
     * @return
     */
    public static void transform(Matrix2dBoolean in1, Matrix2dBoolean in2){
        double nNotEqual = 0.0, nEqual = 0.0, nMax = in1.sizeX * in1.sizeY;
        boolean v1, v2;
        for (int j = 0; j < in1.sizeY; j++) {
            for (int i = 0; i < in1.sizeX; i++) {
                v1 = in1.getValue(i, j);
                v2 = in2.getValue(i, j);
                if(v1 == true && v2 == true) {
                    nEqual += 1;
                }
                if(v1!=v2){
                        nNotEqual+=1;
                }
            }
        }
        //ComparisonResult cr = new ComparisonResult();
        //cr.form = nEqual/(nEqual + nNotEqual);
        //return null;
    }


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