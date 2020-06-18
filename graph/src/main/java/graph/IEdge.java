package graph;

import com.orientechnologies.orient.core.record.OEdge;

public interface IEdge {

    ICluster getPrev();
    void setPrev(ICluster prev);
    ICluster getNext();
    void setNext(ICluster next);
    OEdge getValue();
    void setValue(OEdge value);

}
