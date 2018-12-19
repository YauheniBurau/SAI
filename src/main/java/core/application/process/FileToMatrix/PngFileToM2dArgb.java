package core.application.process.FileToMatrix;

import core.application.algorithms.BaseAlgorithm;
import core.application.process.PrimitiveToColor.IntegerArgbToArgb;
import core.application.model.Model;
import core.application.VertexValue.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.VertexValue.color.ARGB;
import core.application.VertexValue.file.PngFile;
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
    public Boolean process() {
        PngFile in = this.model.pngFileList.get(this.inKey);
        Matrix2d<ARGB> out;
        if(in!=null) {
            out = this.transform(in);
            this.model.matrix2dArgbList.put(this.outKey, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     * PngFile -> Matrix2dArgb
     * @param in
     * @return
     */
    public static Matrix2d<ARGB> transform(PngFile in) {
        BufferedImage image;
        int x, y;
        ARGB color;
        Matrix2d<ARGB> out = new Matrix2d<>(ARGB.class);
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
        return out;
    }

}
