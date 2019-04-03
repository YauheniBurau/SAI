package core.application.workflow.workflow;


import java.io.Serializable;

/**
 * Created by anonymous on 26.03.2019.
 */
public class Node<T extends IAlgorithm> extends AbstractNode<T> implements Serializable{

    public Node() {
        this.setName("undefined");
        this.setAlgorithm(null);
        this.setLayoutX(0);
        this.setLayoutY(0);
    }

    public Node(String name, T algorithm, double translateX, double translateY) {
        this.setName(name);
        this.setAlgorithm(algorithm);
        this.setLayoutX(translateX);
        this.setLayoutY(translateY);
    }

}
