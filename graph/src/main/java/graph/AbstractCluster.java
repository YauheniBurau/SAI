package graph;

import com.orientechnologies.orient.core.record.OVertex;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractCluster implements ICluster{
    protected OVertex value;
    protected Set<ICluster> clusters = null;
    protected Set<IEdge> edges = null;

    @Override
    public void addCluster(ICluster cl){
        if(this.clusters ==null){
            this.clusters = new HashSet<>();
        }
        this.clusters.add(cl);
    }

    @Override
    public void addEdge(IEdge e){
        if(this.edges==null){
            this.edges = new HashSet<>();
        }
        this.edges.add(e);
    }

    @Override
    public OVertex getValue() {
        return value;
    }

    @Override
    public Set<ICluster> getClusters() {
        return clusters;
    }

    @Override
    public Set<IEdge> getEdges() {
        return edges;
    }

}
