package core.application.workflow.workflow;

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
        // delete node from workflow
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

    /**
     * serialize and save workflow object to File
     * @param file
     * @param workflow
     */
    public static void save(File file, Workflow workflow){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(workflow);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * load file and deserialize to workflow object
     * @param file
     */
    public static Workflow load(File file){
        Workflow workflow = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            workflow = (Workflow) objectInputStream.readObject();
            workflow.setLogger(Logger.getLogger(workflow.getClass().toString()) );
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return workflow;
    }

}
