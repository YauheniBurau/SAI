package core.old.graph;

import java.util.HashSet;

/**
 * Created by anonymous on 17.11.2018.
 */
public class Vertex<TValue extends IVertexValue> implements IVertex {
    private static long eId = Long.MIN_VALUE; // current enumerator value for generation next unique Id
    private long uId; // unique id
    private TValue value = null;
    private Vertex parent = null;
    private HashSet<Vertex> childs = new HashSet<>();

    public Vertex() {
        this.uId = Vertex.generate_uid();
    }

    public Vertex(TValue value) {
        this.uId = Vertex.generate_uid();
        this.value = value;
    }

    private static long generate_uid(){
        return Vertex.eId+=1;
    }

    public long getuId() {
        return uId;
    }

    public TValue getValue() {
        return value;
    }

    public void setValue(TValue value) {
        this.value = value;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public HashSet<Vertex> getChilds() {
        return childs;
    }

    public void setChilds(HashSet<Vertex> childs) {
        this.childs = childs;
    }

    public boolean add(Vertex e) {
        return this.childs.add(e);
    }

    public boolean remove(Vertex e) {
        return this.childs.remove(e);
    }

    @Override
    public Boolean toHumanFile(String path) {
        Boolean result = value.toHumanFile(this, path);
        return result;
    }

    @Override
    public Boolean toDataFile(String path) {
        Boolean result = value.toDataFile(this, path);
        return result;
    }
}
