package com.yauheni.burau.sai;

import core.matrix.Matrix2d;
import org.junit.Test;

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
    String imageFile = "table.png";
//    String imageFile = "table.JPG";
//    String imageFile = "nature1.jpeg";
//    String imageFile = "stown.png";

    @Test
    public void checkReduce(){
        int x = 879;
        int y = 297;
        int r = 5;
        Matrix2d m1x = Matrix2d.load(dirIn + imageFile);
        Matrix2d m1x2 = m1x.reduce(2).save(dirOut + imageFile + "1x2.png", "png");
        Matrix2d m1x4 = m1x2.reduce(2).save(dirOut + imageFile + "1x4.png", "png");
        Matrix2d m1x8 = m1x4.reduce(2).save(dirOut + imageFile + "1x8.png", "png");
        Matrix2d m1x16 = m1x8.reduce(2).save(dirOut + imageFile + "1x16.png", "png");
        Matrix2d m1x32 = m1x16.reduce(2).save(dirOut + imageFile + "1x32.png", "png");
        Matrix2d m1x64 = m1x32.reduce(2).save(dirOut + imageFile + "1x64.png", "png");
    }

//    @Test
//    public void argbToAlpha(){
////        int x = 150;
////        int y = 591;
//        int x = 676;
//        int y = 386;
//        int r = 16;
//        ARGB color;
//        Matrix2d<ARGB> m = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m2d = Matrix2dConverter.matrix2dArgbToColorsNxNxN(m, 2);
////        Matrix2d<ARGB> m2d = Matrix2dArgbFilter.argbToColorDiff(m);
//        color = m2d.getValue(x,y);
//        Matrix2d<ARGB> m2dMask = Matrix2dArgbFilter.argbToAlpha(m2d, color, r);
//        Matrix2dFileWriter.saveRGB(m2dMask, dirIn + imageFile + "_Alpha16.png", "png");
//    }
//
//    @Test
//    public void checkRgbToColorDiff1(){
//        Matrix2d<ARGB> m2d = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m1 = Matrix2dArgbFilter.argbToColorDiff(m2d);
//        Matrix2dFileWriter.saveRGB(m1, dirIn + imageFile +"_rgbToColorDiff1.png", "png");
//        Matrix2d<ARGB> m2 = Matrix2dArgbFilter.argbToColorDiff(m1);
//        Matrix2dFileWriter.saveRGB(m2, dirIn + imageFile + "_rgbToColorDiff2.png", "png");
//        Matrix2d<ARGB> m3 = Matrix2dArgbFilter.argbToColorDiff(m2);
//        Matrix2dFileWriter.saveRGB(m3, dirIn + imageFile + "_rgbToColorDiff3.png", "png");
//        Matrix2d<ARGB> m4 = Matrix2dArgbFilter.argbToColorDiff(m3);
//        Matrix2dFileWriter.saveRGB(m4, dirIn + imageFile + "_rgbToColorDiff4.png", "png");
//        Matrix2d<ARGB> m5 = Matrix2dArgbFilter.argbToColorDiff(m4);
//        Matrix2dFileWriter.saveRGB(m5, dirIn + imageFile + "_rgbToColorDiff5.png", "png");
//    }
//
//    @Test
//    public void checkRgbToColorDiff2(){
//        Matrix2d<ARGB> m2d = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m = Matrix2dArgbFilter.argbToColorDiff(m2d);
//        Matrix2dFileWriter.saveRGB(m, dirIn + imageFile +"_rgbToColorDiff.png", "png");
//    }
//
//    @Test
//    public void checkRgbToColorDiffWithLevel(){
//        Matrix2d<ARGB> m2d = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m = Matrix2dArgbFilter.argbToColorDiff(m2d);
//        Matrix2d<ARGB> m2dLevel;
//        for(int minLevel = 0; minLevel<=255; minLevel += 25) {
//            m2dLevel = Matrix2dArgbFilter.argbMinMax(m, 0, 255, minLevel, 255, minLevel, 255, minLevel, 255);
//            Matrix2dFileWriter.saveRGB(m2dLevel, dirIn + imageFile +"_diffAndLevel" + minLevel + ".jpg", "jpg");
//        }
//    }
//
//    @Test
//    public void checkMatrixReducex4_ColorDiff(){
//        Matrix2d<ARGB> matrix2D = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> reduced = Matrix2dTransform.reduce(matrix2D, 4);
//        Matrix2d<ARGB> colorDiff = Matrix2dArgbFilter.argbToColorDiff(reduced);
//        Matrix2d<ARGB> level;
//        for(int minLevel = 0; minLevel<=255; minLevel += 25) {
//            level = Matrix2dArgbFilter.argbMinMax(colorDiff, 0, 255, minLevel, 255, minLevel, 255, minLevel, 255);
//            Matrix2dFileWriter.saveRGB(level, dirIn + imageFile + "_reducedx4_diffWithLevel" + minLevel + ".png", "png");
//        }
//    }
//
//    @Test
//    public void checkRgbToColorDiffWithLevel_127_256(){
//        Matrix2d<ARGB> m2d = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m = Matrix2dArgbFilter.argbToColorDiff(m2d);
//        Matrix2d<ARGB> m2dLevel;
//        int minLevel =128;
//        int maxLevel = 256;
//        m2dLevel = Matrix2dArgbFilter.argbMinMax(m, 0, 255, minLevel, maxLevel, minLevel, maxLevel, minLevel, maxLevel);
//        Matrix2dFileWriter.saveRGB(m2dLevel, dirIn + imageFile + "_diffWithLevel_"+ minLevel + "_" + maxLevel +".jpg", "jpg");
//    }
//
//    @Test
//    public void checkRgbToGrey256AndColorDiff(){
//        Matrix2d<ARGB> m2d = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m2dGrey256 = Matrix2dArgbFilter.rgbToGrey256(m2d);
//        Matrix2dFileWriter.saveRGB(m2dGrey256, dirIn + imageFile + "_rgbToGrey256.png", "png");
//        Matrix2d<ARGB> m2dDiff = Matrix2dArgbFilter.argbToColorDiff(m2dGrey256);
//        Matrix2dFileWriter.saveRGB(m2dDiff, dirIn + imageFile + "_rgbToGrey256AndDiff.png", "png");
//    }
//
//    @Test
//    public void ColorDiffAndColors8() {
//        Matrix2d<ARGB> matrix2D = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m2dDiff = Matrix2dArgbFilter.argbToColorDiff(matrix2D);
//        Matrix2d<ARGB> colors8 = Matrix2dConverter.matrix2dArgbToColors8(m2dDiff);
//        Matrix2dFileWriter.saveRGB(colors8, dirIn + imageFile + "_ColorDiffAndColors8.png", "png");
//    }
//
//    @Test
//    public void ColorDiffAndColors4() {
//        Matrix2d<ARGB> matrix2D = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m2dDiff = Matrix2dArgbFilter.argbToColorDiff(matrix2D);
//        Matrix2d<ARGB> colors4 = Matrix2dConverter.matrix2dArgbToColors4(m2dDiff);
//        Matrix2dFileWriter.saveRGB(colors4, dirIn + imageFile + "_ColorDiffAndColors4.png", "png");
//    }
//
//    @Test
//    public void ColorDiffAndColors2() {
//        Matrix2d<ARGB> matrix2D = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m2dDiff = Matrix2dArgbFilter.argbToColorDiff(matrix2D);
//        Matrix2d<ARGB> colors2 = Matrix2dConverter.matrix2dArgbToColors2(m2dDiff);
//        Matrix2dFileWriter.saveRGB(colors2, dirIn + imageFile + "_ColorDiffAndColors2.png", "png");
//    }
//
//
////    @Test
////    public void tryGetColorXor() {
////        IMatrix matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "anime.png");
////        IMatrix matrix0 = Matrix2dConverter.matrix2dTransform(matrix2D);
//////        IMatrix matrix1 = Matrix2dConverter.matrix2dTransform(matrix0);
//////        IMatrix matrix2 = Matrix2dConverter.matrix2dTransform(matrix1);
//////        IMatrix endM = Matrix2dConverter.matrix2dXor(matrix2D, matrix2);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "anime_grey.jpg", "jpg");
////    }
////
////    @Test
////    public void convertToGrey256() {
////        IMatrix matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "anime.png");
////        IMatrix matrix0 = Matrix2dConverter.matrix2dGrey256(matrix2D);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "anime_grey.jpg", "jpg");
////        matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "apple.jpg");
////        matrix0 = Matrix2dConverter.matrix2dGrey256(matrix2D);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "apple_grey256.jpg", "jpg");
////    }
////
//
////
////    @Test
////    public void convertToGrey4Middle() {
////        IMatrix matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "anime.png");
////        IMatrix matrix0 = Matrix2dConverter.matrix2dGrey4(matrix2D);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "anime_grey4.jpg", "jpg");
////        matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "apple.jpg");
////        matrix0 = Matrix2dConverter.matrix2dGrey4(matrix2D);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "apple_grey4.jpg", "jpg");
////    }
////
////    @Test
////    public void convertToGrey2Middle() {
////        IMatrix matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "anime.png");
////        IMatrix matrix0 = Matrix2dConverter.matrix2dGrey2(matrix2D);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "anime_grey2.jpg", "jpg");
////        matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "apple.jpg");
////        matrix0 = Matrix2dConverter.matrix2dGrey2(matrix2D);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "apple_grey2.jpg", "jpg");
////    }
////
////    @Test
////    public void convertToColor8x8x8() {
////        IMatrix matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "anime.png");
////        IMatrix matrix0 = Matrix2dConverter.matrix2dColor8x8x8(matrix2D);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "anime_Color8x8x8.jpg", "jpg");
////        matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "apple.jpg");
////        matrix0 = Matrix2dConverter.matrix2dColor8x8x8(matrix2D);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "apple_Color8x8x8.jpg", "jpg");
////    }
////
////    @Test
////    public void convertToColor4x4x4() {
////        IMatrix matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "anime.png");
////        IMatrix matrix0 = Matrix2dConverter.matrix2dColorNxNxN(matrix2D, 4);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "anime_Color4x4x4.jpg", "jpg");
////        matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "apple.jpg");
////        matrix0 = Matrix2dConverter.matrix2dColorNxNxN(matrix2D, 4);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "apple_Color4x4x4.jpg", "jpg");
////    }
////
////    @Test
////    public void convertToColor2x2x2() {
////        IMatrix matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "anime.png");
////        IMatrix matrix0 = Matrix2dConverter.matrix2dColorNxNxN(matrix2D, 2);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "anime_Color2x2x2.jpg", "jpg");
////        matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "apple.jpg");
////        matrix0 = Matrix2dConverter.matrix2dColorNxNxN(matrix2D, 2);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "apple_Color2x2x2.jpg", "jpg");
////    }
////
////    @Test
////    public void convertToColor3x3x3() {
////        IMatrix matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "anime.png");
////        IMatrix matrix0 = Matrix2dConverter.matrix2dColorNxNxN(matrix2D, 3);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "anime_Color3x3x3.bmp", "bmp");
////        matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "apple.jpg");
////        matrix0 = Matrix2dConverter.matrix2dColorNxNxN(matrix2D, 3);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "apple_Color3x3x3.bmp", "bmp");
////    }
////
////    @Test
////    public void detectEdges() {
////        IMatrix matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "anime.png");
////        IMatrix matrix0 = Matrix2dConverter.matrix2dGrey256(matrix2D);
////        IMatrix matrixEdges = Matrix2dConverter.matrix2dDetectEdges(matrix0);
////        Matrix2dConverter.matrix2dToFileImage(matrix0, dirIn + "anime_grey256.jpg", "jpg");
////        Matrix2dConverter.matrix2dToFileImage(matrixEdges, dirIn + "anime_grey256DetectedEdges.jpg", "jpg");
////    }
////
////    @Test
////    public void maxMinColorsValues() {
////        IMatrix matrix2D = Matrix2dConverter.FileImageToMatrix2d(dirIn + "anime.png");
////        IMatrix m = Matrix2dConverter.matrix2dTransform(matrix2D);
////        m.analyzeMatrix();
////        System.out.printf("R{%d,%d}G{%d,%d}B{%d,%d}", m.getMinRedValue(), m.getMaxRedValue(),
////                m.getMinGreenValue(), m.getMaxGreenValue(),
////                m.getMinBlueValue(), m.getMaxBlueValue());
////    }
//
//    @Test
//    public void toColors8() {
//        Matrix2d<ARGB> matrix2D = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> colors8 = Matrix2dConverter.matrix2dArgbToColors8(matrix2D);
//        Matrix2dFileWriter.saveRGB(colors8, dirIn + imageFile + "_Colors8.png", "png");
//    }
//
//    @Test
//    public void toColors4() {
//        Matrix2d<ARGB> matrix2D = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> colors4 = Matrix2dConverter.matrix2dArgbToColors4(matrix2D);
//        Matrix2dFileWriter.saveRGB(colors4, dirIn + imageFile + "_Colors4.png", "png");
//    }
//
//    @Test
//    public void toColors2x2x2() {
//        Matrix2d<ARGB> matrix2D = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> colors = Matrix2dConverter.matrix2dArgbToColorsNxNxN(matrix2D, 2);
//        Matrix2dFileWriter.saveRGB(colors, dirIn + imageFile + "_Colors2x2x2.png", "png");
//    }
//
//    @Test
//    public void toColors2x2x2AndDiff() {
//        Matrix2d<ARGB> matrix2D = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> colors = Matrix2dConverter.matrix2dArgbToColorsNxNxN(matrix2D, 2);
//        Matrix2d<ARGB> m2dDiff = Matrix2dArgbFilter.argbToColorDiff(colors);
//        Matrix2dFileWriter.saveRGB(m2dDiff, dirIn + imageFile + "_Colors2x2x2andDiff.png", "png");
//    }
//
//    @Test
//    public void reduceX16_ColorDiff() {
//        Matrix2d<ARGB> matrix2D = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> colors = Matrix2dConverter.matrix2dArgbToColorsNxNxN(matrix2D, 2);
//        Matrix2d<ARGB> m2dDiff = Matrix2dArgbFilter.argbToColorDiff(colors);
//        Matrix2dFileWriter.saveRGB(m2dDiff, dirIn + imageFile + "_reduceX16_ColorDiff.png", "png");
//    }
//
//    @Test
//    public void convoluted2x4x8x16x32x64x128x() {
//        int min =190;
//        int max = 205;
//        Matrix2d<ARGB> m0 = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> mGrey = Matrix2dConverter.matrix2dArgbToColorsNxNxN(m0, 4);
//        Matrix2dFileWriter.saveRGB(mGrey, dirIn + imageFile + "_grey256.png", "png");
//
//        int[] colorFrequency = Matrix2dStatistic.argbColors(mGrey);
////        Matrix2d<ARGB> filtered = Matrix2dArgbFilter.argbMinMax(mGrey, -1, 256, min, max, min, max, min, max);
//        Matrix2d<ARGB> filtered = Matrix2dArgbFilter.argbByColorFrequency(mGrey, colorFrequency, 100000, 100000000);
//        Matrix2d<ARGB> mDiff = Matrix2dArgbFilter.argbToColorDiff(filtered);
//        Matrix2dFileWriter.saveRGB(mDiff, dirIn + imageFile + "_convoluted0x.png", "png");
//        Matrix2d<ARGB> m2 = Matrix2dTransform.argbConvolute2x(mDiff);
//        Matrix2dFileWriter.saveRGB(m2, dirIn + imageFile + "_convoluted2x.png", "png");
//        Matrix2d<ARGB> m4 = Matrix2dTransform.argbConvolute2x(m2);
//        Matrix2dFileWriter.saveRGB(m4, dirIn + imageFile + "_convoluted4x.png", "png");
//        Matrix2d<ARGB> m8 = Matrix2dTransform.argbConvolute2x(m4);
//        Matrix2dFileWriter.saveRGB(m8, dirIn + imageFile + "_convoluted8x.png", "png");
//        Matrix2d<ARGB> m16 = Matrix2dTransform.argbConvolute2x(m8);
//        Matrix2dFileWriter.saveRGB(m16, dirIn + imageFile + "_convoluted16x.png", "png");
//        Matrix2d<ARGB> m32 = Matrix2dTransform.argbConvolute2x(m16);
//        Matrix2dFileWriter.saveRGB(m32, dirIn + imageFile + "_convoluted32x.png", "png");
//        Matrix2d<ARGB> m64 = Matrix2dTransform.argbConvolute2x(m32);
//        Matrix2dFileWriter.saveRGB(m64, dirIn + imageFile + "_convoluted64x.png", "png");
//        Matrix2d<ARGB> m128 = Matrix2dTransform.argbConvolute2x(m64);
//        Matrix2dFileWriter.saveRGB(m128, dirIn + imageFile + "_convoluted128x.png", "png");
//
//    }
//
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
//
//    @Test
//    public void useStatisticColorToDetectEdges() {
//        Matrix2d<ARGB> m0 = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m2 = Matrix2dTransform.argbConvolute2x(m0);
//        Matrix2dFileWriter.saveRGB(m2, dirIn + imageFile + "_convoluted2x.png", "png");
//        Matrix2d<ARGB> m4 = Matrix2dTransform.argbConvolute2x(m2);
//        Matrix2dFileWriter.saveRGB(m4, dirIn + imageFile + "_convoluted4x.png", "png");
//        Matrix2d<ARGB> m8 = Matrix2dTransform.argbConvolute2x(m4);
//        Matrix2dFileWriter.saveRGB(m8, dirIn + imageFile + "_convoluted8x.png", "png");
//
//        ARGB threshold = Matrix2dStatistic.middleColor(m8);
//        Matrix2d<ARGB> filtered = new Matrix2d<ARGB>(ARGB.class, m8.sizeX, m8.sizeY);
//        Matrix2dArgbFilter.argbToGrey2ByThreshold(m8, filtered, threshold, 0,0, m8.sizeX, m8.sizeY);
//        Matrix2dFileWriter.saveRGB(filtered, dirIn + imageFile + "_x8grey2ByThreshold.png", "png");
//    }
//
//    @Test
//    public void useStatisticColorChannelsToDetectEdges() {
//        Matrix2d<ARGB> m0 = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m2 = Matrix2dTransform.argbConvolute2x(m0);
//        Matrix2dFileWriter.saveRGB(m2, dirIn + imageFile + "_convoluted2x.png", "png");
//        Matrix2d<ARGB> m4 = Matrix2dTransform.argbConvolute2x(m2);
//        Matrix2dFileWriter.saveRGB(m4, dirIn + imageFile + "_convoluted4x.png", "png");
//        Matrix2d<ARGB> m8 = Matrix2dTransform.argbConvolute2x(m4);
//        Matrix2dFileWriter.saveRGB(m8, dirIn + imageFile + "_convoluted8x.png", "png");
//
//        ARGB threshold = Matrix2dStatistic.middleColor(m2);
//        Matrix2d<ARGB> filteredR = Matrix2dArgbFilter.argbToGrey2ByRChannel(m2, threshold);
//        Matrix2dFileWriter.saveRGB(filteredR, dirIn + imageFile + "_x8grey2ByRChannel.png", "png");
//        Matrix2d<ARGB> diffR = Matrix2dArgbFilter.argbToColorDiff(filteredR);
//        Matrix2dFileWriter.saveRGB(diffR, dirIn + imageFile + "_x8grey2ByRChannelDiff.png", "png");
//
//        Matrix2d<ARGB> filteredG = Matrix2dArgbFilter.argbToGrey2ByGChannel(m2, threshold);
//        Matrix2dFileWriter.saveRGB(filteredG, dirIn + imageFile + "_x8grey2ByGChannel.png", "png");
//        Matrix2d<ARGB> diffG = Matrix2dArgbFilter.argbToColorDiff(filteredG);
//        Matrix2dFileWriter.saveRGB(diffG, dirIn + imageFile + "_x8grey2ByGChannelDiff.png", "png");
//
//        Matrix2d<ARGB> filteredB = Matrix2dArgbFilter.argbToGrey2ByBChannel(m2, threshold);
//        Matrix2dFileWriter.saveRGB(filteredB, dirIn + imageFile + "_x8grey2ByBChannel.png", "png");
//        Matrix2d<ARGB> diffB = Matrix2dArgbFilter.argbToColorDiff(filteredB);
//        Matrix2dFileWriter.saveRGB(diffB, dirIn + imageFile + "_x8grey2ByBChannelDiff.png", "png");
//
//        Matrix2d<ARGB> sum = Matrix2dTransform.argbPlusArgb(filteredR, filteredG);
//        sum = Matrix2dTransform.argbPlusArgb(sum, filteredB);
//        Matrix2d<ARGB> diffSum = Matrix2dArgbFilter.argbToColorDiff(sum);
//        Matrix2dFileWriter.saveRGB(diffSum, dirIn + imageFile + "_x8grey2ByRGBChannelsSum_Diff.png", "png");
//    }
//
//
//    @Test
//    public void useThresholdColorToDetectEdges() {
//        Matrix2d<ARGB> m0 = Matrix2dFileReader.loadRGB(dirIn + imageFile);
//        Matrix2d<ARGB> m2 = Matrix2dTransform.argbConvolute2x(m0);
//        Matrix2dFileWriter.saveRGB(m2, dirIn + imageFile + "_convoluted2x.png", "png");
//        Matrix2d<ARGB> m4 = Matrix2dTransform.argbConvolute2x(m2);
//        Matrix2dFileWriter.saveRGB(m4, dirIn + imageFile + "_convoluted4x.png", "png");
//        Matrix2d<ARGB> m = Matrix2dTransform.argbConvolute2x(m4);
//        Matrix2dFileWriter.saveRGB(m, dirIn + imageFile + "_convoluted8x.png", "png");
//
//        Matrix2d<ARGB> filtered = new Matrix2d<ARGB>(ARGB.class, m.sizeX, m.sizeY);
//
//        ARGB threshold = Matrix2dStatistic.middleColor(m,0,0, m.sizeX, m.sizeY);
//        Matrix2dArgbFilter.argbToGrey2ByThreshold(m, filtered, threshold, 0,0, m.sizeX, m.sizeY);
//        Matrix2dFileWriter.saveRGB(filtered, dirIn + imageFile + "_1x8_grey2.png", "png");
//
//        threshold = Matrix2dStatistic.middleColor(m,0,0, m.sizeX/2, m.sizeY/2);
//        Matrix2dArgbFilter.argbToGrey2ByThreshold(m, filtered, threshold, 0,0, m.sizeX/2, m.sizeY/2);
//
//        threshold = Matrix2dStatistic.middleColor(m,m.sizeX/2,0, m.sizeX, m.sizeY/2);
//        Matrix2dArgbFilter.argbToGrey2ByThreshold(m, filtered, threshold, m.sizeX/2,0, m.sizeX, m.sizeY/2);
//
//        threshold = Matrix2dStatistic.middleColor(m,0,m.sizeY/2, m.sizeX/2, m.sizeY);
//        Matrix2dArgbFilter.argbToGrey2ByThreshold(m, filtered, threshold, 0,m.sizeY/2, m.sizeX/2, m.sizeY);
//
//        threshold = Matrix2dStatistic.middleColor(m, m.sizeX/2,m.sizeY/2, m.sizeX, m.sizeY);
//        Matrix2dArgbFilter.argbToGrey2ByThreshold(m, filtered, threshold, m.sizeX/2,m.sizeY/2, m.sizeX, m.sizeY);
//
//        Matrix2dFileWriter.saveRGB(filtered, dirIn + imageFile + "_1x8_threshold1x2.png", "png");
//    }
//
//
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