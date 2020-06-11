package process;

import graph.ClusterSet;
import graph.ClusterFIFO;
import graph.ICluster;

public class ClusterSets {

    /**
     * merge fifo clusters into ClusterSet and avoid duplicated clusters
     * @param cls1
     * @param clusterFifo
     * @return
     */
    public static ClusterSet merge(ClusterSet cls1, ClusterFIFO clusterFifo) {
        boolean match;
        for (ICluster clPattern2 : clusterFifo) {
            match = false;
            for (ICluster clPattern1 : cls1.subClustersToFIFO()) {
                if (CompareClusters.byAll(clPattern1, clPattern2)) {
                    match = true;
                    break;
                }
            }
            if (match == false) {
                cls1.addSubCluster(clPattern2);
            }
        }
        return cls1;
    }

}
