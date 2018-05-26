package core.element;

/**
 * Created by anonymous on 06.05.2018.
 */
public class Edge implements Comparable<Edge>{
    public Point2dGeneric p1;
    public Point2dGeneric p2;
    public int diff;

    public Edge(Point2dGeneric p1, Point2dGeneric p2, int diff) {
        this.p1 = p1;
        this.p2 = p2;
        this.diff = diff;
    }

    public int compareTo(Edge o) {
        return this.diff - o.diff;
    }

}
