package graph;

import com.orientechnologies.orient.core.record.OVertex;

public class ClusterLink extends AbstractCluster {

    public ClusterLink(OVertex vertex) {
        this.value = vertex;
    }

}
