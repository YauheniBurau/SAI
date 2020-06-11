package core.application.cluster;

import java.nio.charset.StandardCharsets;

public class ClusterAscii extends Cluster {

    public ClusterAscii(String ch) {
        this.type = false; // 0(false) - class(simple data), 1(true) - link
        this.data = ch.getBytes(StandardCharsets.US_ASCII);
    }


}
