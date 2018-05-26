package core.element;

import core.exceptions.FileException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by anonymous on 02.03.2018.
 */

/*
public class Image extends AbstractElement{
    public static final byte POINT_2D_BYTE = 1;
    public static final byte LINE_2D_BYTE = 2;
    public static final byte ARC_2D_BYTE = 3;
    public static final byte IMAGE = 4;

    public String id = ""; // 8 symbols
    public double aspectRatio = 1; // number of points X/Y
    public Point2dByte simetryAxis = null; // координаты точки оси симметрии
    public byte simetryAxisAngle = 0; // угол наклона оси симметрии

    public HashMap<String, IElement> elements = new HashMap<String, IElement>();

    public String getId() {
        return id;
    }


    // ELEMENTS
    public void setElement(IElement value){
        this.elements.put(value.getId(), value);
    }

    public IElement getElement(String id){
        if(this.elements.containsKey(id)) {
            return this.elements.get(id);
        }
        return null;
    }

    public void removeElement(String id){
        if(this.elements.containsKey(id)) {
            this.elements.remove(id);
        }
    }

    public ArrayList<Point2dByte> toArrayOfPoint2dByte() {
        ArrayList<Point2dByte> points = new ArrayList<Point2dByte>();
        for(IElement element: elements.values()) {
            points.addAll(element.toArrayOfPoint2dByte());
        }
        return points;
    }

    public byte[] toData() {
        byte[] data;
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        for (IElement element: elements.values()) {
            data = element.toData();
            for(int j = 0; j<data.length; j++) {
                bytes.add(data[j]);
            }
        }
        int size = bytes.size();
        byte[] result = new byte[size];
        for (int i = 0; i<size; i++){
            result[i] = bytes.get(i);
        }
        return result;
    }

    public void save(String path, String id){
        File file = new File(path + id); // TODO: File file = new File(path + this.getId() );
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            for (IElement e: this.elements.values() ) {
                fos.write( e.toData() );
            }
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Image load(String path, String id){
        Image img = new Image();
        img.id = id;
        File file = new File(path + id);
        FileInputStream fis;
        byte[] bytes;
        long n;
        int j = 0;
        byte b;
        short s;
        int i;
        long l;
        double d;
        byte value = 127;
        Point2dByte point2dByte;
        try {
            fis = new FileInputStream(file);
            n = file.length();
            bytes = new byte[(int)n]; // TODO: here can be troubles if file longer then int
            fis.read(bytes);
            while(j<n){
                b = bytes[j];
                switch(b){
                    case 1 : point2dByte = new Point2dByte("P" + bytes[j+1] + " " + bytes[j+2], bytes[j+1], bytes[j+2], value);
                        img.setElement(point2dByte);
                        j+=3;
                        break;
                    case 2 : break; // TODO:
                    case 3 : break; // TODO:
                    case 4 : break; // TODO:
                }
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }


}
*/