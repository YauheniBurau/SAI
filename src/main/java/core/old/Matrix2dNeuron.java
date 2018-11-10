package core.old;

/**
 * Created by anonymous on 03.02.2018.
 */

import core.old.neurons.Neuron;

public class Matrix2dNeuron {
    private Neuron[][] matrix;
    public final int sizeX;
    public final int sizeY;

    public Matrix2dNeuron(int xSize, int ySize) {
        this.sizeX = xSize;
        this.sizeY = ySize;
        this.matrix = new Neuron[ySize][xSize];
    }

    public void setValue(int xPos, int yPos, Neuron value) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            this.matrix[yPos][xPos] = value;
        }
    }

    public Neuron getValue(int xPos, int yPos) {
        if(xPos>=0 && xPos<this.sizeX && yPos>=0 && yPos<this.sizeY ) {
            return this.matrix[yPos][xPos];
        }
        return null;
    }

//    /**
//     * count a by 3 points
//     * @param c
//     * @par am a
//     * @param b
//     * @return
//     */
//    public static double findAngle(Point2d c, Point2d a, Point2d b ){
//        double bx, by, ax, ay;
//        double a;
//        bx = c.x - b.x;
//        by = c.y - b.y;
//        ax = c.x - a.x;
//        ay = c.y - a.y;
//        a = Math.acos(
//                (bx * ax + by * ay) /
//                        ( Math.sqrt( bx*bx + by*by )* Math.sqrt(ax*ax + ay*ay) ) )
//                *180/Math.PI;
//        return a;
//    }
//
//    /**
//     * find points wich have only two connections
//     * example:
//     * 1b  3c
//     * \ /
//     *  2a
//     * @param lengthMin
//     * @param lengthMax
//     * @param angleMin from 0.0 to Pi
//     * @param angleMax from 0.0 to Pi
//     * @return
//     */
//    public Matrix2dGraph findLines(double lengthMin, double lengthMax, double angleMin, double angleMax ){
//        Matrix2dBoolean isProcessed = new Matrix2dBoolean(this.size, this.sizeY);
//        boolean isChanged;
//        Graph a, b, c;
//        Point2d pa, pb, pc;
//        double lb, lc;
//        double a;
//        do {
//            for (int j = 0; j < this.sizeY; j++) {
//                for (int i = 0; i < this.size; i++) {
//                    isProcessed.setValue(i, j, false);
//                }
//            }
//            isChanged = false;
//            for (int j = 0; j < this.sizeY; j++) {
//                for (int i = 0; i < this.size; i++) {
//                    a = this.getValue(i, j);
//                    if(a != null){
//                        if (a.getPoints().size() == 2 && isProcessed.getValue(i,j)==false ) {
//                            b = a.getPoints().get(0);
//                            c = a.getPoints().get(1);
//                            pa = a.getPoint();
//                            pb = b.getPoint();
//                            pc = c.getPoint();
//                            lb = Math.sqrt( (pb.x-pa.x)*(pb.x-pa.x) + (pb.y-pa.y)*(pb.y-pa.y) );
//                            lc = Math.sqrt( (pa.x-pc.x)*(pa.x-pc.x) + (pa.y-pc.y)*(pa.y-pc.y) );
//                            // a between two lines
//                            a = this.findAngle(pa, pb, pc);
//                            if( lb >= lengthMin && lb <= lengthMax
//                                    && lc >= lengthMin && lc <= lengthMax
//                                    && a>=angleMin && a <= angleMax){
//                                isChanged = true;
//                                b.getPoints().remove(a);
//                                c.getPoints().remove(a);
//                                b.getPoints().add(c);
//                                c.getPoints().add(b);
//                                this.setValue(i, j, null);
//                            }
//                            isProcessed.setValue(pb.x, pb.y, true);
//                            isProcessed.setValue(pc.x, pc.y, true);
//                        }
//                    }
//                }
//            }
//        }while(isChanged == true);
//        return this;
//    }
//
//
//    /**
//     * transform Graph of points and lines into boolean mask image
//     * @return
//     */
//    public Matrix2dBoolean toBoolean(){
//        Matrix2dBoolean m2d = new Matrix2dBoolean(this.size, this.sizeY);
//        for (int j = 0; j < sizeY; j++) {
//            for (int i = 0; i < size; i++) {
//                m2d.setValue(i, j, false);
//            }
//        }
//        Graph g1;
//        ArrayList<Graph> graphs;
//        for (int j = 0; j < sizeY; j++) {
//            for (int i = 0; i < size; i++) {
//                g1 = this.getValue(i, j);
//                if(g1!=null){
//                    graphs = g1.getPoints();
//                    if (graphs.size()>0) {
//                        for (Graph g2: graphs) {
//                            m2d.drawLine(g1.getPoint().x, g1.getPoint().y, g2.getPoint().x, g2.getPoint().y);
//                        }
//                    }
//                }
//            }
//        }
//        return m2d;
//    }
//
//    /**
//     * to boolean only points
//     * @return
//     */
//    public Matrix2dBoolean toBooleanOnlyPoints(){
//        Matrix2dBoolean m2d = new Matrix2dBoolean(this.size, this.sizeY);
//        for (int j = 0; j < sizeY; j++) {
//            for (int i = 0; i < size; i++) {
//                m2d.setValue(i, j, false);
//            }
//        }
//        Graph g;
//        Point2d p;
//        int n = 0;
//        for (int j = 0; j < this.sizeY; j++) {
//            for (int i = 0; i < this.size; i++) {
//                g = this.getValue(i, j);
//                if( g!=null ){
//                    m2d.setValue(i, j, true);
//                }
//            }
//        }
//        return m2d;
//    }

}
