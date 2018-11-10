package core.application.dataElement;

import core.old.Point;

import java.util.LinkedList;

/**
 * Created by anonymous on 14.06.2018.
 */
public class Conture extends AbstractElement{
    // main data of images
    public String UID = ""; // for saving in files and its unique id for image
    public static int count = 0; // for loading images from HardRam to TempRam
    public int id; // for identification object in memory
    public LinkedList<Point> points = new LinkedList<Point>();

    public Conture() {
        id = Conture.count;
        Conture.count += 1;
    }


}
