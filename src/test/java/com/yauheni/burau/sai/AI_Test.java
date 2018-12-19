package com.yauheni.burau.sai;

import core.application.VertexValue.cloud.CloudOfDecart2dInt;
import core.application.VertexValue.color.ARGB;
import core.application.VertexValue.file.PngFile;
import core.application.VertexValue.matrix.Matrix2d;
import core.application.VertexValue.matrix.Matrix2dByte;
import core.application.graph.Graph;
import core.application.process.CloudToGraph.CloudOfDecart2dIntToGraph;
import core.application.process.FileToMatrix.PngFileToM2dArgb;
import core.application.process.MatrixToCloud.M2dByteToCloudOfDecart2dInt;
import core.application.process.MatrixToMatrix.*;
import org.junit.Test;

/**
 * Created by anonymous on 08.10.2016.
 */
public class AI_Test {

    String dirIn = "E:\\temp\\in\\";
    String dirOut = "E:\\temp\\out\\";
//    String imageFile = "game.png";
//    String imageFile = "lcd.png";
//    String imageFile = "table.png";
//    String imageFile = "table.JPG";
//    String imageFile = "nature1.jpeg";
//    String imageFile = "stown.png";
//    String imageFile = "alphabet2c.png";
//    String imageFile = "nature.png";
//    String imageFile = "anime.png";
    String imageFile = "alphabet_number.png";
//    String imageFile = "alphabet_colors.png";
//    String imageFile = "desktop.png";
//    String imageFile = "text.png";
//    String imageFile = "Y.dat";
//    String imageFile = "T.png";
//    String imageFile = "square.png";
//    String imageFile = "square1.png";
//    String imageFile = "star3.png";
//    String imageFile = "screen.png";
//    String imageFile = "cute_girl_satisfied.png";
//    String imageFile = "cute_girl_smile.png";
//    String imageFile = "BlondeAngel.png";
//    String imageFile = "star.png";
//    String imageFile1 = "star3.png";
//    String imageFile = "circle.png";
//    String imageFile = "screenElements.png";
//    String imageFile = "256Colors.png";


