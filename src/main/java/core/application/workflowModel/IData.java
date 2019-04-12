package core.application.workflowModel;

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

    ArrayList<Data<T>> getConnections();
    void addConnection(Data<T> dataIO);
    void removeConnection(Data<T> dataIO);
    void removeConnections();

    Class getDataFXClass();
    void setDataFXClass(Class dataFXClass);

    AbstractAlgorithm getAlgorithm();
    void setAlgorithm(AbstractAlgorithm algorithm);
}
