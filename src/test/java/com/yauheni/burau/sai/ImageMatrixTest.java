package com.yauheni.burau.sai;

import core.matrix.Matrix2d;
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

    @Test
    public void checkReduce(){
        int x = 879;
        int y = 297;
        int r = 5;
        Matrix2d m1x = Matrix2d.load(dirIn + imageFile);
        Matrix2d m1x2 = m1x.reduce(2).save(dirOut + imageFile + "1x2.png", "png", TYPE_INT_ARGB);
        Matrix2d m1x4 = m1x2.reduce(2).save(dirOut + imageFile + "1x4.png", "png", TYPE_INT_ARGB);
        Matrix2d m1x8 = m1x4.reduce(2).save(dirOut + imageFile + "1x8.png", "png", TYPE_INT_ARGB);
        Matrix2d m1x16 = m1x8.reduce(2).save(dirOut + imageFile + "1x16.png", "png", TYPE_INT_ARGB);
        Matrix2d m1x32 = m1x16.reduce(2).save(dirOut + imageFile + "1x32.png", "png", TYPE_INT_ARGB);
        Matrix2d m1x64 = m1x32.reduce(2).save(dirOut + imageFile + "1x64.png", "png", TYPE_INT_ARGB);
    }

    @Test
    public void average(){
        Matrix2d m2d = Matrix2d.load(dirIn + imageFile);
        m2d.average().average().average().save(dirOut + imageFile + "_average.png", "png", TYPE_INT_ARGB);
    }

    @Test
    public void edge(){
        int r = 16;
        Matrix2d m2d = Matrix2d.load(dirIn + imageFile);
        Matrix2d edge = m2d.edge(r);
        Matrix2d red = edge.channel(Matrix2d.RED).save(dirOut + imageFile + "_R.png", "png", TYPE_BYTE_GRAY);
        Matrix2d green = edge.channel(Matrix2d.GREEN).save(dirOut + imageFile + "_G.png", "png", TYPE_BYTE_GRAY);
        Matrix2d blue = edge.channel(Matrix2d.BLUE).save(dirOut + imageFile + "_B.png", "png", TYPE_BYTE_GRAY);
        Matrix2d and = Matrix2d.and(red, green, blue).save(dirOut + imageFile + "_AND.png", "png", TYPE_BYTE_GRAY);
    }

    @Test
    public void getShape(){
        int r = 16;
        int x = 450;
        int y = 1139;
        Matrix2d m2d = Matrix2d.load(dirIn + imageFile);
        Matrix2d edge = m2d.edge(r);
        Matrix2d red = edge.channel(Matrix2d.RED).save(dirOut + imageFile + "_R.png", "png", TYPE_BYTE_GRAY);
        Matrix2d green = edge.channel(Matrix2d.GREEN).save(dirOut + imageFile + "_G.png", "png", TYPE_BYTE_GRAY);
        Matrix2d blue = edge.channel(Matrix2d.BLUE).save(dirOut + imageFile + "_B.png", "png", TYPE_BYTE_GRAY);
        Matrix2d and = Matrix2d.and(red, green, blue).save(dirOut + imageFile + "_AND.png", "png", TYPE_BYTE_GRAY);

        Matrix2d shape = and.getShape(x,y).save(dirOut + imageFile + "_shape.png", "png", TYPE_BYTE_GRAY);
    }

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