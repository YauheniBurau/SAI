package core.transformer;

import core.application.model.Model;
import core.element.Matrix2dArgbSensor;
import core.element.*;
import core.exceptions.FileException;
import core.exceptions.InputParamException;
import core.element.Matrix2dArgb;
import core.element.Matrix2dBoolean;
import core.element.Matrix2dByte;
import core.element.Graph;
import core.math.Geometry;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.XYChart;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 24.03.2018.
 */
public class Transformer {
    // ================================ TYPES CONVERSION ===============================================
    /**
     * transform Int to Byte
     * int must be in dipazon [0..255]
     * @param value
     * @return
     */
    public static byte int0_255ToByte(int value){
        if(value>255 || value<0){
            throw new InputParamException("input int must be in dipazon [0..255]");
        }
        return (byte)(value-128);
    }

    /**
     * transform Double to Byte
     * int must be in dipazon [0..255]
     * @param value
     * @return
     */
    public static byte double0_255ToByte(double value){
        if(value>255 || value<0){
            throw new InputParamException("input int must be in dipazon [0..255]");
        }
        return (byte)(value-128);
    }

    /**
     * transform model data accordingly list of command transformation
     */
    public static void transform(Model model, Transformation transformation){
        TransformResults tr = null;
        for (TransformationStep ts: transformation.transformationSteps) {
            // Matrix2dArgb -> PngFile
            if(ts.inType == Matrix2dArgb.class && ts.outType == PngFile.class){
                Matrix2dArgb in = model.matrix2dArgbList.get(ts.inKey);
                PngFile out = model.pngFileList.get(ts.outKey);
                tr = Transformer.transform(in, out, ts.transformParams);
                continue;
            }
            // PngFile -> Matrix2dArgb
            if(ts.inType == PngFile.class && ts.outType == Matrix2dArgb.class){
                PngFile in = model.pngFileList.get(ts.inKey);
                Matrix2dArgb out = model.matrix2dArgbList.get(ts.outKey);
                tr = Transformer.transform(in, out, ts.transformParams);
                continue;
            }
            // JavaFX.scene.image.WritableImage -> JavaFX.scene.canvas.Canvas
            if(ts.inType == WritableImage.class && ts.outType == Canvas.class) {
                WritableImage in = model.writableImageList.get(ts.inKey);
                Canvas out = model.canvasList.get(ts.outKey);
                tr = Transformer.transform(in, out, ts.transformParams);
                continue;
            }
            // Matrix2dBoolean -> JavaFX.scene.image.WritableImage
            if(ts.inType == Matrix2dBoolean.class && ts.outType == WritableImage.class) {
                Matrix2dBoolean in = model.matrix2dBooleanList.get(ts.inKey);
                WritableImage out = model.writableImageList.get(ts.outKey);
                tr = Transformer.transform(in, out, ts.transformParams);
                continue;
            }
            // Matrix2dArgb -> JavaFX.scene.image.WritableImage
            if(ts.inType == Matrix2dArgb.class && ts.outType == WritableImage.class) {
                Matrix2dArgb in = model.matrix2dArgbList.get(ts.inKey);
                WritableImage out = model.writableImageList.get(ts.outKey);
                tr = Transformer.transform(in, out, ts.transformParams);
                continue;
            }
            // Matrix2dArgb -> JavaFX.scene.canvas.Canvas
            if(ts.inType == Matrix2dArgb.class && ts.outType == Canvas.class) {
                Matrix2dArgb in = model.matrix2dArgbList.get(ts.inKey);
                Canvas out = model.canvasList.get(ts.outKey);
                WritableImage wi = new WritableImage(in.sizeX, in.sizeY);
                Transformer.transform(in, wi, ts.transformParams);
                tr = Transformer.transform(wi, out, ts.transformParams);
                continue;
            }
            // if no appropriate data transform method
            if(true){
                throw new InputParamException("Data transformation is not available:" + ts.inType + " ->" + ts.outType);
            }
        }
    }


