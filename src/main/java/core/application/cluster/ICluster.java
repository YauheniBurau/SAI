package core.application.cluster;

public interface ICluster {
    public static final boolean CLUSTER_CLASS = false;
    public static final boolean CLUSTER_LINK = true;

    public int getSize();
    public void setSize(int size);
    public byte[] getData();
    public void setData(byte[] data);
    public long getId();
    public void setId(long id);
    public int getFrequency();
    public void setFrequency(int frequency);
    public boolean getType();
    public void setType(boolean type);
    public byte getLevel();
    public void setLevel(byte level);
    public ICluster getParent();
    public void setParent(ICluster parent);
    public ICluster getPrev();
    public void setPrev(ICluster prev);
    public ICluster getNext();
    public void setNext(ICluster next);

    public ICluster getPrevSet();
    public void setPrevSet(ICluster prev);
    public ICluster getNextSet();
    public void setNextSet(ICluster next);

}
