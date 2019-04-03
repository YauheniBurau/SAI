package core.application.workflow.workflow;

import java.io.Serializable;

/**
 * Created by anonymous on 26.03.2019.
 */
public class Param<T> implements IParam<T>, Serializable {
    private String name;
    private T value;

    public Param(String name, T value) {
        this.name = name;
        this.value = value;
    }

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