    // ==============================ELEMENTS DATA CONVERSION ==========================================
    /**
     * PngFile -> Matrix2dArgb
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform(PngFile in, Matrix2dArgb out, TransformParams params) {
        BufferedImage image;
        ARGB argb = null;
        int x, y;
        ARGB color;
        try {
            image = ImageIO.read(new FileImageInputStream(new File(in.urlFile)));
        } catch (IOException e) {
            throw new FileException("Can't read image file into matrix2dArgb", e);
        }
        y = image.getHeight();
        x = image.getWidth();
        out.setSizeXY(x,y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                color = Transformer.transform( image.getRGB(i,j), argb );
                out.setValue(i,j, color);
            }
        }
        return new TransformResults();
    }

    /**
     * save matrix2dArgb to Png-file
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform(Matrix2dArgb in, PngFile out, TransformParams params) {
        BufferedImage image;
        Integer I = null;
        int type = TYPE_INT_ARGB;
        int x, y;
        image = new BufferedImage(in.sizeX, in.sizeY, type);
        y = in.sizeY;
        x = in.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, Transformer.transform(in.getValue(i, j), I) );
            }
        }
        try {
            ImageIO.write(image, "png", new File(out.urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write matrix2d to image file", e);
        }
        return new TransformResults();
    }

    /**
     * JavaFX.scene.image.WritableImage -> JavaFX.scene.canvas.Canvas
     * @param in
     * @param out
     * @param params
     * @return
     */
    public static TransformResults transform(WritableImage in, Canvas out, TransformParams params) {
        out.setHeight(in.getHeight());
        out.setWidth(in.getWidth());
        GraphicsContext gc = out.getGraphicsContext2D();
        gc.drawImage(in, 0,0);
        return new TransformResults();
    }

