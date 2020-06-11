package core.application.graph;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Edge<T> implements IEdge<T>, Externalizable {
    private static int counterId = 0;
    private int id;
    private int uId; // for load edge from file
    private int vId; // for load edge from file
    private T value;
    private IVertex vertexU;
    private IVertex vertexV;

    public Edge(){

    }

    public Edge(T value) {
        this.id = counterId;
        Edge.counterId+=1;
        this.value = value;
    }

    public int geteId() {
        return id;
    }

    public void seteId(int id) {
        this.id = id;
    }

    public int getuId() {
        return uId;
    }

    public Edge setuId(int uId) {
        this.uId = uId;
        return this;
    }

    public int getvId() {
        return vId;
    }

    public Edge setvId(int vId) {
        this.vId = vId;
        return this;
    }

    public T getValue() {
        return value;
    }

    public Edge setValue(T value) {
        this.value = value;
        return this;
    }

    public IVertex getVertexU() {
        return vertexU;
    }

    public Edge setVertexU(IVertex vertexU) {
        this.vertexU = vertexU;
        return this;
    }

    public IVertex getVertexV() {
        return vertexV;
    }

    public Edge setVertexV(IVertex vertexV) {
        this.vertexV = vertexV;
        return this;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeInt(vertexU.getvId());
        out.writeInt(vertexV.getvId());
        out.writeObject(value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        seteId(in.readInt());
        setuId(in.readInt());
        setvId(in.readInt());
        setValue((T)in.readObject());
    }

}