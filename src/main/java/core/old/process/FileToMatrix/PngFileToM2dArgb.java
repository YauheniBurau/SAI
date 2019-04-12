package core.old.process.FileToMatrix;

import core.application.controller.AbstractAlgorithmFX;
import core.old.process.PrimitiveToColor.IntegerArgbToArgb;
import core.old.VertexValue.matrix.Matrix2d;
import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.file.PngFile;
import core.application.exceptions.FileException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by anonymous on 13.10.2018.
 */
public class PngFileToM2dArgb extends AbstractAlgorithmFX {

    /**
     * PngFile -> Matrix2dArgb
     * @return
     */
    @Override
    public Boolean process() {
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
