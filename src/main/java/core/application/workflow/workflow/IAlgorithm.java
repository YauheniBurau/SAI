package core.application.workflow.workflow;

import java.util.LinkedList;

/**
 * Created by anonymous on 13.10.2018.
 */
public interface IAlgorithm {
    String getName();
    void setName(String name);
    Boolean process();
    IParam getParam(Integer key);
    LinkedList<Param> getParams();
    void addParam(Param value);
    IData getInput(Integer key);
    LinkedList<Data> getInputs();
    void addInput(Data value);
    IData getOutput(Integer key);
    LinkedList<Data> getOutputs();
    void addOutput(Data value);


}