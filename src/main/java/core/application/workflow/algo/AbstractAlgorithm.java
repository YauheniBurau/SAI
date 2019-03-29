package core.application.workflow.algo;

import core.application.workflow.data.IData;
import core.application.workflow.param.IParam;

import java.lang.annotation.Inherited;
import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public abstract class AbstractAlgorithm implements IAlgorithm {
    private String name = "undefined";
    private LinkedList<IParam> params = new LinkedList<>();
    private LinkedList<IData> inputs = new LinkedList<>();
    private LinkedList<IData> outputs = new LinkedList<>();

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
    public LinkedList<IParam> getParams() {
        return this.params;
    }

    @Override
    public void addParam(IParam value) {
        this.params.add(value);
    }

    @Override
    public IData getInput(Integer key) {
        return this.inputs.get(key);
    }

    @Override
    public LinkedList<IData> getInputs() {
        return this.inputs;
    }

    @Override
    public void addInput(IData value) {
        this.inputs.add(value);
    }

    @Override
    public IData getOutput(Integer key) {
        return this.outputs.get(key);
    }

    @Override
    public LinkedList<IData> getOutputs() {
        return this.outputs;
    }

    @Override
    public void addOutput(IData value) {
        this.outputs.add(value);
    }

}