    @Test
    public void Png_Graph_humanFiles() {
        PngFile pngFileIn = new PngFile(dirIn + imageFile);
        Matrix2d<ARGB> m2dArgb = PngFileToM2dArgb.transform(pngFileIn);
        Matrix2dByte m2dByte = M2dArgbToM2dByte256Colors.transform(m2dArgb);
        CloudOfDecart2dInt rootCloud = M2dByteToCloudOfDecart2dInt.transform(m2dByte);
        Graph graph = CloudOfDecart2dIntToGraph.transform(rootCloud);
        graph.toHumanFile(dirOut);
    }


//    @Test
//    public void Png_Cloud_Contour_Png() {
//        PngFile pngFileIn = new PngFile(dirIn + imageFile);
//        Matrix2d<ARGB> m2dArgb = PngFileToM2dArgb.transform(pngFileIn);
//        Matrix2dByte m2dByte = M2dArgbToM2dByte256Colors.transform(m2dArgb);
//        CloudOfDecart2dInt rootCloud = M2dByteToCloudOfDecart2dInt.transform(m2dByte);
//        ArrayList<CloudOfDecart2dInt> innerClouds = rootCloud.countInnerClouds();
//        ContourDecart2dDouble contour;
//        Matrix2dBool m2dBool;
//        int id = 0;
//        for (CloudOfDecart2dInt cloud: innerClouds) {
//            contour = CloudDecart2dIntToContourDecart2dDouble.transform(cloud);
//            m2dBool = ContourDecart2dDoubleToM2dBool.transform(contour, m2dArgb.sizeX, m2dArgb.sizeY);
//            M2dBooleanToPngFile.transform(m2dBool, new PngFile(dirOut + id + "_" + imageFile));
//            id+=1;
//        }
//    }


//    @Test
//    public void PngFile_to_Segments_to_pngFiles() {
//        int quantizeValues = 3;
//
//        PngFile pngFileIn = new PngFile(dirIn + imageFile);
//        Matrix2d<ARGB> m2dArgb = PngFileToM2dArgb.transformPoints(pngFileIn);
//        Matrix2d<Lab> m2dLab = M2dArgbToM2dLab.transformPoints(m2dArgb, Lab.whitePoint);
//        Matrix2d<Byte> m2dByteL = M2dLabToM2dByte_L_A_B.transformL(m2dLab);
//        Matrix2d<Byte> m2dByteQ = M2dByteToM2dByte_Quantized.transformPoints(m2dByteL, quantizeValues);
//        ArrayList<SegmentByteDecart2dInt> ArrayOfSegments
//                = Matrix2dByteToArraySegmentByteDecart2dInt.transformPoints(m2dByteQ);
//
//        PngFile pngFileOut;
//        Matrix2d<Byte> m2dByteSeg;
//        int index = 0;
//        for (Segment<Byte,Decart2dInt> seg: ArrayOfSegments) {
//            index+=1;
//            m2dByteSeg = SegmentPointByteDecart2dIntegerToMatrix2dByte.transformPoints(seg);
//            pngFileOut = new PngFile(dirOut  + index + imageFile);
//            pngFileOut = M2dByteToPngFile.transformPoints(m2dByteSeg, pngFileOut);
//        }
//    }


//    @Test
//    public void PngFile_to_LAB_to_M2dByte_EdgeDiff() {
//        TransformResults tr;
//        int n;
//        PngFile pngFileIn = new PngFile(dirIn + imageFile);
//        Matrix2d<ARGB> m2dArgb = new Matrix2d<ARGB>(ARGB.class, 0, 0);
//        Matrix2d<Lab> m2dLab = new Matrix2d<Lab>(Lab.class, 0, 0);
//        Matrix2d<Byte> m2dByteL = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dBytea = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dByteb = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dByteQ = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dByteQ_edgeDiff = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dBytea_edgeDiff = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dByteb_edgeDiff = new Matrix2d<Byte>(Byte.class, 0, 0);
//        PngFile pngFileOut;
//
//        tr = PngFileToM2dArgb.transformPoints(pngFileIn, m2dArgb);
//        tr = M2dArgbToM2dLab.transformPoints(m2dArgb, m2dLab, Lab.whitePoint);
//
//        tr = M2dLabToM2dByte_L_A_B.transformL(m2dLab, m2dByteL);
//        tr = M2dByteToM2dByte_Quantized.transformPoints(m2dByteL, m2dByteQ, 4);
//        tr = M2dByteToM2dByte_EdgeDiff.transformPoints(m2dByteQ, m2dByteQ_edgeDiff);
//        pngFileOut = new PngFile(dirOut  + "_Q" + imageFile);
//        tr = M2dByteToPngFile.transformPoints(m2dByteQ_edgeDiff, pngFileOut);
//    }


//    @Test
//    public void PngFile_to_M2dByte_EdgeDiff() {
//        TransformResults tr;
//        int n;
//        PngFile pngFileIn = new PngFile(dirIn + imageFile);
//        Matrix2d<ARGB> m2dArgb = new Matrix2d<ARGB>(ARGB.class, 0, 0);
//        Matrix2d<Byte> m2dByteR = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dByteG = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dByteB = new Matrix2d<Byte>(Byte.class, 0, 0);
//
//        Matrix2d<Lab> m2dLab = new Matrix2d<Lab>(Lab.class, 0, 0);
//        Matrix2d<Byte> m2dByteL = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dBytea = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dByteb = new Matrix2d<Byte>(Byte.class, 0, 0);
//
//        Matrix2d<Byte> m2dByteR_edgeDiff = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dByteG_edgeDiff = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dByteB_edgeDiff = new Matrix2d<Byte>(Byte.class, 0, 0);
//
//        Matrix2d<Byte> m2dByteL_edgeDiff = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dBytea_edgeDiff = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dByteb_edgeDiff = new Matrix2d<Byte>(Byte.class, 0, 0);
//
//        Matrix2d<ARGB> m2dArgbOut = new Matrix2d<ARGB>(ARGB.class, 0, 0);
//        PngFile pngFileOut;
//
//        tr = PngFileToM2dArgb.transformPoints(pngFileIn, m2dArgb);
//        tr = M2dArgbToM2dByte_A_R_G_B.transform1(m2dArgb, m2dByteR);
//        tr = M2dArgbToM2dByte_A_R_G_B.transform2(m2dArgb, m2dByteG);
//        tr = M2dArgbToM2dByte_A_R_G_B.transform3(m2dArgb, m2dByteB);
//        tr = M2dByteToM2dByte_EdgeDiff.transformPoints(m2dByteR, m2dByteR_edgeDiff);
//        tr = M2dByteToM2dByte_EdgeDiff.transformPoints(m2dByteG, m2dByteG_edgeDiff);
//        tr = M2dByteToM2dByte_EdgeDiff.transformPoints(m2dByteB, m2dByteB_edgeDiff);
//        tr = M2dByte3ToM2dArgb.transformPoints(m2dByteR_edgeDiff, m2dByteG_edgeDiff, m2dByteB_edgeDiff, m2dArgbOut);
//        pngFileOut = new PngFile(dirOut + imageFile);
//        tr = M2dArgbToPngFile.transformPoints(m2dArgbOut, pngFileOut);
//        pngFileOut = new PngFile(dirOut  + "_R" + imageFile);
//        tr = M2dByteToPngFile.transformPoints(m2dByteR_edgeDiff, pngFileOut);
//        pngFileOut = new PngFile(dirOut + "_G" + imageFile);
//        tr = M2dByteToPngFile.transformPoints(m2dByteG_edgeDiff, pngFileOut);
//        pngFileOut = new PngFile(dirOut + "_B" + imageFile);
//        tr = M2dByteToPngFile.transformPoints(m2dByteB_edgeDiff, pngFileOut);
//    }

//    @Test
//    public void PngFile_to_ARGB_to_quantize() {
//        int quantizeValue = 7;
//        TransformResults tr;
//        int n;
//        PngFile pngFileIn = new PngFile(dirIn + imageFile);
//        Matrix2d<ARGB> m2dArgb = new Matrix2d<ARGB>(ARGB.class, 0, 0);
//        Matrix2d<Byte> m2dR = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dG = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dB = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dR1 = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dG1 = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<Byte> m2dB1 = new Matrix2d<Byte>(Byte.class, 0, 0);
//        Matrix2d<ARGB> m2dArgbOut = new Matrix2d<ARGB>(ARGB.class, 0, 0);
//        PngFile pngFileOut = new PngFile(dirOut + imageFile);
//
//        tr = PngFileToM2dArgb.transformPoints(pngFileIn, m2dArgb);
//        // =====
//        tr = M2dArgbToM2dByte_A_R_G_B.transform1(m2dArgb, m2dR);
////        pngFileOut = new PngFile(dirOut + "R" + imageFile);
////        tr = M2dByteToPngFile.transformPoints(m2dR, pngFileOut);
//        tr = M2dArgbToM2dByte_A_R_G_B.transform2(m2dArgb, m2dG);
////        pngFileOut = new PngFile(dirOut + "G" + imageFile);
////        tr = M2dByteToPngFile.transformPoints(m2dG, pngFileOut);
//        tr = M2dArgbToM2dByte_A_R_G_B.transform3(m2dArgb, m2dB);
////        pngFileOut = new PngFile(dirOut + "B" + imageFile);
////        tr = M2dByteToPngFile.transformPoints(m2dB, pngFileOut);
//
//        // =====
//        tr = M2dByteToM2dByte_Quantized.transformPoints(m2dR, m2dR1, quantizeValue);
//        pngFileOut = new PngFile(dirOut + "R1" + imageFile);
//        tr = M2dByteToPngFile.transformPoints(m2dR1, pngFileOut);
//        tr = M2dByteToM2dByte_Quantized.transformPoints(m2dG, m2dG1, quantizeValue);
//        pngFileOut = new PngFile(dirOut + "G1" + imageFile);
//        tr = M2dByteToPngFile.transformPoints(m2dG1, pngFileOut);
//        tr = M2dByteToM2dByte_Quantized.transformPoints(m2dB, m2dB1, quantizeValue);
//        pngFileOut = new PngFile(dirOut + "B1" + imageFile);
//        tr = M2dByteToPngFile.transformPoints(m2dB1, pngFileOut);
//        // =====
//        tr = M2dByte3ToM2dArgb.transformPoints(m2dR1, m2dG1, m2dB1, m2dArgbOut);
//        pngFileOut = new PngFile(dirOut + imageFile);
//        tr = M2dArgbToPngFile.transformPoints(m2dArgbOut, pngFileOut);
//    }


//    @Test
//    public void PngFile_to_ARGB_to_Lab_to_edgesByL() {
//        TransformResults tr;
//        int n;
//        PngFile pngFileIn = new PngFile(dirIn + imageFile);
//        Matrix2d<ARGB> m2dArgb = new Matrix2d<ARGB>(ARGB.class, 0, 0);
//        Matrix2d<Lab> m2dLab = new Matrix2d<Lab>(Lab.class, 0,0);
//        Matrix2d<Byte> m2dL = new Matrix2d<Byte>(Byte.class, 0,0);
//        Matrix2d<Boolean> m2dBool = new Matrix2d<Boolean>(Boolean.class, 0,0);
//        PngFile pngFileOut = new PngFile(dirOut + imageFile);
//
//        tr = PngFileToM2dArgb.transformPoints(pngFileIn, m2dArgb, new TransformParams());
//        tr = M2dArgbToM2dLab.transformPoints(m2dArgb, m2dLab, Lab.whitePoint, new TransformParams());
//        tr = M2dLabToM2dByte_L_A_B.transformPoints(m2dLab, m2dL, new TransformParams());
//        tr = M2dByteToM2dBoolean_SegmentEdges.transformPoints(m2dL, m2dBool, new TransformParams());
//        tr = M2dBooleanToPngFile.transformPoints(m2dBool, pngFileOut, new TransformParams());
//    }


//    @Test
//    public void segmentateTo256Colors() {
//        TransformResults tr;
//        int n;
//        PngFile pngFile = new PngFile(dirIn + imageFile);
//        Matrix2dArgb argb = new Matrix2dArgb(0, 0);
//
//        tr = PngFileToM2dArgb.transformPoints(pngFile, argb, new TransformParams());
//        n = Transformer.countMatrix2dArgbColorsNumber(argb);
//        System.out.println("number of Colors:" + n);
//
//        Matrix2dArgb argb1 = argb.convertTo256Colors();
//        n = Transformer.countMatrix2dArgbColorsNumber(argb1);
//        System.out.println("number of Colors:" + n);
//
//        PngFile pngFile1 = new PngFile(dirOut + imageFile);
//        tr = M2dArgbToPngFile.transformPoints(argb1, pngFile1, new TransformParams());
//        // =============================================================================================================
//    }

//    @Test
//    public void segmentate() {
//        TransformResults tr;
//        int n;
//        // =============================================================================================================
//        PngFile pngFile = new PngFile(dirIn + imageFile);
//        Matrix2dArgb argb = new Matrix2dArgb(0,0);
//        tr = PngFileToM2dArgb.transformPoints(pngFile, argb, new TransformParams());
//        // =============================================================================================================
//        n = Transformer.countMatrix2dArgbColorsNumber(argb);
//        System.out.println("number of Colors:" + n);
//        // =============================================================================================================
//        Matrix2dArgb argb1 = new Matrix2dArgb(0,0);
//        Matrix2dArgb argb2 = new Matrix2dArgb(0,0);
//        Matrix2dArgb argb3 = new Matrix2dArgb(0,0);
//        Matrix2dArgb argb4 = new Matrix2dArgb(0,0);
//        Matrix2dArgb argb5 = new Matrix2dArgb(0,0);
//        Matrix2dArgb argb6 = new Matrix2dArgb(0,0);
//        Matrix2dArgb argb7 = new Matrix2dArgb(0,0);
//        Matrix2dArgb argb8 = new Matrix2dArgb(0,0);
//        Matrix2dArgb argb9 = new Matrix2dArgb(0,0);
//        Matrix2dArgb argb10 = new Matrix2dArgb(0,0);
//
//        int maxColorDiff = 32;
//        Transformer.transformPoints(argb, argb1, maxColorDiff, 0.10);
//        n = Transformer.countMatrix2dArgbColorsNumber(argb1);
//        System.out.println("number of Colors:" + n);
//
//        Transformer.transformPoints(argb1, argb2, maxColorDiff, 0.10);
//        n = Transformer.countMatrix2dArgbColorsNumber(argb2);
//        System.out.println("number of Colors:" + n);
//
//        Transformer.transformPoints(argb2, argb3, maxColorDiff, 0.10);
//        n = Transformer.countMatrix2dArgbColorsNumber(argb3);
//        System.out.println("number of Colors:" + n);
//
//        Transformer.transformPoints(argb3, argb4, maxColorDiff, 0.10);
//        n = Transformer.countMatrix2dArgbColorsNumber(argb4);
//        System.out.println("number of Colors:" + n);
//
//        Transformer.transformPoints(argb4, argb5, maxColorDiff, 0.10);
//        n = Transformer.countMatrix2dArgbColorsNumber(argb5);
//        System.out.println("number of Colors:" + n);
//
//        Transformer.transformPoints(argb5, argb6, maxColorDiff, 0.10);
//        n = Transformer.countMatrix2dArgbColorsNumber(argb6);
//        System.out.println("number of Colors:" + n);
//
//        Transformer.transformPoints(argb6, argb7, maxColorDiff, 0.10);
//        n = Transformer.countMatrix2dArgbColorsNumber(argb7);
//        System.out.println("number of Colors:" + n);
//
//        Transformer.transformPoints(argb7, argb8, maxColorDiff, 0.10);
//        n = Transformer.countMatrix2dArgbColorsNumber(argb8);
//        System.out.println("number of Colors:" + n);
//
//        Transformer.transformPoints(argb8, argb9, maxColorDiff, 0.10);
//        n = Transformer.countMatrix2dArgbColorsNumber(argb9);
//        System.out.println("number of Colors:" + n);
//
//        Transformer.transformPoints(argb9, argb10, maxColorDiff, 0.10);
//        n = Transformer.countMatrix2dArgbColorsNumber(argb10);
//        System.out.println("number of Colors:" + n);
//
//        // =============================================================================================================
//        PngFile pngFile1 = new PngFile(dirOut + imageFile);
//        tr = M2dArgbToPngFile.transformPoints(argb10, pngFile1, new TransformParams());
//    }

