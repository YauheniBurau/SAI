package core.application.workflow.param;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IParam<T> {
    void setName(String value);
    String getName();

    void setValue(T value);
    T getValue();


}
