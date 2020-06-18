package graph;

import com.orientechnologies.orient.core.record.OVertex;

public class ClusterDataVisual extends AbstractCluster {

    public ClusterDataVisual(OVertex vertex) {
        this.value = vertex;
    }
}
