package core.old.process;

import core.old.VertexValue.matrix.Matrix2d;

/**
 * Created by anonymous on 31.10.2018.
 */
//public class M2dByteToM2dBoolean_SegmentEdges {
//
//    /**
//     * Matrix2d<Byte> -> Matrix2d<Boolean> as Contour edges
//     * @return
//     */
//    @Override
//    public Boolean process() {
//        return Boolean.TRUE;
//    }
//
//    /**
//     * transformPoints Matrix2d<Byte> -> Matrix2d<Boolean> as segment edges
//     * @param in
//     * @return
//     */
//    public static Matrix2d<Boolean> transform(Matrix2d<Byte> in) {
//        Byte p00, p01, p02, p10, p11, p12, p20, p21, p22;
//        int x, y;
//        y = in.sizeY;
//        x = in.sizeX;
//        Matrix2d<Boolean> out = new Matrix2d<Boolean>(Boolean.class, x, y, null);
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                p00 = in.getValue(i-1, j-1); if(p00 ==null) p00 = 0;
//                p01 = in.getValue(i, j-1); if(p01 ==null) p01 = 0;
//                p02 = in.getValue(i+1, j-1);  if(p02 ==null) p02 = 0;
//                p10 = in.getValue(i-1, j);  if(p10 ==null) p10 = 0;
//                p11 = in.getValue(i, j);  if(p11 ==null) p11 = 0;
//                p12 = in.getValue(i+1, j);  if(p12 ==null) p12 = 0;
//                p20 = in.getValue(i-1, j+1);  if(p20 ==null) p20 = 0;
//                p21 = in.getValue(i, j+1);  if(p21 ==null) p21 = 0;
//                p22 = in.getValue(i+1, j+1);  if(p22 ==null) p22 = 0;
//                if( p11>p00 ){ out.setValue( i-1, j-1, true); }
//                if( p11>p01 ){ out.setValue( i, j-1, true); }
//                if( p11>p02 ){ out.setValue( i+1, j-1, true); }
//                if( p11>p10 ){ out.setValue( i-1, j, true); }
//                if( p11>p12 ){ out.setValue( i+1, j, true); }
//                if( p11>p20 ){ out.setValue( i-1, j+1, true); }
//                if( p11>p21 ){ out.setValue( i, j+1, true);}
//                if( p11>p22 ){ out.setValue( i+1, j+1,true);}
//            }
//        }
//        return out;
//    }
//
//}