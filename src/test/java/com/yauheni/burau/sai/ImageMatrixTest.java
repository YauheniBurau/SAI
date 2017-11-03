package com.yauheni.burau.sai;

import core.element.Point2d;
import core.matrix.*;
import org.junit.Test;

import static java.awt.image.BufferedImage.TYPE_BYTE_GRAY;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 08.10.2016.
 */
public class ImageMatrixTest {

    String dirIn = "E:\\temp\\in\\";
    String dirOut = "E:\\temp\\out\\";
//    String imageFile = "game.png";
//    String imageFile = "desktop.png";
//    String imageFile = "lcd.png";
//    String imageFile = "anime.png";
//    String imageFile = "table.png";
//    String imageFile = "table.JPG";
//    String imageFile = "nature1.jpeg";
//    String imageFile = "stown.png";
    String imageFile = "alphabet_colors.png";
//    String imageFile = "table1.jpg";
//    String imageFile = "google.png";
//    String imageFile = "flower.jpg";
//    String imageFile = "fractal_rainbow_swirl.jpg";
//    String imageFile = "Alesya.png";
//    String imageFile = "apple.jpg";
//    String imageFile = "line45.png";
//    String imageFile = "Lara_Stown.jpg";
//    String imageFile = "graph.png";
//    String imageFile = "A.png";

    @Test
    public void detectLine() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dBoolean edge = m2d.edgeByColorDistance(16)
                .replacePoints(true, 0, 1, -1,-1)
                .replacePoints(false, 6, 8, -1,-1)
                .skeletize()
                .replace3x3(263, 262)
                .replace3x3(29, 28)
                .replace3x3(113, 112)
                .replace3x3(449, 448)
                .remove90points()
                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
        System.out.println("n=" + edge.countPoints() );
        Matrix2dGraph graph = edge.toGraph();
//        graph.findLines( 0, 5, 135, 180);
//        System.out.println("n=" + graph.countPoints() );
        graph.findLines( 0, Double.MAX_VALUE, 135, 180);
        System.out.println("n=" + graph.countPoints() );
        Matrix2dBoolean lines = graph.toBoolean()
                .save(dirOut + imageFile + "_lines.png", "png", TYPE_BYTE_GRAY);
    }

    @Test
    public void lineAngles() {
        double angle;
        angle = Matrix2dGraph.findAngle(new Point2d(10, 10), new Point2d(10, 20), new Point2d(20, 10) );
        System.out.println("angle must be 90 : " + angle);
        angle = Matrix2dGraph.findAngle(new Point2d(10, 10), new Point2d(10, 20), new Point2d(20, 20) );
        System.out.println("angle must be 45 : " + angle);

        angle = Matrix2dGraph.findAngle(new Point2d(10, 10), new Point2d(1, 10), new Point2d(20, 20) );
        System.out.println("angle must be 135 : " + angle);
    }

    @Test
    public void toGraph() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dBoolean edge = m2d.stretch2x().edgeByColorDistance(32)
                .save(dirOut + imageFile + "_edge1.png", "png", TYPE_BYTE_GRAY);
        Matrix2dBoolean clearNoise = edge
//                .reduceNoisePoints(1).reduceInnerPoints(6).reduceGapPointsInMask(5).reduceGapPointsInMask(5)
                .replace3x3(263, 262)
                .replace3x3(29, 28)
                .replace3x3(113, 112)
                .replace3x3(449, 448)
//                .reduceNoisePoints(1).reduceGapPointsInMask(5).reduceNoisePoints(3).reduceGapPointsInMask(5).reduceNoisePoints(3)
                .save(dirOut + imageFile + "_clearNoise.png", "png", TYPE_BYTE_GRAY);
        Matrix2dBoolean edge2 = clearNoise.edge()
                .save(dirOut + imageFile + "_edge2.png", "png", TYPE_BYTE_GRAY);
        Matrix2dBoolean skeleton = edge2.skeletonByZhangSuen()
//                .reduceNoisePoints(1)
                .save(dirOut + imageFile + "_skeleton.png", "png", TYPE_BYTE_GRAY);
        Matrix2dBoolean edge3 = skeleton.remove90points()
                .save(dirOut + imageFile + "_edge3.png", "png", TYPE_BYTE_GRAY);;
//        Matrix2dBoolean edge3 = edge2.remove90points()
//                .save(dirOut + imageFile + "_edge3.png", "png", TYPE_BYTE_GRAY);;
        // ===========================================================
        System.out.println("n: " + edge3.countPoints() );
        // ===========================================================
        Matrix2dGraph graph = edge3.toGraph();
        graph.findLines(0, 10, 0.0, 180)
                .findLines(10, Double.MAX_VALUE, 160.0, 180);

