package graph;

import com.orientechnologies.orient.core.record.OVertex;

public class Cluster extends AbstractCluster {
    private ICluster last = null;

    public Cluster(OVertex vertex) {
        this.value = vertex;
    }

    public void append(ICluster cluster){
        if(last!=null && cluster!=null){
            EdgePrevNext e = new EdgePrevNext(last, cluster);
            this.addEdge(e);
        }
        last = cluster;
        this.addCluster(cluster);
    }

}
