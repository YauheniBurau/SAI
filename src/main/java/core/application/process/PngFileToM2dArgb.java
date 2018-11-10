package core.application.process;

import core.application.algorithms.BaseAlgorithm;
import core.application.helper.IntegerArgbToArgb;
import core.application.model.Model;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.dataElement.color.ARGB;
import core.application.dataElement.file.PngFile;
import core.application.exceptions.FileException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by anonymous on 13.10.2018.
 */
public class PngFileToM2dArgb extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;

    public PngFileToM2dArgb(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     * PngFile -> Matrix2dArgb
     * @return
     */
    @Override
    public TransformResults process() {
        PngFile in = this.model.pngFileList.get(this.inKey);
        Matrix2d<ARGB> out = this.model.matrix2dArgbList.get(this.outKey);
        TransformResults tr = new TransformResults();
        if(in!=null && out!=null) {
            tr = this.transform(in, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return tr;
    }

    /**
     * PngFile -> Matrix2dArgb
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform(PngFile in, Matrix2d<ARGB> out) {
        BufferedImage image;
        int x, y;
        ARGB color;
        try {
            image = ImageIO.read(new FileImageInputStream(new File(in.urlFile)));
        } catch (IOException e) {
            throw new FileException("Can't read image file into matrix2dArgb", e);
        }
        y = image.getHeight();
        x = image.getWidth();
        out.setSizeXY(x,y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                color = IntegerArgbToArgb.transform( image.getRGB(i,j) );
                out.setValue(i,j, color);
            }
        }
        return new TransformResults();
    }

}
