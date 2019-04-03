package core.application.workflow.workflow;

import java.util.ArrayList;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IData<T> {
    void setName(String value);
    String getName();

    void setValue(T value);
    T getValue();

    ArrayList<Data<T>> getOutputs();
    Data<T> getInput();
    void addOutput(Data dataIO);
    void setInput(Data dataIO);
    void removeInput();
    void removeOutput(Data dataIO);
    void removeOutputs();

//    void setId(int id);
//    int getId();
}
