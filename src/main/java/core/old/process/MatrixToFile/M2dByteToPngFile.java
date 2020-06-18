package core.old.process.MatrixToFile;

import core.old.VertexValue.color.ARGB;
import core.old.VertexValue.color.Colors256ARGB;
import core.old.VertexValue.file.PngFile;
import core.old.VertexValue.matrix.Matrix2d;
import core.application.exceptions.FileException;
import core.old.process.ColorToPrimitive.ArgbToIntegerArgb;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 09.11.2018.
 */
//public class M2dByteToPngFile {
//
//    /**
//     * Matrix2dByte -> PngFile
//     * @return
//     */
//    @Override
//    public Boolean process() {
//        return Boolean.TRUE;
//    }
//
//    /**
//     * save matrix2dArgb to Png-file
//     * @param in
//     * @param out
//     * @return
//     */
//    public static PngFile transform(Matrix2d<Byte> in, PngFile out) {
//        BufferedImage image;
//        Colors256ARGB colors256 = new Colors256ARGB();
//        int type = TYPE_INT_ARGB;
//        int x, y;
//        Byte v;
//        ARGB argb;
//        image = new BufferedImage(in.sizeX, in.sizeY, type);
//        y = in.sizeY;
//        x = in.sizeX;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                v = in.getValue(i, j);
//                if(v!=null) {
//                    argb = colors256.getArgbColor(v+128);
//                    image.setRGB( i, j, ArgbToIntegerArgb.transform(argb) );
//                }else{
//                    image.setRGB(i, j, 0x00000000);
//                }
//            }
//        }
//        try {
//            ImageIO.write(image, "png", new File(out.urlFile));
//        } catch (IOException e) {
//            throw new FileException("Can't write matrix2d to image file", e);
//        }
//        return out;
//    }
//
//}
