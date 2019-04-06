package core.application.workflow.workflow;

import java.util.LinkedList;

/**
 * Created by anonymous on 13.10.2018.
 */
public interface IAlgorithm {
    String getName();
    void setName(String name);
    Boolean onProcess();
    IParam getParam(Integer key);
    LinkedList<Param> getParams();
    Param addParam(Param value);
    IData getInput(Integer key);
    LinkedList<Data> getInputs();
    Data addInput(Data value);
    IData getOutput(Integer key);
    LinkedList<Data> getOutputs();
    Data addOutput(Data value);
    AlgorithmStateEnum getState();
    void setState(AlgorithmStateEnum state);
}