package core.old.graph;

import java.util.HashSet;

/**
 * Created by anonymous on 02.12.2018.
 */
public final class Graph implements IGraph {
    private static long eId = Long.MIN_VALUE; // current enumerator value for generation next unique Id for Graph
    private long uId; // unique id of Graph

    private HashSet<IVertex> vertexes = new HashSet<>();
    private IVertex rootVertex = null;

    public HashSet<IVertex> getVertexes() {
        return vertexes;
    }

    public void setVertexes(HashSet<IVertex> vertexes) {
        this.vertexes = vertexes;
    }

    public IVertex getRootVertex() {
        return rootVertex;
    }

    public void setRootVertex(IVertex rootVertex) {
        this.rootVertex = rootVertex;
    }

    public boolean add(IVertex E) {
        return this.vertexes.add(E);
    }

    public boolean addAll(HashSet<IVertex> E) {
        return this.vertexes.addAll(E);
    }

    public boolean remove(IVertex E) {
        return this.vertexes.remove(E);
    }

    public boolean contains(IVertex e) {
        return this.vertexes.contains(e);
    }

    /**
     * converts all elements of graph into human readable files with names of uid vertex to HexString
     * @param path
     * @return
     */
    @Override
    public Boolean toHumanFile(String path) {
        Boolean result = true;
        for(IVertex v: this.vertexes){
            System.out.println( v.getClass().toGenericString() );
            result = v.toHumanFile(path);
            // TODO: check for errors and onProcess if error, like log, warning and
        }
        return result;
    }


}
