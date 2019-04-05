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
    public boolean isProcessed = false;

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public abstract Boolean onProcess();

    public IParam getParam(Integer key) {
        return this.params.get(key);
    }

    public LinkedList<Param> getParams() {
        return this.params;
    }

    public Param addParam(Param value) {
        this.params.add(value);
        return value;
    }

    public Data getInput(Integer key) {
        return this.inputs.get(key);
    }

    public LinkedList<Data> getInputs() {
        return this.inputs;
    }

    public Data addInput(Data value) {
        this.inputs.add(value);
        return value;
    }

    public Data getOutput(Integer key) {
        return this.outputs.get(key);
    }

    public LinkedList<Data> getOutputs() {
        return this.outputs;
    }

    public Data addOutput(Data value) {
        this.outputs.add(value);
        return value;
    }

    /**
     * only change flag of algorithm
     * @param processed
     */
    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }
}