    //    @Test
//    public void findContures() {
//        int maxDiff = 32;
//
//        PngFile pngFile = new PngFile(dirIn + imageFile);
//        Matrix2dArgbSensor sensor = null;
//        sensor = Transformer.transformPoints(pngFile, sensor);
//
//        Matrix2dByte m2dByte = null;
//        m2dByte = Transformer.transformPoints(sensor, m2dByte);
//
//        ArrayList<ElementImage> images = null;
//        images = Transformer.transformPoints(m2dByte, images, maxDiff);
//
//        ElementImage image = images.get(0);
//        Matrix2dBoolean m2dBoolean = null;
//        m2dBoolean = Transformer.transformPoints(image, m2dBoolean);
//        Matrix2dBoolean m2dEdge = m2dBoolean.removeNoise().edge();
//
//        Matrix2dGraph m2dGraph = null;
//        m2dGraph = Transformer.transformPoints(m2dEdge, m2dGraph);
//
//        ArrayList<Conture> contour = null;
//        contour = Transformer.transformPoints(m2dGraph, contour);
//        Conture c = contour.get(0);
//
//    }



//    @Test
//    public void Image_compare2dForms() {
//        int maxDiff = 32;
//
//        Matrix2dArgbSensor sensor = new Matrix2dArgbSensor();
//
//        PngFile pngSquare = new PngFile(dirIn + "square.png");
//        PngFile pngSquare1 = new PngFile(dirIn + "square1.png");
//        PngFile pngStar = new PngFile(dirIn + "star.png");
//
//        ElementImage imgSquare = new ElementImage();
//        ElementImage imgSquare1 = new ElementImage();
//        ElementImage imgStar = new ElementImage();
//
//        sensor = Transformer.transformPoints(pngSquare, sensor);
//        Matrix2dByte m2dSquare = null;
//        m2dSquare = Transformer.transformPoints(sensor, m2dSquare);
//
//        sensor = Transformer.transformPoints(pngSquare1, sensor);
//        Matrix2dByte m2dSquare1 = null;
//        m2dSquare1 = Transformer.transformPoints(sensor, m2dSquare1);
//
//        sensor = Transformer.transformPoints(pngStar, sensor);
//        Matrix2dByte m2dStar = null;
//        m2dStar = Transformer.transformPoints(sensor, m2dStar);
//
//        ArrayList<ElementImage> squareImages = null;
//        squareImages = Transformer.transformPoints(m2dSquare, squareImages, maxDiff);
//        ArrayList<ElementImage> square1Images = null;
//        square1Images = Transformer.transformPoints(m2dSquare1, square1Images, maxDiff);
//        ArrayList<ElementImage> starImages = null;
//        starImages = Transformer.transformPoints(m2dStar, starImages, maxDiff);
//
//        Transformer.transformPoints(squareImage)
        //        for (ElementImage img: squareImages) {
//            Transformer.transformPoints(img, new PngFile(dirOut + "square_" + img.id + ".png"));
//        }
//        for (ElementImage img1: square1Images) {
//            Transformer.transformPoints(img1, new PngFile(dirOut + "square1_" + img1.id + ".png"));
//        }
//        for (ElementImage img2: starImages) {
//            Transformer.transformPoints(img2, new PngFile(dirOut + "star_" + img2.id + ".png"));
//        }
//    }

//    @Test
//    public void Image_findSegments() {
//        int maxDiff = 32;
//        double d = 0.10; // % of deviation from etalon line or arc
//        double minPoints = 0.90;
//        ArrayList<Curve> curves = new ArrayList<Curve>();
//        ElementImage img = new ElementImage();
//        img.loadPictureInM2dArgb(dirIn + imageFile);
//        ArrayList<Segment> segments = img.findSegments(maxDiff);
//        Segment.removeSegmentsByMinNumberOfPoints(10, segments);
//        for (Segment seg: segments) {
//            curves = new ArrayList<Curve>();
//            curves.addAll(Curve.findCurves2d(seg.points, d, minPoints) );
//            for(Curve c: curves) {
//                c.saveAs2dArgbImage(img.m2dArgbValues,dirOut + imageFile + seg.id + "_" + c.id + "_rgb.png", "png");
//            }
//            seg.saveAs2dArgbImage(img.m2dArgbValues,dirOut + imageFile + seg.id + "_rgb.png", "png");
//        }
//    }

//    @Test
//    public void findLine2dAngleGrade() {
//        Point c = new Point(0,0);
//        double r = 100;
//        Point p;
//        double a;
//        for (int grade = 0; grade<360; grade+=1) {
//            p = Curve.f_radCircle(c, r, grade*Math.PI/180);
//            a = Curve.findLine2dAngleGrade(c, p);
//            System.out.println(p.x + "," + p.y + " : " + a);
//        }
//    }


//    @Test
//    public void findLine2dStandartDeviation(){
//        Point p1 = new Point(298, 300);
//        Point p2 = new Point(506, 118);
//        double k = Geometry.findDirectLineCoeffK(p1, p2);
//        double b = Geometry.findDirectLineCoeffB(p2, k);
//        ArrayList<Point> points = new ArrayList<Point>();
//        for (int x =298; x<506; x++) {
//            points.add( new Point(x, (int)(k*x +b + 1)) );
//        }
//        double d = Curve.findLine2dStandartDeviation(points, p1, p2);
//        System.out.println("deviation: " + d);
//        // vertical line
//        p1 = new Point(298, 300);
//        p2 = new Point(298, 118);
//        points = new ArrayList<Point>();
//        int x;
//        for (int y = p2.y; y<=p1.y; y++) {
//            x = p1.x;
//            points.add( new Point(x+1, y) );
//        }
//        d = Curve.findLine2dStandartDeviation(points, p1, p2);
//        System.out.println("deviation: " + d);
//    }
//
//    @Test
//    public void findArc2dStandartDeviation(){
//        int startAngle =25;
//        int endAngle = 90;
//        Point p1 = new Point(402, 43);
//        Point p2 = new Point(263, 281);
//        Point p3 = new Point(492, 337);
//        Point c = Curve.findCircleRadius(p1, p2, p3);
//        double r = Curve.findPointsDistance(p1, c);
//        ArrayList<Point> points = new ArrayList<Point>();
//        Point p;
//        for(int a = startAngle; a<endAngle; a++) {
//            p = Curve.f_gradeCircle(c, r, a);
//            p.x+=1;
//            p.y+=1;
//            points.add( p );
//        }
//        double d = Curve.findArc2dStandartDeviation(points, c, r, startAngle, endAngle);
//        System.out.println("deviation: " + d);
//    }
//
//
//    @Test
//    public void findCircle2dStandartDeviation(){
//        Point p1 = new Point(402, 43);
//        Point p2 = new Point(263, 281);
//        Point p3 = new Point(492, 337);
//        Point c = Curve.findCircleRadius(p1, p2, p3);
//        double r = Curve.findPointsDistance(p1, c);
//        ArrayList<Point> points = new ArrayList<Point>();
//        Point p;
//        for(int a = 25; a<100; a++) {
//            p = Curve.f_gradeCircle(c, r, a);
//            p.x+=1;
//            p.y+=1;
//            points.add( p );
//        }
//        double d = Curve.findArc2dStandartDeviation(points, c, p1, p2);
//        System.out.println("deviation: " + d);
//    }
//
//
//    @Test
//    public void findCenterBy3Points() {
//        Point p1 = new Point(402, 43);
//        Point p2 = new Point(263, 281);
//        Point p3 = new Point(492, 337);
//        Point c = Curve.findCircleRadius(p1, p2, p3);
//        if(c == null){
//            System.out.println("no center");
//        }else {
//            System.out.println("x:" + c.x + ",y:" + c.y);
//        }
//    }
//
//
//    @Test
//    public void CurveGraph() {
//        CurveGraph graph = new CurveGraph();
//    }


//    @Test
//    public void Matrix2dArgbToMatrix2dHsv() {
//        Matrix2dArgb rgb = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dHsv hsv = MatrixConverter.matrix2dArgbToMatrix2dHsv(rgb);
//        rgb = MatrixConverter.matrix2dHsvToMatrix2dArgb(hsv);
//        rgb.save(dirOut + imageFile + "_rgb.png", "png");
//    }

//    @Test
//    public void compare_segments() {
//        ArrayList<Segment> segments = new ArrayList<Segment>();
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "А.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "Б.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "В.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "Е.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "З.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "К.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "Л.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "М.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "П.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "Р.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "Т.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "У.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "Ф.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "Ч.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "Ш.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "Щ.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "Э.dat").shiftPoints())) );
//        segments.add( MatrixConverter.matrix2dByteToBinSegment(MatrixConverter.segmentToMatrix2dByte(Segment.load(dirIn + "Я.dat").shiftPoints())) );
//
//        for (Segment s: segments) {
//            s.saveAs2dBooleanImage(dirOut + imageFile + s.id + ".png", "png");
//        }
//
//        Segment testSeg = segments.get(0);
//        double result;
//        for (Segment etalon: segments) {
//            result = CComparator.compareFormSegments(etalon, testSeg, 25, 10);
//            System.out.println("segId:"+etalon.id + "; " + result);
//        }
//
//    }



