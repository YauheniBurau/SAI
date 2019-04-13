package core.application.workflowModel;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IParam<T> {
    void setName(String value);
    String getName();

    void setValue(T value);
    T getValue();

    Class getParamFXClass();
    void setParamFXClass(Class paramFXClass);

//    void setAlgorithm(AbstractAlgorithm algorithm);
//    AbstractAlgorithm getAlgorithm();
}
