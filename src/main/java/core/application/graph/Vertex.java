package core.application.graph;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Vector;

public class Vertex<T> implements IVertex<T>, Externalizable {
    private int id;
    private T value;
    private Vector<IEdge> edges = new Vector<>();

    public Vertex(){

    }

    public Vertex(T value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Vertex setId(int id) {
        this.id = id;
        return this;
    }

    public T getValue() {
        return value;
    }

    public Vertex setValue(T value) {
        this.value = value;
        return this;
    }

    public Vector<IEdge> getEdges() {
        return this.edges;
    }

    public boolean addEdge(IEdge e) {
        return this.edges.add(e);
    }

    public boolean removeEdge(IEdge e) {
        return this.edges.remove(e);
    }

    public boolean containsEdge(IEdge e) {
        return this.edges.contains(e);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setId(in.readInt());
        setValue((T)in.readObject());
    }
}
