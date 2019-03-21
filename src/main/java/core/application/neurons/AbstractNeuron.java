package core.application.neurons;

import java.util.HashSet;

/**
 * Created by anonymous on 13.02.2019.
 */
public abstract class AbstractNeuron implements INeuron {
    private HashSet<IDendrite> dendrites = new HashSet<>();
    private HashSet<IAkson> aksons = new HashSet<>();

    /**
     * add Akson
     * @param value
     */
    @Override
    public void addAkson(IAkson value) {
        this.aksons.add(value);
    }

    /**
     * remove Akson
     * @param value
     */
    @Override
    public boolean removeAkson(IAkson value) {
        return this.aksons.remove(value);
    }

    /**
     * contains Akson
     * @param value
     */
    @Override
    public boolean containsAkson(IAkson value) {
        return this.aksons.contains(value);
    }

    /**
     * add Dendrite
     * @param value
     */
    @Override
    public void addDendrite(IDendrite value) {
        this.dendrites.add(value);
    }

    /**
     * remove Dendrite
     * @param value
     */
    @Override
    public boolean removeDendrite(IDendrite value) {
        return this.dendrites.remove(value);
    }

    /**
     * contains Dendrite
     * @param value
     */
    @Override
    public boolean containsDendrite(IDendrite value) {
        return this.dendrites.contains(value);
    }


}
