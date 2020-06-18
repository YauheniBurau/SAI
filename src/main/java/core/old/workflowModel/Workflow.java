package core.old.workflowModel;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by anonymous on 26.03.2019.
 */
public class Workflow implements IWorkflow, Serializable {
    private transient Logger logger;
    private LinkedList<Node> nodes = new LinkedList<>();
    private LinkedList<IConnection> connections = new LinkedList<>();
    private double sizeX = 1;
    private double sizeY = 1;

    public Workflow(double sizeX, double sizeY){
        this.logger = Logger.getLogger(this.getClass().toString());
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    /**
     * add node to workflow model
     * @param e
     */
    public void addNode(Node e) {
        e.setWorkflow(this);
        this.nodes.add(e);
    }

    /**
     * get list of all nodes from workflow model
     * @return
     */
    public LinkedList<Node> getNodes() {
        return nodes;
    }

    /**
     * remove node and all node connection from workflow model
     * @param node
     */
    public void removeNode(Node node) {
        // delete algo dataIO links to inputs and outputs
        LinkedList<Data> inputs = node.getAlgorithm().getInputs();
        ArrayList<IConnection> cons;
        for(Data input: inputs) {
            cons = input.getConnections();
            for(IConnection con: cons) {
                this.removeConnection(con);
            }
        }
        LinkedList<Data> outputs = node.getAlgorithm().getOutputs();
        for(Data output: outputs) {
            cons = output.getConnections();
            for(IConnection con: cons) {
                this.removeConnection(con);
            }
        }
        // delete node from workflowModel
        this.nodes.remove(node);
    }

    /**
     * add connection into workflow model
     * @param connection
     */
    public void addConnection(IConnection connection){
        this.connections.add(connection);
        connection.getStart().addConnection(connection);
        connection.getEnd().addConnection(connection);
    }

    /**
     * get list of all connection from workflow model
     * @return
     */
    public LinkedList<IConnection> getConnections() { // TODO: replace linkedList to ArrayList
        return connections;
    }

    /**
     * remove node connection from workflow model
     * @param connection
     */
    public void removeConnection(IConnection connection) {
        this.connections.remove(connection);
        connection.getStart().removeConnection(connection);
        connection.getEnd().removeConnection(connection);
    }

    /**
     * get sizeX of workflow canvas model
     */
    public double getSizeX() {
        return sizeX;
    }

    /**
     * set sizeX of workflow canvas model
     * @param sizeX
     */
    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }

    /**
     * get sizeY of workflow canvas model
     */
    public double getSizeY() {
        return sizeY;
    }

    /**
     * set sizeY of workflow canvas model
     * @param sizeY
     */
    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }

    /**
     * get Logger
     * @return
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * setLogger
     * @param logger
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

}
