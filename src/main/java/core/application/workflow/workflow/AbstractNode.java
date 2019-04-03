package core.application.workflow.workflow;

import java.io.Serializable;

/**
 * Created by anonymous on 26.03.2019.
 */
public abstract class AbstractNode<T extends IAlgorithm> implements INode<T>, Serializable{
    private String name;
    private T algorithm;
    private double translateX;
    private double translateY;

    @Override
    public T getAlgorithm() {
        return this.algorithm;
    }

    @Override
    public INode setAlgorithm(T algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    @Override
    public INode setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getLayoutX() {
        return this.translateX;
    }

    @Override
    public INode setLayoutX(double value) {
        this.translateX = value;
        return this;
    }

    @Override
    public double getLayoutY() {
        return this.translateY;
    }

    @Override
    public INode setLayoutY(double value) {
        this.translateY = value;
        return this;
    }

}
