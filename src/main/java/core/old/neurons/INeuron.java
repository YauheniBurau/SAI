package core.old.neurons;

/**
 * Created by anonymous on 13.02.2019.
 */
public interface INeuron {
    void addAkson(IAkson value);
    boolean removeAkson(IAkson value);
    boolean containsAkson(IAkson value);

    void addDendrite(IDendrite value);
    boolean removeDendrite(IDendrite value);
    boolean containsDendrite(IDendrite value);

    void calculateNeuron();

}
