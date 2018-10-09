package core.element;

import java.util.ArrayList;


// TODO: remove
/**
 * Created by anonymous on 12.10.2017.
 */
public class Graph  extends AbstractElement{
    private Point point;
    private ArrayList<Graph> points = new ArrayList<Graph>();

    public Graph(Point point) {
        this.point = point;
        this.points = new ArrayList<Graph>();
    }

    public Graph(Point point, ArrayList<Graph> points) {
        this.point = point;
        this.points = points;
    }

    public Point getPoint() {
        return this.point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public ArrayList<Graph> getPoints() {
        return this.points;
    }

    public void setPoints(ArrayList<Graph> points) {
        this.points = points;
    }

}
