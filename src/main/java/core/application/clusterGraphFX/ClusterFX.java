package core.application.clusterGraphFX;

import core.application.cluster.Cluster;
import javafx.geometry.Point3D;
import javafx.scene.shape.Sphere;

public class ClusterFX extends Sphere {
    private Cluster cluster;
    private EdgeFX edgeParent;
    private EdgeFX edgePrevSet; // link to the edgeFX previous cluster in group
    private EdgeFX edgeNextSet; // link to the edgeFX next cluster in group
    private EdgeFX edgePrev; // link to the edgeFX previous cluster in sequence
    private EdgeFX edgeNext; // link to the edgeFX next cluster in sequence

    public ClusterFX(Cluster cluster, int radius, int divisions){
        super(radius, divisions);
        this.cluster = cluster;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public Point3D getPosition() {
        return new Point3D(this.getTranslateX(), this.getTranslateY(), this.getTranslateZ());
    }

}
