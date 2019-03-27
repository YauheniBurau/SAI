package core.old.process.SegmentToMatrix;

import core.application.controller.AbstractAlgorithmFX;

// TODO: remove later
/**
 * Created by anonymous on 12.11.2018.
 */
public class SegmentPointByteDecart2dIntegerToMatrix2dByte extends AbstractAlgorithmFX {
    @Override
    public Boolean process() {
        return null;
    }
//    private Model model;
//    private String inKey;
//    private String outKey;
//
//    public SegmentPointByteDecart2dIntegerToMatrix2dByte(Model model, String inKey, String outKey) {
//        this.model = model;
//        this.inKey = inKey;
//        this.outKey = outKey;
//    }
//
//    /**
//     * Segment<...> -> Matrix2d<...>
//     * @return
//     */
//    @Override
//    public Boolean process() {
//        SegmentPointDecart2dInt in = this.model.segmentByteDecart2dIntList.get(this.inKey);
//        Matrix2d<Byte> out;
//        if(in!=null) {
//            out = this.transform(in);
//            this.model.matrix2dByteList.put(this.outKey, out);
//        }else{
//            throw new InputParamException("Wrong in or out params. At least one of them is null");
//        }
//        return Boolean.TRUE;
//    }
//
//    /**
//     * Segment<Point<Byte,Decart2d<Integer>>> -> Matrix2d<Byte>
//     * @param in
//     * @return
//     */
//    public static Matrix2d<Byte> transform(SegmentPointDecart2dInt in) {
//        // 1. find shift by x and y
//        if(in.points.size()==0) return null;
//        int l = Integer.MAX_VALUE;
//        int r = Integer.MIN_VALUE;
//        int u = Integer.MAX_VALUE;
//        int d = Integer.MIN_VALUE;
//        for(Point<Byte, Decart2dInt> p : in.points){
//            if( p.coords.x < l ) l = p.coords.x;
//            if( p.coords.x > r ) r = p.coords.x;
//            if( p.coords.y < u ) u = p.coords.y;
//            if( p.coords.y > d ) d = p.coords.y;
//        }
//        int width = r - l + 1;
//        int high = d - u + 1;
//        // 2.create m2dByte
//        int x, y;
//        y = high;
//        x = width;
//        Matrix2d<Byte> out = new Matrix2d<Byte>(Byte.class, x, y, null);
//        // 3. add points with shift to Matrix2dByte
//        for(Point<Byte, Decart2dInt> p : in.points) {
//            out.setBufferedImage(p.coords.x - l, p.coords.y - u, p.value );
//        }
//        return out;
//    }
//
}
