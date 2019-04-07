package core.application.workflow.workflow;

import java.io.Serializable;

/**
 * Created by anonymous on 26.03.2019.
 */
public abstract class AbstractNode<T extends AbstractAlgorithm> implements INode<T>, Serializable{
    private String name;
    private Workflow workflow;
    private T algorithm;
    private double translateX;
    private double translateY;
    private double sizeX;
    private double sizeY;

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    public T getAlgorithm() {
        return this.algorithm;
    }

    public AbstractNode setAlgorithm(T algorithm) {
        algorithm.setNode(this);
        this.algorithm = algorithm;
        return this;
    }

    public AbstractNode setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public double getLayoutX() {
        return this.translateX;
    }

    public AbstractNode setLayoutX(double value) {
        this.translateX = value;
        return this;
    }

    public double getLayoutY() {
        return this.translateY;
    }

    public AbstractNode setLayoutY(double value) {
        this.translateY = value;
        return this;
    }

    public double getSizeX() {
        return sizeX;
    }

    public AbstractNode setSizeX(double sizeX) {
        this.sizeX = sizeX;
        return this;
    }

    public double getSizeY() {
        return sizeY;
    }

    public AbstractNode setSizeY(double sizeY) {
        this.sizeY = sizeY;
        return this;
    }
}
