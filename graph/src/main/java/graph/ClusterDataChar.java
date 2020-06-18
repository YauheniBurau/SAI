package graph;

import com.orientechnologies.orient.core.record.OVertex;

public class ClusterDataChar extends AbstractCluster {

    public ClusterDataChar(OVertex vertex) {
        this.value = vertex;
    }

}
