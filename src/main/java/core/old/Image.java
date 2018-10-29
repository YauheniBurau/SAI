package core.old;

import core.application.dataElement.AbstractElement;
import core.application.dataElement.Point;
import java.util.ArrayList;

/**
 * Created by anonymous on 02.03.2018.
 */

/**
 * this class only for preserving data
 * at the beginning, processing of data must be realised through another classes
 */
public class Image extends AbstractElement {
    // main data of images
    public String sId = ""; // for saving in files and its unique id for image
    public static int countId = 0; // for loading images from ssd to memory
    public int id; // for identification object in memory
    public ArrayList<Point> points = new ArrayList<Point>();
//    public ArrayList<Line> lines = new ArrayList<Line>();
//    public ArrayList<Arc> arcs = new ArrayList<Arc>();
//    public ArrayList<Texture> textures = new ArrayList<Texture>();
//    //public ArrayList<IDataElement> elements = new ArrayList<IDataElement>(); // points, lines, arcs, textures
//    public ArrayList<ElementImage> subImages = new ArrayList<ElementImage>();
//    public ArrayList<ImageConnection> subImageConnections = new ArrayList<ImageConnection>();

//    // temporal set of support matrix for calculations and transformations
//    public Matrix2dArgb m2dArgbValues = null;
//    public Matrix2dInt m2dIntValues = null; // for saving id of segments
//    public Matrix2dByte m2dByteValues = null; // byte matrix for processing
//    public Matrix2dBoolean m2dBooleanValues = null; // for creating temp mask
//    public ArrayList<Segment> segments = null;

//    public ElementImage loadPictureInM2dArgb(String urlFile){
//        this.m2dArgbValues = Matrix2dArgb.load(urlFile);
//        return this;
//    }
//
//    /**
//     * find all segments
//     * @param maxDiff
//     * @return
//     */
//    public ArrayList<Segment> findSegments(int maxDiff) {
////        this.m2dByteValues = MatrixConverter.matrix2dArgbToMatrix2dByte(this.m2dArgbValues);
//        ArrayList<Segment> segments = this.m2dByteValues.findSegments(maxDiff);
//        return segments;
//    }




    //    public void removeElement(String id){
//        if(this.elements.containsKey(id)) {
//            this.elements.remove(id);
//        }
//    }
//
//    public ArrayList<Point2dByte> toArrayOfPoint2dByte() {
//        ArrayList<Point2dByte> points = new ArrayList<Point2dByte>();
//        for(IDataElement dataElement: elements.values()) {
//            points.addAll(dataElement.toArrayOfPoint2dByte());
//        }
//        return points;
//    }
//
//    public byte[] toData() {
//        byte[] data;
//        ArrayList<Byte> bytes = new ArrayList<Byte>();
//        for (IDataElement dataElement: elements.values()) {
//            data = dataElement.toData();
//            for(int j = 0; j<data.length; j++) {
//                bytes.add(data[j]);
//            }
//        }
//        int size = bytes.size();
//        byte[] result = new byte[size];
//        for (int i = 0; i<size; i++){
//            result[i] = bytes.get(i);
//        }
//        return result;
//    }
//
//    public void save(String path, String id){
//        File file = new File(path + id); // TODO: File file = new File(path + this.getId() );
//        FileOutputStream fos;
//        try {
//            fos = new FileOutputStream(file);
//            for (IDataElement e: this.elements.values() ) {
//                fos.write( e.toData() );
//            }
//            fos.flush();
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static ElementImage load(String path, String id){
//        ElementImage img = new ElementImage();
//        img.id = id;
//        File file = new File(path + id);
//        FileInputStream fis;
//        byte[] bytes;
//        long n;
//        int j = 0;
//        byte b;
//        short s;
//        int i;
//        long l;
//        double d;
//        byte value = 127;
//        Point2dByte point2dByte;
//        try {
//            fis = new FileInputStream(file);
//            n = file.length();
//            bytes = new byte[(int)n]; // TODO: here can be troubles if file longer then int
//            fis.read(bytes);
//            while(j<n){
//                b = bytes[j];
//                switch(b){
//                    case 1 : point2dByte = new Point2dByte("P" + bytes[j+1] + " " + bytes[j+2], bytes[j+1], bytes[j+2], value);
//                        img.setElement(point2dByte);
//                        j+=3;
//                        break;
//                    case 2 : break; // TODO:
//                    case 3 : break; // TODO:
//                    case 4 : break; // TODO:
//                }
//            }
//            fis.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return img;
//    }
//

}
