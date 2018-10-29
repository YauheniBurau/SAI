package core.application.dataElement;

import core.application.algorithm.helper.ArgbToIntegerArgb;
import core.application.algorithm.helper.IntegerArgbToArgb;
import core.application.dataElement.color.ARGB;
import core.old.MVQ2;

/**
 * Created by anonymous on 06.10.2017.
 */
public class Matrix2dArgb implements IDataElement{
    private ARGB[][] matrix;
    public int sizeX;
    public int sizeY;

    public Matrix2dArgb() {
        this.sizeX = 0;
        this.sizeY = 0;
        this.matrix = null;
    }

    public Matrix2dArgb(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new ARGB[ySize][xSize];
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
    }

    public void setSizeXY(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new ARGB[ySize][xSize];
        for(int j = 0; j<this.sizeY; j++){
            for(int i = 0; i<this.sizeX; i++) {
                this.setValue(i, j, null);
            }
        }
    }

    public void setValue(int xPos, int yPos, ARGB value) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public ARGB getValue(int xPos, int yPos) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            return this.matrix[yPos][xPos];
        }
        return null;
    }

    public Matrix2dArgb convertTo256Colors(){
        MVQ2 mvq2 = new MVQ2();
        int[] img = Matrix2dArgb.matrix2dArgbToArrayInt(this);
        int[] pallete256 = mvq2.to_256_color_paletted_image(img);
        Matrix2dArgb m2d = Matrix2dArgb.arrayIntToMatrix2dArgb(img, this.sizeX, this.sizeY, pallete256);
        return m2d;
    }

    public static int[] matrix2dArgbToArrayInt(Matrix2dArgb in){
        int[] res = new int[in.sizeX*in.sizeY];
        int n = 0;
        int iv;
        Integer I = null;
        ARGB v;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                v = in.getValue(i, j);
                iv = ArgbToIntegerArgb.transform(v);
                res[n] = iv;
                n+=1;
            }
        }
        return res;
    }

    public static Matrix2dArgb arrayIntToMatrix2dArgb(int[] in, int sizeX, int sizeY, int[] pallete256){
        MVQ2 mvq2 = new MVQ2();
        Matrix2dArgb res = new Matrix2dArgb(sizeX, sizeY);
        int n = 0;
        int iv, index;
        ARGB argb = null;
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++) {
                iv = in[n];
                index = mvq2.nearest_entry(pallete256, iv);
                argb = IntegerArgbToArgb.transform(pallete256[index]);
                argb.a = 0xff;
                res.setValue(i, j, argb);
                n+=1;
            }
        }
        return res;
    }

