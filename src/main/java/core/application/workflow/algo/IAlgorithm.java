package core.application.workflow.algo;

import core.application.workflow.data.AbstractData;
import core.application.workflow.data.IData;
import core.application.workflow.param.IParam;

import java.util.LinkedList;

/**
 * Created by anonymous on 13.10.2018.
 */
public interface IAlgorithm {
    String getName();
    void setName(String name);
    Boolean process();
    IParam getParam(Integer key);
    LinkedList<IParam> getParams();
    void addParam(IParam value);
    IData getInput(Integer key);
    LinkedList<AbstractData> getInputs();
    void addInput(AbstractData value);
    IData getOutput(Integer key);
    LinkedList<AbstractData> getOutputs();
    void addOutput(AbstractData value);


}