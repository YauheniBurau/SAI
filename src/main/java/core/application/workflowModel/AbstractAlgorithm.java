package core.application.workflowModel;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public abstract class AbstractAlgorithm implements Serializable {
    private Node node;
    private LinkedList<Param> params = new LinkedList<>();
    private LinkedList<Data> inputs = new LinkedList<>();
    private LinkedList<Data> outputs = new LinkedList<>();
    // for storing state of algo node during processing all workflowModel
    private AlgorithmStateEnum state = AlgorithmStateEnum.NOT_PROCESSED;

    /**
     * get that "description" value from annotation @Algo
     * @return
     */
    public String getName() {
        Algo a = this.getClass().getAnnotation(Algo.class);
        return a.name();
    }

    /**
     * get that "description" value from annotation @Algo
     * @return
     */
    public String getDescription() {
        Algo a = this.getClass().getAnnotation(Algo.class);
        return a.description();
    }

    /**
     * get that "group" value from annotation @Algo
     * @return
     */
    public String getGroup() {
        Algo a = this.getClass().getAnnotation(Algo.class);
        return a.group();
    }


    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

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

    public abstract Boolean onProcess();

}
