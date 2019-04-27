package core.application.graph;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;

public class GraphModel extends Graph<IVertex, IEdge> implements Externalizable {

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.getVertexCounter());
        out.writeInt(this.getEdgeCounter());
        out.writeInt(this.getId());
        out.writeUTF(this.getsId());
        out.writeInt(this.getVertexes().size());
        for (IVertex v: this.getVertexes()) {
            out.writeObject(v);
        }
        out.writeInt(this.getEdges().size());
        for (IEdge e: this.getEdges()) {
            out.writeObject(e);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int size;
        IVertex v1, v2, v;
        IEdge e;
        HashMap<Integer, IVertex> map = new HashMap<>();
        setVertexCounter(in.readInt());
        setEdgeCounter(in.readInt());
        setId(in.readInt());
        setsId(in.readUTF());
        size = in.readInt();
        for (int i = 0; i < size; i++) {
            v = (IVertex)in.readObject();
            this.addVertex( v );
            map.put(v.getId(), v);
        }
        size = in.readInt();
        for (int i = 0; i < size; i++) {
            e = (IEdge)in.readObject();
            addEdge(e);
            v1 = map.get(e.getuId());
            v2 = map.get(e.getvId());
            v1.addEdge(e);
            v2.addEdge(e);
            e.setVertexU(v1);
            e.setVertexV(v2);
        }
    }

}
