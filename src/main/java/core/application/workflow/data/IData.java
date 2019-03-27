package core.application.workflow.data;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IData<T> {
    void setName(String value);
    String getName();

    void setValue(T value);
    T getValue();

}
