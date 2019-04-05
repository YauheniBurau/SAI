package core.application.workflow.workflow;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public class Workflow implements IWorkflow, Serializable {
    private LinkedList<Node> nodes = new LinkedList<>();
    private LinkedList<Connection> connections = new LinkedList<>();
    private double sizeX = 0;
    private double sizeY = 0;

    public Workflow(double sizeX, double sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void addNode(Node e) {
        this.nodes.add(e);
    }

    public void deleteNode(Node value) {
        // delete algo data links to inputs and outputs
        // delete connection from workflow
        LinkedList<Data> inputs = value.getAlgorithm().getInputs();
        for(Data input: inputs) {
            this.deleteConnections( this.findConnections(input) );
        }
        LinkedList<Data> outputs = value.getAlgorithm().getOutputs();
        for(Data output: outputs) {
            this.deleteConnections( this.findConnections(output) );
        }
        // delete node from workflow
        this.nodes.remove(value);

    }

    public void addConnection(Connection e) {
        this.connections.add(e);
    }

    public void deleteConnection(Connection e) {
        // delete data links to inputs and outputs from Algorithm
        if(e!=null) {
            e.getStart().removeOutputs();
            e.getEnd().removeInput();
            // delete connection from workflow
            this.connections.remove(e);
        }
    }

    public void deleteConnections(ArrayList<Connection> list) {
        while(list.size()>0){
            this.deleteConnection(list.get(0));
            list.remove(0);
        }
    }

    public ArrayList<Connection> findConnections(Data dataIO){
        ArrayList<Connection> conns = new ArrayList<>();
        for (Connection conn: this.connections){
            if(conn.getStart()==dataIO || conn.getEnd()==dataIO ){
                conns.add(conn);
            }
        }
        return conns;
    }

    public LinkedList<Node> getNodes() {
        return nodes;
    }

    public LinkedList<Connection> getConnections() {
        return connections;
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


    public void unprocess(){
        // TODO:
    }

    public void process(){
        // TODO:
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
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return workflow;
    }

}
