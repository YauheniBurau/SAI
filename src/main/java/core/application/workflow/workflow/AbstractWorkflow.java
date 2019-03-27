package core.application.workflow.workflow;

import core.application.workflow.connection.Connection;
import core.application.workflow.node.Node;

import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public class AbstractWorkflow implements IWorkflow {
    private LinkedList<Node> nodes = new LinkedList<>();
    private LinkedList<Connection> connections = new LinkedList<>();

    public AbstractWorkflow(){
        
    }

    public AbstractWorkflow(LinkedList<Node> nodes, LinkedList<Connection> connections) {
        this.nodes = nodes;
        this.connections = connections;
    }

    @Override
    public void addNode(Node e) {
        this.nodes.add(e);
    }

    @Override
    public void deleteNode(Node value) {
        this.nodes.remove(value);

    }

    @Override
    public void addConnection(Connection e) {
        this.connections.add(e);
    }

    @Override
    public void deleteConnection(Connection e) {
        this.connections.remove(e);
    }

    @Override
    public LinkedList<Node> getNodes() {
        return nodes;
    }

    @Override
    public LinkedList<Connection> getConnections() {
        return connections;
    }
}
