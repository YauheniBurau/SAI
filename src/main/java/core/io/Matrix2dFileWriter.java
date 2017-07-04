package core.io;

import core.converter.ElementConverter;
import core.element.ARGB;
import core.element.Grey256;
import core.exceptions.FileException;
import core.matrix.Matrix2d;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_BYTE_GRAY;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 * Created by anonymous on 01.05.2017.
 */
public class Matrix2dFileWriter {

    public static void saveRGB(Matrix2d<ARGB> matrix2dArgb, String urlFile, String format) {
        BufferedImage image;
        int x, y;
        image = new BufferedImage(matrix2dArgb.sizeX, matrix2dArgb.sizeY, TYPE_INT_RGB);
        y = matrix2dArgb.sizeY;
        x = matrix2dArgb.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, ElementConverter.argbToInt(matrix2dArgb.getValue(i, j)).value );
            }
        }
        try {
            ImageIO.write(image, format, new File(urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write matrix2d<Argb> to image file", e);
        }
    }

    public static void saveGrey256(Matrix2d<Grey256> matrix2dGrey256, String urlFile, String format) {
        BufferedImage image;
        int x, y;
        image = new BufferedImage(matrix2dGrey256.sizeX, matrix2dGrey256.sizeY, TYPE_BYTE_GRAY);
        y = matrix2dGrey256.sizeY;
        x = matrix2dGrey256.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, matrix2dGrey256.getValue(i, j).value );
            }
        }
        try {
            ImageIO.write(image, format, new File(urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write matrix2d<Grey256> to image file", e);
        }
    }

}
