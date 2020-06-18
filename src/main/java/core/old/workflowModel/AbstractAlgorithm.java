package core.old.workflowModel;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public abstract class AbstractAlgorithm implements Serializable {
    private Node node;
    private transient AlgorithmStateEnum state = AlgorithmStateEnum.NOT_PROCESSED; // for storing state of algo node during processing all workflowModel

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

    public LinkedList<Param> getParams() {
        LinkedList<Param> params = new LinkedList<>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f: fields) {
            if(f.isAnnotationPresent(AlgoParam.class)){
                try {
                    f.setAccessible(true);
                    params.add((Param)f.get(this));
                    f.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return params;
    }

    public LinkedList<Data> getInputs() {
        LinkedList<Data> inputs = new LinkedList<>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f: fields) {
            if(f.isAnnotationPresent(AlgoDataIn.class)){
                try {
                    f.setAccessible(true);
                    inputs.add((Data)f.get(this));
                    f.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return inputs;
    }

    public LinkedList<Data> getOutputs() {
        LinkedList<Data> outputs = new LinkedList<>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f: fields) {
            if(f.isAnnotationPresent(AlgoDataOut.class)){
                try {
                    f.setAccessible(true);
                    outputs.add((Data)f.get(this));
                    f.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return outputs;
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
        for (Data output: this.getOutputs()) {
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
        for (Data input: this.getInputs()) {
            if(input.getState()!=AlgorithmStateEnum.SUCCESS){
                isReady = false;
                break;
            }
        }
        return isReady;
    }

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