//            .findLines( 0.7, 0, 5, 0.0, 180)
//            .findLines( 0.7, 0, 5, 0.0, 180)
//            .findLines( 0.7, 0, 5, 135.0, 180)
//                .findLines( 0.3, 6, 10)
//                .findLines( 0.3, 6, 10)
//                .findLines( 0.3, 6, 10)
//                .findLines( 0.15, 11, 20)
//                .findLines( 0.15, 11, 20)
//                .findLines( 0.15, 11, 10)
//                .findLines(0.1, 5.0, 20, 135, 180)
//                .findLines(0.1, 5.0, 30, 135, 180)
//                .findLines(0.1, 5.0, 45, 135, 180);

        //                .findLines(0.1, 10.0, Double.MAX_VALUE, 135, 180);
//                .findLines(0.1, 31.0, Double.MAX_VALUE, 135, 180)
//                .findLines(0.1, 63.0, Double.MAX_VALUE, 135, 180);

        //                .findLines(0.1, 1.0, Double.MAX_VALUE);
//                .findLines(0.1);

//        graph.findLines(0.03).findLines(0.03).findLines(0.03).findLines(0.03).findLines(0.03)
//                .findLines(0.03).findLines(0.03).findLines(0.03).findLines(0.03).findLines(0.03);
        // ========================================================
        System.out.println("n: " + graph.countPoints() );
        // ========================================================
        Matrix2dBoolean lines = graph.toBoolean()
                .save(dirOut + imageFile + "_lines.png", "png", TYPE_BYTE_GRAY);
    }

    @Test
    public void binaryEdge() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dBoolean edge = m2d.stretch2x().edgeByColorDistance(32)
                .save(dirOut + imageFile + "_edge1.png", "png", TYPE_BYTE_GRAY);
        Matrix2dBoolean clearNoise = edge
//                .reduceNoisePoints(1)
//                .reduceInnerPoints(6)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .replace3x3(263, 262)
//                .replace3x3(29, 28)
//                .replace3x3(113, 112)
//                .replace3x3(449, 448)
//                .reduceNoisePoints(1)
//                .reduceGapPointsInMask(5)
//                .reduceNoisePoints(3)
//                .reduceGapPointsInMask(5)
//                .reduceNoisePoints(3)
                .save(dirOut + imageFile + "_clearNoise.png", "png", TYPE_BYTE_GRAY);
        Matrix2dBoolean edge2 = clearNoise.edge()
                .save(dirOut + imageFile + "_edge2.png", "png", TYPE_BYTE_GRAY);
        Matrix2dBoolean skeleton = edge2.skeletonByZhangSuen()
//                .reduceNoisePoints(1)
                .save(dirOut + imageFile + "_skeleton.png", "png", TYPE_BYTE_GRAY);
    }

    @Test
    public void GapAndNoiseAndSkeletonByZhangSuen() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dBoolean edge = m2d.edgeByColorDistance(32)
                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
        Matrix2dBoolean gn = edge//.reduceNoisePoints(2)
