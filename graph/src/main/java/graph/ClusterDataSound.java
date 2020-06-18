package graph;

import com.orientechnologies.orient.core.record.OVertex;

public class ClusterDataSound extends AbstractCluster {

    public ClusterDataSound(OVertex vertex) {
        this.value = vertex;
    }

}
