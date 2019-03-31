package core.application.workflow.workflow;

import core.application.workflow.connection.Connection;
import core.application.workflow.data.AbstractData;
import core.application.workflow.node.Node;

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
    ArrayList<Connection> findConnections(AbstractData dataIO);

}
