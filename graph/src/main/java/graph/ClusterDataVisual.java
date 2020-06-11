package graph;

public class ClusterDataVisual extends AbstractCluster {
    private Visual value;

    public ClusterDataVisual(Visual value) {
        this.value = value;
    }

    public void setData(Visual value) {
        this.value = value;
    }

    public Visual getData() {
        return value;
    }

}
