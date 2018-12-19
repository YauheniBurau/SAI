package core.application.VertexValue.coords;

import java.util.ArrayList;

/**
 * Created by anonymous on 04.12.2018.
 */
public class LinkedDecart2dInt {
    private Decart2dInt point;
    private ArrayList<LinkedDecart2dInt> points = new ArrayList<LinkedDecart2dInt>();

    public LinkedDecart2dInt(Decart2dInt point) {
        this.point = point;
        this.points = new ArrayList<LinkedDecart2dInt>();
    }

    public LinkedDecart2dInt(Decart2dInt point, ArrayList<LinkedDecart2dInt> points) {
        this.point = point;
        this.points = points;
    }

    public Decart2dInt getPoint() {
        return point;
    }

    public void setPoint(Decart2dInt point) {
        this.point = point;
    }

    public ArrayList<LinkedDecart2dInt> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<LinkedDecart2dInt> points) {
        this.points = points;
    }

}
