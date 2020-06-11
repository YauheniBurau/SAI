package graph;

public class ClusterDataSound extends AbstractCluster {
    private Sound value;

    public ClusterDataSound(Sound value) {
        this.value = value;
    }

    public void setData(Sound value) {
        this.value = value;
    }

    public Sound getData() {
        return value;
    }

}