//                .reduceNoisePoints(3)
//                .reduceNoisePoints(3)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
//                .reduceGapPointsInMask(5)
                .save(dirOut + imageFile + "_gn.png", "png", TYPE_BYTE_GRAY);
        Matrix2dBoolean skeleton = gn.skeletonByZhangSuen()
                .save(dirOut + imageFile + "_skeleton.png", "png", TYPE_BYTE_GRAY);



        int i, j, n;
        n = 0;
        int sX = skeleton.sizeX;
        int sY = skeleton.sizeY;
        for(j = 0; j<sY;j++ ){
            for(i = 0; i<sX;i++ ){
                if( skeleton.getValue(i, j) ) n++;
            }
        }
        System.out.println("white pixels: " + n);


        n = 0;
        sX = gn.sizeX;
        sY = gn.sizeY;
        for(j = 0; j<sY;j++ ){
            for(i = 0; i<sX;i++ ){
                if( gn.getValue(i, j) ) n++;
            }
        }
        System.out.println("white pixels gn: " + n);
    }


    @Test
    public void SkeletonByZhangSuen() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dBoolean edge = m2d.edgeByColorDistance(32)
                .save(dirOut + imageFile + "_edge1.png", "png", TYPE_BYTE_GRAY);
        Matrix2dBoolean skeleton = edge.skeletonByZhangSuen()
                .save(dirOut + imageFile + "_skeleton.png", "png", TYPE_BYTE_GRAY);
    }

    @Test
    public void tangen() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dBoolean edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
        Point2d cp = edge.countCenterOfSymmetry();
        System.out.println("center( " + cp.x + ", " + cp.y + "° )");
        int angle = edge.countAngleAxisOfSymmetry(cp);
        System.out.println(angle + "°");
    }

    @Test
    public void tangens() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + "line20.png");
        Matrix2dBoolean edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
        Point2d cp = edge.countCenterOfSymmetry();
        int angle = edge.countAngleAxisOfSymmetry(cp);
        System.out.println("20 : " + angle + "°");

        m2d = Matrix2dArgb.load(dirIn + "line45.png");
        edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
        cp = edge.countCenterOfSymmetry();
        angle = edge.countAngleAxisOfSymmetry(cp);
        System.out.println("45 : " + angle + "°");

        m2d = Matrix2dArgb.load(dirIn + "line60.png");
        edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
        cp = edge.countCenterOfSymmetry();
        angle = edge.countAngleAxisOfSymmetry(cp);
        System.out.println("60 : " + angle + "°");

        m2d = Matrix2dArgb.load(dirIn + "line100.png");
        edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
        cp = edge.countCenterOfSymmetry();
        angle = edge.countAngleAxisOfSymmetry(cp);
        System.out.println("100 : " + angle + "°");

        m2d = Matrix2dArgb.load(dirIn + "line135.png");
        edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
        cp = edge.countCenterOfSymmetry();
        angle = edge.countAngleAxisOfSymmetry(cp);
        System.out.println("135 : " + angle + "°");
    }

    @Test
    public void stretchAndEdgeByColorDistance() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dArgb stretched = m2d.stretch2x()
                .save(dirOut + imageFile + "_2x.png", "png", TYPE_INT_ARGB);
        stretched.edgeByColorDistance(1).save(dirOut + imageFile + "_edge1.png", "png", TYPE_BYTE_GRAY);
        stretched.edgeByColorDistance(2).save(dirOut + imageFile + "_edge2.png", "png", TYPE_BYTE_GRAY);
        stretched.edgeByColorDistance(4).save(dirOut + imageFile + "_edge4.png", "png", TYPE_BYTE_GRAY);
        stretched.edgeByColorDistance(8).save(dirOut + imageFile + "_edge8.png", "png", TYPE_BYTE_GRAY);
        stretched.edgeByColorDistance(16).save(dirOut + imageFile + "_edge16.png", "png", TYPE_BYTE_GRAY);
        stretched.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
        stretched.edgeByColorDistance(64).save(dirOut + imageFile + "_edge64.png", "png", TYPE_BYTE_GRAY);
        stretched.edgeByColorDistance(128).save(dirOut + imageFile + "_edge128.png", "png", TYPE_BYTE_GRAY);
    }


    @Test
    public void countCenterOfSymmetry() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dBoolean edge;
        Point2d pc;
        edge = m2d.edgeByColorDistance(1).save(dirOut + imageFile + "_edge1h.png", "png", TYPE_BYTE_GRAY);
        pc = edge.countCenterOfSymmetry();
        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
        edge = m2d.edgeByColorDistance(2).save(dirOut + imageFile + "_edge2h.png", "png", TYPE_BYTE_GRAY);
        pc = edge.countCenterOfSymmetry();
        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
        edge = m2d.edgeByColorDistance(4).save(dirOut + imageFile + "_edge4h.png", "png", TYPE_BYTE_GRAY);
        pc = edge.countCenterOfSymmetry();
        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
        edge = m2d.edgeByColorDistance(8).save(dirOut + imageFile + "_edge8h.png", "png", TYPE_BYTE_GRAY);
        pc = edge.countCenterOfSymmetry();
        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
        edge = m2d.edgeByColorDistance(16).save(dirOut + imageFile + "_edge16h.png", "png", TYPE_BYTE_GRAY);
        pc = edge.countCenterOfSymmetry();
        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
        edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32h.png", "png", TYPE_BYTE_GRAY);
        pc = edge.countCenterOfSymmetry();
        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
        edge = m2d.edgeByColorDistance(64).save(dirOut + imageFile + "_edge64h.png", "png", TYPE_BYTE_GRAY);
        pc = edge.countCenterOfSymmetry();
        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
        edge = m2d.edgeByColorDistance(128).save(dirOut + imageFile + "_edge128h.png", "png", TYPE_BYTE_GRAY);
        pc = edge.countCenterOfSymmetry();
        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
    }


    @Test
    public void stretchAndEdgeByColorHue() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dArgb stretched = m2d.stretch2x()
                .save(dirOut + imageFile + "_2x.png", "png", TYPE_BYTE_GRAY);
        Matrix2dHsv hsv = stretched.toHsv();
        hsv.edgeByColorHue(1).save(dirOut + imageFile + "_edge1h.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorHue(2).save(dirOut + imageFile + "_edge2h.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorHue(4).save(dirOut + imageFile + "_edge4h.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorHue(8).save(dirOut + imageFile + "_edge8h.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorHue(16).save(dirOut + imageFile + "_edge16h.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorHue(32).save(dirOut + imageFile + "_edge32h.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorHue(64).save(dirOut + imageFile + "_edge64h.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorHue(128).save(dirOut + imageFile + "_edge128h.png", "png", TYPE_BYTE_GRAY);
    }

    @Test
    public void stretchAndEdgeByColorSaturation() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dArgb stretched = m2d.stretch2x()
                .save(dirOut + imageFile + "_2x.png", "png", TYPE_BYTE_GRAY);
        Matrix2dHsv hsv = stretched.toHsv();
        hsv.edgeByColorSaturation(1).save(dirOut + imageFile + "_edge1s.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorSaturation(2).save(dirOut + imageFile + "_edge2s.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorSaturation(4).save(dirOut + imageFile + "_edge4s.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorSaturation(8).save(dirOut + imageFile + "_edge8s.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorSaturation(16).save(dirOut + imageFile + "_edge16s.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorSaturation(32).save(dirOut + imageFile + "_edge32s.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorSaturation(64).save(dirOut + imageFile + "_edge64s.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorSaturation(128).save(dirOut + imageFile + "_edge128s.png", "png", TYPE_BYTE_GRAY);
    }

    @Test
    public void stretchAndEdgeByColorValue() {
        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dArgb stretched = m2d.stretch2x()
                .save(dirOut + imageFile + "_2x.png", "png", TYPE_BYTE_GRAY);
        Matrix2dHsv hsv = stretched.toHsv();
        hsv.edgeByColorValue(1).save(dirOut + imageFile + "_edge1v.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorValue(2).save(dirOut + imageFile + "_edge2v.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorValue(4).save(dirOut + imageFile + "_edge4v.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorValue(8).save(dirOut + imageFile + "_edge8v.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorValue(16).save(dirOut + imageFile + "_edge16v.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorValue(32).save(dirOut + imageFile + "_edge32v.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorValue(64).save(dirOut + imageFile + "_edge64v.png", "png", TYPE_BYTE_GRAY);
        hsv.edgeByColorValue(128).save(dirOut + imageFile + "_edge128v.png", "png", TYPE_BYTE_GRAY);
    }

//    @Test
//    public void stretchAndEdgeBrightness() {
//        Matrix2d m2d = Matrix2d.load(dirIn + imageFile);
//        Matrix2d brightness = m2d.stretch2x().argbToBrightness()
//                .save(dirOut + imageFile + "_brightness.png", "png", TYPE_BYTE_GRAY);
//        brightness.edgeByBrightness(1).save(dirOut + imageFile + "_edge1b.png", "png", TYPE_BYTE_GRAY);
//        brightness.edgeByBrightness(2).save(dirOut + imageFile + "_edge2b.png", "png", TYPE_BYTE_GRAY);
//        brightness.edgeByBrightness(4).save(dirOut + imageFile + "_edge4b.png", "png", TYPE_BYTE_GRAY);
//        brightness.edgeByBrightness(8).save(dirOut + imageFile + "_edge8b.png", "png", TYPE_BYTE_GRAY);
//        brightness.edgeByBrightness(16).save(dirOut + imageFile + "_edge16b.png", "png", TYPE_BYTE_GRAY);
//        brightness.edgeByBrightness(32).save(dirOut + imageFile + "_edge32b.png", "png", TYPE_BYTE_GRAY);
//        brightness.edgeByBrightness(64).save(dirOut + imageFile + "_edge64b.png", "png", TYPE_BYTE_GRAY);
//        brightness.edgeByBrightness(128).save(dirOut + imageFile + "_edge128b.png", "png", TYPE_BYTE_GRAY);
//    }

    @Test
    public void checkReduce(){
        int x = 879;
        int y = 297;
        int r = 5;
        Matrix2dArgb m1x = Matrix2dArgb.load(dirIn + imageFile);
        Matrix2dArgb m1x2 = m1x.reduce(2).save(dirOut + imageFile + "1x2.png", "png", TYPE_INT_ARGB);
        Matrix2dArgb m1x4 = m1x2.reduce(2).save(dirOut + imageFile + "1x4.png", "png", TYPE_INT_ARGB);
        Matrix2dArgb m1x8 = m1x4.reduce(2).save(dirOut + imageFile + "1x8.png", "png", TYPE_INT_ARGB);
        Matrix2dArgb m1x16 = m1x8.reduce(2).save(dirOut + imageFile + "1x16.png", "png", TYPE_INT_ARGB);
        Matrix2dArgb m1x32 = m1x16.reduce(2).save(dirOut + imageFile + "1x32.png", "png", TYPE_INT_ARGB);
        Matrix2dArgb m1x64 = m1x32.reduce(2).save(dirOut + imageFile + "1x64.png", "png", TYPE_INT_ARGB);
    }

//    @Test
//    public void average(){
//        Matrix2d m2d = Matrix2d.load(dirIn + imageFile);
//        m2d.average().average().average().save(dirOut + imageFile + "_average.png", "png", TYPE_INT_ARGB);
//    }

//    @Test
//    public void stretchAndEdgeAndNoiseReduce(){
//        int r = 16;
//        Matrix2d m2d = Matrix2d.load(dirIn + imageFile);
//        Matrix2d edge = m2d.stretch2x().edge(r);
//        Matrix2d red = edge.channel(Matrix2d.RED).save(dirOut + imageFile + "_R.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d green = edge.channel(Matrix2d.GREEN).save(dirOut + imageFile + "_G.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d blue = edge.channel(Matrix2d.BLUE).save(dirOut + imageFile + "_B.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d and = Matrix2d.and(red, green, blue).save(dirOut + imageFile + "_AND.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d n0 = and.reduceNoisePointsInMask(0).save(dirOut + imageFile + "_Noise0.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d n1 = n0.reduceNoisePointsInMask(0).save(dirOut + imageFile + "_Noise1.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d n2 = n1.reduceNoisePointsInMask(0).save(dirOut + imageFile + "_Noise2.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d g0 = n2.reduceGapPointsInMask(5).save(dirOut + imageFile + "_Gap0.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d g1 = g0.reduceGapPointsInMask(5).save(dirOut + imageFile + "_Gap1.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d g2 = g1.reduceGapPointsInMask(5).save(dirOut + imageFile + "_Gap2.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d g3 = g2.reduceGapPointsInMask(5).save(dirOut + imageFile + "_Gap3.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d g4_10 = g3.reduceGapPointsInMask(6)
//                .reduceGapPointsInMask(6)
//                .reduceGapPointsInMask(6)
//                .reduceGapPointsInMask(6)
//                .reduceGapPointsInMask(6)
//                .reduceGapPointsInMask(6)
//                .reduceGapPointsInMask(6)
//                .reduceGapPointsInMask(6).save(dirOut + imageFile + "_Gap4_10.png", "png", TYPE_BYTE_GRAY);
//
//        Matrix2d g11 = g4_10.reduceGapPointsInMask(5).save(dirOut + imageFile + "_Gap11.png", "png", TYPE_BYTE_GRAY);
//
//    }

//    @Test
//    public void getShape(){
//        int r = 16;
//        int x = 450;
//        int y = 1139;
//        Matrix2d m2d = Matrix2d.load(dirIn + imageFile);
//        Matrix2d edge = m2d.edge(r);
//        Matrix2d red = edge.channel(Matrix2d.RED).save(dirOut + imageFile + "_R.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d green = edge.channel(Matrix2d.GREEN).save(dirOut + imageFile + "_G.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d blue = edge.channel(Matrix2d.BLUE).save(dirOut + imageFile + "_B.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d and = Matrix2d.and(red, green, blue).save(dirOut + imageFile + "_AND.png", "png", TYPE_BYTE_GRAY);
//
//        //Matrix2d shape = and.getShape(x,y).save(dirOut + imageFile + "_shape.png", "png", TYPE_BYTE_GRAY);
//    }

//    @Test
//    public void getAllShapes(){
//        int r = 128;
//        Matrix2d m2d = Matrix2d.load(dirIn + imageFile);
//        Matrix2d edge = m2d.edge(r);
//        Matrix2d red = edge.channel(Matrix2d.RED).save(dirOut + imageFile + "_R.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d green = edge.channel(Matrix2d.GREEN).save(dirOut + imageFile + "_G.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d blue = edge.channel(Matrix2d.BLUE).save(dirOut + imageFile + "_B.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d and = Matrix2d.and(red, green, blue).save(dirOut + imageFile + "_AND.png", "png", TYPE_BYTE_GRAY);
//
//        and.findAndSaveAllShapes(dirOut+"\\allShapes\\", "png", TYPE_BYTE_GRAY);
//    }

//    @Test
//    public void diffAndNoisePointsReduction(){
//        int r = 2;
//        Matrix2d m2d = Matrix2d.load(dirIn + imageFile);
//        Matrix2d edge = m2d.diff(r);
//        Matrix2d red = edge.channel(Matrix2d.RED)
//                .reduceNoisePointsInMask(0)
//                .reduceGapPointsInMask(6)
//                .save(dirOut + imageFile + "_R.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d green = edge.channel(Matrix2d.GREEN)
//                .reduceNoisePointsInMask(0)
//                .reduceGapPointsInMask(6)
//                .save(dirOut + imageFile + "_G.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d blue = edge.channel(Matrix2d.BLUE)
//                .reduceNoisePointsInMask(0)
//                .reduceGapPointsInMask(6)
//                .save(dirOut + imageFile + "_B.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d and = Matrix2d.and(red, green, blue);
//        Matrix2d _0 = and.reduceNoisePointsInMask(0).save(dirOut + imageFile + "_AND0.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d _1 = _0.save(dirOut + imageFile + "_AND1.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d _2 = _1.reduceNoisePointsInMask(3).save(dirOut + imageFile + "_AND2.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d _3 = _2.reduceGapPointsInMask(6).save(dirOut + imageFile + "_AND3.png", "png", TYPE_BYTE_GRAY);
//    }

//    @Test
//    public void reduceColours() {
//        int colorsByChannel = 4;
//        Matrix2d m2d = Matrix2d.load(dirIn + imageFile);
//        Matrix2d coloursReduced = m2d.reduceColors(colorsByChannel)
//                .save(dirOut + imageFile + "_reduceColors.png", "png", TYPE_INT_ARGB);
//    }

//    @Test
//    public void stretch2xReduceColoursAndContoursFind() {
//        int colorsByChannel = 2;
//        Matrix2d m2d = Matrix2d.load(dirIn + imageFile).stretch2x();
//        Matrix2d coloursReduced = m2d.reduceColors(colorsByChannel)
//                .save(dirOut + imageFile + "_reduceColors.png", "png", TYPE_INT_ARGB);
//        int r = 2;
//        Matrix2d edge = coloursReduced.diff(r);
//        Matrix2d red = edge.channel(Matrix2d.RED)
////                .reduceNoisePointsInMask(0)
////                .reduceGapPointsInMask(6)
//                .save(dirOut + imageFile + "_R.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d green = edge.channel(Matrix2d.GREEN)
////                .reduceNoisePointsInMask(0)
////                .reduceGapPointsInMask(6)
//                .save(dirOut + imageFile + "_G.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d blue = edge.channel(Matrix2d.BLUE)
////                .reduceNoisePointsInMask(0)
////                .reduceGapPointsInMask(6)
//                .save(dirOut + imageFile + "_B.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d r_g = Matrix2d.or(red, green);
//        Matrix2d r_g_b = Matrix2d.or(r_g, blue);
//        Matrix2d _0 = r_g_b.reduceNoisePointsInMask(0).save(dirOut + imageFile + "_AND0.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d _1 = _0.save(dirOut + imageFile + "_AND1.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d _2 = _1.reduceNoisePointsInMask(3).save(dirOut + imageFile + "_AND2.png", "png", TYPE_BYTE_GRAY);
//        Matrix2d _3 = _2.reduceGapPointsInMask(6).save(dirOut + imageFile + "_AND3.png", "png", TYPE_BYTE_GRAY);
//    }




    //    @Test
//    public void color256Statistic() {
//        int k, i, j, limit = 100000;
//        int sizeX, sizeY;
//        ARGB pixel;
//        int color;
//        ARGB empty = new ARGB(0x00, 0, 0, 0);
//        ARGB[][] pixels;
//        int a, r, g, b;
//        Matrix2d<ARGB> m0 = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> mGrey = Matrix2dArgbFilter.argbToGrey256(m0);
//        Matrix2dFileWriter.saveRGB(mGrey, dirIn + imageFile + "_grey256.png", "png");
//        Matrix2d<ARGB> mReduceColors = new Matrix2d(ARGB.class, mGrey.sizeX, mGrey.sizeY);
//        sizeX = mGrey.sizeX;
//        sizeY = mGrey.sizeY;
//        int[] colorFrequency = Matrix2dStatistic.argbColors(mGrey);
//        for(k=0; k<=255; k++) System.out.println(colorFrequency[k]);
//        for(j = 0; j<sizeY; j++) {
//            for (i = 0; i < sizeX; i++) {
//                pixel = mGrey.getValue(i, j);
//                color = (pixel.r + pixel.g + pixel.b) / 3;
//                if (colorFrequency[color] <= limit) {
//                    // change color to nearest
//                    pixels = mGrey.get3x3(ARGB.class, i, j, empty);
//                    a = pixels[0][0].a;
//                    r = pixels[0][0].r;
//                    g = pixels[0][0].g;
//                    b = pixels[0][0].b;
//                    mReduceColors.setValue(i, j, new ARGB(a, r, g, b));
//                } else {
//                    //save color without changes
//                    mReduceColors.setValue(i, j, pixel);
//                }
//            }
//        }
//        Matrix2dFileWriter.saveRGB(mReduceColors, dirIn + imageFile + "_reducedColors1.png", "png");
//        Matrix2d<ARGB> m1 = Matrix2dArgbFilter.argbToColorDiff(mReduceColors);
//        Matrix2dFileWriter.saveRGB(m1, dirIn + imageFile + "_reducedColors_diff1.png", "png");
//
////        mGrey = mReduceColors;
////        colorFrequency = Matrix2dStatistic.argbColors(mGrey);
////        for(k=0; k<=255; k++) System.out.println(colorFrequency[k]);
////        for(j = 0; j<sizeY; j++) {
////            for (i = 0; i < sizeX; i++) {
////                pixel = mGrey.getValue(i, j);
////                color = (pixel.r + pixel.g + pixel.b) / 3;
////                if (colorFrequency[color] <= limit) {
////                    // change color to nearest
////                    pixels = mGrey.get3x3(ARGB.class, i, j, empty);
////                    a = pixels[0][0].a;
////                    r = pixels[0][0].r;
////                    g = pixels[0][0].g;
////                    b = pixels[0][0].b;
////                    mReduceColors.setValue(i, j, new ARGB(a, r, g, b));
////                } else {
////                    //save color without changes
////                    mReduceColors.setValue(i, j, pixel);
////                }
////            }
////        }
////        Matrix2dFileWriter.saveRGB(mReduceColors, dirIn + imageFile + "_reducedColors2.png", "png");
////        m1 = Matrix2dArgbFilter.argbToColorDiff(mReduceColors);
////        Matrix2dFileWriter.saveRGB(m1, dirIn + imageFile + "_reducedColors_diff2.png", "png");
//    }

//    @Test
//    public void useMask() {
//        Matrix2d<ARGB> m0x = Matrix2dFileReader.loadRGB(dirIn + imageFile);
////        Matrix2d<ARGB> m1x2 = Matrix2dTransform.argbConvolute2x(m0x);
//        Matrix2d<ARGB> m0 = m0x; //Matrix2dTransform.argbConvolute2x(m0x);
//
//        Matrix2d<ARGB> m1 = new Matrix2d<ARGB>(ARGB.class, m0.sizeX, m0.sizeY);
//        Matrix2d<ARGB> m1_1 = new Matrix2d<ARGB>(ARGB.class, m0.sizeX, m0.sizeY);
//        Matrix2d<ARGB> m1_2 = new Matrix2d<ARGB>(ARGB.class, m0.sizeX, m0.sizeY);
//
//        Matrix2d<ARGB> m2 = new Matrix2d<ARGB>(ARGB.class, m0.sizeX, m0.sizeY);
//        Matrix2d<ARGB> m2_1 = new Matrix2d<ARGB>(ARGB.class, m0.sizeX, m0.sizeY);
//        Matrix2d<ARGB> m2_2 = new Matrix2d<ARGB>(ARGB.class, m0.sizeX, m0.sizeY);
//
//        ARGB threshold = Matrix2dStatistic.middleColor(m0);
//        Matrix2dArgbFilter.argbToMaskByThreshold(m0, m1, m2, threshold, 0,0, m0.sizeX, m0.sizeY);
//        Matrix2dFileWriter.saveRGB(m1, dirIn + imageFile + "_m1_Mask.png", "png");
//        Matrix2dFileWriter.saveRGB(m2, dirIn + imageFile + "_m2_Mask.png", "png");
//
//        threshold = Matrix2dStatistic.middleColor(m0, m1, 0,0, m0.sizeX, m0.sizeY);
//        Matrix2dArgbFilter.argbToMaskByThreshold(m0, m1_1, m1_2, m1, threshold, 0,0, m0.sizeX, m0.sizeY);
//        Matrix2dFileWriter.saveRGB(m1_1, dirIn + imageFile + "_m1_1_Mask.png", "png");
//        Matrix2dFileWriter.saveRGB(m1_2, dirIn + imageFile + "_m1_2_Mask.png", "png");
//
//        threshold = Matrix2dStatistic.middleColor(m0, m2, 0,0, m0.sizeX, m0.sizeY);
//        Matrix2dArgbFilter.argbToMaskByThreshold(m0, m2_1, m2_2, m2, threshold, 0,0, m0.sizeX, m0.sizeY);
//        Matrix2dFileWriter.saveRGB(m2_1, dirIn + imageFile + "_m2_1_Mask.png", "png");
//        Matrix2dFileWriter.saveRGB(m2_2, dirIn + imageFile + "_m2_2_Mask.png", "png");
//
//        Matrix2d<ARGB> m1Diff = Matrix2dArgbFilter.argbToColorDiff(m1);
//        Matrix2d<ARGB> m1_1Diff = Matrix2dArgbFilter.argbToColorDiff(m1_1);
//        Matrix2d<ARGB> m1_2Diff =  Matrix2dArgbFilter.argbToColorDiff(m1_2);
//
//        Matrix2d<ARGB> m2Diff =  Matrix2dArgbFilter.argbToColorDiff(m2);
//        Matrix2d<ARGB> m2_1Diff =  Matrix2dArgbFilter.argbToColorDiff(m2_1);
//        Matrix2d<ARGB> m2_2Diff =  Matrix2dArgbFilter.argbToColorDiff(m2_2);
//
//        Matrix2d<ARGB> result = Matrix2dTransform.argbPlusArgb(m1Diff, m2Diff);
//        Matrix2d<ARGB> result1 = Matrix2dTransform.argbPlusArgb(m1_1Diff, m1_2Diff);
//        Matrix2d<ARGB> result2 = Matrix2dTransform.argbPlusArgb(m2_1Diff, m2_2Diff);
//
//        Matrix2d<ARGB> finish = Matrix2dTransform.argbPlusArgb(result, result1, result2);
//        Matrix2dFileWriter.saveRGB(finish, dirIn + imageFile + "_edges.png", "png");
//
//        random();
//    }

    @Test
    public void reduceColorsByStatistic() {
        // count colors gystogram
        // sort array by values
        // find color frequent min limit

        // for every pixel of source make
//        for (j = 0; j < sizeY; j++) {
//            for (i = 0; i < sizeX; i++) {
//                pixel = mGrey.getValue(i, j);
//                color = (pixel.r + pixel.g + pixel.b) / 3;
//                if (colorFrequency[color] <= limit) {
//                    // change color to nearest
//                    nearestColor = ;
//                    mReduceColors.setValue(i, j, nearestColor);
//                } else {
//                    //save color without changes
//                    mReduceColors.setValue(i, j, pixel);
//                }
//            }
//        }


//        int colors = 64; // number of most frequent color will be stayed colors>0 and colors<=256
//        int k, i, j, minLColorFrequency = 0;
//        int sizeX, sizeY;
//        ARGB pixel;
//        int color;
//        ARGB empty = new ARGB(0x00, 0, 0, 0);
//        ARGB[][] pixels;
//        int a, r, g, b;
//        Matrix2d<ARGB> m0 = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> mGrey = Matrix2dArgbFilter.argbToGrey256(m0);
//        Matrix2dFileWriter.saveRGB(mGrey, dirIn + imageFile + "_grey256.png", "png");
//        Matrix2d<ARGB> mReduceColors = new Matrix2d(ARGB.class, mGrey.sizeX, mGrey.sizeY);
//        sizeX = mGrey.sizeX;
//        sizeY = mGrey.sizeY;
//        int[] colorFrequency = Matrix2dStatistic.argbColors(mGrey);
//        int[] colorFrequencySorted = Arrays.copyOf(colorFrequency,256);
//        Arrays.sort(colorFrequencySorted);
//        minLColorFrequency = colorFrequencySorted[256-colors];
////        for (k = 0; k <= 255; k++) System.out.println(colorFrequency[k]);
//        for (j = 0; j < sizeY; j++) {
//            for (i = 0; i < sizeX; i++) {
//                pixel = mGrey.getValue(i, j);
//                color = (pixel.r + pixel.g + pixel.b) / 3;
//                if (colorFrequency[color] < minLColorFrequency) {
//                    // change color to nearest
//                    pixels = mGrey.get3x3(ARGB.class, i, j, empty);
//
//                    a = pixels[0][0].a;
//                    r = pixels[0][0].r;
//                    g = pixels[0][0].g;
//                    b = pixels[0][0].b;
//                    mReduceColors.setValue(i, j, new ARGB(a, r, g, b));
//                } else {
//                    //save color without changes
//                    mReduceColors.setValue(i, j, pixel);
//                }
//            }
//        }
//        Matrix2dFileWriter.saveRGB(mReduceColors, dirIn + imageFile + "_reducedColors1.png", "png");
//        Matrix2d<ARGB> m1 = Matrix2dArgbFilter.argbToColorDiff(mReduceColors);
//        Matrix2dFileWriter.saveRGB(m1, dirIn + imageFile + "_reducedColors_diff1.png", "png");
    }


    // ОПРЕДЕЛЕНИЯ ГРАНИЦ ПО ОДНОМУ КАНАЛУ ЦВЕТА

    // СЛЕДУЮЩИЙ ЭТАП: ПОИСК ЗАКРЫТЫХ КОНТУРОВ НА ЧЕРНО-БЕЛОМ ИЗОБРАЖЕНИИ
    // СНОВА ИСПОЗОВАТЬ ДИХОТОМИЧЕСКОЕ ДЕЛЕНИЕ ДЛЯ ВЫЯВЛЕНИЯ ГРАНИЦ НА ПОДОБРАЗАХ

    // ПОИСК ТЕКСТУРНЫХ ПАТТЕРНОВ

    // НУЖНА БУДЕТ ИЕРАРХИЯ ВЛОЖЕННОСТИ И ПЕРЕСЕЧЕНИЯ КОНТУРОВ

}