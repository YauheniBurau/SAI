package com.yauheni.burau.sai;

import core.application.VertexValue.color.ARGB;
import core.application.VertexValue.file.PngFile;
import core.application.VertexValue.matrix.Matrix2d;
import core.application.graph.Graph;
import core.application.process.FileToMatrix.PngFileToM2dArgb;
import core.application.process.MatrixToGraph.M2dArgbToGraphVertexSegment2d;
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
//    String imageFile = "alphabet_number.png";
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
    String imageFile = "star3.png";
//    String imageFile = "circle.png";
//    String imageFile = "screenElements.png";
//    String imageFile = "256Colors.png";


    @Test
    public void Png_GraphSegment2d_humanFiles() {
        PngFile pngFileIn = new PngFile(dirIn + imageFile);
        Matrix2d<ARGB> m2dArgb = PngFileToM2dArgb.transform(pngFileIn);
        Graph graph = M2dArgbToGraphVertexSegment2d.transform(m2dArgb);
        graph.toHumanFile(dirOut);
    }


//    @Test
//    public void Png_Graph_humanFiles() {
//        PngFile pngFileIn = new PngFile(dirIn + imageFile);
//        Matrix2d<ARGB> m2dArgb = PngFileToM2dArgb.transform(pngFileIn);
//        Matrix2dByte m2dByte = M2dArgbToM2dByte256Colors.transform(m2dArgb);
//        CloudOfDecart2dInt rootCloud = M2dByteToCloudOfDecart2dInt.transform(m2dByte);
//        Graph graph = CloudOfDecart2dIntToGraph.transform(rootCloud);
//        graph.toHumanFile(dirOut);
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
//    public void selectByPattern4Pixels(){
//        int x = 645;
//        int y = 1465;
//        int dist = 32;
//        Matrix2dArgb in = Matrix2dArgb.load(dirIn + imageFile);
//        Matrix2dArgb pattern = in.selectByPattern4Pixels(x, y, dist)
//                .save(dirOut + imageFile + "_ptrn.png", "png", TYPE_INT_ARGB);
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