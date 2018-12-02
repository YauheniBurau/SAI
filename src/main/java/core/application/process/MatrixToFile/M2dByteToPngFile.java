package core.application.process.MatrixToFile;

import core.application.algorithms.BaseAlgorithm;
import core.application.dataElement.color.Colors256ARGB;
import core.application.dataElement.file.PngFile;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.FileException;
import core.application.exceptions.InputParamException;
import core.application.model.Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 09.11.2018.
 */
public class M2dByteToPngFile extends BaseAlgorithm {
    private Model model;
    private String inKey;
    private String outKey;

    public M2dByteToPngFile(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     * Matrix2dByte -> PngFile
     * @return
     */
    @Override
    public Boolean process() {
        Matrix2d<Byte> in = this.model.matrix2dByteList.get(this.inKey);
        PngFile out = this.model.pngFileList.get(this.outKey);
        if(in!=null && out!=null) {
            out = this.transform(in, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     * save matrix2dArgb to Png-file
     * @param in
     * @param out
     * @return
     */
    public static PngFile transform(Matrix2d<Byte> in, PngFile out) {
        BufferedImage image;
        Colors256ARGB colors256 = new Colors256ARGB();
        int type = TYPE_INT_ARGB;
        int x, y;
        Byte v;
        image = new BufferedImage(in.sizeX, in.sizeY, type);
        y = in.sizeY;
        x = in.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                v = in.getValue(i, j);
                if(v!=null) {
                    image.setRGB( i, j, colors256.getArgbInteger(v+128) );
                }else{
                    image.setRGB(i, j, 0x00000000);
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