//
//    @Test
//    public void reduceHsvColorsByGistogram() {
//        int dist = 16;
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        m2d.save(dirOut + imageFile + "_check.png", "png");
//        Matrix2dHsv m2dHsv = MatrixConverter.matrix2dArgbToMatrix2dHsv(m2d);
//        Matrix2dHsv m2dHsv1 = m2dHsv.reduceColors(dist).reduceColors(dist).reduceColors(dist).reduceColors(dist).reduceColors(dist);
//        Matrix2dBoolean m2dBool = m2dHsv1.edgeByColorValue(dist);
//        m2dBool.save(dirOut + imageFile + "_bin.png", "png", TYPE_BYTE_GRAY);
//
//        int[] gist = m2dHsv1.countGistogramByValue();
//        for(int i = 0; i<256; i++) {
//            if(gist[i]>0) {
//                m2dBool = m2dHsv1.binarizeByValue(i, i);
//                m2dBool.save(dirOut + imageFile + "_bin"+i+".png", "png", TYPE_BYTE_GRAY);
//            }
//        }
//    }

//
//    @Test
//    public void countGistogramByValue() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        m2d.save(dirOut + imageFile + "_check.png", "png", TYPE_INT_ARGB);
//        Matrix2dHsv m2dHsv = MatrixConverter.matrix2dArgbToMatrix2dHsv(m2d);
//        int[] gist = m2dHsv.countGistogramByValue();
//        Matrix2dBoolean m2dBool = m2dHsv.binarizeByValue(26, 55);
//        m2dBool.save(dirOut + imageFile + "_bin26_55.png", "png", TYPE_BYTE_GRAY);
//
////        for(int i = 0; i<256; i++) {
////            if(gist[i]>0) {
////                Matrix2dBoolean m2dBool = m2dHsv.binarizeByValue(i, i);
////                m2dBool.save(dirOut + imageFile + "_bin"+i+".png", "png", TYPE_BYTE_GRAY);
////            }
////        }
//    }



