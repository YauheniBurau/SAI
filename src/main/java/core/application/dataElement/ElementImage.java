package core.application.dataElement;

import java.util.ArrayList;

/**
 * Created by anonymous on 20.09.2018.
 */
public class ElementImage extends AbstractElement{
    // main data of images
    public String UID = ""; // for saving in files and its unique id for image
    public static int count = 0; // for loading images from HardRam to TempRam
    public int id; // for identification object in memory
    public ArrayList<Point> points = new ArrayList<Point>();

    public ElementImage() {
        id = ElementImage.count;
        ElementImage.count += 1;
    }

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

}