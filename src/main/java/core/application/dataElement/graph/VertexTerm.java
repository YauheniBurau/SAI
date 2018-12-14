package core.application.dataElement.graph;


import java.util.ArrayList;

/**
 * Created by anonymous on 07.05.2018.
 * Intelligence thinking unit
 */
public class VertexTerm extends Vertex {
    private ArrayList<IVertex> vertexes = new ArrayList<IVertex>();
    private ArrayList<IEdge> edges = new ArrayList<IEdge>();

    /**
     * creates empty vertex representing Term
     * Terms are the base elements like Intelligence thinking unit, that must be structured to clusters
     */
    public VertexTerm() {

    }

    public boolean removeEdge(IEdge value){
        // TODO: check and remove edges, that connect removable Vertex to another vertexs
        // some types of vertexes must be connected at list with one another vertex, or deleted if no edges
        return this.edges.remove(value);
    }

    public boolean addEdge(IEdge value){
        return this.edges.add(value);
    }

    public boolean removeVertex(IVertex value){
        // TODO: check and remove edges, that connect removable Vertex to another vertexs
        // Remove vertexes that lost one connection.
        // some types of vertexes must be connected at list with one another vertex, or deleted if no edges
        return this.vertexes.remove(value);
    }

    public boolean addVertex(IVertex value){
        return this.vertexes.add(value);
    }

}
