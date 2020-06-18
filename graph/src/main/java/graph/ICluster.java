package graph;

import com.orientechnologies.orient.core.record.OVertex;

import java.util.Set;

public interface ICluster {

    void addCluster(ICluster cl);
    void addEdge(IEdge e);
    OVertex getValue();
    Set<ICluster> getClusters();
    Set<IEdge> getEdges();

}
