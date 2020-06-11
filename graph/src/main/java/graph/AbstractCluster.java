package graph;

import java.util.Date;
import java.util.HashSet;

public abstract class AbstractCluster implements ICluster {
    private Date t;
    private HashSet<ICluster> prevs = new HashSet<>();
    private HashSet<ICluster> nexts = new HashSet<>();
    protected HashSet<ICluster> subClusters = new HashSet<>();
    private HashSet<ClusterLink> copies = new HashSet<>();
    private HashSet<ClusterSet> clusterSets = new HashSet<>();
    private ICluster parent = null;

    public ClusterEnd initStartEnd(){
        ClusterStart start = new ClusterStart();
        ClusterEnd end = new ClusterEnd();
        Clusters.connect(start, end);
        this.addSubCluster(start);
        this.addSubCluster(end);
        return end;
    }

    // TIME
    @Override
    public void setTime(Date time) {
        new RuntimeException("Not implemented");
    }

    @Override
    public Date getTime() {
        new RuntimeException("Not implemented");
        return null;
    }

    // PREVIOUSES
    @Override
    public void addPrev(ICluster cluster) {
        this.prevs.add(cluster);
    }

    @Override
    public HashSet<ICluster> getPrevs() {
        return this.prevs;
    }

    @Override
    public boolean removePrev(ICluster cl){
        return this.prevs.remove(cl);
    }

    @Override
    public void removeAllPrevs(){
        this.prevs = new HashSet<>();
    }

    @Override
    public boolean containsPrev(ICluster cl){
        return this.prevs.contains(cl);
    }

    // NEXTS
    @Override
    public void addNext(ICluster cluster) {
        this.nexts.add(cluster);
    }

    @Override
    public HashSet<ICluster> getNexts() {
        return this.nexts;
    }

    @Override
    public boolean removeNext(ICluster cl){
        return this.nexts.remove(cl);
    }

    @Override
    public boolean containsNext(ICluster cl){
        return this.nexts.contains(cl);
    }

    // SUB CLUSTERS
    // current cluster consists from all that subClusters
    @Override
    public HashSet<ICluster> getSubClusters() {
        return this.subClusters;
    }

    @Override
    public boolean addSubCluster(ICluster cluster) {
        if(this.getClass()==ClusterSet.class){
            cluster.addClusterSet((ClusterSet)this);
            this.subClusters.add(cluster);
        }
        if(this.getClass()==ClusterSequence.class){
            cluster.setParent(this);
            this.subClusters.add(cluster);
        }
        if(this.getClass()==ClusterAnd.class){
            throw new RuntimeException("not implemented");
        }
        if(this.getClass()==ClusterOr.class){
            throw new RuntimeException("not implemented");
        }
        return true;
    }

    @Override
    public boolean removeSubCluster(ICluster cluster) {
        if(this.getClass()==ClusterSet.class){
            this.subClusters.remove(cluster);
            cluster.removeClusterSet((ClusterSet)this);
        }
        if(this.getClass()==ClusterSequence.class){
            cluster.setParent(null);
            this.subClusters.remove(cluster);
        }
        if(this.getClass()==ClusterAnd.class){
            throw new RuntimeException("not implemented");
        }
        if(this.getClass()==ClusterOr.class){
            throw new RuntimeException("not implemented");
        }
        return true;
    }

    @Override
    public boolean containsSubCluster(ICluster cluster){
        return this.subClusters.contains(cluster);
    }

    // COPIES LINKS
    @Override
    public HashSet<ClusterLink> getCopies() {
        return this.copies;
    }

    @Override
    public void setCopies(HashSet<ClusterLink> copies) {
        this.copies = copies;
    }

    @Override
    public void addCopy(ClusterLink copyLink) {
        throw new RuntimeException("not implemented");
    }

    @Override
    public void removeCopy(ClusterLink copy) {
        this.copies.remove(copy);
    }

    // PARENT - CLUSTER SET OR SEQUENCE
    @Override
    public ICluster getParent() {
        return parent;
    }

    @Override
    public void setParent(ICluster parent) {
        this.parent = parent;
    }

    @Override
    public ClusterLink createClusterLink(){
        ClusterLink clL = new ClusterLink(this);
        this.copies.add(clL);
        return clL;
    }

    @Override
    public void addClusterSet(ClusterSet clusterSet) {
        this.clusterSets.add(clusterSet);
    }

    @Override
    public boolean removeClusterSet(ClusterSet clusterSet) {
        return this.clusterSets.remove(clusterSet);
    }

    /**
     * convert subClusters to FIFO
     * @return
     */
    public ClusterFIFO subClustersToFIFO(){
        ClusterFIFO selected = new ClusterFIFO();
        for (ICluster subCl : this.subClusters ) {
            selected.push(subCl);
        }
        return selected;
    }

    /**
     * convert copies to FIFO
     * @return
     */
    public ClusterFIFO copiesToFIFO(){
        ClusterFIFO selected = new ClusterFIFO();
        for (ICluster subCl : this.copies ) {
            selected.push(subCl);
        }
        return selected;
    }

    /**
     * convert prevs to FIFO
     * @return
     */
    public ClusterFIFO prevsToFIFO(){
        ClusterFIFO selected = new ClusterFIFO();
        for (ICluster subCl : this.prevs ) {
            selected.push(subCl);
        }
        return selected;
    }

    /**
     * convert nexts to FIFO
     * @return
     */
    public ClusterFIFO nextsToFIFO(){
        ClusterFIFO selected = new ClusterFIFO();
        for (ICluster subCl : this.nexts ) {
            selected.push(subCl);
        }
        return selected;
    }

    @Override
    public int countSubClusters(){
        return this.subClusters.size();
    }

    @Override
    public int countCopies(){
        return this.copies.size();
    }

    @Override
    public int countPrevs(){
        return this.prevs.size();
    }

    @Override
    public int countNexts(){
        return this.nexts.size();
    }

}