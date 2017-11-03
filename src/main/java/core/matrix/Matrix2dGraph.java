package core.matrix;

import core.element.Graph;
import core.element.Point2d;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.ArrayList;

/**
 * Created by anonymous on 12.10.2017.
 */
public class Matrix2dGraph {
    private Graph[][] matrix;
    public final int sizeX;
    public final int sizeY;

    public Matrix2dGraph(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new Graph[ySize][xSize];
    }

    public void setValue(int xPos, int yPos, Graph value) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public Graph getValue(int xPos, int yPos) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            return this.matrix[yPos][xPos];
        }
        return null;
    }

    /**
     * count angle by 3 points
     * @param c
     * @par am a
     * @param b
     * @return
     */
    public static double findAngle(Point2d c, Point2d a, Point2d b ){
        double bx, by, ax, ay;
        double angle;
        bx = c.x - b.x;
        by = c.y - b.y;
        ax = c.x - a.x;
        ay = c.y - a.y;
        angle = Math.acos(
                (bx * ax + by * ay) /
                        ( Math.sqrt( bx*bx + by*by )* Math.sqrt(ax*ax + ay*ay) ) )
                *180/Math.PI;
        return angle;
    }

    /**
     * find points wich have only two connections
     * example:
     * 1b  3c
     * \ /
     *  2a
     * @param lengthMin
     * @param lengthMax
     * @param angleMin from 0.0 to Pi
     * @param angleMax from 0.0 to Pi
     * @return
     */
    public Matrix2dGraph findLines(double lengthMin, double lengthMax, double angleMin, double angleMax ){
        Matrix2dBoolean isProcessed = new Matrix2dBoolean(this.sizeX, this.sizeY);
        boolean isChanged;
        Graph a, b, c;
        Point2d pa, pb, pc;
        double lb, lc;
        double angle;
        do {
            for (int j = 0; j < this.sizeY; j++) {
                for (int i = 0; i < this.sizeX; i++) {
                    isProcessed.setValue(i, j, false);
                }
            }
            isChanged = false;
            for (int j = 0; j < this.sizeY; j++) {
                for (int i = 0; i < this.sizeX; i++) {
                    a = this.getValue(i, j);
                    if(a != null){
                        if (a.getPoints().size() == 2 && isProcessed.getValue(i,j)==false ) {
                            b = a.getPoints().get(0);
                            c = a.getPoints().get(1);
                            pa = a.getPoint();
                            pb = b.getPoint();
                            pc = c.getPoint();
                            lb = Math.sqrt( (pb.x-pa.x)*(pb.x-pa.x) + (pb.y-pa.y)*(pb.y-pa.y) );
                            lc = Math.sqrt( (pa.x-pc.x)*(pa.x-pc.x) + (pa.y-pc.y)*(pa.y-pc.y) );
                            // angle between two lines
                            angle = this.findAngle(pa, pb, pc);
                            if( lb >= lengthMin && lb <= lengthMax
                                    && lc >= lengthMin && lc <= lengthMax
                                    && angle>=angleMin && angle <= angleMax){
                                isChanged = true;
                                b.getPoints().remove(a);
                                c.getPoints().remove(a);
                                b.getPoints().add(c);
                                c.getPoints().add(b);
                                this.setValue(i, j, null);
                            }
                            isProcessed.setValue(pb.x, pb.y, true);
                            isProcessed.setValue(pc.x, pc.y, true);
                        }
                    }
                }
            }
        }while(isChanged == true);
        return this;
    }

    /**
     * convert graph of points and lines into boolean mask image
     * @return
     */
    public Matrix2dBoolean toBoolean(){
        Matrix2dBoolean m2d = new Matrix2dBoolean(this.sizeX, this.sizeY);
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                m2d.setValue(i, j, false);
            }
        }
        Graph g1;
        ArrayList<Graph> graphs;
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                g1 = this.getValue(i, j);
                if(g1!=null){
                    graphs = g1.getPoints();
                    if (graphs.size()>0) {
                        for (Graph g2: graphs) {
                            m2d.drawLine(g1.getPoint().x, g1.getPoint().y, g2.getPoint().x, g2.getPoint().y);
                        }
                    }
                }
            }
        }
        return m2d;
    }

    /**
     * count number of not null elements
     * @return
     */
    public int countPoints(){
        Graph g;
        Point2d p;
        int n = 0;
        for (int j = 0; j < this.sizeY; j++) {
            for (int i = 0; i < this.sizeX; i++) {
                g = this.getValue(i, j);
                if( g!=null ){
                    n++;
                }
            }
        }
        return n;
    }

}
