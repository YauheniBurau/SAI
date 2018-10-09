package com.yauheni.burau.sai;

import core.application.Facade.Facade;
import core.element.Matrix2dArgb;
import core.element.PngFile;
import core.transformer.TransformParams;
import core.transformer.Transformation;
import core.transformer.TransformationStep;
import org.junit.Test;

/**
 * Created by anonymous on 08.10.2018.
 */
public class FacadeTest {
    String dirIn = "E:\\temp\\in\\";
    String dirOut = "E:\\temp\\out\\";

//    String imageFile = "square.png";
//    String imageFile = "square1.png";
    String imageFile = "star.png";

    @Test
    public void transformDataViaFacade() {
//        int maxDiff = 32;
        Facade facade = new Facade();
        // prepare input data
        facade.model.pngFileList.put("PngFile.in1", new PngFile(dirIn + imageFile));
        facade.model.matrix2dArgbList.put("Matrix2dArgb.1", new Matrix2dArgb());
        facade.model.pngFileList.put("PngFile.out1", new PngFile(dirOut + imageFile));
        // prepare transformation
        Transformation tr = new Transformation();
        tr.add(new TransformationStep(PngFile.class, "PngFile.in1", Matrix2dArgb.class, "Matrix2dArgb.1", new TransformParams()));
        tr.add(new TransformationStep(Matrix2dArgb.class, "Matrix2dArgb.1", PngFile.class, "PngFile.out1", new TransformParams()));
        // execute transformation
        facade.transform(tr);
        // use new created results in model
    }


}
