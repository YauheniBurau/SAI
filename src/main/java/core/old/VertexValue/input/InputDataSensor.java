package core.old.VertexValue.input;

import core.old.VertexValue.coords.Decart2dInt;
import core.old.VertexValue.coords.Decart2dIntLinks;
import core.old.VertexValue.matrix.Matrix2dBool;
import core.old.VertexValue.matrix.Matrix2dByte;
import core.old.VertexValue.matrix.Matrix2dDecart2dIntLinks;

import java.util.ArrayList;

/**
 * Created by anonymous on 05.01.2019.
 */
public class InputDataSensor {
    public int sizeX = 1024;
    public int sizeY = 1024;

    public Matrix2dByte inputM2d;
    public Matrix2dBool isActiveM2d;
    public Matrix2dDecart2dIntLinks contourM2d;

    public InputDataSensor(){
        this.inputM2d = null;
        this.isActiveM2d = null;
        this.contourM2d = null;
    }

    public InputDataSensor(int sizeX, int sizeY){
        this.inputM2d = new Matrix2dByte(sizeX, sizeY, null);
        this.isActiveM2d = new Matrix2dBool(sizeX, sizeY, null);
        this.contourM2d = new Matrix2dDecart2dIntLinks(sizeX*2+1, sizeY*2+1, null);
    }

    public void resetInputM2d(){
        this.inputM2d.resetValues(null);
    }

    public void resetIsActiveM2d(){
        this.isActiveM2d.resetValues(false);
    }

    public void resetContourM2d(){
        this.contourM2d.resetValues(null);
    }