//    @Test
//    public void edge(){
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dHsv hsv = MatrixConverter.matrix2dArgbToMatrix2dHsv(m2d);
//        Matrix2dByte bt = MatrixConverter.matrix2dHsvToMatrix2dByteByValue(hsv);
//        m2d = MatrixConverter.matrix2dByteValueTomatrix2dArgb(bt);
//        m2d.save(dirOut + imageFile + "_256.png", "png", TYPE_INT_ARGB);
//        Matrix2dArgb clr8 = m2d.reduceColors(32).save(dirOut + imageFile + "_clr8.png", "png", TYPE_BYTE_GRAY);
//        clr8.edgeByColorDistance(32).save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
//
////        m2d.edgeByColorDistance(1).save(dirOut + imageFile + "_edge1.png", "png", TYPE_BYTE_GRAY);
////        m2d.edgeByColorDistance(2).save(dirOut + imageFile + "_edge2.png", "png", TYPE_BYTE_GRAY);
////        m2d.edgeByColorDistance(4).save(dirOut + imageFile + "_edge4.png", "png", TYPE_BYTE_GRAY);
////        m2d.edgeByColorDistance(8).save(dirOut + imageFile + "_edge8.png", "png", TYPE_BYTE_GRAY);
////        m2d.edgeByColorDistance(16).save(dirOut + imageFile + "_edge16.png", "png", TYPE_BYTE_GRAY);
////        m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
////        m2d.edgeByColorDistance(64).save(dirOut + imageFile + "_edge64.png", "png", TYPE_BYTE_GRAY);
////        m2d.edgeByColorDistance(128).save(dirOut + imageFile + "_edge128.png", "png", TYPE_BYTE_GRAY);
//    }


//    @Test
//    public void selectByPattern4Pixels(){
//        int x = 645;
//        int y = 1465;
//        int dist = 32;
//        Matrix2dArgb in = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dArgb pattern = in.selectByPattern4Pixels(x, y, dist)
//                .save(dirOut + imageFile + "_ptrn.png", "png", TYPE_INT_ARGB);
//    }

//    @Test
//    public void comparePointsMethod() {
//        double dist = Matrix2dBoolean.comparePoints(0.5, 0.7,  0.3, 0.4);
//        System.out.println("dist = " + dist );
//    }

//    @Test
//    public void imageToBoolean() {
//        Matrix2dArgb in = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = in.edgeByColorDistance(16)
//                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
//        ElementImage img1 = MatrixConverter.matrix2dBooleanToImage(edge);
//        Matrix2dBoolean out = MatrixConverter.imageToMatrix2dBoolean(img1)
//            .save(dirOut + imageFile + "_img.png", "png", TYPE_BYTE_GRAY);
//    }

//    @Test
//    public void comparePointsNormalized() {
//        Matrix2dArgb base = Matrix2dArgb.load(dirIn + "anime20.png");
//        Matrix2dArgb in = Matrix2dArgb.load(dirIn + "anime.png");
//
//        Matrix2dBoolean baseEdge = base.edgeByColorDistance(16)
//                .replacePoints(true, 0, 1, -1,-1)
//                .replacePoints(false, 6, 8, -1,-1)
//                .skeletize()
//                .replace3x3(263, 262)
//                .replace3x3(29, 28)
//                .replace3x3(113, 112)
//                .replace3x3(449, 448)
//                .remove90points()
//                .save(dirOut + "A_cut" + "_edge.png", "png", TYPE_BYTE_GRAY);
//        ElementImage img1 = MatrixConverter.matrix2dBooleanToImage(baseEdge);
//
//        Matrix2dBoolean inEdge = in.edgeByColorDistance(16)
//                .replacePoints(true, 0, 1, -1,-1)
//                .replacePoints(false, 6, 8, -1,-1)
//                .skeletize()
//                .replace3x3(263, 262)
//                .replace3x3(29, 28)
//                .replace3x3(113, 112)
//                .replace3x3(449, 448)
//                .remove90points()
//                .save(dirOut + "A_cut2x" + "_edge.png", "png", TYPE_BYTE_GRAY);
//        ElementImage img2 = MatrixConverter.matrix2dBooleanToImage(inEdge);
//
//        double diff = CComparator.compareImages(img1, img2);
//
//        System.out.println("base n-points =" + baseEdge.countPoints() );
//        System.out.println("in n-points =" + inEdge.countPoints() );
//        System.out.println("diff = " + diff );
//    }


//    @Test
//    public void comparePoints() {
//        Matrix2dArgb base = Matrix2dArgb.load(dirIn + "anime20.png");
//        Matrix2dArgb in = Matrix2dArgb.load(dirIn + "anime.png");
//
//        Matrix2dBoolean baseEdge = base.edgeByColorDistance(16)
//                .replacePoints(true, 0, 1, -1,-1)
//                .replacePoints(false, 6, 8, -1,-1)
//                .skeletize()
//                .replace3x3(263, 262)
//                .replace3x3(29, 28)
//                .replace3x3(113, 112)
//                .replace3x3(449, 448)
//                .remove90points()
//                .save(dirOut + "A_cut" + "_edge.png", "png", TYPE_BYTE_GRAY);
//
//        Matrix2dBoolean inEdge = in.edgeByColorDistance(16)
//                .replacePoints(true, 0, 1, -1,-1)
//                .replacePoints(false, 6, 8, -1,-1)
//                .skeletize()
//                .replace3x3(263, 262)
//                .replace3x3(29, 28)
//                .replace3x3(113, 112)
//                .replace3x3(449, 448)
//                .remove90points()
//                .save(dirOut + "A_cut2x" + "_edge.png", "png", TYPE_BYTE_GRAY);
//
//        double diff = Matrix2dBoolean.comparePoints(baseEdge, inEdge);
//
//        System.out.println("base n-points =" + baseEdge.countPoints() );
//        System.out.println("in n-points =" + inEdge.countPoints() );
//        System.out.println("diff = " + diff );
//    }