    /**
     * Matrix2dBoolean -> javafx.scene.image.WritableImage
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform(Matrix2dBoolean in, WritableImage out, TransformParams params) {
        PixelWriter pw = out.getPixelWriter();
        boolean v;
        ARGB argb = null;
        Integer argbInt = null;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                v = in.getValue( i, j);
                argb = Transformer.transform(v, argb);
                argbInt = Transformer.transform(argb, argbInt);
                pw.setArgb(i, j, argbInt);
            }
        }
        return new TransformResults();
    }

    /**
     * Matrix2dArgb -> javafx.scene.image.WritableImage
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform(Matrix2dArgb in, WritableImage out, TransformParams params) {
        PixelWriter pw = out.getPixelWriter();
        ARGB argb;
        Integer argbInt = null;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                argb = in.getValue( i, j);
                argbInt = Transformer.transform(argb, argbInt);
                pw.setArgb(i, j, argbInt);
            }
        }
        return new TransformResults();
    }



    //  -------------------------------------REFACTOR -------------------------------------------------- //
    //  -------------------------------------REFACTOR -------------------------------------------------- //
    //  -------------------------------------REFACTOR -------------------------------------------------- //
    //  -------------------------------------REFACTOR -------------------------------------------------- //
    /**
     * save matrix2dArgb to Png-file
     * @param in
     * @param out
     * @return
     */
    public static PngFile transform(Matrix2dArgb in, PngFile out) {
        BufferedImage image;
        Integer I = null;
        int type = TYPE_INT_ARGB;
        int x, y;
        image = new BufferedImage(in.sizeX, in.sizeY, type);
        y = in.sizeY;
        x = in.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, Transformer.transform(in.getValue(i, j), I) );
            }
        }
        try {
            ImageIO.write(image, "png", new File(out.urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write matrix2d to image file", e);
        }
        return out;
    }

    /**
     * save Matrix2dBoolean -> PngFile
     * @param in
     * @param out
     * @return
     */
    public static PngFile transform(Matrix2dBoolean in, PngFile out) {
        BufferedImage image;
        ARGB argb = null;
        Integer I = null;
        int type = TYPE_INT_ARGB;
        int x, y;
        image = new BufferedImage(in.sizeX, in.sizeY, type);
        y = in.sizeY;
        x = in.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                argb = Transformer.transform(in.getValue(i, j), argb);
                image.setRGB(i, j, Transformer.transform(argb, I));
            }
        }
        try {
            ImageIO.write(image, "png", new File(out.urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write matrix2d to image file", e);
        }
        return out;
    }

    /**
     * save Matrix2dByte -> PngFile
     * @param in
     * @param out
     * @return
     */
    public static PngFile transform(Matrix2dByte in, PngFile out) {
        BufferedImage image;
        ARGB argb = null;
        Integer I = null;
        int type = TYPE_INT_ARGB;
        int x, y;
        image = new BufferedImage(in.sizeX, in.sizeY, type);
        y = in.sizeY;
        x = in.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                argb = Transformer.transform(in.getValue(i, j), argb);
                image.setRGB(i, j, Transformer.transform(argb, I));
            }
        }
        try {
            ImageIO.write(image, "png", new File(out.urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write matrix2d to image file", e);
        }
        return out;
    }

    /**
     * save ElementImage -> PngFile
     * @param in
     * @param out
     * @return
     */
    public static PngFile transform(ElementImage in, PngFile out) {
        // 1. find shift by x and y
        if(in.points.size()==0) return out;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int u = Integer.MAX_VALUE;
        int d = Integer.MIN_VALUE;
        for(Point p : in.points){
            if( p.x < l ) l = p.x;
            if( p.x > r ) r = p.x;
            if( p.y < u ) u = p.y;
            if( p.y > d ) d = p.y;
        }
        int width = r - l + 1;
        int high = d - u + 1;
        // 2.create image
        BufferedImage image;
        int x, y;
        image = new BufferedImage(width, high, TYPE_INT_ARGB);
        y = high;
        x = width;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, 0x00000000 );
            }
        }
        // 3. add points with shift to PngFile
        for(Point p : in.points) {
            image.setRGB(  p.x - l, p.y - u, p.getValue() );
        }
        // 4. Save
        try {
            ImageIO.write(image, "png", new File(out.urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write ElementImage -> PngFile", e);
        }
        return out;
    }

    /**
     * Matrix2dArgbSensor -> Matrix2dByte
     * @return
     */
    public static Matrix2dByte transform(Matrix2dArgbSensor in, Matrix2dByte out){
        int sizeX = in.sizeX;
        int sizeY = in.sizeY;
        byte v;
        int iv;
        ARGB argb;
        Matrix2dByte m2d = new Matrix2dByte(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++) {
                argb = in.getValue(i, j);
                iv = (argb.a + argb.r + argb.g + argb.b)/4;
                v = Transformer.int0_255ToByte(iv);
                m2d.setValue( i,j, v );
            }
        }
        return m2d;
    }

    /**
     *
     * @param isProcessed
     * @param maxDiff
     * @param x
     * @param y
     * @return
     */
    public static ElementImage transform(Matrix2dByte in, ElementImage out, Matrix2dBoolean isProcessed, int maxDiff, int x, int y){
        int pi, pj;
        Byte v2, v3, v4, v5, v6, v7, v8, v9;
        double summ = 0;
        int n = 0;
        ElementImage img = new ElementImage();
        Point p;
        LinkedList<Point> points = new LinkedList<Point>();
        points.add( new Point(x, y, 0, in.getValue(x, y)) );
        isProcessed.setValue(x, y, true);
        summ += in.getValue(x, y);
        n += 1;
        while(points.size()>0){
            p = points.poll();
            img.points.add(p);
            pi = p.x;
            pj = p.y;
            v2 = in.getValue(pi, pj-1);
            v3 = in.getValue(pi+1, pj-1);
            v4 = in.getValue(pi+1, pj);
            v5 = in.getValue(pi+1, pj+1);
            v6 = in.getValue(pi, pj+1);
            v7 = in.getValue(pi-1, pj+1);
            v8 = in.getValue(pi-1, pj);
            v9 = in.getValue(pi-1, pj-1);
            if( v2 != null && isProcessed.getValue(pi, pj-1) == false && Math.abs(summ/n - v2) <= maxDiff) {
                points.add( new Point(pi,pj-1, 0, v2) );
                isProcessed.setValue(pi, pj-1, true);
                summ += v2;
                n += 1;
            }
            if( v3 != null && isProcessed.getValue(pi+1, pj-1) == false && Math.abs(summ/n - v3) <= maxDiff) {
                points.add( new Point(pi+1,pj-1, 0, v3) );
                isProcessed.setValue(pi+1, pj-1, true);
                summ += v3;
                n += 1;
            }
            if( v4 != null && isProcessed.getValue(pi+1, pj) == false && Math.abs(summ/n - v4) <= maxDiff) {
                points.add( new Point(pi+1,pj, 0, v4) );
                isProcessed.setValue(pi+1, pj, true);
                summ += v4;
                n += 1;
            }
            if( v5 != null && isProcessed.getValue(pi+1, pj+1) == false && Math.abs(summ/n - v5) <= maxDiff) {
                points.add( new Point(pi+1,pj+1, 0, v5) );
                isProcessed.setValue(pi+1, pj+1, true);
                summ += v5;
                n += 1;
            }
            if( v6 != null && isProcessed.getValue(pi, pj+1) == false && Math.abs(summ/n - v6) <= maxDiff) {
                points.add( new Point(pi,pj+1, 0, v6) );
                isProcessed.setValue(pi, pj+1, true);
                summ += v6;
                n += 1;
            }

            if( v7 != null && isProcessed.getValue(pi-1, pj+1) == false && Math.abs(summ/n - v7) <= maxDiff) {
                points.add( new Point(pi-1,pj+1, 0, v7) );
                isProcessed.setValue(pi-1, pj+1, true);
                summ += v7;
                n += 1;
            }
            if( v8 != null && isProcessed.getValue(pi-1, pj) == false && Math.abs(summ/n - v8) <= maxDiff) {
                points.add( new Point(pi-1,pj, 0, v8) );
                isProcessed.setValue(pi-1, pj, true);
                summ += v8;
                n += 1;
            }
            if( v9 != null && isProcessed.getValue(pi-1, pj-1) == false && Math.abs(summ/n - v9) <= maxDiff) {
                points.add( new Point(pi-1,pj-1, 0, v9) );
                isProcessed.setValue(pi-1, pj-1, true);
                summ += v9;
                n += 1;
            }
        }
        return img;
    }

    /**
     * find all point images in Matrix2dByte
     * @param maxDiff
     * @return
     */
    public static ArrayList<ElementImage> transform(Matrix2dByte in, ArrayList<ElementImage> out, int maxDiff) {
        ArrayList<ElementImage> images = new ArrayList<ElementImage>();
        Matrix2dBoolean isProcessed = new Matrix2dBoolean(in.sizeX, in.sizeY);
        ElementImage img = null;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                if( isProcessed.getValue(i, j) == false ){
                    img = Transformer.transform(in, img, isProcessed, maxDiff, i, j);
                    for(Point p: img.points){
                        isProcessed.setValue(p.x, p.y, true);
                    }
                    images.add(img);
                }
            }
        }
        return images;
    }

    /**
     * Matrix2dArgb -> Matrix2dArgbSensor
     * @param in
     * @param out
     * @return
     */
    public static Matrix2dArgbSensor transform(Matrix2dArgb in, Matrix2dArgbSensor out) {
        Matrix2dArgbSensor s = new Matrix2dArgbSensor(in.sizeX, in.sizeY);
        ARGB argb;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                argb = in.getValue(i, j);
                s.setValue(i, j, new ARGB(argb.a, argb.r, argb.g, argb.b));
            }
        }
        return s;
    }

