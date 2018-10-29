package core.application.dataElement;


/**
 * Created by anonymous on 18.03.2018.
 */
public class Line2dByte extends AbstractElement{
    private Point2dByte p1;
    private Point2dByte p2;

    public Line2dByte(Point2dByte p1, Point2dByte p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

}
