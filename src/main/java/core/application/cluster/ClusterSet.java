package core.application.cluster;

public class ClusterSet {
    public ICluster first = null;
    public ICluster last = null;

    /**
     * add new cluster to set
     * cluster already must have filled all attributes
     * @param value
     */
    public void addCluster(ICluster value){
        if(first == null){
            this.first = value;
            this.last = value;
        }else{
            this.last.setNextSet(value);
            value.setPrevSet(last);
            value.setParent(first);
            this.last = value;
        }
    }

    public ICluster getFirst() {
        return first;
    }

    public ICluster getLast() {
        return last;
    }


}
