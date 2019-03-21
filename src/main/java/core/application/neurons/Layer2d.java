package core.application.neurons;

/**
 * Created by anonymous on 14.02.2019.
 */
public class Layer2d extends AbstractLayer {


    @Override
    public void calculateLayerNeurons() {
        // calculate neuron state and values

        // set layer as "counted"
        this.isCounted = true;
    }

}
