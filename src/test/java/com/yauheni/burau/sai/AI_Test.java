package com.yauheni.burau.sai;

import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.file.PngFile;
import core.old.VertexValue.input.InputDataSensor;
import core.old.VertexValue.matrix.Matrix2d;
import core.old.VertexValue.matrix.Matrix2dByte;
import core.old.process.FileToMatrix.PngFileToM2dArgb;
import core.old.process.MatrixToFile.M2dDecart2dIntLinksToPngFile;
import core.old.process.MatrixToMatrix.M2dArgbToM2dByte256Colors;
import org.junit.Test;

/**
 * Created by anonymous on 08.10.2016.
 */
public class AI_Test {

    String dirIn = "E:\\temp\\in\\";
    String dirOut = "E:\\temp\\out\\";
    String imageFile = "star3.png";

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