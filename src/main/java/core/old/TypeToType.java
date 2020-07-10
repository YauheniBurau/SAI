package core.old;

/**
 * Created by anonymous on 28.10.2018.
 */
public class TypeToType {

    /**
     * Boolean -> ARGB
     * @param in
     * @return black color for boolean false, white color for boolean true
     */
    public static int BooleanToIntegerArgb(Boolean in){
        if(in == null){
            //throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        int v;
        if(in == false) v = 0xff000000;
        else v = 0xffffffff;
        return v;
    }

    /**
     * ARGB -> Integer argb
     * @param in
     * @return
     */
    public static int ArgbToIntegerArgb(ARGB in){
        int i = 0x00000000;
        i = i | in.a;
        i = i<<8 | in.r;
        i = i<<8 | in.g;
        i = i<<8 | in.b;
        return i;
    }

    /**
     * @param in Hex String in format 0x[0..1,a-f]+
     * @return Long Value
     */
    public static Long HexStringToLong(String in) {
        if( in == null ){
            //throw new InputParamException("input HexString must be not null");
        }
        return Long.decode(in);

    }

    /**
     * @param in Long Value
     * @return Hex String
     */
    public static String LongToHexString(Long in) {
        if( in == null ){
            //throw new InputParamException("input Long must be not null");
        }
        return Long.toHexString(in);
    }

    /**
     * transform Integer Argb -> ARGB
     * @param in Integer in format 0x[AA][rr][gg][bb]
     * @return
     */
    public static ARGB IntegerArgbToArgb(Integer in){
        int alpha, red, green, blue;
        alpha = (in >>> 24) & 0xff;
        red = (in >>> 16) & 0xff;
        green = (in >>> 8) & 0xff;
        blue = (in >>> 0) & 0xff;
        return new ARGB(alpha, red, green, blue);
    }

//    /**
//     * transformPoints signed Byte to Unsigned Int
//     * @param value
//     * @return
//     */
//    public static ARGB SignedByteToArgb(byte value){
//
//        return new ARGB(value+128, 0xff, 0xff, 0xff);
//    }

    /**
     * transform signed Byte to Unsigned Int
     * @param value
     * @return
     */
    public static int SignedByteToUnsignedInt(byte value){
        return(value+128);
    }

    /**
     * transform signed int -> signed Byte
     * @param value
     * @return
     */
    public static byte SignedIntToSignedByte(int value){
        if(value<-128 || value>127){
            //throw new InputParamException("input int must be in [-128..+127]");
        }
        return (byte)(value);
    }

    /**
     * transformPoints Matrix2d<Lab> to matrix2d<ARGB>
     * @param in
     * @param whitePoint from Lab class
     * @return
     */
    public static Matrix2d<ARGB> M2dLabToM2dArgb(Matrix2d<Lab> in, double[] whitePoint) {
        int x, y;
        y = in.sizeY;
        x = in.sizeX;
        ARGB value;
        Matrix2d<ARGB> out = new Matrix2d<ARGB>(ARGB.class, x, y, null);
        out.setSizeXY(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                value = LabToArgb.transform( in.getValue(i, j), whitePoint );
                out.setValue(i, j, value);
            }
        }
        return out;
    }

    /**
     * transform unsigned Int [0..255] to signed Byte [-128, +127]
     * int must be in dipazon [0..255]
     * @param value
     * @return
     */
    public static byte UnsignedIntToSignedByte(int value){
        if(value>255 || value<0){
            //throw new InputParamException("input int must be in [0..255]");
        }
        return (byte)(value-128);
    }

    /**
     * transform Double to Byte
     * double must be in dipazon [0.0 .. 255.0]
     * @param value
     * @return
     */
    public static byte UnsignedDoubleToSignedByte(double value){
        if(value>255 || value<0){
            //throw new InputParamException("input int must be in [0..255]");
        }
        return (byte)(value-128);
    }


}