    public void setInputM2d(Matrix2dByte in){
        this.sizeX = in.sizeX;
        this.sizeY = in.sizeY;
        this.inputM2d = new Matrix2dByte(sizeX, sizeY, null);
        this.isActiveM2d = new Matrix2dBool(sizeX, sizeY, null);
        this.contourM2d = new Matrix2dDecart2dIntLinks(sizeX*2+1, sizeY*2+1, null);
        // copy values from "in" to "inputM2d"
        Byte value;
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                value = in.getValue(i, j);
                this.inputM2d.setValue(i, j, value);
            }
        }
    }

    public void connect45Links(int x, int y, boolean in1, boolean in2, boolean in3, boolean in4,
                             boolean out1, boolean out2, boolean out3, boolean out4){
        Boolean d1, d2, d3, d4;
        Decart2dIntLinks p1, p2, p3, p4;
        d1 = this.isActiveM2d.getValue(x,y);
        d2 = this.isActiveM2d.getValue(x+1,y);
        d3 = this.isActiveM2d.getValue(x+1,y+1);
        d4 = this.isActiveM2d.getValue(x,y+1);
        p1 = this.contourM2d.getValue(x*2+2,y*2+1);
        p2 = this.contourM2d.getValue(x*2+3,y*2+2);
        p3 = this.contourM2d.getValue(x*2+2,y*2+3);
        p4 = this.contourM2d.getValue(x*2+1,y*2+2);
        if(d1==null) d1 = false;
        if(d2==null) d2 = false;
        if(d3==null) d3 = false;
        if(d4==null) d4 = false;
        if(d1 == in1 && d2 == in2 && d3 == in3 && d4 == in4) {
            // for out1
            if (out1 == true) {
                if (p1 == null) {
                    this.contourM2d.setValue(x * 2 + 2, y * 2 + 1, new Decart2dIntLinks(x * 2 + 2, y * 2 + 1));
                    p1 = this.contourM2d.getValue(x * 2 + 2, y * 2 + 1);
                }
                if (p4 == null) {
                    this.contourM2d.setValue(x * 2 + 1, y * 2 + 2, new Decart2dIntLinks(x * 2 + 1, y * 2 + 2));
                    p4 = this.contourM2d.getValue(x * 2 + 1, y * 2 + 2);
                }
                p1.add(p4);
                p4.add(p1);
            }
            // for out2
            if (out2 == true) {
                if (p1 == null) {
                    this.contourM2d.setValue(x * 2 + 2, y * 2 + 1, new Decart2dIntLinks(x * 2 + 2, y * 2 + 1));
                    p1 = this.contourM2d.getValue(x * 2 + 2, y * 2 + 1);
                }
                if (p2 == null) {
                    this.contourM2d.setValue(x * 2 + 3, y * 2 + 2, new Decart2dIntLinks(x * 2 + 3, y * 2 + 2));
                    p2 = this.contourM2d.getValue(x * 2 + 3, y * 2 + 2);
                }
                p1.add(p2);
                p2.add(p1);
            }
            // for out3
            if (out3 == true) {
                if (p2 == null) {
                    this.contourM2d.setValue(x * 2 + 3, y * 2 + 2, new Decart2dIntLinks(x * 2 + 3, y * 2 + 2));
                    p2 = this.contourM2d.getValue(x * 2 + 3, y * 2 + 2);
                }
                if (p3 == null) {
                    this.contourM2d.setValue(x * 2 + 2, y * 2 + 3, new Decart2dIntLinks(x * 2 + 2, y * 2 + 3));
                    p3 = this.contourM2d.getValue(x * 2 + 2, y * 2 + 3);
                }
                p2.add(p3);
                p3.add(p2);
            }
            // for out4
            if (out4 == true) {
                if (p3 == null) {
                    this.contourM2d.setValue(x * 2 + 2, y * 2 + 3, new Decart2dIntLinks(x * 2 + 2, y * 2 + 3));
                    p3 = this.contourM2d.getValue(x * 2 + 2, y * 2 + 3);
                }
                if (p4 == null) {
                    this.contourM2d.setValue(x * 2 + 1, y * 2 + 2, new Decart2dIntLinks(x * 2 + 1, y * 2 + 2));
                    p4 = this.contourM2d.getValue(x * 2 + 1, y * 2 + 2);
                }
                p3.add(p4);
                p4.add(p3);
            }
        }
    }

    /**
     *
     * @param x
     * @param y
     * @param in1
     * @param in2
     * @param in3
     * @param in4
     * @param out1 horizontal connection
     * @param out2 vertical connection
     */
    public void connect0Links(int x, int y, boolean in1, boolean in2, boolean in3, boolean in4,
                               boolean out1, boolean out2){
        Boolean d1, d2, d3, d4;
        Decart2dIntLinks p1, p2, p3, p4;
        d1 = this.isActiveM2d.getValue(x,y);
        d2 = this.isActiveM2d.getValue(x+1,y);
        d3 = this.isActiveM2d.getValue(x+1,y+1);
        d4 = this.isActiveM2d.getValue(x,y+1);
        p1 = this.contourM2d.getValue(x*2+2,y*2+1);
        p2 = this.contourM2d.getValue(x*2+3,y*2+2);
        p3 = this.contourM2d.getValue(x*2+2,y*2+3);
        p4 = this.contourM2d.getValue(x*2+1,y*2+2);
        if(d1==null) d1 = false;
        if(d2==null) d2 = false;
        if(d3==null) d3 = false;
        if(d4==null) d4 = false;
        if(d1 == in1 && d2 == in2 && d3 == in3 && d4 == in4) {
            // for out1
            if (out1 == true) {
                if (p2 == null) {
                    this.contourM2d.setValue(x * 2 + 3, y * 2 + 2, new Decart2dIntLinks(x * 2 + 3, y * 2 + 2));
                    p2 = this.contourM2d.getValue(x * 2 + 3, y * 2 + 2);
                }
                if (p4 == null) {
                    this.contourM2d.setValue(x * 2 + 1, y * 2 + 2, new Decart2dIntLinks(x * 2 + 1, y * 2 + 2));
                    p4 = this.contourM2d.getValue(x * 2 + 1, y * 2 + 2);
                }
                p2.add(p4);
                p4.add(p2);
            }
            // for out2
            if (out2 == true) {
                if (p1 == null) {
                    this.contourM2d.setValue(x * 2 + 2, y * 2 + 1, new Decart2dIntLinks(x * 2 + 2, y * 2 + 1));
                    p1 = this.contourM2d.getValue(x * 2 + 2, y * 2 + 1);
                }
                if (p3 == null) {
                    this.contourM2d.setValue(x * 2 + 2, y * 2 + 3, new Decart2dIntLinks(x * 2 + 2, y * 2 + 3));
                    p3 = this.contourM2d.getValue(x * 2 + 2, y * 2 + 3);
                }
                p1.add(p3);
                p3.add(p1);
            }
        }
    }


    /**
     * in1 in2
     * in4 in3
     *
     *  / * \   out1  out2
     * *     *
     *  \ * /   out4  out3
     *
     * based on matrix isActivatedM2d
     * @param x
     * @param y
     */
    public void countContourM2d(int x, int y){
        // count segment connected Points
        this.resetIsActiveM2d();
        ArrayList<Decart2dInt> activePoints = this.inputM2d.count8LSegmentPoints(x, y);
        for(Decart2dInt p: activePoints) {
            this.isActiveM2d.setValue(p.x, p.y, true);
        }
        // count matrix of contected points of contours of segment
        for (int j = -1; j <= this.sizeY; j++) {
            for (int i = -1; i <= this.sizeX; i++) {
                // * * |   * | *   | * *
                //   * | * * | * * | *
                this.connect45Links(i,j, true, true, true, false,  false, false, false, true);
                this.connect45Links(i,j, false, true, true, true,  true, false, false, false);
                this.connect45Links(i,j, true, false, true, true,  false, true, false, false);
                this.connect45Links(i,j, true, true, false, true,  false, false, true, false);
                // *   |   *
                //   * | *
                this.connect45Links(i,j, true, false, true, false,  false, true, false, true);
                this.connect45Links(i,j, false, true, false, true,  true, false, true, false);
                // *   |   * |     |     |
                //     |     |   * | *   |
                this.connect45Links(i,j, true, false, false, false,  true, false, false, false);
                this.connect45Links(i,j, false, true, false, false,  false, true, false, false);
                this.connect45Links(i,j, false, false, true, false,  false, false, true, false);
                this.connect45Links(i,j, false, false, false, true,  false, false, false, true);
                // * * |   * |     | *   |
                //     |   * | * * | *   |
                this.connect0Links(i,j, true, true, false, false,  true, false);
                this.connect0Links(i,j, false, true, true, false,  false, true);
                this.connect0Links(i,j, false, false, true, true,  true, false);
                this.connect0Links(i,j, true, false, false, true,  false, true);
            }
        }
    }

}
