package core.converter;

import core.element.*;
import core.matrix.*;
import core.old.Matrix2dNeuron;
import core.old.neurons.Neuron;
import core.old.neurons.NeuronBuilder;

import java.util.ArrayList;

// TODO: refactor all class
/**
 * Created by anonymous on 03.02.2018.
 */
public class Converter {

    // TODO:
    public static Matrix2dNeuron argbToNeuron(Matrix2dArgb m2d){
        return null;
    }

    public static int byteToArgbInt(byte value){
        int v = value + 128;
        int i = 0x00000000;
        i = i | 0xff;
        i = i<<8 | v;
        i = i<<8 | v;
        i = i<<8 | v;
        return i;
    }

    /**
     * convert Matrix2dByte to Segment
     * @param m2d
     * @return
     */
    public static Segment matrix2dByteToSegment(Matrix2dByte m2d){
        Segment segment = new Segment();
        segment.mainM2d = m2d;
        ArrayList<Point2dByte> points = segment.points;
        int sizeX = m2d.sizeX;
        int sizeY = m2d.sizeY;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                points.add( new Point2dByte(i, j, m2d.getValue(i, j) ));
            }
        }
        return segment;
    }

    /**
     * convert Matrix2dByte to Segment
     * @param m2d
     * @return
     */
    public static Segment matrix2dByteToBinSegment(Matrix2dByte m2d){
        Segment segment = new Segment();
        segment.mainM2d = m2d;
        ArrayList<Point2dByte> points = segment.points;
        int sizeX = m2d.sizeX;
        int sizeY = m2d.sizeY;
        byte v;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                v = m2d.getValue(i, j);
                if(v!=-128) v = 127;
                points.add( new Point2dByte(i, j, v) );
            }
        }
        return segment;

    }


    // TODO: now converts only Point2dNeuron-es
    /**
     * convert Matrix2d of point2d, arc2d, line2d neurons into boolean mask image
     * @return
     */
    public static Matrix2dBoolean neuronToBoolean(Matrix2dNeuron m2d){
        int sizeX = m2d.sizeX;
        int sizeY = m2d.sizeY;
        Matrix2dBoolean m2dB = new Matrix2dBoolean(sizeX, sizeY);
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                m2dB.setValue(i, j, false);
            }
        }
        Neuron n1;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                n1 = m2d.getValue(i, j);
                if(n1!=null){
                    m2dB.setValue(i, j, true);
                }
            }
        }
        return m2dB;
    }

    /**
     * Converts boolean into Neurons
     * @param m2d
     * @return
     */
    public static Matrix2dNeuron booleanToNeurons(Matrix2dBoolean m2d) {
        int sizeX = m2d.sizeX;
        int sizeY = m2d.sizeY;
        Neuron n1, n2, n3, n4, n5, n6, n7, n8, n9;
        Matrix2dNeuron m2dN = new Matrix2dNeuron(sizeX, sizeY);
        for (int j = 1; j < sizeY-1; j++) {
            for (int i = 1; i < sizeX-1; i++) {
                if(m2d.getValue(i, j)==true) m2dN.setValue(i, j, NeuronBuilder.newPoint2dNeuron(i, j));
            }
        }
        for (int j = 1; j < sizeY-1; j++) {
            for (int i = 1; i < sizeX-1; i++) {
                n1 = m2dN.getValue(i, j);
                if(n1 != null ) {
                    n2 = m2dN.getValue(i, j - 1);
                    n3 = m2dN.getValue(i + 1, j - 1);
                    n4 = m2dN.getValue(i + 1, j);
                    n5 = m2dN.getValue(i + 1, j + 1);
                    n6 = m2dN.getValue(i, j + 1);
                    n7 = m2dN.getValue(i - 1, j + 1);
                    n8 = m2dN.getValue(i - 1, j);
                    n9 = m2dN.getValue(i - 1, j - 1);
//                    if (n2 != null) { n1.setNeuron(n2); n2.setNeuron(n1); }
//                    if (n3 != null) { n1.setNeuron(n3); n3.setNeuron(n1); }
//                    if (n4 != null) { n1.setNeuron(n4); n4.setNeuron(n1); }
//                    if (n5 != null) { n1.setNeuron(n5); n5.setNeuron(n1); }
//                    if (n6 != null) { n1.setNeuron(n6); n6.setNeuron(n1); }
//                    if (n7 != null) { n1.setNeuron(n7); n7.setNeuron(n1); }
//                    if (n8 != null) { n1.setNeuron(n8); n8.setNeuron(n1); }
//                    if (n9 != null) { n1.setNeuron(n9); n9.setNeuron(n1); }
                }
            }
        }
        return m2dN;
    }

