package core.application.workflow.workflow;


import java.io.Serializable;

/**
 * Created by anonymous on 26.03.2019.
 */
public class Node<T extends AbstractAlgorithm> extends AbstractNode<T> implements Serializable{

    public Node(String name, T algorithm, double translateX, double translateY, double sizeX, double sizeY) {
        this.setName(name);
        this.setAlgorithm(algorithm);
        this.setLayoutX(translateX);
        this.setLayoutY(translateY);
        this.setSizeX(sizeX);
        this.setSizeY(sizeY);
    }

}
