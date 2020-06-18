package core.old.workflowModel;

import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IWorkflow {
    void addNode(Node e);
    void removeNode(Node e);

    LinkedList<Node> getNodes();

    double getSizeX();
    void setSizeX(double sizeX);
    double getSizeY();
    void setSizeY(double sizeY);
}
