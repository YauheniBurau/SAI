package graph;

/**
 * class for base simple and complicated operations between clusters
 */
public class Clusters {

    /**
     * clusterSource will be connected after clusterDestination
     * @param clusterSource
     * @param clusterDestination
     * @return
     */
    public static boolean insertAfter(ICluster clusterSource, ICluster clusterDestination) {
        boolean result = true;

        return result;
    }

    /**
     * clusterSource will be connected befor clusterDestination
     * prevClusters -> clusterDestination
     * result: prevClusters -> clusterSource -> clusterDestination
     * @param clusterSource
     * @param clusterDestination
     * @return
     */
    public static boolean insertBefore(ICluster clusterSource, ICluster clusterDestination) {
        boolean result = true;
        ICluster cl;
        ICluster p = clusterDestination.getParent();
        p.addSubCluster(clusterSource);
        ClusterFIFO clusterFifo = clusterDestination.prevsToFIFO();
        while(clusterFifo.size()>0) {
            cl = clusterFifo.pull();
            Clusters.disconnect(cl, clusterDestination);
            Clusters.connect(cl, clusterSource);
        }
        Clusters.connect(clusterSource, clusterDestination);
        return result;
    }

    /**
     * clusterSource will be connected like:
     * inputs of clusterSource are connected to outputs of clusterStart
     * outputs of clusterSource are connected to inputs of clusterEnd
     * @param clusterSource
     * @param clusterStart
     * @param clusterEnd
     * @return
     */
    public static boolean insertParallel(ICluster clusterSource, ICluster clusterStart, ICluster clusterEnd) {
        boolean result = true;

        return result;
    }

    /**
     * clusterSource will be connected like:
     * inputs of clusterSource are connected to outputs of clusterStart
     * outputs of clusterSource are connected to inputs of clusterEnd
     * @param clusterStart
     * @param clusterEnd
     * @return
     */
    public static ICluster copyBetween(ICluster clusterStart, ICluster clusterEnd) {
        ICluster cluster = null;

        return cluster;
    }

    /**
     * connect to cluster. nexts from "cl1" are connected to prevs from "cl2"
     * @param cl1
     * @param cl2
     */
    public static void connect(ICluster cl1, ICluster cl2){
        cl1.addNext(cl2);
        cl2.addPrev(cl1);
    }

    /**
     * disconnect two clusters. nexts of "cl1" are disconnected from prevs of "cl2"
     * @param cl1
     * @param cl2
     */
    public static void disconnect(ICluster cl1, ICluster cl2){
        cl1.removeNext(cl2);
        cl2.removePrev(cl1);
    }


    /**
     * Cluster mustBe clusterSequence (its like Cluster Pattern, Cluster Tree)
     * if cluster prevs connections == 0 then close by ClusterStart
     * if cluster nexts connections == 0 then close by ClusterEnd
     * and also put close clusters into the same Parent Cluster where "cl"
     * @param clSeq
     */
    public static void closeByClusterStartAndClusterEnd(ICluster clSeq){
        ClusterStart clStart;
        ClusterEnd clEnd;
        ClusterFIFO clusterFifo;
        ICluster cl;
        if(clSeq.getClass()==ClusterSequence.class ){
            clusterFifo = clSeq.subClustersToFIFO();
            while(clusterFifo.size()>0){
                cl = clusterFifo.pull();
                if(cl.getPrevs().size()==0){
                    clStart = new ClusterStart();
                    Clusters.connect(clStart, cl);
                    cl.getParent().addSubCluster(clStart);
                }
                if(cl.getNexts().size()==0){
                    clEnd = new ClusterEnd();
                    Clusters.connect(cl, clEnd);
                    cl.getParent().addSubCluster(clEnd);
                }
            }
        }
    }

    /**
     * it finds only first subCluster of type ClusterStart
     * @param cl
     * @return
     */
    public static ClusterStart selectFirstClusterStart(ICluster cl){
        for( ICluster c: cl.getSubClusters() ) {
            if(c.getClass()==ClusterStart.class){
                return (ClusterStart) c;
            }
        }
        return null;
    }

    /**
     * it finds only first subCluster of type ClusterEnd
     * @param cl
     * @return
     */
    public static ClusterEnd selectFirstClusterEnd(ICluster cl){
        for( ICluster c: cl.getSubClusters() ) {
            if(c.getClass()==ClusterEnd.class){
                return (ClusterEnd) c;
            }
        }
        return null;
    }

}
