package core.old.io;

/**
 * Created by anonymous on 21.09.2018.
 */
public class ElementSaver {

//    /**
//     * load matrix2d from image ARGB-file
//     * @param urlFile
//     * @return
//     */
//    public static Matrix2dArgbSensor load(String urlFile) {
//        BufferedImage image;
//        int x, y;
//        ARGB color;
//        try {
//            image = ImageIO.read(new FileImageInputStream(new File(urlFile)));
//        } catch (IOException e) {
//            throw new FileException("Can't read image file into matrix2d<ARGB>", e);
//        }
//        y = image.getHeight();
//        x = image.getWidth();
//        Matrix2dArgbSensor matrix2D = new Matrix2dArgbSensor(x, y);
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                color = ElementConverter.intToArgb( image.getRGB(i,j) );
//                matrix2D.setValue(i,j, color);
//            }
//        }
//        return matrix2D;
//    }


    //    public PngFile transform(Matrix2dArgb in, PngFile out, String urlFile){
//        // 1. find shift by x and y
//        if(points.size()==0) return this;
//        int l = Integer.MAX_VALUE;
//        int r = Integer.MIN_VALUE;
//        int u = Integer.MAX_VALUE;
//        int d = Integer.MIN_VALUE;
//        for(Point p : points){
//            if( p.x < l ) l = p.x;
//            if( p.x > r ) r = p.x;
//            if( p.y < u ) u = p.y;
//            if( p.y > d ) d = p.y;
//        }
//        int width = r - l + 1;
//        int high = d - u + 1;
//        // 2.create image
//        BufferedImage image;
//        int x, y;
//        image = new BufferedImage(width, high, TYPE_INT_ARGB);
//        y = high;
//        x = width;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                image.setRGB( i, j, 0x00000000 );
//            }
//        }
//        // 3. add points with shift to ElementImage
//        ARGB v;
//        for(Point p : points) {
//            v = mainM2d.getValue(p.x, p.y);
//            image.setRGB(  p.x - l, p.y - u, ElementConverter.argbToInt(v) );
//        }
//        // 4. Save
//        try {
//            ImageIO.write(image, format, new File(urlFile));
//        } catch (IOException e) {
//            throw new FileException("Can't write segment to image file", e);
//        }
//        return this;
//    }


}
