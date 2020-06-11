package core.application.clusterGraph;

import core.application.cluster.Cluster;
import core.application.cluster.ICluster;

import java.util.TreeMap;

public class ClusterGraph {
    private int clusterCounter = Integer.MIN_VALUE;
    private int id = 0; // unique long id for Graph
    private String sId = ""; // unique string id for Graph
    private Cluster clusterRoot;
    private TreeMap<Integer, Cluster> clusters = new TreeMap<>();

    public ClusterGraph(int id, String sId) {
        this.setId(id);
        this.setsId(sId);
        this.clusterRoot = Cluster.createClusterClass(askClusterCounter(), null, (byte)0, null, null, null);
    }

    private int getClusterCounter() {
        return clusterCounter;
    }

    public ClusterGraph setClusterCounter(int clusterCounter) {
        this.clusterCounter = clusterCounter;
        return this;
    }

    public int askClusterCounter() {
        this.clusterCounter +=1;
        return this.clusterCounter;
    }

    public int getId() {
        return id;
    }

    public ClusterGraph setId(int id) {
        this.id = id;
        return this;
    }

    public String getsId() {
        return sId;
    }

    public ClusterGraph setsId(String sId) {
        this.sId = sId;
        return this;
    }

    public Cluster getClusterRoot() {
        return clusterRoot;
    }

    public void addCluster(ICluster cluster, byte level, int frequency, ICluster parent, ICluster prevSet, ICluster nextSet, ICluster prev, ICluster next) {
        cluster.setId( this.askClusterCounter() );
        cluster.setFrequency( frequency );
        cluster.setLevel( level );
        cluster.setParent( parent );
        cluster.setPrevSet( prevSet); // link to the previous cluster in group
        cluster.setNextSet( nextSet ); // link to the next cluster in group
        cluster.setPrev( prev ); // link to the previous cluster in sequence
        cluster.setNext( next ); // link to the next cluster in sequence
    }

    /**
     * for testing
     * @param chars
     * @return
     */
    public Cluster writeRawData(char[] chars){
        // insert empty class cluster
// TODO: or remove
//        Cluster rawDataCluster = Cluster.createClusterClass(
//                askClusterCounter(), getClusterRoot(), (byte) 1, null, getClusterRoot(), getClusterRoot().getNext() );
//        if(getClusterRoot().getNext()!=null){
//            getClusterRoot().getNext().setPrev(rawDataCluster);
//        }
//        getClusterRoot().setNext(rawDataCluster);
//        // fill cluster with char data
//        Cluster curr, next;
//        curr = rawDataCluster;
//        for (char c: chars) {
//            next = Cluster.createClusterClass(askClusterCounter(), rawDataCluster, (byte) 2, new byte[]{(byte) c}, curr, null);
//            curr.setNext(next);
//            curr = next;
//        }
//        // result
//        return rawDataCluster;
        return null;
    }

}