//    /**
//     * Reduce size of matrix2d to n-times on axis x and y by selecting every nx-dataElement
//     * @param nx
//     * @return
//     */
//    public Matrix2dArgb reduce(int nx){
//        int resizedX = this.sizeX/nx;
//        int resizedY = this.sizeY/nx;
//        Matrix2dArgb m2d = new Matrix2dArgb(resizedX, resizedY);
//        for(int j = 0; j<resizedY; j++){
//            for(int i = 0; i<resizedX; i++){
//                m2d.setValue(i, j, this.getValue(i*nx, j*nx) );
//            }
//        }
//        return m2d;
//    }
//
//    /**
//     *
//     * @param del
//     * @return
//     */
//    public Matrix2dArgb reduceColors(int del){
//        int x = this.sizeX;
//        int y = this.sizeY;
//        Matrix2dArgb m2d = new Matrix2dArgb(x, y);
//        ARGB oldV, newV;
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                oldV = this.getValue(i, j);
//                newV = new ARGB(oldV.a, oldV.r/del*del, oldV.g/del*del, oldV.b/del*del );
//                m2d.setValue(i, j, newV );
//            }
//        }
//        return m2d;
//    }
//
//
//    /**
//     * Stretch size of matrix2d to 2-times on axis x and y by doubling every point
//     * @return
//     */
//    public Matrix2dArgb stretch2x(){
//        int x = this.sizeX;
//        int y = this.sizeY;
//        int resizedX = this.sizeX*2;
//        int resizedY = this.sizeY*2;
//        ARGB p;
//        Matrix2dArgb m2d = new Matrix2dArgb(resizedX, resizedY);
//        for(int j = 0; j<y; j++){
//            for(int i = 0; i<x; i++){
//                p = this.getValue(i, j);
//                m2d.setValue(i*2, j*2, p );
//                m2d.setValue(i*2+1, j*2, p );
//                m2d.setValue(i*2, j*2+1, p );
//                m2d.setValue(i*2+1, j*2+1, p );
//            }
//        }
//        return m2d;
//    }
//
//
//    /**
//     * count edge by RGB color distance
//     * @return
//     */
//    public Matrix2dArgb removeByColorDistance(int r){
//        ARGB p00, p01, p02, p10, p11, p12, p20, p21, p22;
//        Matrix2dArgb m2d = new Matrix2dArgb(this.sizeX, this.sizeY);
//        ARGB empty = new ARGB(1,0,0,0);
//        for(int j = 0; j<=this.sizeY-1; j++){
//            for(int i = 0; i<=this.sizeX-1; i++){
//                m2d.setValue(i, j, empty);
//            }
//        }
//        for(int j = 1; j<this.sizeY-1; j++){
//            for(int i = 1; i<this.sizeX-1; i++){
//                p00 = this.getValue(i-1, j-1);
//                p01 = this.getValue(i, j-1);
//                p02 = this.getValue(i+1, j-1);
//
//                p10 = this.getValue(i-1, j);
//                p11 = this.getValue(i, j);
//                p12 = this.getValue(i+1, j);
//
//                p20 = this.getValue(i-1, j+1);
//                p21 = this.getValue(i, j+1);
//                p22 = this.getValue(i+1, j+1);
//
//                if( Color.colorDistance(p11, p00)>=r ){
//                    m2d.setValue( i-1, j-1, p00 );
//                }
//                if( Color.colorDistance(p11, p01)>=r ){
//                    m2d.setValue( i, j-1, p01);
//                }
//                if( Color.colorDistance(p11, p02)>=r ){
//                    m2d.setValue( i+1, j-1, p02);
//                }
//
//                if( Color.colorDistance(p11, p10)>=r ){
//                    m2d.setValue( i-1, j, p10);
//                }
//                if( Color.colorDistance(p11, p12)>=r ){
//                    m2d.setValue( i+1, j, p12);
//                }
//
//                if( Color.colorDistance(p11, p20)>=r ){
//                    m2d.setValue( i-1, j+1, p20);
//                }
//                if( Color.colorDistance(p11, p21)>=r ){
//                    m2d.setValue( i, j+1, p21);
//                }
//                if( Color.colorDistance(p11, p22)>=r ){
//                    m2d.setValue( i+1, j+1, p22);
//                }
//            }
//        }
//        return m2d;
//    }
//
//    /**
//     * count edge by RGB color distance
//     * @return
//     */
//    public Matrix2dArgb middleColor(){
//        ARGB p00, p01, p02, p10, p11, p12, p20, p21, p22;
//        Matrix2dArgb m2d = new Matrix2dArgb(this.sizeX, this.sizeY);
//        ARGB empty = new ARGB(1,0,0,0);
//        for(int j = 0; j<=this.sizeY-1; j++){
//            for(int i = 0; i<=this.sizeX-1; i++){
//                m2d.setValue(i, j, empty);
//            }
//        }
//        for(int j = 1; j<this.sizeY-1; j++){
//            for(int i = 1; i<this.sizeX-1; i++){
//                p00 = this.getValue(i-1, j-1);
//                p01 = this.getValue(i, j-1);
//                p02 = this.getValue(i+1, j-1);
//
//                p10 = this.getValue(i-1, j);
//                p11 = this.getValue(i, j);
//                p12 = this.getValue(i+1, j);
//
//                p20 = this.getValue(i-1, j+1);
//                p21 = this.getValue(i, j+1);
//                p22 = this.getValue(i+1, j+1);
//
//                m2d.setValue( i, j, ARGB.countMiddle(p00, p01, p02, p10, p11, p12, p20, p21, p22) );
//            }
//        }
//        return m2d;
//    }
//
//
//
//    /**
//     * count edge by RGB color distance
//     * @return
//     */
//    public Matrix2dBoolean edgeByColorDistance(int r){
//        ARGB p00, p01, p02, p10, p11, p12, p20, p21, p22;
//        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
//        for(int j = 1; j<this.sizeY-1; j++){
//            for(int i = 1; i<this.sizeX-1; i++){
//                p00 = this.getValue(i-1, j-1);
//                p01 = this.getValue(i, j-1);
//                p02 = this.getValue(i+1, j-1);
//
//                p10 = this.getValue(i-1, j);
//                p11 = this.getValue(i, j);
//                p12 = this.getValue(i+1, j);
//
//                p20 = this.getValue(i-1, j+1);
//                p21 = this.getValue(i, j+1);
//                p22 = this.getValue(i+1, j+1);
//
//                if( Color.colorDistance(p11, p00)>=r ){
//                    m2d.setValue( i-1, j-1, true);
//                }
//                if( Color.colorDistance(p11, p01)>=r ){
//                    m2d.setValue( i, j-1, true);
//                }
//                if( Color.colorDistance(p11, p02)>=r ){
//                    m2d.setValue( i+1, j-1, true);
//                }
//
//                if( Color.colorDistance(p11, p10)>=r ){
//                    m2d.setValue( i-1, j, true);
//                }
//                if( Color.colorDistance(p11, p12)>=r ){
//                    m2d.setValue( i+1, j, true);
//                }
//
//                if( Color.colorDistance(p11, p20)>=r ){
//                    m2d.setValue( i-1, j+1, true);
//                }
//                if( Color.colorDistance(p11, p21)>=r ){
//                    m2d.setValue( i, j+1, true);
//                }
//                if( Color.colorDistance(p11, p22)>=r ){
//                    m2d.setValue( i+1, j+1,true);
//                }
//            }
//        }
//        return m2d;
//    }
//
//    public static ARGB middleColor4Pixels(Matrix2dArgb m2dArgb, int x, int y) {
//        int sizeX = m2dArgb.sizeX;
//        int sizeY = m2dArgb.sizeY;
//        ARGB empty = new ARGB(0xff, 0, 0, 0);
//        ARGB mask = new ARGB(0xff, 255, 255, 255);
//
//        ARGB p11, p12, p21, p22;
//        p11 = m2dArgb.getValue(x, y);
//        p12 = m2dArgb.getValue(x + 1, y);
//        p21 = m2dArgb.getValue(x, y + 1);
//        p22 = m2dArgb.getValue(x + 1, y + 1);
//        if (p11 == null) p11 = empty;
//        if (p12 == null) p12 = empty;
//        if (p21 == null) p21 = empty;
//        if (p22 == null) p22 = empty;
//        return new ARGB( (p11.a +p12.a + p21.a +p22.a)/4,
//                (p11.r +p12.r + p21.r +p22.r)/4,
//                (p11.g +p12.g + p21.g +p22.g)/4,
//                (p11.b +p12.b + p21.b +p22.b)/4);
//    }
//
//
//    public Matrix2dArgb selectByPattern4Pixels(int x, int y, int dist){
//        Matrix2dArgb m2d = new Matrix2dArgb(this.sizeX, this.sizeY);
//        ARGB empty = new ARGB(1,0,0,0);
//        for(int j = 0; j<=this.sizeY-1; j++){
//            for(int i = 0; i<=this.sizeX-1; i++){
//                m2d.setValue(i, j, empty);
//            }
//        }
//        ARGB p1, p2;
//        p1 = this.getValue(x, y);
//        for(int j = 1; j<this.sizeY-1; j++){
//            for(int i = 1; i<this.sizeX-1; i++) {
//                p2 = this.getValue(i, j);
//                if( ARGB.getDistance(p1, p2)<= dist){
//                    m2d.setValue(i, j, new ARGB(p2.a, p2.r, p2.g, p2.b));
//                }
//            }
//        }
//        return m2d;
//    }
//


}
