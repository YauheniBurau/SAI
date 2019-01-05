package core.application.process.MatrixToFile;

import core.application.VertexValue.color.ARGB;
import core.application.VertexValue.color.Colors256ARGB;
import core.application.VertexValue.coords.Decart2dIntLinks;
import core.application.VertexValue.file.PngFile;
import core.application.VertexValue.matrix.Matrix2dDecart2dIntLinks;
import core.application.exceptions.FileException;
import core.application.process.PrimitiveToPrimitive.BooleanToIntegerArgb;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 06.01.2019.
 */
public class M2dDecart2dIntLinksToPngFile{

    /**
     * save matrix2dDecart2dIntLinks to Png-file
     * @param in
     * @param out
     * @return
     */
    public static PngFile transform(Matrix2dDecart2dIntLinks in, PngFile out) {
        BufferedImage image;
        int type = TYPE_INT_ARGB;
        int x, y;
        Decart2dIntLinks v;
        ARGB argb;
        image = new BufferedImage(in.sizeX, in.sizeY, type);
        y = in.sizeY;
        x = in.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                v = in.getValue(i, j);
                if(v!=null) {
                    image.setRGB( i, j, BooleanToIntegerArgb.transform(true));
                }else{
                    image.setRGB(i, j, BooleanToIntegerArgb.transform(false));
                }
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
