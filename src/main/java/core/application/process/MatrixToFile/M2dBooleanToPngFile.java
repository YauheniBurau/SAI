package core.application.process.MatrixToFile;

import core.application.algorithms.BaseAlgorithm;
import core.application.process.PrimitiveToPrimitive.BooleanToIntegerArgb;
import core.application.model.Model;
import core.application.VertexValue.matrix.Matrix2d;
import core.application.exceptions.FileException;
import core.application.exceptions.InputParamException;
import core.application.VertexValue.file.PngFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 28.10.2018.
 */
public class M2dBooleanToPngFile extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;

    public M2dBooleanToPngFile(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     * Matrix2d<Boolean> -> PngFile
     * @return
     */
    @Override
    public Boolean process() {
        Matrix2d<Boolean> in = this.model.matrix2dBoolList.get(this.inKey);
        PngFile out = this.model.pngFileList.get(this.outKey);
        if(in!=null && out!=null) {
            out = this.transform(in, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     * save matrix2dBoolean to Png-file
     * @param in
     * @param out
     * @return
     */
    public static PngFile transform(Matrix2d<Boolean> in, PngFile out) {
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
        return out;
    }

}
