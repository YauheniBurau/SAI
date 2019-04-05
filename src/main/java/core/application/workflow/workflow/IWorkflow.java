package core.application.workflow.workflow;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IWorkflow {
    void addNode(Node e);
    void deleteNode(Node e);

    void addConnection(Connection e);
    void deleteConnection(Connection e);

    LinkedList<Node> getNodes();
    LinkedList<Connection> getConnections();
    void deleteConnections(ArrayList<Connection> list);
    ArrayList<Connection> findConnections(Data dataIO);

    double getSizeX();
    void setSizeX(double sizeX);
    double getSizeY();
    void setSizeY(double sizeY);

    void unprocess();
    void process();

}
