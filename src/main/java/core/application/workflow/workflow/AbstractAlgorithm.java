package core.application.workflow.workflow;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public abstract class AbstractAlgorithm implements IAlgorithm, Serializable {
    private AbstractNode node;
    private LinkedList<Param> params = new LinkedList<>();
    private LinkedList<Data> inputs = new LinkedList<>();
    private LinkedList<Data> outputs = new LinkedList<>();
    // for storing state of algo node during processing all workflow
    private AlgorithmStateEnum state = AlgorithmStateEnum.NOT_PROCESSED;

    public AbstractNode getNode() {
        return node;
    }

    public void setNode(AbstractNode node) {
        this.node = node;
    }

    /**
     * get that value from annotation "Algorithm"
     * @return
     */
    public String getName() {
        Algorithm a = this.getClass().getAnnotation(Algorithm.class);
        return a.name();
    }

    /**
     * get that value from annotation "Algorithm"
     * @return
     */
    public String getDescription() {
        Algorithm a = this.getClass().getAnnotation(Algorithm.class);
        return a.description();
    }

    public abstract Boolean onProcess();

    public IParam getParam(Integer key) {
        return this.params.get(key);
    }

    public LinkedList<Param> getParams() {
        return this.params;
    }

    public Param addParam(Param value) {
//        value.setAlgorithm(this);
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

    public AlgorithmStateEnum getState() {
        return state;
    }

    public void setState(AlgorithmStateEnum state) {
        this.state = state;
    }

}
