package core.old.process;

/**
 * Created by anonymous on 26.10.2018.
 */
//public class M2dArgbToPngFile {
//
//
//    /**
//     * save matrix2dArgb to Png-file
//     * @param in
//     * @return
//     */
//    public static PngFile transform(Matrix2d<ARGB> in, PngFile  out) {
//        BufferedImage image;
//        int type = TYPE_INT_ARGB;
//        int x, y;
//        image = new BufferedImage(in.sizeX, in.sizeY, type);
//        y = in.sizeY;
//        x = in.sizeX;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                image.setRGB( i, j, ArgbToIntegerArgb.transform(in.getValue(i, j)) );
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
