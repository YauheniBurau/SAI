package core.application.neurons;

import java.util.HashSet;

/**
 * Created by anonymous on 13.02.2019.
 */
public class Akson implements IAkson{
    private byte stateSignal; // if bit mask its combination of current state of dendrite
    private byte controlSignal; // if bit mask its combination of 8 signals
    private byte strengthSignal; // -128..+127
    private byte valueSignal; // -128..+127

    private HashSet<IDendrite> dendrites = new HashSet<>();
    private HashSet<INeuron> neurons = new HashSet<>();

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
