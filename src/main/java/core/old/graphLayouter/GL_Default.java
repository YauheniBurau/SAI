package core.old.graphLayouter;

import core.application.gui.model.type.Decart3d;
import core.application.gui.model.type.Polar3d;
import javafx.scene.paint.Color;

import java.util.Collection;

/**
 * count layout position of graphFX vertexes and edges accordingly
 */
//public class GL_Default extends AbstractGraphLayouter {
//    private double sphereRadius = 1000; // all elements will be randomly positioned in sphere of radius
//
//    public double getSphereRadius() {
//        return sphereRadius;
//    }
//
//    public GL_Default setSphereRadius(double sphereRadius) {
//        this.sphereRadius = sphereRadius;
//        return this;
//    }
//
//    public void process(GraphLayout graphLayout){
//        double r;
//        double latitudeAngle;
//        double longitudeAngle;
//        Collection<IVertexLayout> vertexes = graphLayout.getVertexes();
//        Decart3d p3d;
//        for(IVertexLayout v: vertexes) {
//            r = Math.random()*this.sphereRadius;
//            latitudeAngle = Math.random()*2*Math.PI;
//            longitudeAngle = Math.random()*2*Math.PI;
//            p3d = Polar3d_Decart3d.convert(new Polar3d(r, latitudeAngle, longitudeAngle));
//            v.setPosition(p3d);
//            v.setColor(Color.RED);
//            v.setRadius(2);
//        }
//        Collection<IEdgeLayout> edges = graphLayout.getEdges();
//        for(IEdgeLayout e: edges) {
//            e.setColor(Color.BLUE);
//            e.update();
//        }
//    }
//}
