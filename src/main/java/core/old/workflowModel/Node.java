package core.old.workflowModel;

import java.io.Serializable;

/**
 * Created by anonymous on 26.03.2019.
 */
public class Node<T extends AbstractAlgorithm> implements Serializable{
    private Workflow workflow;
    private String name;
    private T algorithm;
    private double translateX;
    private double translateY;
    private double sizeX;
    private double sizeY;

    public Node(String name, T algorithm, double translateX, double translateY, double sizeX, double sizeY) {
        this.setName(name)
                .setAlgorithm(algorithm)
                .setLayoutX(translateX)
                .setLayoutY(translateY)
                .setSizeX(sizeX)
                .setSizeY(sizeY);
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    public T getAlgorithm() {
        return this.algorithm;
    }

    public Node setAlgorithm(T algorithm) {
        algorithm.setNode(this);
        this.algorithm = algorithm;
        return this;
    }

    public Node setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public double getLayoutX() {
        return this.translateX;
    }

    public Node setLayoutX(double value) {
        this.translateX = value;
        return this;
    }

    public double getLayoutY() {
        return this.translateY;
    }

    public Node setLayoutY(double value) {
        this.translateY = value;
        return this;
    }

    public double getSizeX() {
        return sizeX;
    }

    public Node setSizeX(double sizeX) {
        this.sizeX = sizeX;
        return this;
    }

    public double getSizeY() {
        return sizeY;
    }

    public Node setSizeY(double sizeY) {
        this.sizeY = sizeY;
        return this;
    }
}
