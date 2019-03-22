package core.application.model.data;

/**
 * Base cluster of model data that is used for exchange between components of MODEL and GUI
 * Created by anonymous on 22.03.2019.
 */
public class Data<T> implements IData<T> {
    private String typeName = "undef";
    private T data = null;

    public Data(String typeName, T data) {
        this.typeName = typeName;
        this.data = data;
    }

    @Override
    public String getType() {
        return this.typeName;
    }

    @Override
    public void setType(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

}
