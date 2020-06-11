package graph;

public class ClusterDataChar extends AbstractCluster {
    private Character value;

    public ClusterDataChar(Character value) {
        this.value = value;
    }

    public void setData(Character value) {
        this.value = value;
    }

    public Character getData() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
