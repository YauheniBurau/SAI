package core.old;

/**
 * Created by anonymous on 16.12.2018.
 */
//public class ContourDecart2dToM2dBool {

//    /**
//     *  ContourDecart2d -> Matrix2dBool
//     * @param in Contour of Decart2d
//     * @return
//     */
//    public static Matrix2dBool transform(ContourDecart2d in, int sizeX, int sizeY) {
//        Matrix2dBool m2d = new Matrix2dBool(sizeX, sizeY, false);
//        int x, y;
//        for(Decart2d p: in.elements){
//            x = (int)Math.round(p.x);
//            y = (int)Math.round(p.y);
//            m2d.setValue(x, y, true);
//        }
//        return m2d;
//    }

//    @Override
//    public Boolean process() {
//        return null;
//    }
//}