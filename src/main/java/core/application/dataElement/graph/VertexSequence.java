package core.application.dataElement.graph;

import java.util.LinkedList;

/**
 * Created by anonymous on 03.11.2018.
 */
public class VertexSequence<T> extends AbstractVertex {
    private LinkedList<T> sequences = new LinkedList<>();

    public VertexSequence() {

    }

    public VertexSequence(LinkedList<T> sequences) {
        this.sequences = sequences;
    }

    public LinkedList<T> getSequences() {
        return sequences;
    }

    public void setSequences(LinkedList<T> sequences) {
        this.sequences = sequences;
    }


    public boolean addElement(T element) {
        return this.sequences.add(element);
    }

    public boolean removeElement(T element) {
        return this.sequences.remove(element);
    }

}
