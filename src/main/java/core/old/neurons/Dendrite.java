package core.old.neurons;

import java.util.HashSet;

/**
 * Created by anonymous on 13.02.2019.
 */
public class Dendrite implements IDendrite{
    private byte stateSignal; // if bit mask its combination of current state of dendrite
    private byte controlSignal; // if bit mask its combination of 8 signals
    private byte strengthSignal; // -128..+127
    private byte valueSignal; // -128..+127

    private HashSet<IAkson> aksons = new HashSet<>();
    private HashSet<INeuron> neurons = new HashSet<>();

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
     * add Neuron
     * @param value
     */
    @Override
    public void addNeuron(INeuron value) {
        this.neurons.add(value);
    }

    /**
     * remove Neuron
     * @param value
     */
    @Override
    public boolean removeNeuron(INeuron value) {
        return this.neurons.remove(value);
    }

    /**
     * contains Neuron
     * @param value
     */
    @Override
    public boolean containsNeuron(INeuron value) {
        return this.neurons.contains(value);
    }


}
