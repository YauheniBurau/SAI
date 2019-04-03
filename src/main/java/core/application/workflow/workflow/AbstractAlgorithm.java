package core.application.workflow.workflow;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public abstract class AbstractAlgorithm implements IAlgorithm, Serializable {
    private String name = "undefined";
    private LinkedList<Param> params = new LinkedList<>();
    private LinkedList<Data> inputs = new LinkedList<>();
    private LinkedList<Data> outputs = new LinkedList<>();

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public abstract Boolean process();

    public IParam getParam(Integer key) {
        return this.params.get(key);
    }

    @Override
    public LinkedList<Param> getParams() {
        return this.params;
    }

    @Override
    public void addParam(Param value) {
        this.params.add(value);
    }

    @Override
    public Data getInput(Integer key) {
        return this.inputs.get(key);
    }

    @Override
    public LinkedList<Data> getInputs() {
        return this.inputs;
    }

    @Override
    public void addInput(Data value) {
        this.inputs.add(value);
    }

    @Override
    public Data getOutput(Integer key) {
        return this.outputs.get(key);
    }

    @Override
    public LinkedList<Data> getOutputs() {
        return this.outputs;
    }

    @Override
    public void addOutput(Data value) {
        this.outputs.add(value);
    }

}
