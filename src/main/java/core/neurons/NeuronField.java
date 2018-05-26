package core.neurons;

import core.exceptions.InputParamException;
import core.exceptions.SetDataException;

/**
 * Created by anonymous on 13.02.2018.
 */
public class NeuronField {
    private int xSize;
    private int ySize;
    private int zSize;

    private Neuron neurons[][][];

    public NeuronField(int xSize, int ySize, int zSize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
        neurons = new Neuron[xSize][ySize][zSize];
    }

    public NeuronField setNeuron(int x, int y, int z, Neuron neuron){
        if(x>=this.xSize || y>=this.ySize || z>this.zSize){
            throw new InputParamException("Wrong x,y,z");
        }
        if(neurons[x][y][z] == null ){
            neurons[x][y][z] = neuron;
        }else{
            throw new SetDataException("It's possible add neuron only one time in 3dMatrix");
        }

        return this;
    }
}
