package core.application.graphView;

import core.application.data.Decart3d;
import core.application.data.Polar3d;
import core.application.dataConverters.Polar3d_Decart3d;
import core.application.graph.Graph;
import javafx.geometry.Point3D;

import java.util.Vector;

/**
 * count layout position of graphFX vertexes and edges accordingly
 */
public class GraphLayoutDefault extends AbstractGraphLayout {
    private double sphereRadius = 1000; // all elements will be randomly positioned in sphere of radius

    public double getSphereRadius() {
        return sphereRadius;
    }

    public GraphLayoutDefault setSphereRadius(double sphereRadius) {
        this.sphereRadius = sphereRadius;
        return this;
    }

    /**
     * convert all coordinates of graphFX vertexeFX and edgeFX accordingly random algorithm
     * @param graphFX
     */
    public void process(Graph<IVertexFX, IEdgeFX> graphFX){
        double r;
        double latitudeAngle;
        double longitudeAngle;
        Vector<IVertexFX> vertexes = graphFX.getVertexes();
        Decart3d p3d;
        for(IVertexFX v: vertexes) {
            r = Math.random()*this.sphereRadius;
            latitudeAngle = Math.random()*2*Math.PI;
            longitudeAngle = Math.random()*2*Math.PI;
            p3d = Polar3d_Decart3d.convert(new Polar3d(r, latitudeAngle, longitudeAngle));
            v.setPosition( new Point3D(p3d.x, p3d.y, p3d.z) );
        }
        Vector<IEdgeFX> edges = graphFX.getEdges();
        for(IEdgeFX e: edges) {
            e.update();
        }
    }
}
