package core.application.cluster;

/**
 * for effective building of sequence of clusters
 */
public class ClusterSequence {
    public ICluster first = null;
    public ICluster last = null;

    /**
     * add new cluster to sequence
     * cluster already must have filled all attributes
     * @param value
     */
    public void addCluster(ICluster value){
        if(first == null){
            this.first = value;
            this.last = value;
        }else{
            this.last.setNextSet(value);
            this.last.setNext(value);
            value.setPrevSet(last);
            value.setPrev(last);
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
