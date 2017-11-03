package core.matrix;

import core.element.HSV;

/**
 * Created by anonymous on 06.10.2017.
 */
public class Matrix2dHsv implements IMatrix2d<HSV> {
    private HSV[][] matrix;
    public final int sizeX;
    public final int sizeY;

    public Matrix2dHsv(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new HSV[ySize][xSize];
    }

    public void setValue(int xPos, int yPos, HSV value) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public HSV getValue(int xPos, int yPos) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            return this.matrix[yPos][xPos];
        }
        return null;
    }

    /**
     * edge by color hue
     * @return
     */
    public Matrix2dBoolean edgeByColorHue(int r){
        HSV p00, p01, p02, p10, p11, p12, p20, p21, p22;
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for(int j = 1; j<this.sizeY-1; j++){
            for(int i = 1; i<this.sizeX-1; i++){
                p00 = this.getValue(i-1, j-1);
                p01 = this.getValue(i, j-1);
                p02 = this.getValue(i+1, j-1);

                p10 = this.getValue(i-1, j);
                p11 = this.getValue(i, j);
                p12 = this.getValue(i+1, j);

                p20 = this.getValue(i-1, j+1);
                p21 = this.getValue(i, j+1);
                p22 = this.getValue(i+1, j+1);

                if( Math.abs(p11.h - p00.h) >=r ){
                    m2d.setValue( i-1, j-1,true);
                }
                if( Math.abs(p11.h - p01.h)>=r ){
                    m2d.setValue( i, j-1,true);
                }
                if( Math.abs(p11.h - p02.h)>=r ){
                    m2d.setValue( i+1, j-1,true);
                }

                if( Math.abs(p11.h - p10.h)>=r ){
                    m2d.setValue( i-1, j, true);
                }
                if( Math.abs(p11.h - p12.h)>=r ){
                    m2d.setValue( i+1, j, true);
                }

                if( Math.abs(p11.h - p20.h)>=r ){
                    m2d.setValue( i-1, j+1, true);
                }
                if( Math.abs(p11.h - p21.h)>=r ){
                    m2d.setValue( i, j+1, true);
                }
                if( Math.abs(p11.h - p22.h)>=r ){
                    m2d.setValue( i+1, j+1, true);
                }
            }
        }
        return m2d;
    }

    /**
     * edge by color Saturation
     * @return
     */
    public Matrix2dBoolean edgeByColorSaturation(int r){
        HSV p00, p01, p02, p10, p11, p12, p20, p21, p22;
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for(int j = 1; j<this.sizeY-1; j++){
            for(int i = 1; i<this.sizeX-1; i++){
                p00 = this.getValue(i-1, j-1);
                p01 = this.getValue(i, j-1);
                p02 = this.getValue(i+1, j-1);

                p10 = this.getValue(i-1, j);
                p11 = this.getValue(i, j);
                p12 = this.getValue(i+1, j);

                p20 = this.getValue(i-1, j+1);
                p21 = this.getValue(i, j+1);
                p22 = this.getValue(i+1, j+1);

                if( Math.abs(p11.s - p00.s) >=r ){
                    m2d.setValue( i-1, j-1,true);
                }
                if( Math.abs(p11.s - p01.s)>=r ){
                    m2d.setValue( i, j-1,true);
                }
                if( Math.abs(p11.s - p02.s)>=r ){
                    m2d.setValue( i+1, j-1,true);
                }

                if( Math.abs(p11.s - p10.s)>=r ){
                    m2d.setValue( i-1, j, true);
                }
                if( Math.abs(p11.s - p12.s)>=r ){
                    m2d.setValue( i+1, j, true);
                }

                if( Math.abs(p11.s - p20.s)>=r ){
                    m2d.setValue( i-1, j+1, true);
                }
                if( Math.abs(p11.s - p21.s)>=r ){
                    m2d.setValue( i, j+1, true);
                }
                if( Math.abs(p11.s - p22.s)>=r ){
                    m2d.setValue( i+1, j+1, true);
                }
            }
        }
        return m2d;
    }

    /**
     *
     * @return
     */
    public Matrix2dBoolean edgeByColorValue(int r){
        HSV p00, p01, p02, p10, p11, p12, p20, p21, p22;
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for(int j = 1; j<this.sizeY-1; j++){
            for(int i = 1; i<this.sizeX-1; i++){
                p00 = this.getValue(i-1, j-1);
                p01 = this.getValue(i, j-1);
                p02 = this.getValue(i+1, j-1);

                p10 = this.getValue(i-1, j);
                p11 = this.getValue(i, j);
                p12 = this.getValue(i+1, j);

                p20 = this.getValue(i-1, j+1);
                p21 = this.getValue(i, j+1);
                p22 = this.getValue(i+1, j+1);

                if( Math.abs(p11.v - p00.v) >=r ){
                    m2d.setValue( i-1, j-1,true);
                }
                if( Math.abs(p11.v - p01.v)>=r ){
                    m2d.setValue( i, j-1,true);
                }
                if( Math.abs(p11.v - p02.v)>=r ){
                    m2d.setValue( i+1, j-1,true);
                }

                if( Math.abs(p11.v - p10.v)>=r ){
                    m2d.setValue( i-1, j, true);
                }
                if( Math.abs(p11.v - p12.v)>=r ){
                    m2d.setValue( i+1, j, true);
                }

                if( Math.abs(p11.v - p20.v)>=r ){
                    m2d.setValue( i-1, j+1, true);
                }
                if( Math.abs(p11.v - p21.v)>=r ){
                    m2d.setValue( i, j+1, true);
                }
                if( Math.abs(p11.v - p22.v)>=r ){
                    m2d.setValue( i+1, j+1, true);
                }
            }
        }
        return m2d;
    }

}
