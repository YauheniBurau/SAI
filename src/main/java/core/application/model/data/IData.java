package core.application.model.data;

/**
 * Created by anonymous on 22.03.2019.
 */
public interface IData<T> {
    T getData();
    void setData(T data);
    String getType();
    void setType(String typeName);

}
