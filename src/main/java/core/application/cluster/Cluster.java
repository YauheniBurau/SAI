package core.application.cluster;

/**
 * basic element of Graph for storing any data and links between data and links
 */
public class Cluster implements ICluster {
    private long id;
    private int frequency = Integer.MIN_VALUE;
    protected boolean type; // 0(false) - class(simple data), 1(true) - link
    private byte level = 0; // by default all clusters level is 0
    protected byte[] data = null; // by default cluster is linkCluster
    private ICluster parent;
    private ICluster prevSet; // link to the previous cluster in group
    private ICluster nextSet; // link to the next cluster in group
    private ICluster prev; // link to the previous cluster in sequence
    private ICluster next; // link to the next cluster in sequence


    /**
     * cluster storing data as raw data with type of stored data
     * @return
     */
    public int getSize() {
        return (data==null? 0: data.length);
    }

    /**
     * set size of raw data array
     * @param size
     */
    public void setSize(int size) {
        data = new byte[size];
    }

    /**
     * return raw data array
     * @return
     */
    public byte[] getData() {
        return data;
    }

    /**
     * setup raw data array
     * @param data
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public ICluster getParent() {
        return parent;
    }

    public void setParent(ICluster parent) {
        this.parent = parent;
    }

    public ICluster getPrev() {
        return prev;
    }

    public void setPrev(ICluster prev) {
        this.prev = prev;
    }

    public ICluster getNext() {
        return next;
    }

    public void setNext(ICluster next) {
        this.next = next;
    }

    public ICluster getPrevSet() {
        return prevSet;
    }

    public void setPrevSet(ICluster prevSet) {
        this.prevSet = prevSet;
    }

    public ICluster getNextSet() {
        return nextSet;
    }

    public void setNextSet(ICluster nextSet) {
        this.nextSet = nextSet;
    }

    /**
     * any data - is base cluster with data, if data=0 then its cluster classificator group without data
     * @param id
     * @param clusterParent
     * @param level
     * @param data
     * @param prev
     * @return
     */
    public static Cluster createClusterClass(int id, Cluster clusterParent, byte level, byte[] data, Cluster prev, Cluster next){
        Cluster cl = new Cluster();
        cl.id = id;
        cl.frequency = Integer.MIN_VALUE;
        cl.type = CLUSTER_CLASS;
        cl.level = level; // by default all clusters level is 0
        cl.data = data;
        cl.parent = clusterParent;
        cl.prev = prev;
        cl.next = next;
        return cl;
    }

    public static Cluster createClusterLink(int id, Cluster cluster, byte level){
        Cluster cl = new Cluster();
        cl.id = id;
        cl.frequency = Integer.MIN_VALUE;
        cl.type = CLUSTER_LINK;
        cl.level = level; // by default all clusters level is 0
        cl.data = null;
        cl.parent = cluster;
        cl.prev = null;
        cl.next = null;
        return cl;
    }

}
