package core.application.workflow.workflow;

import java.util.ArrayList;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IData<T> {
    Class getClassValue();
    void setClassValue(Class classValue);

    void setName(String value);
    String getName();

    void setValue(T value);
    T getValue();

    ArrayList<Data<T>> getOutputs();
    Data<T> getInput();
    void addOutput(Data<T> dataIO);
    void setInput(Data<T> dataIO);
    void removeInput();
    void removeOutput(Data dataIO);
    void removeOutputs();

    Class getDataFXClass();
    void setDataFXClass(Class dataFXClass);

    AbstractAlgorithm getAlgorithm();

}
