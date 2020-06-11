package removeLater;

import graph.AbstractCluster;

public class ClusterDataBytes extends AbstractCluster {
    private byte[] value;

    private ClusterDataBytes(byte[] value) {
        this.value = value;
    }

    public void setData(byte[] data) {
        this.value = data;
    }

    public byte[] getData() {
        return value;
    }

}