//    @Test
//    public void removeByColorDistance() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile).stretch2x();
//        Matrix2dArgb edge16 = m2d.removeByColorDistance(16).save(dirOut + imageFile + "_16.png", "png", TYPE_INT_ARGB);
//        Matrix2dArgb edge32 = m2d.removeByColorDistance(32).save(dirOut + imageFile + "_32.png", "png", TYPE_INT_ARGB);
//        Matrix2dArgb edge64 = m2d.removeByColorDistance(64).save(dirOut + imageFile + "_64.png", "png", TYPE_INT_ARGB);
//        Matrix2dArgb edge128 = m2d.removeByColorDistance(128).save(dirOut + imageFile + "_128.png", "png", TYPE_INT_ARGB);
//    }
//
//    @Test
//    public void detectConture() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = m2d.edgeByColorDistance(16)
//                .replacePoints(true, 0, 1, -1,-1)
//                .replacePoints(false, 6, 8, -1,-1)
//                .skeletize()
//                .replace3x3(263, 262)
//                .replace3x3(29, 28)
//                .replace3x3(113, 112)
//                .replace3x3(449, 448)
//                .remove90points()
//                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
//        System.out.println("n=" + edge.countPoints() );
//        Matrix2dGraph graph = edge.toGraph();
////        Graph.findLines( 0, 5, 135, 180);
////        System.out.println("n=" + Graph.countPoints() );
//        graph.findLines( 0, Double.MAX_VALUE, 135, 180);
//        System.out.println("n=" + graph.countPoints() );
//        Matrix2dBoolean lines = graph.toBooleanOnlyPoints()
//                .save(dirOut + imageFile + "_lines.png", "png", TYPE_BYTE_GRAY);
//    }
//
//
//    @Test
//    public void detectRounds() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = m2d.edgeByColorDistance(16)
//                .replacePoints(true, 0, 1, -1,-1)
//                .replacePoints(false, 6, 8, -1,-1)
//                .skeletize()
//                .replace3x3(263, 262)
//                .replace3x3(29, 28)
//                .replace3x3(113, 112)
//                .replace3x3(449, 448)
//                .remove90points()
//                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
//        System.out.println("n=" + edge.countPoints() );
//        Matrix2dGraph graph = edge.toGraph();
////        Graph.findLines( 0, 5, 135, 180);
////        System.out.println("n=" + Graph.countPoints() );
//        graph.findLines( 0, Double.MAX_VALUE, 135, 180);
//        System.out.println("n=" + graph.countPoints() );
//        Matrix2dBoolean lines = graph.toBoolean()
//                .save(dirOut + imageFile + "_lines.png", "png", TYPE_BYTE_GRAY);
//    }
//
//
//    @Test
//    public void detectLine() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = m2d.edgeByColorDistance(16)
//                .replacePoints(true, 0, 1, -1,-1)
//                .replacePoints(false, 6, 8, -1,-1)
//                .skeletize()
//                .replace3x3(263, 262)
//                .replace3x3(29, 28)
//                .replace3x3(113, 112)
//                .replace3x3(449, 448)
//                .remove90points()
//                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
//        System.out.println("n=" + edge.countPoints() );
//        Matrix2dGraph graph = edge.toGraph();
////        Graph.findLines( 0, 5, 135, 180);
////        System.out.println("n=" + Graph.countPoints() );
//        graph.findLines( 0, Double.MAX_VALUE, 135, 180);
//        System.out.println("n=" + graph.countPoints() );
//        Matrix2dBoolean lines = graph.toBoolean()
//                .save(dirOut + imageFile + "_lines.png", "png", TYPE_BYTE_GRAY);
//    }

//    @Test
//    public void lineAngles() {
//        double a;
//        a = Matrix2dGraph.findAngle(new Point2d(10, 10), new Point2d(10, 20), new Point2d(20, 10) );
//        System.out.println("a must be 90 : " + a);
//        a = Matrix2dGraph.findAngle(new Point2d(10, 10), new Point2d(10, 20), new Point2d(20, 20) );
//        System.out.println("a must be 45 : " + a);
//
//        a = Matrix2dGraph.findAngle(new Point2d(10, 10), new Point2d(1, 10), new Point2d(20, 20) );
//        System.out.println("a must be 135 : " + a);
//    }

//    @Test
//    public void toGraph() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = m2d.stretch2x().edgeByColorDistance(32)
//                .save(dirOut + imageFile + "_edge1.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dBoolean clearNoise = edge
////                .reduceNoisePoints(1).reduceInnerPoints(6).reduceGapPointsInMask(5).reduceGapPointsInMask(5)
//                .replace3x3(263, 262)
//                .replace3x3(29, 28)
//                .replace3x3(113, 112)
//                .replace3x3(449, 448)
////                .reduceNoisePoints(1).reduceGapPointsInMask(5).reduceNoisePoints(3).reduceGapPointsInMask(5).reduceNoisePoints(3)
//                .save(dirOut + imageFile + "_clearNoise.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dBoolean edge2 = clearNoise.edge()
//                .save(dirOut + imageFile + "_edge2.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dBoolean skeleton = edge2.skeletonByZhangSuen()
////                .reduceNoisePoints(1)
//                .save(dirOut + imageFile + "_skeleton.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dBoolean edge3 = skeleton.remove90points()
//                .save(dirOut + imageFile + "_edge3.png", "png", TYPE_BYTE_GRAY);;
////        Matrix2dBoolean edge3 = edge2.remove90points()
////                .save(dirOut + imageFile + "_edge3.png", "png", TYPE_BYTE_GRAY);;
//        // ===========================================================
//        System.out.println("n: " + edge3.countPoints() );
//        // ===========================================================
//        Matrix2dGraph graph = edge3.toGraph();
//        graph.findLines(0, 10, 0.0, 180)
//                .findLines(10, Double.MAX_VALUE, 160.0, 180);
//
////            .findLines( 0.7, 0, 5, 0.0, 180)
////            .findLines( 0.7, 0, 5, 0.0, 180)
////            .findLines( 0.7, 0, 5, 135.0, 180)
////                .findLines( 0.3, 6, 10)
////                .findLines( 0.3, 6, 10)
////                .findLines( 0.3, 6, 10)
////                .findLines( 0.15, 11, 20)
////                .findLines( 0.15, 11, 20)
////                .findLines( 0.15, 11, 10)
////                .findLines(0.1, 5.0, 20, 135, 180)
////                .findLines(0.1, 5.0, 30, 135, 180)
////                .findLines(0.1, 5.0, 45, 135, 180);
//
//        //                .findLines(0.1, 10.0, Double.MAX_VALUE, 135, 180);
////                .findLines(0.1, 31.0, Double.MAX_VALUE, 135, 180)
////                .findLines(0.1, 63.0, Double.MAX_VALUE, 135, 180);
//
//        //                .findLines(0.1, 1.0, Double.MAX_VALUE);
////                .findLines(0.1);
//
////        Graph.findLines(0.03).findLines(0.03).findLines(0.03).findLines(0.03).findLines(0.03)
////                .findLines(0.03).findLines(0.03).findLines(0.03).findLines(0.03).findLines(0.03);
//        // ========================================================
//        System.out.println("n: " + graph.countPoints() );
//        // ========================================================
//        Matrix2dBoolean lines = graph.toBoolean()
//                .save(dirOut + imageFile + "_lines.png", "png", TYPE_BYTE_GRAY);
//    }

//    @Test
//    public void binaryEdge() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = m2d.stretch2x().edgeByColorDistance(32)
//                .save(dirOut + imageFile + "_edge1.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dBoolean clearNoise = edge
////                .reduceNoisePoints(1)
////                .reduceInnerPoints(6)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .replace3x3(263, 262)
////                .replace3x3(29, 28)
////                .replace3x3(113, 112)
////                .replace3x3(449, 448)
////                .reduceNoisePoints(1)
////                .reduceGapPointsInMask(5)
////                .reduceNoisePoints(3)
////                .reduceGapPointsInMask(5)
////                .reduceNoisePoints(3)
//                .save(dirOut + imageFile + "_clearNoise.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dBoolean edge2 = clearNoise.edge()
//                .save(dirOut + imageFile + "_edge2.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dBoolean skeleton = edge2.skeletonByZhangSuen()
////                .reduceNoisePoints(1)
//                .save(dirOut + imageFile + "_skeleton.png", "png", TYPE_BYTE_GRAY);
//    }

