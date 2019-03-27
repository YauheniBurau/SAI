package core.application.workflow.data;

/**
 * Created by anonymous on 26.03.2019.
 */
public class AbstractData <T> implements IData<T> {
    private String name;
    private T value;

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }

}
