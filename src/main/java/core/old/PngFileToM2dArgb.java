package core.old;

//import javax.imageio.ImageIO;
//import javax.imageio.stream.FileImageInputStream;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;

/**
 * Created by anonymous on 13.10.2018.
 */
public class PngFileToM2dArgb {

//    /**
//     * PngFile -> Matrix2dArgb
//     * @param in
//     * @return
//     */
//    public static Matrix2d<ARGB> transform(PngFile in) {
//        BufferedImage image;
//        int x, y;
//        ARGB color;
//        Matrix2d<ARGB> out = new Matrix2d<>(ARGB.class);
//        try {
//            image = ImageIO.read(new FileImageInputStream(new File(in.urlFile)));
//        } catch (IOException e) {
//            throw new FileException("Can't read image file into matrix2dArgb", e);
//        }
//        y = image.getHeight();
//        x = image.getWidth();
//        out.setSizeXY(x,y);
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                color = IntegerArgbToArgb.transform( image.getRGB(i,j) );
//                out.setValue(i,j, color);
//            }
//        }
//        return out;
//    }

}