//    @Test
//    public void GapAndNoiseAndSkeletonByZhangSuen() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = m2d.edgeByColorDistance(32)
//                .save(dirOut + imageFile + "_edge.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dBoolean gn = edge//.reduceNoisePoints(2)
////                .reduceNoisePoints(3)
////                .reduceNoisePoints(3)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
////                .reduceGapPointsInMask(5)
//                .save(dirOut + imageFile + "_gn.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dBoolean skeleton = gn.skeletonByZhangSuen()
//                .save(dirOut + imageFile + "_skeleton.png", "png", TYPE_BYTE_GRAY);
//
//
//
//        int i, j, n;
//        n = 0;
//        int sX = skeleton.size;
//        int sY = skeleton.sizeY;
//        for(j = 0; j<sY;j++ ){
//            for(i = 0; i<sX;i++ ){
//                if( skeleton.getValue(i, j) ) n++;
//            }
//        }
//        System.out.println("white pixels: " + n);
//
//
//        n = 0;
//        sX = gn.size;
//        sY = gn.sizeY;
//        for(j = 0; j<sY;j++ ){
//            for(i = 0; i<sX;i++ ){
//                if( gn.getValue(i, j) ) n++;
//            }
//        }
//        System.out.println("white pixels gn: " + n);
//    }


//    @Test
//    public void SkeletonByZhangSuen() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = m2d.edgeByColorDistance(32)
//                .save(dirOut + imageFile + "_edge1.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dBoolean skeleton = edge.skeletonByZhangSuen()
//                .save(dirOut + imageFile + "_skeleton.png", "png", TYPE_BYTE_GRAY);
//    }

//    @Test
//    public void tangen() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
//        Point2d cp = edge.countCenterOfSymmetry();
//        System.out.println("center( " + cp.x + ", " + cp.y + "° )");
//        int a = edge.countAngleAxisOfSymmetry(cp);
//        System.out.println(a + "°");
//    }
//
//    @Test
//    public void tangens() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + "line20.png");
//        Matrix2dBoolean edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
//        Point2d cp = edge.countCenterOfSymmetry();
//        int a = edge.countAngleAxisOfSymmetry(cp);
//        System.out.println("20 : " + a + "°");
//
//        m2d = Matrix2dArgb.load(dirIn + "line45.png");
//        edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
//        cp = edge.countCenterOfSymmetry();
//        a = edge.countAngleAxisOfSymmetry(cp);
//        System.out.println("45 : " + a + "°");
//
//        m2d = Matrix2dArgb.load(dirIn + "line60.png");
//        edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
//        cp = edge.countCenterOfSymmetry();
//        a = edge.countAngleAxisOfSymmetry(cp);
//        System.out.println("60 : " + a + "°");
//
//        m2d = Matrix2dArgb.load(dirIn + "line100.png");
//        edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
//        cp = edge.countCenterOfSymmetry();
//        a = edge.countAngleAxisOfSymmetry(cp);
//        System.out.println("100 : " + a + "°");
//
//        m2d = Matrix2dArgb.load(dirIn + "line135.png");
//        edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
//        cp = edge.countCenterOfSymmetry();
//        a = edge.countAngleAxisOfSymmetry(cp);
//        System.out.println("135 : " + a + "°");
//    }
//
//    @Test
//    public void stretchAndEdgeByColorDistance() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dArgb stretched = m2d.stretch2x()
//                .save(dirOut + imageFile + "_2x.png", "png", TYPE_INT_ARGB);
//        stretched.edgeByColorDistance(1).save(dirOut + imageFile + "_edge1.png", "png", TYPE_BYTE_GRAY);
//        stretched.edgeByColorDistance(2).save(dirOut + imageFile + "_edge2.png", "png", TYPE_BYTE_GRAY);
//        stretched.edgeByColorDistance(4).save(dirOut + imageFile + "_edge4.png", "png", TYPE_BYTE_GRAY);
//        stretched.edgeByColorDistance(8).save(dirOut + imageFile + "_edge8.png", "png", TYPE_BYTE_GRAY);
//        stretched.edgeByColorDistance(16).save(dirOut + imageFile + "_edge16.png", "png", TYPE_BYTE_GRAY);
//        stretched.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32.png", "png", TYPE_BYTE_GRAY);
//        stretched.edgeByColorDistance(64).save(dirOut + imageFile + "_edge64.png", "png", TYPE_BYTE_GRAY);
//        stretched.edgeByColorDistance(128).save(dirOut + imageFile + "_edge128.png", "png", TYPE_BYTE_GRAY);
//    }
//
//
//    @Test
//    public void countCenterOfSymmetry() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dBoolean edge;
//        Point2d pc;
//        edge = m2d.edgeByColorDistance(1).save(dirOut + imageFile + "_edge1h.png", "png", TYPE_BYTE_GRAY);
//        pc = edge.countCenterOfSymmetry();
//        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
//        edge = m2d.edgeByColorDistance(2).save(dirOut + imageFile + "_edge2h.png", "png", TYPE_BYTE_GRAY);
//        pc = edge.countCenterOfSymmetry();
//        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
//        edge = m2d.edgeByColorDistance(4).save(dirOut + imageFile + "_edge4h.png", "png", TYPE_BYTE_GRAY);
//        pc = edge.countCenterOfSymmetry();
//        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
//        edge = m2d.edgeByColorDistance(8).save(dirOut + imageFile + "_edge8h.png", "png", TYPE_BYTE_GRAY);
//        pc = edge.countCenterOfSymmetry();
//        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
//        edge = m2d.edgeByColorDistance(16).save(dirOut + imageFile + "_edge16h.png", "png", TYPE_BYTE_GRAY);
//        pc = edge.countCenterOfSymmetry();
//        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
//        edge = m2d.edgeByColorDistance(32).save(dirOut + imageFile + "_edge32h.png", "png", TYPE_BYTE_GRAY);
//        pc = edge.countCenterOfSymmetry();
//        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
//        edge = m2d.edgeByColorDistance(64).save(dirOut + imageFile + "_edge64h.png", "png", TYPE_BYTE_GRAY);
//        pc = edge.countCenterOfSymmetry();
//        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
//        edge = m2d.edgeByColorDistance(128).save(dirOut + imageFile + "_edge128h.png", "png", TYPE_BYTE_GRAY);
//        pc = edge.countCenterOfSymmetry();
//        System.out.println("cx = " + pc.x + "; cy = " + pc.y);
//    }
//
//
//    @Test
//    public void stretchAndEdgeByColorHue() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dArgb stretched = m2d.stretch2x()
//                .save(dirOut + imageFile + "_2x.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dHsv hsv = MatrixConverter.matrix2dArgbToMatrix2dHsv(stretched);
//        hsv.edgeByColorHue(1).save(dirOut + imageFile + "_edge1h.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorHue(2).save(dirOut + imageFile + "_edge2h.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorHue(4).save(dirOut + imageFile + "_edge4h.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorHue(8).save(dirOut + imageFile + "_edge8h.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorHue(16).save(dirOut + imageFile + "_edge16h.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorHue(32).save(dirOut + imageFile + "_edge32h.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorHue(64).save(dirOut + imageFile + "_edge64h.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorHue(128).save(dirOut + imageFile + "_edge128h.png", "png", TYPE_BYTE_GRAY);
//    }
//
//    @Test
//    public void stretchAndEdgeByColorSaturation() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dArgb stretched = m2d.stretch2x()
//                .save(dirOut + imageFile + "_2x.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dHsv hsv = MatrixConverter.matrix2dArgbToMatrix2dHsv(stretched);
//        hsv.edgeByColorSaturation(1).save(dirOut + imageFile + "_edge1s.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorSaturation(2).save(dirOut + imageFile + "_edge2s.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorSaturation(4).save(dirOut + imageFile + "_edge4s.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorSaturation(8).save(dirOut + imageFile + "_edge8s.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorSaturation(16).save(dirOut + imageFile + "_edge16s.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorSaturation(32).save(dirOut + imageFile + "_edge32s.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorSaturation(64).save(dirOut + imageFile + "_edge64s.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorSaturation(128).save(dirOut + imageFile + "_edge128s.png", "png", TYPE_BYTE_GRAY);
//    }
//
//    @Test
//    public void stretchAndEdgeByColorValue() {
//        Matrix2dArgb m2d = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dArgb stretched = m2d.stretch2x()
//                .save(dirOut + imageFile + "_2x.png", "png", TYPE_BYTE_GRAY);
//        Matrix2dHsv hsv = MatrixConverter.matrix2dArgbToMatrix2dHsv(stretched);
//        hsv.edgeByColorValue(1).save(dirOut + imageFile + "_edge1v.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorValue(2).save(dirOut + imageFile + "_edge2v.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorValue(4).save(dirOut + imageFile + "_edge4v.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorValue(8).save(dirOut + imageFile + "_edge8v.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorValue(16).save(dirOut + imageFile + "_edge16v.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorValue(32).save(dirOut + imageFile + "_edge32v.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorValue(64).save(dirOut + imageFile + "_edge64v.png", "png", TYPE_BYTE_GRAY);
//        hsv.edgeByColorValue(128).save(dirOut + imageFile + "_edge128v.png", "png", TYPE_BYTE_GRAY);
//    }

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

