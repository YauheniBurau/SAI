package core.element;

import java.util.ArrayList;

/**
 * Created by anonymous on 12.10.2017.
 */
public class Graph {
    private Point2d point;
    private ArrayList<Graph> points = new ArrayList<Graph>();

    public Graph(Point2d point) {
        this.point = point;
        this.points = new ArrayList<Graph>();
    }

    public Graph(Point2d point, ArrayList<Graph> points) {
        this.point = point;
        this.points = points;
    }

    public Point2d getPoint() {
        return this.point;
    }

    public void setPoint(Point2d point) {
        this.point = point;
    }

    public ArrayList<Graph> getPoints() {
        return this.points;
    }

    public void setPoints(ArrayList<Graph> points) {
        this.points = points;
    }

}
