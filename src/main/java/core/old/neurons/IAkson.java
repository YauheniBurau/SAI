package core.old.neurons;

/**
 * Created by anonymous on 13.02.2019.
 */
public interface IAkson {
    void addNeuron(INeuron value);
    boolean removeNeuron(INeuron value);
    boolean containsNeuron(INeuron value);

    void addDendrite(IDendrite value);
    boolean removeDendrite(IDendrite value);
    boolean containsDendrite(IDendrite value);

}
