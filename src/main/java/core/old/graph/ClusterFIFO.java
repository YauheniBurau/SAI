package core.old.graph;

/**
 * AI structure for temporally contains clusters than are needed to be processed
 * for finding weak clusters, creating new weak clusters, moving from weak to strong clusters
 */
//public class ClusterFIFO extends AbstractCluster implements Iterable<ICluster> {
//    private LinkedList<ICluster> fifo = new LinkedList<>();
//
//    public ICluster pull(){
//        return this.fifo.removeFirst();
//    }
//
//    public void push(ICluster cluster){
//        this.fifo.addLast(cluster);
//    }
//
//    public int size(){
//        return this.fifo.size();
//    }
//
//    public boolean contains(ICluster cluster){
//        return fifo.contains(cluster);
//    }
//
//    public boolean remove(ICluster cluster){
//        return fifo.remove(cluster);
//    }
//
//    public ClusterFIFO remove(ClusterFIFO clusters){
//        for (ICluster cl: clusters) {
//            this.remove(cl);
//        }
//        return this;
//    }
//
//    public ClusterFIFO copy(){
//        ClusterFIFO clusterFifoCopy = new ClusterFIFO();
//        for(ICluster cl : this){
//            clusterFifoCopy.push(cl);
//        }
//        return clusterFifoCopy;
//    }
//
//    @Override
//    public Iterator<ICluster> iterator() {
//        return fifo.iterator();
//    }
//
//}
