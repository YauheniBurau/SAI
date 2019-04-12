package core.application.workflowModel;

import java.io.*;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by anonymous on 26.03.2019.
 */
public class Workflow implements IWorkflow, Serializable {
    private transient Logger logger;
    private LinkedList<Node> nodes = new LinkedList<>();
    private double sizeX = 1;
    private double sizeY = 1;

    public Workflow(double sizeX, double sizeY){
        this.logger = Logger.getLogger(this.getClass().toString());
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void addNode(Node e) {
        e.setWorkflow(this);
        this.nodes.add(e);
    }

    public void removeNode(Node value) {
        // delete algo dataIO links to inputs and outputs
        LinkedList<Data> inputs = value.getAlgorithm().getInputs();
        for(Data input: inputs) { input.removeConnections(); }
        LinkedList<Data> outputs = value.getAlgorithm().getOutputs();
        for(Data output: outputs) { output.removeConnections(); }
        // delete node from workflowModel
        this.nodes.remove(value);
    }

    public LinkedList<Node> getNodes() {
        return nodes;
    }

    public double getSizeX() {
        return sizeX;
    }

    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }

    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

}
