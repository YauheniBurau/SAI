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
    private double sizeX;
    private double sizeY;


    public T getAlgorithm() {
        return this.algorithm;
    }

    public INode setAlgorithm(T algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public INode setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public double getLayoutX() {
        return this.translateX;
    }

    public INode setLayoutX(double value) {
        this.translateX = value;
        return this;
    }

    public double getLayoutY() {
        return this.translateY;
    }

    public INode setLayoutY(double value) {
        this.translateY = value;
        return this;
    }

    public double getSizeX() {
        return sizeX;
    }

    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }

    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }
}
