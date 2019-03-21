package com.yauheni.burau.sai;

import core.application.VertexValue.color.ARGB;
import core.application.VertexValue.file.PngFile;
import core.application.VertexValue.input.InputDataSensor;
import core.application.VertexValue.matrix.Matrix2d;
import core.application.VertexValue.matrix.Matrix2dByte;
import core.application.graph.Graph;
import core.application.process.FileToMatrix.PngFileToM2dArgb;
import core.application.process.MatrixToFile.M2dDecart2dIntLinksToPngFile;
import core.application.process.MatrixToGraph.M2dArgbToGraphVertexSegment2d;
import core.application.process.MatrixToMatrix.M2dArgbToM2dByte256Colors;
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
    public void Png_Contour() {
        PngFile pngFileIn = new PngFile(dirIn + imageFile);
        Matrix2d<ARGB> m2dArgb = PngFileToM2dArgb.transform(pngFileIn);
        Matrix2dByte m2dByte = M2dArgbToM2dByte256Colors.transform(m2dArgb);
        InputDataSensor inputDataSensor = new InputDataSensor();
        inputDataSensor.setInputM2d(m2dByte);
        inputDataSensor.countContourM2d(400, 250);
        PngFile pngFileOut = new PngFile(dirOut + "C_" + imageFile);
        M2dDecart2dIntLinksToPngFile.transform(inputDataSensor.contourM2d, pngFileOut);
    }


}