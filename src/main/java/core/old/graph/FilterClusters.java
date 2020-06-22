package core.old.graph;

/**
 * When filter FIFO then create new one FIFO contains only clusters passed through conditions
 */
public class FilterClusters {

//    /**
//     * Filter cluster by Cluster class(type)and return FIFO
//     * @param clusterFifo
//     * @param clazz
//     * @return
//     */
//    public static ClusterFIFO byClusterClass(ClusterFIFO clusterFifo, Class<? extends ICluster> clazz){
//        ClusterFIFO selected = new ClusterFIFO();
//        for (ICluster subCl : clusterFifo) {
//            if(subCl.getClass()==clazz){
//                selected.push(subCl);
//            }
//        }
//        return selected;
//    }
//
//    /**
//     * Filter cluster by Parent. clusters must have selected by parent Cluster
//     * @param clusterFifo
//     * @param parent
//     * @return
//     */
//    public static ClusterFIFO byParent(ClusterFIFO clusterFifo, ICluster parent){
//        ClusterFIFO selected = new ClusterFIFO();
//        for (ICluster subCl : clusterFifo) {
//            if(subCl.getParent()==parent){
//                selected.push(subCl);
//            }
//        }
//        return selected;
//    }
//
//    /**
//     * check every FIFO cluster that if clusterType is ClusterLink and then
//     * check fifoCluster.value  == clValue
//     * subCl.value and clValue are the same cluster
//     * @param clusterFifo must contain clusterLink-s
//     * @param clusterLink
//     * @return
//     */
//    public static ClusterFIFO byClusterLinkValue(ClusterFIFO clusterFifo, ICluster clusterLink){
//        ClusterFIFO selected = new ClusterFIFO();
//        if(clusterLink.getClass()==ClusterLink.class){
//            for(ICluster subCl : clusterFifo) {
//                if(CompareClusters.byClusterLinkValue(subCl, clusterLink)){
//                    selected.push(subCl);
//                }
//            }
//        }
//        return selected;
//    }

}