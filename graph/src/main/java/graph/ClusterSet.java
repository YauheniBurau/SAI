package graph;

public class ClusterSet extends AbstractCluster {

    public ClusterSet() {
        super();
    }

    public ClusterSet(ClusterFIFO clusters) {
        super();
        for (ICluster cl: clusters) {
            this.subClusters.add(cl);
        }
    }


    @Override
    public String toString() {
        String str = "ClusterSet{ clusters=";
        for (ICluster cl: this.getSubClusters()) {
            if(cl.getClass()==ClusterDataChar.class) {
                str += cl.toString() + " | ";
            }
        }
        str+= '}';
        return str;
    }

}
