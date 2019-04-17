package core.application.workflowModel;

import core.old.RunProcess;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public abstract class AbstractAlgorithm implements Serializable {
    private Node node;
    private LinkedList<Param> params = new LinkedList<>();
    private LinkedList<Data> inputs = new LinkedList<>();
    private LinkedList<Data> outputs = new LinkedList<>();
    private AlgorithmStateEnum state = AlgorithmStateEnum.NOT_PROCESSED; // for storing state of algo node during processing all workflowModel

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

    /**
     * returb state of algo
     * @return
     */
    public AlgorithmStateEnum getState() {
        return state;
    }

    /**
     * set state to algo node and for every output
     * @param state
     */
    public void setState(AlgorithmStateEnum state) {
        this.state = state;
        for (Data output: this.outputs) {
            output.setState(state);
        }
    }

    /**
     * must be overriden, and have to contain main logic of processing inputs and what to send to outputs
     * @return
     */
    public abstract Boolean onProcess();

    /**
     * check all inputs, and if at least one of them not has status "SUCCESS" - then result - false, algo is not ready
     * @return
     */
    public boolean isReadyToProcess(){
        boolean isReady = true;
        for (Data input: this.inputs) {
            if(input.getState()!=AlgorithmStateEnum.SUCCESS){
                isReady = false;
                break;
            }
        }
        return isReady;
    }

    // TODO: remove or refactor
//    public void signalCountPrevious(){
//        for (Data input: this.inputs) {
//            if(input.getState()!=AlgorithmStateEnum.SUCCESS){
//                new RunProcess(input.getConnection(0).getStart().getAlgorithm()).run();
//            }
//        }
//    }
//
//    public void signalCountNext(){
//        for (Data output: this.outputs) {
//            ArrayList<IConnection> conns = output.getConnections();//. e.getEnd().getAlgorithm().runProcess();
//            for (int i = 0; i < conns.size() ; i++) {
//                new RunProcess(conns.get(i).getStart().getAlgorithm()).run();
//            }
//        }
//    }
//
//    public void runProcess(){
//        boolean result;
//        if( isReadyToProcess() == true ){
//            result = this.onProcess();
//            if(result == true){ // send to outputs signal that node is processed
//                this.setState(AlgorithmStateEnum.SUCCESS);
//                signalCountNext();
//            }
//        }else{ // send signals to all inputs connected nodes
//            signalCountPrevious();
//        }
//    }

}
