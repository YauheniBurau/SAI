package core.io;

import core.converter.ElementConverter;
import core.element.ARGB;
import core.element.Grey256;
import core.exceptions.FileException;
import core.matrix.Matrix2d;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by anonymous on 01.05.2017.
 */
public class Matrix2dFileReader {

    public static Matrix2d<ARGB> loadRGB(String urlFile) {
        BufferedImage image;
        int color, x, y;
        try {
            image = ImageIO.read(new FileImageInputStream(new File(urlFile)));
        } catch (IOException e) {
            throw new FileException("Can't read image file into matrix2d<ARGB>", e);
        }
        y = image.getHeight();
        x = image.getWidth();
        Matrix2d<ARGB> matrix2D = new Matrix2d(ARGB.class, x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                color = image.getRGB(i,j);
                matrix2D.setValue(i,j, ElementConverter.intToArgb(color));
            }
        }
        return matrix2D;
    }

    public static Matrix2d<Grey256> loadGrey256(String urlFile) {
        BufferedImage image;
        int color, x, y;
        byte greyColor;
        try {
            image = ImageIO.read(new FileImageInputStream(new File(urlFile)));
        } catch (IOException e) {
            throw new FileException("Can't read image file into matrix2d<ARGB>", e);
        }
        y = image.getHeight();
        x = image.getWidth();
        Matrix2d<Grey256> matrix2d = new Matrix2d(Grey256.class, x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                color = image.getRGB(i,j);
                greyColor = (byte)(color & 0xff);
                matrix2d.setValue(i,j, new Grey256(greyColor) );
            }
        }
        return matrix2d;
    }

}
