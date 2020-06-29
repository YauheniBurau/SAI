package core.old.process;

/**
 * Created by anonymous on 28.10.2018.
 */
//public class M2dBooleanToPngFile {
//
//    /**
//     * Matrix2d<Boolean> -> PngFile
//     * @return
//     */
//    @Override
//    public Boolean process() {
//        return Boolean.TRUE;
//    }
//
//    /**
//     * save matrix2dBoolean to Png-file
//     * @param in
//     * @param out
//     * @return
//     */
//    public static PngFile transform(Matrix2d<Boolean> in, PngFile out) {
//        BufferedImage image;
//        int type = TYPE_INT_ARGB;
//        int x, y;
//        image = new BufferedImage(in.sizeX, in.sizeY, type);
//        y = in.sizeY;
//        x = in.sizeX;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                image.setRGB( i, j, BooleanToIntegerArgb.transform(in.getValue(i, j)) );
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
