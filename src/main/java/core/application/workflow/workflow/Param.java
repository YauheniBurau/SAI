package core.application.workflow.workflow;

import java.io.Serializable;

/**
 * Created by anonymous on 26.03.2019.
 */
public class Param<T> implements IParam<T>, Serializable {
    private AbstractAlgorithm algorithm;
    private String name;
    private T value;
    private Class paramFXClass;

    public Param(String name, T value, Class paramFXClass) {
        this.name = name;
        this.value = value;
        this.paramFXClass = paramFXClass;
    }


    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public Class getParamFXClass() {
        return this.paramFXClass;
    }

    public void setParamFXClass(Class paramFXClass) {
        this.paramFXClass = paramFXClass;
    }

    public void setAlgorithm(AbstractAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public AbstractAlgorithm getAlgorithm() {
        return algorithm;
    }

}
