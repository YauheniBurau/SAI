package graph;

public class ClusterLink extends AbstractCluster {
    private ICluster cluster;

    public ClusterLink(ICluster cluster){
        this.cluster = cluster;
    }

    public ICluster getCluster() {
        return cluster;
    }
}