//    /**
//     * PngFile -> Matrix2dArgbSensor
//     * @param in
//     * @param out
//     * @return
//     */
//    public static Matrix2dArgbSensor transform(PngFile in, Matrix2dArgbSensor out) {
//        Matrix2dArgb m2d = null;
//        m2d = Transformer.transform(in, m2d);
//        Matrix2dArgbSensor s = null;
//        return Transformer.transform(m2d, out);
//    }

    /**
     * ARGB -> Integer
     * @param in
     * @param out
     * @return
     */
    public static Integer transform(ARGB in, Integer out){
        int i = 0x00000000;
        i = i | in.a;
        i = i<<8 | in.r;
        i = i<<8 | in.g;
        i = i<<8 | in.b;
        return i;
    }

    /**
     * Byte -> ARGB
     * @param in
     * @param out
     * @return
     */
    public static ARGB transform(Byte in, ARGB out){
        int v = in +128;
        ARGB argb = new ARGB(0xff, v, v, v);
        return argb;
    }

    /**
     * Boolean -> ARGB
     * @param in
     * @param out
     * @return
     */
    public static ARGB transform(Boolean in, ARGB out){
        ARGB argb;
        if(in == false) argb = new ARGB(0,0,0,0);
        else argb = new ARGB(255,255,255,255);
        return argb;
    }

    /**
     * transform Integer -> ARGB
     * @param in
     * @param out
     * @return
     */
    public static ARGB transform(Integer in, ARGB out){
        int alpha, red, green, blue;
        alpha = (in >>> 24) & 0xff;
        red = (in >>> 16) & 0xff;
        green = (in >>> 8) & 0xff;
        blue = (in >>> 0) & 0xff;
        return new ARGB(alpha, red, green, blue);
    }

    /**
     * ElementImage -> ImageCenter
     * @param in
     * @param out
     * @return
     */
    public static ImageCenter transform(ElementImage in, ImageCenter out){
        int n = 0;
        double cx = 0;
        double cy = 0;
        double cz = 0;
        for(Point p: in.points) {
            n +=1;
            cx += p.x;
            cy += p.y;
            cz += p.z;
        }
        if(n>0) {
            cx /= n;
            cy /= n;
            cz /= n;
        }
        return new ImageCenter(cx, cy, cz);
    }

    /**
     * Conture -> ContureCenter
     * @param in
     * @param out
     * @return
     */
    public static ContureCenter transform(Conture in, ContureCenter out){
        int n = 0;
        double cx = 0;
        double cy = 0;
        double cz = 0;
        for(Point p: in.points) {
            n +=1;
            cx += p.x;
            cy += p.y;
            cz += p.z;
        }
        if(n>0) {
            cx /= n;
            cy /= n;
            cz /= n;
        }
        return new ContureCenter(cx, cy, cz);
    }

    /**
     * ElementImage -> Matrix2dInt
     * @param in
     * @param out
     * @return
     */
    public static Matrix2dInt transform(ElementImage in, Matrix2dInt out){
        // 1. find shift by x and y
        if(in.points.size()==0) return out;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int u = Integer.MAX_VALUE;
        int d = Integer.MIN_VALUE;
        for(Point p : in.points){
            if( p.x < l ) l = p.x;
            if( p.x > r ) r = p.x;
            if( p.y < u ) u = p.y;
            if( p.y > d ) d = p.y;
        }
        int width = r - l + 1;
        int high = d - u + 1;
        // 2.create image
        Matrix2dInt m2d = new Matrix2dInt(width, high);
        int x, y;
        y = high;
        x = width;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                m2d.setValue(i, j,0x00000000);
            }
        }
        // 3. add points with shift to Matrix2d
        for(Point p : in.points) {
            m2d.setValue(  p.x - l, p.y - u, p.getValue() );
        }
        return m2d;
    }

    /**
     * ElementImage -> Matrix2dInt
     * @param in
     * @param out
     * @return
     */
    public static Matrix2dBoolean transform(ElementImage in, Matrix2dBoolean out){
        // 1. find shift by x and y
        if(in.points.size()==0) return out;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int u = Integer.MAX_VALUE;
        int d = Integer.MIN_VALUE;
        for(Point p : in.points){
            if( p.x < l ) l = p.x;
            if( p.x > r ) r = p.x;
            if( p.y < u ) u = p.y;
            if( p.y > d ) d = p.y;
        }
        int width = r - l + 1;
        int high = d - u + 1;
        // 2.create image
        Matrix2dBoolean m2d = new Matrix2dBoolean(width, high);
        int x, y;
        y = high;
        x = width;
        // 3. add points with shift to Matrix2d
        for(Point p : in.points) {
            m2d.setValue(  p.x - l, p.y - u, true );
        }
        return m2d;
    }

    /**
     * transform Matrix2dBoolean -> Matrix2dGraph
     * @return
     */
    public static Matrix2dGraph transform(Matrix2dBoolean in, Matrix2dGraph out) {
        int sizeX = in.sizeX;
        int sizeY = in.sizeY;
        Graph g1, g2, g3, g4, g5, g6, g7, g8, g9;
        Matrix2dGraph m2d = new Matrix2dGraph(sizeX, sizeY);
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                if(in.getValue(i, j)==true) m2d.setValue(i, j, new Graph( new Point(i, j,0,0)));
            }
        }
        for (int j = 1; j < sizeY-1; j++) {
            for (int i = 1; i < sizeX-1; i++) {
                g1 = m2d.getValue(i, j);
                if(g1 != null ) {
                    g2 = m2d.getValue(i, j - 1);
                    g3 = m2d.getValue(i + 1, j - 1);
                    g4 = m2d.getValue(i + 1, j);
                    g5 = m2d.getValue(i + 1, j + 1);
                    g6 = m2d.getValue(i, j + 1);
                    g7 = m2d.getValue(i - 1, j + 1);
                    g8 = m2d.getValue(i - 1, j);
                    g9 = m2d.getValue(i - 1, j - 1);
                    if (g2 != null) {
                        if (!g1.getPoints().contains(g2)) {
                            g1.getPoints().add(g2);
                            g2.getPoints().add(g1);
                        }
                    }
                    if (g3 != null && g2 == null && g4 == null) {
                        if (!g1.getPoints().contains(g3)) {
                            g1.getPoints().add(g3);
                            g3.getPoints().add(g1);
                        }
                    }
                    if (g4 != null) {
                        if (!g1.getPoints().contains(g4)) {
                            g1.getPoints().add(g4);
                            g4.getPoints().add(g1);
                        }
                    }
                    if (g5 != null && g4 == null && g6 == null) {
                        if (!g1.getPoints().contains(g5)) {
                            g1.getPoints().add(g5);
                            g5.getPoints().add(g1);
                        }
                    }
                    if (g6 != null) {
                        if (!g1.getPoints().contains(g6)) {
                            g1.getPoints().add(g6);
                            g6.getPoints().add(g1);
                        }
                    }
                    if (g7 != null && g6 == null && g8 == null) {
                        if (!g1.getPoints().contains(g7)) {
                            g1.getPoints().add(g7);
                            g7.getPoints().add(g1);
                        }
                    }
                    if (g8 != null) {
                        if (!g1.getPoints().contains(g8)) {
                            g1.getPoints().add(g8);
                            g8.getPoints().add(g1);
                        }
                    }
                    if (g9 != null && g2 == null && g8 == null) {
                        if (!g1.getPoints().contains(g9)) {
                            g1.getPoints().add(g9);
                            g9.getPoints().add(g1);
                        }
                    }
                }
            }
        }
        return m2d;
    }

    /**
     * ElementImage -> "ArrayList<Conture>"
     * @param in
     * @param out
     * @return
     */
    public static ArrayList<Conture> transform(Matrix2dGraph in, ArrayList<Conture> out){
        ArrayList<Conture> contures = new ArrayList<Conture>();
        Matrix2dBoolean isProcessed = new Matrix2dBoolean(in.sizeX, in.sizeY);
        Conture c;
        Graph g;
        int x, y;
        ArrayList<Graph> links;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++){
                if(in.getValue(i, j)!=null && isProcessed.getValue(i,j)==false){
                    c = new Conture();
                    // 1-st direction
                    g = in.getValue(i, j);
                    x = g.getPoint().x;
                    y = g.getPoint().y;
                    do{
                        c.points.addLast(new Point(x, y) );
                        isProcessed.setValue(x, y, true);
                        links = g.getPoints();
                        g = null;
                        for (Graph link: links) {
                            x = link.getPoint().x;
                            y = link.getPoint().y;
                            if( isProcessed.getValue(x,y)==false){
                                g = link;
                                break;
                            }
                        }
                    }while(g!=null);
                    // 2-nd direction
                    c.points.removeFirst();
                    g = in.getValue(i, j);
                    x = g.getPoint().x;
                    y = g.getPoint().y;
                    do{
                        c.points.addFirst(new Point(x, y) );
                        isProcessed.setValue(x, y,true);
                        links = g.getPoints();
                        g = null;
                        for (Graph link: links) {
                            x = link.getPoint().x;
                            y = link.getPoint().y;
                            if( isProcessed.getValue(x,y)==false){
                                g = link;
                                break;
                            }
                        }
                    }while(g!=null);
                    contures.add(c);
                }
            }
        }

        return contures;
    }

    /**
     * Conture -> pngFile
     * @param in
     * @param out
     * @return
     */
    public static PngFile transform(Conture in, PngFile out){
        // 1. find shift by x and y
        if(in.points.size()==0) return out;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int u = Integer.MAX_VALUE;
        int d = Integer.MIN_VALUE;
        for(Point p : in.points){
            if( p.x < l ) l = p.x;
            if( p.x > r ) r = p.x;
            if( p.y < u ) u = p.y;
            if( p.y > d ) d = p.y;
        }
        int width = r - l + 1;
        int high = d - u + 1;
        // 2.create image
        BufferedImage image;
        int x, y;
        image = new BufferedImage(width, high, TYPE_INT_ARGB);
        y = high;
        x = width;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, 0x00000000 );
            }
        }
        // 3. add points with shift to PngFile
        for(Point p : in.points) {
            //image.setRGB(  p.x - l, p.y - u, p.getValue() ); // TODO: make possible save value in Matrix2dBoolean
            image.setRGB(  p.x - l, p.y - u, 0xffffffff );
        }
        // 4. Save
        try {
            ImageIO.write(image, "png", new File(out.urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write Conture -> PngFile", e);
        }
        return out;
    }

    /**
     * works only for 2d contures
     * @param in
     * @param out
     * @return
     */
    public static PolarConture transform(Conture in, PolarConture out) {
        ContureCenter cc = null;
        cc = Transformer.transform(in, cc);
        if(out == null){ out = new PolarConture();}

        double d;
        double angle;
        // count max distance and find distance from center to points
        for(Point p: in.points) {
            angle = Geometry.findLine2dAngleGrade( new Point((int)cc.x, (int)cc.y), p);
            d = Math.sqrt((cc.x - p.x)*(cc.x - p.x) + (cc.y - p.y)*(cc.y - p.y));
            out.points.add( new PolarPoint(angle, d) );
        }
        return out;
    }

    /**
     * PolarConture (absolute values) -> NormalizedPolarConture( values in range [-128 +127] )
     * works only for 2d contures
     * @param in
     * @param out
     * @return
     */
    public static NormalizedPolarConture transform(PolarConture in, NormalizedPolarConture out) {
        NormalizedPolarConture normalizedPolarConture = new NormalizedPolarConture();
        double dist, angle, maxDistance = 0;
        byte a, r;
        for(PolarPoint v: in.points) {
            if (v.r > maxDistance) {
                maxDistance = v.r;
            }
        }
        for(PolarPoint v: in.points) {
            dist = (v.r/maxDistance)*255;
            r = Transformer.double0_255ToByte(dist);
            angle = v.a /360 * 255;
            a = Transformer.double0_255ToByte(angle);
            normalizedPolarConture.points.add( new NormalizedPolarPoint(a, r) );
        }
        return normalizedPolarConture;
    }

    /**
     * NormalizedPolarPoint -> polarPoint where a value ={0..360}; r value = {0..255}
     * @param in
     * @param out
     * @return
     */
    public static PolarPoint transform(NormalizedPolarPoint in, PolarPoint out){
        double a = 360.0 / 255.0 * (in.a + 128);
        double r = (in.r +128);
        return new PolarPoint(a, r);
    }

    /**
     * PolarPoint where a value ={0..360}; r value = {0..255} -> Point2d where x and y ={-128..+127}
     * @param in
     * @param out
     * @return
     */
    public static Point2d transform(PolarPoint in, Point2d out){
        int x = (int) Math.floor( (in.r * Math.cos(in.a * Math.PI / 180))/2 );
        int y = (int) Math.floor( (in.r * Math.sin(in.a * Math.PI / 180))/2 );
        return new Point2d(x, y);
    }

    /**
     * NormalizedPolarPoint -> PolarPoint -> Point2d
     * @param in
     * @param out
     * @return
     */
    public static Point2d transform(NormalizedPolarPoint in, Point2d out){
        PolarPoint pp = null;
        pp = Transformer.transform(in, pp);
        Point2d p2d = null;
        p2d = Transformer.transform(pp, p2d);
        return p2d;
    }

    /**
     * NormalizedPolarConture -> transform to Matrix2dBoolean as picture
     * @param in
     * @param out
     * @return
     */
    public static Matrix2dBoolean transform(NormalizedPolarConture in, Matrix2dBoolean out) {
        Matrix2dBoolean m2d = new Matrix2dBoolean(256, 256);
        // draw contureLine in Matrix
        NormalizedPolarPoint nppFirst, nppLast, npp1, npp2;
        nppFirst = in.points.get(0);
        nppLast = in.points.get(0);
        npp1 = nppFirst;
        Point2d p1 = null, p2 = null;
        for (NormalizedPolarPoint npp: in.points){
            npp2 = npp;
            p1 = Transformer.transform(npp1, p1);
            p2 = Transformer.transform(npp2, p2);
            m2d.drawLine(p1.x+128, p1.y+128, p2.x+128, p2.y+128);
            npp1 = npp2;
            nppLast = npp2;
        }
        p1 = Transformer.transform(nppFirst, p1);
        p2 = Transformer.transform(nppLast, p2);
        m2d.drawLine(p1.x+128, p1.y+128, p2.x+128, p2.y+128);
        return m2d;
    }

    //    /**
//     * NormalizedPolarConture -> NormalizedPolarConture, where all cell under conture line are fullfilled
//     * @param in
//     * @param out
//     * @return
//     */
//    public static Matrix2dBoolean transform(NormalizedPolarConture in, Matrix2dBoolean out) {
//        Matrix2dBoolean m2d = new Matrix2dBoolean(256, 256);
//        // draw contureLine in Matrix
//        NormalizedPolarPoint npp1, npp2;
//        npp1 = in.points.get(0);
//        for (NormalizedPolarPoint npp: in.points){
//            npp2 = npp;
//            if(Math.abs(npp1.a - npp2.a)>128){
//                // TODO: Make  it cicle from last point to firstPoint of LinkedList
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

    /**
     * Matrix2dByte -> javafx.scene.image.WritableImage
     * @param in
     * @param out
     * @return
     */
    public static WritableImage transform(Matrix2dByte in, WritableImage out) {
        WritableImage img = new WritableImage(in.sizeX, in.sizeY);
        PixelWriter pw = img.getPixelWriter();
        Byte v;
        ARGB argb = null;
        Integer argbInt = null;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                v = in.getValue( i, j);
                argb = Transformer.transform(v, argb);
                argbInt = Transformer.transform(argb, argbInt);
                pw.setArgb(i, j, argbInt);
            }
        }
        return img;
    }

    // ===================================== COMPARE ============================================
    /**
     * Compare two NormalizedPolarConture -> and return double from 0..1 where 1.0 - %100 is equal contures
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
     * @param out
     * @return
     */
    public static ComparisonResult transform(Matrix2dBoolean in1, Matrix2dBoolean in2, ComparisonResult out){
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
        ComparisonResult cr = new ComparisonResult();
        cr.form = nEqual/(nEqual + nNotEqual);
        return cr;
    }


    // MyClass is located in the same project with images,
