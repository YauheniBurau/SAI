package core.matrix;

import core.element.ARGB;
import core.element.Color;
import core.exceptions.FileException;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by anonymous on 06.10.2017.
 */
public class Matrix2dArgb implements IMatrix2d<ARGB>{
    private ARGB[][] matrix;
    public final int sizeX;
    public final int sizeY;

    public Matrix2dArgb(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new ARGB[ySize][xSize];
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

    /**
     * convert matrix2dArgb into Matrix2dHsv where new value = HSV from argb color
     * @return
     */
    public Matrix2dHsv toHsv(){
        int sizeX = this.sizeX;
        int sizeY = this.sizeY;
        Matrix2dHsv m2d = new Matrix2dHsv(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++) {
                m2d.setValue( i,j, this.getValue(i,j).toHsv() );
            }
        }
        return m2d;
    }

    /**
     * load matrix2d from image ARGB-file
     * @param urlFile
     * @return
     */
    public static Matrix2dArgb load(String urlFile) {
        BufferedImage image;
        int x, y;
        ARGB color;
        try {
            image = ImageIO.read(new FileImageInputStream(new File(urlFile)));
        } catch (IOException e) {
            throw new FileException("Can't read image file into matrix2d<ARGB>", e);
        }
        y = image.getHeight();
        x = image.getWidth();
        Matrix2dArgb matrix2D = new Matrix2dArgb(x, y);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                color = Color.intToArgb( image.getRGB(i,j) );
                matrix2D.setValue(i,j, color);
            }
        }
        return matrix2D;
    }

    /**
     * save matrix to image-file
     * @param urlFile
     * @param format
     */
    public Matrix2dArgb save(String urlFile, String format, int type) {
        BufferedImage image;
        int x, y;
        image = new BufferedImage(this.sizeX, this.sizeY, type);
        y = this.sizeY;
        x = this.sizeX;
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                image.setRGB( i, j, Color.argbToInt(this.getValue(i, j)) );
            }
        }
        try {
            ImageIO.write(image, format, new File(urlFile));
        } catch (IOException e) {
            throw new FileException("Can't write matrix2d to image file", e);
        }
        return this;
    }

    /**
     * Reduce size of matrix2d to n-times on axis x and y by selecting every nx-element
     * @param nx
     * @return
     */
    public Matrix2dArgb reduce(int nx){
        int resizedX = this.sizeX/nx;
        int resizedY = this.sizeY/nx;
        Matrix2dArgb m2d = new Matrix2dArgb(resizedX, resizedY);
        for(int j = 0; j<resizedY; j++){
            for(int i = 0; i<resizedX; i++){
                m2d.setValue(i, j, this.getValue(i*nx, j*nx) );
            }
        }
        return m2d;
    }

    /**
     * Stretch size of matrix2d to 2-times on axis x and y by doubling every point
     * @return
     */
    public Matrix2dArgb stretch2x(){
        int x = this.sizeX;
        int y = this.sizeY;
        int resizedX = this.sizeX*2;
        int resizedY = this.sizeY*2;
        ARGB p;
        Matrix2dArgb m2d = new Matrix2dArgb(resizedX, resizedY);
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                p = this.getValue(i, j);
                m2d.setValue(i*2, j*2, p );
                m2d.setValue(i*2+1, j*2, p );
                m2d.setValue(i*2, j*2+1, p );
                m2d.setValue(i*2+1, j*2+1, p );
            }
        }
        return m2d;
    }

    /**
     * count edge by RGB color distance
     * @return
     */
    public Matrix2dBoolean edgeByColorDistance(int r){
        ARGB p00, p01, p02, p10, p11, p12, p20, p21, p22;
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

                if( Color.colorDistance(p11, p00)>=r ){
                    m2d.setValue( i-1, j-1, true);
                }
                if( Color.colorDistance(p11, p01)>=r ){
                    m2d.setValue( i, j-1, true);
                }
                if( Color.colorDistance(p11, p02)>=r ){
                    m2d.setValue( i+1, j-1, true);
                }

                if( Color.colorDistance(p11, p10)>=r ){
                    m2d.setValue( i-1, j, true);
                }
                if( Color.colorDistance(p11, p12)>=r ){
                    m2d.setValue( i+1, j, true);
                }

                if( Color.colorDistance(p11, p20)>=r ){
                    m2d.setValue( i-1, j+1, true);
                }
                if( Color.colorDistance(p11, p21)>=r ){
                    m2d.setValue( i, j+1, true);
                }
                if( Color.colorDistance(p11, p22)>=r ){
                    m2d.setValue( i+1, j+1,true);
                }
            }
        }
        return m2d;
    }


}
