package core.application.workflow.data;

import java.util.ArrayList;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IData<T> {
    void setName(String value);
    String getName();

    void setValue(T value);
    T getValue();

    ArrayList<AbstractData<T>> getOutputs();
    AbstractData<T> getInput();
    void addOutput(AbstractData dataIO);
    void setInput(AbstractData dataIO);
    void removeInput();
    void removeOutput(AbstractData dataIO);
    void removeOutputs();
}
