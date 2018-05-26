package core.matrix;


import core.neurons.NeuronParamEnum;

/**
 * Created by anonymous on 09.02.2018.
 */
public class NeuronParam {
    private NeuronParamEnum type;
    private byte bytes[];

    public NeuronParamEnum getType() {
        return type;
    }

    public int getSize() {
        return bytes.length;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public NeuronParam(NeuronParamEnum type, byte[] bytes) {
        this.type = type;
        this.bytes = bytes;
    }

}
