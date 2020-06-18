package core.old.workflowModel;

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

    ArrayList<IConnection<T>> getConnections();
    void addConnection(IConnection<T> connection);
    void removeConnection(IConnection<T> connection);
    void removeAllConnections();

    Class getDataFXClass();
    void setDataFXClass(Class dataFXClass);

    AbstractAlgorithm getAlgorithm();
    void setAlgorithm(AbstractAlgorithm algorithm);

}
