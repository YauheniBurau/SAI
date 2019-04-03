package core.application.workflow.workflow;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface INode<T extends IAlgorithm> {
    INode setName(String name);
    String getName();
    T getAlgorithm();
    INode setAlgorithm(T algorithm);
    double getLayoutX();
    INode setLayoutX(double value);
    double getLayoutY();
    INode setLayoutY(double value);

}
