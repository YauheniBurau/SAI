package core.application.workflow.workflow;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface INode<T extends AbstractAlgorithm> {
    AbstractNode setName(String name);
    String getName();
    T getAlgorithm();
    AbstractNode setAlgorithm(T algorithm);
    double getLayoutX();
    AbstractNode setLayoutX(double value);
    double getLayoutY();
    AbstractNode setLayoutY(double value);

    double getSizeX();
    AbstractNode setSizeX(double sizeX);
    double getSizeY();
    AbstractNode setSizeY(double sizeY);
}