//    public static Image matrix2dBooleanToImage(Matrix2dBoolean m2d){
//        Image img = new Image();
//        ArrayList<Point2d> points = new ArrayList<Point2d>();
//        ArrayList<Point2dByte> pointsByte = new ArrayList<Point2dByte>();
//        byte value = 127;
//        int sizeX = m2d.sizeX;
//        int sizeY = m2d.sizeY;
//        for (int j = 0; j < sizeY; j++) {
//            for (int i = 0; i < sizeX; i++) {
//                if(m2d.getValue(i, j)==true) points.add( new Point2d(i,j) );
//            }
//        }
//        // здесь должно быть преобразование точек и поворот их, чтобы выровнять ось симметрии вертикеально
//
//        Point2d c = m2d.countCenterOfSymmetry();
//        int angle = m2d.countAngleAxisOfSymmetry(c);
//        int l = c.x;
//        int r = c.x;
//        int u = c.y;
//        int d = c.y;
//        for(Point2d p : points){
//            if( p.x < l ) l = p.x;
//            if( p.x > r ) r = p.x;
//            if( p.y < u ) u = p.y;
//            if( p.y > d ) d = p.y;
//        }
//        double width = r - l;
//        double high = d - u;
//        double wStep = width/256;
//        double hStep = high/256;
//        Point2dByte pb;
//        byte x, y;
//        // преобразуем координаты точек в значения относительно центра от -128 до 127
//        for(Point2d p : points) {
//            x = (byte)(-128 + 255*(p.x - l)/width );
//            y = (byte)(-128 + 255*(p.y - u)/high);
//            pb = new Point2dByte(x, y, value);
//            img.setElement(pb);
//        }
//        return img;
//    }
//
//    public static Image matrix2dByteToImage(Matrix2dByte m2d){
//        Image img = new Image();
//        ArrayList<Point2d> points = new ArrayList<Point2d>();
//        ArrayList<Point2dByte> pointsByte = new ArrayList<Point2dByte>();
//        byte value = 127;
//        int sizeX = m2d.sizeX;
//        int sizeY = m2d.sizeY;
//        for (int j = 0; j < sizeY; j++) {
//            for (int i = 0; i < sizeX; i++) {
//                points.add( new Point2d(i,j, Converter.byteToInt(m2d.getValue(i, j))) );
//            }
//        }
//        // здесь должно быть преобразование точек и поворот их, чтобы выровнять ось симметрии вертикеально
//
//        //        Point2d c = m2d.countCenterOfSymmetry();
//        //        int angle = m2d.countAngleAxisOfSymmetry(c);
//        // TODO: number of points in matrix must be more than 0;
//        Point2d c = points.get(0);
//        int l = c.x;
//        int r = c.x;
//        int u = c.y;
//        int d = c.y;
//        for(Point2d p : points){
//            if( p.x < l ) l = p.x;
//            if( p.x > r ) r = p.x;
//            if( p.y < u ) u = p.y;
//            if( p.y > d ) d = p.y;
//        }
//        double width = r - l;
//        double high = d - u;
//        double wStep = width/256;
//        double hStep = high/256;
//        Point2dByte pb;
//        byte x, y;
//        // преобразуем координаты точек в значения относительно центра от -128 до 127
//        for(Point2d p : points) {
//            x = (byte)(-128 + 255*(p.x - l)/width );
//            y = (byte)(-128 + 255*(p.y - u)/high);
//            pb = new Point2dByte(x, y, Converter.intToByte(p.getValue()) );
//            img.setElement(pb);
//        }
//        return img;
//    }
//
//
//    public static Matrix2dBoolean imageToMatrix2dBoolean(Image img){
//        Matrix2dBoolean m2d = new Matrix2dBoolean(256,256);
//        ArrayList<Point2dByte> points = img.toArrayOfPoint2dByte();
//        for(IElement p : img.elements.values()){
//            for( Point2dByte point2dByte: points ) {
//                m2d.setValue( point2dByte.x+128, point2dByte.y+128,true);
//            }
//        }
//        return m2d;
//    }
//
//    public static Image ArrayListPoint2dToImage(ArrayList<Point2d> points){
//        byte value = 127;
//        Image img = new Image();
//        ArrayList<Point2dByte> pointsByte = new ArrayList<Point2dByte>();
//        int l = points.get(0).x;
//        int r = points.get(0).x;
//        int u = points.get(0).y;
//        int d = points.get(0).y;
//        for(Point2d p : points){
//            if( p.x < l ) l = p.x;
//            if( p.x > r ) r = p.x;
//            if( p.y < u ) u = p.y;
//            if( p.y > d ) d = p.y;
//        }
//        double width = r - l;
//        double high = d - u;
//        // преобразуем координаты точек в значения относительно центра от -128 до 127
//        Point2dByte pb;
//        byte x, y;
//        for(Point2d p : points) {
//            x = (byte)(-128 + 255*(p.x - l)/width );
//            y = (byte)(-128 + 255*(p.y - u)/high);
//            pb = new Point2dByte(x, y, value);
//            img.setElement(pb);
//        }
//        return img;
//    }

    public ArrayList<Point2d> matrix2dBooleanToArrayListPoint2d(Matrix2dBoolean m2d) {
        ArrayList<Point2d> points = new ArrayList<Point2d>();
        int sizeX = m2d.sizeX;
        int sizeY = m2d.sizeY;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                if(m2d.getValue(i, j)==true) points.add( new Point2d(i,j) );
            }
        }
        return points;
    }

    public static ArrayList<Point2dGeneric<HSV>> arrayListPoint2dHsvDivideByValue(ArrayList<Point2dGeneric<HSV>> points, int value) {
        ArrayList<Point2dGeneric<HSV>> pointsHSV = new ArrayList<Point2dGeneric<HSV>>();
        HSV hsv;
        for (Point2dGeneric<HSV> p: points) {
            if(p.getValue().v < value){
                hsv = new HSV(p.getValue().h, p.getValue().s, p.getValue().v);
                pointsHSV.add(new Point2dGeneric<HSV>(p.x, p.y, hsv) );
            }
        }
        return pointsHSV;
    }


    /**
     * convert matrix2dArgb into Matrix2dHsv where new value = HSV from argb color
     * @return
     */
    public static Matrix2dHsv matrix2dArgbToMatrix2dHsv(Matrix2dArgb in){
        int sizeX = in.sizeX;
        int sizeY = in.sizeY;
        Matrix2dHsv m2d = new Matrix2dHsv(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++) {
                m2d.setValue( i,j, ElementConverter.argbToHsv(in.getValue(i,j)) );
            }
        }
        return m2d;
    }

    /**
     * convert Matrix2dHsv into matrix2dArgb where new value = argb from HSV color
     * @return
     */
    public static Matrix2dArgb matrix2dHsvToMatrix2dArgb(Matrix2dHsv in){
        int sizeX = in.sizeX;
        int sizeY = in.sizeY;
        Matrix2dArgb m2d = new Matrix2dArgb(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++) {
                m2d.setValue( i,j, ElementConverter.hsvToArgb(in.getValue(i,j)) );
            }
        }
        return m2d;
    }


    /**
     * convert matrix2dArgb into Matrix2dHsv where new value = HSV from argb color
     * @return
     */
    public static Matrix2dByte matrix2dHsvToMatrix2dByteByValue(Matrix2dHsv in){
        int sizeX = in.sizeX;
        int sizeY = in.sizeY;
        Matrix2dByte m2d = new Matrix2dByte(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++) {
                m2d.setValue( i,j, intToByte(in.getValue(i,j).v) );
            }
        }
        return m2d;
    }

    /**
     * convert matrix2dArgb into Matrix2dHsv where new value = HSV from argb color
     * @return
     */
    public static Matrix2dByte matrix2dHsvToMatrix2dByteByHue(Matrix2dHsv in){
        int sizeX = in.sizeX;
        int sizeY = in.sizeY;
        Matrix2dByte m2d = new Matrix2dByte(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++) {
                m2d.setValue( i,j, intToByte(in.getValue(i,j).h) );
            }
        }
        return m2d;
    }

    /**
     * convert matrix2dArgb into Matrix2dHsv where new value = HSV from argb color
     * @return
     */
    public static Matrix2dByte matrix2dHsvToMatrix2dByteBySaturation(Matrix2dHsv in){
        int sizeX = in.sizeX;
        int sizeY = in.sizeY;
        Matrix2dByte m2d = new Matrix2dByte(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++) {
                m2d.setValue( i,j, intToByte(in.getValue(i,j).s) );
            }
        }
        return m2d;
    }

    /**
     * convert matrix2dArgb into Matrix2dHsv where new value = HSV from argb color
     * @return
     */
    public static Matrix2dArgb matrix2dByteValueTomatrix2dArgb(Matrix2dByte in){
        int sizeX = in.sizeX;
        int sizeY = in.sizeY;
        int v;
        Matrix2dArgb m2d = new Matrix2dArgb(sizeX, sizeY);
        for(int j = 0; j<sizeY; j++){
            for(int i = 0; i<sizeX; i++) {
                v = byteToInt(in.getValue(i,j));
                m2d.setValue( i,j, new ARGB( 0xffffffff, v, v, v) );
            }
        }
        return m2d;
    }


    /**
     * convert int to byte
     * @param in
     * @return
     */
    public static byte intToByte(int in) {
        byte result = 0;
        if(in>255){ result = 127;}
        else if(in<0){ result = -128;}
        else{ result = (byte)(in - 128); }
        return result;
    }

    /**
     * convert byte to int
     * @param in
     * @return
     */
    public static int byteToInt(byte in) {
        return in + 128;
    }

    /**
     * convert Segment to Matrix2dByte
     * @return
     */
    public static Matrix2dByte segmentToMatrix2dByte(Segment in){
        if(in.points.size()==0) return null;
        int l = Integer.MAX_VALUE;
        int u = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;
        for(Point2dByte p : in.points){
            if( p.x < l ) l = p.x;
            if( p.y < u ) u = p.y;
            if( p.x > r ) r = p.x;
            if( p.y > d ) d = p.y;
        }

        int sizeX = r+1;
        int sizeY = d+1;
        Matrix2dByte m2d = new Matrix2dByte(sizeX, sizeY, (byte)-128);
        for(Point2dByte p: in.points){
            m2d.setValue(p.x, p.y, p.value);
        }
        return m2d;
    }

}
