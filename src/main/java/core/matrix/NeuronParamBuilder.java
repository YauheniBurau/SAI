package core.matrix;

import core.matrix.NeuronParam;
import core.neurons.NeuronParamEnum;

/**
 * Created by anonymous on 10.02.2018.
 */
public class NeuronParamBuilder {

    public static NeuronParam newDefault(){
        byte bytes[] = {0,0,0,0};
        NeuronParam p = new NeuronParam(NeuronParamEnum.DEFAULT, bytes);
        return p;
    }
}
