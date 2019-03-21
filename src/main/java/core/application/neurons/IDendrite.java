package core.application.neurons;

/**
 * Created by anonymous on 13.02.2019.
 */
public interface IDendrite {
    void addAkson(IAkson value);
    boolean removeAkson(IAkson value);
    boolean containsAkson(IAkson value);

    void addNeuron(INeuron value);
    boolean removeNeuron(INeuron value);
    boolean containsNeuron(INeuron value);


}
