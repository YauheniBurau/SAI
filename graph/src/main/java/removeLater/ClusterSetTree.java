package removeLater;

import graph.AbstractCluster;
import graph.ICluster;

import java.util.HashSet;

/**
 * implementation must be changed in future
 */
public class ClusterSetTree extends AbstractCluster {

    public ClusterSetTree() {
        super();
    }

    public boolean contains(ICluster cluster){
        return this.containsSubCluster(cluster);
    }

    public boolean add(ICluster cluster){
        return this.addSubCluster(cluster);
    }

    public void remove(ICluster cluster){
        this.removeSubCluster(cluster);
    }

}
