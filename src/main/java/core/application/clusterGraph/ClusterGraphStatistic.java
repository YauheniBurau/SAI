package core.application.clusterGraph;

/**
 * count statistic of clusters in graph
 */
public class ClusterGraphStatistic {
    public ClusterGraph clusterGraph;
    public int N_CLUSTER_DATA = 0;
    public int N_CLUSTER_COPY = 0;
    public int N_CLUSTER_GROUP = 0;

    public ClusterGraphStatistic() {

    }

    // TODO: implement BSD and gathering information
    public static ClusterGraphStatistic countStatistic(ClusterGraph value){
        ClusterGraphStatistic cgs = new ClusterGraphStatistic();
        cgs.clusterGraph = value;
//        for (Cluster c: value.getClusters()) {
//            switch( c.type ){
//                case CLUSTER_CLASS: cgs.N_CLUSTER_DATA+=1; break;
//                case CLUSTER_COPY: cgs.N_CLUSTER_COPY+=1; break;
//                case CLUSTER_GROUP: cgs.N_CLUSTER_GROUP+=1; break;
//            }
//        }
        return cgs;
    }

    @Override
    public String toString() {
        return "===== ClusterGraph =====\n"+
                "Id: " + clusterGraph.getId() +
                "; sId: " + clusterGraph.getsId() +
                "; N_CLUSTER_DATA: " + N_CLUSTER_DATA +
                "; N_CLUSTER_COPY: " + N_CLUSTER_COPY +
                "; N_CLUSTER_GROUP: " + N_CLUSTER_GROUP;
    }

}
