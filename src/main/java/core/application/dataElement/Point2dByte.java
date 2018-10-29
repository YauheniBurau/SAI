package core.application.dataElement;

/**
 * Created by anonymous on 02.03.2018.
 */
public class Point2dByte extends AbstractElement{
    public int x;
    public int y;
    public byte value;

    public Point2dByte(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Point2dByte(int x, int y, byte value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

}