// or in the same jar file with images.
//    Class<?> clazz = MyClass.class;
//    InputStream input = clazz.getResourceAsStream("/org/o7planning/javafx/icon/java-32.png");
//    Image image = new Image(input);


//    public static Transformation transform(Matrix2dInt256x256 in, Transformation out, Matrix2dInt256x256 ethalon){
//        Transformation tr = new Transformation();
//
//
//        return tr;
//    }



//    /**
//     * transform Int ARGB to Boolean
//     * @param value
//     * @return
//     */
//    public static boolean intToBoolean(int value){
//        return value <-1 ? false : true;
//    }

//    /**
//     * transform Boolean color to int Color
//     * @param value
//     * @return
//     */
//    public static int booleanToInt(boolean value){
//        int i =  0x00000000;
//        if(value){ i = 0xffffffff; }
//        return i;
//    }


//    /**
//     * transform int ARGB into HSV
//     * @param value
//     * @return
//     */
//    public static HSV intToHsv(int value){
//        return Transformer.argbToHsv( intToArgb(value) );
//    }

//   /**
//     * transform ARGB to HSV
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
//     * transform HSV to ARGB
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

//    /**
//     * transform HSV to int
//     * @param value
//     * @return
//     */
//    public static int hsvToInt(HSV value){
//        int i = 0x00000000;
//        i = i | 0xff;
//        i = i<<8 | value.h;
//        i = i<<8 | value.s;
//        i = i<<8 | value.v;
//        return i;
//    }


    // ====================== ARGB to HSV ======================

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
