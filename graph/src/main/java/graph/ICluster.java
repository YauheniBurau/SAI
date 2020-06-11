package graph;

import java.util.Date;
import java.util.HashSet;

public interface ICluster {
    void setTime(Date time);
    Date getTime();

    void addPrev(ICluster cluster);
    HashSet<ICluster> getPrevs();
    boolean removePrev(ICluster cl);
    boolean containsPrev(ICluster cl);
    void removeAllPrevs();

    void addNext(ICluster cluster);
    HashSet<ICluster> getNexts();
    boolean removeNext(ICluster cl);
    boolean containsNext(ICluster cl);

    HashSet<ICluster> getSubClusters();
    boolean addSubCluster(ICluster cluster);
    boolean removeSubCluster(ICluster cluster);
    boolean containsSubCluster(ICluster cluster);

    HashSet<ClusterLink> getCopies();
    void setCopies(HashSet<ClusterLink> copies);
    void addCopy(ClusterLink copyLink);
    void removeCopy(ClusterLink copy);

    void addClusterSet(ClusterSet clusterSet);
    boolean removeClusterSet(ClusterSet clusterSet);

    ICluster getParent();
    void setParent(ICluster parent);

    ClusterFIFO subClustersToFIFO();
    ClusterFIFO copiesToFIFO();
    ClusterFIFO prevsToFIFO();
    ClusterFIFO nextsToFIFO();

    /**
     * create ClusterLink for current Cluster
     * @return
     */
    ClusterLink createClusterLink();

    /**
     * count how much subClusters in current Cluster
     */
    int countSubClusters();

    /**
     * count how much copies of current Cluster
     */
    int countCopies();

    /**
     * count how much prevs clusters connected to current Cluster
     */
    int countPrevs();

    /**
     * count how much nexts clusters connected to current Cluster
     */
    int countNexts();

}
