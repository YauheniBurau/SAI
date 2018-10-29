package core.application.algorithm.process;

import core.application.algorithm.helper.BooleanToIntegerArgb;
import core.application.model.Model;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.FileException;
import core.application.exceptions.InputParamException;
import core.application.dataElement.file.PngFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 28.10.2018.
 */
public class Matrix2dBooleanToPngFile extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;
    TransformParams transformParams;

    public Matrix2dBooleanToPngFile(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.transformParams = new TransformParams();
    }

    public Matrix2dBooleanToPngFile(Model model, String inKey, String outKey, TransformParams transformParams) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.transformParams = transformParams;
    }

    /**
     * Matrix2d<Boolean> -> PngFile
     * @return
     */
    @Override
    public TransformResults process() {
        Matrix2d<Boolean> in = this.model.matrix2dBooleanList.get(this.inKey);
        PngFile out = this.model.pngFileList.get(this.outKey);
        TransformResults tr = new TransformResults();
        if(in!=null && out!=null) {
            tr = this.transform(in, out, this.transformParams);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return tr;
    }

    /**
     * save matrix2dBoolean to Png-file
     * @param in
     * @param out
     * @param params
     * @return
     */
    public static TransformResults transform(Matrix2d<Boolean> in, PngFile out, TransformParams params) {
        BufferedImage image;
        int type = TYPE_INT_ARGB;
        int x, y;
        image = new BufferedImage(in.sizeX, in.sizeY, type);
        y = in.sizeY;
        x = in.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, BooleanToIntegerArgb.transform(in.getValue(i, j)) );
            }
        }
        try {
            ImageIO.write(image, "png", new File(out.urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write matrix2d to image file", e);
        }
        return new TransformResults();
    }

}