//    @Test
//    public void checkReduce(){
//        int x = 879;
//        int y = 297;
//        int r = 5;
//        Matrix2dArgb m1x = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dArgb m1x2 = m1x.reduce(2).save(dirOut + imageFile + "1x2.png", "png", TYPE_INT_ARGB);
//        Matrix2dArgb m1x4 = m1x2.reduce(2).save(dirOut + imageFile + "1x4.png", "png", TYPE_INT_ARGB);
//        Matrix2dArgb m1x8 = m1x4.reduce(2).save(dirOut + imageFile + "1x8.png", "png", TYPE_INT_ARGB);
//        Matrix2dArgb m1x16 = m1x8.reduce(2).save(dirOut + imageFile + "1x16.png", "png", TYPE_INT_ARGB);
//        Matrix2dArgb m1x32 = m1x16.reduce(2).save(dirOut + imageFile + "1x32.png", "png", TYPE_INT_ARGB);
//        Matrix2dArgb m1x64 = m1x32.reduce(2).save(dirOut + imageFile + "1x64.png", "png", TYPE_INT_ARGB);
//    }

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
//        int size, sizeY;
//        ARGB pixel;
//        int color;
//        ARGB empty = new ARGB(0x00, 0, 0, 0);
//        ARGB[][] pixels;
//        int a, r, g, b;
//        Matrix2d<ARGB> m0 = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> mGrey = Matrix2dArgbFilter.argbToGrey256(m0);
//        Matrix2dFileWriter.saveRGB(mGrey, dirIn + imageFile + "_grey256.png", "png");
//        Matrix2d<ARGB> mReduceColors = new Matrix2d(ARGB.class, mGrey.size, mGrey.sizeY);
//        size = mGrey.size;
//        sizeY = mGrey.sizeY;
//        int[] colorFrequency = Matrix2dStatistic.argbColors(mGrey);
//        for(k=0; k<=255; k++) System.out.println(colorFrequency[k]);
//        for(j = 0; j<sizeY; j++) {
//            for (i = 0; i < size; i++) {
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
////            for (i = 0; i < size; i++) {
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
//        Matrix2d<ARGB> m1 = new Matrix2d<ARGB>(ARGB.class, m0.size, m0.sizeY);
//        Matrix2d<ARGB> m1_1 = new Matrix2d<ARGB>(ARGB.class, m0.size, m0.sizeY);
//        Matrix2d<ARGB> m1_2 = new Matrix2d<ARGB>(ARGB.class, m0.size, m0.sizeY);
//
//        Matrix2d<ARGB> m2 = new Matrix2d<ARGB>(ARGB.class, m0.size, m0.sizeY);
//        Matrix2d<ARGB> m2_1 = new Matrix2d<ARGB>(ARGB.class, m0.size, m0.sizeY);
//        Matrix2d<ARGB> m2_2 = new Matrix2d<ARGB>(ARGB.class, m0.size, m0.sizeY);
//
//        ARGB threshold = Matrix2dStatistic.middleColor(m0);
//        Matrix2dArgbFilter.argbToMaskByThreshold(m0, m1, m2, threshold, 0,0, m0.size, m0.sizeY);
//        Matrix2dFileWriter.saveRGB(m1, dirIn + imageFile + "_m1_Mask.png", "png");
//        Matrix2dFileWriter.saveRGB(m2, dirIn + imageFile + "_m2_Mask.png", "png");
//
//        threshold = Matrix2dStatistic.middleColor(m0, m1, 0,0, m0.size, m0.sizeY);
//        Matrix2dArgbFilter.argbToMaskByThreshold(m0, m1_1, m1_2, m1, threshold, 0,0, m0.size, m0.sizeY);
//        Matrix2dFileWriter.saveRGB(m1_1, dirIn + imageFile + "_m1_1_Mask.png", "png");
//        Matrix2dFileWriter.saveRGB(m1_2, dirIn + imageFile + "_m1_2_Mask.png", "png");
//
//        threshold = Matrix2dStatistic.middleColor(m0, m2, 0,0, m0.size, m0.sizeY);
//        Matrix2dArgbFilter.argbToMaskByThreshold(m0, m2_1, m2_2, m2, threshold, 0,0, m0.size, m0.sizeY);
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
//            for (i = 0; i < size; i++) {
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
//        int size, sizeY;
//        ARGB pixel;
//        int color;
//        ARGB empty = new ARGB(0x00, 0, 0, 0);
//        ARGB[][] pixels;
//        int a, r, g, b;
//        Matrix2d<ARGB> m0 = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> mGrey = Matrix2dArgbFilter.argbToGrey256(m0);
//        Matrix2dFileWriter.saveRGB(mGrey, dirIn + imageFile + "_grey256.png", "png");
//        Matrix2d<ARGB> mReduceColors = new Matrix2d(ARGB.class, mGrey.size, mGrey.sizeY);
//        size = mGrey.size;
//        sizeY = mGrey.sizeY;
//        int[] colorFrequency = Matrix2dStatistic.argbColors(mGrey);
//        int[] colorFrequencySorted = Arrays.copyOf(colorFrequency,256);
//        Arrays.sort(colorFrequencySorted);
//        minLColorFrequency = colorFrequencySorted[256-colors];
////        for (k = 0; k <= 255; k++) System.out.println(colorFrequency[k]);
//        for (j = 0; j < sizeY; j++) {
//            for (i = 0; i < size; i++) {
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

}